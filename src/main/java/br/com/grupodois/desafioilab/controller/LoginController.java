package br.com.grupodois.desafioilab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.grupodois.desafioilab.dao.DeliveryPersonDAO;
import br.com.grupodois.desafioilab.dto.DeliveryPersonLoginDTO;
import br.com.grupodois.desafioilab.model.DeliveryPerson;
import br.com.grupodois.desafioilab.security.Token;
import br.com.grupodois.desafioilab.services.IDeliveryPerson;

@RestController
@CrossOrigin("*")
public class LoginController {
	
	@Autowired
	private IDeliveryPerson service; 
	
	@Autowired 
	private DeliveryPersonDAO dao; 
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody DeliveryPersonLoginDTO loginData) throws Exception { 
		try { 
			DeliveryPerson user = dao.findByDpEmailOrDpPhone(loginData.getEmail(), loginData.getPhone());
	
			Token token = service.generateUserToken(loginData, user);
			return ResponseEntity.ok(token);
				
		} catch (Exception e) { 
			e.printStackTrace(System.out);
			return null;
		}
	}
}
