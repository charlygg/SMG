package com.mkyong.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tramite_presentan_info_impacto")
public class Tramite_presentan_info_impacto {
	
	@Id
	@GeneratedValue
	@Column(name="idtramite_impacto")
	private int idtramite_impacto;
	
	@Column(name="rfc")
	private String rfc;
	
	@Column(name="estatus")
	private int estatus;
	
	@Column(name="UUID")
	private String UUID;
	
	@Column(name="idestablecimiento")
	private int idestablecimiento;
	
	@Column(name="idempresa")
	private int idempresa;
	
	@Column(name="asunto")
	private String asunto;
	
	@Column(name="f_recepcion_tramite")
	private String f_recepcion_tramite;
	
	@Column(name="f_tramite_concluido")
	private String f_tramite_concluido;
	
	@Column(name="notificacion")
	private String notificacion;
	
	@Column(name="f_notificacion")
	private String f_notificacion;
	
	public int getIdtramite_impacto() {
		return idtramite_impacto;
	}
	
	public void setIdtramite_impacto(int idtramite_impacto) {
		this.idtramite_impacto = idtramite_impacto;
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
	
	public void setUUID(String uUID) {
		UUID = uUID;
	}
	
	public int getIdestablecimiento() {
		return idestablecimiento;
	}
	
	public void setIdestablecimiento(int idestablecimiento) {
		this.idestablecimiento = idestablecimiento;
	}
	
	public int getIdempresa() {
		return idempresa;
	}
	
	public void setIdempresa(int idempresa) {
		this.idempresa = idempresa;
	}
	
	public String getAsunto() {
		return asunto;
	}
	
	public void setAsunto(String asunto) {
		this.asunto = asunto;
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
	
	public void setNotificacion(String notificacion) {
		this.notificacion = notificacion;
	}
	
	public String getNotificacion() {
		return notificacion;
	}

	public String getF_notificacion() {
		return f_notificacion;
	}

	public void setF_notificacion(String f_notificacion) {
		this.f_notificacion = f_notificacion;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[ID TRAMITE IMPACTO PRESENTAN INFOMACION] : " + getIdtramite_impacto());
		sb.append("\n[ID EMPRESA] : " + getIdempresa());
		sb.append("\n[ID ESTABLECIMIENTO] : " + getIdestablecimiento());
		sb.append("\n[ASUNTO] : " + getAsunto());
		sb.append("\n[RFC] : " + getRfc());
		sb.append("\n[ESTATUS] : " + getEstatus());
		sb.append("\n[UUID] : " + getUUID());
		sb.append("\n[F_RECEPCION_TAMITE] : " + getF_recepcion_tramite());
		sb.append("\n[F_TRAMITE_CONCLUIDO] : " + getF_tramite_concluido());
		sb.append("\n[NOTIFICADO] : " + getNotificacion());
		sb.append("\n[F_NOTIFICACION] : " + getF_notificacion());
		return sb.toString();
	}
	
}
