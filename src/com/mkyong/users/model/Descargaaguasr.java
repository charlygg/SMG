package com.mkyong.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tramite_descargaaguasr")
public class Descargaaguasr {

	@Id
	@GeneratedValue
	@Column(name = "idtramite")
	private int idtramite;

	@Column(name = "conagua")
	private String conagua;

	@Column(name = "nfolio")
	private String nfolio;
	
	@Column(name = "esnuevousu")
	private String esnuevousu;
	
	@Column(name = "regnuedesexpant")
	private String regnuedesexpant;
	
	@Column(name = "modexpant")
	private String modexpant;
	
	@Column(name = "idempresa")
	private int idempresa;
	
	@Column(name = "idestablecimiento")
	private int idestablecimiento;
	
	@Column(name = "nomrepresentante")
	private String nomrepresentante;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "calle")
	private String calle;
	
	@Column(name = "numero")
	private String numero;
	
	@Column(name = "colonia")
	private String colonia;

	@Column(name = "municipio")
	private String municipio;

	@Column(name = "telefonodes")
	private String telefonodes;

	@Column(name = "entrecalles")
	private String entrecalles;

	@Column(name = "email")
	private String email;

	@Column(name = "direcciondes")
	private String direcciondes;
	
	@Column(name = "actividad")
	private String actividad;

	@Column(name = "servicio")
	private String servicio;

	@Column(name = "concesion")
	private String concesion;

	@Column(name = "contrato")
	private String contrato;

	@Column(name = "sadm")
	private String sadm;

	@Column(name = "cna")
	private String cna;
	
	@Column(name = "condesp")
	private String condesp;
	
	@Column(name = "oficio")
	private String oficio;
	
	@Column(name = "tipodescarga")
	private String tipodescarga;
	
	@Column(name = "horadescarga")
	private String horadescarga;

	@Column(name = "areaproviene")
	private String areaproviene;

	@Column(name = "tipodescargasda")
	private String tipodescargasda;

	@Column(name = "horadescargasda")
	private String horadescargasda;

	@Column(name = "areaprovienesda")
	private String areaprovienesda;

	@Column(name = "tipodecargatra")
	private String tipodecargatra;

	@Column(name = "horadescargatra")
	private String horadescargatra;

	@Column(name = "areaprovienetra")
	private String areaprovienetra;

	@Column(name = "tipodecargacta")
	private String tipodecargacta;

	@Column(name = "horadescargacta")
	private String horadescargacta;

	@Column(name = "areaprovienecta")
	private String areaprovienecta;

	@Column(name = "pluvialdrenaje")
	private String pluvialdrenaje;

	@Column(name = "descripciondescargas")
	private String descripciondescargas;

	@Column(name = "cambiosdescargas")
	private String cambiosdescargas;

	@Column(name = "fecha")
	private String fecha;
	
	@Column(name = "tipopersona")
	private String tipopersona;
	
	@Column(name = "identificacion")
	private String identificacion;
	
	@Column(name = "actaconstitutiva")
	private String actaconstitutiva;
	
	@Column(name = "poderrepresentante")
	private String poderrepresentante;
	
	@Column(name = "solicitudcopias")
	private String solicitudcopias;
	
	@Column(name = "registrosbanqueta")
	private String registrosbanqueta;
	
	@Column(name = "tipodescargaqta")
	private String tipodescargaqta;
	
	@Column(name = "horadescargaqta")
	private String horadescargaqta;
	
	@Column(name = "ptar")
	private String ptar;
	
	@Column(name = "tipoprocedimiento")
	private String tipoprocedimiento;
	
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

	
	public int getIdtramite() {
		return idtramite;
	}

	public void setIdtramite(int idtramite) {
		this.idtramite = idtramite;
	}

	public String getNfolio() {
		return nfolio;
	}

	public void setNfolio(String nfolio) {
		this.nfolio = nfolio;
	}

	public String getEsnuevousu() {
		return esnuevousu;
	}

	public void setEsnuevousu(String esnuevousu) {
		this.esnuevousu = esnuevousu;
	}

	public String getRegnuedesexpant() {
		return regnuedesexpant;
	}

	public void setRegnuedesexpant(String regnuedesexpant) {
		this.regnuedesexpant = regnuedesexpant;
	}

	public String getModexpant() {
		return modexpant;
	}

	public void setModexpant(String modexpant) {
		this.modexpant = modexpant;
	}

	
	public String getNomrepresentante() {
		return nomrepresentante;
	}

	public void setNomrepresentante(String nomrepresentante) {
		this.nomrepresentante = nomrepresentante;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
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

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getTelefonodes() {
		return telefonodes;
	}

	public void setTelefonodes(String telefonodes) {
		this.telefonodes = telefonodes;
	}

	public String getEntrecalles() {
		return entrecalles;
	}

	public void setEntrecalles(String entrecalles) {
		this.entrecalles = entrecalles;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDirecciondes() {
		return direcciondes;
	}

	public void setDirecciondes(String direcciondes) {
		this.direcciondes = direcciondes;
	}

	public String getActividad() {
		return actividad;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	public String getConcesion() {
		return concesion;
	}

	public void setConcesion(String concesion) {
		this.concesion = concesion;
	}

	public String getContrato() {
		return contrato;
	}

	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	public String getSadm() {
		return sadm;
	}

	public void setSadm(String sadm) {
		this.sadm = sadm;
	}

	public String getCna() {
		return cna;
	}

	public void setCna(String cna) {
		this.cna = cna;
	}

	public String getCondesp() {
		return condesp;
	}

	public void setCondesp(String condesp) {
		this.condesp = condesp;
	}

	public String getOficio() {
		return oficio;
	}

	public void setOficio(String oficio) {
		this.oficio = oficio;
	}

	public String getTipodescarga() {
		return tipodescarga;
	}

	public void setTipodescarga(String tipodescarga) {
		this.tipodescarga = tipodescarga;
	}

	public String getHoradescarga() {
		return horadescarga;
	}

	public void setHoradescarga(String horadescarga) {
		this.horadescarga = horadescarga;
	}

	public String getAreaproviene() {
		return areaproviene;
	}

	public void setAreaproviene(String areaproviene) {
		this.areaproviene = areaproviene;
	}

	public String getTipodescargasda() {
		return tipodescargasda;
	}

	public void setTipodescargasda(String tipodescargasda) {
		this.tipodescargasda = tipodescargasda;
	}

	public String getHoradescargasda() {
		return horadescargasda;
	}

	public void setHoradescargasda(String horadescargasda) {
		this.horadescargasda = horadescargasda;
	}

	public String getAreaprovienesda() {
		return areaprovienesda;
	}

	public void setAreaprovienesda(String areaprovienesda) {
		this.areaprovienesda = areaprovienesda;
	}

	public String getTipodecargatra() {
		return tipodecargatra;
	}

	public void setTipodecargatra(String tipodecargatra) {
		this.tipodecargatra = tipodecargatra;
	}

	public String getHoradescargatra() {
		return horadescargatra;
	}

	public void setHoradescargatra(String horadescargatra) {
		this.horadescargatra = horadescargatra;
	}

	public String getAreaprovienetra() {
		return areaprovienetra;
	}

	public void setAreaprovienetra(String areaprovienetra) {
		this.areaprovienetra = areaprovienetra;
	}

	public String getTipodecargacta() {
		return tipodecargacta;
	}

	public void setTipodecargacta(String tipodecargacta) {
		this.tipodecargacta = tipodecargacta;
	}

	public String getHoradescargacta() {
		return horadescargacta;
	}

	public void setHoradescargacta(String horadescargacta) {
		this.horadescargacta = horadescargacta;
	}

	public String getAreaprovienecta() {
		return areaprovienecta;
	}

	public void setAreaprovienecta(String areaprovienecta) {
		this.areaprovienecta = areaprovienecta;
	}

	public String getPluvialdrenaje() {
		return pluvialdrenaje;
	}

	public void setPluvialdrenaje(String pluvialdrenaje) {
		this.pluvialdrenaje = pluvialdrenaje;
	}

	public String getDescripciondescargas() {
		return descripciondescargas;
	}

	public void setDescripciondescargas(String descripciondescargas) {
		this.descripciondescargas = descripciondescargas;
	}

	public String getCambiosdescargas() {
		return cambiosdescargas;
	}

	public void setCambiosdescargas(String cambiosdescargas) {
		this.cambiosdescargas = cambiosdescargas;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getTipopersona() {
		return tipopersona;
	}

	public void setTipopersona(String tipopersona) {
		this.tipopersona = tipopersona;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getActaconstitutiva() {
		return actaconstitutiva;
	}

	public void setActaconstitutiva(String actaconstitutiva) {
		this.actaconstitutiva = actaconstitutiva;
	}

	public String getPoderrepresentante() {
		return poderrepresentante;
	}

	public void setPoderrepresentante(String poderrepresentante) {
		this.poderrepresentante = poderrepresentante;
	}

	public String getSolicitudcopias() {
		return solicitudcopias;
	}

	public void setSolicitudcopias(String solicitudcopias) {
		this.solicitudcopias = solicitudcopias;
	}

	public String getRegistrosbanqueta() {
		return registrosbanqueta;
	}

	public void setRegistrosbanqueta(String registrosbanqueta) {
		this.registrosbanqueta = registrosbanqueta;
	}

	public String getTipodescargaqta() {
		return tipodescargaqta;
	}

	public void setTipodescargaqta(String tipodescargaqta) {
		this.tipodescargaqta = tipodescargaqta;
	}

	public String getHoradescargaqta() {
		return horadescargaqta;
	}

	public void setHoradescargaqta(String horadescargaqta) {
		this.horadescargaqta = horadescargaqta;
	}

	public String getConagua() {
		return conagua;
	}

	public void setConagua(String conagua) {
		this.conagua = conagua;
	}

	
	public String getPtar() {
		return ptar;
	}

	public void setPtar(String ptar) {
		this.ptar = ptar;
	}

	public String getTipoprocedimiento() {
		return tipoprocedimiento;
	}

	public void setTipoprocedimiento(String tipoprocedimiento) {
		this.tipoprocedimiento = tipoprocedimiento;
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
		
}
