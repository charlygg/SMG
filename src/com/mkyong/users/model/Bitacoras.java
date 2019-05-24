package com.mkyong.users.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "bitacoraregistros")
public class Bitacoras {

	@Id
	@GeneratedValue
	@Column(name = "idbitacoraregistros")
	private BigInteger idbitacoraregistros;
	
	@Column(name = "fecha")
	private String fecha;
	
	@Column(name = "hora")
	private String hora;
	
	@Column(name = "idusuario")
	private int idusuario;
	
	@Column(name = "estatus")
	private int estatus;
	
	@Column(name = "idregistro")
	private String idregistro;
	
	@Column(name = "idempresa")
	private int idempresa;
	
	@Column(name = "idestablecimiento")
	private int idestablecimiento;
	
	@Column(name = "catalogoID")
	private int catalogoID;
	
	@Column(name = "tipoBitacora")
	private String tipoBitacora;
	
//	private String nombreUsuario;
//	private String nombreEstatus;
	public Bitacoras(){
		
	}

	
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

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

	public String getIdregistro() {
		return idregistro;
	}

	public void setIdregistro(String idregistro) {
		this.idregistro = idregistro;
	}


	public BigInteger getIdbitacoraregistros() {
		return idbitacoraregistros;
	}


	public void setIdbitacoraregistros(BigInteger idbitacoraregistros) {
		this.idbitacoraregistros = idbitacoraregistros;
	}


	public int getIdusuario() {
		return idusuario;
	}


	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}


	public int getIdempresa() {
		return idempresa;
	}


	public void setIdempresa(int idempresa) {
		this.idempresa = idempresa;
	}


	public int getIdestablecimiento() {
		return idestablecimiento;
	}


	public void setIdestablecimiento(int idestablecimiento) {
		this.idestablecimiento = idestablecimiento;
	}


	public int getCatalogoID() {
		return catalogoID;
	}


	public void setCatalogoID(int catalogoID) {
		this.catalogoID = catalogoID;
	}


	public String getTipoBitacora() {
		return tipoBitacora;
	}


	public void setTipoBitacora(String tipoBitacora) {
		this.tipoBitacora = tipoBitacora;
	}


//	public String getNombreUsuario() {
//		return nombreUsuario;
//	}
//
//
//	public void setNombreUsuario(String nombreUsuario) {
//		this.nombreUsuario = nombreUsuario;
//	}
//
//
//	public String getNombreEstatus() {
//		return nombreEstatus;
//	}
//
//
//	public void setNombreEstatus(String nombreEstatus) {
//		this.nombreEstatus = nombreEstatus;
//	}




}
