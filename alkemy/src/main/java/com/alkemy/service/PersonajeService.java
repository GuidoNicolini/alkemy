package com.alkemy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.alkemy.dto.PersonajeConsultaDTO;
import com.alkemy.entities.Personaje;


@Service
public class PersonajeService {

	public List<PersonajeConsultaDTO> listaDTO(List<Personaje> personajes){
		
		List<PersonajeConsultaDTO> listaDTO = new ArrayList<>();
		
		for (Personaje personaje : personajes) {
			
			PersonajeConsultaDTO personajeAUX = new PersonajeConsultaDTO();
			
			personajeAUX.setLinkImagen(personaje.getLinkImagen());
			personajeAUX.setNombre(personaje.getNombre());
			
			listaDTO.add(personajeAUX);
		}
		
		return listaDTO;
	}
	
}
