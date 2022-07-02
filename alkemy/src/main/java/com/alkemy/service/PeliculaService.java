package com.alkemy.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.alkemy.dto.PeliculaConsultaDTO;

import com.alkemy.entities.PeliculaSerie;

@Service
public class PeliculaService {

	public List<PeliculaConsultaDTO> listaDTO(List<PeliculaSerie> peliculas) {

		List<PeliculaConsultaDTO> listaDTO = new ArrayList<>();

		for (PeliculaSerie pelicula : peliculas) {

			PeliculaConsultaDTO peliculaAUX = new PeliculaConsultaDTO();

			peliculaAUX.setLinkImagen(pelicula.getLinkImagen());
			peliculaAUX.setTitulo(pelicula.getTitulo());
			peliculaAUX.setFechaCreacion(pelicula.getFechaCreacion());

			listaDTO.add(peliculaAUX);
		}

		return listaDTO;
	}
	
	
}
