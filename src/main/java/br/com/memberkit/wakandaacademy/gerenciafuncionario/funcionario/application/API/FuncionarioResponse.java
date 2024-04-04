package br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.application.API;

import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.domain.Endereco;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.domain.Funcionario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Value
public class FuncionarioResponse {

    private UUID idFuncionario;

    private String nome;
    private String Designacao;
    private String telefone;

    private Endereco endereco;

    public FuncionarioResponse(Funcionario funcionario) {
        this.idFuncionario = funcionario.getIdFuncionario();
        this.nome = funcionario.getNome();
        Designacao = funcionario.getDesignacao();
        this.telefone = funcionario.getTelefone();
        this.endereco = funcionario.getEndereco();
    }
}
