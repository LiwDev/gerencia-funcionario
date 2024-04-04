package br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.application.repository;

import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.domain.Funcionario;

public interface FuncionarioRepository {
    Funcionario salva(Funcionario funcionario);
}
