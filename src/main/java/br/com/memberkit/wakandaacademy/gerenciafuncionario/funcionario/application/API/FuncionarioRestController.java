package br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.application.API;

import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.application.service.FuncionarioApplicationService;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.application.service.FuncionarioService;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.domain.Funcionario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class FuncionarioRestController implements FuncionarioAPI {


    private final FuncionarioService funcionarioService;

    @Override
    public Funcionario postNovoFuncionario(FuncionarioRequest funcionarioRequest) {
        log.info("[incia] - -FuncionarioRestController - postNovoFuncionario");
        Funcionario criaNovoFuncionario = funcionarioService.criaNovoFuncionario(funcionarioRequest);
        log.info("[finaliza] - -FuncionarioRestController - postNovoFuncionario");
        return criaNovoFuncionario;
    }

    @Override
    public Optional<Funcionario> getFuncionarioPorId(UUID id, Funcionario funcionario) {
        log.info("[incia] - -FuncionarioRestController - getFuncionarioPorId");
        Optional<Funcionario> funcionarioPorId = funcionarioService.buscaFuncionarioPorId(id, funcionario);
        log.info("[finaliza] - -FuncionarioRestController - getFuncionarioPorId");
        return funcionarioPorId;
    }

    @Override
    public List<Funcionario> buscaFuncionario(Funcionario funcionario) {
        log.info("[incia] - -FuncionarioRestController - getFuncionario");
        List<Funcionario> listaFuncionario = funcionarioService.buscaFuncionario(funcionario);
        log.info("[finaliza] - -FuncionarioRestController - getFuncionario");
        return listaFuncionario;
    }
}
