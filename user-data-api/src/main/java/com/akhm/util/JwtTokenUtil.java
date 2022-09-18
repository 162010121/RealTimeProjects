package com.akhm.util;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable 
{
static final long serialVersionUID = 1L;

public static final long JWT_TOKEN_VALIDITY=60*60*5;

@Value("${jwt.secret}")
private String secret;

		//Retrieve UserName from JwtToken
		public String getUserNameFromToken(String token)
		{
			return getClaimFromToken(token,Claims::getSubject);
		}
		
		public Date getExperationDateFromToken(String token)
		{
			return getClaimFromToken(token,Claims::getExpiration);
		}
		public <T> T getClaimFromToken(String token,Function<Claims, T> claimsResolver)
		{
			final Claims claims=getAllClaimsFromToken(token); 
			return claimsResolver.apply(claims);
			
		}
		//For Retrieving Any Information from token we will need the sequnce
		private Claims getAllClaimsFromToken(String token)
		{
			
			return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		}
		//Check If the Token Has the Expired
		private Boolean isTokenExpired(String token)
		{
			final Date expiration=getExperationDateFromToken(token);
			return expiration.before(new Date()) ;
		}
		public String generateToken(UserDetails userDetails)
		{
			Map<String, Object> cliams=new HashMap<>();
			return doGenerateToken(cliams, userDetails.getUsername());
			
		}
		private String doGenerateToken(Map<String, Object> cliams,String subject)
		{
			
		  return Jwts.builder().setClaims(cliams).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis()+JWT_TOKEN_VALIDITY*1000)).setExpiration(null).signWith(SignatureAlgorithm.HS512, secret).compact();
		}
		public Boolean validateToken(String token,UserDetails userDetails)
		{
			final String userName=getUserNameFromToken(token);
			
			return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
		}
	
		
}





