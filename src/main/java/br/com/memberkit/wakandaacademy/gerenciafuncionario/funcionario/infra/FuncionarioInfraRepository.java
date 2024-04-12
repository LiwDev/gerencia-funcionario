package br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.infra;

import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.application.API.FuncionarioRequest;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.application.API.FuncionarioResponse;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.application.repository.FuncionarioRepository;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.domain.Funcionario;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.handler.ApiException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

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
    public Optional<Funcionario> buscaFuncionarioPorId(UUID id) {
        log.info("[incia] - -FuncionarioSpringMongoDBRepository - buscaFuncionarioPorId");
        Optional<Funcionario> funcionarioResponse = funcionarioSpringMongoDBRepository.findById(id);
        log.info("[finaliza] - -FuncionarioSpringMongoDBRepository - buscaFuncionarioPorId");
        return funcionarioResponse;
    }

    @Override
    public List<Funcionario> buscaFuncionario() {
        log.info("[incia] - -FuncionarioSpringMongoDBRepository - buscaFuncionario");
        List<Funcionario> listaFuncionario = funcionarioSpringMongoDBRepository.findAll();
        log.info("[finaliza] - -FuncionarioSpringMongoDBRepository - buscaFuncionario");
        return listaFuncionario;
    }

    @Override
    public void atualizaFuncionario(UUID idFuncionario, FuncionarioResponse funcionario) {
        log.info("[incia] - -FuncionarioSpringMongoDBRepository - atualizaFuncionario");
        try {
            log.info("[incia] - -FuncionarioSpringMongoDBRepository - atualizaFuncionario");
            Funcionario existingFuncionario = funcionarioSpringMongoDBRepository.findById(idFuncionario).get();
            log.info("[existingFuncionario] - -funcionarioSpringMongoDBRepository - findById");

            if (funcionario.getNome() != null && !funcionario.getNome().isBlank()) {
                existingFuncionario.setNome(funcionario.getNome());
            }
            if (funcionario.getTelefone() != null && !funcionario.getTelefone().isBlank()) {
                existingFuncionario.setTelefone(funcionario.getTelefone());
            }
            if (funcionario.getDesignacao() != null && !funcionario.getDesignacao().isBlank())
                existingFuncionario.setDesignacao(funcionario.getDesignacao());

            if (funcionario.getEndereco().getCep() != null && !funcionario.getEndereco().getCep().isBlank())
                existingFuncionario.getEndereco().setCep(funcionario.getEndereco().getCep());
            if (funcionario.getEndereco().getCidade() != null && !funcionario.getEndereco().getCidade().isBlank())
                existingFuncionario.getEndereco().setCidade(funcionario.getEndereco().getCidade());
            if (funcionario.getEndereco().getRua() != null && !funcionario.getEndereco().getRua().isBlank())
                existingFuncionario.getEndereco().setRua(funcionario.getEndereco().getRua());
            if (funcionario.getEndereco().getEstado() != null && !funcionario.getEndereco().getEstado().isBlank())
                existingFuncionario.getEndereco().setEstado(funcionario.getEndereco().getEstado());
            log.info("[existingFuncionario-encontrado] - -funcionarioSpringMongoDBRepository - findById ");


            funcionarioSpringMongoDBRepository.save(existingFuncionario);
            log.info("[finaliza] - -FuncionarioSpringMongoDBRepository - atualizaFuncionario");
        } catch
        (Exception exception) {
            throw ApiException.build(HttpStatus.BAD_REQUEST, "error ao atualizar funcionario", exception);
        }

    }

    @Override
    public void deletaFuncionario(UUID idFuncionario) {
        log.info("[incia] - -FuncionarioSpringMongoDBRepository - deletaFuncionario");
        Funcionario funcionario = funcionarioSpringMongoDBRepository.findById(idFuncionario).get();
        funcionarioSpringMongoDBRepository.delete(funcionario);
        log.info("[finaliza] - -FuncionarioSpringMongoDBRepository - deletaFuncionario");
    }


}
