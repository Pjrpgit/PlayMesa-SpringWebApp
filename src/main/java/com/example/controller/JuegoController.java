package com.example.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.modelo.Juego;
import com.example.servicio.CategoriaService;
import com.example.servicio.JuegoService;


@Controller
@RequestMapping("/admin/juego")
public class JuegoController {

	@Autowired
	private JuegoService juegoService;

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("juegos", juegoService.findAll());
		return "admin/list-juego";
	}

	@GetMapping("/nuevo")
	public String nuevoJuego(Model model) {
		model.addAttribute("juego", new Juego());
		model.addAttribute("categorias", categoriaService.findAll());
		return "admin/form-juego";
	}

	@PostMapping("/nuevo/submit")
	public String submitNuevoJuego(@Valid Juego juego, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("categorias", categoriaService.findAll());
			return "admin/form-juego";
		} else {
			juegoService.save(juego);
			return "redirect:/admin/juego/";

		}

	}

	@GetMapping("/editar/{id}")
	public String editarJuego(@PathVariable("id") Integer id, Model model) {

		Juego juego = juegoService.findById(id);

		if (juego != null) {
			model.addAttribute("juego", juego);
			model.addAttribute("categorias", categoriaService.findAll());
			return "admin/form-juego";
		} else {
			return "redirect:/admin/juego/";
		}

	}

	@GetMapping("/borrar/{id}")
	public String borrarJuego(@PathVariable("id") Integer id, Model model) {

		Juego juego = juegoService.findById(id);

		if (juego != null) {
			juegoService.delete(juego);
		}

		return "redirect:/admin/juego/";

	}

}

