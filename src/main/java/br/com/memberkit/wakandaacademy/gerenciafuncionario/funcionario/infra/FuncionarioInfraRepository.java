package br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.infra;

import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.application.repository.FuncionarioRepository;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.domain.Funcionario;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.handler.ApiException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
@Log4j2
@Repository
@RequiredArgsConstructor
public class FuncionarioInfraRepository implements FuncionarioRepository {
    private FuncionarioSpringMongoDBRepository funcionarioSpringMongoDBRepository;

    @Override
    public Funcionario salva(Funcionario funcionario) {
        log.info("[incia] - -FuncionarioSpringMongoDBRepository - salva");
        try {
            funcionarioSpringMongoDBRepository.save(funcionario);
        } catch (DataIntegrityViolationException e) {
            throw ApiException.build(HttpStatus.BAD_REQUEST, "Funcionario já cadastrada", e);
        }
        log.info("[incia] - -FuncionarioSpringMongoDBRepository - salva");
        return funcionario;

    }

}
