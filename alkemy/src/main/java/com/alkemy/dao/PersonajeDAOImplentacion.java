package com.alkemy.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.alkemy.entities.Personaje;

@Repository
@Transactional
public class PersonajeDAOImplentacion implements IPersonajeDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void createPersonaje(Personaje personaje) {

		em.persist(personaje);

	}

	@Override
	public void editPersonaje(Personaje personaje, Integer id) {

		Personaje personajeAUX = em.find(Personaje.class, id);

		personajeAUX.setLinkImagen(personaje.getLinkImagen());
		personajeAUX.setNombre(personaje.getNombre());
		personajeAUX.setEdad(personaje.getEdad());
		personajeAUX.setPeso(personaje.getPeso());
		personajeAUX.setHistoria(personaje.getHistoria());

		em.merge(personajeAUX);
	}

	@Override
	public void deletePersonaje(Integer id) {

		em.remove(em.find(Personaje.class, id));

	}

	@Override
	public List<Personaje> getPersonajes() {

		String query = "FROM Personaje";
		List<Personaje> listaPersonajes = em.createQuery(query).getResultList();

		return listaPersonajes;
	}

	@Override
	public Personaje getPersonajeDetalle(Integer id) {

		String query = "FROM Personaje a WHERE a.id=" + id;

		Personaje personaje = (Personaje) em.createQuery(query).getSingleResult();

		return personaje;
	}

}
