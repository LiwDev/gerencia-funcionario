package br.com.memberkit.wakandaacademy.gerenciafuncionario;

import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.domain.Endereco;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.domain.Funcionario;

import java.util.UUID;

public class DataHelper {
    private static final UUID funcionarioID = UUID.fromString("a713162f-20a9-4db9-a85b-90cd51ab18f4");
    public static Funcionario creatFuncionario(){
        return Funcionario.builder().idFuncionario(funcionarioID).nome("wilson costa").designacao("chefe").telefone("1234456789")
                .endereco(Endereco.builder().cep("12456782").rua("rua dos patos").estado("Minas Gerais").cidade("Manga").build())
                .build();
    }
}
