package com.mkyong.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tramite_regularizacion_impacto")
public class Tramite_regularizacion_impacto {
	
	@Id
	@GeneratedValue
	@Column(name="idtramite_regularizacion_impacto")
	private int idtramite_regularizacion_impacto;
	
	@Column(name="idestablecimiento")
	private int idestablecimiento;
	
	@Column(name="idempresa")
	private int idempresa;
	
	@Column(name="asunto")
	private String asunto;
	
	@Column(name="UUID")
	private String UUID;
	
	@Column(name="estatus")
	private int estatus;
	
	@Column(name="f_recepcion_tramite")
	private String f_recepcion_tramite;
	
	@Column(name="f_tramite_concluido")
	private String f_tramite_concluido;
	
	@Column(name="notificacion")
	private String notificacion;
	
	@Column(name="f_notificacion")
	private String f_notificacion;
	
	public Tramite_regularizacion_impacto() { }
	
	public Tramite_regularizacion_impacto(int idtramite_regularizacion_impacto, int idestablecimiento, int idempresa,
			String asunto, String uUID, int estatus, String f_recepcion_tramite, String f_tramite_concluido,
			String notificacion, String f_notificacion) {
		super();
		this.idtramite_regularizacion_impacto = idtramite_regularizacion_impacto;
		this.idestablecimiento = idestablecimiento;
		this.idempresa = idempresa;
		this.asunto = asunto;
		this.UUID = uUID;
		this.estatus = estatus;
		this.f_recepcion_tramite = f_recepcion_tramite;
		this.f_tramite_concluido = f_tramite_concluido;
		this.notificacion = notificacion;
		this.f_notificacion = f_notificacion;
	}
	
}
