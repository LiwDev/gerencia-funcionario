package br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.application.service;

import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.application.API.FuncionarioRequest;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.domain.Funcionario;

public interface FuncionarioService {
    Funcionario criaNovoFuncionario(FuncionarioRequest funcionarioRequest);
}
