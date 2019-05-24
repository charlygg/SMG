package com.mkyong.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "areas")
public class Area {

	@Id
	@GeneratedValue
	@Column(name = "idareas")
	private int idareas;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "role", updatable=false)
	private String role;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Area(){
		
	}
	public Area(String nombre,String descripcion, String role){
		this.nombre= nombre;
		this.descripcion=descripcion;
		this.role = role;
	}

	public int getIdareas() {
		return idareas;
	}

	public void setIdareas(int idareas) {
		this.idareas = idareas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	
}
