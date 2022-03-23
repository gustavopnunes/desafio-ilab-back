package br.com.grupodois.desafioilab.security;

import java.security.Key;
import java.util.Collections;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import br.com.grupodois.desafioilab.model.DeliveryPerson;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;



public class TokenUtil {
	
	private static final String HEADER = "Authorization"; 
	private static final String PREFIX = "Bearer "; 
	private static final long EXPIRATION = 20*60*1000; //20 minutes
	private static final String SECRET_KEY = "s3cr3t_k3y_fr0m_D3l1v3ry_P3rS0n_4uTh"; 
	private static final String EMISSOR = "DeliveryPersonUser";
	
	public static String createToken(DeliveryPerson user) { 
		Key secretKey = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
		String token = Jwts.builder().setSubject(user.getDpEmail())
									 .setIssuer(EMISSOR) 
									 .setExpiration(new Date(System.currentTimeMillis()+EXPIRATION))
									 .signWith(secretKey, SignatureAlgorithm.HS256)
								     .compact();
		System.out.println("TOKEN gerado = "+token);
		
		return PREFIX + token;
	}
	
	private static boolean isExpirationValid(Date expiration) { 
		return expiration.after(new Date(System.currentTimeMillis())); 
	}
	private static boolean isEmissorValid(String emissor) { 
		return emissor.equals(EMISSOR);
	}
	private static boolean isSubjectValid(String username) { 
		return username !=null && username.length() > 0 ;
	}
	
	public static Authentication validate(HttpServletRequest request) {
		String token = request.getHeader(HEADER);
		token = token.replace(PREFIX, ""); 
		
		Jws<Claims> jwsClaims = Jwts.parserBuilder().setSigningKey(SECRET_KEY.getBytes())
													.build()
													.parseClaimsJws(token);
		
		String email = jwsClaims.getBody().getSubject(); 
		String issuer = jwsClaims.getBody().getIssuer(); 
		Date expiration = jwsClaims.getBody().getExpiration(); 
		
		if(isSubjectValid(email) && isEmissorValid(issuer) && isExpirationValid(expiration)) { 
			return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
		}
		
		return null;
	}
}
