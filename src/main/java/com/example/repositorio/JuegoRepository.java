package com.example.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.modelo.Categoria;
import com.example.modelo.Editorial;
import com.example.modelo.Juego;



public interface JuegoRepository extends JpaRepository<Juego, Integer> {
	
	
	@Query("select p.juegoId from Juego p")
	public List<Integer> obtenerIds();
	
	@Query("select p from Juego p where p.categoria.categoriaId = ?1")
	public List<Juego> findByCategoriaId(Integer categoriaId);
	
	@Query("select p from Juego p where p.editorial.editorialId = ?1")
	public List<Juego> findByEditorialId(Integer editorialId);
	
	@Query("select count(p) from Juego p where p.categoria = ?1")
	public int findNumJuegosByCategoria(Categoria categoria);
	
	@Query("select count(p) from Juego p where p.editorial = ?1")
	public int findNumJuegosByEditorial(Editorial editorial);
	
	
	public List<Juego> findByCategoria(Categoria categoria);

	public List<Juego> findByEditorial(Editorial editorial);
	

}
