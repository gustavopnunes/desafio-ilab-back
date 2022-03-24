package br.com.grupodois.desafioilab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.grupodois.desafioilab.model.TrackingStatus;
import br.com.grupodois.desafioilab.service.ITrackingStatusService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "tracking-status")
public class TrackingStatusController {

	@Autowired
	private ITrackingStatusService service;
	
	@PostMapping
	public ResponseEntity<?> createTrackingStatus (@RequestBody TrackingStatus novo) {
		try {
			novo = service.createTrackingStatus(novo);
			
			if (novo != null) {
				return ResponseEntity.status(201).body(novo);
			}
			
			return ResponseEntity.status(404).body("Dados inválidos.");
		} catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(500).body(ex.getMessage());
		}
	}
}
