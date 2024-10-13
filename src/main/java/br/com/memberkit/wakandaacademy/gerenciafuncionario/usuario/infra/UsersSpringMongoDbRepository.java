package br.com.memberkit.wakandaacademy.gerenciafuncionario.usuario.infra;

import br.com.memberkit.wakandaacademy.gerenciafuncionario.usuario.domain.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface UsersSpringMongoDbRepository extends MongoRepository<Users, UUID> {
    UserDetails findByLogin(String login);
}
