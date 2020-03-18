package com.joblesstudio.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.modelo.Categoria;
import com.example.modelo.Juego;



public interface JuegoRepository extends JpaRepository<Juego, Long> {
	
	public List<Juego> findByCategoria(Categoria categoria);
	
	@Query("select p.juego_id from Juego p")
	public List<Long> obtenerIds();
	
	@Query("select p from Juego p where p.categoria.categoria_id = ?1")
	public List<Juego> findByCategoriaId(Categoria categoriaId);
	
	@Query("select count(p) from Juego p where p.categoria = ?1")
	public int findNumProductosByCategoria(Categoria categoria);
	
	

}
