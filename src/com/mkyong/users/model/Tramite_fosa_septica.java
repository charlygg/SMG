package com.mkyong.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tramite_fosaseptica")
public class Tramite_fosa_septica {

	@Id
	@GeneratedValue
	@Column(name = "idtramite_fosaseptica")
	private int idtramite_fosaseptica;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "calles")
	private String calles;

	@Column(name = "numero")
	private String numero;

	@Column(name = "colonia")
	private String colonia;

	@Column(name = "cp")
	private String cp;

	@Column(name = "telefonoDomicilio")
	private String telefonoDomicilio;

	@Column(name = "municipio")
	private String municipio;

	@Column(name = "actividad")
	private String actividad;

	@Column(name = "callesfosa")
	private String callesfosa;

	@Column(name = "numerofosa")
	private String numerofosa;

	@Column(name = "coloniafosa")
	private String coloniafosa;
	
	@Column(name = "cpfosa")
	private String cpfosa;

	@Column(name = "telefonofosa")
	private String telefonofosa;

	@Column(name = "municipiofosa")
	private String municipiofosa;

	@Column(name = "contratoagua")
	private String contratoagua;
	
	@Column(name = "empresa_contratoagua")
	private String empresa_contratoagua;
	
	@Column(name = "numerodefosas")
	private String numerodefosas;

	@Column(name = "tipoinstalacion1")
	private String tipoinstalacion1;

	@Column(name = "capacidadm31")
	private String capacidadm31;

	@Column(name = "tipoinstalacion2")
	private String tipoinstalacion2;

	@Column(name = "capacidadm32")
	private String capacidadm32;

	@Column(name = "idempresa")
	private int idempresa;

	@Column(name = "idestablecimiento")
	private int idestablecimiento;
	
	@Column(name = "estatus")
	private int estatus;
	
	@Column(name = "UUID")
	private String UUID;
	
	@Column(name = "asunto")
	private String asunto;
	
	@Column(name = "f_recepcion_tramite")
	private String f_recepcion_tramite;
	
	@Column(name = "f_tramite_concluido")
	private String f_tramite_concluido;
	
	public String getF_recepcion_tramite() {
		return f_recepcion_tramite;
	}

	public void setF_recepcion_tramite(String f_recepcion_tramite) {
		this.f_recepcion_tramite = f_recepcion_tramite;
	}

	public String getF_tramite_concluido() {
		return f_tramite_concluido;
	}

	public void setF_tramite_concluido(String f_tramite_concluido) {
		this.f_tramite_concluido = f_tramite_concluido;
	}
	
	
	public String getEmpresa_contratoagua() {
		return empresa_contratoagua;
	}

	public void setEmpresa_contratoagua(String empresa_contratoagua) {
		this.empresa_contratoagua = empresa_contratoagua;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

	public String getUUID() {
		return UUID;
	}

	public void setUUID(String uUID) {
		UUID = uUID;
	}

	public int getIdtramite_fosaseptica() {
		return idtramite_fosaseptica;
	}

	public void setIdtramite_fosaseptica(int idtramite_fosaseptica) {
		this.idtramite_fosaseptica = idtramite_fosaseptica;
	}

	
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCalles() {
		return calles;
	}

	public void setCalles(String calles) {
		this.calles = calles;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getTelefonoDomicilio() {
		return telefonoDomicilio;
	}

	public void setTelefonoDomicilio(String telefonoDomicilio) {
		this.telefonoDomicilio = telefonoDomicilio;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getActividad() {
		return actividad;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	public String getCallesfosa() {
		return callesfosa;
	}

	public void setCallesfosa(String callesfosa) {
		this.callesfosa = callesfosa;
	}

	public String getNumerofosa() {
		return numerofosa;
	}

	public void setNumerofosa(String numerofosa) {
		this.numerofosa = numerofosa;
	}

	public String getCpfosa() {
		return cpfosa;
	}

	public void setCpfosa(String cpfosa) {
		this.cpfosa = cpfosa;
	}

	public String getTelefonofosa() {
		return telefonofosa;
	}

	public void setTelefonofosa(String telefonofosa) {
		this.telefonofosa = telefonofosa;
	}

	public String getMunicipiofosa() {
		return municipiofosa;
	}

	public void setMunicipiofosa(String municipiofosa) {
		this.municipiofosa = municipiofosa;
	}

	public String getContratoagua() {
		return contratoagua;
	}

	public void setContratoagua(String contratoagua) {
		this.contratoagua = contratoagua;
	}

	public String getNumerodefosas() {
		return numerodefosas;
	}

	public void setNumerodefosas(String numerodefosas) {
		this.numerodefosas = numerodefosas;
	}

	public String getTipoinstalacion1() {
		return tipoinstalacion1;
	}

	public void setTipoinstalacion1(String tipoinstalacion1) {
		this.tipoinstalacion1 = tipoinstalacion1;
	}

	public String getCapacidadm31() {
		return capacidadm31;
	}

	public void setCapacidadm31(String capacidadm31) {
		this.capacidadm31 = capacidadm31;
	}

	public String getTipoinstalacion2() {
		return tipoinstalacion2;
	}

	public void setTipoinstalacion2(String tipoinstalacion2) {
		this.tipoinstalacion2 = tipoinstalacion2;
	}

	public String getCapacidadm32() {
		return capacidadm32;
	}

	public void setCapacidadm32(String capacidadm32) {
		this.capacidadm32 = capacidadm32;
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

	public String getColoniafosa() {
		return coloniafosa;
	}

	public void setColoniafosa(String coloniafosa) {
		this.coloniafosa = coloniafosa;
	}

}
