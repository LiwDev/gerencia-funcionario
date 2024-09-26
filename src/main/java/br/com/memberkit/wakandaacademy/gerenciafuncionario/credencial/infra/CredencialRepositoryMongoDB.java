package br.com.memberkit.wakandaacademy.gerenciafuncionario.credencial.infra;

import br.com.memberkit.wakandaacademy.gerenciafuncionario.credencial.application.repository.CredencialRepository;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.credencial.domain.Credencial;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.handler.ApiException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;

@Log4j2
@RequiredArgsConstructor
public class CredencialRepositoryMongoDB implements CredencialRepository {
 private final CredencialMongoSpringRepository credencialMongoSpringRepository;
    @Override
    public Credencial salvaCredencial(Credencial credencial) {
       log.info("[Inicia] CredencialRepositoryMongoDB- salvaCredencial ");
credencialMongoSpringRepository.save(credencial);
        log.info("[finaliza] CredencialRepositoryMongoDB- salvaCredencial ");

        return credencial;
    }

    @Override
    public Credencial buscaCredencialPorUsuario(String usuario) {
        log.info("[Inicia] CredencialRepositoryMongoDB- buscaCredencialPorUsuario ");
        var credencial = credencialMongoSpringRepository.findByUsuario(usuario).orElseThrow(()-> ApiException.build(HttpStatus.NOT_FOUND,"Credencial não encontrada para esse usuario"));
        log.info("[finaliza] CredencialRepositoryMongoDB- buscaCredencialPorUsuario ");
        return credencial;
    }
}
