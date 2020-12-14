package com.zyy.mowa.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.zyy.mowa.dao.TUser;
import com.zyy.mowa.dto.UserDto;

/**
 * @author USER
 * @date 2020/05/25
 */
public class JwtUtils {

    /**
     * 过期时间为一天 TODO 正式上线更换为15分钟
     */
    private static final long EXPIRE_TIME = 24 * 60 * 60 * 1000;

    /**
     * token私钥
     */
    private static final String TOKEN_SECRET = "joijsdfjlsjfljfljl5135313135";

    /**
     * 生成签名,15分钟后过期
     *
     * @return
     */
    /*  public static String sign(String username,String userId){
        //过期时间
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        //私钥及加密算法
        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
        //设置头信息
        HashMap<String, Object> header = new HashMap<>(2);
        header.put("typ", "JWT");
        header.put("alg", "HS256");
        //附带username和userID生成签名
        return JWT.create().withHeader(header).withClaim("loginName",username)
                .withClaim("userId",userId).withExpiresAt(date).sign(algorithm);
    }
    
    
    public static boolean verity(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        } catch (JWTVerificationException e) {
            return false;
        }
    
    }*/

    // 自定义两个注解
    // 用来跳过验证
    @Target({ElementType.METHOD, ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface PassToken {
        boolean required() default true;
    }

    // 需要登录才能进行操作的注解
    @Target({ElementType.METHOD, ElementType.TYPE}) // 注解的作用目标
    @Retention(RetentionPolicy.RUNTIME) // 注解的保留位置
    public @interface UserLoginToken {
        boolean required() default true;
    }

    /**
     * 生成token
     * 
     * @param user
     * @return
     */
    public String getToken(TUser user) {
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        String token = "";
       token = JWT.create().withAudience(user.getUsername()).withExpiresAt(date)
           .sign(Algorithm.HMAC256(user.getNickname()));
        return token;
    }
}
