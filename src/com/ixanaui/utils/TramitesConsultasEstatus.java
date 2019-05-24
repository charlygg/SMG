package com.ixanaui.utils;

import java.util.Date;

public class TramitesConsultasEstatus {
	
	private int noTramite;
	private String tramite;
	private int idarea;
	private String area;
	private int idempresa;
	private String empresa;
	private String asunto;
	private Date fechaRecibido;
	private Date fechaProceso;
	
	public TramitesConsultasEstatus() {	}
	

	public TramitesConsultasEstatus(int noTramite, String tramite, int idarea, String area, int idempresa,
			String empresa, String asunto, Date fechaRecibido, Date fechaProceso) {
		super();
		this.noTramite = noTramite;
		this.tramite = tramite;
		this.idarea = idarea;
		this.area = area;
		this.idempresa = idempresa;
		this.empresa = empresa;
		this.asunto = asunto;
		this.fechaRecibido = fechaRecibido;
		this.fechaProceso = fechaProceso;
	}

	public int getNoTramite() {
		return noTramite;
	}

	public void setNoTramite(int noTramite) {
		this.noTramite = noTramite;
	}

	public String getTramite() {
		return tramite;
	}

	public void setTramite(String tramite) {
		this.tramite = tramite;
	}

	public int getIdarea() {
		return idarea;
	}

	public void setIdarea(int idarea) {
		this.idarea = idarea;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getIdempresa() {
		return idempresa;
	}

	public void setIdempresa(int idempresa) {
		this.idempresa = idempresa;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public Date getFechaRecibido() {
		return fechaRecibido;
	}

	public void setFechaRecibido(Date fechaRecibido) {
		this.fechaRecibido = fechaRecibido;
	}

	public Date getFechaProceso() {
		return fechaProceso;
	}

	public void setFechaProceso(Date fechaProceso) {
		this.fechaProceso = fechaProceso;
	}
	
	

}
