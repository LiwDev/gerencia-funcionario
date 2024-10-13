package br.com.memberkit.wakandaacademy.gerenciafuncionario.usuario.application.repository;

import br.com.memberkit.wakandaacademy.gerenciafuncionario.autenticacao.application.api.UsersRequest;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.usuario.domain.Users;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsersRepository {
    void salva(Users users);
    UserDetails findByLogin(String login);
}
