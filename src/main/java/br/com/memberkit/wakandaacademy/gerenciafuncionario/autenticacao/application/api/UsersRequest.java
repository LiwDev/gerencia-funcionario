package br.com.memberkit.wakandaacademy.gerenciafuncionario.autenticacao.application.api;

import br.com.memberkit.wakandaacademy.gerenciafuncionario.usuario.domain.UserRoles;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Value;
import org.springframework.data.mongodb.core.index.Indexed;

@Value
public class UsersRequest {

    private String login;

    private String senha;
    private UserRoles role;
}
