package br.com.memberkit.wakandaacademy.gerenciafuncionario.autenticacao.application.api;

import br.com.memberkit.wakandaacademy.gerenciafuncionario.autenticacao.domain.Token;
import lombok.Value;

@Value
public class TokenResponse {
    private String token;
    private String tipo;

    public TokenResponse(Token token) {
        this.token = token.getToken();
        this.tipo = token.getTipo();
    }
}
