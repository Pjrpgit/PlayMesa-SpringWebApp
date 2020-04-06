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

			// Rescatamos todos los juegos
			List<Juego> juegos = juegoRepository.findAll();
			
			juegoRepository.saveAll(juegos);

		};

	}
}
