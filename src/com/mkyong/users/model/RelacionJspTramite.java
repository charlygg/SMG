package com.mkyong.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "relacion_jsp_tramite")
public class RelacionJspTramite {

	@Id
	@GeneratedValue
	@Column(name = "idrelacion_jsp_tramite")
	private int idrelacion_jsp_tramite;
	
	@Column(name = "catalogo_tramites_catalogoID")
	private int catalogo_tramites_catalogoID;
	
	@Column(name = "tipo")
	private String tipo;
	
	@Column(name = "url_server")
	private String url_server;

	public int getIdrelacion_jsp_tramite() {
		return idrelacion_jsp_tramite;
	}

	public void setIdrelacion_jsp_tramite(int idrelacion_jsp_tramite) {
		this.idrelacion_jsp_tramite = idrelacion_jsp_tramite;
	}

	public int getCatalogo_tramites_catalogoID() {
		return catalogo_tramites_catalogoID;
	}

	public void setCatalogo_tramites_catalogoID(int catalogo_tramites_catalogoID) {
		this.catalogo_tramites_catalogoID = catalogo_tramites_catalogoID;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUrl_server() {
		return url_server;
	}

	public void setUrl_server(String url_server) {
		this.url_server = url_server;
	}
	
}
