package com.example.servicio;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.modelo.Categoria;
import com.example.modelo.Juego;
import com.example.repositorio.JuegoRepository;

@Service
public class JuegoService {
	
	@Autowired
	private JuegoRepository repositorio;
	
	public List<Juego> findAll() {
		return repositorio.findAll();
	}
	
	public List<Juego> findAllByCategoria(Categoria categoria) {
		return repositorio.findByCategoria(categoria);
	}
	
	public List<Juego> findAllByCategoria(Integer categoriaId) {
		return repositorio.findByCategoriaId(categoriaId);
	}
	
	public Juego findById(Integer id) {
		return repositorio.findById(id).orElse(null);
	}
	
	public Juego save(Juego juego) {
		return repositorio.save(juego);
	}
	
	public Juego delete(Juego juego) {
		Juego result = findById(juego.getJuegoId());
		repositorio.delete(result);
		return result;
	}
	
	public int numeroProductosCategoria(Categoria categoria) {
		return repositorio.findNumProductosByCategoria(categoria);
	}
	
	

	public List<Juego> obtenerProductosAleatorios(int numero) {
		// Obtenemos los ids de todos los productos
		List<Integer> listaIds = repositorio.obtenerIds();
		// Los desordenamos 
		Collections.shuffle(listaIds);
		// Nos quedamos con los N primeros, con N = numero.
		listaIds = listaIds.stream().limit(numero).collect(Collectors.toList());
		// Buscamos los productos con esos IDs y devolvemos la lista
		return repositorio.findAllById(listaIds);

	}
	

}

