package br.com.memberkit.wakandaacademy.gerenciafuncionario.config.security.application.services;

import br.com.memberkit.wakandaacademy.gerenciafuncionario.handler.ApiException;
import br.com.memberkit.wakandaacademy.gerenciafuncionario.usuario.domain.Users;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service

public class TokenService {

    @Value("${gerencia-funcionario.security.token.secret}")
    private String secret;
    @Value("${gerencia-funcionario.security.token.api}")
    private String apiName;

    public String generateToken(Users users){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
        String token = JWT.create()
                .withIssuer(apiName)
                .withSubject(users.getLogin())
                .withExpiresAt(getExpiraçaoDate())
                .sign(algorithm);
        return  token;}
        catch (JWTCreationException creationException){
            throw  ApiException.build(HttpStatus.BAD_REQUEST,"Falha ao criar token", creationException);
        }
    }
    public  String ValidetToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
       return JWT.require(algorithm)
               .withIssuer(apiName)
               .build()
               .verify(token)
               .getSubject();}
        catch (JWTVerificationException jwtVerificationException){
            throw ApiException.build(HttpStatus.BAD_REQUEST,"Token Invalido",jwtVerificationException);
        }


    }
    public Instant getExpiraçaoDate(){
        return LocalDateTime.now().plusHours(2).toInstant( ZoneOffset.of("-03.00"));

    }

}
