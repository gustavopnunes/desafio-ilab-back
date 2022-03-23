package br.com.grupodois.desafioilab.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.grupodois.desafioilab.model.DeliveryPerson;

public interface DeliveryPersonDAO extends CrudRepository<DeliveryPerson, Integer>{

	DeliveryPerson findByEmailOrPhone(String email, String email2);
	//by email or phone

}
