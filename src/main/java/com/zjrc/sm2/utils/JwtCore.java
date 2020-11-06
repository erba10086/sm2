package com.zjrc.sm2.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

/**
 * @author xy
 * @version 1.0
 * @date 2020/10/4 10:47
 */
public class JwtCore {
    public JwtCore() {
    }

    public static String createToken(String msg) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setIssuedAt(new Date());
        jwtBuilder.setSubject(msg);
        jwtBuilder.signWith(signatureAlgorithm, createKey());
        return jwtBuilder.compact();
    }

    public static String parseJWT(String token) {
        SecretKey key = createKey();
        Claims claims = (Claims)Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    private static SecretKey createKey() {
        byte[] keys = "netpackettoken".getBytes();
        SecretKey key = new SecretKeySpec(keys, 0, keys.length, "AES");
        return key;
    }
}
