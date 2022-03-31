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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.grupodois.desafioilab.dto.OrdersDTO;
import br.com.grupodois.desafioilab.model.Orders;
import br.com.grupodois.desafioilab.service.IOrdersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
@RequestMapping("/orders")
@Api(value = "Pedidos")
public class OrdersController {

	@Autowired
	public IOrdersService service;

	@ApiOperation(value = "Retorno dos Pedidos")
	@GetMapping
	public ResponseEntity<List<Orders>> getAllOrdersByStatus(@RequestParam(name = "status") String status, @RequestParam(name = "items") int items) {
		
    	List<Orders> response = service.getOrderByStatus(status.toUpperCase(), items);
    	if (response.size() != 0) {
    		return ResponseEntity.ok(response);
    	}
    	return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getOrderByid(@PathVariable Long id) {
		try {
			Orders res = service.getOrderById(id);
			if(res != null) {
				return ResponseEntity.status(200).body(res);
			}
			
			return ResponseEntity.status(404).body("Pedido não encontrado.");
			
		} catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(500).body(ex.getMessage());
		}
	}
	
	@PostMapping
	public ResponseEntity<Object> createNewOrder(@RequestBody OrdersDTO newOrder) {
		try {
			Orders order = service.createNewOrder(newOrder);

			if (order != null) {
				return ResponseEntity.status(201).body(order.toString());
			}

			return ResponseEntity.status(400).body("Dados inválidos.");
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(500).body(ex.getMessage());
		}
	}
}