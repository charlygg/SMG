package com.mkyong.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tramite_presentan_info_residuos")
public class Tramite_presentan_info_residuos {

	@Id
	@GeneratedValue
	@Column(name="idtramite_residuos")
	private int idtramite_residuos;
	
	@Column(name="idempresa")
	private int idempresa;
	
	@Column(name="idestablecimiento")
	private int idestablecimiento;
	
	@Column(name="asunto")
	private String asunto;
	
	@Column(name="rfc")
	private String rfc;
	
	@Column(name="estatus")
	private int estatus;
	
	@Column(name="UUID")
	private String UUID;
	
	@Column(name="f_recepcion_tramite")
	private String f_recepcion_tramite;

	@Column(name="f_tramite_concluido")
	private String f_tramite_concluido;
	
	@Column(name="notificacion")
	private String notificacion;
	
	@Column(name="f_notificacion")
	private String f_notificacion;
	
	public Tramite_presentan_info_residuos() {	}

	public Tramite_presentan_info_residuos(int idtramite_residuos, int idempresa, int idestablecimiento, String asunto,
			String rfc, int estatus, String UUID, String f_recepcion_tramite, String f_tramite_concluido,
			String notificacion, String f_notificacion) {
		super();
		this.idtramite_residuos = idtramite_residuos;
		this.idempresa = idempresa;
		this.idestablecimiento = idestablecimiento;
		this.asunto = asunto;
		this.rfc = rfc;
		this.estatus = estatus;
		this.UUID = UUID;
		this.f_recepcion_tramite = f_recepcion_tramite;
		this.f_tramite_concluido = f_tramite_concluido;
		this.notificacion = notificacion;
		this.f_notificacion = f_notificacion;
	}

	public int getIdtramite_residuos() {
		return idtramite_residuos;
	}

	public void setIdtramite_residuos(int idtramite_residuos) {
		this.idtramite_residuos = idtramite_residuos;
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

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
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

	public void setUUID(String UUID) {
		this.UUID = UUID;
	}

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

	public String getNotificacion() {
		return notificacion;
	}

	public void setNotificacion(String notificacion) {
		this.notificacion = notificacion;
	}

	public String getF_notificacion() {
		return f_notificacion;
	}

	public void setF_notificacion(String f_notificacion) {
		this.f_notificacion = f_notificacion;
	}
	
	
}
