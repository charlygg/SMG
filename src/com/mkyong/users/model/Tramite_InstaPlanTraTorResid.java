package com.mkyong.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tramite_instaplantratorresid")
public class Tramite_InstaPlanTraTorResid {
	
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
	
	@Column(name = "innuaudifiremaesp")
	private String innuaudifiremaesp;
	
	@Column(name = "innuaumaimamb")
	private String innuaumaimamb;
	
	@Column(name = "inussuauprdosipltrter")
	private String inussuauprdosipltrter;
	
	@Column(name = "detitrteut")
	private String detitrteut;
	
	@Column(name = "nores_a")
	private String nores_a;
	
	@Column(name = "caanestra_a")
	private String caanestra_a;
	
	@Column(name = "gere_a")
	private String gere_a;
	
	@Column(name = "nuaut_a")
	private String nuaut_a;
	
	@Column(name = "nores_b")
	private String nores_b;

	@Column(name = "caanestra_b")
	private String caanestra_b;
	
	@Column(name = "gere_b")
	private String gere_b;
	
	@Column(name = "nuaut_b")
	private String nuaut_b;
	
	@Column(name = "nores_c")
	private String nores_c;
	
	@Column(name = "caanestra_c")
	private String caanestra_c;
	
	@Column(name = "gere_c")
	private String gere_c;
	
	@Column(name = "nuaut_c")
	private String nuaut_c;
	
	@Column(name = "nores_d")
	private String nores_d;
	
	@Column(name = "caanestra_d")
	private String caanestra_d;
	
	@Column(name = "gere_d")
	private String gere_d;
	@Column(name = "nuaut_d")
	private String nuaut_d;
	@Column(name = "nores_e")
	private String nores_e;
	@Column(name = "caanestra_e")
	private String caanestra_e;
	@Column(name = "gere_e")
	private String gere_e;
	@Column(name = "nuaut_e")
	private String nuaut_e;
	@Column(name = "nores_f")
	private String nores_f;
	@Column(name = "caanestra_f")
	private String caanestra_f;
	@Column(name = "gere_f")
	private String gere_f;

	@Column(name = "nuaut_f")
	private String nuaut_f;
	
	@Column(name = "nores_g")
	private String nores_g;
	@Column(name = "caanestra_g")
	private String caanestra_g;
	@Column(name = "gere_g")
	private String gere_g;
	@Column(name = "nuaut_g")
	private String nuaut_g;
	@Column(name = "nores_h")
	private String nores_h;
	@Column(name = "caanestra_h")
	private String caanestra_h;
	@Column(name = "gere_h")
	private String gere_h;
	@Column(name = "nuaut_h")
	private String nuaut_h;
	@Column(name = "insidifiregetrter")
	private String insidifiregetrter;
	
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

	public String getInnuaudifiremaesp() {
		return innuaudifiremaesp;
	}

	public void setInnuaudifiremaesp(String innuaudifiremaesp) {
		this.innuaudifiremaesp = innuaudifiremaesp;
	}

	public String getInnuaumaimamb() {
		return innuaumaimamb;
	}

	public void setInnuaumaimamb(String innuaumaimamb) {
		this.innuaumaimamb = innuaumaimamb;
	}

	public String getInussuauprdosipltrter() {
		return inussuauprdosipltrter;
	}

	public void setInussuauprdosipltrter(String inussuauprdosipltrter) {
		this.inussuauprdosipltrter = inussuauprdosipltrter;
	}

	public String getDetitrteut() {
		return detitrteut;
	}

	public void setDetitrteut(String detitrteut) {
		this.detitrteut = detitrteut;
	}

	public String getNores_a() {
		return nores_a;
	}

	public void setNores_a(String nores_a) {
		this.nores_a = nores_a;
	}

	public String getCaanestra_a() {
		return caanestra_a;
	}

	public void setCaanestra_a(String caanestra_a) {
		this.caanestra_a = caanestra_a;
	}

	public String getGere_a() {
		return gere_a;
	}

	public void setGere_a(String gere_a) {
		this.gere_a = gere_a;
	}

	public String getNuaut_a() {
		return nuaut_a;
	}

	public void setNuaut_a(String nuaut_a) {
		this.nuaut_a = nuaut_a;
	}

	public String getNores_b() {
		return nores_b;
	}

	public void setNores_b(String nores_b) {
		this.nores_b = nores_b;
	}

	public String getCaanestra_b() {
		return caanestra_b;
	}

	public void setCaanestra_b(String caanestra_b) {
		this.caanestra_b = caanestra_b;
	}

	public String getGere_b() {
		return gere_b;
	}

	public void setGere_b(String gere_b) {
		this.gere_b = gere_b;
	}

	public String getNuaut_b() {
		return nuaut_b;
	}

	public void setNuaut_b(String nuaut_b) {
		this.nuaut_b = nuaut_b;
	}

	public String getNores_c() {
		return nores_c;
	}

	public void setNores_c(String nores_c) {
		this.nores_c = nores_c;
	}

	public String getCaanestra_c() {
		return caanestra_c;
	}

	public void setCaanestra_c(String caanestra_c) {
		this.caanestra_c = caanestra_c;
	}

	public String getGere_c() {
		return gere_c;
	}

	public void setGere_c(String gere_c) {
		this.gere_c = gere_c;
	}

	public String getNuaut_c() {
		return nuaut_c;
	}

	public void setNuaut_c(String nuaut_c) {
		this.nuaut_c = nuaut_c;
	}

	public String getNores_d() {
		return nores_d;
	}

	public void setNores_d(String nores_d) {
		this.nores_d = nores_d;
	}

	public String getCaanestra_d() {
		return caanestra_d;
	}

	public void setCaanestra_d(String caanestra_d) {
		this.caanestra_d = caanestra_d;
	}

	public String getGere_d() {
		return gere_d;
	}

	public void setGere_d(String gere_d) {
		this.gere_d = gere_d;
	}

	public String getNuaut_d() {
		return nuaut_d;
	}

	public void setNuaut_d(String nuaut_d) {
		this.nuaut_d = nuaut_d;
	}

	public String getNores_e() {
		return nores_e;
	}

	public void setNores_e(String nores_e) {
		this.nores_e = nores_e;
	}

	public String getCaanestra_e() {
		return caanestra_e;
	}

	public void setCaanestra_e(String caanestra_e) {
		this.caanestra_e = caanestra_e;
	}

	public String getGere_e() {
		return gere_e;
	}

	public void setGere_e(String gere_e) {
		this.gere_e = gere_e;
	}

	public String getNuaut_e() {
		return nuaut_e;
	}

	public void setNuaut_e(String nuaut_e) {
		this.nuaut_e = nuaut_e;
	}

	public String getNores_f() {
		return nores_f;
	}

	public void setNores_f(String nores_f) {
		this.nores_f = nores_f;
	}

	public String getCaanestra_f() {
		return caanestra_f;
	}

	public void setCaanestra_f(String caanestra_f) {
		this.caanestra_f = caanestra_f;
	}

	public String getGere_f() {
		return gere_f;
	}

	public void setGere_f(String gere_f) {
		this.gere_f = gere_f;
	}

	public String getNuaut_f() {
		return nuaut_f;
	}

	public void setNuaut_f(String nuaut_f) {
		this.nuaut_f = nuaut_f;
	}

	public String getNores_g() {
		return nores_g;
	}

	public void setNores_g(String nores_g) {
		this.nores_g = nores_g;
	}

	public String getCaanestra_g() {
		return caanestra_g;
	}

	public void setCaanestra_g(String caanestra_g) {
		this.caanestra_g = caanestra_g;
	}

	public String getGere_g() {
		return gere_g;
	}

	public void setGere_g(String gere_g) {
		this.gere_g = gere_g;
	}

	public String getNuaut_g() {
		return nuaut_g;
	}

	public void setNuaut_g(String nuaut_g) {
		this.nuaut_g = nuaut_g;
	}

	public String getNores_h() {
		return nores_h;
	}

	public void setNores_h(String nores_h) {
		this.nores_h = nores_h;
	}

	public String getCaanestra_h() {
		return caanestra_h;
	}

	public void setCaanestra_h(String caanestra_h) {
		this.caanestra_h = caanestra_h;
	}

	public String getGere_h() {
		return gere_h;
	}

	public void setGere_h(String gere_h) {
		this.gere_h = gere_h;
	}

	public String getNuaut_h() {
		return nuaut_h;
	}

	public void setNuaut_h(String nuaut_h) {
		this.nuaut_h = nuaut_h;
	}

	public String getInsidifiregetrter() {
		return insidifiregetrter;
	}

	public void setInsidifiregetrter(String insidifiregetrter) {
		this.insidifiregetrter = insidifiregetrter;
	}

}
