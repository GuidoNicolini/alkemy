package com.alkemy.dto;

import java.util.List;

import com.alkemy.entities.PeliculaSerie;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class PersonajePeliculaDTO {

	private String linkImagen;
	private String nombre;
	private Integer edad;
	private Double peso;
	private String historia;
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	public List<PeliculaSerie> peliculaSeries;

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

	public void setPeliculaSeries(List<PeliculaSerie> peliculaSeries) {
		this.peliculaSeries = peliculaSeries;
	}

}
