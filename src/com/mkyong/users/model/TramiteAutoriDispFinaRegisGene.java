package com.mkyong.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tramiteautoridispfinaregisgene")
public class TramiteAutoriDispFinaRegisGene {
	
	@Id
	@GeneratedValue
	@Column(name = "idtramite")
	private int idtramite;
	
	@Column(name = "idempresa")
	private int idempresa;
	
	@Column(name = "idestablecimiento")
	private int idestablecimiento;
	
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
	
	@Column(name = "descproceprod")
	private String descproceprod;
	
	@Column(name = "residuoa")
	private String residuoa;
	
	@Column(name = "procesogeneraa")
	private String procesogeneraa;
	
	@Column(name = "emprecolectoraa")
	private String emprecolectoraa;
	
	@Column(name = "numautorizaciona")
	private String numautorizaciona;

	@Column(name = "generamensuala")
	private String generamensuala;

	@Column(name = "sitiodispfinala")
	private String sitiodispfinala;

	@Column(name = "residuob")
	private String residuob;

	@Column(name = "procesogenerab")
	private String procesogenerab;

	@Column(name = "emprecolectorab")
	private String emprecolectorab;

	@Column(name = "generamensualb")
	private String generamensualb;

	@Column(name = "sitiodispfinalb")
	private String sitiodispfinalb;

	@Column(name = "numautorizacionb")
	private String numautorizacionb;

	@Column(name = "residuoc")
	private String residuoc;

	@Column(name = "procesogenerac")
	private String procesogenerac;

	@Column(name = "emprecolectorac")
	private String emprecolectorac;

	@Column(name = "numautorizacionc")
	private String numautorizacionc;

	@Column(name = "generamensualc")
	private String generamensualc;

	@Column(name = "sitiodispfinalc")
	private String sitiodispfinalc;

	@Column(name = "residuod")
	private String residuod;

	@Column(name = "procesogenerad")
	private String procesogenerad;

	@Column(name = "emprecolectorad")
	private String emprecolectorad;
	
	@Column(name = "numautorizaciond")
	private String numautorizaciond;

	@Column(name = "generamensuald")
	private String generamensuald;

	@Column(name = "sitiodispfinald")
	private String sitiodispfinald;

	@Column(name = "residuoe")
	private String residuoe;

	@Column(name = "procesogenerae")
	private String procesogenerae;

	@Column(name = "emprecolectorae")
	private String emprecolectorae;

	@Column(name = "numautorizacione")
	private String numautorizacione;

	@Column(name = "generamensuale")
	private String generamensuale;

	@Column(name = "sitiodispfinale")
	private String sitiodispfinale;

	@Column(name = "residuof")
	private String residuof;

	@Column(name = "procesogeneraf")
	private String procesogeneraf;

	@Column(name = "emprecolectoraf")
	private String emprecolectoraf;

	@Column(name = "numautorizacionf")
	private String numautorizacionf;

	@Column(name = "generamensualf")
	private String generamensualf;

	@Column(name = "sitiodispfinalf")
	private String sitiodispfinalf;

	@Column(name = "materialreciclablea")
	private String materialreciclablea;

	@Column(name = "gentonpormesa")
	private String gentonpormesa;

	@Column(name = "procgeneraa")
	private String procgeneraa;

	@Column(name = "empcompmata")
	private String empcompmata;

	@Column(name = "numautcompventa")
	private String numautcompventa;

	@Column(name = "numauttransrecica")
	private String numauttransrecica;

	@Column(name = "materialreciclableb")
	private String materialreciclableb;

	@Column(name = "gentonpormesb")
	private String gentonpormesb;

	@Column(name = "procgenerab")
	private String procgenerab;

	@Column(name = "empcompmatb")
	private String empcompmatb;

	@Column(name = "numautcompventb")
	private String numautcompventb;

	@Column(name = "numauttransrecicb")
	private String numauttransrecicb;

	@Column(name = "materialreciclablec")
	private String materialreciclablec;

	@Column(name = "gentonpormesc")
	private String gentonpormesc;

	@Column(name = "procgenerac")
	private String procgenerac;

	@Column(name = "empcompmatc")
	private String empcompmatc;

	@Column(name = "numautcompventc")
	private String numautcompventc;

	@Column(name = "numauttransrecicc")
	private String numauttransrecicc;

	@Column(name = "materialreciclabled")
	private String materialreciclabled;

	@Column(name = "gentonpormesd")
	private String gentonpormesd;

	@Column(name = "procgenerad")
	private String procgenerad;

	@Column(name = "empcompmatd")
	private String empcompmatd;

	@Column(name = "numautcompventd")
	private String numautcompventd;

	@Column(name = "numauttransrecicd")
	private String numauttransrecicd;

	@Column(name = "materialreciclablee")
	private String materialreciclablee;

	@Column(name = "gentonpormese")
	private String gentonpormese;

	@Column(name = "procgenerae")
	private String procgenerae;

	@Column(name = "empcompmate")
	private String empcompmate;
	
	@Column(name = "numautcompvente")
	private String numautcompvente;
	
	@Column(name = "numauttransrecice")
	private String numauttransrecice;
	
	@Column(name = "usoindustrial")
	private String usoindustrial;
	
	@Column(name = "usotro")
	private String usotro;
		
	@Column(name = "rtgadescripcion")
	private String rtgadescripcion;
	
	@Column(name = "rtgafreclimp")
	private String rtgafreclimp;
	
	@Column(name = "rtgacapacidadm3tramp")
	private String rtgacapacidadm3tramp;
	
	@Column(name = "rtgageneramens")
	private String rtgageneramens;
	
	@Column(name = "rtgalugdisrestra")
	private String rtgalugdisrestra;
	
	@Column(name = "rtganumafprov")
	private String rtganumafprov;

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
	
	@Column(name = "idestablecimientomens")
	private int idestablecimientomens;
	

	public int getIdestablecimientomens() {
		return idestablecimientomens;
	}

	public void setIdestablecimientomens(int idestablecimientomens) {
		this.idestablecimientomens = idestablecimientomens;
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

	public String getDescproceprod() {
		return descproceprod;
	}

	public void setDescproceprod(String descproceprod) {
		this.descproceprod = descproceprod;
	}

	public String getResiduoa() {
		return residuoa;
	}

	public void setResiduoa(String residuoa) {
		this.residuoa = residuoa;
	}

	public String getProcesogeneraa() {
		return procesogeneraa;
	}

	public void setProcesogeneraa(String procesogeneraa) {
		this.procesogeneraa = procesogeneraa;
	}

	public String getEmprecolectoraa() {
		return emprecolectoraa;
	}

	public void setEmprecolectoraa(String emprecolectoraa) {
		this.emprecolectoraa = emprecolectoraa;
	}

	public String getNumautorizaciona() {
		return numautorizaciona;
	}

	public void setNumautorizaciona(String numautorizaciona) {
		this.numautorizaciona = numautorizaciona;
	}

	public String getGeneramensuala() {
		return generamensuala;
	}

	public void setGeneramensuala(String generamensuala) {
		this.generamensuala = generamensuala;
	}

	public String getSitiodispfinala() {
		return sitiodispfinala;
	}

	public void setSitiodispfinala(String sitiodispfinala) {
		this.sitiodispfinala = sitiodispfinala;
	}

	public String getResiduob() {
		return residuob;
	}

	public void setResiduob(String residuob) {
		this.residuob = residuob;
	}

	public String getProcesogenerab() {
		return procesogenerab;
	}

	public void setProcesogenerab(String procesogenerab) {
		this.procesogenerab = procesogenerab;
	}

	public String getEmprecolectorab() {
		return emprecolectorab;
	}

	public void setEmprecolectorab(String emprecolectorab) {
		this.emprecolectorab = emprecolectorab;
	}

	public String getGeneramensualb() {
		return generamensualb;
	}

	public void setGeneramensualb(String generamensualb) {
		this.generamensualb = generamensualb;
	}

	public String getSitiodispfinalb() {
		return sitiodispfinalb;
	}

	public void setSitiodispfinalb(String sitiodispfinalb) {
		this.sitiodispfinalb = sitiodispfinalb;
	}

	public String getNumautorizacionb() {
		return numautorizacionb;
	}

	public void setNumautorizacionb(String numautorizacionb) {
		this.numautorizacionb = numautorizacionb;
	}

	public String getResiduoc() {
		return residuoc;
	}

	public void setResiduoc(String residuoc) {
		this.residuoc = residuoc;
	}

	public String getProcesogenerac() {
		return procesogenerac;
	}

	public void setProcesogenerac(String procesogenerac) {
		this.procesogenerac = procesogenerac;
	}

	public String getEmprecolectorac() {
		return emprecolectorac;
	}

	public void setEmprecolectorac(String emprecolectorac) {
		this.emprecolectorac = emprecolectorac;
	}

	public String getNumautorizacionc() {
		return numautorizacionc;
	}

	public void setNumautorizacionc(String numautorizacionc) {
		this.numautorizacionc = numautorizacionc;
	}

	public String getGeneramensualc() {
		return generamensualc;
	}

	public void setGeneramensualc(String generamensualc) {
		this.generamensualc = generamensualc;
	}

	public String getSitiodispfinalc() {
		return sitiodispfinalc;
	}

	public void setSitiodispfinalc(String sitiodispfinalc) {
		this.sitiodispfinalc = sitiodispfinalc;
	}

	public String getResiduod() {
		return residuod;
	}

	public void setResiduod(String residuod) {
		this.residuod = residuod;
	}

	public String getProcesogenerad() {
		return procesogenerad;
	}

	public void setProcesogenerad(String procesogenerad) {
		this.procesogenerad = procesogenerad;
	}

	public String getNumautorizaciond() {
		return numautorizaciond;
	}

	public void setNumautorizaciond(String numautorizaciond) {
		this.numautorizaciond = numautorizaciond;
	}

	public String getGeneramensuald() {
		return generamensuald;
	}

	public void setGeneramensuald(String generamensuald) {
		this.generamensuald = generamensuald;
	}

	public String getSitiodispfinald() {
		return sitiodispfinald;
	}

	public void setSitiodispfinald(String sitiodispfinald) {
		this.sitiodispfinald = sitiodispfinald;
	}

	public String getResiduoe() {
		return residuoe;
	}

	public void setResiduoe(String residuoe) {
		this.residuoe = residuoe;
	}

	public String getProcesogenerae() {
		return procesogenerae;
	}

	public void setProcesogenerae(String procesogenerae) {
		this.procesogenerae = procesogenerae;
	}

	public String getEmprecolectorae() {
		return emprecolectorae;
	}

	public void setEmprecolectorae(String emprecolectorae) {
		this.emprecolectorae = emprecolectorae;
	}

	public String getNumautorizacione() {
		return numautorizacione;
	}

	public void setNumautorizacione(String numautorizacione) {
		this.numautorizacione = numautorizacione;
	}

	public String getGeneramensuale() {
		return generamensuale;
	}

	public void setGeneramensuale(String generamensuale) {
		this.generamensuale = generamensuale;
	}

	public String getSitiodispfinale() {
		return sitiodispfinale;
	}

	public void setSitiodispfinale(String sitiodispfinale) {
		this.sitiodispfinale = sitiodispfinale;
	}

	public String getResiduof() {
		return residuof;
	}

	public void setResiduof(String residuof) {
		this.residuof = residuof;
	}

	public String getProcesogeneraf() {
		return procesogeneraf;
	}

	public void setProcesogeneraf(String procesogeneraf) {
		this.procesogeneraf = procesogeneraf;
	}

	public String getEmprecolectoraf() {
		return emprecolectoraf;
	}

	public void setEmprecolectoraf(String emprecolectoraf) {
		this.emprecolectoraf = emprecolectoraf;
	}

	public String getNumautorizacionf() {
		return numautorizacionf;
	}

	public void setNumautorizacionf(String numautorizacionf) {
		this.numautorizacionf = numautorizacionf;
	}

	public String getGeneramensualf() {
		return generamensualf;
	}

	public void setGeneramensualf(String generamensualf) {
		this.generamensualf = generamensualf;
	}

	public String getSitiodispfinalf() {
		return sitiodispfinalf;
	}

	public void setSitiodispfinalf(String sitiodispfinalf) {
		this.sitiodispfinalf = sitiodispfinalf;
	}

	public String getMaterialreciclablea() {
		return materialreciclablea;
	}

	public void setMaterialreciclablea(String materialreciclablea) {
		this.materialreciclablea = materialreciclablea;
	}

	public String getGentonpormesa() {
		return gentonpormesa;
	}

	public void setGentonpormesa(String gentonpormesa) {
		this.gentonpormesa = gentonpormesa;
	}

	public String getProcgeneraa() {
		return procgeneraa;
	}

	public void setProcgeneraa(String procgeneraa) {
		this.procgeneraa = procgeneraa;
	}

	public String getEmpcompmata() {
		return empcompmata;
	}

	public void setEmpcompmata(String empcompmata) {
		this.empcompmata = empcompmata;
	}

	public String getNumautcompventa() {
		return numautcompventa;
	}

	public void setNumautcompventa(String numautcompventa) {
		this.numautcompventa = numautcompventa;
	}

	public String getNumauttransrecica() {
		return numauttransrecica;
	}

	public void setNumauttransrecica(String numauttransrecica) {
		this.numauttransrecica = numauttransrecica;
	}

	public String getMaterialreciclableb() {
		return materialreciclableb;
	}

	public void setMaterialreciclableb(String materialreciclableb) {
		this.materialreciclableb = materialreciclableb;
	}

	public String getGentonpormesb() {
		return gentonpormesb;
	}

	public void setGentonpormesb(String gentonpormesb) {
		this.gentonpormesb = gentonpormesb;
	}

	public String getProcgenerab() {
		return procgenerab;
	}

	public void setProcgenerab(String procgenerab) {
		this.procgenerab = procgenerab;
	}

	public String getEmpcompmatb() {
		return empcompmatb;
	}

	public void setEmpcompmatb(String empcompmatb) {
		this.empcompmatb = empcompmatb;
	}

	public String getNumautcompventb() {
		return numautcompventb;
	}

	public void setNumautcompventb(String numautcompventb) {
		this.numautcompventb = numautcompventb;
	}

	public String getNumauttransrecicb() {
		return numauttransrecicb;
	}

	public void setNumauttransrecicb(String numauttransrecicb) {
		this.numauttransrecicb = numauttransrecicb;
	}

	public String getMaterialreciclablec() {
		return materialreciclablec;
	}

	public void setMaterialreciclablec(String materialreciclablec) {
		this.materialreciclablec = materialreciclablec;
	}

	public String getGentonpormesc() {
		return gentonpormesc;
	}

	public void setGentonpormesc(String gentonpormesc) {
		this.gentonpormesc = gentonpormesc;
	}

	public String getProcgenerac() {
		return procgenerac;
	}

	public void setProcgenerac(String procgenerac) {
		this.procgenerac = procgenerac;
	}

	public String getEmpcompmatc() {
		return empcompmatc;
	}

	public void setEmpcompmatc(String empcompmatc) {
		this.empcompmatc = empcompmatc;
	}

	public String getNumautcompventc() {
		return numautcompventc;
	}

	public void setNumautcompventc(String numautcompventc) {
		this.numautcompventc = numautcompventc;
	}

	public String getNumauttransrecicc() {
		return numauttransrecicc;
	}

	public void setNumauttransrecicc(String numauttransrecicc) {
		this.numauttransrecicc = numauttransrecicc;
	}

	public String getMaterialreciclabled() {
		return materialreciclabled;
	}

	public void setMaterialreciclabled(String materialreciclabled) {
		this.materialreciclabled = materialreciclabled;
	}

	public String getGentonpormesd() {
		return gentonpormesd;
	}

	public void setGentonpormesd(String gentonpormesd) {
		this.gentonpormesd = gentonpormesd;
	}

	public String getProcgenerad() {
		return procgenerad;
	}

	public void setProcgenerad(String procgenerad) {
		this.procgenerad = procgenerad;
	}

	public String getEmpcompmatd() {
		return empcompmatd;
	}

	public void setEmpcompmatd(String empcompmatd) {
		this.empcompmatd = empcompmatd;
	}

	public String getNumautcompventd() {
		return numautcompventd;
	}

	public void setNumautcompventd(String numautcompventd) {
		this.numautcompventd = numautcompventd;
	}

	public String getNumauttransrecicd() {
		return numauttransrecicd;
	}

	public void setNumauttransrecicd(String numauttransrecicd) {
		this.numauttransrecicd = numauttransrecicd;
	}

	public String getMaterialreciclablee() {
		return materialreciclablee;
	}

	public void setMaterialreciclablee(String materialreciclablee) {
		this.materialreciclablee = materialreciclablee;
	}

	public String getGentonpormese() {
		return gentonpormese;
	}

	public void setGentonpormese(String gentonpormese) {
		this.gentonpormese = gentonpormese;
	}

	public String getProcgenerae() {
		return procgenerae;
	}

	public void setProcgenerae(String procgenerae) {
		this.procgenerae = procgenerae;
	}

	public String getEmpcompmate() {
		return empcompmate;
	}

	public void setEmpcompmate(String empcompmate) {
		this.empcompmate = empcompmate;
	}

	public String getNumautcompvente() {
		return numautcompvente;
	}

	public void setNumautcompvente(String numautcompvente) {
		this.numautcompvente = numautcompvente;
	}

	public String getNumauttransrecice() {
		return numauttransrecice;
	}

	public void setNumauttransrecice(String numauttransrecice) {
		this.numauttransrecice = numauttransrecice;
	}

	public String getUsoindustrial() {
		return usoindustrial;
	}

	public void setUsoindustrial(String usoindustrial) {
		this.usoindustrial = usoindustrial;
	}

	public String getUsotro() {
		return usotro;
	}

	public void setUsotro(String usotro) {
		this.usotro = usotro;
	}

	public String getRtgadescripcion() {
		return rtgadescripcion;
	}

	public void setRtgadescripcion(String rtgadescripcion) {
		this.rtgadescripcion = rtgadescripcion;
	}

	public String getRtgafreclimp() {
		return rtgafreclimp;
	}

	public void setRtgafreclimp(String rtgafreclimp) {
		this.rtgafreclimp = rtgafreclimp;
	}

	public String getRtgacapacidadm3tramp() {
		return rtgacapacidadm3tramp;
	}

	public void setRtgacapacidadm3tramp(String rtgacapacidadm3tramp) {
		this.rtgacapacidadm3tramp = rtgacapacidadm3tramp;
	}

	public String getRtgageneramens() {
		return rtgageneramens;
	}

	public void setRtgageneramens(String rtgageneramens) {
		this.rtgageneramens = rtgageneramens;
	}

	public String getRtgalugdisrestra() {
		return rtgalugdisrestra;
	}

	public void setRtgalugdisrestra(String rtgalugdisrestra) {
		this.rtgalugdisrestra = rtgalugdisrestra;
	}

	public String getRtganumafprov() {
		return rtganumafprov;
	}

	public void setRtganumafprov(String rtganumafprov) {
		this.rtganumafprov = rtganumafprov;
	}

	public String getEmprecolectorad() {
		return emprecolectorad;
	}

	public void setEmprecolectorad(String emprecolectorad) {
		this.emprecolectorad = emprecolectorad;
	}

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

}
