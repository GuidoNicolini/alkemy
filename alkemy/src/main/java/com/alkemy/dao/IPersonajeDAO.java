package com.alkemy.dao;

import java.util.List;

import com.alkemy.dto.PersonajePeliculaDTO;
import com.alkemy.entities.Personaje;

public interface IPersonajeDAO {

	public void createPersonaje(Personaje personaje);
	public void editPersonaje(Personaje personaje,Integer id);
	public void deletePersonaje(Integer id);
	public List<Personaje> getPersonajes();
	public Personaje getPersonajeDetalle(Integer id);
	
}
