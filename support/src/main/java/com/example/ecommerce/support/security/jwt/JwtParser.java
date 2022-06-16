package com.example.ecommerce.support.security.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Collection;
import java.util.List;

@Slf4j
public class JwtParser {

    private final SecretKey key;

    public JwtParser(final String secret) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    public Authentication authentication(final String token) throws JwtException {;
        Claims claims = this.parseJwt(token).getBody();

        String principal = claims.get("userId").toString();
        Collection<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(claims.get("role").toString()));

        return new UsernamePasswordAuthenticationToken(principal, "", authorities);
    }

    private Jws<Claims> parseJwt(final String token) throws AuthenticationException {
        try{
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
        } catch (MalformedJwtException e) {
            throw new AuthenticationServiceException("Malformed Token");
        } catch (ExpiredJwtException e) {
            throw new AuthenticationServiceException("Expired Token");
        } catch (UnsupportedJwtException e) {
            throw new AuthenticationServiceException("Unsupported Token");
        } catch (JwtException e) {
            throw new AuthenticationServiceException("Invalid Token");
        }
    }

}
