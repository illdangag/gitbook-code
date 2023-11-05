package com.illdangag.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtCreateMain {
    private static String secretKey = Base64.getEncoder().encodeToString("SECRET_KEY_SECRET_KEY_SECRET_KEY_SECRET_KEY_SECRET_KEY_SECRET_KEY".getBytes());
    private static long tokenValidTime = 30 * 60 * 1000L; // 토큰 유효 시간 30분

    public static void main(String[] args) throws Exception {
        Map<String, String> payload = new HashMap<>();
        payload.put("ID", "USER_ID");

        Date now = new Date();
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));

        String jwt = Jwts.builder()
                .claim("app", payload)
                .issuedAt(now)
                .expiration(new Date(now.getTime() + tokenValidTime))
                .signWith(key, Jwts.SIG.HS512)
                .compact();

        System.out.println(jwt);
    }
}
