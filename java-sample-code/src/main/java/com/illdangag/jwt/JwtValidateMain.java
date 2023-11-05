package com.illdangag.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Map;

public class JwtValidateMain {
    private static String secretKey = Base64.getEncoder().encodeToString("SECRET_KEY_SECRET_KEY_SECRET_KEY_SECRET_KEY_SECRET_KEY_SECRET_KEY".getBytes());;

    public static void main(String[] args) {
        String jwtString  = "eyJhbGciOiJIUzUxMiJ9.eyJhcHAiOnsiSUQiOiJVU0VSX0lEIn0sImlhdCI6MTY5OTE4NTY1OCwiZXhwIjoxNjk5MTg3NDU4fQ.-9L1o6UlSEnuqbY0bWqj9URrmu3p7D414j1QuTChU8glcygKiX-OzCcftTKfSwSHU48ghaZcaCv-EJ35FBcF0A";

        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));

        Jws<Claims> jwe = Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(jwtString);

        Claims claims = jwe.getPayload();
        Map<String, String> map = claims.get("app", Map.class);
        System.out.println(jwe);
    }
}
