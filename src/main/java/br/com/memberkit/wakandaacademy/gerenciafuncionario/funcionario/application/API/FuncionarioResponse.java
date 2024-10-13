package br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.application.API;

import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.domain.Endereco;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.domain.StatusFuncionario;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class FuncionarioResponse {
    private String nome;
    private StatusFuncionario statusFuncionario;
    private String designacao;
    private String telefone;

    private Endereco endereco;

    public FuncionarioResponse(FuncionarioRequest funcionario) {
        this.nome = funcionario.getNome();
        this.statusFuncionario = funcionario.getStatusFuncionario();

        designacao = funcionario.getDesignacao();
        this.telefone = funcionario.getTelefone();
        this.endereco = funcionario.getEndereco();
    }
}
