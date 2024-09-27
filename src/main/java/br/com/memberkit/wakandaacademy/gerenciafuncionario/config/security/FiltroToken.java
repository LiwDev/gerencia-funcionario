package br.com.memberkit.wakandaacademy.gerenciafuncionario.config.security;

import br.com.memberkit.wakandaacademy.gerenciafuncionario.config.security.domain.ValidaConteudoAuthorizationHeader;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.config.security.service.TokenService;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.credencial.application.services.CredencialService;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.credencial.domain.Credencial;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.handler.ApiException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Log4j2
@RequiredArgsConstructor
public class FiltroToken extends OncePerRequestFilter {
    private final TokenService tokenService;
    private final CredencialService credencialService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
      log.info("[Inicio] FiltroToken - doFilterInternal");
        String token = recuperaToken(request);
        autenticaCliente(token);
      log.info("[finaliza] FiltroToken - doFilterInternal");
      filterChain.doFilter(request,response);

    }

    private void autenticaCliente(String token) {
        log.info("[Inicio] FiltroToken - autenticaCliente");
        Credencial credencial = recuperaUsuario(token);
        var authenticationToken = new UsernamePasswordAuthenticationToken(credencial,null,credencial.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        log.info("[Finaliza] FiltroToken - autenticaCliente");
    }

    private Credencial recuperaUsuario(String token) {
        var usuario = tokenService.getUsuario(token).orElseThrow(()->ApiException.build(HttpStatus.FORBIDDEN,
                "Token enviado esta invalido . Tente novamente"));
        return credencialService.searchCredentialToUser(usuario);

    }

    private String recuperaToken(HttpServletRequest request) {
        log.info("[Inicio] FiltroToken - recuperaToken");
        var authorizationHeaderValueOpt = Optional.ofNullable(recuperaValorAuthorizationValue(request));
        String authorizationHeaderValue = authorizationHeaderValueOpt.filter(new ValidaConteudoAuthorizationHeader()).orElseThrow(()-> ApiException.build(HttpStatus.UNAUTHORIZED,"Token enviado esta invalido . Tente novamente"));
        log.info("[Finaliza] FiltroToken - recuperaToken");
        return authorizationHeaderValue.substring(7,authorizationHeaderValue.length());

    }

    private String recuperaValorAuthorizationValue(HttpServletRequest request) {
    return Optional.ofNullable(request.getHeader("Authorization")).orElseThrow(()->ApiException.build(HttpStatus.FORBIDDEN,"Token não esta presente na requisição"));

    }
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String path = request.getRequestURI();
        return path.contains("/public/")||path.contains("/swagger-ui/");
    }


}
