package br.com.memberkit.wakandaacademy.gerenciafuncionario.autenticacao.application.api;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Builder
@Data

public class AutenticacaoRequest {
    @NotNull
    @NotBlank(message = "o Usuario não pode ficar em branco")
    @Email
    private String usuario;
    @NotNull
    @Size(min = 6,message = "a Senha deve ter no minimo de 6 caracteres")
    private  String senha;
    public UsernamePasswordAuthenticationToken getUserPassToken(){
        return new UsernamePasswordAuthenticationToken(usuario,senha);
    }
}
