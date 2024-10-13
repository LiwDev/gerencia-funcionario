package br.com.memberkit.wakandaacademy.gerenciafuncionario.usuario.application.service;

import br.com.memberkit.wakandaacademy.gerenciafuncionario.autenticacao.application.api.UsersRequest;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.usuario.domain.Users;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
    void criaUsuario(Users users);
    UserDetails findByLogin(String login);
}
