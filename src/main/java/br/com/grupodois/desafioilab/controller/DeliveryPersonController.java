package br.com.grupodois.desafioilab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.grupodois.desafioilab.dao.DeliveryPersonDAO;
import br.com.grupodois.desafioilab.model.DeliveryPerson;
import br.com.grupodois.desafioilab.security.SystemCrypto;

@RestController
@CrossOrigin("*")
public class DeliveryPersonController {
	@Autowired
	DeliveryPersonDAO dao; 
	
	@PostMapping("/register")
	public ResponseEntity<String> cadastrar(@RequestBody DeliveryPerson newUser) throws Exception { 
		try { 
			newUser.setDpPassword(SystemCrypto.encrypt(newUser.getDpPassword()));
			
		dao.save(newUser);
		return ResponseEntity.ok("Show show cadastro top");
		} catch (Exception e) { 
			System.out.print(e.getStackTrace());
			return null;
		}
	}
	@GetMapping("/ping")
	public String AuthTest() { 
		return "Pong";
	}
}