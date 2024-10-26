package br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.application.service;

import br.com.memberkit.wakandaacademy.gerenciafuncionario.DataHelper;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.application.API.FuncionarioRequest;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.application.repository.FuncionarioRepository;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.funcionario.domain.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class FuncionarioApplicationServiceTest {
    @Mock
    FuncionarioRepository funcionarioRepository;
    @InjectMocks
    FuncionarioApplicationService funcionarioApplicationService;

    @BeforeEach
    void setUp() {
        try (AutoCloseable closeable = MockitoAnnotations.openMocks(this)) {

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void criaNovoFuncionario() {
        Funcionario funcionario = DataHelper.creatFuncionario();
        when(funcionarioRepository.salva(funcionario)).thenReturn(funcionario);
        Funcionario result = funcionarioApplicationService.criaNovoFuncionario(funcionario);
        assertEquals(funcionario, result);
    }

    @Test
    void buscaFuncionarioPorId() {
    }

    @Test
    void buscaFuncionario() {
    }

    @Test
    void atualizaFuncionario() {
    }

    @Test
    void deletaFuncionario() {
    }
}