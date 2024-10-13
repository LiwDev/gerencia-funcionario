package br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.infra;

import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.domain.Funcionario;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.UUID;

public interface FuncionarioSpringMongoDBRepository extends MongoRepository<Funcionario, UUID> {

}
