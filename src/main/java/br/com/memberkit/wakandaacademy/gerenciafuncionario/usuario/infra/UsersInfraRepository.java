package br.com.memberkit.wakandaacademy.gerenciafuncionario.usuario.infra;

import br.com.memberkit.wakandaacademy.gerenciafuncionario.handler.ApiException;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.autenticacao.application.api.UsersRequest;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.usuario.application.repository.UsersRepository;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.usuario.domain.Users;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Log4j2
public class UsersInfraRepository implements UsersRepository {
    private final UsersSpringMongoDbRepository usersSpringMongoDbRepository;
    @Override
    public void salva(Users users) {
        log.info("[inicia] UsersInfraRepository - salva");
        try {
            usersSpringMongoDbRepository.save(users);
        }catch (DataIntegrityViolationException dataIntegrityViolationException){
            throw ApiException.build(HttpStatus.BAD_REQUEST,"erro ao criar usuario",dataIntegrityViolationException);

        }
        log.info("[inicia] UsersInfraRepository - salva");
    }

    @Override
    public UserDetails findByLogin(String login) {
        log.info("[inicia] UsersInfraRepository - fyndByLogin");
        var usuario = usersSpringMongoDbRepository.findByLogin(login);
        log.info("[inicia] UsersInfraRepository - fyndByLogin");
        return usuario;
    }
}
