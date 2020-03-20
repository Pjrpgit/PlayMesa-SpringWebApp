package com.example.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.modelo.Juego;
import com.example.servicio.CategoriaService;
import com.example.servicio.JuegoService;



@Controller
public class MainController {
	
	private static final int NUM_JUEGOS_ALEATORIOS = 8;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private JuegoService juegoService;
	

//	@GetMapping("/login")
//	public String login() {
//		//podemos tramitar variable con requestparam..? o con PathVariable.
//		return "login"; //si retorno ":redirect" me envia a este metodo
//		
//	}
//	@GetMapping("/registration")
//	public String register() {
//		//podemos tramitar variable con requestparam..? o con PathVariable.
//		return "registration"; //si retorno ":redirect" me envia a este metodo
//		
//	}
	
	@GetMapping({"/","/index"})
	public String index(@RequestParam(name="idCategoria", required=false) Integer idCategoria, Model model) {		
		
		model.addAttribute("categorias", categoriaService.findAll());
		
		List<Juego> juegos;
		
		if (idCategoria == null) {
			juegos = juegoService.obtenerProductosAleatorios(NUM_JUEGOS_ALEATORIOS);
		} else {			
			juegos = juegoService.findAllByCategoria(idCategoria);
		}
		
		model.addAttribute("productos", juegos);
		
		return "index";
	}
	
	@GetMapping("/juego/{id}")
	public String showDetails(@PathVariable("id") Integer id, Model model) {
		Juego p = juegoService.findById(id);
		if (p != null) {
			model.addAttribute("juego", p);
			return "detail";
		}
		
		return "redirect:/";
		
	}
	
//	@GetMapping("/error")
//	public String errorTrace() {
//		return "error";
//	}
	
}
