package com.example.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;


import com.example.modelo.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
	
	
	
}
