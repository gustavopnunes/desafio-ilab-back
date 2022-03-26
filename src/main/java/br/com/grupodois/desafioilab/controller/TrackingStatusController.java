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

import br.com.grupodois.desafioilab.dto.TrackingStatusUpdateDTO;
import br.com.grupodois.desafioilab.model.Orders;
import br.com.grupodois.desafioilab.model.TrackingStatus;
import br.com.grupodois.desafioilab.model.enums.TrackingStatusEnum;
import br.com.grupodois.desafioilab.service.IOrdersService;
import br.com.grupodois.desafioilab.service.ITrackingStatusService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "tracking-status")
public class TrackingStatusController {

	@Autowired
	private ITrackingStatusService service;

	@Autowired
	private IOrdersService ordersService;
	
	@Autowired
	public IOrdersService orderService;
	
	@PostMapping
	public ResponseEntity<?> createTrackingStatus (@RequestBody TrackingStatus novo) {
		try {
			Long orderId = novo.getOrder().getId();
			Orders order = orderService.getOrderById(orderId);
			
			if (order != null) {
				if (order.getOrderStatus().toLowerCase().equals("aberto")) {

					order = orderService.updateOrder(order, "Em andamento");
					
					novo = service.createTrackingStatus(novo);
					
					if (novo != null) {
						return ResponseEntity.status(201).body(novo);
					}
					
					return ResponseEntity.status(404).body("Dados inválidos.");
				}
				return ResponseEntity.status(404).body("Pedido: "+ orderId + " não está disponível para entrega.");
			}
			return ResponseEntity.status(404).body("Produto: " + orderId + " não encontrado.");
		} catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(500).body(ex.getMessage());
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateTrackingStatus (@PathVariable Long id, @RequestBody TrackingStatusUpdateDTO statusString) {
		try { 
			TrackingStatusEnum status = TrackingStatusEnum.valueOf(statusString.getStatus());  
			
			TrackingStatus ts = service.getTrackingStatusById(id);
			ts.setStatus(status);
			service.updateTrackingStatus(ts);
			
			if (status.getCode() == 1) { 
				Orders order = ts.getOrder();
				
				order.setOrderStatus("entregue");
				ordersService.updateOrder(order);
			}
		
			return ResponseEntity.status(200).body(null);
		} catch(Exception e) { 
			return ResponseEntity.status(400).body("Não foi possível atualizar o status do pedido");
		}
	}
}
