package br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.application.API;

import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.application.service.FuncionarioApplicationService;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.application.service.FuncionarioService;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.domain.Funcionario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class FuncionarioRestController implements FuncionarioAPI {


    private final FuncionarioService funcionarioService;

    @Override
    public Funcionario postNovoFuncionario(FuncionarioRequest funcionarioRequest) {
        Funcionario criaNovoFuncionario = funcionarioService.criaNovoFuncionario(funcionarioRequest);
        return criaNovoFuncionario;
    }
}
