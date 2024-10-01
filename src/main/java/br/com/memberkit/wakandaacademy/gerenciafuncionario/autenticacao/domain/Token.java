package br.com.memberkit.wakandaacademy.gerenciafuncionario.autenticacao.domain;

import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Token {
    private String token;
    private  String tipo;
}
