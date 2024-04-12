package br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.application.API;

import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.domain.Endereco;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class FuncionarioResponse {
    private String nome;
    private String designacao;
    private String telefone;

    private Endereco endereco;

    public FuncionarioResponse(FuncionarioRequest funcionario) {
        this.nome = funcionario.getNome();
        designacao = funcionario.getDesignacao();
        this.telefone = funcionario.getTelefone();
        this.endereco = funcionario.getEndereco();
    }
}
