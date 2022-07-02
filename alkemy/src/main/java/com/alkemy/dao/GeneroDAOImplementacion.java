package com.alkemy.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.alkemy.entities.Genero;
import com.alkemy.entities.PeliculaSerie;

@Repository
@Transactional
public class GeneroDAOImplementacion implements IGeneroDAO{

	

	@PersistenceContext
	private EntityManager em;

	@Override
	public void createGenero(Genero genero) {
		
		em.persist(genero);
		
	}

	@Override
	public void agregarPelicula(Integer peliculaId, Integer generoId) {
		
		Genero g1 = em.find(Genero.class, generoId);
		PeliculaSerie ps = em.find(PeliculaSerie.class, peliculaId);
		
		
		g1.getPeliculaSeries().add(ps);
		
		em.merge(g1);
		
		
	}

	@Override
	public List<PeliculaSerie> listaPorGenero(Integer id) {
		
		return em.find(Genero.class, id).getPeliculaSeries();
	
	}

}
