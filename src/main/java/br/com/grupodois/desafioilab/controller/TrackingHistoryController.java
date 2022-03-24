package br.com.grupodois.desafioilab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.grupodois.desafioilab.model.TrackingHistory;
import br.com.grupodois.desafioilab.service.ITrackingHistoryService;

@RestController
@CrossOrigin("*")
@RequestMapping("/tracking-history")
public class TrackingHistoryController {
	
	@Autowired
	private ITrackingHistoryService service;
	
	@PostMapping()
	public String hello(){
	
		return "Hello";
	}
	
	@GetMapping()
	public ResponseEntity<?> listTrackingHistory(@RequestParam (name = "order-id")  Long id){
		TrackingHistory res = (TrackingHistory) service.listTrackingHistoryByOrder(id);
		
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.notFound().build();
	}
	
}
