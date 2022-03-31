package br.com.grupodois.desafioilab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.grupodois.desafioilab.dao.ClientDAO;
import br.com.grupodois.desafioilab.dao.OrdersDAO;
import br.com.grupodois.desafioilab.dto.OrdersDTO;
import br.com.grupodois.desafioilab.model.Client;
import br.com.grupodois.desafioilab.model.Orders;

@Component
public class OrdersImpl implements IOrdersService {
	
	@Autowired
	private OrdersDAO ordersDao;
	
	@Autowired
	private ClientDAO clientDao;

	@Override
	public List<Orders> getOrderByStatus(@RequestParam(name = "status") String status, @RequestParam(name = "items") int items) {
		Pageable firstPage = PageRequest.of(0, items);
		return ordersDao.findAllByOrderStatus(status, firstPage);
	}
	
	@Override
	public Orders getOrderById(Long id) {
		try {
			return ordersDao.findById(id);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public Orders updateOrder(Orders order, String status) {
		try {
			order.setOrderStatus(status);
			return ordersDao.save(order);
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}


	@Override
	public Orders createNewOrder(OrdersDTO newOrder) {
		try {
			Client client = clientDao.getById(newOrder.getClientId());
			
			Orders order = new Orders();
			order.setId(newOrder.getId());
			order.setClientId(client);
			order.setOrderDate(newOrder.getOrderDate());
			order.setOrderStatus(newOrder.getOrderStatus());
			order.setOrderValue(newOrder.getOrderValue());

			return ordersDao.save(order);
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
