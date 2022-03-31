package br.com.grupodois.desafioilab;


import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.grupodois.desafioilab.service.ITrackingStatusService;

@SpringBootTest
public class TrackingStatusService {

	@Autowired
	private ITrackingStatusService service;
	
	public void showldThrowExceptionDeIdInvalido() {
		Assertions.assertThrows(java.lang.RuntimeException.class, () -> {
			service.getTrackingStatusById((long) -1);
		});
	}
}
