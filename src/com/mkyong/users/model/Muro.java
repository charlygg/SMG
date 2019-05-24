package com.mkyong.users.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "muro")
public class Muro {


	@Id
	@GeneratedValue
	@Column(name = "idmuro")
	private int idmuro;
	
	@Column(name = "fecha")
	@Type(type = "timestamp")
	private Timestamp fecha;
	
	@Column(name = "estado_tramite")
	private String estado_tramite;
	
	@Column(name = "tipo_tramite")
	private String tipo_tramite;
	
	@Column(name = "catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento")
	private int catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento;
	
	@Column(name = "catalogo_denuncias_idcatalogo_denuncias")
	private int catalogo_denuncias_idcatalogo_denuncias;
	
	@Column(name = "catalogo_tramites_catalogoID")
	private int catalogo_tramites_catalogoID;
	
	@Column(name = "id_tipo_tramite")
	private int id_tipo_tramite;
	
	

	public int getId_tipo_tramite() {
		return id_tipo_tramite;
	}

	public void setId_tipo_tramite(int id_tipo_tramite) {
		this.id_tipo_tramite = id_tipo_tramite;
	}

	public int getCatalogo_tramites_catalogoID() {
		return catalogo_tramites_catalogoID;
	}

	public void setCatalogo_tramites_catalogoID(int catalogo_tramites_catalogoID) {
		this.catalogo_tramites_catalogoID = catalogo_tramites_catalogoID;
	}

	public int getIdmuro() {
		return idmuro;
	}

	public void setIdmuro(int idmuro) {
		this.idmuro = idmuro;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public String getEstado_tramite() {
		return estado_tramite;
	}

	public void setEstado_tramite(String estado_tramite) {
		this.estado_tramite = estado_tramite;
	}

	public String getTipo_tramite() {
		return tipo_tramite;
	}

	public void setTipo_tramite(String tipo_tramite) {
		this.tipo_tramite = tipo_tramite;
	}

	public int getCatalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento() {
		return catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento;
	}

	public void setCatalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento(
			int catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento) {
		this.catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento = catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento;
	}

	public int getCatalogo_denuncias_idcatalogo_denuncias() {
		return catalogo_denuncias_idcatalogo_denuncias;
	}

	public void setCatalogo_denuncias_idcatalogo_denuncias(
			int catalogo_denuncias_idcatalogo_denuncias) {
		this.catalogo_denuncias_idcatalogo_denuncias = catalogo_denuncias_idcatalogo_denuncias;
	}
	
	
}
