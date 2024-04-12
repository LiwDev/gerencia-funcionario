package br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.application.service;

import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.application.API.FuncionarioRequest;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.application.API.FuncionarioResponse;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.application.repository.FuncionarioRepository;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.domain.Funcionario;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.handler.ApiException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class FuncionarioApplicationService implements FuncionarioService{
    private final FuncionarioRepository funcionarioRepository;

    @Override
    public Funcionario criaNovoFuncionario(FuncionarioRequest funcionarioRequest) {
        log.info("[incia] - -FuncionarioApplicationService - criaNovoFuncionario");
        Funcionario criaNovoFuncionario = funcionarioRepository.salva(new Funcionario(funcionarioRequest));
        log.info("[finaliza] - -FuncionarioApplicationService - criaNovoFuncionario");
        return    criaNovoFuncionario;
    }

    @Override
    public  Optional<Funcionario> buscaFuncionarioPorId(UUID id) {
        log.info("[incia] - -FuncionarioApplicationService - buscaFuncionarioPorId");
        Optional<Funcionario> funcionarioPorId =   funcionarioRepository.buscaFuncionarioPorId(id);
        log.info("[finaliza] - -FuncionarioApplicationService - buscaFuncionarioPorId");
        return funcionarioPorId;
    }

    @Override
    public List<Funcionario> buscaFuncionario() {
        log.info("[incia] - -FuncionarioApplicationService - buscaFuncionario");
        List<Funcionario> listaFuncionario = funcionarioRepository.buscaFuncionario();
        log.info("[finaliza] - -FuncionarioApplicationService - buscaFuncionario");
        return  listaFuncionario;
    }

    @Override
    public Optional<FuncionarioResponse> atualizaFuncionario(UUID idFuncionario, FuncionarioRequest funcionario) {
        funcionarioRepository.atualizaFuncionario(idFuncionario,new FuncionarioResponse(funcionario));
        return Optional.of(new FuncionarioResponse(funcionario));
    }
}
