package br.com.memberkit.wakandaacademy.gerenciafuncionario.credencial.infra;

import br.com.memberkit.wakandaacademy.gerenciafuncionario.credencial.domain.Credencial;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CredencialMongoSpringRepository extends MongoRepository<Credencial,String> {
    Optional<Credencial> findByUsuario(String usuario);
}
