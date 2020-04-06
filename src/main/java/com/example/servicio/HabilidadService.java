package com.example.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.modelo.Habilidad;
import com.example.repositorio.HabilidadRepository;

@Service
public class HabilidadService {

	
	@Autowired
	private HabilidadRepository repositorio;
	
	public List<Habilidad> findAll(){
		return repositorio.findAll();
	}
		
	public Habilidad findById(Integer id) {
		return repositorio.findById(id).orElse(null);
	}
	
	
}
