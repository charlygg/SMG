package com.mkyong.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue
	@Column(name = "idusuarios")
	private int idusuarios;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellidoPaterno")
	private String apellidoPaterno;
	
	@Column(name = "apellidoMaterno")
	private String apellidoMaterno;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "role")
	private String role;
	
	public Usuario(){
		
	}
	
	public Usuario(String username, String password, String nombre, String apellidoPaterno, String apellidoMaterno, String email, String role, String fechaRegistro) {
	 	this.username = username;
	 	this.password = password;
	 	this.nombre = nombre;
	 	this.apellidoPaterno = apellidoPaterno;
	 	this.apellidoMaterno = apellidoMaterno;
	 	this.email = email;
	 	this.role = role;
	 }

	public int getIdusuarios() {
		return idusuarios;
	}

	public void setIdusuarios(int idusuarios) {
		this.idusuarios = idusuarios;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	

}
