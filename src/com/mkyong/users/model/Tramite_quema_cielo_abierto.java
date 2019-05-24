package com.mkyong.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tramite_quema_cielo_abierto")
public class Tramite_quema_cielo_abierto {

	@Id
	@GeneratedValue
	@Column(name = "idtramite_quema_cielo_abierto")
	private int idtramite_quema_cielo_abierto;
	
	@Column(name = "tipo_combustible")
	private String tipo_combustible;
	
	@Column(name = "cantidad")
	private String cantidad;
	
	@Column(name = "catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento")
	private int catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento;
	
	@Column(name = "catalogo_perfilempresa_idcatalogo_perfilempresa")
	private int catalogo_perfilempresa_idcatalogo_perfilempresa;
	
	@Column(name = "estatus")
	private int estatus;
	
	@Column(name = "UUID")
	private String UUID;
	
	@Column(name = "asunto")
	private String asunto;
	
	@Column(name = "f_recepcion_tramite")
	private String f_recepcion_tramite;
	
	@Column(name = "f_tramite_concluido")
	private String f_tramite_concluido;
	
	public String getF_recepcion_tramite() {
		return f_recepcion_tramite;
	}

	public void setF_recepcion_tramite(String f_recepcion_tramite) {
		this.f_recepcion_tramite = f_recepcion_tramite;
	}

	public String getF_tramite_concluido() {
		return f_tramite_concluido;
	}

	public void setF_tramite_concluido(String f_tramite_concluido) {
		this.f_tramite_concluido = f_tramite_concluido;
	}
	
	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

	public String getUUID() {
		return UUID;
	}

	public void setUUID(String uUID) {
		UUID = uUID;
	}

	public int getIdtramite_quema_cielo_abierto() {
		return idtramite_quema_cielo_abierto;
	}

	public void setIdtramite_quema_cielo_abierto(int idtramite_quema_cielo_abierto) {
		this.idtramite_quema_cielo_abierto = idtramite_quema_cielo_abierto;
	}

	public String getTipo_combustible() {
		return tipo_combustible;
	}

	public void setTipo_combustible(String tipo_combustible) {
		this.tipo_combustible = tipo_combustible;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public int getCatalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento() {
		return catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento;
	}

	public void setCatalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento(
			int catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento) {
		this.catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento = catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento;
	}

	public int getCatalogo_perfilempresa_idcatalogo_perfilempresa() {
		return catalogo_perfilempresa_idcatalogo_perfilempresa;
	}

	public void setCatalogo_perfilempresa_idcatalogo_perfilempresa(
			int catalogo_perfilempresa_idcatalogo_perfilempresa) {
		this.catalogo_perfilempresa_idcatalogo_perfilempresa = catalogo_perfilempresa_idcatalogo_perfilempresa;
	}
	
	
}
