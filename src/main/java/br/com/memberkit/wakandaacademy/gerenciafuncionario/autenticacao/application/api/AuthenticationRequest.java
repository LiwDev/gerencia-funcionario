package br.com.memberkit.wakandaacademy.gerenciafuncionario.autenticacao.application.api;

import jakarta.validation.constraints.Size;
import lombok.Value;

@Value
public class AuthenticationRequest {
    private String login;

    private String senha;
}
