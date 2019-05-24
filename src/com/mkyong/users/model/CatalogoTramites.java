package com.mkyong.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "catalogo_tramites")
public class CatalogoTramites {

	@Id
	@GeneratedValue
	@Column(name = "catalogoID")
	private int catalogoID;
	
	@Column(name = "areaID")
	private int areaID;
	
	@Column(name = "areaNombre")
	private String areaNombre;
	
	@Column(name = "nombreTramite")
	private String nombreTramite;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	
	public CatalogoTramites(){
		
	}
	public CatalogoTramites(int catalogoID,int areaID,String areaNombre,String nombreTramite, String descripcion){
		this.catalogoID= catalogoID;
		this.areaID=areaID;
		this.areaNombre = areaNombre;
		this.nombreTramite = nombreTramite;
		this.descripcion=descripcion;
	}

	

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCatalogoID() {
		return catalogoID;
	}
	public void setCatalogoID(int catalogoID) {
		this.catalogoID = catalogoID;
	}
	public int getAreaID() {
		return areaID;
	}
	public void setAreaID(int areaID) {
		this.areaID = areaID;
	}
	public String getAreaNombre() {
		return areaNombre;
	}
	public void setAreaNombre(String areaNombre) {
		this.areaNombre = areaNombre;
	}
	public String getNombreTramite() {
		return nombreTramite;
	}
	public void setNombreTramite(String nombreTramite) {
		this.nombreTramite = nombreTramite;
	}
	



	
	
}
