package br.com.grupodois.desafioilab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.grupodois.desafioilab.dao.OrdersDAO;
import br.com.grupodois.desafioilab.model.Orders;

@RestController
public class OrdersController {

  @Autowired
  private OrdersDAO dao;

  @GetMapping("/orders")
	public List<Orders> getOrderByStatus(@RequestParam(name = "status") String status, @RequestParam(name = "items") int items) {
    Pageable firstPage = PageRequest.of(0, items);
		return dao.findByOrderStatus(status, firstPage);
	}


}
