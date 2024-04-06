package br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.infra;

import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.application.API.FuncionarioResponse;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.application.repository.FuncionarioRepository;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.domain.Funcionario;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.handler.ApiException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Log4j2
@Repository
@RequiredArgsConstructor
public class FuncionarioInfraRepository implements FuncionarioRepository {
    private final FuncionarioSpringMongoDBRepository funcionarioSpringMongoDBRepository;

    @Override
    public Funcionario salva(Funcionario funcionario) {
        log.info("[incia] - -FuncionarioSpringMongoDBRepository - salva");
        try {
            funcionarioSpringMongoDBRepository.save(funcionario);
        } catch (DataIntegrityViolationException e) {
            throw ApiException.build(HttpStatus.BAD_REQUEST, "Funcionario já cadastrada", e);
        }
        log.info("[finaliza] - -FuncionarioSpringMongoDBRepository - salva");
        return funcionario;

    }

    @Override
    public Optional<Funcionario> buscaFuncionarioPorId(UUID id, Funcionario funcionario) {
        log.info("[incia] - -FuncionarioSpringMongoDBRepository - buscaFuncionarioPorId");
        Optional<Funcionario> funcionarioResponse = funcionarioSpringMongoDBRepository.findById(id);
        log.info("[finaliza] - -FuncionarioSpringMongoDBRepository - buscaFuncionarioPorId");
      return funcionarioResponse;
    }

    @Override
    public List<Funcionario> buscaFuncionario(Funcionario funcionario) {
        log.info("[incia] - -FuncionarioSpringMongoDBRepository - buscaFuncionario");
        List<Funcionario> listaFuncionario = funcionarioSpringMongoDBRepository.findAll();
        log.info("[finaliza] - -FuncionarioSpringMongoDBRepository - buscaFuncionario");
   return listaFuncionario;
    }

}
