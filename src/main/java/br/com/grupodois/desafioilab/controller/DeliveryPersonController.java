package br.com.grupodois.desafioilab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.grupodois.desafioilab.dao.DeliveryPersonDAO;
import br.com.grupodois.desafioilab.model.DeliveryPerson;

@RestController
public class DeliveryPersonController {
	@Autowired
	DeliveryPersonDAO dao; 
	
	@PostMapping("/register")
	public ResponseEntity<String> cadastrar(@RequestBody DeliveryPerson newUser) throws Exception { 
		try { 			
		dao.save(newUser);
		return ResponseEntity.ok("ok");
		} catch (Exception e) { 
			System.out.print(e.getStackTrace());
			return null;
		}
	}
}
