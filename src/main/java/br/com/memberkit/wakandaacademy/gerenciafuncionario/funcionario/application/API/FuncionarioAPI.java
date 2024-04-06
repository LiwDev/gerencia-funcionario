package br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.application.API;

import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.domain.Funcionario;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/funcionario")
public interface FuncionarioAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    Funcionario postNovoFuncionario(@RequestBody @Valid FuncionarioRequest funcionarioRequest);
    @GetMapping("/lista-funcionario/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    Optional<Funcionario> getFuncionarioPorId(@Valid @PathVariable("id") UUID id , @RequestParam(required = false) Funcionario funcionario);

    @GetMapping("/lista-funcionario")
    @ResponseStatus(code = HttpStatus.OK)
    List<Funcionario> buscaFuncionario(@RequestParam(required = false) Funcionario funcionario);
}
