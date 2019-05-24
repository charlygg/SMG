package com.mkyong.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tramite_rehuso_residuos_manejo_especial")
public class Tramite_rehuso_residuos_manejo_especial {

	@Id
	@GeneratedValue
	@Column(name = "idtramite_rehuso_residuos_manejo_especial")
	private int idtramite_rehuso_residuos_manejo_especial;
	
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
	
	@Column(name = "numero_autorizacion_MIA")
	private String numero_autorizacion_MIA;
	
	@Column(name = "numero_autorizacion_disposicion")
	private String numero_autorizacion_disposicion;
	
	@Column(name = "numero_autorizacion_venta_compra")
	private String numero_autorizacion_venta_compra;
	
	@Column(name = "describir_residuos")
	private String describir_residuos;
	
	@Column(name = "nombre_residuo1")
	private String nombre_residuo1;
	
	@Column(name = "cantidad_anual1")
	private String cantidad_anual1;
	
	@Column(name = "generador_residuo1")
	private String generador_residuo1;
	
	@Column(name = "nombre_residuo2")
	private String nombre_residuo2;
	
	@Column(name = "cantidad_anual2")
	private String cantidad_anual2;
	
	@Column(name = "generador_residuo2")
	private String generador_residuo2;
	
	@Column(name = "nombre_residuo3")
	private String nombre_residuo3;
	
	@Column(name = "cantidad_anual3")
	private String cantidad_anual3;
	
	@Column(name = "generador_residuo3")
	private String generador_residuo3;
	
	@Column(name = "nombre_residuo4")
	private String nombre_residuo4;
	
	@Column(name = "cantidad_anual4")
	private String cantidad_anual4;
	
	@Column(name = "generador_residuo4")
	private String generador_residuo4;
	
	@Column(name = "nombre_residuo5")
	private String nombre_residuo5;
	
	@Column(name = "cantidad_anual5")
	private String cantidad_anual5;
	
	@Column(name = "generador_residuo5")
	private String generador_residuo5;
	
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

	public int getIdtramite_rehuso_residuos_manejo_especial() {
		return idtramite_rehuso_residuos_manejo_especial;
	}

	public void setIdtramite_rehuso_residuos_manejo_especial(
			int idtramite_rehuso_residuos_manejo_especial) {
		this.idtramite_rehuso_residuos_manejo_especial = idtramite_rehuso_residuos_manejo_especial;
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

	public String getNumero_autorizacion_MIA() {
		return numero_autorizacion_MIA;
	}

	public void setNumero_autorizacion_MIA(String numero_autorizacion_MIA) {
		this.numero_autorizacion_MIA = numero_autorizacion_MIA;
	}

	public String getNumero_autorizacion_disposicion() {
		return numero_autorizacion_disposicion;
	}

	public void setNumero_autorizacion_disposicion(
			String numero_autorizacion_disposicion) {
		this.numero_autorizacion_disposicion = numero_autorizacion_disposicion;
	}

	public String getNumero_autorizacion_venta_compra() {
		return numero_autorizacion_venta_compra;
	}

	public void setNumero_autorizacion_venta_compra(
			String numero_autorizacion_venta_compra) {
		this.numero_autorizacion_venta_compra = numero_autorizacion_venta_compra;
	}

	public String getDescribir_residuos() {
		return describir_residuos;
	}

	public void setDescribir_residuos(String describir_residuos) {
		this.describir_residuos = describir_residuos;
	}

	public String getNombre_residuo1() {
		return nombre_residuo1;
	}

	public void setNombre_residuo1(String nombre_residuo1) {
		this.nombre_residuo1 = nombre_residuo1;
	}

	public String getCantidad_anual1() {
		return cantidad_anual1;
	}

	public void setCantidad_anual1(String cantidad_anual1) {
		this.cantidad_anual1 = cantidad_anual1;
	}

	public String getGenerador_residuo1() {
		return generador_residuo1;
	}

	public void setGenerador_residuo1(String generador_residuo1) {
		this.generador_residuo1 = generador_residuo1;
	}

	public String getNombre_residuo2() {
		return nombre_residuo2;
	}

	public void setNombre_residuo2(String nombre_residuo2) {
		this.nombre_residuo2 = nombre_residuo2;
	}

	public String getCantidad_anual2() {
		return cantidad_anual2;
	}

	public void setCantidad_anual2(String cantidad_anual2) {
		this.cantidad_anual2 = cantidad_anual2;
	}

	public String getGenerador_residuo2() {
		return generador_residuo2;
	}

	public void setGenerador_residuo2(String generador_residuo2) {
		this.generador_residuo2 = generador_residuo2;
	}

	public String getNombre_residuo3() {
		return nombre_residuo3;
	}

	public void setNombre_residuo3(String nombre_residuo3) {
		this.nombre_residuo3 = nombre_residuo3;
	}

	public String getCantidad_anual3() {
		return cantidad_anual3;
	}

	public void setCantidad_anual3(String cantidad_anual3) {
		this.cantidad_anual3 = cantidad_anual3;
	}

	public String getGenerador_residuo3() {
		return generador_residuo3;
	}

	public void setGenerador_residuo3(String generador_residuo3) {
		this.generador_residuo3 = generador_residuo3;
	}

	public String getNombre_residuo4() {
		return nombre_residuo4;
	}

	public void setNombre_residuo4(String nombre_residuo4) {
		this.nombre_residuo4 = nombre_residuo4;
	}

	public String getCantidad_anual4() {
		return cantidad_anual4;
	}

	public void setCantidad_anual4(String cantidad_anual4) {
		this.cantidad_anual4 = cantidad_anual4;
	}

	public String getGenerador_residuo4() {
		return generador_residuo4;
	}

	public void setGenerador_residuo4(String generador_residuo4) {
		this.generador_residuo4 = generador_residuo4;
	}

	public String getNombre_residuo5() {
		return nombre_residuo5;
	}

	public void setNombre_residuo5(String nombre_residuo5) {
		this.nombre_residuo5 = nombre_residuo5;
	}

	public String getCantidad_anual5() {
		return cantidad_anual5;
	}

	public void setCantidad_anual5(String cantidad_anual5) {
		this.cantidad_anual5 = cantidad_anual5;
	}

	public String getGenerador_residuo5() {
		return generador_residuo5;
	}

	public void setGenerador_residuo5(String generador_residuo5) {
		this.generador_residuo5 = generador_residuo5;
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
