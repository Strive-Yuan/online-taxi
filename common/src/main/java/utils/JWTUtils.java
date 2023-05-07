package utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;

public class JWTUtils {

    private static final String SALT = "v83fhE5OJ8Bw5v6JagpMfZFrVG2S1mDx";


    public static String generatorToken(Map<String, String> map) {
        JWTCreator.Builder builder = JWT.create();
        map.forEach(builder::withClaim);
        builder.withExpiresAt(Date.from(LocalDateTime.now().plusMinutes(30).atZone(ZoneId.systemDefault()).toInstant()));
        return builder.sign(Algorithm.HMAC256(SALT));
    }

    public static String parseToken(String token) {
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(SALT)).build().verify(token);
        return verify.getClaim("name").asString();
    }

    public static void main(String[] args) {
        String token = generatorToken(Map.of("name", "小刘", "age", "18"));
        System.out.println(token);
        String decodedJWT = parseToken(token);
        System.out.println(Jackson.toJson(decodedJWT));
    }
}
