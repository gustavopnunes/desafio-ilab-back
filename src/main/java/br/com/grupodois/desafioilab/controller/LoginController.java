package br.com.grupodois.desafioilab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.grupodois.desafioilab.dao.DeliveryPersonDAO;
import br.com.grupodois.desafioilab.dto.DeliveryPersonLoginDTO;
import br.com.grupodois.desafioilab.model.DeliveryPerson;
import br.com.grupodois.desafioilab.services.IDeliveryPerson;

@RestController
public class LoginController {
	
	@Autowired
	private IDeliveryPerson service; 
	
	@Autowired 
	private DeliveryPersonDAO dao; 
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody DeliveryPersonLoginDTO loginData) { 
		DeliveryPerson user = dao.findByEmailOrPhone(null, null);
		System.out.print(user);

		service.generateUserToken(loginData);
		return ResponseEntity.ok("token");
	}
}
