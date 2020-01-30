package talissonMelo.cursomc.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {

	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${jwt.expiration}")
	private Long expiration;
	
	public  String generateToken(String username) {
		return Jwts.builder() //GERANDO TOKEN 
				.setSubject(username)                                               //Usuario.
				.setExpiration(new Date(System.currentTimeMillis() + expiration))  //horario atual do sistema mais o expiration.
				.signWith(SignatureAlgorithm.HS512, secret.getBytes())            //Como assinar meu Token algoritimo e o segredo.
				.compact();														 //Finalizar 
	}
}
