package br.com.memberkit.wakandaacademy.gerenciafuncionario.autenticacao.application.api;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/auth")
public interface AuthenticationApi {

    @PostMapping("login")
    ResponseEntity login(@RequestBody @Valid AuthenticationRequest authenticationRequest);

    @PostMapping("register")
    ResponseEntity register(@RequestBody @Valid UsersRequest usersRequest );

}
