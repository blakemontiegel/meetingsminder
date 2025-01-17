package com.blakemontiegel.meeting_efficiency_tracker.authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    private final String SECRET_KEY = "${SECRET_KEY}";

    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) //24 hrs
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}
