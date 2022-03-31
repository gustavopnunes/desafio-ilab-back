package br.com.grupodois.desafioilab.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import br.com.grupodois.desafioilab.dto.OrdersDTO;
import br.com.grupodois.desafioilab.model.Orders;
import br.com.grupodois.desafioilab.model.enums.OrdersEnum;

public interface IOrdersService {
	public List<Orders> getOrderByStatus(@RequestParam(name = "status") String status, @RequestParam(name = "items") int items);
	public Orders getOrderById(Long id);
	public Orders updateOrder(Orders order, OrdersEnum status);
	public Orders createNewOrder(OrdersDTO newOrder);
}
