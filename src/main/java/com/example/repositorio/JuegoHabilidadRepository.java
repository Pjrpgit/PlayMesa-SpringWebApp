package com.example.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.modelo.Habilidad;
import com.example.modelo.Juego;
import com.example.modelo.JuegoHabilidad;

public interface JuegoHabilidadRepository extends JpaRepository<JuegoHabilidad,Integer> {

	@Query("select count(p) from JuegoHabilidad p where p.habilidadId = ?1")
	int findNumJuegosByHabilidad(Habilidad habilidad);
	
	@Query("select count(p) from JuegoHabilidad p where p.juegoId = ?1")
	int findNumHabilidadesByJuego(Juego juego);
	
	@Query("select p from JuegoHabilidad p where p.juegoId = ?1")
	List<JuegoHabilidad> findHabilidadesByJuego(Juego juegoId);
	
	@Query("select p from JuegoHabilidad p where p.habilidadId = ?1")
	List<JuegoHabilidad> findHabilidadesByHabilidad(Habilidad habilidadId);
	
//	@Query("select p from JuegoHabilidad p where p.categoria.id = ?1")
//	public List<Producto> findByCategoriaId(Long categoriaId);

}
