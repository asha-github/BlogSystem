package com.blog.security;

import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.logging.Logger;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTTokenUtil {
	private static final Logger logger = Logger.getLogger(JWTTokenUtil.class.getSimpleName());
	public static String issueToken(String userName) {
        Key key = SimpleKeyGenerator.getInstance().generateKey();
        String jwtToken = Jwts.builder()
                .setSubject(userName)
                .setIssuedAt(new Date())
                .setExpiration(toDate(LocalDateTime.now().plusMinutes(10)))
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
        logger.info("Generated token : " + jwtToken + " for user " + userName +" with key "+key);
        return jwtToken;

    }
	private static Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
