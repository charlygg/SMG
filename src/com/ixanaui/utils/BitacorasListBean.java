package com.ixanaui.utils;

import java.math.BigInteger;

public class BitacorasListBean {
	private BigInteger idbitacoraregistros;
	private String fecha;
	private String hora;
	private String usuario;
	private String estatus;
	private String registro;
	private String empresa;
	private String establecimiento;
	private String catalogo;
	private int idcatalogo;
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public String getRegistro() {
		return registro;
	}
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	public String getEstablecimiento() {
		return establecimiento;
	}
	public void setEstablecimiento(String establecimiento) {
		this.establecimiento = establecimiento;
	}
	public String getCatalogo() {
		return catalogo;
	}
	public void setCatalogo(String catalogo) {
		this.catalogo = catalogo;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public BigInteger getIdbitacoraregistros() {
		return idbitacoraregistros;
	}
	public void setIdbitacoraregistros(BigInteger idbitacoraregistros) {
		this.idbitacoraregistros = idbitacoraregistros;
	}
	public int getIdcatalogo() {
		return idcatalogo;
	}
	public void setIdcatalogo(int idcatalogo) {
		this.idcatalogo = idcatalogo;
	}

}
