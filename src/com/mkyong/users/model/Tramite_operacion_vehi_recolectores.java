package com.mkyong.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tramite_operacion_vehi_recolectores")
public class Tramite_operacion_vehi_recolectores {

	@Id
	@GeneratedValue
	@Column(name = "idtramite_operacion_vehi_recolectores")
	private int idtramite_operacion_vehi_recolectores;
	
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
	
	@Column(name = "numero_placa1")
	private String numero_placa1;
	
	@Column(name = "niv1")
	private String niv1;
	
	@Column(name = "marca1")
	private String marca1;
	
	@Column(name = "tipo_vehiculo1")
	private String tipo_vehiculo1;
	
	@Column(name = "modelo1")
	private String modelo1;
	
	@Column(name = "numero_placa2")
	private String numero_placa2;
	
	@Column(name = "niv2")
	private String niv2;
	
	@Column(name = "marca2")
	private String marca2;
	
	@Column(name = "tipo_vehiculo2")
	private String tipo_vehiculo2;
	
	@Column(name = "modelo2")
	private String modelo2;
	
	@Column(name = "numero_placa3")
	private String numero_placa3;
	
	@Column(name = "niv3")
	private String niv3;
	
	@Column(name = "marca3")
	private String marca3;
	
	@Column(name = "tipo_vehiculo3")
	private String tipo_vehiculo3;
	
	@Column(name = "modelo3")
	private String modelo3;
	
	@Column(name = "numero_placa4")
	private String numero_placa4;
	
	@Column(name = "niv4")
	private String niv4;
	
	@Column(name = "marca4")
	private String marca4;
	
	@Column(name = "tipo_vehiculo4")
	private String tipo_vehiculo4;
	
	@Column(name = "modelo4")
	private String modelo4;
	
	@Column(name = "numero_placa5")
	private String numero_placa5;
	
	@Column(name = "niv5")
	private String niv5;
	
	@Column(name = "marca5")
	private String marca5;
	
	@Column(name = "tipo_vehiculo5")
	private String tipo_vehiculo5;
	
	@Column(name = "modelo5")
	private String modelo5;
	
	@Column(name = "numero_placa6")
	private String numero_placa6;
	
	@Column(name = "niv6")
	private String niv6;
	
	@Column(name = "marca6")
	private String marca6;
	
	@Column(name = "tipo_vehiculo6")
	private String tipo_vehiculo6;
	
	@Column(name = "modelo6")
	private String modelo6;
	
	@Column(name = "numero_placa7")
	private String numero_placa7;
	
	@Column(name = "niv7")
	private String niv7;
	
	@Column(name = "marca7")
	private String marca7;
	
	@Column(name = "tipo_vehiculo7")
	private String tipo_vehiculo7;
	
	@Column(name = "modelo7")
	private String modelo7;
	
	@Column(name = "numero_placa8")
	private String numero_placa8;
	
	@Column(name = "niv8")
	private String niv8;
	
	@Column(name = "marca8")
	private String marca8;
	
	@Column(name = "tipo_vehiculo8")
	private String tipo_vehiculo8;
	
	@Column(name = "modelo8")
	private String modelo8;
	
	@Column(name = "numero_vehiculos")
	private String numero_vehiculos;
	
	@Column(name = "destino_final")
	private String destino_final;
	
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

	public int getIdtramite_operacion_vehi_recolectores() {
		return idtramite_operacion_vehi_recolectores;
	}

	public void setIdtramite_operacion_vehi_recolectores(
			int idtramite_operacion_vehi_recolectores) {
		this.idtramite_operacion_vehi_recolectores = idtramite_operacion_vehi_recolectores;
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

	public String getNumero_placa1() {
		return numero_placa1;
	}

	public void setNumero_placa1(String numero_placa1) {
		this.numero_placa1 = numero_placa1;
	}

	public String getNiv1() {
		return niv1;
	}

	public void setNiv1(String niv1) {
		this.niv1 = niv1;
	}

	public String getMarca1() {
		return marca1;
	}

	public void setMarca1(String marca1) {
		this.marca1 = marca1;
	}

	public String getTipo_vehiculo1() {
		return tipo_vehiculo1;
	}

	public void setTipo_vehiculo1(String tipo_vehiculo1) {
		this.tipo_vehiculo1 = tipo_vehiculo1;
	}

	public String getModelo1() {
		return modelo1;
	}

	public void setModelo1(String modelo1) {
		this.modelo1 = modelo1;
	}

	public String getNumero_placa2() {
		return numero_placa2;
	}

	public void setNumero_placa2(String numero_placa2) {
		this.numero_placa2 = numero_placa2;
	}

	public String getNiv2() {
		return niv2;
	}

	public void setNiv2(String niv2) {
		this.niv2 = niv2;
	}

	public String getMarca2() {
		return marca2;
	}

	public void setMarca2(String marca2) {
		this.marca2 = marca2;
	}

	public String getTipo_vehiculo2() {
		return tipo_vehiculo2;
	}

	public void setTipo_vehiculo2(String tipo_vehiculo2) {
		this.tipo_vehiculo2 = tipo_vehiculo2;
	}

	public String getModelo2() {
		return modelo2;
	}

	public void setModelo2(String modelo2) {
		this.modelo2 = modelo2;
	}

	public String getNumero_placa3() {
		return numero_placa3;
	}

	public void setNumero_placa3(String numero_placa3) {
		this.numero_placa3 = numero_placa3;
	}

	public String getNiv3() {
		return niv3;
	}

	public void setNiv3(String niv3) {
		this.niv3 = niv3;
	}

	public String getMarca3() {
		return marca3;
	}

	public void setMarca3(String marca3) {
		this.marca3 = marca3;
	}

	public String getTipo_vehiculo3() {
		return tipo_vehiculo3;
	}

	public void setTipo_vehiculo3(String tipo_vehiculo3) {
		this.tipo_vehiculo3 = tipo_vehiculo3;
	}

	public String getModelo3() {
		return modelo3;
	}

	public void setModelo3(String modelo3) {
		this.modelo3 = modelo3;
	}

	public String getNumero_placa4() {
		return numero_placa4;
	}

	public void setNumero_placa4(String numero_placa4) {
		this.numero_placa4 = numero_placa4;
	}

	public String getNiv4() {
		return niv4;
	}

	public void setNiv4(String niv4) {
		this.niv4 = niv4;
	}

	public String getMarca4() {
		return marca4;
	}

	public void setMarca4(String marca4) {
		this.marca4 = marca4;
	}

	public String getTipo_vehiculo4() {
		return tipo_vehiculo4;
	}

	public void setTipo_vehiculo4(String tipo_vehiculo4) {
		this.tipo_vehiculo4 = tipo_vehiculo4;
	}

	public String getModelo4() {
		return modelo4;
	}

	public void setModelo4(String modelo4) {
		this.modelo4 = modelo4;
	}

	public String getNumero_placa5() {
		return numero_placa5;
	}

	public void setNumero_placa5(String numero_placa5) {
		this.numero_placa5 = numero_placa5;
	}

	public String getNiv5() {
		return niv5;
	}

	public void setNiv5(String niv5) {
		this.niv5 = niv5;
	}

	public String getMarca5() {
		return marca5;
	}

	public void setMarca5(String marca5) {
		this.marca5 = marca5;
	}

	public String getTipo_vehiculo5() {
		return tipo_vehiculo5;
	}

	public void setTipo_vehiculo5(String tipo_vehiculo5) {
		this.tipo_vehiculo5 = tipo_vehiculo5;
	}

	public String getModelo5() {
		return modelo5;
	}

	public void setModelo5(String modelo5) {
		this.modelo5 = modelo5;
	}

	public String getNumero_placa6() {
		return numero_placa6;
	}

	public void setNumero_placa6(String numero_placa6) {
		this.numero_placa6 = numero_placa6;
	}

	public String getNiv6() {
		return niv6;
	}

	public void setNiv6(String niv6) {
		this.niv6 = niv6;
	}

	public String getMarca6() {
		return marca6;
	}

	public void setMarca6(String marca6) {
		this.marca6 = marca6;
	}

	public String getTipo_vehiculo6() {
		return tipo_vehiculo6;
	}

	public void setTipo_vehiculo6(String tipo_vehiculo6) {
		this.tipo_vehiculo6 = tipo_vehiculo6;
	}

	public String getModelo6() {
		return modelo6;
	}

	public void setModelo6(String modelo6) {
		this.modelo6 = modelo6;
	}

	public String getNumero_placa7() {
		return numero_placa7;
	}

	public void setNumero_placa7(String numero_placa7) {
		this.numero_placa7 = numero_placa7;
	}

	public String getNiv7() {
		return niv7;
	}

	public void setNiv7(String niv7) {
		this.niv7 = niv7;
	}

	public String getMarca7() {
		return marca7;
	}

	public void setMarca7(String marca7) {
		this.marca7 = marca7;
	}

	public String getTipo_vehiculo7() {
		return tipo_vehiculo7;
	}

	public void setTipo_vehiculo7(String tipo_vehiculo7) {
		this.tipo_vehiculo7 = tipo_vehiculo7;
	}

	public String getModelo7() {
		return modelo7;
	}

	public void setModelo7(String modelo7) {
		this.modelo7 = modelo7;
	}

	public String getNumero_placa8() {
		return numero_placa8;
	}

	public void setNumero_placa8(String numero_placa8) {
		this.numero_placa8 = numero_placa8;
	}

	public String getNiv8() {
		return niv8;
	}

	public void setNiv8(String niv8) {
		this.niv8 = niv8;
	}

	public String getMarca8() {
		return marca8;
	}

	public void setMarca8(String marca8) {
		this.marca8 = marca8;
	}

	public String getTipo_vehiculo8() {
		return tipo_vehiculo8;
	}

	public void setTipo_vehiculo8(String tipo_vehiculo8) {
		this.tipo_vehiculo8 = tipo_vehiculo8;
	}

	public String getModelo8() {
		return modelo8;
	}

	public void setModelo8(String modelo8) {
		this.modelo8 = modelo8;
	}

	public String getNumero_vehiculos() {
		return numero_vehiculos;
	}

	public void setNumero_vehiculos(String numero_vehiculos) {
		this.numero_vehiculos = numero_vehiculos;
	}

	public String getDestino_final() {
		return destino_final;
	}

	public void setDestino_final(String destino_final) {
		this.destino_final = destino_final;
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
