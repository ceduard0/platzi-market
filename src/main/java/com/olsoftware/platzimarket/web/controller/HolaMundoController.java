package com.olsoftware.platzimarket.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saludar")
public class HolaMundoController {
	
	@GetMapping("/hola")
	public String getSaludo() {
		return "Nunca pares de aprender ! ";
	}
	
	
}
