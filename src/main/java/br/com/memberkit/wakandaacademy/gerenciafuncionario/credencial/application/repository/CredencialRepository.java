package br.com.memberkit.wakandaacademy.gerenciafuncionario.credencial.application.repository;

import br.com.memberkit.wakandaacademy.gerenciafuncionario.credencial.domain.Credencial;

public interface CredencialRepository {
    Credencial salvaCredencial(Credencial credencial);
    Credencial buscaCredencialPorUsuario(String usuario);
}
