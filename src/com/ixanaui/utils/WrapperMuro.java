package com.ixanaui.utils;

import java.sql.Timestamp;

public class WrapperMuro {
	
	private Integer idtramite;
	private String estado_tramite;
	private String tipo_tramite;
	private int id_tipo_tramite;
	private String nombre_empresa;
	private String municipio_empresa;
	private Timestamp fecha;
	private String nombreTramite;

	
	public String getNombreTramite() {
		return nombreTramite;
	}
	public void setNombreTramite(String nombreTramite) {
		this.nombreTramite = nombreTramite;
	}
	public Integer getIdtramite() {
		return idtramite;
	}
	public void setIdtramite(Integer idtramite) {
		this.idtramite = idtramite;
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
	public int getId_tipo_tramite() {
		return id_tipo_tramite;
	}
	public void setId_tipo_tramite(int id_tipo_tramite) {
		this.id_tipo_tramite = id_tipo_tramite;
	}
	public String getNombre_empresa() {
		return nombre_empresa;
	}
	public void setNombre_empresa(String nombre_empresa) {
		this.nombre_empresa = nombre_empresa;
	}
	public String getMunicipio_empresa() {
		return municipio_empresa;
	}
	public void setMunicipio_empresa(String municipio_empresa) {
		this.municipio_empresa = municipio_empresa;
	}
	public Timestamp getFecha() {
		return fecha;
	}
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}
	
	

}
