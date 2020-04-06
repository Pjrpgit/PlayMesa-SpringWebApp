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
import com.example.servicio.EditorialService;
import com.example.servicio.HabilidadService;
import com.example.servicio.JuegoService;



@Controller
public class MainController {
	
	private static final int NUM_JUEGOS_ALEATORIOS = 8;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private HabilidadService habilidadService;
	
	@Autowired
	private EditorialService editorialService;
	
	@Autowired
	private JuegoService juegoService;
	
	

	
	@GetMapping({"/","/index"})
	public String index(@RequestParam(name="idCategoria", required=false) Integer idCategoria,@RequestParam(name="idEditorial", required=false) Integer idEditorial, Model model) {		
		
		model.addAttribute("categorias", categoriaService.findAll());
		
		model.addAttribute("editoriales", editorialService.findAll());
		
		
		List<Juego> juegos;
		
		if (idCategoria == null) {
			juegos = juegoService.obtenerProductosAleatorios(NUM_JUEGOS_ALEATORIOS);
		} else {			
			juegos = juegoService.findAllByCategoria(idCategoria);
		}
		
		if (idEditorial == null) {
			juegos = juegoService.obtenerProductosAleatorios(NUM_JUEGOS_ALEATORIOS);
		} else {			
			juegos = juegoService.findAllByEditorial(idEditorial);
		}
		
		model.addAttribute("juegos", juegos);
		
		return "index";
	}
	
	@GetMapping("/juego/{juegoId}")
	public String showDetails(@PathVariable("juegoId") Integer id, Model model) {
		Juego p = juegoService.findById(id);
		if (p != null) {
			model.addAttribute("juego", p);
			return "detail";
		}
		
		return "redirect:/";
		
	}
	
	@GetMapping("/conocenos")
	public String showDetails() {
		
		return "conocenos";
		
	}
	
	@GetMapping("/habilidades")
	public String habilidades(Model model) {
		model.addAttribute("habilidades", habilidadService.findAll());
		return "list-habilidades";
	}
	
	
}
