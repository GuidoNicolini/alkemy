package com.alkemy.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Personaje {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String linkImagen;
	private String nombre;
	private Integer edad;
	private Double peso;
	private String historia;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "personaje_pelicula", joinColumns = { @JoinColumn(name = "personaje_id") }, inverseJoinColumns = {
			@JoinColumn(name = "pelicula_serie_id") })
	private List<PeliculaSerie> peliculaSeries;

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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public String getHistoria() {
		return historia;
	}

	public void setHistoria(String historia) {
		this.historia = historia;
	}

	public List<PeliculaSerie> getPeliculaSeries() {
		return peliculaSeries;
	}

	public void setPeliculaSeries(List<PeliculaSerie> peliculaSerie) {
		this.peliculaSeries = peliculaSerie;
	}

}
