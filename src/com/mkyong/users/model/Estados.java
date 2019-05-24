package com.mkyong.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "estadosrepub")
public class Estados {

	@Id
	@GeneratedValue
	@Column(name = "EstadoID")
	private int EstadoID;
	
	@Column(name = "Nombre")
	private String Nombre;
	
	@Column(name = "Clave")
	private String Clave;



	
	
	public Estados(){
		
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





	public String getClave() {
		return Clave;
	}





	public void setClave(String clave) {
		Clave = clave;
	}
	

	
	
}
