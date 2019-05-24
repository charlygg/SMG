package com.ixanaui.utils;

public class WrapperTramiteCorrespondencia {
	
	private int idTramite;
	private String tramite;
	private String empresa;
	private String rep_legal;
	private String asunto;
	private String turnado;
	
	public WrapperTramiteCorrespondencia() {	}
	
	public WrapperTramiteCorrespondencia(int idTramite, String tramite, String empresa, String rep_legal, String asunto,
			String turnado) {
		super();
		this.idTramite = idTramite;
		this.tramite = tramite;
		this.empresa = empresa;
		this.rep_legal = rep_legal;
		this.asunto = asunto;
		this.turnado = turnado;
	}



	public int getIdTramite() {
		return idTramite;
	}

	public void setIdTramite(int idTramite) {
		this.idTramite = idTramite;
	}

	public String getTramite() {
		return tramite;
	}

	public void setTramite(String tramite) {
		this.tramite = tramite;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getRep_legal() {
		return rep_legal;
	}

	public void setRep_legal(String rep_legal) {
		this.rep_legal = rep_legal;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getTurnado() {
		return turnado;
	}

	public void setTurnado(String turnado) {
		this.turnado = turnado;
	}

	
}
