package br.com.grupodois.desafioilab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.grupodois.desafioilab.dto.RequestTrackingStatusDTO;
import br.com.grupodois.desafioilab.dto.ResponseTrackingStatusDTO;
import br.com.grupodois.desafioilab.dto.TrackingStatusUpdateDTO;
import br.com.grupodois.desafioilab.exceptions.CustomException;
import br.com.grupodois.desafioilab.model.TrackingStatus;
import br.com.grupodois.desafioilab.service.IOrdersService;
import br.com.grupodois.desafioilab.service.ITrackingStatusService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "tracking-status")
@Api(value = "Rastreio")
public class TrackingStatusController {

	@Autowired
	private ITrackingStatusService service;

	@Autowired
	public IOrdersService orderService;
	
	@ApiOperation(value = "Criação do Rastreio de um Produto")
	@PostMapping
	public ResponseEntity<?> createTrackingStatus (@RequestBody RequestTrackingStatusDTO novo) {
		try {
			TrackingStatus newTrackingStatus = service.createTrackingStatus(novo);
			return ResponseEntity.status(201).body(ResponseTrackingStatusDTO.fromTrackingStatus(newTrackingStatus));
					
		} catch(CustomException exception) {
			exception.printStackTrace();
			return ResponseEntity.status(exception.getStatusCode()).body(exception.getMessage());

		} catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(500).body(ex.getMessage());
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateTrackingStatus (@PathVariable Long id, @RequestBody TrackingStatusUpdateDTO status) {
		try {
			service.updateTrackingStatus(status, id);
			return ResponseEntity.status(200).body("Status atualizado com sucesso!");
		} catch(CustomException ex) {
			ex.printStackTrace();
			return ResponseEntity.status(ex.getStatusCode()).body(ex.getMessage());
		} catch(Exception e) { 
			e.printStackTrace();
			return ResponseEntity.status(500).body("Não foi possível atualizar o status do pedido.");
		}
	}
}
