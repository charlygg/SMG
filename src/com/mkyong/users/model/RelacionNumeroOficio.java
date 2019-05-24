package com.mkyong.users.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "relacion_numeros_oficio")
public class RelacionNumeroOficio {

	@Id
	@GeneratedValue
	@Column(name = "idrelacion_numeros_oficio")
	private int idrelacion_numeros_oficio;
	
	@Column(name = "numero_oficina")
	private String numero_oficina;
	
	@Column(name = "numerotipo_oficina")
	private String numerotipo_oficina;
	
	@Column(name = "fecha")
	private Timestamp fecha;
	
	@Column(name = "idtramite")
	private int idtramite;
	
	@Column(name = "idtipo_tramite")
	private int idtipo_tramite;
	
	@Column(name = "nombre_tramite")
	private String nombre_tramite;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "estado")
	private String estado;

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getIdrelacion_numeros_oficio() {
		return idrelacion_numeros_oficio;
	}

	public void setIdrelacion_numeros_oficio(int idrelacion_numeros_oficio) {
		this.idrelacion_numeros_oficio = idrelacion_numeros_oficio;
	}

	public String getNumerotipo_oficina() {
		return numerotipo_oficina;
	}

	public void setNumerotipo_oficina(String numerotipo_oficina) {
		this.numerotipo_oficina = numerotipo_oficina;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public int getIdtramite() {
		return idtramite;
	}

	public void setIdtramite(int idtramite) {
		this.idtramite = idtramite;
	}

	public int getIdtipo_tramite() {
		return idtipo_tramite;
	}

	public void setIdtipo_tramite(int idtipo_tramite) {
		this.idtipo_tramite = idtipo_tramite;
	}


	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNumero_oficina() {
		return numero_oficina;
	}

	public void setNumero_oficina(String numero_oficina) {
		this.numero_oficina = numero_oficina;
	}

	public String getNombre_tramite() {
		return nombre_tramite;
	}

	public void setNombre_tramite(String nombre_tramite) {
		this.nombre_tramite = nombre_tramite;
	}
	
	
	
	
}