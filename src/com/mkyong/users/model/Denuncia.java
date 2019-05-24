package com.mkyong.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "denuncia")
public class Denuncia {

	@Id
	@GeneratedValue
	@Column(name = "iddenuncia")
	private int iddenuncia;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "correo")
	private String correo;
	
	@Column(name = "anonimo")
	private String anonimo;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "calle")
	private String calle;
	
	@Column(name = "numero_int")
	private String numero_int;
	
	@Column(name = "numero_ext")
	private String numero_ext;
	
	@Column(name = "colonia")
	private String colonia;
	
	@Column(name = "ciudad")
	private String ciudad;
	
	@Column(name = "municipio")
	private String municipio;
	
	@Column(name = "catalogo_denuncias_idcatalogo_denuncias")
	private int catalogo_denuncias_idcatalogo_denuncias;
	
	@Column(name = "estatus")
	private int estatus;
	
	@Column(name = "rolAgrego")
	private String rolAgrego;
	


//	private int identificador;
//	private String descripcionLista;
	public int getIddenuncia() {
		return iddenuncia;
	}

	public void setIddenuncia(int iddenuncia) {
		this.iddenuncia = iddenuncia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getAnonimo() {
		return anonimo;
	}

	public void setAnonimo(String anonimo) {
		this.anonimo = anonimo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumero_int() {
		return numero_int;
	}

	public void setNumero_int(String numero_int) {
		this.numero_int = numero_int;
	}

	public String getNumero_ext() {
		return numero_ext;
	}

	public void setNumero_ext(String numero_ext) {
		this.numero_ext = numero_ext;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public int getCatalogo_denuncias_idcatalogo_denuncias() {
		return catalogo_denuncias_idcatalogo_denuncias;
	}

	public void setCatalogo_denuncias_idcatalogo_denuncias(
			int catalogo_denuncias_idcatalogo_denuncias) {
		this.catalogo_denuncias_idcatalogo_denuncias = catalogo_denuncias_idcatalogo_denuncias;
	}

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

	public String getRolAgrego() {
		return rolAgrego;
	}

	public void setRolAgrego(String rolAgrego) {
		this.rolAgrego = rolAgrego;
	}

//	public int getIdentificador() {
//		return identificador;
//	}
//
//	public void setIdentificador(int identificador) {
//		this.identificador = identificador;
//	}
//
//	public String getDescripcionLista() {
//		return descripcionLista;
//	}
//
//	public void setDescripcionLista(String descripcionLista) {
//		this.descripcionLista = descripcionLista;
//	}
	
	
	
}
