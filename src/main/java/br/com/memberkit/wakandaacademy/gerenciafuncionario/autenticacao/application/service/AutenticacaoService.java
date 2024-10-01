package br.com.memberkit.wakandaacademy.gerenciafuncionario.autenticacao.application.service;


import br.com.memberkit.wakandaacademy.gerenciafuncionario.autenticacao.domain.Token;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public interface AutenticacaoService {
    public Token autentica(UsernamePasswordAuthenticationToken userCredentals);
    public Token reativaToken(String TokenExpirado);
}
