package com.mkyong.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "catalogo_perfilempresa")
public class CatPerfilEmpresa {

	@Id
	@GeneratedValue
	@Column(name = "idcatalogo_perfilempresa")
	private int idcatalogo_perfilempresa;
	
	public int getIdcatalogo_perfilempresa() {
		return idcatalogo_perfilempresa;
	}


	public void setIdcatalogo_perfilempresa(int idcatalogo_perfilempresa) {
		this.idcatalogo_perfilempresa = idcatalogo_perfilempresa;
	}


	public String getNombreEmpresa() {
		return nombreEmpresa;
	}


	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}


	public String getRepresentanteLegal() {
		return representanteLegal;
	}


	public void setRepresentanteLegal(String representanteLegal) {
		this.representanteLegal = representanteLegal;
	}


	@Column(name = "nombreEmpresa")
	private String nombreEmpresa;
	
	@Column(name = "representanteLegal")
	private String representanteLegal;
	
	
	public CatPerfilEmpresa(){
		
	}
	

	
	
}
