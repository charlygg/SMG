package com.mkyong.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tramite_licencia_funcionamiento")
public class Tramite_licencia_funcionamiento {

	@Id
	@GeneratedValue
	@Column(name = "idtramite_licencia_funcionamiento")
	private int idtramite_licencia_funcionamiento;
	
	@Column(name = "catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento")
	private int catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento;
	
	@Column(name = "catalogo_perfilempresa_idcatalogo_perfilempresa")
	private int catalogo_perfilempresa_idcatalogo_perfilempresa;
	
	@Column(name = "estatus")
	private int estatus;
	
	@Column(name = "UUID")
	private String UUID;

	@Column(name = "actaC")
	private String actaC;
	
	@Column(name = "poderRL")
	private String poderRL;
	
	@Column(name = "licenciaUS")
	private String licenciaUS;
	
	@Column(name = "analisisEFF")
	private String analisisEFF;
	
	@Column(name = "observaciones")
	private String observaciones;
	
	@Column(name = "personaEAA")
	private String personaEAA;
	
	@Column(name = "telefonoP")
	private String telefonoP;
	
	@Column(name = "emailP")
	private String emailP;
	
	@Column(name = "actividadG")
	private String actividadG;
	
	@Column(name = "fechaIA")
	private String fechaIA;
	
	@Column(name = "registroFC")
	private String registroFC;
	
	@Column(name = "numeroEA")
	private String numeroEA;
	
	@Column(name = "numeroEO")
	private String numeroEO;
	@Column(name = "numeroET")
	private String numeroET;
	@Column(name = "tiempoOHD")
	private String tiempoOHD;
	@Column(name = "tiempoODS")
	private String tiempoODS;
	@Column(name = "tiempoOSA")
	private String tiempoOSA;
	
	@Column(name = "coordenadasG")
	private String coordenadasG;
	
	@Column(name = "colindanciasN")
	private String colindanciasN;
	
	@Column(name = "coordenadasS")
	private String coordenadasS;
	
	@Column(name = "coordenadasE")
	private String coordenadasE;
	
	@Column(name = "coordenadasO")
	private String coordenadasO;
	
	@Column(name = "areaTP")
	private String areaTP;
	
	@Column(name = "areaTC")
	private String areaTC;
	
	@Column(name = "materiasPEP11")
	private String materiasPEP11;
	
	@Column(name = "materiasPEP12")
	private String materiasPEP12;
	
	@Column(name = "materiasPEP13")
	private String materiasPEP13;
	
	@Column(name = "materiasPEP14")
	private String materiasPEP14;
	
	@Column(name = "materiasPEP15")
	private String materiasPEP15;
	
	@Column(name = "materiasPEP16")
	private String materiasPEP16;

	@Column(name = "materiasPEP17")
	private String materiasPEP17;

	@Column(name = "materiasPEP21")
	private String materiasPEP21;

	@Column(name = "materiasPEP22")
	private String materiasPEP22;

	@Column(name = "materiasPEP23")
	private String materiasPEP23;

	@Column(name = "materiasPEP24")
	private String materiasPEP24;

	@Column(name = "materiasPEP25")
	private String materiasPEP25;

	@Column(name = "materiasPEP26")
	private String materiasPEP26;

	@Column(name = "materiasPEP27")
	private String materiasPEP27;

	@Column(name = "materiasPEP31")
	private String materiasPEP31;
	
	@Column(name = "materiasPEP32")
	private String materiasPEP32;
	
	@Column(name = "materiasPEP33")
	private String materiasPEP33;
	@Column(name = "materiasPEP34")
	private String materiasPEP34;
	@Column(name = "materiasPEP35")
	private String materiasPEP35;
	@Column(name = "materiasPEP36")
	private String materiasPEP36;
	@Column(name = "materiasPEP37")
	private String materiasPEP37;
	@Column(name = "materiasPEP41")
	private String materiasPEP41;
	@Column(name = "materiasPEP42")
	private String materiasPEP42;
	
	@Column(name = "materiasPEP43")
	private String materiasPEP43;
	
	@Column(name = "materiasPEP44")
	private String materiasPEP44;
	
	@Column(name = "materiasPEP45")
	private String materiasPEP45;
	
	@Column(name = "materiasPEP46")
	private String materiasPEP46;
	
	@Column(name = "materiasPEP47")
	private String materiasPEP47;
	
	@Column(name = "productosST11")
	private String productosST11;
	
	@Column(name = "productosST12")
	private String productosST12;

	@Column(name = "productosST13")
	private String productosST13;
	
	@Column(name = "productosST14")
	private String productosST14;
	
	@Column(name = "productosST15")
	private String productosST15;
	
	@Column(name = "productosST16")
	private String productosST16;
	
	@Column(name = "productosST17")
	private String productosST17;

	@Column(name = "productosST18")
	private String productosST18;

	@Column(name = "productosST21")
	private String productosST21;

	@Column(name = "productosST22")
	private String productosST22;

	@Column(name = "productosST23")
	private String productosST23;

	@Column(name = "productosST24")
	private String productosST24;

	@Column(name = "productosST25")
	private String productosST25;

	@Column(name = "productosST26")
	private String productosST26;

	@Column(name = "productosST27")
	private String productosST27;

	@Column(name = "productosST31")
	private String productosST31;

	@Column(name = "productosST32")
	private String productosST32;

	@Column(name = "productosST33")
	private String productosST33;

	@Column(name = "productosST34")
	private String productosST34;

	@Column(name = "productosST35")
	private String productosST35;

	@Column(name = "productosST36")
	private String productosST36;

	@Column(name = "productosST37")
	private String productosST37;

	@Column(name = "productosST38")
	private String productosST38;

	@Column(name = "equiposFGEA11")
	private String equiposFGEA11;

	@Column(name = "equiposFGEA12")
	private String equiposFGEA12;

	@Column(name = "equiposFGEA13")
	private String equiposFGEA13;

	@Column(name = "equiposFGEA14")
	private String equiposFGEA14;
	
	@Column(name = "equiposFGEA15")
	private String equiposFGEA15;
	
	@Column(name = "equiposFGEA16")
	private String equiposFGEA16;
	
	@Column(name = "equiposFGEA17")
	private String equiposFGEA17;
	
	@Column(name = "equiposFGEA21")
	private String equiposFGEA21;
	
	@Column(name = "equiposFGEA22")
	private String equiposFGEA22;
	
	@Column(name = "equiposFGEA23")
	private String equiposFGEA23;
	
	@Column(name = "equiposFGEA24")
	private String equiposFGEA24;
	
	@Column(name = "equiposFGEA25")
	private String equiposFGEA25;
	
	@Column(name = "equiposFGEA26")
	private String equiposFGEA26;
	
	@Column(name = "equiposFGEA27")
	private String equiposFGEA27;
	
	@Column(name = "equiposFGEA31")
	private String equiposFGEA31;
	
	@Column(name = "equiposFGEA32")
	private String equiposFGEA32;
	
	@Column(name = "equiposFGEA33")
	private String equiposFGEA33;

	@Column(name = "equiposFGEA34")
	private String equiposFGEA34;
	
	@Column(name = "equiposFGEA35")
	private String equiposFGEA35;
	
	@Column(name = "equiposFGEA36")
	private String equiposFGEA36;

	@Column(name = "equiposFGEA41")
	private String equiposFGEA41;
	
	@Column(name = "equiposFGEA42")
	private String equiposFGEA42;
	
	@Column(name = "equiposFGEA43")
	private String equiposFGEA43;
	
	@Column(name = "equiposFGEA44")
	private String equiposFGEA44;
	
	@Column(name = "equiposFGEA45")
	private String equiposFGEA45;
	
	@Column(name = "equiposFGEA46")
	private String equiposFGEA46;
	
	@Column(name = "equiposFGEA47")
	private String equiposFGEA47;


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

	public int getIdtramite_licencia_funcionamiento() {
		return idtramite_licencia_funcionamiento;
	}

	public void setIdtramite_licencia_funcionamiento(
			int idtramite_licencia_funcionamiento) {
		this.idtramite_licencia_funcionamiento = idtramite_licencia_funcionamiento;
	}

	public int getCatalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento() {
		return catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento;
	}

	public void setCatalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento(
			int catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento) {
		this.catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento = catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento;
	}

	public int getCatalogo_perfilempresa_idcatalogo_perfilempresa() {
		return catalogo_perfilempresa_idcatalogo_perfilempresa;
	}

	public void setCatalogo_perfilempresa_idcatalogo_perfilempresa(
			int catalogo_perfilempresa_idcatalogo_perfilempresa) {
		this.catalogo_perfilempresa_idcatalogo_perfilempresa = catalogo_perfilempresa_idcatalogo_perfilempresa;
	}

	public String getActaC() {
		return actaC;
	}

	public void setActaC(String actaC) {
		this.actaC = actaC;
	}

	public String getPoderRL() {
		return poderRL;
	}

	public void setPoderRL(String poderRL) {
		this.poderRL = poderRL;
	}

	public String getLicenciaUS() {
		return licenciaUS;
	}

	public void setLicenciaUS(String licenciaUS) {
		this.licenciaUS = licenciaUS;
	}

	public String getAnalisisEFF() {
		return analisisEFF;
	}

	public void setAnalisisEFF(String analisisEFF) {
		this.analisisEFF = analisisEFF;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getPersonaEAA() {
		return personaEAA;
	}

	public void setPersonaEAA(String personaEAA) {
		this.personaEAA = personaEAA;
	}

	public String getTelefonoP() {
		return telefonoP;
	}

	public void setTelefonoP(String telefonoP) {
		this.telefonoP = telefonoP;
	}

	public String getEmailP() {
		return emailP;
	}

	public void setEmailP(String emailP) {
		this.emailP = emailP;
	}

	public String getActividadG() {
		return actividadG;
	}

	public void setActividadG(String actividadG) {
		this.actividadG = actividadG;
	}

	public String getFechaIA() {
		return fechaIA;
	}

	public void setFechaIA(String fechaIA) {
		this.fechaIA = fechaIA;
	}

	public String getRegistroFC() {
		return registroFC;
	}

	public void setRegistroFC(String registroFC) {
		this.registroFC = registroFC;
	}

	public String getNumeroEA() {
		return numeroEA;
	}

	public void setNumeroEA(String numeroEA) {
		this.numeroEA = numeroEA;
	}

	public String getNumeroEO() {
		return numeroEO;
	}

	public void setNumeroEO(String numeroEO) {
		this.numeroEO = numeroEO;
	}

	public String getNumeroET() {
		return numeroET;
	}

	public void setNumeroET(String numeroET) {
		this.numeroET = numeroET;
	}

	public String getTiempoOHD() {
		return tiempoOHD;
	}

	public void setTiempoOHD(String tiempoOHD) {
		this.tiempoOHD = tiempoOHD;
	}

	public String getTiempoODS() {
		return tiempoODS;
	}

	public void setTiempoODS(String tiempoODS) {
		this.tiempoODS = tiempoODS;
	}

	public String getTiempoOSA() {
		return tiempoOSA;
	}

	public void setTiempoOSA(String tiempoOSA) {
		this.tiempoOSA = tiempoOSA;
	}

	public String getCoordenadasG() {
		return coordenadasG;
	}

	public void setCoordenadasG(String coordenadasG) {
		this.coordenadasG = coordenadasG;
	}

	public String getColindanciasN() {
		return colindanciasN;
	}

	public void setColindanciasN(String colindanciasN) {
		this.colindanciasN = colindanciasN;
	}

	public String getCoordenadasS() {
		return coordenadasS;
	}

	public void setCoordenadasS(String coordenadasS) {
		this.coordenadasS = coordenadasS;
	}

	public String getCoordenadasE() {
		return coordenadasE;
	}

	public void setCoordenadasE(String coordenadasE) {
		this.coordenadasE = coordenadasE;
	}

	public String getCoordenadasO() {
		return coordenadasO;
	}

	public void setCoordenadasO(String coordenadasO) {
		this.coordenadasO = coordenadasO;
	}

	public String getAreaTP() {
		return areaTP;
	}

	public void setAreaTP(String areaTP) {
		this.areaTP = areaTP;
	}

	public String getAreaTC() {
		return areaTC;
	}

	public void setAreaTC(String areaTC) {
		this.areaTC = areaTC;
	}

	public String getMateriasPEP11() {
		return materiasPEP11;
	}

	public void setMateriasPEP11(String materiasPEP11) {
		this.materiasPEP11 = materiasPEP11;
	}

	public String getMateriasPEP12() {
		return materiasPEP12;
	}

	public void setMateriasPEP12(String materiasPEP12) {
		this.materiasPEP12 = materiasPEP12;
	}

	public String getMateriasPEP13() {
		return materiasPEP13;
	}

	public void setMateriasPEP13(String materiasPEP13) {
		this.materiasPEP13 = materiasPEP13;
	}

	public String getMateriasPEP14() {
		return materiasPEP14;
	}

	public void setMateriasPEP14(String materiasPEP14) {
		this.materiasPEP14 = materiasPEP14;
	}

	public String getMateriasPEP15() {
		return materiasPEP15;
	}

	public void setMateriasPEP15(String materiasPEP15) {
		this.materiasPEP15 = materiasPEP15;
	}

	public String getMateriasPEP16() {
		return materiasPEP16;
	}

	public void setMateriasPEP16(String materiasPEP16) {
		this.materiasPEP16 = materiasPEP16;
	}

	public String getMateriasPEP17() {
		return materiasPEP17;
	}

	public void setMateriasPEP17(String materiasPEP17) {
		this.materiasPEP17 = materiasPEP17;
	}

	public String getMateriasPEP21() {
		return materiasPEP21;
	}

	public void setMateriasPEP21(String materiasPEP21) {
		this.materiasPEP21 = materiasPEP21;
	}

	public String getMateriasPEP22() {
		return materiasPEP22;
	}

	public void setMateriasPEP22(String materiasPEP22) {
		this.materiasPEP22 = materiasPEP22;
	}

	public String getMateriasPEP23() {
		return materiasPEP23;
	}

	public void setMateriasPEP23(String materiasPEP23) {
		this.materiasPEP23 = materiasPEP23;
	}

	public String getMateriasPEP24() {
		return materiasPEP24;
	}

	public void setMateriasPEP24(String materiasPEP24) {
		this.materiasPEP24 = materiasPEP24;
	}

	public String getMateriasPEP25() {
		return materiasPEP25;
	}

	public void setMateriasPEP25(String materiasPEP25) {
		this.materiasPEP25 = materiasPEP25;
	}

	public String getMateriasPEP26() {
		return materiasPEP26;
	}

	public void setMateriasPEP26(String materiasPEP26) {
		this.materiasPEP26 = materiasPEP26;
	}

	public String getMateriasPEP27() {
		return materiasPEP27;
	}

	public void setMateriasPEP27(String materiasPEP27) {
		this.materiasPEP27 = materiasPEP27;
	}

	public String getMateriasPEP31() {
		return materiasPEP31;
	}

	public void setMateriasPEP31(String materiasPEP31) {
		this.materiasPEP31 = materiasPEP31;
	}

	public String getMateriasPEP32() {
		return materiasPEP32;
	}

	public void setMateriasPEP32(String materiasPEP32) {
		this.materiasPEP32 = materiasPEP32;
	}

	public String getMateriasPEP33() {
		return materiasPEP33;
	}

	public void setMateriasPEP33(String materiasPEP33) {
		this.materiasPEP33 = materiasPEP33;
	}

	public String getMateriasPEP34() {
		return materiasPEP34;
	}

	public void setMateriasPEP34(String materiasPEP34) {
		this.materiasPEP34 = materiasPEP34;
	}

	public String getMateriasPEP35() {
		return materiasPEP35;
	}

	public void setMateriasPEP35(String materiasPEP35) {
		this.materiasPEP35 = materiasPEP35;
	}

	public String getMateriasPEP36() {
		return materiasPEP36;
	}

	public void setMateriasPEP36(String materiasPEP36) {
		this.materiasPEP36 = materiasPEP36;
	}

	public String getMateriasPEP37() {
		return materiasPEP37;
	}

	public void setMateriasPEP37(String materiasPEP37) {
		this.materiasPEP37 = materiasPEP37;
	}

	public String getMateriasPEP41() {
		return materiasPEP41;
	}

	public void setMateriasPEP41(String materiasPEP41) {
		this.materiasPEP41 = materiasPEP41;
	}

	public String getMateriasPEP42() {
		return materiasPEP42;
	}

	public void setMateriasPEP42(String materiasPEP42) {
		this.materiasPEP42 = materiasPEP42;
	}

	public String getMateriasPEP43() {
		return materiasPEP43;
	}

	public void setMateriasPEP43(String materiasPEP43) {
		this.materiasPEP43 = materiasPEP43;
	}

	public String getMateriasPEP44() {
		return materiasPEP44;
	}

	public void setMateriasPEP44(String materiasPEP44) {
		this.materiasPEP44 = materiasPEP44;
	}

	public String getMateriasPEP45() {
		return materiasPEP45;
	}

	public void setMateriasPEP45(String materiasPEP45) {
		this.materiasPEP45 = materiasPEP45;
	}

	public String getMateriasPEP46() {
		return materiasPEP46;
	}

	public void setMateriasPEP46(String materiasPEP46) {
		this.materiasPEP46 = materiasPEP46;
	}

	public String getMateriasPEP47() {
		return materiasPEP47;
	}

	public void setMateriasPEP47(String materiasPEP47) {
		this.materiasPEP47 = materiasPEP47;
	}

	public String getProductosST11() {
		return productosST11;
	}

	public void setProductosST11(String productosST11) {
		this.productosST11 = productosST11;
	}

	public String getProductosST12() {
		return productosST12;
	}

	public void setProductosST12(String productosST12) {
		this.productosST12 = productosST12;
	}

	public String getProductosST13() {
		return productosST13;
	}

	public void setProductosST13(String productosST13) {
		this.productosST13 = productosST13;
	}

	public String getProductosST14() {
		return productosST14;
	}

	public void setProductosST14(String productosST14) {
		this.productosST14 = productosST14;
	}

	public String getProductosST15() {
		return productosST15;
	}

	public void setProductosST15(String productosST15) {
		this.productosST15 = productosST15;
	}

	public String getProductosST16() {
		return productosST16;
	}

	public void setProductosST16(String productosST16) {
		this.productosST16 = productosST16;
	}

	public String getProductosST17() {
		return productosST17;
	}

	public void setProductosST17(String productosST17) {
		this.productosST17 = productosST17;
	}

	public String getProductosST18() {
		return productosST18;
	}

	public void setProductosST18(String productosST18) {
		this.productosST18 = productosST18;
	}

	public String getProductosST21() {
		return productosST21;
	}

	public void setProductosST21(String productosST21) {
		this.productosST21 = productosST21;
	}

	public String getProductosST22() {
		return productosST22;
	}

	public void setProductosST22(String productosST22) {
		this.productosST22 = productosST22;
	}

	public String getProductosST23() {
		return productosST23;
	}

	public void setProductosST23(String productosST23) {
		this.productosST23 = productosST23;
	}

	public String getProductosST24() {
		return productosST24;
	}

	public void setProductosST24(String productosST24) {
		this.productosST24 = productosST24;
	}

	public String getProductosST25() {
		return productosST25;
	}

	public void setProductosST25(String productosST25) {
		this.productosST25 = productosST25;
	}

	public String getProductosST26() {
		return productosST26;
	}

	public void setProductosST26(String productosST26) {
		this.productosST26 = productosST26;
	}

	public String getProductosST27() {
		return productosST27;
	}

	public void setProductosST27(String productosST27) {
		this.productosST27 = productosST27;
	}

	public String getProductosST31() {
		return productosST31;
	}

	public void setProductosST31(String productosST31) {
		this.productosST31 = productosST31;
	}

	public String getProductosST32() {
		return productosST32;
	}

	public void setProductosST32(String productosST32) {
		this.productosST32 = productosST32;
	}

	public String getProductosST33() {
		return productosST33;
	}

	public void setProductosST33(String productosST33) {
		this.productosST33 = productosST33;
	}

	public String getProductosST34() {
		return productosST34;
	}

	public void setProductosST34(String productosST34) {
		this.productosST34 = productosST34;
	}

	public String getProductosST35() {
		return productosST35;
	}

	public void setProductosST35(String productosST35) {
		this.productosST35 = productosST35;
	}

	public String getProductosST36() {
		return productosST36;
	}

	public void setProductosST36(String productosST36) {
		this.productosST36 = productosST36;
	}

	public String getProductosST37() {
		return productosST37;
	}

	public void setProductosST37(String productosST37) {
		this.productosST37 = productosST37;
	}

	public String getProductosST38() {
		return productosST38;
	}

	public void setProductosST38(String productosST38) {
		this.productosST38 = productosST38;
	}

	public String getEquiposFGEA11() {
		return equiposFGEA11;
	}

	public void setEquiposFGEA11(String equiposFGEA11) {
		this.equiposFGEA11 = equiposFGEA11;
	}

	public String getEquiposFGEA12() {
		return equiposFGEA12;
	}

	public void setEquiposFGEA12(String equiposFGEA12) {
		this.equiposFGEA12 = equiposFGEA12;
	}

	public String getEquiposFGEA13() {
		return equiposFGEA13;
	}

	public void setEquiposFGEA13(String equiposFGEA13) {
		this.equiposFGEA13 = equiposFGEA13;
	}

	public String getEquiposFGEA14() {
		return equiposFGEA14;
	}

	public void setEquiposFGEA14(String equiposFGEA14) {
		this.equiposFGEA14 = equiposFGEA14;
	}

	public String getEquiposFGEA15() {
		return equiposFGEA15;
	}

	public void setEquiposFGEA15(String equiposFGEA15) {
		this.equiposFGEA15 = equiposFGEA15;
	}

	public String getEquiposFGEA16() {
		return equiposFGEA16;
	}

	public void setEquiposFGEA16(String equiposFGEA16) {
		this.equiposFGEA16 = equiposFGEA16;
	}

	public String getEquiposFGEA17() {
		return equiposFGEA17;
	}

	public void setEquiposFGEA17(String equiposFGEA17) {
		this.equiposFGEA17 = equiposFGEA17;
	}

	public String getEquiposFGEA21() {
		return equiposFGEA21;
	}

	public void setEquiposFGEA21(String equiposFGEA21) {
		this.equiposFGEA21 = equiposFGEA21;
	}

	public String getEquiposFGEA22() {
		return equiposFGEA22;
	}

	public void setEquiposFGEA22(String equiposFGEA22) {
		this.equiposFGEA22 = equiposFGEA22;
	}

	public String getEquiposFGEA23() {
		return equiposFGEA23;
	}

	public void setEquiposFGEA23(String equiposFGEA23) {
		this.equiposFGEA23 = equiposFGEA23;
	}

	public String getEquiposFGEA24() {
		return equiposFGEA24;
	}

	public void setEquiposFGEA24(String equiposFGEA24) {
		this.equiposFGEA24 = equiposFGEA24;
	}

	public String getEquiposFGEA25() {
		return equiposFGEA25;
	}

	public void setEquiposFGEA25(String equiposFGEA25) {
		this.equiposFGEA25 = equiposFGEA25;
	}

	public String getEquiposFGEA26() {
		return equiposFGEA26;
	}

	public void setEquiposFGEA26(String equiposFGEA26) {
		this.equiposFGEA26 = equiposFGEA26;
	}

	public String getEquiposFGEA27() {
		return equiposFGEA27;
	}

	public void setEquiposFGEA27(String equiposFGEA27) {
		this.equiposFGEA27 = equiposFGEA27;
	}

	public String getEquiposFGEA31() {
		return equiposFGEA31;
	}

	public void setEquiposFGEA31(String equiposFGEA31) {
		this.equiposFGEA31 = equiposFGEA31;
	}

	public String getEquiposFGEA32() {
		return equiposFGEA32;
	}

	public void setEquiposFGEA32(String equiposFGEA32) {
		this.equiposFGEA32 = equiposFGEA32;
	}

	public String getEquiposFGEA33() {
		return equiposFGEA33;
	}

	public void setEquiposFGEA33(String equiposFGEA33) {
		this.equiposFGEA33 = equiposFGEA33;
	}

	public String getEquiposFGEA34() {
		return equiposFGEA34;
	}

	public void setEquiposFGEA34(String equiposFGEA34) {
		this.equiposFGEA34 = equiposFGEA34;
	}

	public String getEquiposFGEA35() {
		return equiposFGEA35;
	}

	public void setEquiposFGEA35(String equiposFGEA35) {
		this.equiposFGEA35 = equiposFGEA35;
	}

	public String getEquiposFGEA36() {
		return equiposFGEA36;
	}

	public void setEquiposFGEA36(String equiposFGEA36) {
		this.equiposFGEA36 = equiposFGEA36;
	}

	public String getEquiposFGEA41() {
		return equiposFGEA41;
	}

	public void setEquiposFGEA41(String equiposFGEA41) {
		this.equiposFGEA41 = equiposFGEA41;
	}

	public String getEquiposFGEA42() {
		return equiposFGEA42;
	}

	public void setEquiposFGEA42(String equiposFGEA42) {
		this.equiposFGEA42 = equiposFGEA42;
	}

	public String getEquiposFGEA43() {
		return equiposFGEA43;
	}

	public void setEquiposFGEA43(String equiposFGEA43) {
		this.equiposFGEA43 = equiposFGEA43;
	}

	public String getEquiposFGEA44() {
		return equiposFGEA44;
	}

	public void setEquiposFGEA44(String equiposFGEA44) {
		this.equiposFGEA44 = equiposFGEA44;
	}

	public String getEquiposFGEA45() {
		return equiposFGEA45;
	}

	public void setEquiposFGEA45(String equiposFGEA45) {
		this.equiposFGEA45 = equiposFGEA45;
	}

	public String getEquiposFGEA46() {
		return equiposFGEA46;
	}

	public void setEquiposFGEA46(String equiposFGEA46) {
		this.equiposFGEA46 = equiposFGEA46;
	}

	public String getEquiposFGEA47() {
		return equiposFGEA47;
	}

	public void setEquiposFGEA47(String equiposFGEA47) {
		this.equiposFGEA47 = equiposFGEA47;
	}
	
	
}
