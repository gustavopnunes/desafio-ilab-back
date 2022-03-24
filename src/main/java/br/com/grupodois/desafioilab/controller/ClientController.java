package br.com.grupodois.desafioilab.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
	
	@GetMapping("client")
	public String teste() {
		return "teste";
	}
}
