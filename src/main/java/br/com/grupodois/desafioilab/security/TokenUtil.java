package br.com.grupodois.desafioilab.security;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import br.com.grupodois.desafioilab.model.DeliveryPerson;



public class TokenUtil {
	
	private static final String HEADER = "Authorization"; 
	private static final String PREFIX = "Bearer "; 
	private static final String SECRET_KEY = "s3cr3t_k3y_fr0m_D3l1v3ry_P3rS0n_4uTh"; 
	private static final Algorithm ALGORITHM = Algorithm.HMAC256(SECRET_KEY);
	private static final String EMISSOR = "DeliveryApp";
	
	public static String createToken(DeliveryPerson user) { 
		try {
		    String token = JWT.create().withClaim("userId", user.getId())
		        .withIssuer(EMISSOR)
		        .sign(ALGORITHM);
		       
		    
		    return PREFIX + token;
		} catch (JWTCreationException exception){
			throw new JWTVerificationException(exception.getMessage());
		}	
	}
	
	public static Authentication validate(HttpServletRequest request) throws Exception {
		String token = request.getHeader(HEADER);
		token = token.replace(PREFIX, ""); 
		try {
		    JWTVerifier verifier = JWT.require(ALGORITHM)
		        .withIssuer(EMISSOR)
		        .build(); 
		    verifier.verify(token);
		    return new UsernamePasswordAuthenticationToken(null, null, Collections.emptyList());
		    
		} catch (JWTVerificationException exception){
			throw new JWTVerificationException(exception.getMessage()); 
		}
	}
}
