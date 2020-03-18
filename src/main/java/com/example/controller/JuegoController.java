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
@RequestMapping("/admin/producto")
public class JuegoController {

	@Autowired
	private JuegoService juegoService;

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("productos", juegoService.findAll());
		return "admin/list-producto";
	}

	@GetMapping("/nuevo")
	public String nuevaProducto(Model model) {
		model.addAttribute("producto", new Juego());
		model.addAttribute("categorias", categoriaService.findAll());
		return "admin/form-producto";
	}

	@PostMapping("/nuevo/submit")
	public String submitNuevoProducto(@Valid Juego juego, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("categorias", categoriaService.findAll());
			return "admin/form-producto";
		} else {
			juegoService.save(juego);
			return "redirect:/admin/producto/";

		}

	}

	@GetMapping("/editar/{id}")
	public String editarProducto(@PathVariable("id") Integer id, Model model) {

		Juego producto = juegoService.findById(id);

		if (producto != null) {
			model.addAttribute("producto", producto);
			model.addAttribute("categorias", categoriaService.findAll());
			return "admin/form-producto";
		} else {
			return "redirect:/admin/producto/";
		}

	}

	@GetMapping("/borrar/{id}")
	public String borrarProducto(@PathVariable("id") Integer id, Model model) {

		Juego juego = juegoService.findById(id);

		if (juego != null) {
			juegoService.delete(juego);
		}

		return "redirect:/admin/producto/";

	}

}

