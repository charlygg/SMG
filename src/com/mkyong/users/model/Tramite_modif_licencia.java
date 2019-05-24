package com.mkyong.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tramite_modif_licencia")
public class Tramite_modif_licencia {
	
	@Id
	@GeneratedValue
	@Column(name = "idtramite_modif_licencia")
	private int idtramite_modif_licencia;
	
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

	public int getIdtramite_modif_licencia() {
		return idtramite_modif_licencia;
	}

	public void setIdtramite_modif_licencia(int idtramite_modif_licencia) {
		this.idtramite_modif_licencia = idtramite_modif_licencia;
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