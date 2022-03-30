package br.com.grupodois.desafioilab.service;

import br.com.grupodois.desafioilab.dto.DeliveryPersonLoginDTO;
import br.com.grupodois.desafioilab.model.DeliveryPerson;
import br.com.grupodois.desafioilab.security.Token;

public interface IDeliveryPerson {
	public Token generateUserToken(DeliveryPersonLoginDTO dadosLogin, DeliveryPerson user) throws Exception;
}
