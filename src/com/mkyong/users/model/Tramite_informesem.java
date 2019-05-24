package com.mkyong.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tramite_informesem")
public class Tramite_informesem {

	@Id
	@GeneratedValue
	@Column(name = "idtramite_informesem")
	private int idtramite_informesem;

	@Column(name = "fechaemision")
	private String fechaemision;

	@Column(name = "idempresa")
	private int idempresa;
	
	@Column(name = "rfc")
	private String rfc;
	
	@Column(name = "idestablecimiento")
	private int idestablecimiento;
	
	@Column(name = "estatus")
	private int estatus;
	
	@Column(name = "f_recepcion_tramite")
	private String f_recepcion_tramite;
	
	@Column(name = "f_tramite_concluido")
	private String f_tramite_concluido;
	
	@Column(name="f_notificacion")
	private String f_notificacion;
	
	@Column(name="notificacion")
	private String notificacion;
	
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
	
	@Column(name = "UUID")
	private String UUID;
	
	@Column(name = "asunto")
	private String asunto;
	
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

	public int getIdtramite_informesem() {
		return idtramite_informesem;
	}

	public void setIdtramite_informesem(int idtramite_informesem) {
		this.idtramite_informesem = idtramite_informesem;
	}

	public String getFechaemision() {
		return fechaemision;
	}

	public void setFechaemision(String fechaemision) {
		this.fechaemision = fechaemision;
	}


	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public int getIdempresa() {
		return idempresa;
	}

	public void setIdempresa(int idempresa) {
		this.idempresa = idempresa;
	}

	public int getIdestablecimiento() {
		return idestablecimiento;
	}

	public void setIdestablecimiento(int idestablecimiento) {
		this.idestablecimiento = idestablecimiento;
	}
	
	/* Agregados por Ing. Carlos Garcia Garza*/
	public String getF_notificacion() {
		return f_notificacion;
	}
	
	public void setF_notificacion(String f_notificacion) {
		this.f_notificacion = f_notificacion;
	}
	
	public String getNotificacion() {
		return notificacion;
	}
	
	public void setNotificacion(String notificacion) {
		this.notificacion = notificacion;
	}
	

}
