package com.example.main;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String index() {
		//podemos tramitar variable con requestparam..? o con PathVariable.
		return "index"; //si retorno ":redirect" me envia a este metodo
		
	}
	@GetMapping("/logine")
	public String login() {
		//podemos tramitar variable con requestparam..? o con PathVariable.
		return "login"; //si retorno ":redirect" me envia a este metodo
		
	}
	@GetMapping("/registration")
	public String register() {
		//podemos tramitar variable con requestparam..? o con PathVariable.
		return "registration"; //si retorno ":redirect" me envia a este metodo
		
	}
	
}
