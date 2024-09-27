package br.com.memberkit.wakandaacademy.gerenciafuncionario.config.security.domain;

import java.util.function.Predicate;

public class ValidaConteudoAuthorizationHeader implements Predicate<String> {
    @Override
    public boolean test(String conteudoAuthorizationHeader) {
        return !conteudoAuthorizationHeader.isEmpty() && conteudoAuthorizationHeader.startsWith("Bearer");
    }
}
