package br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.application.service;

import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.application.API.FuncionarioRequest;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.application.repository.FuncionarioRepository;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.domain.Funcionario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FuncionarioApplicationService implements FuncionarioService{
    private final FuncionarioRepository funcionarioRepository;

    @Override
    public Funcionario criaNovoFuncionario(FuncionarioRequest funcionarioRequest) {
        Funcionario criaNovoFuncionario = funcionarioRepository.salva(new Funcionario(funcionarioRequest));
        return    criaNovoFuncionario;
    }
}
