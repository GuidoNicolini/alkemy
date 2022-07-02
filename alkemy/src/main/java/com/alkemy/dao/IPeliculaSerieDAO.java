package com.alkemy.dao;

import java.util.List;

import com.alkemy.entities.PeliculaSerie;
import com.alkemy.entities.Personaje;

public interface IPeliculaSerieDAO {

	public void createPelicula(PeliculaSerie pelicula);
	public void editPelicula(PeliculaSerie pelicula,Integer id);
	public void deletePelicula(Integer id);
	public List<PeliculaSerie> getPeliculas();
	public PeliculaSerie getPeliculajeDetalle(Integer id);
	public List<PeliculaSerie> getPeliculasOrdenadas(String ordenamiento);
	public void agregarPersonajeAPelicula(Integer peliculaId,Integer personajeId);
	public void borrarPersonajeAPelicula(Integer peliculaId,Integer personajeId);
}
