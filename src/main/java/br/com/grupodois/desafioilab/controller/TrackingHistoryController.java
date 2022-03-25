package br.com.grupodois.desafioilab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.grupodois.desafioilab.dao.TrackingHistoryDAO;
import br.com.grupodois.desafioilab.model.TrackingHistory;
import br.com.grupodois.desafioilab.service.ITrackingHistoryService;

@RestController
@CrossOrigin("*")
@RequestMapping("/tracking-history")
public class TrackingHistoryController {
	
	@Autowired
	private ITrackingHistoryService service;
	
	@PostMapping
	 public ResponseEntity<?> createNewTrackingRecord(@RequestBody TrackingHistory newRecording) {
		try {
			newRecording = service.createTrackingRecord(newRecording);
			
			if (newRecording != null) {
				return ResponseEntity.status(201).body(newRecording);
			}
			
			return ResponseEntity.status(404).body("Dados inválidos.");
		} catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(500).body(ex.getMessage());
		}
	}
	
	@GetMapping("orders/{id}")
	public ResponseEntity<?> listTrackingHistory(@PathVariable Long id){
		List<TrackingHistory> res = service.listTrackingHistoryByOrder(id);
		
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.notFound().build();
	}
	
}
