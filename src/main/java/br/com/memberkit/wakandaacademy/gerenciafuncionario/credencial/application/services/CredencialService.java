package br.com.memberkit.wakandaacademy.gerenciafuncionario.credencial.application.services;

import br.com.memberkit.wakandaacademy.gerenciafuncionario.credencial.domain.Credencial;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.application.API.FuncionarioRequest;
import jakarta.validation.Valid;

public interface CredencialService {
    void createNewCredencial(@Valid FuncionarioRequest funcionarioRequest);
    Credencial searchCredentialToUser(String user);
}
