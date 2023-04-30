package com.crud.crud.security.jwt;

import com.crud.crud.security.entity.PrincipalUser;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Esta clase genera el token
 * posee un metodo de validacion, que el token no este expirado
 */

@Component
public class JwtProvider {
    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private int expiration;

    public String generateToken(Authentication authentication) {
        PrincipalUser principalUser = (PrincipalUser) authentication.getPrincipal();

        return Jwts.builder().setSubject(principalUser.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 1000L))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public String getUserNameFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJwt(token).getBody().getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJwt(token);
            return true;
        } catch (MalformedJwtException e) {
            logger.error("Bad formed token");
        } catch (UnsupportedJwtException e) {
            logger.error("Not soported token");
        } catch (ExpiredJwtException e) {
            logger.error("Expired token");
        } catch (IllegalArgumentException e) {
            logger.error("Empty token");
        }

        return false;
    }

}
