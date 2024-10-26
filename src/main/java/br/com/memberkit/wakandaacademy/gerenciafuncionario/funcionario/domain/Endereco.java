package br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
@Builder
@Data
public class Endereco {
    private String rua;
    private String cidade;
    private String estado;
    private String cep;
}
