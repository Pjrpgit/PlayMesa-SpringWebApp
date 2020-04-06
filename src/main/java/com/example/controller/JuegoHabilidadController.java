package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.modelo.Juego;
import com.example.modelo.JuegoHabilidad;
import com.example.servicio.HabilidadService;
import com.example.servicio.JuegoHabilidadService;
import com.example.servicio.JuegoService;

@Controller
@RequestMapping("/admin/juegohabilidad")
public class JuegoHabilidadController {

	@Autowired
	private JuegoHabilidadService juegoHabilidadService;
	
	@Autowired
	private JuegoService juegoService;
	
	@Autowired
	private HabilidadService habilidadService;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("juegohabilidades", juegoHabilidadService.findAll());
		return "admin/list-juegohabilidad";
	}
	
	@GetMapping("/nueva/{id}")
	public String nuevaJuegoHabilidad(@PathVariable("id") Integer id,Model model) {
		model.addAttribute("juego", juegoService.findById(id));
		model.addAttribute("juegohabilidad", new JuegoHabilidad((Juego)model.getAttribute("juego")));
		model.addAttribute("habilidades", habilidadService.findAll());
		return "admin/form-juegohabilidad";
	}
	
	@PostMapping("/nueva/submit")
	public String submitNuevaJuegoHabilidad(@ModelAttribute("juegohabilidad") JuegoHabilidad juegoHabilidad, Model model) {

		juegoHabilidadService.save(juegoHabilidad);		
		return "redirect:/admin/juegohabilidad/";
	}
	
	@GetMapping("/editar/{id}")
	public String editarJuegoHabilidad(@PathVariable("id") Integer id, Model model) {
		
		JuegoHabilidad juegohabilidad = juegoHabilidadService.findById(id);
		model.addAttribute("juego", juegoService.findById(id));
		model.addAttribute("habilidades", habilidadService.findAll());
		
		if (juegohabilidad != null) {
			model.addAttribute("juegohabilidad", juegohabilidad);
			return "admin/form-juegohabilidad";
		} else {
			return "redirect:/admin/juegohabilidad/";
		}
		
	}
	
	@GetMapping("/borrar/{id}")
	public String borrarJuegoHabilidad(@PathVariable("id") Integer id, Model model) {
		
		JuegoHabilidad juegoHabilidad = juegoHabilidadService.findById(id);

		if (juegoHabilidad != null) {
			juegoHabilidadService.delete(juegoHabilidad);
		}

		return "redirect:/admin/juegohabilidad/";
				
	}
	
}
