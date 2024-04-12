package br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.application.repository;

import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.application.API.FuncionarioResponse;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.domain.Funcionario;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FuncionarioRepository {
    Funcionario salva(Funcionario funcionario);

    Optional<Funcionario> buscaFuncionarioPorId(UUID id);

    List<Funcionario> buscaFuncionario();

    void atualizaFuncionario(UUID idFuncionario,FuncionarioResponse funcionario);

    void deletaFuncionario(UUID idFuncionario);
}
