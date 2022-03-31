package br.com.grupodois.desafioilab;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.grupodois.desafioilab.dto.DeliveryPersonLoginDTO;

@SpringBootTest
@AutoConfigureMockMvc
public class ApiTests {
	
	DeliveryPersonLoginDTO deliveryPerson = new DeliveryPersonLoginDTO();
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void shouldReturnOk_WhenLoginIsValid() throws Exception{
		
			
			deliveryPerson.setEmail("dagomir@mail.com");
			deliveryPerson.setPassword("12345678");
			
			String json = new ObjectMapper().writeValueAsString(deliveryPerson);
			mockMvc.perform(MockMvcRequestBuilders.post("/login")
					.content(json)
					.contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void ShouldReturnBadRequest_WhenLoginIsInvalid() throws Exception{
		deliveryPerson.setEmail("dagomir@mail.com");
		deliveryPerson.setPassword("1234");
		
		String json = new ObjectMapper().writeValueAsString(deliveryPerson);
		mockMvc.perform(MockMvcRequestBuilders.post("/login")
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
}
