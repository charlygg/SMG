package com.mkyong.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "municipiosrepub")
public class Municipios {
	
	@Column(name = "EstadoID")
	private int EstadoID;
	
	@Id
	@Column(name = "MunicipioID")
	private int MunicipioID;
	
	@Column(name = "Nombre")
	private String Nombre;

	@Column(name = "Localidad")
	private String Localidad;


	
	
	public Municipios(){
		
	}

	public int getEstadoID() {
		return EstadoID;
	}

	public void setEstadoID(int estadoID) {
		EstadoID = estadoID;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public int getMunicipioID() {
		return MunicipioID;
	}

	public void setMunicipioID(int municipioID) {
		MunicipioID = municipioID;
	}

	public String getLocalidad() {
		return Localidad;
	}

	public void setLocalidad(String localidad) {
		Localidad = localidad;
	}
}
