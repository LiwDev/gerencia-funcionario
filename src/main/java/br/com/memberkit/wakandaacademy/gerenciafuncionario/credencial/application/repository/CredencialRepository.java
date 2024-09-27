package br.com.memberkit.wakandaacademy.gerenciafuncionario.credencial.application.repository;

import br.com.memberkit.wakandaacademy.gerenciafuncionario.credencial.domain.Credencial;
import org.springframework.stereotype.Repository;


public interface CredencialRepository {
    Credencial salvaCredencial(Credencial credencial);
    Credencial searchCredentialToUser(String usuario);
}
