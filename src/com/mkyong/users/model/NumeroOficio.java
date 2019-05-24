package com.mkyong.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "numeros_oficio")
public class NumeroOficio {
	
	@Id
	@GeneratedValue
	@Column(name = "idnumeros_oficio")
	private int idnumeros_oficio;
	
	@Column(name = "tipo")
	private String tipo;
	
	@Column(name = "area")
	private String area;
	
	@Column(name = "ultimo_numero")
	private int ultimo_numero;

	public int getIdnumeros_oficio() {
		return idnumeros_oficio;
	}

	public void setIdnumeros_oficio(int idnumeros_oficio) {
		this.idnumeros_oficio = idnumeros_oficio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getUltimo_numero() {
		return ultimo_numero;
	}

	public void setUltimo_numero(int ultimo_numero) {
		this.ultimo_numero = ultimo_numero;
	}
	
	

}
