package br.com.grupodois.desafioilab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
		
    	List<Orders> response = service.getOrderByStatus(status, items);
    	if (response.size() != 0) {
    		return ResponseEntity.ok(response);
    	}
    	return ResponseEntity.noContent().build();
	}

}
