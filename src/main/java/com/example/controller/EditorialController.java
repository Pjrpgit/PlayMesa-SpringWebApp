package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.modelo.Editorial;
import com.example.servicio.EditorialService;
import com.example.servicio.JuegoService;



@Controller
@RequestMapping("/admin/editorial")
public class EditorialController {

	@Autowired
	private EditorialService editorialService;
	
	@Autowired
	private JuegoService juegoService;
	
	@GetMapping({"/"})
	public String index(Model model) {
		model.addAttribute("editoriales", editorialService.findAll());
		return "admin/list-editorial";
	}
	
	@GetMapping("/nueva")
	public String nuevaEditorial(Model model) {
		model.addAttribute("editorial", new Editorial());
		return "admin/form-editorial";
	}
	
	@PostMapping("/nueva/submit")
	public String submitNuevaEditorial(@ModelAttribute("editorial") Editorial editorial, Model model) {
		
		editorialService.save(editorial);
		
		return "redirect:/admin/editorial/";
	}
	
	@GetMapping("/editar/{id}")
	public String editarEditorial(@PathVariable("id") Integer id, Model model) {
		
		Editorial editorial = editorialService.findById(id);
		
		if (editorial != null) {
			model.addAttribute("editorial", editorial);
			return "admin/form-editorial";
		} else {
			return "redirect:/admin/editorial/";
		}
		
	}
	
	@GetMapping("/borrar/{id}")
	public String borrarEditorial(@PathVariable("id") Integer id, Model model) {
		
		Editorial editorial = editorialService.findById(id);
		
		if (editorial != null) {
			
			if (juegoService.numeroJuegosEditorial(editorial) == 0) {
				editorialService.delete(editorial);				
			} else {
				return "redirect:/admin/editorial/?error=true";
			}
			
		} 

		return "redirect:/admin/editorial/";
		
		
	}
	

	
}
