package br.com.grupodois.desafioilab;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.grupodois.desafioilab.model.DeliveryPerson;
import br.com.grupodois.desafioilab.model.TrackingStatus;
import br.com.grupodois.desafioilab.model.enums.TrackingStatusEnum;

@SpringBootTest
@AutoConfigureMockMvc
public class TrackingStatusAPITest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void shouldCreateTrackingStatus() throws Exception {
		
		DeliveryPerson dp = new DeliveryPerson();
		dp.setId((long)4);
		
		TrackingStatus trStatus = new TrackingStatus((long) 1, (long) 5, dp, TrackingStatusEnum.DELIVERED);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/tracking-status")
				.content(toJson(trStatus))
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
	}
	
	public static String toJson(final Object ob) {
		try {
			return new ObjectMapper().writeValueAsString(ob);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
}
