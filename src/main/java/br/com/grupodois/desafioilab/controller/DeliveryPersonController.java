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
	public ResponseEntity<String> register(@RequestBody DeliveryPerson newUser) throws Exception { 
		try { 
			if (newUser.getDpEmail() == null || newUser.getDpCpf() == null || newUser.getDpPhone() == null || newUser.getDpName() == null || newUser.getDpPassword() == null) { 
				throw new IllegalArgumentException();
			}
			newUser.setDpEmail(newUser.getDpEmail().toLowerCase());
			newUser.setDpPassword(SystemCrypto.encrypt(newUser.getDpPassword()));
			dao.save(newUser);
			return ResponseEntity.status(201).body("Cadastro realizado com sucesso!");
			
		} catch (IllegalArgumentException e) { 
			System.out.print(e.getStackTrace());
			return ResponseEntity.status(400).body("Campos nome, email, telefone, cpf e senha sao obrigatorios.");
		} catch (Exception e) { 
			System.out.print(e.getStackTrace());
			return ResponseEntity.status(400).body("Nao foi possivel realizar o cadastro.");
		}
	}
	@GetMapping("/ping")
	public String AuthTest() { 
		return "Pong";
	}
}