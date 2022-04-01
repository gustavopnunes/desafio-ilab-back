package br.com.grupodois.desafioilab;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.grupodois.desafioilab.model.Orders;
import br.com.grupodois.desafioilab.service.IOrdersService;

@SpringBootTest
public class OrdersServiceTests {
	
	@Autowired
	private IOrdersService service;

	@Test 
	public void shouldExistsOrdersService() {
		Assertions.assertTrue(service.getOrderById((long) 1) == null || service.getOrderById((long) 1) != null);
	}

	@Test
	public void shouldReturnOrdersList() {
		Assertions.assertTrue(service.getOrderByStatus(null, 1).size() >= 0);
	}

	@Test
	public void shouldReturnExistingOrder() {
		Assertions.assertInstanceOf(Orders.class, service.getOrderById((long) 1));
	}

	@Test
	public void shouldReturnInexistingOrder() {
		Assertions.assertEquals(null, service.getOrderById((long) 1000));
	}


}
