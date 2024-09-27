package br.com.memberkit.wakandaacademy.gerenciafuncionario.config.security.service;


import br.com.memberkit.wakandaacademy.gerenciafuncionario.credencial.application.repository.CredencialRepository;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.handler.ApiException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Log4j2
@RequiredArgsConstructor
@Service
public class AutenticacaoSecurityService implements UserDetailsService {
    private final CredencialRepository credencialRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    log.info("[Inicio] AutenticacaoSecurityService - loadUserByUsername");
    var credencial = credencialRepository.searchCredentialToUser(username);
    log.info("[Finaliza] AutenticacaoSecurityService - loadUserByUsername");


        return Optional.ofNullable(credencial).orElseThrow(()-> ApiException.build(HttpStatus.NOT_FOUND,"Não existe credencial para o Usuario informado!"));
    }
}
