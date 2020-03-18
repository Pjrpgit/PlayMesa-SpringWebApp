package com.example.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.modelo.Categoria;
import com.example.modelo.Juego;



public interface JuegoRepository extends JpaRepository<Juego, Integer> {
	
	
	@Query("select p.id from Producto p")
	public List<Integer> obtenerIds();
	
	@Query("select p from Producto p where p.categoria.id = ?1")
	public List<Juego> findByCategoriaId(Integer categoriaId);
	
	@Query("select count(p) from Producto p where p.categoria = ?1")
	public int findNumProductosByCategoria(Categoria categoria);

	public List<Juego> findByCategoria(Categoria categoria);


	

}
