package com.mkyong.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tramite_operacion_manejo_integral_establecimientos")
public class Tramite_operacion_manejo_integral_establecimientos {

	@Id
	@GeneratedValue
	@Column(name = "idtramite_operacion_manejo_integral_establecimientos")
	private int idtramite_operacion_manejo_integral_establecimientos;
	
	@Column(name = "catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento")
	private int catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento;
	
	@Column(name = "catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento1")
	private int catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento1;
	
	@Column(name = "catalogo_perfilempresa_idcatalogo_perfilempresa")
	private int catalogo_perfilempresa_idcatalogo_perfilempresa;
	
	@Column(name = "contacto_planta")
	private String contacto_planta;
	
	@Column(name = "rfc_planta")
	private String rfc_planta;
	
	@Column(name = "lada_planta")
	private String lada_planta;
	
	@Column(name = "telefono_planta")
	private String telefono_planta;
	
	@Column(name = "extension_planta")
	private String extension_planta;
	
	@Column(name = "email_planta")
	private String email_planta;
	
	@Column(name = "contacto_notificacion")
	private String contacto_notificacion;
	
	@Column(name = "rfc_notificacion")
	private String rfc_notificacion;
	
	@Column(name = "lada_notificacion")
	private String lada_notificacion;
	
	@Column(name = "telefono_notificacion")
	private String telefono_notificacion;
	
	@Column(name = "extension_notificacion")
	private String extension_notificacion;
	
	@Column(name = "email_notificacion")
	private String email_notificacion;
	
	@Column(name = "giro_empresa")
	private String giro_empresa;
	
	@Column(name = "especificar")
	private String especificar;
	
	@Column(name = "producto_final")
	private String producto_final;
	
	///
	
	@Column(name = "material1")
	private String material1;
	
	@Column(name = "material2")
	private String material2;
	
	@Column(name = "material3")
	private String material3;
	
	@Column(name = "material4")
	private String material4;
	
	@Column(name = "material5")
	private String material5;
	
	@Column(name = "material6")
	private String material6;
	
	@Column(name = "material7")
	private String material7;
	
	@Column(name = "material8")
	private String material8;
	
	@Column(name = "servicios_empresa")
	private String servicios_empresa;
	
	@Column(name = "describir_manejo")
	private String describir_manejo;
	
	@Column(name = "residuo1")
	private String residuo1;
	
	@Column(name = "generacion_mensual1")
	private String generacion_mensual1;
	
	@Column(name = "residuo2")
	private String residuo2;
	
	@Column(name = "generacion_mensual2")
	private String generacion_mensual2;
	
	@Column(name = "residuo3")
	private String residuo3;
	
	@Column(name = "generacion_mensual3")
	private String generacion_mensual3;
	
	@Column(name = "residuo4")
	private String residuo4;
	
	@Column(name = "generacion_mensual4")
	private String generacion_mensual4;
	
	@Column(name = "estatus")
	private int estatus;
	
	@Column(name = "rolAgrego")
	private String rolAgrego;
	
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

	public int getIdtramite_operacion_manejo_integral_establecimientos() {
		return idtramite_operacion_manejo_integral_establecimientos;
	}

	public void setIdtramite_operacion_manejo_integral_establecimientos(
			int idtramite_operacion_manejo_integral_establecimientos) {
		this.idtramite_operacion_manejo_integral_establecimientos = idtramite_operacion_manejo_integral_establecimientos;
	}

	public int getCatalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento() {
		return catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento;
	}

	public void setCatalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento(
			int catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento) {
		this.catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento = catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento;
	}

	public int getCatalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento1() {
		return catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento1;
	}

	public void setCatalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento1(
			int catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento1) {
		this.catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento1 = catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento1;
	}

	public int getCatalogo_perfilempresa_idcatalogo_perfilempresa() {
		return catalogo_perfilempresa_idcatalogo_perfilempresa;
	}

	public void setCatalogo_perfilempresa_idcatalogo_perfilempresa(
			int catalogo_perfilempresa_idcatalogo_perfilempresa) {
		this.catalogo_perfilempresa_idcatalogo_perfilempresa = catalogo_perfilempresa_idcatalogo_perfilempresa;
	}

	public String getContacto_planta() {
		return contacto_planta;
	}

	public void setContacto_planta(String contacto_planta) {
		this.contacto_planta = contacto_planta;
	}

	public String getRfc_planta() {
		return rfc_planta;
	}

	public void setRfc_planta(String rfc_planta) {
		this.rfc_planta = rfc_planta;
	}

	public String getLada_planta() {
		return lada_planta;
	}

	public void setLada_planta(String lada_planta) {
		this.lada_planta = lada_planta;
	}

	public String getTelefono_planta() {
		return telefono_planta;
	}

	public void setTelefono_planta(String telefono_planta) {
		this.telefono_planta = telefono_planta;
	}

	public String getExtension_planta() {
		return extension_planta;
	}

	public void setExtension_planta(String extension_planta) {
		this.extension_planta = extension_planta;
	}

	public String getEmail_planta() {
		return email_planta;
	}

	public void setEmail_planta(String email_planta) {
		this.email_planta = email_planta;
	}

	public String getContacto_notificacion() {
		return contacto_notificacion;
	}

	public void setContacto_notificacion(String contacto_notificacion) {
		this.contacto_notificacion = contacto_notificacion;
	}

	public String getRfc_notificacion() {
		return rfc_notificacion;
	}

	public void setRfc_notificacion(String rfc_notificacion) {
		this.rfc_notificacion = rfc_notificacion;
	}

	public String getLada_notificacion() {
		return lada_notificacion;
	}

	public void setLada_notificacion(String lada_notificacion) {
		this.lada_notificacion = lada_notificacion;
	}

	public String getTelefono_notificacion() {
		return telefono_notificacion;
	}

	public void setTelefono_notificacion(String telefono_notificacion) {
		this.telefono_notificacion = telefono_notificacion;
	}

	public String getExtension_notificacion() {
		return extension_notificacion;
	}

	public void setExtension_notificacion(String extension_notificacion) {
		this.extension_notificacion = extension_notificacion;
	}

	public String getEmail_notificacion() {
		return email_notificacion;
	}

	public void setEmail_notificacion(String email_notificacion) {
		this.email_notificacion = email_notificacion;
	}

	public String getGiro_empresa() {
		return giro_empresa;
	}

	public void setGiro_empresa(String giro_empresa) {
		this.giro_empresa = giro_empresa;
	}

	public String getEspecificar() {
		return especificar;
	}

	public void setEspecificar(String especificar) {
		this.especificar = especificar;
	}

	public String getProducto_final() {
		return producto_final;
	}

	public void setProducto_final(String producto_final) {
		this.producto_final = producto_final;
	}

	

	public String getMaterial1() {
		return material1;
	}

	public void setMaterial1(String material1) {
		this.material1 = material1;
	}

	public String getMaterial2() {
		return material2;
	}

	public void setMaterial2(String material2) {
		this.material2 = material2;
	}

	public String getMaterial3() {
		return material3;
	}

	public void setMaterial3(String material3) {
		this.material3 = material3;
	}

	public String getMaterial4() {
		return material4;
	}

	public void setMaterial4(String material4) {
		this.material4 = material4;
	}

	public String getMaterial5() {
		return material5;
	}

	public void setMaterial5(String material5) {
		this.material5 = material5;
	}

	public String getMaterial6() {
		return material6;
	}

	public void setMaterial6(String material6) {
		this.material6 = material6;
	}

	public String getMaterial7() {
		return material7;
	}

	public void setMaterial7(String material7) {
		this.material7 = material7;
	}

	public String getMaterial8() {
		return material8;
	}

	public void setMaterial8(String material8) {
		this.material8 = material8;
	}

	public String getServicios_empresa() {
		return servicios_empresa;
	}

	public void setServicios_empresa(String servicios_empresa) {
		this.servicios_empresa = servicios_empresa;
	}

	public String getDescribir_manejo() {
		return describir_manejo;
	}

	public void setDescribir_manejo(String describir_manejo) {
		this.describir_manejo = describir_manejo;
	}

	public String getResiduo1() {
		return residuo1;
	}

	public void setResiduo1(String residuo1) {
		this.residuo1 = residuo1;
	}

	public String getGeneracion_mensual1() {
		return generacion_mensual1;
	}

	public void setGeneracion_mensual1(String generacion_mensual1) {
		this.generacion_mensual1 = generacion_mensual1;
	}

	public String getResiduo2() {
		return residuo2;
	}

	public void setResiduo2(String residuo2) {
		this.residuo2 = residuo2;
	}

	public String getGeneracion_mensual2() {
		return generacion_mensual2;
	}

	public void setGeneracion_mensual2(String generacion_mensual2) {
		this.generacion_mensual2 = generacion_mensual2;
	}

	public String getResiduo3() {
		return residuo3;
	}

	public void setResiduo3(String residuo3) {
		this.residuo3 = residuo3;
	}

	public String getGeneracion_mensual3() {
		return generacion_mensual3;
	}

	public void setGeneracion_mensual3(String generacion_mensual3) {
		this.generacion_mensual3 = generacion_mensual3;
	}

	public String getResiduo4() {
		return residuo4;
	}

	public void setResiduo4(String residuo4) {
		this.residuo4 = residuo4;
	}

	public String getGeneracion_mensual4() {
		return generacion_mensual4;
	}

	public void setGeneracion_mensual4(String generacion_mensual4) {
		this.generacion_mensual4 = generacion_mensual4;
	}

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

	public String getRolAgrego() {
		return rolAgrego;
	}

	public void setRolAgrego(String rolAgrego) {
		this.rolAgrego = rolAgrego;
	}
	
	
	
}