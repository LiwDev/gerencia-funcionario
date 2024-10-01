package br.com.memberkit.wakandaacademy.gerenciafuncionario.autenticacao.application.api;

import br.com.memberkit.wakandaacademy.gerenciafuncionario.autenticacao.application.service.AutenticacaoService;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.config.security.domain.ValidaConteudoAuthorizationHeader;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.handler.ApiException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;
import java.util.Optional;

@Log4j2
@RestController
@RequiredArgsConstructor
public class AutenticacaoRestController implements AutenticacaoAPI{
    private final AutenticacaoService autenticacaoService;
    @Override
    public TokenResponse autentica(AutenticacaoRequest autenticacaoRequest) throws AuthenticationException {
        log.info("[inicio] AutenticacaoRestController - autentica");

        var token = autenticacaoService.autentica(autenticacaoRequest.getUserPassToken());
        log.info("[finaliza] AutenticacaoRestController - autentica");
        return new TokenResponse(token);
    }

    @Override
    public TokenResponse reativaAutenticacao(String tokenExpirado) throws AuthenticationException {
        log.info("[inicio] AutenticacaoRestController - reativaAutenticacao");
        String tokenExpiradoValido = validaTokenExpirado(Optional.of(tokenExpirado));
        var token = autenticacaoService.reativaToken(tokenExpiradoValido);
        log.info("[finaliza] AutenticacaoRestController - reativaAutenticacao");
        return new TokenResponse(token);
    }

    private String validaTokenExpirado(Optional<String> tokenExpirado) {
        log.info("[inicio] AutenticacaoRestController - validaTokenExpirado");
        String tokenExp = tokenExpirado.filter(new ValidaConteudoAuthorizationHeader()).orElseThrow(()-> ApiException.build(HttpStatus.BAD_REQUEST,"Token Invalido!"));
        log.info("[finaliza] AutenticacaoRestController - validaTokenExpirado");
        return tokenExp.substring(7,tokenExp.length());
    }
}
