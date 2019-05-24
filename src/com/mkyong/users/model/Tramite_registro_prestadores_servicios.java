package com.mkyong.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tramite_registro_prestador_servicio")
public class Tramite_registro_prestadores_servicios {
	
	@Id
	@GeneratedValue
	@Column(name = "idtramite_registro_prestador_servicio")
	private int idtramite_registro_prestador_servicio;
	
	@Column(name = "clave_registro")
	private String clave_registro;
	
	@Column(name = "apellido_paterno")
	private String apellido_paterno;
	
	@Column(name = "apellido_materno")
	private String apellido_materno;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "calle")
	private String calle;
	
	@Column(name = "num_exterior")
	private String num_exterior;
	
	@Column(name = "colonia")
	private String colonia;
	
	@Column(name = "num_interior")
	private String num_interior;
	
	@Column(name = "cp")
	private String cp;
	
	@Column(name = "tel")
	private String tel;
	
	@Column(name = "fax")
	private String fax;
	
	@Column(name = "cel")
	private String cel;
	
	@Column(name = "municipio")
	private String municipio;
	
	@Column(name = "correo")
	private String correo;
	
	@Column(name = "sexo_fisica")
	private String sexo_fisica;
	
	@Column(name = "nacionalidad_fisica")
	private String nacionalidad_fisica;
	
	@Column(name = "lugar_nacimiento_fisica")
	private String lugar_nacimiento_fisica;
	
	@Column(name = "pais_fisica")
	private String pais_fisica;
	
	@Column(name = "rfc_fisica")
	private String rfc_fisica;
	
	@Column(name = "curp_fisica")
	private String curp_fisica;
	
	@Column(name = "domicilio_fisica")
	private String domicilio_fisica;
	
	@Column(name = "fecha_declaracion_fisica")
	private String fecha_declaracion_fisica;
	
	@Column(name = "factura_fisica")
	private String factura_fisica;
	
	@Column(name = "academico_fisica")
	private String academico_fisica;

	@Column(name = "carrera_fisica")
	private String carrera_fisica;
	
	@Column(name = "periodo_fin_fisica")
	private String periodo_fin_fisica;
	
	@Column(name = "tesis_fisica")
	private String tesis_fisica;
	
	@Column(name = "curso_fisica")
	private String curso_fisica;
	
	@Column(name = "nivel_curso_fisica")
	private String nivel_curso_fisica;
	
	@Column(name = "donde_laboral_fisica")
	private String donde_laboral_fisica;
	
	@Column(name = "antiguedad_fisica")
	private String antiguedad_fisica;
	
	@Column(name = "causa_fisica")
	private String causa_fisica;
	
	@Column(name = "donde_laboral_fisica2")
	private String donde_laboral_fisica2;
	
	@Column(name = "antiguedad_fisica2")
	private String antiguedad_fisica2;
	
	@Column(name = "causa_fisica2")
	private String causa_fisica2;
	
	@Column(name = "tipo_proyecto_fisica")
	private String tipo_proyecto_fisica;
	
	@Column(name = "duracion_proyecto_fisica")
	private String duracion_proyecto_fisica;

	@Column(name = "ubicacion_proyecto_fisica")
	private String ubicacion_proyecto_fisica;
	
	@Column(name = "municipio_proyecto_fisica")
	private String municipio_proyecto_fisica;
	
	@Column(name = "estado_proyecto_fisca")
	private String estado_proyecto_fisca;
	
	@Column(name = "federacion_proyecto_fisica")
	private String federacion_proyecto_fisica;
	
	@Column(name = "tipo_proyecto_fisica2")
	private String tipo_proyecto_fisica2;
	
	@Column(name = "duracion_proyecto_fisica2")
	private String duracion_proyecto_fisica2;
	
	@Column(name = "ubicacion_proyecto_fisica2")
	private String ubicacion_proyecto_fisica2;
	
	@Column(name = "municipio_proyecto_fisica2")
	private String municipio_proyecto_fisica2;
	
	@Column(name = "estado_proyecto_fisca2")
	private String estado_proyecto_fisca2;
	
	@Column(name = "federacion_proyecto_fisica2")
	private String federacion_proyecto_fisica2;
	
	@Column(name = "tipo_proyecto_fisica3")
	private String tipo_proyecto_fisica3;
	
	@Column(name = "duracion_proyecto_fisica3")
	private String duracion_proyecto_fisica3;
	
	@Column(name = "ubicacion_proyecto_fisica3")
	private String ubicacion_proyecto_fisica3;
	
	@Column(name = "municipio_proyecto_fisica3")
	private String municipio_proyecto_fisica3;
	
	@Column(name = "estado_proyecto_fisca3")
	private String estado_proyecto_fisca3;
	
	@Column(name = "federacion_proyecto_fisica3")
	private String federacion_proyecto_fisica3;
	
	@Column(name = "rfc_morales")
	private String rfc_morales;
	
	@Column(name = "domicilio_morales")
	private String domicilio_morales;
	
	@Column(name = "fecha_declaracion_morales")
	private String fecha_declaracion_morales;
	
	@Column(name = "factura_morales")
	private String factura_morales;
	
	@Column(name = "estudio_morales")
	private String estudio_morales;
	
	@Column(name = "nombre_estudios_morales")
	private String nombre_estudios_morales;
	
	@Column(name = "domicilio_estudios_morales")
	private String domicilio_estudios_morales;
	
	@Column(name = "fecha_estudios_morales")
	private String fecha_estudios_morales;
	
	@Column(name = "estudio_morales2")
	private String estudio_morales2;
	
	@Column(name = "nombre_estudios_morales2")
	private String nombre_estudios_morales2;
	
	@Column(name = "domicilio_estudios_morales2")
	private String domicilio_estudios_morales2;
	
	@Column(name = "fecha_estudios_morales2")
	private String fecha_estudios_morales2;

	@Column(name = "estudio_morales3")
	private String estudio_morales3;
	
	@Column(name = "nombre_estudios_morales3")
	private String nombre_estudios_morales3;
	
	@Column(name = "domicilio_estudios_morales3")
	private String domicilio_estudios_morales3;
	
	@Column(name = "fecha_estudios_morales3")
	private String fecha_estudios_morales3;
	
	@Column(name = "estudio_morales4")
	private String estudio_morales4;
	
	@Column(name = "nombre_estudios_morales4")
	private String nombre_estudios_morales4;
	
	@Column(name = "domicilio_estudios_morales4")
	private String domicilio_estudios_morales4;

	@Column(name = "fecha_estudios_morales4")
	private String fecha_estudios_morales4;
	
	@Column(name = "estudio_morales5")
	private String estudio_morales5;
	
	@Column(name = "nombre_estudios_morales5")
	private String nombre_estudios_morales5;
	
	@Column(name = "domicilio_estudios_morales5")
	private String domicilio_estudios_morales5;
	
	@Column(name = "fecha_estudios_morales5")
	private String fecha_estudios_morales5;

	@Column(name = "disponibilidad_equipo_infraestructuras")
	private String disponibilidad_equipo_infraestructuras;
	
	@Column(name = "cartografia")
	private String cartografia;
	
	@Column(name = "bibliografia")
	private String bibliografia;
	
	@Column(name = "curso_capacitacion")
	private String curso_capacitacion;

	@Column(name = "ingresos_mensuales")
	private String ingresos_mensuales;

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

	public int getIdtramite_registro_prestador_servicio() {
		return idtramite_registro_prestador_servicio;
	}

	public void setIdtramite_registro_prestador_servicio(
			int idtramite_registro_prestador_servicio) {
		this.idtramite_registro_prestador_servicio = idtramite_registro_prestador_servicio;
	}

	public String getClave_registro() {
		return clave_registro;
	}

	public void setClave_registro(String clave_registro) {
		this.clave_registro = clave_registro;
	}

	public String getApellido_paterno() {
		return apellido_paterno;
	}

	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}

	public String getApellido_materno() {
		return apellido_materno;
	}

	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNum_exterior() {
		return num_exterior;
	}

	public void setNum_exterior(String num_exterior) {
		this.num_exterior = num_exterior;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getNum_interior() {
		return num_interior;
	}

	public void setNum_interior(String num_interior) {
		this.num_interior = num_interior;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getCel() {
		return cel;
	}

	public void setCel(String cel) {
		this.cel = cel;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getSexo_fisica() {
		return sexo_fisica;
	}

	public void setSexo_fisica(String sexo_fisica) {
		this.sexo_fisica = sexo_fisica;
	}

	public String getNacionalidad_fisica() {
		return nacionalidad_fisica;
	}

	public void setNacionalidad_fisica(String nacionalidad_fisica) {
		this.nacionalidad_fisica = nacionalidad_fisica;
	}

	public String getLugar_nacimiento_fisica() {
		return lugar_nacimiento_fisica;
	}

	public void setLugar_nacimiento_fisica(String lugar_nacimiento_fisica) {
		this.lugar_nacimiento_fisica = lugar_nacimiento_fisica;
	}

	public String getPais_fisica() {
		return pais_fisica;
	}

	public void setPais_fisica(String pais_fisica) {
		this.pais_fisica = pais_fisica;
	}

	public String getRfc_fisica() {
		return rfc_fisica;
	}

	public void setRfc_fisica(String rfc_fisica) {
		this.rfc_fisica = rfc_fisica;
	}

	public String getCurp_fisica() {
		return curp_fisica;
	}

	public void setCurp_fisica(String curp_fisica) {
		this.curp_fisica = curp_fisica;
	}

	public String getDomicilio_fisica() {
		return domicilio_fisica;
	}

	public void setDomicilio_fisica(String domicilio_fisica) {
		this.domicilio_fisica = domicilio_fisica;
	}

	public String getFecha_declaracion_fisica() {
		return fecha_declaracion_fisica;
	}

	public void setFecha_declaracion_fisica(String fecha_declaracion_fisica) {
		this.fecha_declaracion_fisica = fecha_declaracion_fisica;
	}

	public String getFactura_fisica() {
		return factura_fisica;
	}

	public void setFactura_fisica(String factura_fisica) {
		this.factura_fisica = factura_fisica;
	}

	public String getAcademico_fisica() {
		return academico_fisica;
	}

	public void setAcademico_fisica(String academico_fisica) {
		this.academico_fisica = academico_fisica;
	}

	public String getCarrera_fisica() {
		return carrera_fisica;
	}

	public void setCarrera_fisica(String carrera_fisica) {
		this.carrera_fisica = carrera_fisica;
	}

	public String getPeriodo_fin_fisica() {
		return periodo_fin_fisica;
	}

	public void setPeriodo_fin_fisica(String periodo_fin_fisica) {
		this.periodo_fin_fisica = periodo_fin_fisica;
	}

	public String getTesis_fisica() {
		return tesis_fisica;
	}

	public void setTesis_fisica(String tesis_fisica) {
		this.tesis_fisica = tesis_fisica;
	}

	public String getCurso_fisica() {
		return curso_fisica;
	}

	public void setCurso_fisica(String curso_fisica) {
		this.curso_fisica = curso_fisica;
	}

	public String getNivel_curso_fisica() {
		return nivel_curso_fisica;
	}

	public void setNivel_curso_fisica(String nivel_curso_fisica) {
		this.nivel_curso_fisica = nivel_curso_fisica;
	}

	public String getDonde_laboral_fisica() {
		return donde_laboral_fisica;
	}

	public void setDonde_laboral_fisica(String donde_laboral_fisica) {
		this.donde_laboral_fisica = donde_laboral_fisica;
	}

	public String getAntiguedad_fisica() {
		return antiguedad_fisica;
	}

	public void setAntiguedad_fisica(String antiguedad_fisica) {
		this.antiguedad_fisica = antiguedad_fisica;
	}

	public String getCausa_fisica() {
		return causa_fisica;
	}

	public void setCausa_fisica(String causa_fisica) {
		this.causa_fisica = causa_fisica;
	}

	public String getDonde_laboral_fisica2() {
		return donde_laboral_fisica2;
	}

	public void setDonde_laboral_fisica2(String donde_laboral_fisica2) {
		this.donde_laboral_fisica2 = donde_laboral_fisica2;
	}

	public String getAntiguedad_fisica2() {
		return antiguedad_fisica2;
	}

	public void setAntiguedad_fisica2(String antiguedad_fisica2) {
		this.antiguedad_fisica2 = antiguedad_fisica2;
	}

	public String getCausa_fisica2() {
		return causa_fisica2;
	}

	public void setCausa_fisica2(String causa_fisica2) {
		this.causa_fisica2 = causa_fisica2;
	}

	public String getTipo_proyecto_fisica() {
		return tipo_proyecto_fisica;
	}

	public void setTipo_proyecto_fisica(String tipo_proyecto_fisica) {
		this.tipo_proyecto_fisica = tipo_proyecto_fisica;
	}

	public String getDuracion_proyecto_fisica() {
		return duracion_proyecto_fisica;
	}

	public void setDuracion_proyecto_fisica(String duracion_proyecto_fisica) {
		this.duracion_proyecto_fisica = duracion_proyecto_fisica;
	}

	public String getUbicacion_proyecto_fisica() {
		return ubicacion_proyecto_fisica;
	}

	public void setUbicacion_proyecto_fisica(String ubicacion_proyecto_fisica) {
		this.ubicacion_proyecto_fisica = ubicacion_proyecto_fisica;
	}

	public String getMunicipio_proyecto_fisica() {
		return municipio_proyecto_fisica;
	}

	public void setMunicipio_proyecto_fisica(String municipio_proyecto_fisica) {
		this.municipio_proyecto_fisica = municipio_proyecto_fisica;
	}

	public String getEstado_proyecto_fisca() {
		return estado_proyecto_fisca;
	}

	public void setEstado_proyecto_fisca(String estado_proyecto_fisca) {
		this.estado_proyecto_fisca = estado_proyecto_fisca;
	}

	public String getFederacion_proyecto_fisica() {
		return federacion_proyecto_fisica;
	}

	public void setFederacion_proyecto_fisica(String federacion_proyecto_fisica) {
		this.federacion_proyecto_fisica = federacion_proyecto_fisica;
	}

	public String getTipo_proyecto_fisica2() {
		return tipo_proyecto_fisica2;
	}

	public void setTipo_proyecto_fisica2(String tipo_proyecto_fisica2) {
		this.tipo_proyecto_fisica2 = tipo_proyecto_fisica2;
	}

	public String getDuracion_proyecto_fisica2() {
		return duracion_proyecto_fisica2;
	}

	public void setDuracion_proyecto_fisica2(String duracion_proyecto_fisica2) {
		this.duracion_proyecto_fisica2 = duracion_proyecto_fisica2;
	}

	public String getUbicacion_proyecto_fisica2() {
		return ubicacion_proyecto_fisica2;
	}

	public void setUbicacion_proyecto_fisica2(String ubicacion_proyecto_fisica2) {
		this.ubicacion_proyecto_fisica2 = ubicacion_proyecto_fisica2;
	}

	public String getMunicipio_proyecto_fisica2() {
		return municipio_proyecto_fisica2;
	}

	public void setMunicipio_proyecto_fisica2(String municipio_proyecto_fisica2) {
		this.municipio_proyecto_fisica2 = municipio_proyecto_fisica2;
	}

	public String getEstado_proyecto_fisca2() {
		return estado_proyecto_fisca2;
	}

	public void setEstado_proyecto_fisca2(String estado_proyecto_fisca2) {
		this.estado_proyecto_fisca2 = estado_proyecto_fisca2;
	}

	public String getFederacion_proyecto_fisica2() {
		return federacion_proyecto_fisica2;
	}

	public void setFederacion_proyecto_fisica2(String federacion_proyecto_fisica2) {
		this.federacion_proyecto_fisica2 = federacion_proyecto_fisica2;
	}

	public String getTipo_proyecto_fisica3() {
		return tipo_proyecto_fisica3;
	}

	public void setTipo_proyecto_fisica3(String tipo_proyecto_fisica3) {
		this.tipo_proyecto_fisica3 = tipo_proyecto_fisica3;
	}

	public String getDuracion_proyecto_fisica3() {
		return duracion_proyecto_fisica3;
	}

	public void setDuracion_proyecto_fisica3(String duracion_proyecto_fisica3) {
		this.duracion_proyecto_fisica3 = duracion_proyecto_fisica3;
	}

	public String getUbicacion_proyecto_fisica3() {
		return ubicacion_proyecto_fisica3;
	}

	public void setUbicacion_proyecto_fisica3(String ubicacion_proyecto_fisica3) {
		this.ubicacion_proyecto_fisica3 = ubicacion_proyecto_fisica3;
	}

	public String getMunicipio_proyecto_fisica3() {
		return municipio_proyecto_fisica3;
	}

	public void setMunicipio_proyecto_fisica3(String municipio_proyecto_fisica3) {
		this.municipio_proyecto_fisica3 = municipio_proyecto_fisica3;
	}

	public String getEstado_proyecto_fisca3() {
		return estado_proyecto_fisca3;
	}

	public void setEstado_proyecto_fisca3(String estado_proyecto_fisca3) {
		this.estado_proyecto_fisca3 = estado_proyecto_fisca3;
	}

	public String getFederacion_proyecto_fisica3() {
		return federacion_proyecto_fisica3;
	}

	public void setFederacion_proyecto_fisica3(String federacion_proyecto_fisica3) {
		this.federacion_proyecto_fisica3 = federacion_proyecto_fisica3;
	}

	public String getRfc_morales() {
		return rfc_morales;
	}

	public void setRfc_morales(String rfc_morales) {
		this.rfc_morales = rfc_morales;
	}

	public String getDomicilio_morales() {
		return domicilio_morales;
	}

	public void setDomicilio_morales(String domicilio_morales) {
		this.domicilio_morales = domicilio_morales;
	}

	public String getFecha_declaracion_morales() {
		return fecha_declaracion_morales;
	}

	public void setFecha_declaracion_morales(String fecha_declaracion_morales) {
		this.fecha_declaracion_morales = fecha_declaracion_morales;
	}

	public String getFactura_morales() {
		return factura_morales;
	}

	public void setFactura_morales(String factura_morales) {
		this.factura_morales = factura_morales;
	}

	public String getEstudio_morales() {
		return estudio_morales;
	}

	public void setEstudio_morales(String estudio_morales) {
		this.estudio_morales = estudio_morales;
	}

	public String getNombre_estudios_morales() {
		return nombre_estudios_morales;
	}

	public void setNombre_estudios_morales(String nombre_estudios_morales) {
		this.nombre_estudios_morales = nombre_estudios_morales;
	}

	public String getDomicilio_estudios_morales() {
		return domicilio_estudios_morales;
	}

	public void setDomicilio_estudios_morales(String domicilio_estudios_morales) {
		this.domicilio_estudios_morales = domicilio_estudios_morales;
	}

	public String getFecha_estudios_morales() {
		return fecha_estudios_morales;
	}

	public void setFecha_estudios_morales(String fecha_estudios_morales) {
		this.fecha_estudios_morales = fecha_estudios_morales;
	}

	public String getEstudio_morales2() {
		return estudio_morales2;
	}

	public void setEstudio_morales2(String estudio_morales2) {
		this.estudio_morales2 = estudio_morales2;
	}

	public String getNombre_estudios_morales2() {
		return nombre_estudios_morales2;
	}

	public void setNombre_estudios_morales2(String nombre_estudios_morales2) {
		this.nombre_estudios_morales2 = nombre_estudios_morales2;
	}

	public String getDomicilio_estudios_morales2() {
		return domicilio_estudios_morales2;
	}

	public void setDomicilio_estudios_morales2(String domicilio_estudios_morales2) {
		this.domicilio_estudios_morales2 = domicilio_estudios_morales2;
	}

	public String getFecha_estudios_morales2() {
		return fecha_estudios_morales2;
	}

	public void setFecha_estudios_morales2(String fecha_estudios_morales2) {
		this.fecha_estudios_morales2 = fecha_estudios_morales2;
	}

	public String getEstudio_morales3() {
		return estudio_morales3;
	}

	public void setEstudio_morales3(String estudio_morales3) {
		this.estudio_morales3 = estudio_morales3;
	}

	public String getNombre_estudios_morales3() {
		return nombre_estudios_morales3;
	}

	public void setNombre_estudios_morales3(String nombre_estudios_morales3) {
		this.nombre_estudios_morales3 = nombre_estudios_morales3;
	}

	public String getDomicilio_estudios_morales3() {
		return domicilio_estudios_morales3;
	}

	public void setDomicilio_estudios_morales3(String domicilio_estudios_morales3) {
		this.domicilio_estudios_morales3 = domicilio_estudios_morales3;
	}

	public String getFecha_estudios_morales3() {
		return fecha_estudios_morales3;
	}

	public void setFecha_estudios_morales3(String fecha_estudios_morales3) {
		this.fecha_estudios_morales3 = fecha_estudios_morales3;
	}

	public String getEstudio_morales4() {
		return estudio_morales4;
	}

	public void setEstudio_morales4(String estudio_morales4) {
		this.estudio_morales4 = estudio_morales4;
	}

	public String getNombre_estudios_morales4() {
		return nombre_estudios_morales4;
	}

	public void setNombre_estudios_morales4(String nombre_estudios_morales4) {
		this.nombre_estudios_morales4 = nombre_estudios_morales4;
	}

	public String getDomicilio_estudios_morales4() {
		return domicilio_estudios_morales4;
	}

	public void setDomicilio_estudios_morales4(String domicilio_estudios_morales4) {
		this.domicilio_estudios_morales4 = domicilio_estudios_morales4;
	}

	public String getFecha_estudios_morales4() {
		return fecha_estudios_morales4;
	}

	public void setFecha_estudios_morales4(String fecha_estudios_morales4) {
		this.fecha_estudios_morales4 = fecha_estudios_morales4;
	}

	public String getEstudio_morales5() {
		return estudio_morales5;
	}

	public void setEstudio_morales5(String estudio_morales5) {
		this.estudio_morales5 = estudio_morales5;
	}

	public String getNombre_estudios_morales5() {
		return nombre_estudios_morales5;
	}

	public void setNombre_estudios_morales5(String nombre_estudios_morales5) {
		this.nombre_estudios_morales5 = nombre_estudios_morales5;
	}

	public String getDomicilio_estudios_morales5() {
		return domicilio_estudios_morales5;
	}

	public void setDomicilio_estudios_morales5(String domicilio_estudios_morales5) {
		this.domicilio_estudios_morales5 = domicilio_estudios_morales5;
	}

	public String getFecha_estudios_morales5() {
		return fecha_estudios_morales5;
	}

	public void setFecha_estudios_morales5(String fecha_estudios_morales5) {
		this.fecha_estudios_morales5 = fecha_estudios_morales5;
	}

	public String getDisponibilidad_equipo_infraestructuras() {
		return disponibilidad_equipo_infraestructuras;
	}

	public void setDisponibilidad_equipo_infraestructuras(
			String disponibilidad_equipo_infraestructuras) {
		this.disponibilidad_equipo_infraestructuras = disponibilidad_equipo_infraestructuras;
	}

	public String getCartografia() {
		return cartografia;
	}

	public void setCartografia(String cartografia) {
		this.cartografia = cartografia;
	}

	public String getBibliografia() {
		return bibliografia;
	}

	public void setBibliografia(String bibliografia) {
		this.bibliografia = bibliografia;
	}

	public String getCurso_capacitacion() {
		return curso_capacitacion;
	}

	public void setCurso_capacitacion(String curso_capacitacion) {
		this.curso_capacitacion = curso_capacitacion;
	}

	public String getIngresos_mensuales() {
		return ingresos_mensuales;
	}

	public void setIngresos_mensuales(String ingresos_mensuales) {
		this.ingresos_mensuales = ingresos_mensuales;
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
}