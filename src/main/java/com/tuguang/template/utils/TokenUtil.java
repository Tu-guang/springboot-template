package com.tuguang.template.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.tuguang.template.model.entity.User;

import java.util.Date;

public class TokenUtil {
    private static final long EXPIRE_TIME = 60 * 60 * 60 * 1000;
    private static final String TOKEN_SECRET = "tuguang";  //密钥盐

    /**
     * 签名生成
     *
     * @param user
     * @return
     */
    public static String sign(User user) {
        String token = null;
        try {
            System.out.println(user.getId());
            Date expiresAt = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            token = JWT.create()
                    .withIssuer("auth0")
                    .withClaim("userAccount", user.getAccount())
                    .withClaim("userId", user.getId().toString())
                    .withExpiresAt(expiresAt)
                    // 使用了HMAC256加密算法。
                    .sign(Algorithm.HMAC256(TOKEN_SECRET));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }

    /**
     * 签名验证
     *
     * @param token
     * @return
     */
    public static String verify(String token) {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();
            DecodedJWT jwt = verifier.verify(token);
            System.out.println("认证通过：");
            System.out.println("userAccount: " + jwt.getClaim("userAccount").asString());
            System.out.println("userId: " + jwt.getClaim("userId").asString());
            System.out.println("过期时间：      " + jwt.getExpiresAt());
            return jwt.getClaim("userId").asString();
        } catch (Exception e) {
            return null;
        }
    }
}

