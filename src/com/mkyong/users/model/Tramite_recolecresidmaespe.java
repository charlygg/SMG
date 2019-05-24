package com.mkyong.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tramite_recolecresidmarspe")
public class Tramite_recolecresidmaespe {
	
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

	@Column(name = "nupla_a")
	private String nupla_a;
	@Column(name = "niv_a")
	private String niv_a;
	@Column(name = "capacidad_a")
	private String capacidad_a;
	@Column(name = "marca_a")
	private String marca_a;
	@Column(name = "tiveh_a")
	private String tiveh_a;
	@Column(name = "modelo_a")
	private String modelo_a;

	@Column(name = "nupla_b")
	private String nupla_b;
	@Column(name = "niv_b")
	private String niv_b;
	@Column(name = "capacidad_b")
	private String capacidad_b;
	@Column(name = "marca_b")
	private String marca_b;
	@Column(name = "tiveh_b")
	private String tiveh_b;
	@Column(name = "modelo_b")
	private String modelo_b;

	@Column(name = "nupla_c")
	private String nupla_c;
	@Column(name = "niv_c")
	private String niv_c;
	@Column(name = "capacidad_c")
	private String capacidad_c;
	@Column(name = "marca_c")
	private String marca_c;
	@Column(name = "tiveh_c")
	private String tiveh_c;
	@Column(name = "modelo_c")
	private String modelo_c;

	@Column(name = "nupla_d")
	private String nupla_d;
	@Column(name = "niv_d")
	private String niv_d;
	@Column(name = "capacidad_d")
	private String capacidad_d;
	@Column(name = "marca_d")
	private String marca_d;
	@Column(name = "tiveh_d")
	private String tiveh_d;
	@Column(name = "modelo_d")
	private String modelo_d;

	@Column(name = "nupla_e")
	private String nupla_e;
	@Column(name = "niv_e")
	private String niv_e;
	@Column(name = "capacidad_e")
	private String capacidad_e;
	@Column(name = "marca_e")
	private String marca_e;
	@Column(name = "tiveh_e")
	private String tiveh_e;
	@Column(name = "modelo_e")
	private String modelo_e;

	@Column(name = "nupla_f")
	private String nupla_f;
	@Column(name = "niv_f")
	private String niv_f;
	@Column(name = "capacidad_f")
	private String capacidad_f;
	@Column(name = "marca_f")
	private String marca_f;
	@Column(name = "tiveh_f")
	private String tiveh_f;
	@Column(name = "modelo_f")
	private String modelo_f;

	@Column(name = "nupla_g")
	private String nupla_g;
	@Column(name = "niv_g")
	private String niv_g;
	@Column(name = "capacidad_g")
	private String capacidad_g;
	@Column(name = "marca_g")
	private String marca_g;
	@Column(name = "tiveh_g")
	private String tiveh_g;
	@Column(name = "modelo_g")
	private String modelo_g;

	@Column(name = "nupla_h")
	private String nupla_h;
	@Column(name = "niv_h")
	private String niv_h;
	@Column(name = "capacidad_h")
	private String capacidad_h;
	@Column(name = "marca_h")
	private String marca_h;
	@Column(name = "tiveh_h")
	private String tiveh_h;
	@Column(name = "modelo_h")
	private String modelo_h;

	@Column(name = "nutoverec")
	private String nutoverec;

	@Column(name = "seofemneg")
	private String seofemneg;

	@Column(name = "cltrmaesp")
	private String cltrmaesp;
	
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

	public String getNupla_a() {
		return nupla_a;
	}

	public void setNupla_a(String nupla_a) {
		this.nupla_a = nupla_a;
	}

	public String getNiv_a() {
		return niv_a;
	}

	public void setNiv_a(String niv_a) {
		this.niv_a = niv_a;
	}

	public String getCapacidad_a() {
		return capacidad_a;
	}

	public void setCapacidad_a(String capacidad_a) {
		this.capacidad_a = capacidad_a;
	}

	public String getMarca_a() {
		return marca_a;
	}

	public void setMarca_a(String marca_a) {
		this.marca_a = marca_a;
	}

	public String getTiveh_a() {
		return tiveh_a;
	}

	public void setTiveh_a(String tiveh_a) {
		this.tiveh_a = tiveh_a;
	}

	public String getModelo_a() {
		return modelo_a;
	}

	public void setModelo_a(String modelo_a) {
		this.modelo_a = modelo_a;
	}

	public String getNupla_b() {
		return nupla_b;
	}

	public void setNupla_b(String nupla_b) {
		this.nupla_b = nupla_b;
	}

	public String getNiv_b() {
		return niv_b;
	}

	public void setNiv_b(String niv_b) {
		this.niv_b = niv_b;
	}

	public String getCapacidad_b() {
		return capacidad_b;
	}

	public void setCapacidad_b(String capacidad_b) {
		this.capacidad_b = capacidad_b;
	}

	public String getMarca_b() {
		return marca_b;
	}

	public void setMarca_b(String marca_b) {
		this.marca_b = marca_b;
	}

	public String getTiveh_b() {
		return tiveh_b;
	}

	public void setTiveh_b(String tiveh_b) {
		this.tiveh_b = tiveh_b;
	}

	public String getModelo_b() {
		return modelo_b;
	}

	public void setModelo_b(String modelo_b) {
		this.modelo_b = modelo_b;
	}

	public String getNupla_c() {
		return nupla_c;
	}

	public void setNupla_c(String nupla_c) {
		this.nupla_c = nupla_c;
	}

	public String getNiv_c() {
		return niv_c;
	}

	public void setNiv_c(String niv_c) {
		this.niv_c = niv_c;
	}

	public String getCapacidad_c() {
		return capacidad_c;
	}

	public void setCapacidad_c(String capacidad_c) {
		this.capacidad_c = capacidad_c;
	}

	public String getMarca_c() {
		return marca_c;
	}

	public void setMarca_c(String marca_c) {
		this.marca_c = marca_c;
	}

	public String getTiveh_c() {
		return tiveh_c;
	}

	public void setTiveh_c(String tiveh_c) {
		this.tiveh_c = tiveh_c;
	}

	public String getModelo_c() {
		return modelo_c;
	}

	public void setModelo_c(String modelo_c) {
		this.modelo_c = modelo_c;
	}

	public String getNupla_d() {
		return nupla_d;
	}

	public void setNupla_d(String nupla_d) {
		this.nupla_d = nupla_d;
	}

	public String getNiv_d() {
		return niv_d;
	}

	public void setNiv_d(String niv_d) {
		this.niv_d = niv_d;
	}

	public String getCapacidad_d() {
		return capacidad_d;
	}

	public void setCapacidad_d(String capacidad_d) {
		this.capacidad_d = capacidad_d;
	}

	public String getMarca_d() {
		return marca_d;
	}

	public void setMarca_d(String marca_d) {
		this.marca_d = marca_d;
	}

	public String getTiveh_d() {
		return tiveh_d;
	}

	public void setTiveh_d(String tiveh_d) {
		this.tiveh_d = tiveh_d;
	}

	public String getModelo_d() {
		return modelo_d;
	}

	public void setModelo_d(String modelo_d) {
		this.modelo_d = modelo_d;
	}

	public String getNupla_e() {
		return nupla_e;
	}

	public void setNupla_e(String nupla_e) {
		this.nupla_e = nupla_e;
	}

	public String getNiv_e() {
		return niv_e;
	}

	public void setNiv_e(String niv_e) {
		this.niv_e = niv_e;
	}

	public String getCapacidad_e() {
		return capacidad_e;
	}

	public void setCapacidad_e(String capacidad_e) {
		this.capacidad_e = capacidad_e;
	}

	public String getMarca_e() {
		return marca_e;
	}

	public void setMarca_e(String marca_e) {
		this.marca_e = marca_e;
	}

	public String getTiveh_e() {
		return tiveh_e;
	}

	public void setTiveh_e(String tiveh_e) {
		this.tiveh_e = tiveh_e;
	}

	public String getModelo_e() {
		return modelo_e;
	}

	public void setModelo_e(String modelo_e) {
		this.modelo_e = modelo_e;
	}

	public String getNupla_f() {
		return nupla_f;
	}

	public void setNupla_f(String nupla_f) {
		this.nupla_f = nupla_f;
	}

	public String getNiv_f() {
		return niv_f;
	}

	public void setNiv_f(String niv_f) {
		this.niv_f = niv_f;
	}

	public String getCapacidad_f() {
		return capacidad_f;
	}

	public void setCapacidad_f(String capacidad_f) {
		this.capacidad_f = capacidad_f;
	}

	public String getMarca_f() {
		return marca_f;
	}

	public void setMarca_f(String marca_f) {
		this.marca_f = marca_f;
	}

	public String getTiveh_f() {
		return tiveh_f;
	}

	public void setTiveh_f(String tiveh_f) {
		this.tiveh_f = tiveh_f;
	}

	public String getModelo_f() {
		return modelo_f;
	}

	public void setModelo_f(String modelo_f) {
		this.modelo_f = modelo_f;
	}

	public String getNupla_g() {
		return nupla_g;
	}

	public void setNupla_g(String nupla_g) {
		this.nupla_g = nupla_g;
	}

	public String getNiv_g() {
		return niv_g;
	}

	public void setNiv_g(String niv_g) {
		this.niv_g = niv_g;
	}

	public String getCapacidad_g() {
		return capacidad_g;
	}

	public void setCapacidad_g(String capacidad_g) {
		this.capacidad_g = capacidad_g;
	}

	public String getMarca_g() {
		return marca_g;
	}

	public void setMarca_g(String marca_g) {
		this.marca_g = marca_g;
	}

	public String getTiveh_g() {
		return tiveh_g;
	}

	public void setTiveh_g(String tiveh_g) {
		this.tiveh_g = tiveh_g;
	}

	public String getModelo_g() {
		return modelo_g;
	}

	public void setModelo_g(String modelo_g) {
		this.modelo_g = modelo_g;
	}

	public String getNupla_h() {
		return nupla_h;
	}

	public void setNupla_h(String nupla_h) {
		this.nupla_h = nupla_h;
	}

	public String getNiv_h() {
		return niv_h;
	}

	public void setNiv_h(String niv_h) {
		this.niv_h = niv_h;
	}

	public String getCapacidad_h() {
		return capacidad_h;
	}

	public void setCapacidad_h(String capacidad_h) {
		this.capacidad_h = capacidad_h;
	}

	public String getMarca_h() {
		return marca_h;
	}

	public void setMarca_h(String marca_h) {
		this.marca_h = marca_h;
	}

	public String getTiveh_h() {
		return tiveh_h;
	}

	public void setTiveh_h(String tiveh_h) {
		this.tiveh_h = tiveh_h;
	}

	public String getModelo_h() {
		return modelo_h;
	}

	public void setModelo_h(String modelo_h) {
		this.modelo_h = modelo_h;
	}

	public String getNutoverec() {
		return nutoverec;
	}

	public void setNutoverec(String nutoverec) {
		this.nutoverec = nutoverec;
	}

	public String getSeofemneg() {
		return seofemneg;
	}

	public void setSeofemneg(String seofemneg) {
		this.seofemneg = seofemneg;
	}

	public String getCltrmaesp() {
		return cltrmaesp;
	}

	public void setCltrmaesp(String cltrmaesp) {
		this.cltrmaesp = cltrmaesp;
	}

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

}
