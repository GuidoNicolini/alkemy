package com.alkemy.dao;

import java.util.List;

import com.alkemy.entities.Genero;
import com.alkemy.entities.PeliculaSerie;


public interface IGeneroDAO {

	
	public void createGenero(Genero genero);
	public void agregarPelicula(Integer peliculaId,Integer generoId);
	public List<PeliculaSerie> listaPorGenero(Integer id);
}
