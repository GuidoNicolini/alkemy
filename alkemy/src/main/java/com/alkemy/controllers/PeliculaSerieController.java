package com.alkemy.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alkemy.dao.IGeneroDAO;
import com.alkemy.dao.IPeliculaSerieDAO;
import com.alkemy.dto.PeliculaConsultaDTO;
import com.alkemy.dto.PeliculaDTO;
import com.alkemy.entities.PeliculaSerie;
import com.alkemy.service.PeliculaService;

@RestController
@RequestMapping("movies")
public class PeliculaSerieController {

	@Autowired
	private IPeliculaSerieDAO dao;
	
	@Autowired
	private IGeneroDAO daoGenero;

	@Autowired
	private PeliculaService pservice;

	@Transactional
	@GetMapping()
	public List<PeliculaConsultaDTO> getPersonajes(@RequestParam(required = false, defaultValue = "") String name,
			@RequestParam(required = false, defaultValue = "") String genre,
			@RequestParam(required = false, defaultValue = "") String order) {

		List<PeliculaSerie> listaPeliculas = dao.getPeliculas();
		List<PeliculaSerie> listaFinal = new ArrayList<>();
		
		if(!name.isEmpty()) {
			
			for(PeliculaSerie pelicula : listaPeliculas) {
				
				if(pelicula.getTitulo().equals(name)) {
					listaFinal.add(pelicula);
					
				}
			}
			
			return pservice.listaDTO(listaFinal);
		}
		
		if(!genre.isEmpty()) {
			
			Integer generoId = Integer.parseInt(genre);
			
			
			
			return pservice.listaDTO(daoGenero.listaPorGenero(generoId));
		}
		
		
		if(!order.isEmpty()) {
			
			
			
			return pservice.listaDTO(dao.getPeliculasOrdenadas(order));
			
		}
		
		return pservice.listaDTO(listaPeliculas);

	}

	@Transactional
	@PostMapping()
	public void createPelicula(@RequestBody PeliculaSerie pelicula) {

		dao.createPelicula(pelicula);
	}

	@Transactional
	@PatchMapping("{id}")
	public void editPelicula(@RequestBody PeliculaSerie pelicula, @PathVariable Integer id) {

		dao.editPelicula(pelicula, id);
	}

	@Transactional
	@DeleteMapping("{id}")
	public void deletePelicula(@PathVariable Integer id) {

		dao.deletePelicula(id);
	}

	@Transactional
	@GetMapping("detalle/{id}")
	public PeliculaDTO getPeliculaDetalle(@PathVariable Integer id) {

		PeliculaSerie peliOriginal = dao.getPeliculajeDetalle(id);
		
		PeliculaDTO peliAUX = new PeliculaDTO();
		
		
		peliAUX.setId(peliOriginal.getId());
		peliAUX.setLinkImagen(peliOriginal.getLinkImagen());
		peliAUX.setTitulo(peliOriginal.getTitulo());
		peliAUX.setFechaCreacion(peliOriginal.getFechaCreacion());
		peliAUX.setCalificacion(peliOriginal.getCalificacion());
		peliAUX.setPersonajes(peliOriginal.getPersonajes());
		
		
		return peliAUX;

	}
	
	@Transactional
	@PostMapping("{idMovie}/characters/{idCharacter}")
	public void agregarPersonajeAPelicula(@PathVariable Integer idMovie,@PathVariable Integer idCharacter) {
		
		dao.agregarPersonajeAPelicula(idMovie,idCharacter);
	}
	
	@Transactional
	@DeleteMapping("{idMovie}/characters/{idCharacter}")
	public void borrarPersonajeAPelicula(@PathVariable Integer idMovie,@PathVariable Integer idCharacter) {
		
		dao.borrarPersonajeAPelicula(idMovie, idCharacter);
	}
	
}
