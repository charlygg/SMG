package com.mkyong.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tramite_ubiopermaintrellsaniconfnormofimex")
public class Tramite_ubiopermaintrellsaniconfnormofimex {
	
	@Id
	@GeneratedValue
	@Column(name = "idtramite")
	private int idtramite;
	
	@Column(name = "idempresa")
	private int idempresa;
	
	@Column(name = "idestablecimiento")
	private int idestablecimiento;
	
	@Column(name = "idestablecimientomens")
	private int idestablecimientomens;
	
	@Column(name = "nombreconp")
	private String nombreconp;
	
	@Column(name = "rfcp")
	private String rfcp;
	
	@Column(name = "ladap")
	private String ladap;
	
	@Column(name = "telefonop")
	private String telefonop;
	
	@Column(name = "extensionp")
	private String extensionp;
	
	@Column(name = "emailp")
	private String emailp;
	
	@Column(name = "cp")
	private String cp;
	
	@Column(name = "cps")
	private String cps;
	
	@Column(name = "nombrecons")
	private String nombrecons;
	
	@Column(name = "rfcs")
	private String rfcs;
	
	@Column(name = "ladas")
	private String ladas;
	
	@Column(name = "telefonos")
	private String telefonos;
	
	@Column(name = "extensions")
	private String extensions;
	
	@Column(name = "emails")
	private String emails;
	
	@Column(name = "giro")
	private String giro;
	
	@Column(name = "especificar")
	private String especificar;
	
	@Column(name = "productofinal")
	private String productofinal;


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
	
	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	
	public String getUUID() {
		return UUID;
	}

	public void setUUID(String uUID) {
		UUID = uUID;
	}

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

	
	public int getIdtramite() {
		return idtramite;
	}

	public void setIdtramite(int idtramite) {
		this.idtramite = idtramite;
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

	public int getIdestablecimientomens() {
		return idestablecimientomens;
	}

	public void setIdestablecimientomens(int idestablecimientomens) {
		this.idestablecimientomens = idestablecimientomens;
	}

	public String getNombreconp() {
		return nombreconp;
	}

	public void setNombreconp(String nombreconp) {
		this.nombreconp = nombreconp;
	}

	public String getRfcp() {
		return rfcp;
	}

	public void setRfcp(String rfcp) {
		this.rfcp = rfcp;
	}

	public String getLadap() {
		return ladap;
	}

	public void setLadap(String ladap) {
		this.ladap = ladap;
	}

	public String getTelefonop() {
		return telefonop;
	}

	public void setTelefonop(String telefonop) {
		this.telefonop = telefonop;
	}

	public String getExtensionp() {
		return extensionp;
	}

	public void setExtensionp(String extensionp) {
		this.extensionp = extensionp;
	}

	public String getEmailp() {
		return emailp;
	}

	public void setEmailp(String emailp) {
		this.emailp = emailp;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getCps() {
		return cps;
	}

	public void setCps(String cps) {
		this.cps = cps;
	}

	public String getNombrecons() {
		return nombrecons;
	}

	public void setNombrecons(String nombrecons) {
		this.nombrecons = nombrecons;
	}

	public String getRfcs() {
		return rfcs;
	}

	public void setRfcs(String rfcs) {
		this.rfcs = rfcs;
	}

	public String getLadas() {
		return ladas;
	}

	public void setLadas(String ladas) {
		this.ladas = ladas;
	}

	public String getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(String telefonos) {
		this.telefonos = telefonos;
	}

	public String getExtensions() {
		return extensions;
	}

	public void setExtensions(String extensions) {
		this.extensions = extensions;
	}

	public String getEmails() {
		return emails;
	}

	public void setEmails(String emails) {
		this.emails = emails;
	}

	public String getGiro() {
		return giro;
	}

	public void setGiro(String giro) {
		this.giro = giro;
	}

	public String getEspecificar() {
		return especificar;
	}

	public void setEspecificar(String especificar) {
		this.especificar = especificar;
	}

	public String getProductofinal() {
		return productofinal;
	}

	public void setProductofinal(String productofinal) {
		this.productofinal = productofinal;
	}

}
