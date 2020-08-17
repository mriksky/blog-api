package com.mirkmoon.components.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * JWT生成
 */
public class JwtTokenUtil {
    //私钥
    private static final String SECRET_KEY = "I-LIKE-CODING";
    //
    private static final long EXPIRATION_TIME = 3600000L * 23 * 7;

    /**
     *
     */
    public String generateToken(UserDetails userDetails){
        Map<String,Object> claims =new HashMap<>(2);
        claims.put(Claims.SUBJECT,userDetails.getUsername());
        claims.put(Claims.ISSUED_AT,new Date());
        return generateToken(claims);
    }

    /**
     *  从数据申明声明令牌
     * @param claims 数据声明
     * @return 令牌
     */
    private String generateToken(Map<String, Object> claims) {
        Date expirationDate = new Date(System.currentTimeMillis()+EXPIRATION_TIME);
        return Jwts.builder().setClaims(claims).setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.ES512,SECRET_KEY)
                .compact();
    }

}
