package br.com.grupodois.desafioilab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.grupodois.desafioilab.dao.OrdersDAO;
import br.com.grupodois.desafioilab.model.Orders;

@Component
public class OrdersImpl implements IOrdersService {
	@Autowired
	private OrdersDAO dao;

	@Override
	public List<Orders> getOrderByStatus(@RequestParam(name = "status") String status, @RequestParam(name = "items") int items) {
		Pageable firstPage = PageRequest.of(0, items);
		return dao.findAllByOrderStatus(status, firstPage);
	}

	@Override
	public Orders updateOrder(Orders updatedOrder) {
		return dao.save(updatedOrder);
	}
	
	
}
