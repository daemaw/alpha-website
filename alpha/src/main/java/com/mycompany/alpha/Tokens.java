/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.alpha;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.time.Instant;
import java.util.Date;

/**
 *
 * @author z004366p
 */
public class Tokens {
    private static final String secret = "alpha-sec";
    private static final Algorithm algorithm = Algorithm.HMAC256(secret);
    private static final JWTVerifier verifier = JWT.require(algorithm)
        .withIssuer("alpha")
        .build(); //Reusable verifier instance
    
    public static String createLoginToken(User user) throws JWTCreationException{
        String token;
        Instant time = Instant.now().plusSeconds(3600);
        Date date = Date.from(time);
        
        token = JWT.create()
            .withIssuer("alpha")
            .withClaim("uid", user.getUid())
            .withClaim("username", user.getUsername())
            .withClaim("isadmin", user.getAdmin())
            .withExpiresAt(date)
            .sign(algorithm);
        
        return token;
    }
    
    public static boolean verifyLoginToken(String token) {
        try{
            DecodedJWT jwt = verifier.verify(token);
        }
        catch(JWTVerificationException e){
            return false;
        }
        return true;
    }
}
