package com.mkyong.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "catalogo_perfilestablecimiento")
public class CatPerfilEstablecimiento {

	@Id
	@GeneratedValue
	@Column(name = "idcatalogo_perfilestablecimiento")
	private int idcatalogo_perfilestablecimiento;
	
	@Column(name = "idcatalogo_perfilempresa")
	private int idcatalogo_perfilempresa;
	
	@Column(name = "nombreEmpresa")
	private String nombreEmpresa;
	
	@Column(name = "calle")
	private String calle;
	@Column(name = "numeroExterior")
	private String numeroExterior;
	@Column(name = "numeroInterior")
	private String numeroInterior;
	@Column(name = "colonia")
	private String colonia;
	@Column(name = "municipio")
	private String municipio;
	@Column(name = "estado")
	private String estado;
	@Column(name = "latitud")
	private String latitud;
	@Column(name = "longitud")
	private String longitud;
	@Column(name = "email")
	private String email;
	@Column(name = "telefono")
	private String telefono;
	@Column(name = "matriz")
	private String matriz;
	
	public CatPerfilEstablecimiento(){
		
	}
	public int getIdcatalogo_perfilestablecimiento() {
		return idcatalogo_perfilestablecimiento;
	}
	public void setIdcatalogo_perfilestablecimiento(
			int idcatalogo_perfilestablecimiento) {
		this.idcatalogo_perfilestablecimiento = idcatalogo_perfilestablecimiento;
	}
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumeroExterior() {
		return numeroExterior;
	}
	public void setNumeroExterior(String numeroExterior) {
		this.numeroExterior = numeroExterior;
	}
	public String getNumeroInterior() {
		return numeroInterior;
	}
	public void setNumeroInterior(String numeroInterior) {
		this.numeroInterior = numeroInterior;
	}
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getLatitud() {
		return latitud;
	}
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}
	public String getLongitud() {
		return longitud;
	}
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getMatriz() {
		return matriz;
	}
	public void setMatriz(String matriz) {
		this.matriz = matriz;
	}
	public int getIdcatalogo_perfilempresa() {
		return idcatalogo_perfilempresa;
	}
	public void setIdcatalogo_perfilempresa(int idcatalogo_perfilempresa) {
		this.idcatalogo_perfilempresa = idcatalogo_perfilempresa;
	}	

	
	
}
