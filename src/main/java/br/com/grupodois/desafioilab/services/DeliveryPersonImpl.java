package br.com.grupodois.desafioilab.services;


import org.springframework.stereotype.Component;

import br.com.grupodois.desafioilab.dto.DeliveryPersonLoginDTO;
import br.com.grupodois.desafioilab.model.DeliveryPerson;
import br.com.grupodois.desafioilab.security.SystemCrypto;
import br.com.grupodois.desafioilab.security.Token;
import br.com.grupodois.desafioilab.security.TokenUtil;

@Component
public class DeliveryPersonImpl implements IDeliveryPerson {

	@Override
	public Token generateUserToken(DeliveryPersonLoginDTO loginData, DeliveryPerson user) throws Exception {	
		try {
			
			String encryptedPassword =  SystemCrypto.encrypt(loginData.getPassword());
			
			if (!user.getDpPassword().equals(encryptedPassword)) { 
				throw new Exception("Senha incorreta e tal");
			}
			
			return new Token(TokenUtil.createToken(user));
			
		} catch (Exception e) {
			e.printStackTrace(System.out);
			return null;
		}
	}

}