package com.alkemy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alkemy.dao.IGeneroDAO;
import com.alkemy.entities.Genero;

@RestController
@RequestMapping("genero")
public class GeneroController {

	@Autowired
	private IGeneroDAO dao;
	
	@PostMapping
	public void agregarGenero(@RequestBody Genero genero) {
		
		
		dao.createGenero(genero);
		
	}
	
	@PatchMapping("{peliculaId}/{generoId}")
	public void agregarPelicula(@PathVariable Integer peliculaId,@PathVariable Integer generoId) {
		
		dao.agregarPelicula(peliculaId, generoId);
		
	}
	
	
}
