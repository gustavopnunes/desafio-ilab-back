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
import br.com.grupodois.desafioilab.service.IDeliveryPerson;

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
			if ((loginData.getEmail() == null && loginData.getPhone() == null) || loginData.getPassword() == null) { 
				throw new IllegalArgumentException("Campos telefone/email e senha sao obrigatorios");
			}
			String email = loginData.getEmail() != null ? loginData.getEmail().toLowerCase() : null; 
			
			DeliveryPerson user = dao.findByDpEmailOrDpPhone(email, loginData.getPhone());
			
			if (user == null) {
				throw new IllegalArgumentException("Login e/ou senha incorretos"); 			 	
			}
			Token token = service.generateUserToken(loginData, user);
			return ResponseEntity.ok(token);
				
		} catch (IllegalArgumentException e) { 
			System.out.print(e.getStackTrace());
			return ResponseEntity.status(400).body(e.getMessage());
		} catch (Exception e) { 
			System.out.print(e.getStackTrace());
			return ResponseEntity.status(400).body("Nao foi possivel autenticar usuario");
		}
	}
}
