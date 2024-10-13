package br.com.memberkit.wakandaacademy.gerenciafuncionario.usuario.application.service;

import br.com.memberkit.wakandaacademy.gerenciafuncionario.autenticacao.application.api.UsersRequest;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.usuario.application.repository.UsersRepository;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.usuario.domain.Users;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserApplicationService implements UserService{

    private final UsersRepository userRepository;
    @Override
    public void criaUsuario(Users users) {
        log.info("[inicia] UserApplicationService - criaUsuario ");
        userRepository.salva(users);
        log.info("[finaliza] UserApplicationService - criaUsuario ");

    }

    @Override
    public UserDetails findByLogin(String login) {
        log.info("[inicia] UserApplicationService - findByLogin ");
        var usuario = userRepository.findByLogin(login);
        log.info("[finaliza] UserApplicationService - findByLogin ");
        return usuario;
    }
}
