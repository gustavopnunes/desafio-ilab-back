package br.com.grupodois.desafioilab.services;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.grupodois.desafioilab.dao.DeliveryPersonDAO;
import br.com.grupodois.desafioilab.dto.DeliveryPersonLoginDTO;
import br.com.grupodois.desafioilab.model.DeliveryPerson;
import br.com.grupodois.desafioilab.security.SystemCrypto;
import br.com.grupodois.desafioilab.security.Token;
import br.com.grupodois.desafioilab.security.TokenUtil;

public class DeliveryPersonImpl implements IDeliveryPerson {
	
	@Autowired
	private DeliveryPersonDAO dao;
	
	@Override
	public Token generateUserToken(DeliveryPersonLoginDTO dadosLogin) {	
		try {
			System.out.println(dadosLogin);
			//get email or get phone!! 
			DeliveryPerson user = dao.findByEmailOrPhone(dadosLogin.getEmail(), dadosLogin.getPhone());
			
			if (user == null) { 
				return null;
			}
			
			String senhaCriptograda = SystemCrypto.encrypt(dadosLogin.getPassword());
			
			System.out.println(user.getDpPassword());
			System.out.println(senhaCriptograda);
			
			if (!user.getDpPassword().equals(senhaCriptograda)) { 
				return null; 
			}
			
			Token t = new Token(TokenUtil.createToken(user));
			return t;
			
		} catch (Exception e) {
			e.printStackTrace(System.out);
			return null;
		}
	}

}
