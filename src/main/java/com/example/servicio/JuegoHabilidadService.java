package com.example.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.modelo.Habilidad;
import com.example.modelo.Juego;
import com.example.modelo.JuegoHabilidad;
import com.example.repositorio.JuegoHabilidadRepository;

@Service
public class JuegoHabilidadService {

	@Autowired
	private JuegoHabilidadRepository repositorio;
	
	
	public List<JuegoHabilidad> findAll() {
		return repositorio.findAll();
	}	
	
	
	public JuegoHabilidad save(JuegoHabilidad juegoHabilidad) {
		return repositorio.save(juegoHabilidad);
	}
	
	public JuegoHabilidad findById(Integer id) {
		return repositorio.findById(id).orElse(null);
	}
	
	public List<JuegoHabilidad> findByJuegoId(Juego juegoId) {
		return repositorio.findHabilidadesByJuego(juegoId);
	}
	
	public List<JuegoHabilidad> findByHabilidadId(Habilidad habilidadId) {
		return repositorio.findHabilidadesByHabilidad(habilidadId);
	}
	
	public JuegoHabilidad delete(JuegoHabilidad juegoHabilidad) {
		JuegoHabilidad result = findById(juegoHabilidad.getRelacionId());
		repositorio.delete(result);
		return result;
	}
	
	public int numeroJuegosHabilidad(Habilidad habilidad) {
		return repositorio.findNumJuegosByHabilidad(habilidad);
	}
	
	public int numeroHabilidadJuego(Juego juego) {
		return repositorio.findNumHabilidadesByJuego(juego);
	}
}
