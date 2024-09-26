package br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.infra;

import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.application.API.FuncionarioRequest;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.application.API.FuncionarioResponse;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.application.repository.FuncionarioRepository;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.domain.Endereco;
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
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

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

            Funcionario filtraFuncionarioRequest = verificaRequest(idFuncionario,funcionario);

            funcionarioSpringMongoDBRepository.save(filtraFuncionarioRequest);
            log.info("[finaliza] - -FuncionarioSpringMongoDBRepository - atualizaFuncionario");

    }

    @Override
    public void deletaFuncionario(UUID idFuncionario) {
        log.info("[incia] - -FuncionarioSpringMongoDBRepository - deletaFuncionario");
        Funcionario funcionario = funcionarioSpringMongoDBRepository.findById(idFuncionario).get();
        funcionarioSpringMongoDBRepository.delete(funcionario);
        log.info("[finaliza] - -FuncionarioSpringMongoDBRepository - deletaFuncionario");
    }
public Funcionario verificaRequest(UUID idFuncionario ,FuncionarioResponse funcionario){
    log.info("[incia] - -FuncionarioSpringMongoDBRepository - verificaRequest");
    Funcionario existingFuncionario = funcionarioSpringMongoDBRepository.findById(idFuncionario).get();

    Optional.ofNullable(funcionario.getNome())
            .filter(nome -> !nome.isBlank())
            .ifPresent(existingFuncionario::setNome);

    Optional.ofNullable(funcionario.getTelefone())
            .filter(telefone -> !telefone.isBlank())
            .ifPresent(existingFuncionario::setTelefone);

    Optional.ofNullable(funcionario.getDesignacao())
            .filter(designacao -> !designacao.isBlank())
            .ifPresent(existingFuncionario::setDesignacao);

    Optional.ofNullable(funcionario.getEndereco())
            .ifPresent(endereco -> {
                if (endereco.getCep() != null && !endereco.getCep().isBlank()) {
                    existingFuncionario.getEndereco().setCep(endereco.getCep());
                }
                if (endereco.getCidade() != null && !endereco.getCidade().isBlank()) {
                    existingFuncionario.getEndereco().setCidade(endereco.getCidade());
                }
                if (endereco.getRua() != null && !endereco.getRua().isBlank()) {
                    existingFuncionario.getEndereco().setRua(endereco.getRua());
                }
                if (endereco.getEstado() != null && !endereco.getEstado().isBlank()) {
                    existingFuncionario.getEndereco().setEstado(endereco.getEstado());
                }
            });
    log.info("[finaliza] - -funcionarioSpringMongoDBRepository - verificaRequest");
    return existingFuncionario;

}

}
