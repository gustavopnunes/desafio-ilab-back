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

import br.com.grupodois.desafioilab.model.TrackingHistory;
import br.com.grupodois.desafioilab.service.ITrackingHistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin("*")
@RequestMapping("/tracking-history")
@Api(value = "Histórico de Localização")
public class TrackingHistoryController {

	@Autowired
	private ITrackingHistoryService service;

	@ApiOperation(value = "Criação do Histórico de Localização")
	@ApiResponses(value = {
		    @ApiResponse(code = 201, message = "Criação de Histórico de Localização realizado com sucesso."),
		    @ApiResponse(code = 403, message = "Para acessar este recurso um token de autenticação válido deve ser enviado.")})
	@PostMapping
	public ResponseEntity<?> createNewTrackingRecord(@RequestBody TrackingHistory newRecording) {
		try {
			newRecording = service.createTrackingRecord(newRecording);

			if (newRecording != null) {
				return ResponseEntity.status(201).body(newRecording);
			}

			return ResponseEntity.status(404).body("Dados inválidos.");
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(500).body(ex.getMessage());
		}
	}

	@ApiOperation(value = "Retorno do Histórico de Localização por Pedido")
	@GetMapping("orders/{id}")
	public ResponseEntity<?> listTrackingHistory(@PathVariable Long id) {
		try {
			List<TrackingHistory> res = service.listTrackingHistoryByOrder(id);

			if (res != null) {
				return ResponseEntity.ok(res);
			}
			return ResponseEntity.notFound().build();
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(500).body(ex.getMessage());
		}

	}

}
