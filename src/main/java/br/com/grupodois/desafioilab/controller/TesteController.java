package br.com.grupodois.desafioilab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.grupodois.desafioilab.dao.TesteDAO;
import br.com.grupodois.desafioilab.model.Teste;

@RestController
public class TesteController {
	
	@Autowired
	TesteDAO dao;
	
//	@RequestMapping
	
	@PostMapping("/teste")
	public ResponseEntity<?> addTrackingRecord(@RequestBody Teste newRecord) {
		Teste response = dao.save(newRecord);
		if (response != null) {
			return ResponseEntity.status(201).body(response);
		}
		return ResponseEntity.badRequest().build();
	}
}
