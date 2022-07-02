package com.alkemy.dto;

import java.util.Date;
import java.util.List;


import com.alkemy.entities.Personaje;


public class PeliculaDTO {
	private Integer id;
	private String linkImagen;
	private String titulo;
	private Date fechaCreacion;
	private Byte calificacion;
	private List<Personaje> personajes;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLinkImagen() {
		return linkImagen;
	}
	public void setLinkImagen(String linkImagen) {
		this.linkImagen = linkImagen;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Byte getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(Byte calificacion) {
		this.calificacion = calificacion;
	}
	public List<Personaje> getPersonajes() {
		return personajes;
	}
	public void setPersonajes(List<Personaje> personajes) {
		this.personajes = personajes;
	}
	
	
	
}
