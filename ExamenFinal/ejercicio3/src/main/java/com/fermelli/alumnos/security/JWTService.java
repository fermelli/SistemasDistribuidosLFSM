package com.fermelli.alumnos.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.util.Date;

public class JWTService {

    private final long TIEMPO_EXPIRACION_SEGUNDOS = 60000;
    private final String llaveSecreta = "!fermelli¡";
    private final Algorithm algorithm = Algorithm.HMAC256(llaveSecreta);

    public JWTService() {
    }

    public String generarToken(String nombreUsuario, int nivelUsuario) {
        long ahora = new Date().getTime();
        long tiempoExpiracion = ahora + TIEMPO_EXPIRACION_SEGUNDOS;
        Date fechaExpiracion = new Date(tiempoExpiracion);
        String token = JWT.create().withIssuer("Meet")
            .withClaim("usuario", nombreUsuario)
            .withClaim("nivel", nivelUsuario)
            .withExpiresAt(fechaExpiracion)
            .sign(algorithm);
        return token;
    }

    public String resolverToken(String token) {
        if (token != null && token.startsWith("Bearer ")) {
            return token.substring(7);
        }
        return null;
    }

    public boolean verificarToken(String token) {
        try {
            JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("Meet")
                .acceptExpiresAt(TIEMPO_EXPIRACION_SEGUNDOS)
                .build();
            token = resolverToken(token);
            if(token == null) {
                return false;
            }
            verifier.verify(token);
            return true;
        } catch (JWTVerificationException e) {
            return false;
        }
    }

    public String obtenerDatoDelToken(String token, String key) {
        token = resolverToken(token);
        DecodedJWT decodedJWT = JWT.decode(token);
        return decodedJWT.getClaims().get(key).toString();
    }

}
