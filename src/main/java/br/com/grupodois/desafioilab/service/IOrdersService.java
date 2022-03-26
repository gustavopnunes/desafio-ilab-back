package br.com.grupodois.desafioilab.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import br.com.grupodois.desafioilab.model.Orders;

public interface IOrdersService {
	public List<Orders> getOrderByStatus(@RequestParam(name = "status") String status, @RequestParam(name = "items") int items);
	public Orders updateOrder(Orders updatedOrder);
}
