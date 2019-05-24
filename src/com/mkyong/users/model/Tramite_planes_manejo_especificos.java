package com.mkyong.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tramite_planes_manejo_especificos")
public class Tramite_planes_manejo_especificos {

	@Id
	@GeneratedValue
	@Column(name = "idtramite_planes_manejo_especificos")
	private int idtramite_planes_manejo_especificos;
	
	@Column(name = "catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento")
	private int catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento;
	
	@Column(name = "catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento1")
	private int catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento1;
	
	@Column(name = "catalogo_perfilempresa_idcatalogo_perfilempresa")
	private int catalogo_perfilempresa_idcatalogo_perfilempresa;
	
	@Column(name = "rolAgrego")
	private String rolAgrego;
	
	@Column(name = "estatus")
	private int estatus;
	
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
	
	@Column(name = "plan_manejo")
	private String plan_manejo;
	
	@Column(name = "modalidad_plan")
	private String modalidad_plan;
	
	@Column(name = "p_nombre_residuo1")
	private String p_nombre_residuo1;
	
	@Column(name = "p_generacion_men1")
	private String p_generacion_men1;
	
	@Column(name = "p_forma_manejo1")
	private String p_forma_manejo1;
	
	@Column(name = "p_nombre_residuo2")
	private String p_nombre_residuo2;
	
	@Column(name = "p_generacion_men2")
	private String p_generacion_men2;
	
	@Column(name = "p_forma_manejo2")
	private String p_forma_manejo2;
	
	@Column(name = "p_nombre_residuo3")
	private String p_nombre_residuo3;
	
	@Column(name = "p_generacion_men3")
	private String p_generacion_men3;
	
	@Column(name = "p_forma_manejo3")
	private String p_forma_manejo3;
	
	
	@Column(name = "a_tipo_trampa1")
	private String a_tipo_trampa1;
	
	@Column(name = "a_capacidad1")
	private String a_capacidad1;
	
	@Column(name = "a_frecuencia_limp1")
	private String a_frecuencia_limp1;
	
	@Column(name = "a_empresa1")
	private String a_empresa1;
	
	@Column(name = "a_numero_autorizacion1")
	private String a_numero_autorizacion1;
	
	@Column(name = "a_vigencia_autorizacion1")
	private String a_vigencia_autorizacion1;
	
	@Column(name = "a_tipo_trampa2")
	private String a_tipo_trampa2;
	
	@Column(name = "a_capacidad2")
	private String a_capacidad2;
	
	@Column(name = "a_frecuencia_limp2")
	private String a_frecuencia_limp2;
	
	@Column(name = "a_empresa2")
	private String a_empresa2;
	
	@Column(name = "a_numero_autorizacion2")
	private String a_numero_autorizacion2;
	
	@Column(name = "a_vigencia_autorizacion2")
	private String a_vigencia_autorizacion2;
	
	@Column(name = "a_tipo_trampa3")
	private String a_tipo_trampa3;
	
	@Column(name = "a_capacidad3")
	private String a_capacidad3;
	
	@Column(name = "a_frecuencia_limp3")
	private String a_frecuencia_limp3;
	
	@Column(name = "a_empresa3")
	private String a_empresa3;
	
	@Column(name = "a_numero_autorizacion3")
	private String a_numero_autorizacion3;
	
	@Column(name = "a_vigencia_autorizacion3")
	private String a_vigencia_autorizacion3;
	
	@Column(name = "tipo_trampa_especificar")
	private String tipo_trampa_especificar;
	
	@Column(name = "g_residuo1")
	private String g_residuo1;
	
	@Column(name = "g_generacion_dia1")
	private String g_generacion_dia1;
	
	@Column(name = "g_proceso_genera1")
	private String g_proceso_genera1;
	
	@Column(name = "g_composicion_residuo1")
	private String g_composicion_residuo1;
	
	@Column(name = "g_residuo2")
	private String g_residuo2;
	
	@Column(name = "g_generacion_dia2")
	private String g_generacion_dia2;
	
	@Column(name = "g_proceso_genera2")
	private String g_proceso_genera2;
	
	@Column(name = "g_composicion_residuo2")
	private String g_composicion_residuo2;
	
	@Column(name = "g_residuo3")
	private String g_residuo3;
	
	@Column(name = "g_generacion_dia3")
	private String g_generacion_dia3;
	
	@Column(name = "g_proceso_genera3")
	private String g_proceso_genera3;
	
	@Column(name = "g_composicion_residuo3")
	private String g_composicion_residuo3;
	
	@Column(name = "metodo_reduccion")
	private String metodo_reduccion;
	
	@Column(name = "tipo_reduccion")
	private String tipo_reduccion;
	
	@Column(name = "descripcion_metodo")
	private String descripcion_metodo;
	
	@Column(name = "CantMens_sinMetodo")
	private String CantMens_sinMetodo;
	
	@Column(name = "CantMens_conMetodo")
	private String CantMens_conMetodo;
	
	@Column(name = "Porcentaje_reduccion")
	private String Porcentaje_reduccion;
	
	@Column(name = "nombre_residuo")
	private String nombre_residuo;
	
	@Column(name = "cantidad_coproceso")
	private String cantidad_coproceso;
	
	@Column(name = "tipo_coproceso")
	private String tipo_coproceso;
	
	@Column(name = "interno")
	private String interno;
	
	@Column(name = "externo")
	private String externo;
	
	@Column(name = "e_nombre_empresa")
	private String e_nombre_empresa;
	
	@Column(name = "e_domicilio_empresa")
	private String e_domicilio_empresa;
	
	@Column(name = "e_giro_empresa")
	private String e_giro_empresa;
	
	@Column(name = "e_etapa_proceso")
	private String e_etapa_proceso;
	
	@Column(name = "v_residuo1")
	private String v_residuo1;
	
	@Column(name = "v_cantidad1")
	private String v_cantidad1;
	
	@Column(name = "v_negociacion1")
	private String v_negociacion1;
	
	@Column(name = "v_numero_actorizacion1")
	private String v_numero_actorizacion1;
	
	@Column(name = "v_vigencia1")
	private String v_vigencia1;
	
	@Column(name = "t_residuo1")
	private String t_residuo1;
	
	@Column(name = "t_tratamiento1")
	private String t_tratamiento1;
	
	@Column(name = "t_cantidad1")
	private String t_cantidad1;
	
	@Column(name = "t_prestador1")
	private String t_prestador1;
	
	@Column(name = "t_num_actorizacion1")
	private String t_num_actorizacion1;
	
	@Column(name = "t_vigencia1")
	private String t_vigencia1;
	
	@Column(name = "t_residuo2")
	private String t_residuo2;
	
	@Column(name = "t_tratamiento2")
	private String t_tratamiento2;
	
	@Column(name = "t_cantidad2")
	private String t_cantidad2;
	
	@Column(name = "t_prestador2")
	private String t_prestador2;
	
	@Column(name = "t_num_actorizacion2")
	private String t_num_actorizacion2;
	
	@Column(name = "t_vigencia2")
	private String t_vigencia2;
	
	@Column(name = "t_residuo3")
	private String t_residuo3;
	
	@Column(name = "t_tratamiento3")
	private String t_tratamiento3;
	
	@Column(name = "t_cantidad3")
	private String t_cantidad3;
	
	@Column(name = "t_prestador3")
	private String t_prestador3;
	
	@Column(name = "t_num_actorizacion3")
	private String t_num_actorizacion3;
	
	@Column(name = "t_vigencia3")
	private String t_vigencia3;
	
	@Column(name = "r_sin1")
	private String r_sin1;
	
	@Column(name = "r_manejo1")
	private String r_manejo1;
	
	@Column(name = "r_servicio1")
	private String r_servicio1;
	
	@Column(name = "r_razon1")
	private String r_razon1;
	
	@Column(name = "r_num_autorizacion1")
	private String r_num_autorizacion1;
	
	@Column(name = "r_vigencia1")
	private String r_vigencia1;
	
	@Column(name = "r_sin2")
	private String r_sin2;
	
	@Column(name = "r_manejo2")
	private String r_manejo2;
	
	@Column(name = "r_servicio2")
	private String r_servicio2;
	
	@Column(name = "r_razon2")
	private String r_razon2;
	
	@Column(name = "r_num_autorizacion2")
	private String r_num_autorizacion2;
	
	@Column(name = "r_vigencia2")
	private String r_vigencia2;
	
	@Column(name = "r_sin3")
	private String r_sin3;
	
	@Column(name = "r_manejo3")
	private String r_manejo3;
	
	@Column(name = "r_servicio3")
	private String r_servicio3;
	
	@Column(name = "r_razon3")
	private String r_razon3;
	
	@Column(name = "r_num_autorizacion3")
	private String r_num_autorizacion3;
	
	@Column(name = "r_vigencia3")
	private String r_vigencia3;

	@Column(name = "m_meta1")
	private String m_meta1;
	
	@Column(name = "m_descripcion1")
	private String m_descripcion1;
	
	@Column(name = "m_fecha1")
	private String m_fecha1;
	
	@Column(name = "m_periodo1")
	private String m_periodo1;
	
	@Column(name = "m_entrega1")
	private String m_entrega1;
	
	@Column(name = "m_meta2")
	private String m_meta2;
	
	@Column(name = "m_descripcion2")
	private String m_descripcion2;
	
	@Column(name = "m_fecha2")
	private String m_fecha2;
	
	@Column(name = "m_periodo2")
	private String m_periodo2;
	
	@Column(name = "m_entrega2")
	private String m_entrega2;
	
	@Column(name = "m_meta3")
	private String m_meta3;
	
	@Column(name = "m_descripcion3")
	private String m_descripcion3;
	
	@Column(name = "m_fecha3")
	private String m_fecha3;
	
	@Column(name = "m_periodo3")
	private String m_periodo3;
	
	@Column(name = "m_entrega3")
	private String m_entrega3;
	
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

	public int getIdtramite_planes_manejo_especificos() {
		return idtramite_planes_manejo_especificos;
	}

	public void setIdtramite_planes_manejo_especificos(
			int idtramite_planes_manejo_especificos) {
		this.idtramite_planes_manejo_especificos = idtramite_planes_manejo_especificos;
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

	public String getRolAgrego() {
		return rolAgrego;
	}

	public void setRolAgrego(String rolAgrego) {
		this.rolAgrego = rolAgrego;
	}

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
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

	public String getPlan_manejo() {
		return plan_manejo;
	}

	public void setPlan_manejo(String plan_manejo) {
		this.plan_manejo = plan_manejo;
	}

	public String getModalidad_plan() {
		return modalidad_plan;
	}

	public void setModalidad_plan(String modalidad_plan) {
		this.modalidad_plan = modalidad_plan;
	}

	public String getP_nombre_residuo1() {
		return p_nombre_residuo1;
	}

	public void setP_nombre_residuo1(String p_nombre_residuo1) {
		this.p_nombre_residuo1 = p_nombre_residuo1;
	}

	public String getP_generacion_men1() {
		return p_generacion_men1;
	}

	public void setP_generacion_men1(String p_generacion_men1) {
		this.p_generacion_men1 = p_generacion_men1;
	}

	public String getP_forma_manejo1() {
		return p_forma_manejo1;
	}

	public void setP_forma_manejo1(String p_forma_manejo1) {
		this.p_forma_manejo1 = p_forma_manejo1;
	}

	public String getP_nombre_residuo2() {
		return p_nombre_residuo2;
	}

	public void setP_nombre_residuo2(String p_nombre_residuo2) {
		this.p_nombre_residuo2 = p_nombre_residuo2;
	}

	public String getP_generacion_men2() {
		return p_generacion_men2;
	}

	public void setP_generacion_men2(String p_generacion_men2) {
		this.p_generacion_men2 = p_generacion_men2;
	}

	public String getP_forma_manejo2() {
		return p_forma_manejo2;
	}

	public void setP_forma_manejo2(String p_forma_manejo2) {
		this.p_forma_manejo2 = p_forma_manejo2;
	}

	public String getP_nombre_residuo3() {
		return p_nombre_residuo3;
	}

	public void setP_nombre_residuo3(String p_nombre_residuo3) {
		this.p_nombre_residuo3 = p_nombre_residuo3;
	}

	public String getP_generacion_men3() {
		return p_generacion_men3;
	}

	public void setP_generacion_men3(String p_generacion_men3) {
		this.p_generacion_men3 = p_generacion_men3;
	}

	public String getP_forma_manejo3() {
		return p_forma_manejo3;
	}

	public void setP_forma_manejo3(String p_forma_manejo3) {
		this.p_forma_manejo3 = p_forma_manejo3;
	}

	public String getA_tipo_trampa1() {
		return a_tipo_trampa1;
	}

	public void setA_tipo_trampa1(String a_tipo_trampa1) {
		this.a_tipo_trampa1 = a_tipo_trampa1;
	}

	public String getA_capacidad1() {
		return a_capacidad1;
	}

	public void setA_capacidad1(String a_capacidad1) {
		this.a_capacidad1 = a_capacidad1;
	}

	public String getA_frecuencia_limp1() {
		return a_frecuencia_limp1;
	}

	public void setA_frecuencia_limp1(String a_frecuencia_limp1) {
		this.a_frecuencia_limp1 = a_frecuencia_limp1;
	}

	public String getA_empresa1() {
		return a_empresa1;
	}

	public void setA_empresa1(String a_empresa1) {
		this.a_empresa1 = a_empresa1;
	}

	public String getA_numero_autorizacion1() {
		return a_numero_autorizacion1;
	}

	public void setA_numero_autorizacion1(String a_numero_autorizacion1) {
		this.a_numero_autorizacion1 = a_numero_autorizacion1;
	}

	public String getA_vigencia_autorizacion1() {
		return a_vigencia_autorizacion1;
	}

	public void setA_vigencia_autorizacion1(String a_vigencia_autorizacion1) {
		this.a_vigencia_autorizacion1 = a_vigencia_autorizacion1;
	}

	public String getA_tipo_trampa2() {
		return a_tipo_trampa2;
	}

	public void setA_tipo_trampa2(String a_tipo_trampa2) {
		this.a_tipo_trampa2 = a_tipo_trampa2;
	}

	public String getA_capacidad2() {
		return a_capacidad2;
	}

	public void setA_capacidad2(String a_capacidad2) {
		this.a_capacidad2 = a_capacidad2;
	}

	public String getA_frecuencia_limp2() {
		return a_frecuencia_limp2;
	}

	public void setA_frecuencia_limp2(String a_frecuencia_limp2) {
		this.a_frecuencia_limp2 = a_frecuencia_limp2;
	}

	public String getA_empresa2() {
		return a_empresa2;
	}

	public void setA_empresa2(String a_empresa2) {
		this.a_empresa2 = a_empresa2;
	}

	public String getA_numero_autorizacion2() {
		return a_numero_autorizacion2;
	}

	public void setA_numero_autorizacion2(String a_numero_autorizacion2) {
		this.a_numero_autorizacion2 = a_numero_autorizacion2;
	}

	public String getA_vigencia_autorizacion2() {
		return a_vigencia_autorizacion2;
	}

	public void setA_vigencia_autorizacion2(String a_vigencia_autorizacion2) {
		this.a_vigencia_autorizacion2 = a_vigencia_autorizacion2;
	}

	public String getA_tipo_trampa3() {
		return a_tipo_trampa3;
	}

	public void setA_tipo_trampa3(String a_tipo_trampa3) {
		this.a_tipo_trampa3 = a_tipo_trampa3;
	}

	public String getA_capacidad3() {
		return a_capacidad3;
	}

	public void setA_capacidad3(String a_capacidad3) {
		this.a_capacidad3 = a_capacidad3;
	}

	public String getA_frecuencia_limp3() {
		return a_frecuencia_limp3;
	}

	public void setA_frecuencia_limp3(String a_frecuencia_limp3) {
		this.a_frecuencia_limp3 = a_frecuencia_limp3;
	}

	public String getA_empresa3() {
		return a_empresa3;
	}

	public void setA_empresa3(String a_empresa3) {
		this.a_empresa3 = a_empresa3;
	}

	public String getA_numero_autorizacion3() {
		return a_numero_autorizacion3;
	}

	public void setA_numero_autorizacion3(String a_numero_autorizacion3) {
		this.a_numero_autorizacion3 = a_numero_autorizacion3;
	}

	public String getA_vigencia_autorizacion3() {
		return a_vigencia_autorizacion3;
	}

	public void setA_vigencia_autorizacion3(String a_vigencia_autorizacion3) {
		this.a_vigencia_autorizacion3 = a_vigencia_autorizacion3;
	}

	public String getTipo_trampa_especificar() {
		return tipo_trampa_especificar;
	}

	public void setTipo_trampa_especificar(String tipo_trampa_especificar) {
		this.tipo_trampa_especificar = tipo_trampa_especificar;
	}

	public String getG_residuo1() {
		return g_residuo1;
	}

	public void setG_residuo1(String g_residuo1) {
		this.g_residuo1 = g_residuo1;
	}

	public String getG_generacion_dia1() {
		return g_generacion_dia1;
	}

	public void setG_generacion_dia1(String g_generacion_dia1) {
		this.g_generacion_dia1 = g_generacion_dia1;
	}

	public String getG_proceso_genera1() {
		return g_proceso_genera1;
	}

	public void setG_proceso_genera1(String g_proceso_genera1) {
		this.g_proceso_genera1 = g_proceso_genera1;
	}

	public String getG_composicion_residuo1() {
		return g_composicion_residuo1;
	}

	public void setG_composicion_residuo1(String g_composicion_residuo1) {
		this.g_composicion_residuo1 = g_composicion_residuo1;
	}

	public String getG_residuo2() {
		return g_residuo2;
	}

	public void setG_residuo2(String g_residuo2) {
		this.g_residuo2 = g_residuo2;
	}

	public String getG_generacion_dia2() {
		return g_generacion_dia2;
	}

	public void setG_generacion_dia2(String g_generacion_dia2) {
		this.g_generacion_dia2 = g_generacion_dia2;
	}

	public String getG_proceso_genera2() {
		return g_proceso_genera2;
	}

	public void setG_proceso_genera2(String g_proceso_genera2) {
		this.g_proceso_genera2 = g_proceso_genera2;
	}

	public String getG_composicion_residuo2() {
		return g_composicion_residuo2;
	}

	public void setG_composicion_residuo2(String g_composicion_residuo2) {
		this.g_composicion_residuo2 = g_composicion_residuo2;
	}

	public String getG_residuo3() {
		return g_residuo3;
	}

	public void setG_residuo3(String g_residuo3) {
		this.g_residuo3 = g_residuo3;
	}

	public String getG_generacion_dia3() {
		return g_generacion_dia3;
	}

	public void setG_generacion_dia3(String g_generacion_dia3) {
		this.g_generacion_dia3 = g_generacion_dia3;
	}

	public String getG_proceso_genera3() {
		return g_proceso_genera3;
	}

	public void setG_proceso_genera3(String g_proceso_genera3) {
		this.g_proceso_genera3 = g_proceso_genera3;
	}

	public String getG_composicion_residuo3() {
		return g_composicion_residuo3;
	}

	public void setG_composicion_residuo3(String g_composicion_residuo3) {
		this.g_composicion_residuo3 = g_composicion_residuo3;
	}

	public String getMetodo_reduccion() {
		return metodo_reduccion;
	}

	public void setMetodo_reduccion(String metodo_reduccion) {
		this.metodo_reduccion = metodo_reduccion;
	}

	public String getTipo_reduccion() {
		return tipo_reduccion;
	}

	public void setTipo_reduccion(String tipo_reduccion) {
		this.tipo_reduccion = tipo_reduccion;
	}

	public String getDescripcion_metodo() {
		return descripcion_metodo;
	}

	public void setDescripcion_metodo(String descripcion_metodo) {
		this.descripcion_metodo = descripcion_metodo;
	}

	public String getCantMens_sinMetodo() {
		return CantMens_sinMetodo;
	}

	public void setCantMens_sinMetodo(String cantMens_sinMetodo) {
		CantMens_sinMetodo = cantMens_sinMetodo;
	}

	public String getCantMens_conMetodo() {
		return CantMens_conMetodo;
	}

	public void setCantMens_conMetodo(String cantMens_conMetodo) {
		CantMens_conMetodo = cantMens_conMetodo;
	}

	public String getPorcentaje_reduccion() {
		return Porcentaje_reduccion;
	}

	public void setPorcentaje_reduccion(String porcentaje_reduccion) {
		Porcentaje_reduccion = porcentaje_reduccion;
	}

	public String getNombre_residuo() {
		return nombre_residuo;
	}

	public void setNombre_residuo(String nombre_residuo) {
		this.nombre_residuo = nombre_residuo;
	}

	public String getCantidad_coproceso() {
		return cantidad_coproceso;
	}

	public void setCantidad_coproceso(String cantidad_coproceso) {
		this.cantidad_coproceso = cantidad_coproceso;
	}

	public String getTipo_coproceso() {
		return tipo_coproceso;
	}

	public void setTipo_coproceso(String tipo_coproceso) {
		this.tipo_coproceso = tipo_coproceso;
	}

	public String getInterno() {
		return interno;
	}

	public void setInterno(String interno) {
		this.interno = interno;
	}

	public String getExterno() {
		return externo;
	}

	public void setExterno(String externo) {
		this.externo = externo;
	}

	public String getE_nombre_empresa() {
		return e_nombre_empresa;
	}

	public void setE_nombre_empresa(String e_nombre_empresa) {
		this.e_nombre_empresa = e_nombre_empresa;
	}

	public String getE_domicilio_empresa() {
		return e_domicilio_empresa;
	}

	public void setE_domicilio_empresa(String e_domicilio_empresa) {
		this.e_domicilio_empresa = e_domicilio_empresa;
	}

	public String getE_giro_empresa() {
		return e_giro_empresa;
	}

	public void setE_giro_empresa(String e_giro_empresa) {
		this.e_giro_empresa = e_giro_empresa;
	}

	public String getE_etapa_proceso() {
		return e_etapa_proceso;
	}

	public void setE_etapa_proceso(String e_etapa_proceso) {
		this.e_etapa_proceso = e_etapa_proceso;
	}

	public String getV_residuo1() {
		return v_residuo1;
	}

	public void setV_residuo1(String v_residuo1) {
		this.v_residuo1 = v_residuo1;
	}

	public String getV_cantidad1() {
		return v_cantidad1;
	}

	public void setV_cantidad1(String v_cantidad1) {
		this.v_cantidad1 = v_cantidad1;
	}

	public String getV_negociacion1() {
		return v_negociacion1;
	}

	public void setV_negociacion1(String v_negociacion1) {
		this.v_negociacion1 = v_negociacion1;
	}

	public String getV_numero_actorizacion1() {
		return v_numero_actorizacion1;
	}

	public void setV_numero_actorizacion1(String v_numero_actorizacion1) {
		this.v_numero_actorizacion1 = v_numero_actorizacion1;
	}

	public String getV_vigencia1() {
		return v_vigencia1;
	}

	public void setV_vigencia1(String v_vigencia1) {
		this.v_vigencia1 = v_vigencia1;
	}

	public String getT_residuo1() {
		return t_residuo1;
	}

	public void setT_residuo1(String t_residuo1) {
		this.t_residuo1 = t_residuo1;
	}

	public String getT_tratamiento1() {
		return t_tratamiento1;
	}

	public void setT_tratamiento1(String t_tratamiento1) {
		this.t_tratamiento1 = t_tratamiento1;
	}

	public String getT_cantidad1() {
		return t_cantidad1;
	}

	public void setT_cantidad1(String t_cantidad1) {
		this.t_cantidad1 = t_cantidad1;
	}

	public String getT_prestador1() {
		return t_prestador1;
	}

	public void setT_prestador1(String t_prestador1) {
		this.t_prestador1 = t_prestador1;
	}

	public String getT_num_actorizacion1() {
		return t_num_actorizacion1;
	}

	public void setT_num_actorizacion1(String t_num_actorizacion1) {
		this.t_num_actorizacion1 = t_num_actorizacion1;
	}

	public String getT_vigencia1() {
		return t_vigencia1;
	}

	public void setT_vigencia1(String t_vigencia1) {
		this.t_vigencia1 = t_vigencia1;
	}

	public String getT_residuo2() {
		return t_residuo2;
	}

	public void setT_residuo2(String t_residuo2) {
		this.t_residuo2 = t_residuo2;
	}

	public String getT_tratamiento2() {
		return t_tratamiento2;
	}

	public void setT_tratamiento2(String t_tratamiento2) {
		this.t_tratamiento2 = t_tratamiento2;
	}

	public String getT_cantidad2() {
		return t_cantidad2;
	}

	public void setT_cantidad2(String t_cantidad2) {
		this.t_cantidad2 = t_cantidad2;
	}

	public String getT_prestador2() {
		return t_prestador2;
	}

	public void setT_prestador2(String t_prestador2) {
		this.t_prestador2 = t_prestador2;
	}

	public String getT_num_actorizacion2() {
		return t_num_actorizacion2;
	}

	public void setT_num_actorizacion2(String t_num_actorizacion2) {
		this.t_num_actorizacion2 = t_num_actorizacion2;
	}

	public String getT_vigencia2() {
		return t_vigencia2;
	}

	public void setT_vigencia2(String t_vigencia2) {
		this.t_vigencia2 = t_vigencia2;
	}

	public String getT_residuo3() {
		return t_residuo3;
	}

	public void setT_residuo3(String t_residuo3) {
		this.t_residuo3 = t_residuo3;
	}

	public String getT_tratamiento3() {
		return t_tratamiento3;
	}

	public void setT_tratamiento3(String t_tratamiento3) {
		this.t_tratamiento3 = t_tratamiento3;
	}

	public String getT_cantidad3() {
		return t_cantidad3;
	}

	public void setT_cantidad3(String t_cantidad3) {
		this.t_cantidad3 = t_cantidad3;
	}

	public String getT_prestador3() {
		return t_prestador3;
	}

	public void setT_prestador3(String t_prestador3) {
		this.t_prestador3 = t_prestador3;
	}

	public String getT_num_actorizacion3() {
		return t_num_actorizacion3;
	}

	public void setT_num_actorizacion3(String t_num_actorizacion3) {
		this.t_num_actorizacion3 = t_num_actorizacion3;
	}

	public String getT_vigencia3() {
		return t_vigencia3;
	}

	public void setT_vigencia3(String t_vigencia3) {
		this.t_vigencia3 = t_vigencia3;
	}

	public String getR_sin1() {
		return r_sin1;
	}

	public void setR_sin1(String r_sin1) {
		this.r_sin1 = r_sin1;
	}

	public String getR_manejo1() {
		return r_manejo1;
	}

	public void setR_manejo1(String r_manejo1) {
		this.r_manejo1 = r_manejo1;
	}

	public String getR_servicio1() {
		return r_servicio1;
	}

	public void setR_servicio1(String r_servicio1) {
		this.r_servicio1 = r_servicio1;
	}

	public String getR_razon1() {
		return r_razon1;
	}

	public void setR_razon1(String r_razon1) {
		this.r_razon1 = r_razon1;
	}

	public String getR_num_autorizacion1() {
		return r_num_autorizacion1;
	}

	public void setR_num_autorizacion1(String r_num_autorizacion1) {
		this.r_num_autorizacion1 = r_num_autorizacion1;
	}

	public String getR_vigencia1() {
		return r_vigencia1;
	}

	public void setR_vigencia1(String r_vigencia1) {
		this.r_vigencia1 = r_vigencia1;
	}

	public String getR_sin2() {
		return r_sin2;
	}

	public void setR_sin2(String r_sin2) {
		this.r_sin2 = r_sin2;
	}

	public String getR_manejo2() {
		return r_manejo2;
	}

	public void setR_manejo2(String r_manejo2) {
		this.r_manejo2 = r_manejo2;
	}

	public String getR_servicio2() {
		return r_servicio2;
	}

	public void setR_servicio2(String r_servicio2) {
		this.r_servicio2 = r_servicio2;
	}

	public String getR_razon2() {
		return r_razon2;
	}

	public void setR_razon2(String r_razon2) {
		this.r_razon2 = r_razon2;
	}

	public String getR_num_autorizacion2() {
		return r_num_autorizacion2;
	}

	public void setR_num_autorizacion2(String r_num_autorizacion2) {
		this.r_num_autorizacion2 = r_num_autorizacion2;
	}

	public String getR_vigencia2() {
		return r_vigencia2;
	}

	public void setR_vigencia2(String r_vigencia2) {
		this.r_vigencia2 = r_vigencia2;
	}

	public String getR_sin3() {
		return r_sin3;
	}

	public void setR_sin3(String r_sin3) {
		this.r_sin3 = r_sin3;
	}

	public String getR_manejo3() {
		return r_manejo3;
	}

	public void setR_manejo3(String r_manejo3) {
		this.r_manejo3 = r_manejo3;
	}

	public String getR_servicio3() {
		return r_servicio3;
	}

	public void setR_servicio3(String r_servicio3) {
		this.r_servicio3 = r_servicio3;
	}

	public String getR_razon3() {
		return r_razon3;
	}

	public void setR_razon3(String r_razon3) {
		this.r_razon3 = r_razon3;
	}

	public String getR_num_autorizacion3() {
		return r_num_autorizacion3;
	}

	public void setR_num_autorizacion3(String r_num_autorizacion3) {
		this.r_num_autorizacion3 = r_num_autorizacion3;
	}

	public String getR_vigencia3() {
		return r_vigencia3;
	}

	public void setR_vigencia3(String r_vigencia3) {
		this.r_vigencia3 = r_vigencia3;
	}

	public String getM_meta1() {
		return m_meta1;
	}

	public void setM_meta1(String m_meta1) {
		this.m_meta1 = m_meta1;
	}

	public String getM_descripcion1() {
		return m_descripcion1;
	}

	public void setM_descripcion1(String m_descripcion1) {
		this.m_descripcion1 = m_descripcion1;
	}

	public String getM_fecha1() {
		return m_fecha1;
	}

	public void setM_fecha1(String m_fecha1) {
		this.m_fecha1 = m_fecha1;
	}

	public String getM_periodo1() {
		return m_periodo1;
	}

	public void setM_periodo1(String m_periodo1) {
		this.m_periodo1 = m_periodo1;
	}

	public String getM_entrega1() {
		return m_entrega1;
	}

	public void setM_entrega1(String m_entrega1) {
		this.m_entrega1 = m_entrega1;
	}

	public String getM_meta2() {
		return m_meta2;
	}

	public void setM_meta2(String m_meta2) {
		this.m_meta2 = m_meta2;
	}

	public String getM_descripcion2() {
		return m_descripcion2;
	}

	public void setM_descripcion2(String m_descripcion2) {
		this.m_descripcion2 = m_descripcion2;
	}

	public String getM_fecha2() {
		return m_fecha2;
	}

	public void setM_fecha2(String m_fecha2) {
		this.m_fecha2 = m_fecha2;
	}

	public String getM_periodo2() {
		return m_periodo2;
	}

	public void setM_periodo2(String m_periodo2) {
		this.m_periodo2 = m_periodo2;
	}

	public String getM_entrega2() {
		return m_entrega2;
	}

	public void setM_entrega2(String m_entrega2) {
		this.m_entrega2 = m_entrega2;
	}

	public String getM_meta3() {
		return m_meta3;
	}

	public void setM_meta3(String m_meta3) {
		this.m_meta3 = m_meta3;
	}

	public String getM_descripcion3() {
		return m_descripcion3;
	}

	public void setM_descripcion3(String m_descripcion3) {
		this.m_descripcion3 = m_descripcion3;
	}

	public String getM_fecha3() {
		return m_fecha3;
	}

	public void setM_fecha3(String m_fecha3) {
		this.m_fecha3 = m_fecha3;
	}

	public String getM_periodo3() {
		return m_periodo3;
	}

	public void setM_periodo3(String m_periodo3) {
		this.m_periodo3 = m_periodo3;
	}

	public String getM_entrega3() {
		return m_entrega3;
	}

	public void setM_entrega3(String m_entrega3) {
		this.m_entrega3 = m_entrega3;
	}

	public String getUUID() {
		return UUID;
	}

	public void setUUID(String uUID) {
		UUID = uUID;
	}
	
	
	
}
