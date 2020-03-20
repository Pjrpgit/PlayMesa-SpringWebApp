package com.example;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.modelo.Juego;
import com.example.repositorio.JuegoRepository;



@SpringBootApplication
public class PlayMesaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlayMesaApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner initData(JuegoRepository juegoRepository) {

		return args -> {

			// Rescatamos todos los productos
			List<Juego> juegos = juegoRepository.findAll();
			
//			Random r = new Random();
//
//			// Para cada uno de ellos
//			for (Producto p : productos) {
//				// Vamos a añadirle un número aleatorio de puntuaciones, entre 1 y 10
//				for (int i = 0; i < r.nextInt(10); i++)
//					// Lo valoramos con una puntuación aleatoria, entre 3 y 5.
//					p.addPuntuacion(new Puntuacion(3 + r.nextInt(2)));
//			}

			// Actualizamos los productos, almacenando así su puntuación
			juegoRepository.saveAll(juegos);

		};

	}
}
