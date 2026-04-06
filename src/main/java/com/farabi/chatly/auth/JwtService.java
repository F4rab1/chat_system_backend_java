package com.farabi.chatly.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {
    public String generateToken(String username) {
        final long tokenExpiration = 86400;

        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * tokenExpiration))
                .signWith(Keys.hmacShaKeyFor("GRFQRkHARYG4rTyJzO1VgSZx7hCtqcHI8dNbb1fbXtM=".getBytes()))
                .compact();
    }
}
