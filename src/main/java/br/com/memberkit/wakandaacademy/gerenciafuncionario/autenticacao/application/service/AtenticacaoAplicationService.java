package br.com.memberkit.wakandaacademy.gerenciafuncionario.autenticacao.application.service;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.autenticacao.domain.Token;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.config.security.service.TokenService;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.credencial.application.services.CredencialService;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.credencial.domain.Credencial;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.handler.ApiException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class AtenticacaoAplicationService implements  AutenticacaoService{
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final CredencialService credencialService;
    @Override
    public Token autentica(UsernamePasswordAuthenticationToken userCredentials) {
        log.info("[inicia] AtenticacaoAplicationService - autentica ");
        var authentication = authenticationManager.authenticate(userCredentials);
        Token token = Token.builder().tipo("bearer").token(tokenService.gerarToken(authentication)).build();
        log.info("[finaliza] AtenticacaoAplicationService - autentica ");
        return  token;
    }

    @Override
    public Token reativaToken(String tokenExpirado) {
        log.info("[inicia] AtenticacaoAplicationService - reativaToken ");
var usuario = extraiUsuario(tokenExpirado);
        Credencial credencial = credencialService.searchCredentialToUser(usuario);
        log.info("[finaliza] AtenticacaoAplicationService - reativaToken ");
        return Token.builder().tipo("bearer").token(tokenService.gerarToken(credencial)).build();
    }

    private String extraiUsuario(String tokenExpirado){
        return tokenService.getUsuario(tokenExpirado).orElseThrow(()-> ApiException.build(HttpStatus.BAD_REQUEST,"Token invalido"));
    }
}
