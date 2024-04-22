//package com.example.helloworld.helloworld.utility;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.security.Keys;
//import jakarta.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import javax.crypto.SecretKey;
//import java.io.Serializable;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.function.Function;
//
//@Component
//public class JwtUtility implements Serializable {
//
//    private static final long serialVersionUID = 234234523523L;
//    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
//
//    @Value("${jwt.secret}")
//    private String secret;
//
//    private SecretKey secretKey;
//
//    @PostConstruct
//    public void init() {
//        secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);
//    }
//
//    // Retrieve username from JWT token
//    public String getUsernameFromToken(String token){
//        return getClaimFromToken(token, Claims::getSubject);
//    }
//
//    // Retrieve expiration date from JWT token
//    public Date getExpirationDateFromToken(String token){
//        return getClaimFromToken(token, Claims::getExpiration);
//    }
//
//    public <T> T getClaimFromToken(String token, Function<Claims,T> claimsResolver)
//    {
//        final Claims claims=getAllClaimsFromToken(token);
//        return claimsResolver.apply(claims);
//    }
//
//    // Check if the token has expired
//
//    private Claims getAllClaimsFromToken(String token) {
//        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
//    }
//
//
//    private Boolean isTokenExpired(String token){
//        final Date expiration = getExpirationDateFromToken(token);
//        return expiration.before(new Date());
//    }
//
//    // Generate token for user
//    public String generateToken(UserDetails userDetails){
//        Map<String,Object> claims=new HashMap<>();
//        return doGenerateToken(claims,userDetails.getUsername());
//    }
//
//    private  String doGenerateToken(Map<String,Object>claims,String subject){
//        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis()+ JWT_TOKEN_VALIDITY *1000))
//                .signWith(secretKey).compact();
//
//    }
//
//    public Boolean validateToken(String token,UserDetails userDetails){
//        final String username=getUsernameFromToken(token);
//        return (username.equals(userDetails.getUsername())&& !isTokenExpired(token));
//    }
//
//    // Method to get or generate the secret key
//
//}