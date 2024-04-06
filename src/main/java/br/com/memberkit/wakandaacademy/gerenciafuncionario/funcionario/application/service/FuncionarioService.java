package br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.application.service;

import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.application.API.FuncionarioRequest;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.application.API.FuncionarioResponse;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.domain.Funcionario;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FuncionarioService {
    Funcionario criaNovoFuncionario(FuncionarioRequest funcionarioRequest);

    Optional<Funcionario> buscaFuncionarioPorId(UUID id, Funcionario funcionario);

    List<Funcionario> buscaFuncionario(Funcionario funcionario);
}
