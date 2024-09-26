package br.com.memberkit.wakandaacademy.gerenciafuncionario.credencial.application.services;

import br.com.memberkit.wakandaacademy.gerenciafuncionario.credencial.application.repository.CredencialRepository;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.credencial.domain.Credencial;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.application.API.FuncionarioRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class CredencialApplicationService implements  CredencialService{
    private final CredencialRepository credencialRepository;
    @Override
    public void createNewCredencial(@Valid FuncionarioRequest funcionarioRequest) {
log.info("[Inicia] - CredencialApplicationService - createNewCredencial");
        var novaCredencial = new Credencial(funcionarioRequest.getEmail(), funcionarioRequest.getSenha());
        credencialRepository.salvaCredencial(novaCredencial);
        log.info("[Finaliza] - CredencialApplicationService - createNewCredencial");
    }

    @Override
    public Credencial searchCredentialToUser(String user) {
        log.info("[Inicia] - CredencialApplicationService - searchCredentialToUser");
        Credencial credencial = credencialRepository.buscaCredencialPorUsuario(user);
        log.info("[finaliza] - CredencialApplicationService - searchCredentialToUser");
        return credencial;
    }
}
