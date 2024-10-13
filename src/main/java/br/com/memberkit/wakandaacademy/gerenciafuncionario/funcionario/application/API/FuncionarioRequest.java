package br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.application.API;

import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.domain.Endereco;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.domain.StatusFuncionario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Value;

@Value
public class FuncionarioRequest {

    private String nome;
    private StatusFuncionario statusFuncionario;
    private String designacao;
    private String telefone;

    private Endereco endereco;
}
