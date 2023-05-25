package it.develhope.Unit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.develhope.Unit.Test.controllers.UtenteController;
import it.develhope.Unit.Test.entities.Utente;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class UnitTestApplicationTests {

	@Autowired
	private UtenteController utenteController;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;


	@Test
	void contextLoads() {
		assertThat(utenteController).isNotNull();
	}


	@Test
	public void getAll() throws Exception {
		this.mockMvc.perform(get("/users")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void getSingle() throws Exception {
		this.mockMvc.perform(get("/users/1")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void create() throws Exception {
		Utente utente = new Utente(1L, "Alessio", "Limina");
		String utenteJSON = objectMapper.writeValueAsString(utente);
		this.mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON).content(utenteJSON)).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void update() throws Exception {
		Utente utente = new Utente(1L, "Alessio", "Limina");
		String utenteJson = objectMapper.writeValueAsString(utente);
		this.mockMvc.perform(put("/users/Gianni").contentType(MediaType.APPLICATION_JSON).content(utenteJson)).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void deleteUser() throws Exception {
		this.mockMvc.perform(delete("/users")).andDo(print()).andExpect(status().isOk());
	}

}
