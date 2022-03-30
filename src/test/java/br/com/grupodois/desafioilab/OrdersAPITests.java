package br.com.grupodois.desafioilab;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc 
public class OrdersAPITests {
	
	@Autowired
	private MockMvc mockMvc;
	

//	@Test
//    public void shouldReturnOrdersList() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/orders?{status=DELIVERED}&{items=1}"))
//               .andExpect(MockMvcResultMatchers.status().isOk())
//               .andDo(MockMvcResultHandlers.print());
//    }
	
	@Test
	public void shouldExistEndpoint() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/orders/1"))
		       .andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void shouldReturnValidOrder() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/orders/1"))
		       .andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void shouldReturnNotFoundStatus() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/orders/100"))
		       .andExpect(MockMvcResultMatchers.status().isNotFound());
		mockMvc.perform(MockMvcRequestBuilders.get("/orders/-1"))
	       .andExpect(MockMvcResultMatchers.status().isNotFound());
	}


}
