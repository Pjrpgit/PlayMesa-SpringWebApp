package com.example.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.modelo.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
	
	
	@Query("select c from Categoria c where c.destacada = true")
	public List<Categoria> findDestacadas();
	
	

}
