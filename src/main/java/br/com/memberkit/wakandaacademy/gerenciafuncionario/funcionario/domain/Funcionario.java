package br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.domain;

import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.application.API.FuncionarioRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Document(collection = "Funcionario")

public class Funcionario {

    @Id
    private UUID idFuncionario;
    @NotBlank
    @Size(message = "Campo nome do funcionario não pode estar vazio", max = 255, min = 3)
    private String nome;
    private String Designacao;
    private String telefone;
    @NotBlank
    @Size(message = "Campo endereco do funcionario não pode estar vazio", max = 255, min = 3)
    private Endereco endereco;

    public Funcionario(FuncionarioRequest funcionarioRequest) {
        this.idFuncionario = UUID.randomUUID();
        this.nome = funcionarioRequest.getNome();
        Designacao = funcionarioRequest.getDesignacao();
        this.telefone = funcionarioRequest.getTelefone();
        this.endereco = funcionarioRequest.getEndereco();
    }
}
