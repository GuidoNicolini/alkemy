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

import com.alkemy.dao.IPersonajeDAO;
import com.alkemy.dto.PersonajeConsultaDTO;

import com.alkemy.entities.PeliculaSerie;
import com.alkemy.entities.Personaje;
import com.alkemy.service.PersonajeService;

@RestController
@RequestMapping("characters")
public class PersonajeController {

	@Autowired
	private IPersonajeDAO dao;

	@Autowired
	private PersonajeService pservice;

	@Transactional
	@GetMapping()
	public List<PersonajeConsultaDTO> getPersonajes(@RequestParam(required = false, defaultValue = "") String name,
			@RequestParam(required = false, defaultValue = "") String age,
			@RequestParam(required = false, defaultValue = "") String movies) {

		List<Personaje> listaPersonajes = dao.getPersonajes();
		List<Personaje> listaFinal = new ArrayList<>();

		if (!name.isEmpty()) {

			for (Personaje personaje : listaPersonajes) {
				if (personaje.getNombre().equals(name)) {
					listaFinal.add(personaje);
				}
			}

			return pservice.listaDTO(listaFinal);

		}

		if (!age.isEmpty()) {

			Integer edad = Integer.parseInt(age);

			for (Personaje personaje : listaPersonajes) {
				if (personaje.getEdad().equals(edad)) {
					listaFinal.add(personaje);
				}
			}
			return pservice.listaDTO(listaFinal);

		}

		if (!movies.isEmpty()) {

			for (Personaje personaje : listaPersonajes) {

				for (PeliculaSerie pelis : personaje.getPeliculaSeries()) {

					if (pelis.getTitulo().equals(movies)) {

						listaFinal.add(personaje);
					}

				}

			}
			return pservice.listaDTO(listaFinal);
		}

		return pservice.listaDTO(listaPersonajes);

	}

	@Transactional
	@PostMapping()
	public void createPersonaje(@RequestBody Personaje personaje) {

		dao.createPersonaje(personaje);
	}

	@Transactional
	@PatchMapping("{id}")
	public void editPersonaje(@RequestBody Personaje personaje, @PathVariable Integer id) {

		dao.editPersonaje(personaje, id);
	}

	@Transactional
	@DeleteMapping("{id}")
	public void deletePersonaje(@PathVariable Integer id) {

		dao.deletePersonaje(id);
	}

	@Transactional
	@GetMapping("detalle/{id}")
	public Personaje getPersonajeDetalle(@PathVariable Integer id) {

		return dao.getPersonajeDetalle(id);

	}
}
