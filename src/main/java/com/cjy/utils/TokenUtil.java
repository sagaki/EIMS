package com.cjy.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
    生成Token 解析Token
 */
public class TokenUtil {
    // 设置过期时间
    private static final long EXPIRE_DATE = 10 * 60 * 1000;
    // token秘钥
    private static final String TOKEN_SECRET = "hellowrod2022";

    public static String createJwt(String id) {
        String userToken = null;
        JwtBuilder builder = Jwts.builder().setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DATE));
        builder.setId(id);
        userToken = builder.signWith(SignatureAlgorithm.HS512, TOKEN_SECRET).compact();
        return userToken;
    }

    public static Claims parseJwt(String token) {
        return Jwts.parser().setSigningKey(TOKEN_SECRET).parseClaimsJws(token).getBody();
    }

}
