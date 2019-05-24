package com.mkyong.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "catalogo_denuncias")
public class CatDenuncias {

	
	@Id
	@GeneratedValue
	@Column(name = "idcatalogo_denuncias")
	private int idcatalogo_denuncias;
	
	@Column(name = "nombre_tramite")
	private String nombre_tramite;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "area")
	private String area;
	
	@Column(name = "area_idarea")
	private int area_idarea;

	public int getIdcatalogo_denuncias() {
		return idcatalogo_denuncias;
	}

	public void setIdcatalogo_denuncias(int idcatalogo_denuncias) {
		this.idcatalogo_denuncias = idcatalogo_denuncias;
	}

	public String getNombre_tramite() {
		return nombre_tramite;
	}

	public void setNombre_tramite(String nombre_tramite) {
		this.nombre_tramite = nombre_tramite;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getArea_idarea() {
		return area_idarea;
	}

	public void setArea_idarea(int area_idarea) {
		this.area_idarea = area_idarea;
	}

		
	
	
}
