package com.ixanaui.utils;

public class MensajeBean  {
	private String mensaje;
	private int numero;
	private String referencia;
	private int consecutivo;
	/* Agregados por Charly para que de el ID del tramite al momento de registrar*/
	private int idNumTramite;
	private int idTipoTramite;
	
	public MensajeBean(){
		
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public int getConsecutivo() {
		return consecutivo;
	}
	public void setConsecutivo(int consecutivo) {
		this.consecutivo = consecutivo;
	}
	
	public int getIdNumTramite() {
		return idNumTramite;
	}
	
	public void setIdNumTramite(int idNumTramite) {
		this.idNumTramite = idNumTramite;
	}
	
	public int getIdTipoTramite() {
		return idTipoTramite;
	}
	
	public void setIdTipoTramite(int idTipoTramite) {
		this.idTipoTramite = idTipoTramite;
	}
	
}