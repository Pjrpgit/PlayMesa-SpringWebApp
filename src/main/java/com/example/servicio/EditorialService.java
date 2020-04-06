package com.example.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.modelo.Editorial;
import com.example.repositorio.EditorialRepository;

@Service
public class EditorialService {

	@Autowired
	private EditorialRepository repositorio;
	
	public List<Editorial> findAll() {
		return repositorio.findAll();
	}	
	
	
	public Editorial save(Editorial editorial) {
		return repositorio.save(editorial);
	}
	
	public Editorial findById(Integer id) {
		return repositorio.findById(id).orElse(null);
	}
	
	public Editorial delete(Editorial editorial) {
		Editorial result = findById(editorial.getEditorialId());
		repositorio.delete(result);
		return result;
	}
	
	
}
