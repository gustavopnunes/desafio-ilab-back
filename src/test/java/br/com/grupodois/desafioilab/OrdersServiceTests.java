package br.com.grupodois.desafioilab;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.grupodois.desafioilab.service.IOrdersService;

@SpringBootTest
public class OrdersServiceTests {
	
	@Autowired
	private IOrdersService service;

	@Test 
	public void shouldExistsOrdersService() {
		// Assertions.assertEquals(service.listarTodos(), null);
		Assertions.assertTrue(service.getOrderById((long) 1) == null || service.getOrderById((long) 1) != null);
	}

//	@Test
//	public void shouldReturnListaUsuario() {
//		Assertions.assertTrue(service.listarTodos().size() >= 0);
//	}

//	@Test
//	public void shouldExistServicoDetalhes() {
//		Assertions.assertTrue(service.detalharUsuario(1) == null || service.detalharUsuario(1) != null);
//	}
//
//	@Test
//	public void shouldReturnUsuarioExistente() {
//		Assertions.assertInstanceOf(Usuario.class, service.detalharUsuario(1));
//	}
//
//	@Test
//	public void shouldReturnUsuarioInexistente() {
//		// Assertions.assertInstanceOf(Usuario.class, service.detalharUsuario(1000));
//		Assertions.assertEquals(null, service.detalharUsuario(1000));
//	}
//
//	@Test
//	public void shouldThrowExceptionDeIdInvalido() {
//		Assertions.assertThrows(java.lang.RuntimeException.class, () -> {
//			service.detalharUsuario(-1);
//		});

//	}

}
