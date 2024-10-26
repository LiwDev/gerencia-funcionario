package br.com.memberkit.wakandaacademy.gerenciafuncionario.autenticacao.application.service;

import br.com.memberkit.wakandaacademy.gerenciafuncionario.usuario.application.repository.UsersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AuthorizationServiceTest {

    @Mock
    private UsersRepository usersRepository;

    @InjectMocks
    private AuthorizationService authorizationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testLoadUserByUsername_UserExists() {
        // Arrange
        String username = "testUser";
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(username, "password", new ArrayList<>());
        when(usersRepository.findByLogin(username)).thenReturn(userDetails);

        // Act
        UserDetails result = authorizationService.loadUserByUsername(username);

        // Assert
        assertEquals(userDetails, result);
    }

    @Test
    void testLoadUserByUsername_UserNotFound() {
        // Arrange
        String username = "unknownUser";
        when(usersRepository.findByLogin(username)).thenReturn(null);

        // Act & Assert
        assertThrows(UsernameNotFoundException.class, () -> authorizationService.loadUserByUsername(username));
    }
    }