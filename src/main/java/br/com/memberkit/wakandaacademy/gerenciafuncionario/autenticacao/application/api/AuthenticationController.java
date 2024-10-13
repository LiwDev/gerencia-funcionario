package br.com.memberkit.wakandaacademy.gerenciafuncionario.autenticacao.application.api;

import br.com.memberkit.wakandaacademy.gerenciafuncionario.usuario.application.service.UserService;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.usuario.domain.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController implements AuthenticationApi{
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    @Override
    public ResponseEntity login(AuthenticationRequest authenticationRequest) {
        var login = new UsernamePasswordAuthenticationToken(authenticationRequest.getLogin(),authenticationRequest.getSenha());
        var auth = authenticationManager.authenticate(login);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity register(UsersRequest usersRequest) {
        if (userService.findByLogin(usersRequest.getLogin())!=null) return ResponseEntity.badRequest().build();
        else {
            var encriptsenha = new BCryptPasswordEncoder().encode(usersRequest.getSenha());
            Users users = new Users(usersRequest.getLogin(),encriptsenha,usersRequest.getRole());
        userService.criaUsuario(users);
        }
        return null;
    }



}
