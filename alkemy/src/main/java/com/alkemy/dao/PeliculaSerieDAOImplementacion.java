package com.alkemy.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.alkemy.entities.PeliculaSerie;
import com.alkemy.entities.Personaje;

@Repository
@Transactional
public class PeliculaSerieDAOImplementacion implements IPeliculaSerieDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void createPelicula(PeliculaSerie pelicula) {
		em.persist(pelicula);

	}

	@Override
	public void editPelicula(PeliculaSerie pelicula, Integer id) {

		PeliculaSerie peliculaAUX = em.find(PeliculaSerie.class, id);

		peliculaAUX.setLinkImagen(pelicula.getLinkImagen());
		peliculaAUX.setTitulo(pelicula.getTitulo());
		peliculaAUX.setFechaCreacion(pelicula.getFechaCreacion());
		peliculaAUX.setCalificacion(pelicula.getCalificacion());

		em.merge(peliculaAUX);
	}

	@Override
	public void deletePelicula(Integer id) {
		em.remove(em.find(PeliculaSerie.class, id));

	}

	@Override
	public List<PeliculaSerie> getPeliculas() {

		String query = "FROM PeliculaSerie";
		List<PeliculaSerie> listaPeliculas = em.createQuery(query).getResultList();

		return listaPeliculas;
	}

	@Override
	public PeliculaSerie getPeliculajeDetalle(Integer id) {
		String query = "FROM PeliculaSerie a WHERE a.id=" + id;

		PeliculaSerie pelicula = (PeliculaSerie) em.createQuery(query).getSingleResult();

		return pelicula;
	}

	@Override
	public List<PeliculaSerie> getPeliculasOrdenadas(String ordenamiento) {

		String query = "FROM PeliculaSerie a ORDER BY a.fechaCreacion " + ordenamiento;
		List<PeliculaSerie> listaPeliculas = em.createQuery(query).getResultList();
		return listaPeliculas;
	}

	@Override
	public void agregarPersonajeAPelicula(Integer peliculaId, Integer personajeId) {

		String query = "INSERT INTO personaje_pelicula (personaje_id,pelicula_serie_id) VALUES " + "(" + personajeId
				+ "," + peliculaId + ")";
		em.createNativeQuery(query).executeUpdate();
	}

	@Override
	public void borrarPersonajeAPelicula(Integer peliculaId, Integer personajeId) {

		String query = "DELETE FROM personaje_pelicula WHERE personaje_id = " + personajeId + " AND "
				+ "pelicula_serie_id = " + peliculaId;
		em.createNativeQuery(query).executeUpdate();

	}

}
