package br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.application.API;

import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.domain.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.util.UUID;
@Value
public class FuncionarioRequest {
    @NotBlank
    @Size(message = "Campo nome do funcionario não pode estar vazio", max = 255, min = 3)
    private String nome;
    private String Designacao;
    private String telefone;

    private Endereco endereco;
}
