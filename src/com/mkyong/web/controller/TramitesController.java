package com.mkyong.web.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ixanaui.utils.JsonDataWrapper;
import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.Bitacoras;
import com.mkyong.users.model.CatPerfilEstablecimiento;
import com.mkyong.users.model.CatalogoTramites;
import com.mkyong.users.model.Descargaaguasr;
import com.mkyong.users.model.RelacionJspTramite;
import com.mkyong.users.model.TramiteAutoriDispFinaRegisGene;
import com.mkyong.users.model.Tramite_InstaPlanTraTorResid;
import com.mkyong.users.model.Tramite_UbiOperMaIntEscSitDisFiResidProCons;
import com.mkyong.users.model.Tramite_UbiOperMaIntSitDisFiProEstTransf;
import com.mkyong.users.model.Tramite_actualizacion_situa_partdes;
import com.mkyong.users.model.Tramite_actualizacion_tranps;
import com.mkyong.users.model.Tramite_baja_cambio_dom;
import com.mkyong.users.model.Tramite_baja_permisos;
import com.mkyong.users.model.Tramite_baja_venta_pasivo;
import com.mkyong.users.model.Tramite_cambio_razon_social;
import com.mkyong.users.model.Tramite_cambio_representante;
import com.mkyong.users.model.Tramite_cambio_titularidad;
import com.mkyong.users.model.Tramite_cierre_operaciones;
import com.mkyong.users.model.Tramite_consultas;
import com.mkyong.users.model.Tramite_evaluacion_impacto_ambiental;
import com.mkyong.users.model.Tramite_fosa_septica;
import com.mkyong.users.model.Tramite_informacion;
import com.mkyong.users.model.Tramite_informesem;
import com.mkyong.users.model.Tramite_licencia_funcionamiento;
import com.mkyong.users.model.Tramite_modif_condif_part_desc;
import com.mkyong.users.model.Tramite_modif_licencia;
import com.mkyong.users.model.Tramite_modificacion_proyecto;
import com.mkyong.users.model.Tramite_operacion_manejo_integral_centros;
import com.mkyong.users.model.Tramite_operacion_manejo_integral_establecimientos;
import com.mkyong.users.model.Tramite_operacion_vehi_recolectores;
import com.mkyong.users.model.Tramite_otros;
import com.mkyong.users.model.Tramite_pedreras;
import com.mkyong.users.model.Tramite_planes_manejo_especificos;
import com.mkyong.users.model.Tramite_presentan_info_impacto;
import com.mkyong.users.model.Tramite_presentan_info_residuos;
import com.mkyong.users.model.Tramite_quema_cielo_abierto;
import com.mkyong.users.model.Tramite_reception_validacion_informacion;
import com.mkyong.users.model.Tramite_reciclaje_residuos_manejo_especial;
import com.mkyong.users.model.Tramite_recolecresidmaespe;
import com.mkyong.users.model.Tramite_registro_prestadores_servicios;
import com.mkyong.users.model.Tramite_registro_trans_aguas_reci;
import com.mkyong.users.model.Tramite_rehuso_residuos_manejo_especial;
import com.mkyong.users.model.Tramite_solicitud_copias;
import com.mkyong.users.model.Tramite_solicitud_prorroga;
import com.mkyong.users.model.Tramite_transresidmaespe;
import com.mkyong.users.model.Tramite_tratamiento_aguasr;
import com.mkyong.users.model.Tramite_ubiopermaintrellsaniconfnormofimex;
import com.mkyong.users.service.BitacorasService;
import com.mkyong.users.service.CatTramitesService;
import com.mkyong.users.service.DescargaaguasrService;
import com.mkyong.users.service.PerfilEmpresaService;
import com.mkyong.users.service.PerfilEstablecimientoService;
import com.mkyong.users.service.RelacionJspTramiteService;
import com.mkyong.users.service.Tramite_UbiOperMaIntEscSitDisFiResidProConsService;
import com.mkyong.users.service.Tramite_UbiOperMaIntSitDisFiProEstTransfService;
import com.mkyong.users.service.Tramite_actualizacion_situa_partdesService;
import com.mkyong.users.service.Tramite_actualizacion_tranpsService;
import com.mkyong.users.service.Tramite_baja_cambio_domService;
import com.mkyong.users.service.Tramite_baja_permisosService;
import com.mkyong.users.service.Tramite_baja_venta_pasivoService;
import com.mkyong.users.service.Tramite_cambio_razon_socialService;
import com.mkyong.users.service.Tramite_cambio_representanteService;
import com.mkyong.users.service.Tramite_cambio_titularidadService;
import com.mkyong.users.service.Tramite_cierre_operacionesService;
import com.mkyong.users.service.Tramite_consultasService;
import com.mkyong.users.service.Tramite_evaluacion_impacto_ambientalService;
import com.mkyong.users.service.Tramite_fosasepticaService;
import com.mkyong.users.service.Tramite_informacionService;
import com.mkyong.users.service.Tramite_informesemService;
import com.mkyong.users.service.Tramite_instaplantratorresidService;
import com.mkyong.users.service.Tramite_licencia_funcionamientoService;
import com.mkyong.users.service.Tramite_modif_condif_part_descService;
import com.mkyong.users.service.Tramite_modif_licenciaService;
import com.mkyong.users.service.Tramite_modificacion_proyectoService;
import com.mkyong.users.service.Tramite_operacion_manejo_integral_centrosService;
import com.mkyong.users.service.Tramite_operacion_manejo_integral_establecimientosService;
import com.mkyong.users.service.Tramite_operacion_vehi_recolectoresService;
import com.mkyong.users.service.Tramite_otrosService;
import com.mkyong.users.service.Tramite_pedrerasService;
import com.mkyong.users.service.Tramite_planes_manejo_especificosService;
import com.mkyong.users.service.Tramite_presentan_info_impactoService;
import com.mkyong.users.service.Tramite_presentan_info_residuosService;
import com.mkyong.users.service.Tramite_quema_cielo_abiertoService;
import com.mkyong.users.service.Tramite_reception_validacion_informacionService;
import com.mkyong.users.service.Tramite_reciclaje_residuos_manejo_especialService;
import com.mkyong.users.service.Tramite_recolecresidmarspeService;
import com.mkyong.users.service.Tramite_registro_prestadores_serviciosService;
import com.mkyong.users.service.Tramite_registro_trans_aguas_reciService;
import com.mkyong.users.service.Tramite_rehuso_residuos_manejo_especialService;
import com.mkyong.users.service.Tramite_solicitud_copiasService;
import com.mkyong.users.service.Tramite_solicitud_prorrogaService;
import com.mkyong.users.service.Tramite_transresidmaespeService;
import com.mkyong.users.service.Tramite_tratamientoService;
import com.mkyong.users.service.Tramite_ubiopermaintrellsaniconfnormofimexService;
import com.mkyong.users.service.TramiteautoridispfinaregisgeneService;

@Controller
public class TramitesController {
	@Autowired
	private BitacorasService  bitacorasService;
	
	@Autowired
	private PerfilEmpresaService  perfilEmpresaService;
	
	@Autowired
	private PerfilEstablecimientoService  perfilEstablecimientoService;
	
	@Autowired
	private CatTramitesService  cattramitesService;
	
	@Autowired
	private RelacionJspTramiteService  relacionjsptramiteService;
	
	@Autowired
	private Tramite_quema_cielo_abiertoService  tramite_quema_cielo_abiertoService;
	
	@Autowired
	private Tramite_licencia_funcionamientoService  tramite_licencia_funcionamientoService;
	
	@Autowired
	private Tramite_cambio_razon_socialService  tramite_cambio_razon_socialService;
	
	@Autowired
	private Tramite_cambio_representanteService  tramite_cambio_representanteService;
	
	@Autowired
	private Tramite_evaluacion_impacto_ambientalService  tramite_evaluacion_impacto_ambientalService;
	
	@Autowired
	private Tramite_cambio_titularidadService  tramite_cambio_titularidadService;
	
	@Autowired
	private Tramite_solicitud_prorrogaService  tramite_solicitud_prorrogaService;
	
	@Autowired
	private Tramite_solicitud_copiasService  tramite_solicitud_copiasService;
	
	@Autowired
	private Tramite_consultasService  tramite_consultasService;
	
	@Autowired
	private Tramite_modificacion_proyectoService  tramite_modificacion_proyectoService;
	
	@Autowired
	private DescargaaguasrService  descargaaguasrService;
	
	@Autowired
	private Tramite_tratamientoService  tramite_tratamientoService;

	@Autowired
	private Tramite_fosasepticaService  tramite_fosasepticaService;

	@Autowired
	private Tramite_informesemService  tramite_informesemService;
	
	@Autowired
	private TramiteautoridispfinaregisgeneService  tramiteautoridispfinaregisgeneService;
	
	@Autowired
	private Tramite_UbiOperMaIntEscSitDisFiResidProConsService  tramite_UbiOperMaIntEscSitDisFiResidProConsService;

	@Autowired
	private Tramite_UbiOperMaIntSitDisFiProEstTransfService  tramite_UbiOperMaIntSitDisFiProEstTransfService;

	@Autowired
	private Tramite_instaplantratorresidService  tramite_instaplantratorresidService;

	@Autowired
	private Tramite_ubiopermaintrellsaniconfnormofimexService  Tramite_ubiopermaintrellsaniconfnormofimexService;

	@Autowired
	private Tramite_reciclaje_residuos_manejo_especialService  Tramite_reciclaje_residuos_manejo_especialService;
	
	@Autowired
	private Tramite_transresidmaespeService  tramite_transresidmaespeService;

	@Autowired
	private Tramite_recolecresidmarspeService tramite_recolecresidmarspeService;
	
	@Autowired
	private Tramite_rehuso_residuos_manejo_especialService Tramite_rehuso_residuos_manejo_especialService;
	
	@Autowired
	private Tramite_operacion_vehi_recolectoresService Tramite_operacion_vehi_recolectoresService;
	
	@Autowired
	private Tramite_operacion_manejo_integral_centrosService Tramite_operacion_manejo_integral_centrosService;
	
	@Autowired
	private Tramite_operacion_manejo_integral_establecimientosService Tramite_operacion_manejo_integral_establecimientosService;
	
	@Autowired
	private Tramite_reception_validacion_informacionService Tramite_reception_validacion_informacionService;
	
	@Autowired
	private Tramite_planes_manejo_especificosService Tramite_planes_manejo_especificosService;
	
	@Autowired
	private Tramite_UbiOperMaIntSitDisFiProEstTransfService Tramite_UbiOperMaIntSitDisFiProEstTransfService;
	
	@Autowired
	private Tramite_cierre_operacionesService Tramite_cierre_operacionesService;
	
	@Autowired
	private Tramite_informacionService tramite_informacionService;
	
	@Autowired
	private Tramite_actualizacion_tranpsService tramite_actualizacion_tranpsService;
	
	@Autowired
	private Tramite_baja_cambio_domService tramite_baja_cambio_domService;
	
	@Autowired
	private Tramite_baja_venta_pasivoService tramite_baja_venta_pasivoService;
	
	@Autowired
	private Tramite_modif_condif_part_descService tramite_modif_condif_part_descService;
	
	@Autowired
	private Tramite_actualizacion_situa_partdesService tramite_actualizacion_situa_partdesService;

	@Autowired
	private Tramite_registro_trans_aguas_reciService tramite_registro_trans_aguas_reciService;

	@Autowired
	private Tramite_registro_prestadores_serviciosService tramite_registro_prestadores_serviciosService;
	
	@Autowired
	private Tramite_modif_licenciaService tramite_modif_licenciaService;
	
	@Autowired
	private Tramite_otrosService tramite_otrosService;
	
	@Autowired
	private Tramite_baja_permisosService tramite_baja_permisosService;
	
	@Autowired
	private Tramite_presentan_info_impactoService tramite_presentan_info_impactoService;
	
	@Autowired
	private Tramite_presentan_info_residuosService tramite_presentan_info_residuosService;
	
	@Autowired
	private Tramite_pedrerasService tramite_pedrerasService;
	
		
	private DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	

	/*
	 * Muestra el catalogo de la denuncias en forma de vista
	 */
	@RequestMapping(value = { "/showCatalogoTramites" }, method = RequestMethod.GET)
	public ModelAndView showCatalogoTramites() {
		ModelAndView model = new ModelAndView();
	
		model.setViewName("reception/new_tramite");
		return model;
	}
	
	
	/*
	 * Mostrar el tramite 
	 */
	 @RequestMapping(value = { "/getDataTramite" }, method = RequestMethod.GET)
		public ModelAndView getDataTramite(HttpServletRequest request,
				HttpServletResponse response) {
		 	ModelAndView model = new ModelAndView();
		 	String idtramite = request.getParameter("idtramite");
		 	String tipo = request.getParameter("tipo");
		 	CatalogoTramites result =new CatalogoTramites();
		 	CatalogoTramites nuevo= new  CatalogoTramites();
		 	RelacionJspTramite page= new RelacionJspTramite();
		 	
		 	switch(tipo){
		 	case "1":	//Licencia de funcionamiento
		 		Tramite_licencia_funcionamiento dato = new Tramite_licencia_funcionamiento();
			 		dato.setIdtramite_licencia_funcionamiento(Integer.parseInt(idtramite));
			 		nuevo.setCatalogoID(1);
			 	 	result = cattramitesService.consultaTramite(nuevo);
				 	page = relacionjsptramiteService.consultaRelacionJspTramite(result);
				 	model.addObject("data",tramite_licencia_funcionamientoService.busquedaById(dato).get(0));
			 		break;
		 	case "2":	//Quema a cielo abierto
		 		Tramite_quema_cielo_abierto dato1 = new Tramite_quema_cielo_abierto();
			 		dato1.setIdtramite_quema_cielo_abierto(Integer.parseInt(idtramite));
			 		nuevo.setCatalogoID(2);
			 	 	result = cattramitesService.consultaTramite(nuevo);
				 	page = relacionjsptramiteService.consultaRelacionJspTramite(result);
				 	model.addObject("data",tramite_quema_cielo_abiertoService.busquedaById(dato1).get(0));
			 		break;
		 	case "3":	//Cambio de Razón Social
		 	Tramite_cambio_razon_social dato11 = new Tramite_cambio_razon_social();
		 		dato11.setIdtramite_cambio_razon_social(Integer.parseInt(idtramite));
		 		nuevo.setCatalogoID(3);
		 	 	result = cattramitesService.consultaTramite(nuevo);
			 	page = relacionjsptramiteService.consultaRelacionJspTramite(result);
			 	model.addObject("data",tramite_cambio_razon_socialService.busquedaById(dato11).get(0));
		 		break;
		 	case "4":	//Cambio de Representante Legal
		 		Tramite_cambio_representante dato4 = new Tramite_cambio_representante();
			 		dato4.setIdtramite_cambio_representante(Integer.parseInt(idtramite));
			 		nuevo.setCatalogoID(4);
			 	 	result = cattramitesService.consultaTramite(nuevo);
				 	page = relacionjsptramiteService.consultaRelacionJspTramite(result);
				 	model.addObject("data",tramite_cambio_representanteService.busquedaById(dato4).get(0));
			 		break;
		 	case "5":	//Cierre de operaciones
		 		Tramite_cierre_operaciones date5 = new Tramite_cierre_operaciones();
			 		date5.setIdtramite_cierre_operaciones(Integer.parseInt(idtramite));
			 		nuevo.setCatalogoID(5);
			 	 	result = cattramitesService.consultaTramite(nuevo);
				 	page = relacionjsptramiteService.consultaRelacionJspTramite(result);
				 	model.addObject("data",Tramite_cierre_operacionesService.busquedaById(date5).get(0));
			 		break;
			case "6":	//Evaluación de Impacto Ambiental
				Tramite_evaluacion_impacto_ambiental date6 = new Tramite_evaluacion_impacto_ambiental();
			 		date6.setIdtramite_evaluacion_impacto_ambiental(Integer.parseInt(idtramite));
			 		nuevo.setCatalogoID(6);
			 	 	result = cattramitesService.consultaTramite(nuevo);
				 	page = relacionjsptramiteService.consultaRelacionJspTramite(result);
				 	model.addObject("data",tramite_evaluacion_impacto_ambientalService.busquedaById(date6).get(0));
			 		break;
			case "7":	//Cambio de titularidad
					Tramite_cambio_titularidad date7 = new Tramite_cambio_titularidad();
			 		date7.setIdtramite_cambio_titularidad(Integer.parseInt(idtramite));
			 		nuevo.setCatalogoID(7);
			 	 	result = cattramitesService.consultaTramite(nuevo);
				 	page = relacionjsptramiteService.consultaRelacionJspTramite(result);
				 	model.addObject("data",tramite_cambio_titularidadService.busquedaById(date7).get(0));
			 		break;
			 		
			case "9":	//Solicitud de prorrogas
				Tramite_solicitud_prorroga data9 = new Tramite_solicitud_prorroga();
		 		data9.setIdtramite_solicitud_prorroga(Integer.parseInt(idtramite));
		 		nuevo.setCatalogoID(9);
		 	 	result = cattramitesService.consultaTramite(nuevo);
			 	page = relacionjsptramiteService.consultaRelacionJspTramite(result);
			 	model.addObject("data",tramite_solicitud_prorrogaService.busquedaById(data9).get(0));
		 		break;
			case "10":	//Solicitud de Copias
				Tramite_solicitud_copias data10 = new Tramite_solicitud_copias();
		 		data10.setIdtramite_solicitud_copias(Integer.parseInt(idtramite));
		 		nuevo.setCatalogoID(10);
		 	 	result = cattramitesService.consultaTramite(nuevo);
			 	page = relacionjsptramiteService.consultaRelacionJspTramite(result);
			 	model.addObject("data",tramite_solicitud_copiasService.busquedaById(data10).get(0));
		 		break;
			case "11":	//Consultas
				Tramite_consultas data11 = new Tramite_consultas();
		 		data11.setIdtramite_consultas(Integer.parseInt(idtramite));
		 		nuevo.setCatalogoID(11);
		 	 	result = cattramitesService.consultaTramite(nuevo);
			 	page = relacionjsptramiteService.consultaRelacionJspTramite(result);
			 	model.addObject("data",tramite_consultasService.busquedaById(data11).get(0));
		 		break;
			case "12":	//Modificación de proyectos
				Tramite_modificacion_proyecto data12 = new Tramite_modificacion_proyecto();
		 		data12.setIdtramite_modificacion_proyecto(Integer.parseInt(idtramite));
		 		nuevo.setCatalogoID(12);
		 	 	result = cattramitesService.consultaTramite(nuevo);
			 	page = relacionjsptramiteService.consultaRelacionJspTramite(result);
			 	model.addObject("data",tramite_modificacion_proyectoService.busquedaById(data12).get(0));
		 		break;
			case "16":	//Registro de aguas residuales
				Descargaaguasr data16 = new Descargaaguasr();
		 		data16.setIdtramite(Integer.parseInt(idtramite));
		 		nuevo.setCatalogoID(16);
		 	 	result = cattramitesService.consultaTramite(nuevo);
			 	page = relacionjsptramiteService.consultaRelacionJspTramite(result);
			 	model.addObject("data",descargaaguasrService.busquedaById(data16).get(0));
		 		break;
			case "17":	//Registro de planta de tratamiento de aguas residuales
				Tramite_tratamiento_aguasr data17 = new Tramite_tratamiento_aguasr();
		 		data17.setIdtramite_tratamiento(Integer.parseInt(idtramite));
		 		nuevo.setCatalogoID(17);
		 	 	result = cattramitesService.consultaTramite(nuevo);
			 	page = relacionjsptramiteService.consultaRelacionJspTramite(result);
			 	model.addObject("data",tramite_tratamientoService.busquedaById(data17).get(0));
		 		break;
			case "18":	//Registro de planta de tratamiento de aguas residuales
				Tramite_fosa_septica data18 = new Tramite_fosa_septica();
		 		data18.setIdtramite_fosaseptica(Integer.parseInt(idtramite));
		 		nuevo.setCatalogoID(18);
		 	 	result = cattramitesService.consultaTramite(nuevo);
			 	page = relacionjsptramiteService.consultaRelacionJspTramite(result);
			 	model.addObject("data",tramite_fosasepticaService.consulta(data18));
		 		break;
			case "19":	//Registro de planta de tratamiento de aguas residuales
				Tramite_registro_trans_aguas_reci data19 = new Tramite_registro_trans_aguas_reci();
		 		data19.setIdtramite_registro_trans_aguas_reci(Integer.parseInt(idtramite));
		 		nuevo.setCatalogoID(19);
		 	 	result = cattramitesService.consultaTramite(nuevo);
			 	page = relacionjsptramiteService.consultaRelacionJspTramite(result);
			 	model.addObject("data",tramite_registro_trans_aguas_reciService.consulta(data19,""));
		 		break;
			case "20":	//Informe Semestral
				Tramite_informesem data20 = new Tramite_informesem();
		 		data20.setIdtramite_informesem(Integer.parseInt(idtramite));
		 		nuevo.setCatalogoID(20);
		 	 	result = cattramitesService.consultaTramite(nuevo);
			 	page = relacionjsptramiteService.consultaRelacionJspTramite(result);
			 	model.addObject("data",this.tramite_informesemService.consulta(data20));
		 		break;

			case "21":	//Solicitud de información
				Tramite_informacion data21 = new Tramite_informacion();
		 		data21.setIdtramite_informacion(Integer.parseInt(idtramite));
		 		nuevo.setCatalogoID(21);
		 	 	result = cattramitesService.consultaTramite(nuevo);
			 	page = relacionjsptramiteService.consultaRelacionJspTramite(result);
			 	model.addObject("data",tramite_informacionService.busquedaById(data21).get(0));
		 		break;
			case "22":	//Actualización de transportistas
				Tramite_actualizacion_tranps data22 = new Tramite_actualizacion_tranps();
		 		data22.setIdtramite_actualizacion_tranps(Integer.parseInt(idtramite));
		 		nuevo.setCatalogoID(22);
		 	 	result = cattramitesService.consultaTramite(nuevo);
			 	page = relacionjsptramiteService.consultaRelacionJspTramite(result);
			 	model.addObject("data",tramite_actualizacion_tranpsService.busquedaById(data22).get(0));
		 		break;
			case "23":	//Actualización de situación particular de descarga
				Tramite_actualizacion_situa_partdes data23 = new Tramite_actualizacion_situa_partdes();
		 		data23.setIdtramite(Integer.parseInt(idtramite));
		 		nuevo.setCatalogoID(23);
		 	 	result = cattramitesService.consultaTramite(nuevo);
			 	page = relacionjsptramiteService.consultaRelacionJspTramite(result);
			 	model.addObject("data",tramite_actualizacion_situa_partdesService.consulta(data23,""));
		 		break;
			case "24":	//Baja por cambio de domicilio
				Tramite_baja_cambio_dom data24 = new Tramite_baja_cambio_dom();
		 		data24.setIdtramite_baja_cambio_dom(Integer.parseInt(idtramite));
		 		nuevo.setCatalogoID(24);
		 	 	result = cattramitesService.consultaTramite(nuevo);
			 	page = relacionjsptramiteService.consultaRelacionJspTramite(result);
			 	model.addObject("data",tramite_baja_cambio_domService.busquedaById(data24).get(0));
		 		break;
			case "25":	//Modificación de las condiciones particulares de descarga según el parámetro y/o número de descarga.
				Tramite_modif_condif_part_desc data25 = new Tramite_modif_condif_part_desc();
		 		data25.setIdtramite(Integer.parseInt(idtramite));
		 		nuevo.setCatalogoID(25);
		 	 	result = cattramitesService.consultaTramite(nuevo);
			 	page = relacionjsptramiteService.consultaRelacionJspTramite(result);
			 	model.addObject("data",tramite_modif_condif_part_descService.consulta(data25,""));
		 		break;

			case "26":	//Baja por venta de pasivo ambiental
				Tramite_baja_venta_pasivo data26 = new Tramite_baja_venta_pasivo();
		 		data26.setIdtramite_baja_venta_pasivo(Integer.parseInt(idtramite));
		 		nuevo.setCatalogoID(26);
		 	 	result = cattramitesService.consultaTramite(nuevo);
			 	page = relacionjsptramiteService.consultaRelacionJspTramite(result);
			 	model.addObject("data",tramite_baja_venta_pasivoService.busquedaById(data26).get(0));
		 		break;
			case "27":	//Autorización para la disposición final y registro como generador
				TramiteAutoriDispFinaRegisGene data27 = new TramiteAutoriDispFinaRegisGene();
		 		data27.setIdtramite(Integer.parseInt(idtramite));
		 		nuevo.setCatalogoID(27);
		 	 	result = cattramitesService.consultaTramite(nuevo);
			 	page = relacionjsptramiteService.consultaRelacionJspTramite(result);
			 	model.addObject("data",tramiteautoridispfinaregisgeneService.busquedaById(data27).get(0));
		 		break;
			case "28":	//Ubicación, operación y manejo integral de escombreras o sitios de disposición final de residuos provenientes de la construcción
				Tramite_UbiOperMaIntEscSitDisFiResidProCons data28 = new Tramite_UbiOperMaIntEscSitDisFiResidProCons();
		 		data28.setIdtramite(Integer.parseInt(idtramite));
		 		nuevo.setCatalogoID(28);
		 	 	result = cattramitesService.consultaTramite(nuevo);
			 	page = relacionjsptramiteService.consultaRelacionJspTramite(result);
			 	model.addObject("data",tramite_UbiOperMaIntEscSitDisFiResidProConsService.busquedaById(data28).get(0));
		 		break;
			case "29":	//Ubicación, operación y manejo integral de sitios de disposición final de residuos provenientes de las estaciones de transferencia.
				Tramite_UbiOperMaIntSitDisFiProEstTransf data29 = new Tramite_UbiOperMaIntSitDisFiProEstTransf();
		 		data29.setIdtramite(Integer.parseInt(idtramite));
		 		nuevo.setCatalogoID(29);
		 	 	result = cattramitesService.consultaTramite(nuevo);
			 	page = relacionjsptramiteService.consultaRelacionJspTramite(result);
			 	model.addObject("data",Tramite_UbiOperMaIntSitDisFiProEstTransfService.busquedaById(data29).get(0));
		 		break;
			case "30":	//Instalación de plantas de tratamiento térmico de residuos
				Tramite_InstaPlanTraTorResid data30 = new Tramite_InstaPlanTraTorResid();
		 		data30.setIdtramite(Integer.parseInt(idtramite));
		 		nuevo.setCatalogoID(30);
		 	 	result = cattramitesService.consultaTramite(nuevo);
			 	page = relacionjsptramiteService.consultaRelacionJspTramite(result);
			 	model.addObject("data",tramite_instaplantratorresidService.busquedaById(data30).get(0));
		 		break;
			case "31":	//Ubicación, operación y manejo integral de un relleno sanitario, conforme a las Normas Oficiales Mexicanas y demás ordenamientos aplicables.
				Tramite_ubiopermaintrellsaniconfnormofimex data31 = new Tramite_ubiopermaintrellsaniconfnormofimex();
		 		data31.setIdtramite(Integer.parseInt(idtramite));
		 		nuevo.setCatalogoID(31);
		 	 	result = cattramitesService.consultaTramite(nuevo);
			 	page = relacionjsptramiteService.consultaRelacionJspTramite(result);
			 	model.addObject("data",Tramite_ubiopermaintrellsaniconfnormofimexService.busquedaById(data31).get(0));
		 		break;
			case "32":	//Transportes de residuos de manejo especial
				Tramite_transresidmaespe data32 = new Tramite_transresidmaespe();
		 		data32.setIdtramite(Integer.parseInt(idtramite));
		 		nuevo.setCatalogoID(32);
		 	 	result = cattramitesService.consultaTramite(nuevo);
			 	page = relacionjsptramiteService.consultaRelacionJspTramite(result);
			 	model.addObject("data",tramite_transresidmaespeService.busquedaById(data32).get(0));
		 		break;
			case "33":	//Recolección de residuos de manejo especial
				Tramite_recolecresidmaespe data33 = new Tramite_recolecresidmaespe();
		 		data33.setIdtramite(Integer.parseInt(idtramite));
		 		nuevo.setCatalogoID(33);
		 	 	result = cattramitesService.consultaTramite(nuevo);
			 	page = relacionjsptramiteService.consultaRelacionJspTramite(result);
			 	model.addObject("data",tramite_recolecresidmarspeService.busquedaById(data33).get(0));
		 		break;
			case "34":	//Reciclaje de residuos de manejo especial
				Tramite_reciclaje_residuos_manejo_especial data34 = new Tramite_reciclaje_residuos_manejo_especial();
		 		data34.setIdtramite_reciclaje_residuos_manejo_especial(Integer.parseInt(idtramite));
		 		nuevo.setCatalogoID(34);
		 	 	result = cattramitesService.consultaTramite(nuevo);
			 	page = relacionjsptramiteService.consultaRelacionJspTramite(result);
			 	model.addObject("data",Tramite_reciclaje_residuos_manejo_especialService.busquedaById(data34).get(0));
		 		break;
			case "35":	//Operación de los vehículos recolectores de residuos sólidos urbanos cuando presenten el servicio a dos o más municipios
				Tramite_operacion_vehi_recolectores data35 = new Tramite_operacion_vehi_recolectores();
		 		data35.setIdtramite_operacion_vehi_recolectores(Integer.parseInt(idtramite));
		 		nuevo.setCatalogoID(35);
		 	 	result = cattramitesService.consultaTramite(nuevo);
			 	page = relacionjsptramiteService.consultaRelacionJspTramite(result);
			 	model.addObject("data",Tramite_operacion_vehi_recolectoresService.busquedaById(data35).get(0));
		 		break;
			case "36":	//Operación y manejo integral de los establecimientos para la compra y venta de materiales reciclables.
				Tramite_operacion_manejo_integral_establecimientos data36 = new Tramite_operacion_manejo_integral_establecimientos();
		 		data36.setIdtramite_operacion_manejo_integral_establecimientos(Integer.parseInt(idtramite));
		 		nuevo.setCatalogoID(36);
		 	 	result = cattramitesService.consultaTramite(nuevo);
			 	page = relacionjsptramiteService.consultaRelacionJspTramite(result);
			 	model.addObject("data",Tramite_operacion_manejo_integral_establecimientosService.busquedaById(data36).get(0));
		 		break;
			case "37":	//Planes de manejo específicos de residuos de manejo especial
				Tramite_planes_manejo_especificos data37 = new Tramite_planes_manejo_especificos();
		 		data37.setIdtramite_planes_manejo_especificos(Integer.parseInt(idtramite));
		 		nuevo.setCatalogoID(37);
		 	 	result = cattramitesService.consultaTramite(nuevo);
			 	page = relacionjsptramiteService.consultaRelacionJspTramite(result);
			 	model.addObject("data",Tramite_planes_manejo_especificosService.busquedaById(data37).get(0));
		 		break;
			case "39":	//Recepción y Validación de información del COA
				Tramite_reception_validacion_informacion data39 = new Tramite_reception_validacion_informacion();
		 		data39.setIdtramite_reception_validacion_informacion(Integer.parseInt(idtramite));
		 		nuevo.setCatalogoID(39);
		 	 	result = cattramitesService.consultaTramite(nuevo);
			 	page = relacionjsptramiteService.consultaRelacionJspTramite(result);
			 	model.addObject("data",Tramite_reception_validacion_informacionService.busquedaById(data39).get(0));
		 		break;
			case "40":	//Reuso de residuos de manejo especial
				Tramite_rehuso_residuos_manejo_especial data40 = new Tramite_rehuso_residuos_manejo_especial();
		 		data40.setIdtramite_rehuso_residuos_manejo_especial(Integer.parseInt(idtramite));
		 		nuevo.setCatalogoID(40);
		 	 	result = cattramitesService.consultaTramite(nuevo);
			 	page = relacionjsptramiteService.consultaRelacionJspTramite(result);
			 	model.addObject("data",Tramite_rehuso_residuos_manejo_especialService.busquedaById(data40).get(0));
		 		break;
			case "41":	//Operación y manejo integral de los centros de composteo
				Tramite_operacion_manejo_integral_centros data41 = new Tramite_operacion_manejo_integral_centros();
		 		data41.setIdtramite_operacion_manejo_integral_centros(Integer.parseInt(idtramite));
		 		nuevo.setCatalogoID(41);
		 	 	result = cattramitesService.consultaTramite(nuevo);
			 	page = relacionjsptramiteService.consultaRelacionJspTramite(result);
			 	model.addObject("data",Tramite_operacion_manejo_integral_centrosService.busquedaById(data41).get(0));
		 		break;
			case "42":	//Modificación de licencia
				Tramite_modif_licencia data42 = new Tramite_modif_licencia();
				data42.setIdtramite_modif_licencia(Integer.parseInt(idtramite));
		 		nuevo.setCatalogoID(42);
		 	 	result = cattramitesService.consultaTramite(nuevo);
			 	page = relacionjsptramiteService.consultaRelacionJspTramite(result);
			 	model.addObject("data",tramite_modif_licenciaService.busquedaById(data42).get(0));
		 		break;
			case "43":	//Otros
				Tramite_otros data43 = new Tramite_otros();
		 		data43.setIdtramite_otros(Integer.parseInt(idtramite));
		 		nuevo.setCatalogoID(43);
		 	 	result = cattramitesService.consultaTramite(nuevo);
			 	page = relacionjsptramiteService.consultaRelacionJspTramite(result);
			 	model.addObject("data",tramite_otrosService.busquedaById(data43).get(0));
		 		break;
			case "44":	//Baja de permisos
				Tramite_baja_permisos data44 = new Tramite_baja_permisos();
		 		data44.setIdtramite_baja_permisos(Integer.parseInt(idtramite));
		 		nuevo.setCatalogoID(44);
		 	 	result = cattramitesService.consultaTramite(nuevo);
			 	page = relacionjsptramiteService.consultaRelacionJspTramite(result);
			 	model.addObject("data",tramite_baja_permisosService.busquedaById(data44).get(0));
		 		break;
			case "45":	//Tramite presentan informacion impacto ambiental
				Tramite_presentan_info_impacto data45 = new Tramite_presentan_info_impacto();
				data45.setIdtramite_impacto(Integer.parseInt(idtramite));
				nuevo.setCatalogoID(45);
				result = cattramitesService.consultaTramite(nuevo);
				page = relacionjsptramiteService.consultaRelacionJspTramite(result);
				model.addObject("data", tramite_presentan_info_impactoService.busquedaById(data45).get(0));
				break;
			case "47": //Tramite presentan informacion residuos
				Tramite_presentan_info_residuos data47 = new Tramite_presentan_info_residuos();
				data47.setIdtramite_residuos(Integer.parseInt(idtramite));
				nuevo.setCatalogoID(47);
				result = cattramitesService.consultaTramite(nuevo);
				page = relacionjsptramiteService.consultaRelacionJspTramite(result);
				model.addObject("data", tramite_presentan_info_residuosService.busquedaById(data47).get(0));
				break;
		 		
			case "49": //Tramite pedreras de inspeccion y vigilancia
				Tramite_pedreras data49 = new Tramite_pedreras();
				data49.setIdtramite_pedreras(Integer.parseInt(idtramite));
				nuevo.setCatalogoID(49);
				result = cattramitesService.consultaTramite(nuevo);
				page = relacionjsptramiteService.consultaRelacionJspTramite(result);
				model.addObject("data", tramite_pedrerasService.busquedaById(data49).get(0));
				break;
		 	}

		 	System.out.println("result.getNombreTramite() "+result.getNombreTramite());
		 	System.out.println("result.getAreaID() "+result.getAreaID());
		 	System.out.println("result.getCatalogoID() "+result.getCatalogoID());
		 	System.out.println("page.getUrl_server() "+page.getUrl_server());
		 	System.out.println("page.getIdrelacion_jsp_tramite() "+page.getIdrelacion_jsp_tramite());
		 	System.out.println("page.getCatalogo_tramites_catalogoID() "+page.getCatalogo_tramites_catalogoID());
			
			
			model.setViewName("formularios_tramites/"+page.getUrl_server());
			model.addObject("empresas", perfilEmpresaService.lista());
			model.addObject("establecimientos", perfilEstablecimientoService.lista());
			model.addObject("view", 1);
			

			return model;

		}
	
	/*
	 * Muestra el catalogo de la denuncias en forma de vista
	 */
	@RequestMapping(value = { "/busquedaTramite" }, method = RequestMethod.GET)
	public ModelAndView showBusquedaTramites() {
		ModelAndView model = new ModelAndView();
		List<CatalogoTramites> list =cattramitesService.searchList();
		model.addObject("tiposTramite", list);
		model.addObject("municipios", perfilEstablecimientoService.getMunicipiosEstablecimientos());
		model.setViewName("formularios_tramites/busquedaTramites");
		
		//sacar la lista de municipios que ahi en la tabla establecimiento
		
		
		
		return model;
	}
	
	 @RequestMapping(value = "/getBusquedaTramite", method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody JsonDataWrapper getBusquedaTramite(HttpServletRequest request,HttpServletResponse response) {
		 
			String tipo_tramite = request.getParameter("tipo_tramite");
			String municipio_tramite = request.getParameter("municipio_tramite");
			String colonia_tramite = request.getParameter("colonia_tramite");
			
			System.out.println("tipo de tramite busqueda "+tipo_tramite);
			System.out.println("tipo de tramite busqueda "+municipio_tramite);
			System.out.println("tipo de tramite busqueda "+colonia_tramite);
			
			if(municipio_tramite.equals("Todos"))
				municipio_tramite="%";
			if(colonia_tramite.equals("Todos"))
				colonia_tramite="%";
			
			List<WrapperTramite>  list = new ArrayList<WrapperTramite>();;
			switch(tipo_tramite){
			
			case "1"://Licencia de funcionamiento
				list = tramite_licencia_funcionamientoService.listaTramitesByZona(municipio_tramite, colonia_tramite);
				break;
			case "2"://Quema a cielo abierto
				list = tramite_quema_cielo_abiertoService.listaTramitesByZona(municipio_tramite, colonia_tramite);
				break;
			case "3"://Cambio de Razón Social
				list =tramite_cambio_razon_socialService.listaTramitesByZona(municipio_tramite, colonia_tramite);
				break;
				case "4"://Cambio de Representante Legal
					list =tramite_cambio_representanteService.listaTramitesByZona(municipio_tramite, colonia_tramite);
					break;
				case "5"://Cierre de operaciones
					list =Tramite_cierre_operacionesService.listaTramitesByZona(municipio_tramite, colonia_tramite);
					break;
				case "6"://Evaluación de Impacto Ambiental
					list =tramite_evaluacion_impacto_ambientalService.listaTramitesByZona(municipio_tramite, colonia_tramite);
					break;
				case "7"://Cambio de titularidad
					list =tramite_cambio_titularidadService.listaTramitesByZona(municipio_tramite, colonia_tramite);
					break;
				case "9"://Solicitud de prorrogas
					list =tramite_solicitud_prorrogaService.listaTramitesByZona(municipio_tramite, colonia_tramite);
					break;
				case "10"://Solicitud de Copias
					list =tramite_solicitud_copiasService.listaTramitesByZona(municipio_tramite, colonia_tramite);
					break;
				case "11"://Consultas
					list =tramite_consultasService.listaTramitesByZona(municipio_tramite, colonia_tramite);
					break;
				case "12"://Modificación de proyectos
					list =tramite_modificacion_proyectoService.listaTramitesByZona(municipio_tramite, colonia_tramite);
					break;
				case "16"://Registro de aguas residuales
					list =descargaaguasrService.listaTramitesByZona(municipio_tramite, colonia_tramite);
					break;
				case "17"://Registro de planta de tratamiento de aguas residuales
					list =tramite_tratamientoService.listaTramitesByZona(municipio_tramite, colonia_tramite);
					break;
				case "18"://Registro de fosa séptica
					list =tramite_fosasepticaService.listaTramitesByZona(municipio_tramite, colonia_tramite);
					break;
				case "19"://Registro de fosa séptica
					list =tramite_registro_trans_aguas_reciService.listaTramitesByZona(municipio_tramite, colonia_tramite);
					break;
				case "20"://Informe Semestral
					list =tramite_informesemService.listaTramitesByZona(municipio_tramite, colonia_tramite);
					break;
				case "21"://Solicitud de información
					list =tramite_informacionService.listaTramitesByZona(municipio_tramite, colonia_tramite);
					break;
				case "22"://Actualización de transportistas
					list =tramite_actualizacion_tranpsService.listaTramitesByZona(municipio_tramite, colonia_tramite);
					break;
				case "23"://Actualización de situación particular de descarga
					list =tramite_actualizacion_situa_partdesService.listaTramitesByZona(municipio_tramite, colonia_tramite);
					break;
				case "24"://Baja por cambio de domicilio
					list =tramite_baja_cambio_domService.listaTramitesByZona(municipio_tramite, colonia_tramite);
					break;
				case "25"://Modificación de las condiciones particulares de descarga según el parámetro y/o número de descarga.
					list =tramite_modif_condif_part_descService.listaTramitesByZona(municipio_tramite, colonia_tramite);
					break;
				case "26"://Baja por venta de pasivo ambiental
					list =tramite_baja_venta_pasivoService.listaTramitesByZona(municipio_tramite, colonia_tramite);
					break;
				case "27"://Autorización para la disposición final y registro como generador
					list =tramiteautoridispfinaregisgeneService.listaTramitesByZona(municipio_tramite, colonia_tramite);
					break;
				case "28"://Ubicación, operación y manejo integral de escombreras o sitios de disposición final de residuos provenientes de la construcción
					list =tramite_UbiOperMaIntEscSitDisFiResidProConsService.listaTramitesByZona(municipio_tramite, colonia_tramite);
					break;
				case "29"://Ubicación, operación y manejo integral de sitios de disposición final de residuos provenientes de las estaciones de transferencia.
					list =Tramite_UbiOperMaIntSitDisFiProEstTransfService.listaTramitesByZona(municipio_tramite, colonia_tramite);
					break;
				case "30"://Instalación de plantas de tratamiento térmico de residuos
					list =tramite_instaplantratorresidService.listaTramitesByZona(municipio_tramite, colonia_tramite);
					break;
				case "31"://Ubicación, operación y manejo integral de un relleno sanitario, conforme a las Normas Oficiales Mexicanas y demás ordenamientos aplicables.
					list =Tramite_ubiopermaintrellsaniconfnormofimexService.listaTramitesByZona(municipio_tramite, colonia_tramite);
					break;
				case "32":///Transportes de residuos de manejo especial
					list =tramite_transresidmaespeService.listaTramitesByZona(municipio_tramite, colonia_tramite);
					break;
				case "33"://recoleccion de residuos de manejo especial
					list =tramite_recolecresidmarspeService.listaTramitesByZona(municipio_tramite, colonia_tramite);
					break;
				case "34"://Reciclaje de residuos de manejo especial
					list =Tramite_reciclaje_residuos_manejo_especialService.listaTramitesByZona(municipio_tramite, colonia_tramite);
					break;
				case "35"://Operación de los vehículos recolectores de residuos sólidos urbanos cuando presenten el servicio a dos o más municipios
					list =Tramite_operacion_vehi_recolectoresService.listaTramitesByZona(municipio_tramite, colonia_tramite);
					break;
				case "36"://Operación y manejo integral de los establecimientos para la compra y venta de materiales reciclables.
					list =Tramite_operacion_manejo_integral_establecimientosService.listaTramitesByZona(municipio_tramite, colonia_tramite);
					break;
				case "37"://Planes de manejo específicos de residuos de manejo especial
					list =Tramite_planes_manejo_especificosService.listaTramitesByZona(municipio_tramite, colonia_tramite);
					break;
				case "39"://Recepción y Validación de información del COA
					list =Tramite_reception_validacion_informacionService.listaTramitesByZona(municipio_tramite, colonia_tramite);
					break;
				case "40"://Reuso de residuos de manejo especial
					list =Tramite_rehuso_residuos_manejo_especialService.listaTramitesByZona(municipio_tramite, colonia_tramite);
					break;
				case "41"://Operación y manejo integral de los centros de composteo
					list =Tramite_operacion_manejo_integral_centrosService.listaTramitesByZona(municipio_tramite, colonia_tramite);
					break;
				case "42"://Modificación de licencia
					list =tramite_modif_licenciaService.listaTramitesByZona(municipio_tramite, colonia_tramite);
					break;
				case "43"://Otros
					list =tramite_otrosService.listaTramitesByZona(municipio_tramite, colonia_tramite);
					break;
				case "44"://Baja de permisos
					list =tramite_baja_permisosService.listaTramitesByZona(municipio_tramite, colonia_tramite);
					break;
				case "45"://Presentan Informacion Impacto Ambiental
					list =tramite_presentan_info_impactoService.listaTramitesByZona(municipio_tramite, colonia_tramite);
					break;
				case "47"://Presentan Informacion Residuos
					list =tramite_presentan_info_residuosService.listaTramitesByZona(municipio_tramite, colonia_tramite);
					break;
				case "49"://Pedreras	
					list =tramite_pedrerasService.listaTramitesByZona(municipio_tramite, colonia_tramite);
					break;
				case "0"://Operación y manejo integral de los centros de composteo
					list = tramite_licencia_funcionamientoService.listaTramitesByZona(municipio_tramite, colonia_tramite);
					list.addAll(tramite_quema_cielo_abiertoService.listaTramitesByZona(municipio_tramite, colonia_tramite));
					list.addAll(tramite_cambio_razon_socialService.listaTramitesByZona(municipio_tramite, colonia_tramite));
					list.addAll(tramite_cambio_representanteService.listaTramitesByZona(municipio_tramite, colonia_tramite));
					list.addAll(Tramite_cierre_operacionesService.listaTramitesByZona(municipio_tramite, colonia_tramite));	
					list.addAll(tramite_evaluacion_impacto_ambientalService.listaTramitesByZona(municipio_tramite, colonia_tramite));						
					list.addAll(tramite_cambio_titularidadService.listaTramitesByZona(municipio_tramite, colonia_tramite));		
					list.addAll(tramite_solicitud_prorrogaService.listaTramitesByZona(municipio_tramite, colonia_tramite));					
					list.addAll(tramite_solicitud_copiasService.listaTramitesByZona(municipio_tramite, colonia_tramite));	
					list.addAll(tramite_consultasService.listaTramitesByZona(municipio_tramite, colonia_tramite));
					list.addAll(tramite_modificacion_proyectoService.listaTramitesByZona(municipio_tramite, colonia_tramite));					
					list.addAll(descargaaguasrService.listaTramitesByZona(municipio_tramite, colonia_tramite));
					list.addAll(tramite_tratamientoService.listaTramitesByZona(municipio_tramite, colonia_tramite));
					list.addAll(tramite_fosasepticaService.listaTramitesByZona(municipio_tramite, colonia_tramite));
					list.addAll(tramite_registro_trans_aguas_reciService.listaTramitesByZona(municipio_tramite, colonia_tramite));	
					list.addAll(tramite_informesemService.listaTramitesByZona(municipio_tramite, colonia_tramite));	
					list.addAll(tramite_informacionService.listaTramitesByZona(municipio_tramite, colonia_tramite));
					list.addAll(tramite_actualizacion_tranpsService.listaTramitesByZona(municipio_tramite, colonia_tramite));				
					list.addAll(tramite_actualizacion_situa_partdesService.listaTramitesByZona(municipio_tramite, colonia_tramite));
					list.addAll(tramite_baja_cambio_domService.listaTramitesByZona(municipio_tramite, colonia_tramite));
					list.addAll(tramite_modif_condif_part_descService.listaTramitesByZona(municipio_tramite, colonia_tramite));
					list.addAll(tramite_baja_venta_pasivoService.listaTramitesByZona(municipio_tramite, colonia_tramite));
					list.addAll(tramiteautoridispfinaregisgeneService.listaTramitesByZona(municipio_tramite, colonia_tramite));
					list.addAll(tramite_UbiOperMaIntEscSitDisFiResidProConsService.listaTramitesByZona(municipio_tramite, colonia_tramite));
					list.addAll(Tramite_UbiOperMaIntSitDisFiProEstTransfService.listaTramitesByZona(municipio_tramite, colonia_tramite));
					list.addAll(tramite_instaplantratorresidService.listaTramitesByZona(municipio_tramite, colonia_tramite));
					list.addAll(tramite_transresidmaespeService.listaTramitesByZona(municipio_tramite, colonia_tramite));
					list.addAll(tramite_transresidmaespeService.listaTramitesByZona(municipio_tramite, colonia_tramite));
					list.addAll(tramite_recolecresidmarspeService.listaTramitesByZona(municipio_tramite, colonia_tramite));
					list.addAll(Tramite_reciclaje_residuos_manejo_especialService.listaTramitesByZona(municipio_tramite, colonia_tramite));
					list.addAll(Tramite_operacion_vehi_recolectoresService.listaTramitesByZona(municipio_tramite, colonia_tramite));
					list.addAll(Tramite_operacion_manejo_integral_establecimientosService.listaTramitesByZona(municipio_tramite, colonia_tramite));
					list.addAll(Tramite_planes_manejo_especificosService.listaTramitesByZona(municipio_tramite, colonia_tramite));
					list.addAll(Tramite_reception_validacion_informacionService.listaTramitesByZona(municipio_tramite, colonia_tramite));
					list.addAll(Tramite_rehuso_residuos_manejo_especialService.listaTramitesByZona(municipio_tramite, colonia_tramite));
					list.addAll(Tramite_operacion_manejo_integral_centrosService.listaTramitesByZona(municipio_tramite, colonia_tramite));
					list.addAll(tramite_modif_licenciaService.listaTramitesByZona(municipio_tramite, colonia_tramite));
					list.addAll(tramite_otrosService.listaTramitesByZona(municipio_tramite, colonia_tramite));
					list.addAll(tramite_baja_permisosService.listaTramitesByZona(municipio_tramite, colonia_tramite));
					list.addAll(tramite_presentan_info_impactoService.listaTramitesByZona(municipio_tramite, colonia_tramite));
					list.addAll(tramite_presentan_info_residuosService.listaTramitesByZona(municipio_tramite, colonia_tramite));
					list.addAll(tramite_pedrerasService.listaTramitesByZona(municipio_tramite, colonia_tramite));
					break;
					
			default:
				
			break;
				
			}
		
		JsonDataWrapper data = new JsonDataWrapper(1, list.size(), list.size(), list.toArray());
		return data;

	}
	
	 /*
	  * Retorno la lista de las tramites que tenemos en la base de datos de catalogo de denuncias
	  */
	 @RequestMapping(value = "/getArrayColoniasPorMunicipio", method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody List<String> getArrayColoniasPorMunicipio(HttpServletRequest request,HttpServletResponse response) {
		return perfilEstablecimientoService.getColoniasPorMunicipios(request.getParameter("municipio_tramite"));

	}
	 
	 /*
	  * Retorno la lista de las tramites que tenemos en la base de datos de catalogo de denuncias
	  */
	 @RequestMapping(value = "/getArrayCatalogoTramites", method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody List<String> getArrayCatalogoTramites(HttpServletRequest request,HttpServletResponse response) {
		 String rol = request.getParameter("rol");
		 System.out.println("\nrol_usuario \n\t"+rol);
		 List<String> list = new ArrayList<String>();
		 List<CatalogoTramites> listaTramites = cattramitesService.searchList(rol);
		 for(int x=0;x<listaTramites.size();x++){
			 list.add(listaTramites.get(x).getNombreTramite());
		 }
		return list;

	}
	 
	 /*
	  * Retorno la lista de las tramites que tenemos en la base de datos de catalogo de denuncias
	  */
	 @RequestMapping(value = "/getArrayEstablecimientosPorEmpresa", method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody List<CatPerfilEstablecimiento> getArrayEstablecimientosPorEmpresa(HttpServletRequest request,
				HttpServletResponse response) {
		 CatPerfilEstablecimiento establecimiento = new CatPerfilEstablecimiento();
		 establecimiento.setIdcatalogo_perfilempresa(Integer.parseInt(request.getParameter("idempresa")));
		 List<CatPerfilEstablecimiento> list =perfilEstablecimientoService.consultaListByEmpresa(establecimiento);
		return list;

	}
	 
	 /*
	  * 
	  */
	 @RequestMapping(value = { "/getFormTramite" }, method = RequestMethod.GET)
		public ModelAndView getFormTramite(HttpServletRequest request,
				HttpServletResponse response) {
		 	String tramite = request.getParameter("tramite");
		 	System.out.println("Busqueda de tramites");
		 	System.out.println(tramite);
		 	CatalogoTramites dato = new CatalogoTramites();
		 	dato.setNombreTramite(tramite);
		 	CatalogoTramites result = cattramitesService.consultaTramiteByNombreTramite(dato);
		 	System.out.println(result.getNombreTramite());
		 	System.out.println(result.getAreaID());
		 	System.out.println(result.getCatalogoID());
		 	RelacionJspTramite page = relacionjsptramiteService.consultaRelacionJspTramite(result);
		 	System.out.println(page.getUrl_server());
		 	System.out.println(page.getIdrelacion_jsp_tramite());
		 	System.out.println(page.getCatalogo_tramites_catalogoID());
			
			ModelAndView model = new ModelAndView();
			model.setViewName("formularios_tramites/"+page.getUrl_server());
			model.addObject("empresas", perfilEmpresaService.lista());
			model.addObject("catalogoID",page.getCatalogo_tramites_catalogoID());
			model.addObject("areaTramiteID", result.getAreaID());
			model.addObject("UUID", UUID.randomUUID());
			return model;

		}
	 
	 
	 /*
	  * Retorno la lista de las tramites que tenemos en la base de datos de catalogo de denuncias
	  */
	 @RequestMapping(value = "/getEstablecimientosByID", method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody CatPerfilEstablecimiento getEstablecimientosByID(HttpServletRequest request,
				HttpServletResponse response) {
		 CatPerfilEstablecimiento establecimiento = new CatPerfilEstablecimiento();
		 establecimiento.setIdcatalogo_perfilestablecimiento(Integer.parseInt(request.getParameter("idestablecimiento")));
		 CatPerfilEstablecimiento list =perfilEstablecimientoService.consulta(establecimiento);
		return list;

	 }
	 
	 	@RequestMapping(value = "/registerTramite_quema_cielo_abierto", method = RequestMethod.POST, produces = "application/json")
	 	public @ResponseBody MensajeBean registerTramite_quema_cielo_abierto(@ModelAttribute("tramite_quema_cielo_abierto") Tramite_quema_cielo_abierto tramite, BindingResult resul, HttpServletRequest request) {
	 		MensajeBean nuevo = new MensajeBean();
	 			Date date = new Date();
	 			Bitacoras bita =new  Bitacoras();
	 			bita.setEstatus(tramite.getEstatus());
	 			bita.setFecha(dateFormat.format(date));
	 			bita.setHora(hourFormat.format(date));
	 			String auxi = request.getSession().getAttribute("usuario_id").toString();
	 			bita.setIdusuario(Integer.parseInt(auxi));
	 			CatalogoTramites catram = new CatalogoTramites();
	 			catram.setNombreTramite("Quema a cielo abierto");
	 			catram = cattramitesService.consultaTramiteByNombreTramite(catram);
	 			bita.setCatalogoID(catram.getCatalogoID());
	 			bita.setIdempresa(tramite.getCatalogo_perfilempresa_idcatalogo_perfilempresa());
	 			bita.setIdestablecimiento(tramite.getCatalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento());
	 			bita.setIdregistro(String.valueOf(tramite.getIdtramite_quema_cielo_abierto()));
	 			bita.setTipoBitacora("Tramite");
	 			bitacorasService.inserta(bita);
	 			nuevo = tramite_quema_cielo_abiertoService.inserta(tramite);
	 			nuevo.setIdTipoTramite(catram.getCatalogoID());
	 		return nuevo;
	 	}
	 	@RequestMapping(value = "/listacomboTramite_quema_cielo_abierto", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody List <Tramite_quema_cielo_abierto> listacomboTramite_quema_cielo_abierto(@ModelAttribute("tramite_quema_cielo_abierto") Tramite_quema_cielo_abierto nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_quema_cielo_abiertoService.lista(rol);
	 	}
	 	
	 	@RequestMapping(value = "/consultaTramite_quema_cielo_abierto", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody Tramite_quema_cielo_abierto consultaTramite_quema_cielo_abierto(@ModelAttribute("tramite_quema_cielo_abierto") Tramite_quema_cielo_abierto nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_quema_cielo_abiertoService.consulta(nuevo, rol);
	 	}
	 	
	 	@RequestMapping(value = "/registerTramite_licencia_funcionamiento", method = RequestMethod.POST, produces = "application/json")
	 	public @ResponseBody MensajeBean registerTramite_licencia_funcionamiento(@ModelAttribute("tramite_licencia_funcionamiento") Tramite_licencia_funcionamiento tramite, BindingResult resul,HttpServletRequest request) {
	 		MensajeBean nuevo = new MensajeBean();
	 			Date date = new Date();
				Bitacoras bita =new  Bitacoras();
	 			bita.setEstatus(tramite.getEstatus());
	 			bita.setFecha(dateFormat.format(date));
	 			bita.setHora(hourFormat.format(date));
	 			String auxi = request.getSession().getAttribute("usuario_id").toString();
	 			bita.setIdusuario(Integer.parseInt(auxi));
	 			CatalogoTramites catram = new CatalogoTramites();
	 			catram.setNombreTramite("Licencia de funcionamiento");
	 			catram = cattramitesService.consultaTramiteByNombreTramite(catram);
	 			if(catram != null){
	 				bita.setCatalogoID(catram.getCatalogoID());
	 			}
	 			bita.setIdempresa(tramite.getCatalogo_perfilempresa_idcatalogo_perfilempresa());
	 			bita.setIdestablecimiento(tramite.getCatalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento());
	 			bita.setIdregistro(String.valueOf(tramite.getIdtramite_licencia_funcionamiento()));
	 			bita.setTipoBitacora("Tramite");
	 			bitacorasService.inserta(bita);
	 		nuevo = tramite_licencia_funcionamientoService.inserta(tramite);
	 		nuevo.setIdTipoTramite(catram.getCatalogoID());
	 		return nuevo;
	 	}
		@RequestMapping(value = "/listacomboTramite_licencia_funcionamiento", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody List <Tramite_licencia_funcionamiento> listacomboTramite_licencia_funcionamiento(@ModelAttribute("tramite_licencia_funcionamiento") Tramite_licencia_funcionamiento nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_licencia_funcionamientoService.lista(rol);
	 	}
	 	
	 	@RequestMapping(value = "/consultaTramite_licencia_funcionamiento", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody Tramite_licencia_funcionamiento consultaTramite_licencia_funcionamiento(@ModelAttribute("tramite_licencia_funcionamiento") Tramite_licencia_funcionamiento nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_licencia_funcionamientoService.consulta(nuevo, rol);
	 	}


	 	@RequestMapping(value = "/registerTramite_cambio_razon_social", method = RequestMethod.POST, produces = "application/json")
	 	public @ResponseBody MensajeBean registerTramite_cambio_razon_social(@ModelAttribute("tramite_cambio_razon_social") Tramite_cambio_razon_social tramite, BindingResult resul,HttpServletRequest request) {
	 		MensajeBean nuevo = new MensajeBean();
	 			Date date = new Date();
				Bitacoras bita =new  Bitacoras();
	 			bita.setEstatus(tramite.getEstatus());
	 			bita.setFecha(dateFormat.format(date));
	 			bita.setHora(hourFormat.format(date));
	 			String auxi = request.getSession().getAttribute("usuario_id").toString();
	 			bita.setIdusuario(Integer.parseInt(auxi));
	 			CatalogoTramites catram = new CatalogoTramites();
	 			catram.setNombreTramite("Cambio de Razón Social");
	 			catram = cattramitesService.consultaTramiteByNombreTramite(catram);
	 			if(catram != null){
	 				bita.setCatalogoID(catram.getCatalogoID());
	 			}
	 			bita.setIdempresa(tramite.getCatalogo_perfilempresa_idcatalogo_perfilempresa());
	 			bita.setIdestablecimiento(tramite.getCatalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento());
	 			bita.setIdregistro(String.valueOf(tramite.getIdtramite_cambio_razon_social()));
	 			bita.setTipoBitacora("Tramite");
	 			bitacorasService.inserta(bita);
	 			nuevo = tramite_cambio_razon_socialService.inserta(tramite);
	 			nuevo.setIdTipoTramite(catram.getCatalogoID());
	 			return nuevo;
	 	}
		@RequestMapping(value = "/listacomboTramite_cambio_razon_social", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody List <Tramite_cambio_razon_social> listacomboTramite_cambio_razon_social(@ModelAttribute("tramite_cambio_razon_social") Tramite_cambio_razon_social nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_cambio_razon_socialService.lista(rol);
	 	}
	 	
	 	@RequestMapping(value = "/consultaTramite_cambio_razon_social", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody Tramite_cambio_razon_social consultaTramite_cambio_razon_social(@ModelAttribute("tramite_cambio_razon_social") Tramite_cambio_razon_social nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_cambio_razon_socialService.consulta(nuevo, rol);
	 	}

	 	@RequestMapping(value = "/registerTramite_cambio_representante", method = RequestMethod.POST, produces = "application/json")
	 	public @ResponseBody MensajeBean registerTramite_cambio_representante(@ModelAttribute("tramite_cambio_representante") Tramite_cambio_representante tramite, BindingResult resul, HttpServletRequest request) {
	 		MensajeBean nuevo = new MensajeBean();
	 			Date date = new Date();
	 			Bitacoras bita =new  Bitacoras();
	 			bita.setEstatus(tramite.getEstatus());
	 			bita.setFecha(dateFormat.format(date));
	 			bita.setHora(hourFormat.format(date));
	 			String auxi = request.getSession().getAttribute("usuario_id").toString();
	 			bita.setIdusuario(Integer.parseInt(auxi));
	 			CatalogoTramites catram = new CatalogoTramites();
	 			catram.setNombreTramite("Cambio de Representante Legal");
	 			catram = cattramitesService.consultaTramiteByNombreTramite(catram);
	 			bita.setCatalogoID(catram.getCatalogoID());
	 			bita.setIdempresa(tramite.getCatalogo_perfilempresa_idcatalogo_perfilempresa());
	 			bita.setIdestablecimiento(tramite.getCatalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento());
	 			bita.setIdregistro(String.valueOf(tramite.getIdtramite_cambio_representante()));
	 			bita.setTipoBitacora("Tramite");
	 			bitacorasService.inserta(bita);
	 		nuevo = tramite_cambio_representanteService.inserta(tramite);
	 		nuevo.setIdTipoTramite(catram.getCatalogoID());
	 		return nuevo;
	 	}
	 	@RequestMapping(value = "/listacomboTramite_cambio_representante", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody List <Tramite_cambio_representante> listacomboTramite_cambio_representante(@ModelAttribute("tramite_cambio_representante") Tramite_cambio_representante nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_cambio_representanteService.lista(rol);
	 	}
	 	
	 	@RequestMapping(value = "/consultaTramite_cambio_representante", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody Tramite_cambio_representante consultaTramite_cambio_representante(@ModelAttribute("tramite_cambio_representante") Tramite_cambio_representante nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_cambio_representanteService.consulta(nuevo, rol);
	 	}

	 	@RequestMapping(value = "/registerTramite_evaluacion_impacto_ambiental", method = RequestMethod.POST, produces = "application/json")
	 	public @ResponseBody MensajeBean registerTramite_evaluacion_impacto_ambiental(@ModelAttribute("tramite_evaluacion_impacto_ambiental") Tramite_evaluacion_impacto_ambiental tramite, BindingResult resul, HttpServletRequest request) {
	 		MensajeBean nuevo = new MensajeBean();
	 			Date date = new Date();
	 			Bitacoras bita =new  Bitacoras();
	 			bita.setEstatus(tramite.getEstatus());
	 			bita.setFecha(dateFormat.format(date));
	 			bita.setHora(hourFormat.format(date));
	 			String auxi = request.getSession().getAttribute("usuario_id").toString();
	 			bita.setIdusuario(Integer.parseInt(auxi));
	 			CatalogoTramites catram = new CatalogoTramites();
	 			catram.setNombreTramite("Evaluación de Impacto Ambiental");
	 			catram = cattramitesService.consultaTramiteByNombreTramite(catram);
	 			bita.setCatalogoID(catram.getCatalogoID());
	 			bita.setIdempresa(tramite.getCatalogo_perfilempresa_idcatalogo_perfilempresa());
	 			bita.setIdestablecimiento(tramite.getCatalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento());
	 			bita.setIdregistro(String.valueOf(tramite.getIdtramite_evaluacion_impacto_ambiental()));
	 			bita.setTipoBitacora("Tramite");
	 			bitacorasService.inserta(bita);
	 		nuevo = tramite_evaluacion_impacto_ambientalService.inserta(tramite);
	 		nuevo.setIdTipoTramite(catram.getCatalogoID());
	 		return nuevo;
	 	}
	 	@RequestMapping(value = "/listacomboTramite_evaluacion_impacto_ambiental", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody List <Tramite_evaluacion_impacto_ambiental> listacomboTramite_evaluacion_impacto_ambiental(@ModelAttribute("tramite_evaluacion_impacto_ambiental") Tramite_evaluacion_impacto_ambiental nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_evaluacion_impacto_ambientalService.lista(rol);
	 	}
	 	
	 	@RequestMapping(value = "/consultaTramite_evaluacion_impacto_ambiental", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody Tramite_evaluacion_impacto_ambiental consultaTramite_evaluacion_impacto_ambiental(@ModelAttribute("tramite_evaluacion_impacto_ambiental") Tramite_evaluacion_impacto_ambiental nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_evaluacion_impacto_ambientalService.consulta(nuevo, rol);
	 	}

	 	@RequestMapping(value = "/registerTramite_cambio_titularidad", method = RequestMethod.POST, produces = "application/json")
	 	public @ResponseBody MensajeBean registerTramite_cambio_titularidad(@ModelAttribute("tramite_cambio_titularidad") Tramite_cambio_titularidad tramite, BindingResult resul, HttpServletRequest request) {
	 		MensajeBean nuevo = new MensajeBean();
	 			Date date = new Date();
	 			Bitacoras bita =new  Bitacoras();
	 			bita.setEstatus(tramite.getEstatus());
	 			bita.setFecha(dateFormat.format(date));
	 			bita.setHora(hourFormat.format(date));
	 			String auxi = request.getSession().getAttribute("usuario_id").toString();
	 			bita.setIdusuario(Integer.parseInt(auxi));
	 			CatalogoTramites catram = new CatalogoTramites();
	 			catram.setNombreTramite("Cambio de titularidad (Impacto Ambiental)");
	 			catram = cattramitesService.consultaTramiteByNombreTramite(catram);
	 			bita.setCatalogoID(catram.getCatalogoID());
	 			bita.setIdempresa(tramite.getCatalogo_perfilempresa_idcatalogo_perfilempresa());
	 			bita.setIdestablecimiento(tramite.getCatalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento());
	 			bita.setIdregistro(String.valueOf(tramite.getIdtramite_cambio_titularidad()));
	 			bita.setTipoBitacora("Tramite");
	 			bitacorasService.inserta(bita);
	 		nuevo = tramite_cambio_titularidadService.inserta(tramite);
	 		nuevo.setIdTipoTramite(catram.getCatalogoID());
	 		return nuevo;
	 	}
	 	@RequestMapping(value = "/listacomboTramite_cambio_titularidad", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody List <Tramite_cambio_titularidad> listacomboTramite_cambio_titularidad(@ModelAttribute("tramite_cambio_titularidad") Tramite_cambio_titularidad nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_cambio_titularidadService.lista(rol);
	 	}
	 	
	 	@RequestMapping(value = "/consultaTramite_cambio_titularidad", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody Tramite_cambio_titularidad consultaTramite_cambio_titularidad(@ModelAttribute("tramite_cambio_titularidad") Tramite_cambio_titularidad nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_cambio_titularidadService.consulta(nuevo, rol);
	 	}
	 	
	 	@RequestMapping(value = "/registerTramite_solicitud_prorroga", method = RequestMethod.POST, produces = "application/json")
	 	public @ResponseBody MensajeBean registerTramite_solicitud_prorroga(@ModelAttribute("tramite_solicitud_prorroga") Tramite_solicitud_prorroga tramite, BindingResult resul, HttpServletRequest request) {
	 		MensajeBean nuevo = new MensajeBean();
	 			Date date = new Date();
	 			Bitacoras bita =new  Bitacoras();
	 			bita.setEstatus(tramite.getEstatus());
	 			bita.setFecha(dateFormat.format(date));
	 			bita.setHora(hourFormat.format(date));
	 			String auxi = request.getSession().getAttribute("usuario_id").toString();
	 			bita.setIdusuario(Integer.parseInt(auxi));
	 			CatalogoTramites catram = new CatalogoTramites();
	 			catram.setNombreTramite("Solicitud de prorrogas");
	 			catram = cattramitesService.consultaTramiteByNombreTramite(catram);
	 			bita.setCatalogoID(catram.getCatalogoID());
	 			bita.setIdempresa(tramite.getCatalogo_perfilempresa_idcatalogo_perfilempresa());
	 			bita.setIdestablecimiento(tramite.getCatalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento());
	 			bita.setIdregistro(String.valueOf(tramite.getIdtramite_solicitud_prorroga()));
	 			bita.setTipoBitacora("Tramite");
	 			bitacorasService.inserta(bita);
	 		nuevo = tramite_solicitud_prorrogaService.inserta(tramite);
	 		nuevo.setIdTipoTramite(catram.getCatalogoID());
	 		return nuevo;
	 	}
	 	@RequestMapping(value = "/listacomboTramite_solicitud_prorroga", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody List <Tramite_solicitud_prorroga> listacomboTramite_solicitud_prorroga(@ModelAttribute("tramite_solicitud_prorroga") Tramite_solicitud_prorroga nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_solicitud_prorrogaService.lista(rol);
	 	}
	 	
	 	@RequestMapping(value = "/consultaTramite_solicitud_prorroga", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody Tramite_solicitud_prorroga consultaTramite_solicitud_prorroga(@ModelAttribute("tramite_solicitud_prorroga") Tramite_solicitud_prorroga nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_solicitud_prorrogaService.consulta(nuevo, rol);
	 	}

	 	@RequestMapping(value = "/registerTramite_solicitud_copias", method = RequestMethod.POST, produces = "application/json")
	 	public @ResponseBody MensajeBean registerTramite_solicitud_copias(@ModelAttribute("tramite_solicitud_copias") Tramite_solicitud_copias tramite, BindingResult resul, HttpServletRequest request) {
	 		MensajeBean nuevo = new MensajeBean();
	 			Date date = new Date();
	 			Bitacoras bita =new  Bitacoras();
	 			bita.setEstatus(tramite.getEstatus());
	 			bita.setFecha(dateFormat.format(date));
	 			bita.setHora(hourFormat.format(date));
	 			String auxi = request.getSession().getAttribute("usuario_id").toString();
	 			bita.setIdusuario(Integer.parseInt(auxi));
	 			CatalogoTramites catram = new CatalogoTramites();
	 			catram.setNombreTramite("Solicitud de Copias");
	 			catram = cattramitesService.consultaTramiteByNombreTramite(catram);
	 			bita.setCatalogoID(catram.getCatalogoID());
	 			bita.setIdempresa(tramite.getCatalogo_perfilempresa_idcatalogo_perfilempresa());
	 			bita.setIdestablecimiento(tramite.getCatalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento());
	 			bita.setIdregistro(String.valueOf(tramite.getIdtramite_solicitud_copias()));
	 			bita.setTipoBitacora("Tramite");
	 			bitacorasService.inserta(bita);
	 		nuevo = tramite_solicitud_copiasService.inserta(tramite);
	 		nuevo.setIdTipoTramite(catram.getCatalogoID());
	 		return nuevo;
	 	}
	 	@RequestMapping(value = "/listacomboTramite_solicitud_copias", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody List <Tramite_solicitud_copias> listacomboTramite_solicitud_prorroga(@ModelAttribute("tramite_solicitud_copias") Tramite_solicitud_copias nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_solicitud_copiasService.lista(rol);
	 	}
	 	
	 	@RequestMapping(value = "/consultaTramite_solicitud_copias", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody Tramite_solicitud_copias consultaTramite_solicitud_prorroga(@ModelAttribute("tramite_solicitud_copias") Tramite_solicitud_copias nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_solicitud_copiasService.consulta(nuevo, rol);
	 	}
	 	
	 	@RequestMapping(value = "/registerTramite_consultas", method = RequestMethod.POST, produces = "application/json")
	 	public @ResponseBody MensajeBean registerTramite_consultas(@ModelAttribute("tramite_consultas") Tramite_consultas tramite, BindingResult resul, HttpServletRequest request) {
	 		MensajeBean nuevo = new MensajeBean();
	 			Date date = new Date();
	 			Bitacoras bita =new  Bitacoras();
	 			bita.setEstatus(tramite.getEstatus());
	 			bita.setFecha(dateFormat.format(date));
	 			bita.setHora(hourFormat.format(date));
	 			String auxi = request.getSession().getAttribute("usuario_id").toString();
	 			bita.setIdusuario(Integer.parseInt(auxi));
	 			CatalogoTramites catram = new CatalogoTramites();
	 			catram.setNombreTramite("Consultas");
	 			catram = cattramitesService.consultaTramiteByNombreTramite(catram);
	 			bita.setCatalogoID(catram.getCatalogoID());
	 			bita.setIdempresa(tramite.getCatalogo_perfilempresa_idcatalogo_perfilempresa());
	 			bita.setIdestablecimiento(tramite.getCatalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento());
	 			bita.setIdregistro(String.valueOf(tramite.getIdtramite_consultas()));
	 			bita.setTipoBitacora("Tramite");
	 			bitacorasService.inserta(bita);
	 		nuevo = tramite_consultasService.inserta(tramite);
	 		nuevo.setIdTipoTramite(catram.getCatalogoID());
	 		return nuevo;
	 	}
	 	@RequestMapping(value = "/listacomboTramite_consultas", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody List <Tramite_consultas> listacomboTramite_consultas(@ModelAttribute("tramite_consultas") Tramite_consultas nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_consultasService.lista(rol);
	 	}
	 	
	 	@RequestMapping(value = "/consultaTramite_consultas", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody Tramite_consultas consultaTramite_consultas(@ModelAttribute("tramite_consultas") Tramite_consultas nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_consultasService.consulta(nuevo, rol);
	 	}
	 	

	 	@RequestMapping(value = "/registerTramite_modificacion_proyecto", method = RequestMethod.POST, produces = "application/json")
	 	public @ResponseBody MensajeBean registerTramite_modificacion_proyecto(@ModelAttribute("tramite_modificacion_proyecto") Tramite_modificacion_proyecto tramite, BindingResult resul, HttpServletRequest request) {
	 		MensajeBean nuevo = new MensajeBean();
	 			Date date = new Date();
	 			Bitacoras bita =new  Bitacoras();
	 			bita.setEstatus(tramite.getEstatus());
	 			bita.setFecha(dateFormat.format(date));
	 			bita.setHora(hourFormat.format(date));
	 			String auxi = request.getSession().getAttribute("usuario_id").toString();
	 			bita.setIdusuario(Integer.parseInt(auxi));
	 			CatalogoTramites catram = new CatalogoTramites();
	 			catram.setNombreTramite("Modificación de proyectos");
	 			catram = cattramitesService.consultaTramiteByNombreTramite(catram);
	 			bita.setCatalogoID(catram.getCatalogoID());
	 			bita.setIdempresa(tramite.getCatalogo_perfilempresa_idcatalogo_perfilempresa());
	 			bita.setIdestablecimiento(tramite.getCatalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento());
	 			bita.setIdregistro(String.valueOf(tramite.getIdtramite_modificacion_proyecto()));
	 			bita.setTipoBitacora("Tramite");
	 			bitacorasService.inserta(bita);
	 		nuevo = tramite_modificacion_proyectoService.inserta(tramite);
	 		nuevo.setIdTipoTramite(catram.getCatalogoID());
	 		return nuevo;
	 	}
	 	@RequestMapping(value = "/listacomboTramite_modificacion_proyecto", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody List <Tramite_modificacion_proyecto> listacomboTramite_consultas(@ModelAttribute("tramite_modificacion_proyecto") Tramite_modificacion_proyecto nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_modificacion_proyectoService.lista(rol);
	 	}
	 	
	 	@RequestMapping(value = "/consultaTramite_modificacion_proyecto", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody Tramite_modificacion_proyecto consultaTramite_consultas(@ModelAttribute("tramite_modificacion_proyecto") Tramite_modificacion_proyecto nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_modificacion_proyectoService.consulta(nuevo, rol);
	 	}
	 	
	 	@RequestMapping(value = "/registerTramite_registro_de_prestadores_de_servicios", method = RequestMethod.POST, produces = "application/json")
	 	public @ResponseBody MensajeBean registerTramite_registro_de_prestadores_de_servicios(@ModelAttribute("tramite_registro_prestadores_servicios") Tramite_registro_prestadores_servicios nuevo, BindingResult resul,HttpServletRequest request) {
	 			MensajeBean msn = new MensajeBean();
	 			Date date = new Date();
	 			Bitacoras bita =new  Bitacoras();
	 			bita.setEstatus(nuevo.getEstatus());
	 			bita.setFecha(dateFormat.format(date));
	 			bita.setHora(hourFormat.format(date));
	 			String auxi = request.getSession().getAttribute("usuario_id").toString();
	 			bita.setIdusuario(Integer.parseInt(auxi));
	 			CatalogoTramites catram = new CatalogoTramites();
	 			catram.setNombreTramite("Registro de prestadores de servicios");
	 			catram = cattramitesService.consultaTramiteByNombreTramite(catram);
	 			bita.setCatalogoID(catram.getCatalogoID());
	 			bita.setIdempresa(0);
	 			bita.setIdestablecimiento(0);
	 			bita.setIdregistro(String.valueOf(nuevo.getIdtramite_registro_prestador_servicio()));
	 			bita.setTipoBitacora("Tramite");
	 			bitacorasService.inserta(bita);
	 			msn = tramite_registro_prestadores_serviciosService.inserta(nuevo);
	 			msn.setIdTipoTramite(catram.getCatalogoID());
	 		return msn;
	 	}
	 	@RequestMapping(value = "/consultaTramite_registro_de_prestadores_de_servicios", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody Tramite_registro_prestadores_servicios consultaTramite_registro_de_prestadores_de_servicios(@ModelAttribute("tramite_registro_prestadores_servicios") Tramite_registro_prestadores_servicios nuevo, BindingResult resul,HttpServletRequest request) {
	 		return tramite_registro_prestadores_serviciosService.consulta(nuevo,"rol");
	 	}
	 	@RequestMapping(value = "/listaTramite_registro_de_prestadores_de_servicios", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody List <Tramite_registro_prestadores_servicios> listaTramite_registro_de_prestadores_de_servicios(@ModelAttribute("tramite_registro_prestadores_servicios") Tramite_registro_prestadores_servicios nuevo, BindingResult resul,HttpServletRequest request) {
	 		String rol = request.getParameter("rol_usuario");
	 		return tramite_registro_prestadores_serviciosService.lista(rol);
	 	}
	 	
	 	@RequestMapping(value = "/registerTramite_baja_por_venta_de_pasivo_ambiental", method = RequestMethod.POST, produces = "application/json")
	 	public @ResponseBody MensajeBean registerTramite_baja_por_venta_de_pasivo_ambiental() {
	 		MensajeBean nuevo = new MensajeBean();
	 		return nuevo;
	 	}   
	 	
	 	@RequestMapping(value = "/registerTramite_baja_por_cambio_de_domicilio", method = RequestMethod.POST, produces = "application/json")
	 	public @ResponseBody MensajeBean registerTramite_baja_por_cambio_de_domicilio() {
	 		MensajeBean nuevo = new MensajeBean();
	 		return nuevo;
	 	}   
	 	
	 	@RequestMapping(value = "/registerTramite_actualizacion_de_transportistas", method = RequestMethod.POST, produces = "application/json")
	 	public @ResponseBody MensajeBean registerTramite_actualizacion_de_transportistas() {
	 		MensajeBean nuevo = new MensajeBean();
	 		return nuevo;
	 	}  
	 	
	 	
	 	@RequestMapping(value = "/registerTramite_registro_de_transportistas_de_aguas_residuales", method = RequestMethod.POST, produces = "application/json")
	 	public @ResponseBody MensajeBean registerTramite_registro_de_transportistas_de_aguas_residuales(@ModelAttribute("tramite_registro_trans_aguas_reci") Tramite_registro_trans_aguas_reci tramite, BindingResult resul, HttpServletRequest request) {
	 		MensajeBean nuevo = new MensajeBean();
	 			Date date = new Date();
	 			Bitacoras bita =new  Bitacoras();
	 			bita.setEstatus(tramite.getEstatus());
	 			bita.setFecha(dateFormat.format(date));
	 			bita.setHora(hourFormat.format(date));
	 			String auxi = request.getSession().getAttribute("usuario_id").toString();
	 			bita.setIdusuario(Integer.parseInt(auxi));
	 			CatalogoTramites catram = new CatalogoTramites();
	 			catram.setNombreTramite("Registro de transportistas de Aguas residuales");
	 			catram = cattramitesService.consultaTramiteByNombreTramite(catram);
	 			bita.setCatalogoID(catram.getCatalogoID());
	 			bita.setIdempresa(tramite.getCatalogo_perfilempresa_idcatalogo_perfilempresa());
	 			bita.setIdestablecimiento(tramite.getCatalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento());
	 			bita.setIdregistro(String.valueOf(tramite.getIdtramite_registro_trans_aguas_reci()));
	 			bita.setTipoBitacora("Tramite");
	 			bitacorasService.inserta(bita);
	 		nuevo = this.tramite_registro_trans_aguas_reciService.inserta(tramite);
	 		nuevo.setIdTipoTramite(catram.getCatalogoID());
	 		return nuevo;
	 	}
	 	@RequestMapping(value = "/listacomboTramite_registro_de_transportistas_de_aguas_residuales", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody List <Tramite_registro_trans_aguas_reci> listacomboTramite_registro_de_transportistas_de_aguas_residuales
	 							(@ModelAttribute("tramite_registro_trans_aguas_reci") Tramite_registro_trans_aguas_reci nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_registro_trans_aguas_reciService.lista(rol);
	 	}
	 	
	 	@RequestMapping(value = "/consultaTramite_registro_de_transportistas_de_aguas_residuales", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody Tramite_registro_trans_aguas_reci consultaTramite_registro_de_transportistas_de_aguas_residuales(@ModelAttribute("tramite_registro_trans_aguas_reci") Tramite_registro_trans_aguas_reci nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_registro_trans_aguas_reciService.consulta(nuevo, rol);
	 	}
	 	
	 	@RequestMapping(value = "/registerTramite_informe_Semestral", method = RequestMethod.POST, produces = "application/json")
	 	public @ResponseBody MensajeBean registerTramite_informe_Semestral(@ModelAttribute("tramite_informesem") Tramite_informesem nuevo, BindingResult resul, HttpServletRequest request) {
	 		MensajeBean msj = new MensajeBean();
	 		
	 			Date date = new Date();
	 			Bitacoras bita =new  Bitacoras();
	 			bita.setEstatus(nuevo.getEstatus());
	 			bita.setFecha(dateFormat.format(date));
	 			bita.setHora(hourFormat.format(date));
	 			String auxi = request.getSession().getAttribute("usuario_id").toString();
	 			bita.setIdusuario(Integer.parseInt(auxi));
	 			CatalogoTramites catram = new CatalogoTramites();
	 			catram.setNombreTramite("Informe Semestral");
	 			catram = cattramitesService.consultaTramiteByNombreTramite(catram);
	 			bita.setCatalogoID(catram.getCatalogoID());
	 			bita.setIdempresa(nuevo.getIdempresa());
	 			bita.setIdestablecimiento(nuevo.getIdestablecimiento());
	 			bita.setIdregistro(String.valueOf(nuevo.getIdtramite_informesem()));
	 			bita.setTipoBitacora("Tramite");
	 			bitacorasService.inserta(bita);
	 			System.out.println("Catalogo ID " + catram.getCatalogoID());
	 			msj.setIdTipoTramite(catram.getCatalogoID());
	 			msj = tramite_informesemService.inserta(nuevo);
	 			msj.setIdTipoTramite(20);
	 		return msj;
	 	}
	 	
	 	@RequestMapping(value = "/listacomboTramite_informe_Semestral", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody List <Tramite_informesem> listacomboTramite_informe_Semestral(@ModelAttribute("tramite_informesem") Tramite_informesem nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_informesemService.lista(rol);
	 	}
	 	
	 	@RequestMapping(value = "/consultaTramite_informe_Semestral", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody Tramite_informesem consultaTramite_informe_Semestral(@ModelAttribute("tramite_informesem") Tramite_informesem nuevo, BindingResult resul,HttpServletRequest request) {
			return tramite_informesemService.consulta(nuevo);
	 	}	 	
	 	
	 	
	 	@RequestMapping(value = "/registerTramite_registro_de_planta_de_tratamiento_de_aguas_residuales", method = RequestMethod.POST, produces = "application/json")
	 	public @ResponseBody MensajeBean registerTramite_registro_de_planta_de_tratamiento_de_aguas_residuales(@ModelAttribute("tramite_tratamiento_aguasr") Tramite_tratamiento_aguasr tramite, BindingResult resul, HttpServletRequest request) {
	 		MensajeBean nuevo = new MensajeBean();
	 		
	 			Date date = new Date();
	 			Bitacoras bita =new  Bitacoras();
	 			bita.setEstatus(tramite.getEstatus());
	 			bita.setFecha(dateFormat.format(date));
	 			bita.setHora(hourFormat.format(date));
	 			String auxi = request.getSession().getAttribute("usuario_id").toString();
	 			bita.setIdusuario(Integer.parseInt(auxi));
	 			CatalogoTramites catram = new CatalogoTramites();
	 			catram.setNombreTramite("Registro de planta de tratamiento de aguas residuales");
	 			catram = cattramitesService.consultaTramiteByNombreTramite(catram);
	 			bita.setCatalogoID(catram.getCatalogoID());
	 			bita.setIdempresa(tramite.getIdempresa());
	 			bita.setIdestablecimiento(tramite.getIdestablecimiento());
	 			bita.setIdregistro(String.valueOf(tramite.getIdtramite_tratamiento()));
	 			bita.setTipoBitacora("Tramite");
	 			bitacorasService.inserta(bita);
	 		
	 		nuevo = tramite_tratamientoService.inserta(tramite);
	 		nuevo.setIdTipoTramite(catram.getCatalogoID());
	 		return nuevo;
	 	}
	 	@RequestMapping(value = "/listacomboTramite_registro_de_planta_de_tratamiento_de_aguas_residuales", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody List <Tramite_tratamiento_aguasr> listacomboTramite_registro_de_planta_de_tratamiento_de_aguas_residuales(@ModelAttribute("tramite_tratamiento_aguasr") Tramite_tratamiento_aguasr nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_tratamientoService.lista(rol);
	 	}
	 	
	 	@RequestMapping(value = "/consultaTramite_registro_de_planta_de_tratamiento_de_aguas_residuales", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody Tramite_tratamiento_aguasr consultaTramite_registro_de_planta_de_tratamiento_de_aguas_residuales(@ModelAttribute("tramite_tratamiento_aguasr") Tramite_tratamiento_aguasr nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_tratamientoService.consulta(nuevo, rol);
	 	}
	 	
	 	@RequestMapping(value = "/registerTramite_fosa_septica", method = RequestMethod.POST, produces = "application/json")
	 	public @ResponseBody MensajeBean registerTramite_fosa_septica(@ModelAttribute("tramite_fosa_septica") Tramite_fosa_septica tramite, BindingResult resul, HttpServletRequest request) {
	 		MensajeBean nuevo = new MensajeBean();
	 			Date date = new Date();
	 			Bitacoras bita =new  Bitacoras();
	 			bita.setEstatus(tramite.getEstatus());
	 			bita.setFecha(dateFormat.format(date));
	 			bita.setHora(hourFormat.format(date));
	 			String auxi = request.getSession().getAttribute("usuario_id").toString();
	 			bita.setIdusuario(Integer.parseInt(auxi));
	 			CatalogoTramites catram = new CatalogoTramites();
	 			catram.setNombreTramite("Registro de fosa séptica");
	 			catram = cattramitesService.consultaTramiteByNombreTramite(catram);
	 			bita.setCatalogoID(catram.getCatalogoID());
	 			bita.setIdempresa(tramite.getIdempresa());
	 			bita.setIdestablecimiento(tramite.getIdestablecimiento());
	 			bita.setIdregistro(String.valueOf(tramite.getIdtramite_fosaseptica()));
	 			bita.setTipoBitacora("Tramite");
	 			bitacorasService.inserta(bita);
	 		nuevo = tramite_fosasepticaService.inserta(tramite);
	 		nuevo.setIdTipoTramite(catram.getCatalogoID());
	 		return nuevo;
	 	}
	 	@RequestMapping(value = "/listacomboTramite_fosa_septica", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody List <Tramite_fosa_septica> listacomboTramite_fosa_septica(@ModelAttribute("tramite_fosa_septica") Tramite_fosa_septica nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_fosasepticaService.lista(rol);
	 	}
	 	
	 	@RequestMapping(value = "/consultaTramite_fosa_septica", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody Tramite_fosa_septica consultaTramite_fosa_septica(@ModelAttribute("tramite_fosa_septica") Tramite_fosa_septica nuevo, BindingResult resul,HttpServletRequest request) {
			return tramite_fosasepticaService.consulta(nuevo);
	 	}
//	 	@RequestMapping(value = "/registerTramite_solicitud_de_informacion", method = RequestMethod.GET, produces = "application/json")
//	 	public @ResponseBody MensajeBean registerTramite_solicitud_de_informacion(@ModelAttribute("Tramite_fosa_septica") Descargaaguasr nuevo, BindingResult resul) {
//	 		MensajeBean msj = new MensajeBean();
//	 		return msj;
//	 	}  
//
//	 	@RequestMapping(value = "/registerTramite_registro_de_fosa_septica", method = RequestMethod.GET, produces = "application/json")
//	 	public @ResponseBody MensajeBean registerTramite_registro_de_fosa_septica() {
//	 		MensajeBean nuevo = new MensajeBean();
//	 		return nuevo;
//	 	}  
	 	
	 	@RequestMapping(value = "/registerTramite_registro_Aguas_Residuales", method = RequestMethod.POST, produces = "application/json")
	 	public @ResponseBody MensajeBean registerTramite_registro_Aguas_Residuales(@ModelAttribute("descargaaguasr") Descargaaguasr nuevo, BindingResult resul, HttpServletRequest request) {
	 			MensajeBean msj = new MensajeBean();
	 			Date date = new Date();
	 			Bitacoras bita =new  Bitacoras();
	 			bita.setEstatus(nuevo.getEstatus());
	 			bita.setFecha(dateFormat.format(date));
	 			bita.setHora(hourFormat.format(date));
	 			String auxi = request.getSession().getAttribute("usuario_id").toString();
	 			bita.setIdusuario(Integer.parseInt(auxi));
	 			CatalogoTramites catram = new CatalogoTramites();
	 			catram.setNombreTramite("Registro de aguas residuales");
	 			catram = cattramitesService.consultaTramiteByNombreTramite(catram);
	 			bita.setCatalogoID(catram.getCatalogoID());
	 			bita.setIdempresa(nuevo.getIdempresa());
	 			bita.setIdestablecimiento(nuevo.getIdestablecimiento());
	 			bita.setIdregistro(String.valueOf(nuevo.getIdtramite()));
	 			bita.setTipoBitacora("Tramite");
	 			bitacorasService.inserta(bita);
	 			msj = descargaaguasrService.inserta(nuevo);
	 			msj.setIdTipoTramite(catram.getCatalogoID());
	 		return msj;
	 	}
	 	@RequestMapping(value = "/listacomboTramite_registro_Aguas_Residuales", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody List <Descargaaguasr> listacomboTramite_registro_Aguas_Residuales(@ModelAttribute("descargaaguasr") Descargaaguasr nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return descargaaguasrService.lista(rol);
	 	}
	 	
	 	@RequestMapping(value = "/consultaTramite_registro_Aguas_Residuales", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody Descargaaguasr consultaTramite_registro_Aguas_Residuales(@ModelAttribute("descargaaguasr") Descargaaguasr nuevo, BindingResult resul,HttpServletRequest request) {
			return descargaaguasrService.consulta(nuevo);
	 	}
		
	 	
		@RequestMapping(value = "/registerTramite_actualizacion_situacion_particular_descarga", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody MensajeBean registerTramite_actualizacion_situacion_particular_descarga(@ModelAttribute("tramite_actualizacion_situa_partdes") Tramite_actualizacion_situa_partdes tramite, BindingResult resul, HttpServletRequest request) {
	 		MensajeBean nuevo = new MensajeBean();
	 		
	 			Date date = new Date();
	 			Bitacoras bita =new  Bitacoras();
	 			bita.setEstatus(tramite.getEstatus());
	 			bita.setFecha(dateFormat.format(date));
	 			bita.setHora(hourFormat.format(date));
	 			String auxi = request.getSession().getAttribute("usuario_id").toString();
	 			bita.setIdusuario(Integer.parseInt(auxi));
	 			CatalogoTramites catram = new CatalogoTramites();
	 			catram.setNombreTramite("Actualización de situación particular de descarga");
	 			catram = cattramitesService.consultaTramiteByNombreTramite(catram);
	 			bita.setCatalogoID(catram.getCatalogoID());
	 			bita.setIdempresa(tramite.getIdempresa());
	 			bita.setIdestablecimiento(tramite.getIdestablecimiento());
	 			bita.setIdregistro(String.valueOf(tramite.getIdtramite()));
	 			bita.setTipoBitacora("Tramite");
	 			bitacorasService.inserta(bita);
	 		
	 		nuevo = tramite_actualizacion_situa_partdesService.inserta(tramite);
	 		nuevo.setIdTipoTramite(catram.getCatalogoID());
	 		return nuevo;
	 	}
	 	@RequestMapping(value = "/listacomboTramite_actualizacion_situacion_particular_descarga", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody List <Tramite_actualizacion_situa_partdes> listacomboTramite_actualizacion_situacion_particular_descarga(@ModelAttribute("tramite_actualizacion_situa_partdes") Tramite_actualizacion_situa_partdes nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_actualizacion_situa_partdesService.lista(rol);
	 	}
	 	
	 	@RequestMapping(value = "/consultaTramite_actualizacion_situacion_particular_descarga", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody Tramite_actualizacion_situa_partdes consultaTramite_actualizacion_situacion_particular_descarga(@ModelAttribute("tramite_actualizacion_situa_partdes") Tramite_actualizacion_situa_partdes nuevo, BindingResult resul,HttpServletRequest request) {
			return tramite_actualizacion_situa_partdesService.consulta(nuevo,"");
	 	}
		
		
		
		
		@RequestMapping(value = "/registertramiteAutoriDispFinaRegisGene", method = RequestMethod.POST, produces = "application/json")
	 	public @ResponseBody MensajeBean registertramiteAutoriDispFinaRegisGene(@ModelAttribute("tramiteAutoriDispFinaRegisGene") TramiteAutoriDispFinaRegisGene nuevo, BindingResult resul,HttpServletRequest request) {
				MensajeBean bean = new MensajeBean();
				Date date = new Date();
	 			Bitacoras bita =new  Bitacoras();
	 			bita.setEstatus(nuevo.getEstatus());
	 			bita.setFecha(dateFormat.format(date));
	 			bita.setHora(hourFormat.format(date));
	 			String auxi = request.getSession().getAttribute("usuario_id").toString();
	 			bita.setIdusuario(Integer.parseInt(auxi));
	 			CatalogoTramites catram = new CatalogoTramites();
	 			catram.setNombreTramite("Autorización para la disposición final y registro como generador");
	 			catram = cattramitesService.consultaTramiteByNombreTramite(catram);
	 			bita.setCatalogoID(catram.getCatalogoID());
	 			bita.setIdempresa(nuevo.getIdempresa());
	 			bita.setIdestablecimiento(nuevo.getIdestablecimiento());
	 			bita.setIdregistro(String.valueOf(nuevo.getIdtramite()));
	 			bita.setTipoBitacora("Tramite");
	 			bitacorasService.inserta(bita);
	 			bean = tramiteautoridispfinaregisgeneService.inserta(nuevo);
	 			bean.setIdTipoTramite(catram.getCatalogoID());
			return bean;
	 	}
		@RequestMapping(value = "/listacombotramiteAutoriDispFinaRegisGene", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody List <TramiteAutoriDispFinaRegisGene> listacombotramiteAutoriDispFinaRegisGene(@ModelAttribute("tramiteAutoriDispFinaRegisGene") TramiteAutoriDispFinaRegisGene nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramiteautoridispfinaregisgeneService.lista(rol);
	 	}
	 	@RequestMapping(value = "/consultatramiteAutoriDispFinaRegisGene", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody TramiteAutoriDispFinaRegisGene consultatramiteAutoriDispFinaRegisGene(@ModelAttribute("tramiteAutoriDispFinaRegisGene") TramiteAutoriDispFinaRegisGene nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramiteautoridispfinaregisgeneService.consulta(nuevo, rol);
	 	}
		
		@RequestMapping(value = "/registertramite_UbiOperMaIntEscSitDisFiResidProCons", method = RequestMethod.POST, produces = "application/json")
	 	public @ResponseBody MensajeBean registertramite_UbiOperMaIntEscSitDisFiResidProCons(@ModelAttribute("tramite_UbiOperMaIntEscSitDisFiResidProCons") Tramite_UbiOperMaIntEscSitDisFiResidProCons nuevo, BindingResult resul,HttpServletRequest request) {
				MensajeBean msj = new MensajeBean();
				Date date = new Date();
	 			Bitacoras bita =new  Bitacoras();
	 			bita.setEstatus(nuevo.getEstatus());
	 			bita.setFecha(dateFormat.format(date));
	 			bita.setHora(hourFormat.format(date));
	 			String auxi = request.getSession().getAttribute("usuario_id").toString();
	 			bita.setIdusuario(Integer.parseInt(auxi));
	 			CatalogoTramites catram = new CatalogoTramites();
	 			catram.setNombreTramite("Ubicación, operación y manejo integral de escombreras o sitios de disposición final de residuos provenientes de la construcción");
	 			catram = cattramitesService.consultaTramiteByNombreTramite(catram);
	 			bita.setCatalogoID(catram.getCatalogoID());
	 			bita.setIdempresa(nuevo.getIdempresa());
	 			bita.setIdestablecimiento(nuevo.getIdestablecimiento());
	 			bita.setIdregistro(String.valueOf(nuevo.getIdtramite()));
	 			bita.setTipoBitacora("Tramite");
	 			bitacorasService.inserta(bita);
	 			msj =  tramite_UbiOperMaIntEscSitDisFiResidProConsService.inserta(nuevo);
	 			msj.setIdTipoTramite(catram.getCatalogoID());
			return msj;
	 	}
		@RequestMapping(value = "/listacombotramite_UbiOperMaIntEscSitDisFiResidProCons", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody List <Tramite_UbiOperMaIntEscSitDisFiResidProCons> listacombotramite_UbiOperMaIntEscSitDisFiResidProCons(@ModelAttribute("tramite_UbiOperMaIntEscSitDisFiResidProCons") Tramite_UbiOperMaIntEscSitDisFiResidProCons nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_UbiOperMaIntEscSitDisFiResidProConsService.lista(rol);
	 	}
	 	
	 	@RequestMapping(value = "/consultatramite_UbiOperMaIntEscSitDisFiResidProCons", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody Tramite_UbiOperMaIntEscSitDisFiResidProCons consultatramite_UbiOperMaIntEscSitDisFiResidProCons(@ModelAttribute("tramite_UbiOperMaIntEscSitDisFiResidProCons") Tramite_UbiOperMaIntEscSitDisFiResidProCons nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_UbiOperMaIntEscSitDisFiResidProConsService.consulta(nuevo, rol);
	 	}
		
		
		
		/*
		@RequestMapping(value = "/registertramite_UbiOperMaIntSitDisFiProEstTransf", method = RequestMethod.POST, produces = "application/json")
	 	public @ResponseBody MensajeBean registertramite_UbiOperMaIntSitDisFiProEstTransf(@ModelAttribute("tramite_UbiOperMaIntSitDisFiProEstTransf") Tramite_UbiOperMaIntSitDisFiProEstTransf nuevo, BindingResult resul,HttpServletRequest request) {
				MensajeBean bean = new MensajeBean();
				Date date = new Date();
	 			Bitacoras bita =new  Bitacoras();
	 			bita.setEstatus(nuevo.getEstatus());
	 			bita.setFecha(dateFormat.format(date));
	 			bita.setHora(hourFormat.format(date));
	 			String auxi = request.getSession().getAttribute("usuario_id").toString();
	 			bita.setIdusuario(Integer.parseInt(auxi));
	 			CatalogoTramites catram = new CatalogoTramites();
	 			catram.setNombreTramite("Ubicación, operación y manejo integral de sitios de disposición final de residuos provenientes de las estaciones de transferencia.");
	 			catram = cattramitesService.consultaTramiteByNombreTramite(catram);
	 			bita.setCatalogoID(catram.getCatalogoID());
	 			bita.setIdempresa(nuevo.getIdempresa());
	 			bita.setIdestablecimiento(nuevo.getIdestablecimiento());
	 			bita.setIdregistro(String.valueOf(nuevo.getIdtramite()));
	 			bita.setTipoBitacora("Tramite");
	 			bitacorasService.inserta(bita);
	 			bean = tramite_UbiOperMaIntSitDisFiProEstTransfService.inserta(nuevo);
	 			bean.setIdTipoTramite(idTipoTramite);
			return bean;
	 	}
	*/	
		/**
		 * tramite_instaplantratorresid
		 * @param nuevo
		 * @param resul
		 * @return
		 */
		@RequestMapping(value = "/registertramite_instaplantratorresid", method = RequestMethod.POST, produces = "application/json")
	 	public @ResponseBody MensajeBean registertramite_instaplantratorresid(@ModelAttribute("tramite_InstaPlanTraTorResid") Tramite_InstaPlanTraTorResid nuevo, BindingResult resul,HttpServletRequest request) {
				MensajeBean msj = new MensajeBean();
				Date date = new Date();
	 			Bitacoras bita =new  Bitacoras();
	 			bita.setEstatus(nuevo.getEstatus());
	 			bita.setFecha(dateFormat.format(date));
	 			bita.setHora(hourFormat.format(date));
	 			String auxi = request.getSession().getAttribute("usuario_id").toString();
	 			bita.setIdusuario(Integer.parseInt(auxi));
	 			CatalogoTramites catram = new CatalogoTramites();
	 			catram.setNombreTramite("Instalación de plantas de tratamiento térmico de residuos");
	 			catram = cattramitesService.consultaTramiteByNombreTramite(catram);
	 			bita.setCatalogoID(catram.getCatalogoID());
	 			bita.setIdempresa(nuevo.getIdempresa());
	 			bita.setIdestablecimiento(nuevo.getIdestablecimiento());
	 			bita.setIdregistro(String.valueOf(nuevo.getIdtramite()));
	 			bita.setTipoBitacora("Tramite");
	 			bitacorasService.inserta(bita);
	 			msj = tramite_instaplantratorresidService.inserta(nuevo);
	 			msj.setIdTipoTramite(catram.getCatalogoID());
			return msj;
	 	}
		
		@RequestMapping(value = "/listacomboTramite_instaplantratorresid", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody List <Tramite_InstaPlanTraTorResid> listacomboTramite_instaplantratorresid(@ModelAttribute("tramite_instaplantratorresid") Tramite_InstaPlanTraTorResid nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_instaplantratorresidService.lista(rol);
	 	}
	 	@RequestMapping(value = "/consultaTramite_instaplantratorresid", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody Tramite_InstaPlanTraTorResid consultaTramite_instaplantratorresid(@ModelAttribute("tramite_instaplantratorresid") Tramite_InstaPlanTraTorResid nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_instaplantratorresidService.consulta(nuevo, rol);
	 	}
		
		/**
		 * 
		 */

		@RequestMapping(value = "/registerTramite_ubiopermaintrellsaniconfnormofimex", method = RequestMethod.POST, produces = "application/json")
	 	public @ResponseBody MensajeBean registerTramite_ubiopermaintrellsaniconfnormofimex(@ModelAttribute("tramite_ubiopermaintrellsaniconfnormofimex") Tramite_ubiopermaintrellsaniconfnormofimex nuevo, BindingResult resul,HttpServletRequest request) {
				MensajeBean msj = new MensajeBean();
				Date date = new Date();
	 			Bitacoras bita =new  Bitacoras();
	 			bita.setEstatus(nuevo.getEstatus());
	 			bita.setFecha(dateFormat.format(date));
	 			bita.setHora(hourFormat.format(date));
	 			String auxi = request.getSession().getAttribute("usuario_id").toString();
	 			bita.setIdusuario(Integer.parseInt(auxi));
	 			CatalogoTramites catram = new CatalogoTramites();
	 			catram.setNombreTramite("Ubicación, operación y manejo integral de un relleno sanitario, conforme a las Normas Oficiales Mexicanas y demás ordenamientos aplicables.");
	 			catram = cattramitesService.consultaTramiteByNombreTramite(catram);
	 			bita.setCatalogoID(catram.getCatalogoID());
	 			bita.setIdempresa(nuevo.getIdempresa());
	 			bita.setIdestablecimiento(nuevo.getIdestablecimiento());
	 			bita.setIdregistro(String.valueOf(nuevo.getIdtramite()));
	 			bita.setTipoBitacora("Tramite");
	 			bitacorasService.inserta(bita);
	 			msj = Tramite_ubiopermaintrellsaniconfnormofimexService.inserta(nuevo);
	 			msj.setIdTipoTramite(catram.getCatalogoID());
			return msj; 
	 	}
		@RequestMapping(value = "/listacomboTramite_ubiopermaintrellsaniconfnormofimex", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody List <Tramite_ubiopermaintrellsaniconfnormofimex> listacomboTramite_ubiopermaintrellsaniconfnormofimex(@ModelAttribute("tramite_ubiopermaintrellsaniconfnormofimex") Tramite_ubiopermaintrellsaniconfnormofimex nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return Tramite_ubiopermaintrellsaniconfnormofimexService.lista(rol);
	 	}
	 	@RequestMapping(value = "/consultaTramite_ubiopermaintrellsaniconfnormofimex", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody Tramite_ubiopermaintrellsaniconfnormofimex consultaTramite_ubiopermaintrellsaniconfnormofimex(@ModelAttribute("tramite_ubiopermaintrellsaniconfnormofimex") Tramite_ubiopermaintrellsaniconfnormofimex nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return Tramite_ubiopermaintrellsaniconfnormofimexService.consulta(nuevo, rol);
	 	}

		@RequestMapping(value = "/registerTramite_transresidmaespe", method = RequestMethod.POST, produces = "application/json")
	 	public @ResponseBody MensajeBean registerTramite_transresidmaespe(@ModelAttribute("tramite_transresidmaespe") Tramite_transresidmaespe nuevo, BindingResult resul,HttpServletRequest request) {
				MensajeBean msj = new MensajeBean();
				Date date = new Date();
	 			Bitacoras bita =new  Bitacoras();
	 			bita.setEstatus(nuevo.getEstatus());
	 			bita.setFecha(dateFormat.format(date));
	 			bita.setHora(hourFormat.format(date));
	 			String auxi = request.getSession().getAttribute("usuario_id").toString();
	 			bita.setIdusuario(Integer.parseInt(auxi));
	 			CatalogoTramites catram = new CatalogoTramites();
	 			catram.setNombreTramite("Transportes de residuos de manejo especial");
	 			catram = cattramitesService.consultaTramiteByNombreTramite(catram);
	 			bita.setCatalogoID(catram.getCatalogoID());
	 			bita.setIdempresa(nuevo.getIdempresa());
	 			bita.setIdestablecimiento(nuevo.getIdestablecimiento());
	 			bita.setIdregistro(String.valueOf(nuevo.getIdtramite()));
	 			bita.setTipoBitacora("Tramite");
	 			bitacorasService.inserta(bita);
	 			msj = tramite_transresidmaespeService.inserta(nuevo);
	 			msj.setIdTipoTramite(catram.getCatalogoID());
			return msj;
	 	}
		
		@RequestMapping(value = "/listacomboTramite_transresidmaespe", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody List <Tramite_transresidmaespe> listacomboTramite_transresidmaespe(@ModelAttribute("tramite_transresidmaespe") Tramite_transresidmaespe nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_transresidmaespeService.lista(rol);
	 	}
	 	
	 	@RequestMapping(value = "/consultaTramite_transresidmaespe", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody Tramite_transresidmaespe consultaTramite_transresidmaespe(@ModelAttribute("tramite_transresidmaespe") Tramite_transresidmaespe nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_transresidmaespeService.consulta(nuevo, rol);
	 	}
	 	
	 	/***
		 *  tramite_recolecresidmarspeService
		 */
		@RequestMapping(value = "/registerTramite_recolecresidmaespe", method = RequestMethod.POST, produces = "application/json")
	 	public @ResponseBody MensajeBean registerTramite_recolecresidmaespe(@ModelAttribute("tramite_recolecresidmaespe") Tramite_recolecresidmaespe nuevo, BindingResult resul,HttpServletRequest request) {
				MensajeBean msj = new MensajeBean();
				Date date = new Date();
	 			Bitacoras bita =new  Bitacoras();
	 			bita.setEstatus(nuevo.getEstatus());
	 			bita.setFecha(dateFormat.format(date));
	 			bita.setHora(hourFormat.format(date));
	 			String auxi = request.getSession().getAttribute("usuario_id").toString();
	 			bita.setIdusuario(Integer.parseInt(auxi));
	 			CatalogoTramites catram = new CatalogoTramites();
	 			catram.setNombreTramite("Recolección de residuos de manejo especial");
	 			catram = cattramitesService.consultaTramiteByNombreTramite(catram);
	 			bita.setCatalogoID(catram.getCatalogoID());
	 			bita.setIdempresa(nuevo.getIdempresa());
	 			bita.setIdestablecimiento(nuevo.getIdestablecimiento());
	 			bita.setIdregistro(String.valueOf(nuevo.getIdtramite()));
	 			bita.setTipoBitacora("Tramite");
	 			bitacorasService.inserta(bita);
	 			msj = tramite_recolecresidmarspeService.inserta(nuevo);
	 			msj.setIdTipoTramite(catram.getCatalogoID());
			return msj;
	 	}
		@RequestMapping(value = "/listacomboTramite_recolecresidmaespe", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody List <Tramite_recolecresidmaespe> listacomboTramite_recolecresidmaespe(@ModelAttribute("tramite_recolecresidmaespe") Tramite_recolecresidmaespe nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_recolecresidmarspeService.lista(rol);
	 	}
	 	
	 	@RequestMapping(value = "/consultaTramite_recolecresidmaespe", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody Tramite_recolecresidmaespe consultaTramite_recolecresidmaespe(@ModelAttribute("tramite_recolecresidmaespe") Tramite_recolecresidmaespe nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_recolecresidmarspeService.consulta(nuevo, rol);
	 	}
	 	


		/***
		 *  Tramite_reciclaje_residuos_manejo_especial
		 */

		@RequestMapping(value = "/registerTramite_reciclaje_residuos_manejo_especial", method = RequestMethod.POST, produces = "application/json")
	 	public @ResponseBody MensajeBean registerTramite_reciclaje_residuos_manejo_especial(@ModelAttribute("tramite_reciclaje_residuos_manejo_especial") Tramite_reciclaje_residuos_manejo_especial nuevo, BindingResult resul,HttpServletRequest request) {
				MensajeBean msj = new MensajeBean();
				Date date = new Date();
	 			Bitacoras bita =new  Bitacoras();
	 			bita.setEstatus(nuevo.getEstatus());
	 			bita.setFecha(dateFormat.format(date));
	 			bita.setHora(hourFormat.format(date));
	 			String auxi = request.getSession().getAttribute("usuario_id").toString();
	 			bita.setIdusuario(Integer.parseInt(auxi));
	 			CatalogoTramites catram = new CatalogoTramites();
	 			catram.setNombreTramite("Reciclaje de residuos de manejo especial");
	 			catram = cattramitesService.consultaTramiteByNombreTramite(catram);
	 			bita.setCatalogoID(catram.getCatalogoID());
	 			bita.setIdempresa(nuevo.getCatalogo_perfilempresa_idcatalogo_perfilempresa());
	 			bita.setIdestablecimiento(nuevo.getCatalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento());
	 			bita.setIdregistro(String.valueOf(nuevo.getIdtramite_reciclaje_residuos_manejo_especial()));
	 			bita.setTipoBitacora("Tramite");
	 			bitacorasService.inserta(bita);
	 			msj = Tramite_reciclaje_residuos_manejo_especialService.inserta(nuevo);
	 			msj.setIdTipoTramite(catram.getCatalogoID());
			return msj;
	 	}
		@RequestMapping(value = "/listacomboTramite_reciclaje_residuos_manejo_especial", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody List <Tramite_reciclaje_residuos_manejo_especial> listacomboTramite_reciclaje_residuos_manejo_especial(@ModelAttribute("tramite_reciclaje_residuos_manejo_especial") Tramite_reciclaje_residuos_manejo_especial nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return Tramite_reciclaje_residuos_manejo_especialService.lista(rol);
	 	}
	 	@RequestMapping(value = "/consultaTramite_reciclaje_residuos_manejo_especial", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody Tramite_reciclaje_residuos_manejo_especial consultaTramite_reciclaje_residuos_manejo_especial(@ModelAttribute("tramite_reciclaje_residuos_manejo_especial") Tramite_reciclaje_residuos_manejo_especial nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return Tramite_reciclaje_residuos_manejo_especialService.consulta(nuevo, rol);
	 	}
	 	
		/***
		 *  Tramite_rehuso_residuos_manejo_especial
		 */
		
		@RequestMapping(value = "/registerTramite_rehuso_residuos_manejo_especial", method = RequestMethod.POST, produces = "application/json")
	 	public @ResponseBody MensajeBean registerTramite_rehuso_residuos_manejo_especial(@ModelAttribute("tramite_rehuso_residuos_manejo_especial") Tramite_rehuso_residuos_manejo_especial nuevo, BindingResult resul,HttpServletRequest request) {
				MensajeBean msj = new MensajeBean();
				Date date = new Date();
	 			Bitacoras bita =new  Bitacoras();
	 			bita.setEstatus(nuevo.getEstatus());
	 			bita.setFecha(dateFormat.format(date));
	 			bita.setHora(hourFormat.format(date));
	 			String auxi = request.getSession().getAttribute("usuario_id").toString();
	 			bita.setIdusuario(Integer.parseInt(auxi));
	 			CatalogoTramites catram = new CatalogoTramites();
	 			catram.setNombreTramite("Reuso de residuos de manejo especial");
	 			catram = cattramitesService.consultaTramiteByNombreTramite(catram);
	 			bita.setCatalogoID(catram.getCatalogoID());
	 			bita.setIdempresa(nuevo.getCatalogo_perfilempresa_idcatalogo_perfilempresa());
	 			bita.setIdestablecimiento(nuevo.getCatalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento());
	 			bita.setIdregistro(String.valueOf(nuevo.getIdtramite_rehuso_residuos_manejo_especial()));
	 			bita.setTipoBitacora("Tramite");
	 			bitacorasService.inserta(bita);
	 			msj = Tramite_rehuso_residuos_manejo_especialService.inserta(nuevo);
	 			msj.setIdTipoTramite(catram.getCatalogoID());
			return msj;
	 	}
		@RequestMapping(value = "/listacomboTramite_rehuso_residuos_manejo_especial", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody List <Tramite_rehuso_residuos_manejo_especial> listacomboTramite_rehuso_residuos_manejo_especial(@ModelAttribute("tramite_rehuso_residuos_manejo_especial") Tramite_rehuso_residuos_manejo_especial nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return Tramite_rehuso_residuos_manejo_especialService.lista(rol);
	 	}
	 	@RequestMapping(value = "/consultaTramite_rehuso_residuos_manejo_especial", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody Tramite_rehuso_residuos_manejo_especial consultaTramite_rehuso_residuos_manejo_especial(@ModelAttribute("tramite_rehuso_residuos_manejo_especial") Tramite_rehuso_residuos_manejo_especial nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return Tramite_rehuso_residuos_manejo_especialService.consulta(nuevo, rol);
	 	}
		
		/**
		 * 
		 */
	 	
	 	
	 	/***
		 *  Tramite_operacion_vehi_recolectores
		 */
		
		@RequestMapping(value = "/registerTramite_operacion_vehi_recolectores", method = RequestMethod.POST, produces = "application/json")
	 	public @ResponseBody MensajeBean registerTramite_operacion_vehi_recolectores(@ModelAttribute("tramite_operacion_vehi_recolectores") Tramite_operacion_vehi_recolectores nuevo, BindingResult resul,HttpServletRequest request) {
				MensajeBean msj = new MensajeBean();
				Date date = new Date();
	 			Bitacoras bita =new  Bitacoras();
	 			bita.setEstatus(nuevo.getEstatus());
	 			bita.setHora(hourFormat.format(date));
	 			String auxi = request.getSession().getAttribute("usuario_id").toString();
	 			bita.setIdusuario(Integer.parseInt(auxi));
	 			CatalogoTramites catram = new CatalogoTramites();
	 			catram.setNombreTramite("Operación de los vehículos recolectores de residuos sólidos urbanos cuando presenten el servicio a dos o más municipios");
	 			catram = cattramitesService.consultaTramiteByNombreTramite(catram);
	 			bita.setCatalogoID(catram.getCatalogoID());
	 			bita.setIdempresa(nuevo.getCatalogo_perfilempresa_idcatalogo_perfilempresa());
	 			bita.setIdestablecimiento(nuevo.getCatalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento());
	 			bita.setIdregistro(String.valueOf(nuevo.getIdtramite_operacion_vehi_recolectores()));
	 			bita.setTipoBitacora("Tramite");
	 			bitacorasService.inserta(bita);
	 			msj = Tramite_operacion_vehi_recolectoresService.inserta(nuevo);
	 			msj.setIdTipoTramite(catram.getCatalogoID());
			return msj;
	 	}
		@RequestMapping(value = "/listacomboTramite_operacion_vehi_recolectores", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody List <Tramite_operacion_vehi_recolectores> listacomboTramite_operacion_vehi_recolectores(@ModelAttribute("tramite_operacion_vehi_recolectores") Tramite_operacion_vehi_recolectores nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return Tramite_operacion_vehi_recolectoresService.lista(rol);
	 	}
	 	@RequestMapping(value = "/consultaTramite_operacion_vehi_recolectores", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody Tramite_operacion_vehi_recolectores consultaTramite_operacion_vehi_recolectores(@ModelAttribute("tramite_operacion_vehi_recolectores") Tramite_operacion_vehi_recolectores nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return Tramite_operacion_vehi_recolectoresService.consulta(nuevo, rol);
	 	}
		
		/**
		 * 
		 */
	 	
		/***
		 *  Tramite_operacion_manejo_integral_centros
		 */
		
		@RequestMapping(value = "/registerTramite_operacion_manejo_integral_centros", method = RequestMethod.POST, produces = "application/json")
	 	public @ResponseBody MensajeBean registerTramite_operacion_manejo_integral_centros(@ModelAttribute("tramite_operacion_manejo_integral_centros") Tramite_operacion_manejo_integral_centros nuevo, BindingResult resul,HttpServletRequest request) {
				MensajeBean msj = new MensajeBean();
				Date date = new Date();
	 			Bitacoras bita =new  Bitacoras();
	 			bita.setEstatus(nuevo.getEstatus());
	 			bita.setFecha(dateFormat.format(date));
	 			bita.setHora(hourFormat.format(date));
	 			String auxi = request.getSession().getAttribute("usuario_id").toString();
	 			bita.setIdusuario(Integer.parseInt(auxi));
	 			CatalogoTramites catram = new CatalogoTramites();
	 			catram.setNombreTramite("Operación y manejo integral de los centros de composteo");
	 			catram = cattramitesService.consultaTramiteByNombreTramite(catram);
	 			bita.setCatalogoID(catram.getCatalogoID());
	 			bita.setIdempresa(nuevo.getCatalogo_perfilempresa_idcatalogo_perfilempresa());
	 			bita.setIdestablecimiento(nuevo.getCatalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento());
	 			bita.setIdregistro(String.valueOf(nuevo.getIdtramite_operacion_manejo_integral_centros()));
	 			bita.setTipoBitacora("Tramite");
	 			bitacorasService.inserta(bita);
	 			msj = Tramite_operacion_manejo_integral_centrosService.inserta(nuevo);
	 			msj.setIdTipoTramite(catram.getCatalogoID());
			return msj;
	 	}
		@RequestMapping(value = "/listacomboTramite_operacion_manejo_integral_centros", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody List <Tramite_operacion_manejo_integral_centros> listacomboTramite_operacion_manejo_integral_centros(@ModelAttribute("tramite_operacion_manejo_integral_centros") Tramite_operacion_manejo_integral_centros nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return Tramite_operacion_manejo_integral_centrosService.lista(rol);
	 	}
	 	@RequestMapping(value = "/consultaTramite_operacion_manejo_integral_centros", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody Tramite_operacion_manejo_integral_centros consultaTramite_operacion_manejo_integral_centros(@ModelAttribute("tramite_operacion_manejo_integral_centros") Tramite_operacion_manejo_integral_centros nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return Tramite_operacion_manejo_integral_centrosService.consulta(nuevo, rol);
	 	}
		
		/**
		 * 
		 */
	 	
	 	
	 	/***
		 *  Tramite_operacion_manejo_integral_establecimientos
		 */
		
		@RequestMapping(value = "/registerTramite_operacion_manejo_integral_establecimientos", method = RequestMethod.POST, produces = "application/json")
	 	public @ResponseBody MensajeBean registerTramite_operacion_manejo_integral_establecimientos(@ModelAttribute("tramite_operacion_manejo_integral_establecimientos") Tramite_operacion_manejo_integral_establecimientos nuevo, BindingResult resul,HttpServletRequest request) {
				MensajeBean msj = new MensajeBean();
				Date date = new Date();
	 			Bitacoras bita =new  Bitacoras();
	 			bita.setEstatus(nuevo.getEstatus());
	 			bita.setFecha(dateFormat.format(date));
	 			bita.setHora(hourFormat.format(date));
	 			String auxi = request.getSession().getAttribute("usuario_id").toString();
	 			bita.setIdusuario(Integer.parseInt(auxi));
	 			CatalogoTramites catram = new CatalogoTramites();
	 			catram.setNombreTramite("Operación y manejo integral de los establecimientos para la compra y venta de materiales reciclables.");
	 			catram = cattramitesService.consultaTramiteByNombreTramite(catram);
	 			bita.setCatalogoID(catram.getCatalogoID());
	 			bita.setIdempresa(nuevo.getCatalogo_perfilempresa_idcatalogo_perfilempresa());
	 			bita.setIdestablecimiento(nuevo.getCatalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento());
	 			bita.setIdregistro(String.valueOf(nuevo.getIdtramite_operacion_manejo_integral_establecimientos()));
	 			bita.setTipoBitacora("Tramite");
	 			bitacorasService.inserta(bita);
	 			msj = Tramite_operacion_manejo_integral_establecimientosService.inserta(nuevo);
	 			msj.setIdTipoTramite(catram.getCatalogoID());
			return msj;
	 	}
		@RequestMapping(value = "/listacomboTramite_operacion_manejo_integral_establecimientos", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody List <Tramite_operacion_manejo_integral_establecimientos> listacomboTramite_operacion_manejo_integral_establecimientos(@ModelAttribute("tramite_operacion_manejo_integral_establecimientos") Tramite_operacion_manejo_integral_establecimientos nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return Tramite_operacion_manejo_integral_establecimientosService.lista(rol);
	 	}
	 	@RequestMapping(value = "/consultaTramite_operacion_manejo_integral_establecimientos", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody Tramite_operacion_manejo_integral_establecimientos consultaTramite_operacion_manejo_integral_establecimientos(@ModelAttribute("tramite_operacion_manejo_integral_establecimientos") Tramite_operacion_manejo_integral_establecimientos nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return Tramite_operacion_manejo_integral_establecimientosService.consulta(nuevo, rol);
	 	}
		
		/**
		 * 
		 */
	 	
	 	/***
		 *  Tramite_reception_validacion_informacion
		 */
		
		@RequestMapping(value = "/registerTramite_reception_validacion_informacion", method = RequestMethod.POST, produces = "application/json")
	 	public @ResponseBody MensajeBean registerTramite_reception_validacion_informacion(@ModelAttribute("tramite_reception_validacion_informacion") Tramite_reception_validacion_informacion nuevo, BindingResult resul,HttpServletRequest request) {
				MensajeBean msn = new MensajeBean();
				Date date = new Date();
	 			Bitacoras bita =new  Bitacoras();
	 			bita.setEstatus(nuevo.getEstatus());
	 			bita.setFecha(dateFormat.format(date));
	 			bita.setHora(hourFormat.format(date));
	 			String auxi = request.getSession().getAttribute("usuario_id").toString();
	 			bita.setIdusuario(Integer.parseInt(auxi));
	 			CatalogoTramites catram = new CatalogoTramites();
	 			catram.setNombreTramite("Recepción y Validación de información del COA");
	 			catram = cattramitesService.consultaTramiteByNombreTramite(catram);
	 			bita.setCatalogoID(catram.getCatalogoID());
	 			bita.setIdempresa(nuevo.getCatalogo_perfilempresa_idcatalogo_perfilempresa());
	 			bita.setIdestablecimiento(nuevo.getCatalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento());
	 			bita.setIdregistro(String.valueOf(nuevo.getIdtramite_reception_validacion_informacion()));
	 			bita.setTipoBitacora("Tramite");
	 			bitacorasService.inserta(bita);
	 			msn = Tramite_reception_validacion_informacionService.inserta(nuevo);
	 			msn.setIdTipoTramite(catram.getCatalogoID());
			return msn;
	 	}
		@RequestMapping(value = "/listacomboTramite_reception_validacion_informacion", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody List <Tramite_reception_validacion_informacion> listacomboTramite_reception_validacion_informacion(@ModelAttribute("tramite_reception_validacion_informacion") Tramite_reception_validacion_informacion nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return Tramite_reception_validacion_informacionService.lista(rol);
	 	}
	 	@RequestMapping(value = "/consultaTramite_reception_validacion_informacion", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody Tramite_reception_validacion_informacion consultaTramite_reception_validacion_informacion(@ModelAttribute("tramite_reception_validacion_informacion") Tramite_reception_validacion_informacion nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return Tramite_reception_validacion_informacionService.consulta(nuevo, rol);
	 	}
		
		/**
		 * 
		 */
	 	
		/***
		 *  Tramite_planes_manejo_especificos
		 */
		
		@RequestMapping(value = "/registerTramite_planes_manejo_especificos", method = RequestMethod.POST, produces = "application/json")
	 	public @ResponseBody MensajeBean registerTramite_planes_manejo_especificos(@ModelAttribute("tramite_planes_manejo_especificos") Tramite_planes_manejo_especificos nuevo, BindingResult resul,HttpServletRequest request) {
				MensajeBean msj = new MensajeBean();
				Date date = new Date();
	 			Bitacoras bita =new  Bitacoras();
	 			bita.setEstatus(nuevo.getEstatus());
	 			bita.setFecha(dateFormat.format(date));
	 			bita.setHora(hourFormat.format(date));
	 			String auxi = request.getSession().getAttribute("usuario_id").toString();
	 			bita.setIdusuario(Integer.parseInt(auxi));
	 			CatalogoTramites catram = new CatalogoTramites();
	 			catram.setNombreTramite("Planes de manejo específicos de residuos de manejo especial");
	 			catram = cattramitesService.consultaTramiteByNombreTramite(catram);
	 			bita.setCatalogoID(catram.getCatalogoID());
	 			bita.setIdempresa(nuevo.getCatalogo_perfilempresa_idcatalogo_perfilempresa());
	 			bita.setIdestablecimiento(nuevo.getCatalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento());
	 			bita.setIdregistro(String.valueOf(nuevo.getIdtramite_planes_manejo_especificos()));
	 			bita.setTipoBitacora("Tramite");
	 			bitacorasService.inserta(bita);
	 			msj = Tramite_planes_manejo_especificosService.inserta(nuevo); 
	 			msj.setIdTipoTramite(catram.getCatalogoID());
			return msj;
	 	}
		@RequestMapping(value = "/listacomboTramite_planes_manejo_especificos", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody List <Tramite_planes_manejo_especificos> listacomboTramite_planes_manejo_especificos(@ModelAttribute("tramite_planes_manejo_especificos") Tramite_planes_manejo_especificos nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return Tramite_planes_manejo_especificosService.lista(rol);
	 	}
	 	@RequestMapping(value = "/consultaTramite_planes_manejo_especificos", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody Tramite_planes_manejo_especificos consultaTramite_planes_manejo_especificos(@ModelAttribute("tramite_planes_manejo_especificos") Tramite_planes_manejo_especificos nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return Tramite_planes_manejo_especificosService.consulta(nuevo, rol);
	 	}
		
		/**
		 * 
		 */
	 	
	 	
	 	/***
		 *  tramite_informacion

		 */
		
		@RequestMapping(value = "/registerTramite_informacion", method = RequestMethod.POST, produces = "application/json")
	 	public @ResponseBody MensajeBean registerTramite_informacion(@ModelAttribute("tramite_informacion") Tramite_informacion nuevo, BindingResult resul,HttpServletRequest request) {
				
				MensajeBean msn = new MensajeBean();
				Date date = new Date();
	 			Bitacoras bita =new  Bitacoras();
	 			bita.setEstatus(nuevo.getEstatus());
	 			bita.setFecha(dateFormat.format(date));
	 			bita.setHora(hourFormat.format(date));
	 			String auxi = request.getSession().getAttribute("usuario_id").toString();
	 			bita.setIdusuario(Integer.parseInt(auxi));
	 			CatalogoTramites catram = new CatalogoTramites();
	 			catram.setNombreTramite("Presentan información descargas");
	 			catram = cattramitesService.consultaTramiteByNombreTramite(catram);
	 			bita.setCatalogoID(catram.getCatalogoID());
	 			bita.setIdempresa(nuevo.getCatalogo_perfilempresa_idcatalogo_perfilempresa());
	 			bita.setIdestablecimiento(nuevo.getCatalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento());
	 			bita.setIdregistro(String.valueOf(nuevo.getIdtramite_informacion()));
	 			bita.setTipoBitacora("Tramite");
	 			bitacorasService.inserta(bita);
	 			msn = tramite_informacionService.inserta(nuevo);
	 			msn.setIdTipoTramite(catram.getCatalogoID());
			return msn;
	 	}
		@RequestMapping(value = "/listacomboTramite_informacion", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody List <Tramite_informacion> listacomboTramite_informacion(@ModelAttribute("tramite_informacion") Tramite_informacion nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_informacionService.lista(rol);
	 	}
	 	@RequestMapping(value = "/consultaTramite_informacion", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody Tramite_informacion consultaTramite_informacion(@ModelAttribute("tramite_informacion") Tramite_informacion nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_informacionService.consulta(nuevo, rol);
	 	}
	 	
	 	/***
		 *  tramite_actualizacion_tranps

		 */
		
		@RequestMapping(value = "/registerTramite_actualizacion_tranps", method = RequestMethod.POST, produces = "application/json")
	 	public @ResponseBody MensajeBean registerTramite_actualizacion_tranps(@ModelAttribute("tramite_actualizacion_tranps") Tramite_actualizacion_tranps nuevo, BindingResult resul,HttpServletRequest request) {
			MensajeBean mensaje = new MensajeBean();
				Date date = new Date();
	 			Bitacoras bita =new  Bitacoras();
	 			bita.setEstatus(nuevo.getEstatus());
	 			bita.setFecha(dateFormat.format(date));
	 			bita.setHora(hourFormat.format(date));
	 			String auxi = request.getSession().getAttribute("usuario_id").toString();
	 			bita.setIdusuario(Integer.parseInt(auxi));
	 			CatalogoTramites catram = new CatalogoTramites();
	 			catram.setNombreTramite("Actualización de transportistas");
	 			catram = cattramitesService.consultaTramiteByNombreTramite(catram);
	 			bita.setCatalogoID(catram.getCatalogoID());
	 			bita.setIdempresa(nuevo.getCatalogo_perfilempresa_idcatalogo_perfilempresa());
	 			bita.setIdestablecimiento(nuevo.getCatalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento());
	 			bita.setIdregistro(String.valueOf(nuevo.getIdtramite_actualizacion_tranps()));
	 			bita.setTipoBitacora("Tramite");
	 			bitacorasService.inserta(bita);
	 			mensaje = tramite_actualizacion_tranpsService.inserta(nuevo);
	 			mensaje.setIdTipoTramite(catram.getCatalogoID());
	 			
			return mensaje;
	 	}
		@RequestMapping(value = "/listacomboTramite_actualizacion_tranps", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody List <Tramite_actualizacion_tranps> listacomboTramite_actualizacion_tranps(@ModelAttribute("tramite_actualizacion_tranps") Tramite_actualizacion_tranps nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_actualizacion_tranpsService.lista(rol);
	 	}
	 	@RequestMapping(value = "/consultaTramite_actualizacion_tranps", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody Tramite_actualizacion_tranps consultaTramite_actualizacion_tranps(@ModelAttribute("tramite_actualizacion_tranps") Tramite_actualizacion_tranps nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_actualizacion_tranpsService.consulta(nuevo, rol);
	 	}
		
	 	/***
		 *  tramite_baja_cambio_dom

		 */
		
		@RequestMapping(value = "/registerTramite_baja_cambio_dom", method = RequestMethod.POST, produces = "application/json")
	 	public @ResponseBody MensajeBean registerTramite_baja_cambio_dom(@ModelAttribute("tramite_baja_cambio_dom") Tramite_baja_cambio_dom nuevo, BindingResult resul,HttpServletRequest request) {
				MensajeBean mensaje = new MensajeBean();
				Date date = new Date();
	 			Bitacoras bita =new  Bitacoras();
	 			bita.setEstatus(nuevo.getEstatus());
	 			bita.setFecha(dateFormat.format(date));
	 			bita.setHora(hourFormat.format(date));
	 			String auxi = request.getSession().getAttribute("usuario_id").toString();
	 			bita.setIdusuario(Integer.parseInt(auxi));
	 			CatalogoTramites catram = new CatalogoTramites();
	 			catram.setNombreTramite("Baja por cambio de domicilio");
	 			catram = cattramitesService.consultaTramiteByNombreTramite(catram);
	 			bita.setCatalogoID(catram.getCatalogoID());
	 			bita.setIdempresa(nuevo.getCatalogo_perfilempresa_idcatalogo_perfilempresa());
	 			bita.setIdestablecimiento(nuevo.getCatalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento());
	 			bita.setIdregistro(String.valueOf(nuevo.getIdtramite_baja_cambio_dom()));
	 			bita.setTipoBitacora("Tramite");
	 			bitacorasService.inserta(bita);
	 			mensaje = tramite_baja_cambio_domService.inserta(nuevo);
	 			mensaje.setIdTipoTramite(catram.getCatalogoID());
			return mensaje;
	 	}
		@RequestMapping(value = "/listacomboTramite_baja_cambio_dom", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody List <Tramite_baja_cambio_dom> listacomboTramite_baja_cambio_dom(@ModelAttribute("tramite_baja_cambio_dom") Tramite_baja_cambio_dom nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_baja_cambio_domService.lista(rol);
	 	}
	 	@RequestMapping(value = "/consultaTramite_baja_cambio_dom", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody Tramite_baja_cambio_dom consultaTramite_baja_cambio_dom(@ModelAttribute("tramite_baja_cambio_dom") Tramite_baja_cambio_dom nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_baja_cambio_domService.consulta(nuevo, rol);
	 	}
	 	
	 	/***
		 *  tramite_baja_venta_pasivo

		 */
		
		@RequestMapping(value = "/registerTramite_baja_venta_pasivo", method = RequestMethod.POST, produces = "application/json")
	 	public @ResponseBody MensajeBean registerTramite_baja_venta_pasivo(@ModelAttribute("tramite_baja_venta_pasivo") Tramite_baja_venta_pasivo nuevo, BindingResult resul,HttpServletRequest request) {
			
				MensajeBean mensaje = new MensajeBean();
				Date date = new Date();
	 			Bitacoras bita =new  Bitacoras();
	 			bita.setEstatus(nuevo.getEstatus());
	 			bita.setFecha(dateFormat.format(date));
	 			bita.setHora(hourFormat.format(date));
	 			String auxi = request.getSession().getAttribute("usuario_id").toString();
	 			bita.setIdusuario(Integer.parseInt(auxi));
	 			CatalogoTramites catram = new CatalogoTramites();
	 			catram.setNombreTramite("Baja por venta de pasivo ambiental");
	 			catram = cattramitesService.consultaTramiteByNombreTramite(catram);
	 			bita.setCatalogoID(catram.getCatalogoID());
	 			bita.setIdempresa(nuevo.getCatalogo_perfilempresa_idcatalogo_perfilempresa());
	 			bita.setIdestablecimiento(nuevo.getCatalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento());
	 			bita.setIdregistro(String.valueOf(nuevo.getIdtramite_baja_venta_pasivo()));
	 			bita.setTipoBitacora("Tramite");
	 			bitacorasService.inserta(bita);
	 			mensaje = tramite_baja_venta_pasivoService.inserta(nuevo);
	 			mensaje.setIdTipoTramite(catram.getCatalogoID());
	 		
			return mensaje;
	 	}
		@RequestMapping(value = "/listacomboTramite_baja_venta_pasivo", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody List <Tramite_baja_venta_pasivo> listacomboTramite_baja_venta_pasivo(@ModelAttribute("tramite_baja_venta_pasivo") Tramite_baja_venta_pasivo nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_baja_venta_pasivoService.lista(rol);
	 	}
	 	@RequestMapping(value = "/consultaTramite_baja_venta_pasivo", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody Tramite_baja_venta_pasivo consultaTramite_baja_venta_pasivo(@ModelAttribute("tramite_baja_venta_pasivo") Tramite_baja_venta_pasivo nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_baja_venta_pasivoService.consulta(nuevo, rol);
	 	}
	 	

	 	/***
		 *  tramite_actualizacion_situa_partdes

		 */
		
		@RequestMapping(value = "/registerTramite_actualizacion_situa_partdes", method = RequestMethod.POST, produces = "application/json")
	 	public @ResponseBody MensajeBean registerTramite_actualizacion_situa_partdes(@ModelAttribute("tramite_actualizacion_situa_partdes") Tramite_actualizacion_situa_partdes nuevo, BindingResult resul,HttpServletRequest request) {
			{
				Date date = new Date();
	 			Bitacoras bita =new  Bitacoras();
	 			bita.setEstatus(nuevo.getEstatus());
	 			bita.setFecha(dateFormat.format(date));
	 			bita.setHora(hourFormat.format(date));
	 			String auxi = request.getSession().getAttribute("usuario_id").toString();
	 			bita.setIdusuario(Integer.parseInt(auxi));
	 			CatalogoTramites catram = new CatalogoTramites();
	 			catram.setNombreTramite("Actualización de situación particular de descarga");
	 			catram = cattramitesService.consultaTramiteByNombreTramite(catram);
	 			bita.setCatalogoID(catram.getCatalogoID());
	 			bita.setIdempresa(nuevo.getIdempresa());
	 			bita.setIdestablecimiento(nuevo.getIdestablecimiento());
	 			bita.setIdregistro(String.valueOf(nuevo.getIdtramite()));
	 			bita.setTipoBitacora("Tramite");
	 			bitacorasService.inserta(bita);
	 		}
			return tramite_actualizacion_situa_partdesService.inserta(nuevo);
	 	}
		@RequestMapping(value = "/listacomboTramite_actualizacion_situa_partdes", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody List <Tramite_actualizacion_situa_partdes> listacomboTramite_actualizacion_situa_partdes(@ModelAttribute("tramite_actualizacion_situa_partdes") Tramite_actualizacion_situa_partdes nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_actualizacion_situa_partdesService.lista(rol);
	 	}
	 	@RequestMapping(value = "/consultaTramite_actualizacion_situa_partdes", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody Tramite_actualizacion_situa_partdes consultaTramite_actualizacion_situa_partdes(@ModelAttribute("tramite_actualizacion_situa_partdes") Tramite_actualizacion_situa_partdes nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_actualizacion_situa_partdesService.consulta(nuevo, rol);
	 	}
	 	

	 	/***
		 *  tramite_modif_condif_part_desc

		 */
		
		@RequestMapping(value = "/registerTramite_modif_condif_part_desc", method = RequestMethod.POST, produces = "application/json")
	 	public @ResponseBody MensajeBean registerTramite_modif_condif_part_desc(@ModelAttribute("tramite_modif_condif_part_desc") Tramite_modif_condif_part_desc nuevo, BindingResult resul,HttpServletRequest request) {
			
				MensajeBean msj = new MensajeBean();
				Date date = new Date();
	 			Bitacoras bita =new  Bitacoras();
	 			bita.setEstatus(nuevo.getEstatus());
	 			bita.setFecha(dateFormat.format(date));
	 			bita.setHora(hourFormat.format(date));
	 			String auxi = request.getSession().getAttribute("usuario_id").toString();
	 			bita.setIdusuario(Integer.parseInt(auxi));
	 			CatalogoTramites catram = new CatalogoTramites();
	 			catram.setNombreTramite("Modificación de las condiciones particulares de descarga según el parámetro y/o número de descarga.");
	 			catram = cattramitesService.consultaTramiteByNombreTramite(catram);
	 			bita.setCatalogoID(catram.getCatalogoID());
	 			bita.setIdempresa(nuevo.getIdempresa());
	 			bita.setIdestablecimiento(nuevo.getIdestablecimiento());
	 			bita.setIdregistro(String.valueOf(nuevo.getIdtramite()));
	 			bita.setTipoBitacora("Tramite");
	 			bitacorasService.inserta(bita);
	 			
	 			msj = tramite_modif_condif_part_descService.inserta(nuevo);
	 			msj.setIdTipoTramite(catram.getCatalogoID());
	 			
	 			return msj;
	 	}
		@RequestMapping(value = "/listacomboTramite_modif_condif_part_desc", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody List <Tramite_modif_condif_part_desc> listacomboTramite_modif_condif_part_desc(@ModelAttribute("tramite_modif_condif_part_desc") Tramite_modif_condif_part_desc nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_modif_condif_part_descService.lista(rol);
	 	}
	 	@RequestMapping(value = "/consultaTramite_modif_condif_part_desc", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody Tramite_modif_condif_part_desc consultaTramite_modif_condif_part_desc(@ModelAttribute("tramite_modif_condif_part_desc") Tramite_modif_condif_part_desc nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_modif_condif_part_descService.consulta(nuevo, rol);
	 	}
		/**
		 * 
		 */
	 	
	 	/***
		 *  tramite_ubiopermaintsitdisfiproesttransf

		 */
		
		@RequestMapping(value = "/registerTramite_UbiOperMaIntSitDisFiProEstTransf", method = RequestMethod.POST, produces = "application/json")
	 	public @ResponseBody MensajeBean registerTramite_UbiOperMaIntSitDisFiProEstTransf(@ModelAttribute("tramite_informacion") Tramite_UbiOperMaIntSitDisFiProEstTransf nuevo, BindingResult resul, HttpServletRequest request) {
				MensajeBean msj = new MensajeBean();
				Date date = new Date();
	 			Bitacoras bita =new  Bitacoras();
	 			bita.setEstatus(nuevo.getEstatus());
	 			bita.setFecha(dateFormat.format(date));
	 			bita.setHora(hourFormat.format(date));
	 			String auxi = request.getSession().getAttribute("usuario_id").toString();
	 			bita.setIdusuario(Integer.parseInt(auxi));
	 			CatalogoTramites catram = new CatalogoTramites();
	 			catram.setNombreTramite("Ubicación, operación y manejo integral de sitios de disposición final de residuos provenientes de las estaciones de transferencia.");
	 			catram = cattramitesService.consultaTramiteByNombreTramite(catram);
	 			bita.setCatalogoID(catram.getCatalogoID());
	 			bita.setIdempresa(nuevo.getIdempresa());
	 			bita.setIdestablecimiento(nuevo.getIdestablecimiento());
	 			bita.setIdregistro(String.valueOf(nuevo.getIdtramite()));
	 			bita.setTipoBitacora("Tramite");
	 			bitacorasService.inserta(bita);
	 			msj = Tramite_UbiOperMaIntSitDisFiProEstTransfService.inserta(nuevo);
	 			msj.setIdTipoTramite(catram.getCatalogoID());
			return msj;
	 	}
		@RequestMapping(value = "/listacomboTramite_UbiOperMaIntSitDisFiProEstTransf", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody List <Tramite_UbiOperMaIntSitDisFiProEstTransf> listacomboTramite_UbiOperMaIntSitDisFiProEstTransf(@ModelAttribute("tramite_informacion") Tramite_UbiOperMaIntSitDisFiProEstTransf nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return Tramite_UbiOperMaIntSitDisFiProEstTransfService.lista(rol);
	 	}
	 	@RequestMapping(value = "/consultaTramite_UbiOperMaIntSitDisFiProEstTransf", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody Tramite_UbiOperMaIntSitDisFiProEstTransf consultaTramite_UbiOperMaIntSitDisFiProEstTransf(@ModelAttribute("tramite_informacion") Tramite_UbiOperMaIntSitDisFiProEstTransf nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return Tramite_UbiOperMaIntSitDisFiProEstTransfService.consulta(nuevo, rol);
	 	}
		
		/**
		 * 
		 */
	 	
	 	
	 	/***
		 *  tramite_cierre_operaciones
Cierre de operaciones
		 */
		
	 	@RequestMapping(value = "/registerTramite_cierre_operaciones", method = RequestMethod.POST, produces = "application/json")
	 	public @ResponseBody MensajeBean registerTramite_cierre_operaciones(@ModelAttribute("tramite_cierre_operaciones") Tramite_cierre_operaciones tramite, BindingResult resul, HttpServletRequest request) {
	 		MensajeBean nuevo = new MensajeBean();
	 			Date date = new Date();
	 			Bitacoras bita =new  Bitacoras();
	 			bita.setEstatus(tramite.getEstatus());
	 			bita.setFecha(dateFormat.format(date));
	 			bita.setHora(hourFormat.format(date));
	 			String auxi = request.getSession().getAttribute("usuario_id").toString();
	 			bita.setIdusuario(Integer.parseInt(auxi));
	 			CatalogoTramites catram = new CatalogoTramites();
	 			catram.setNombreTramite("Cierre de operaciones");
	 			catram = cattramitesService.consultaTramiteByNombreTramite(catram);
	 			bita.setCatalogoID(catram.getCatalogoID());
	 			bita.setIdempresa(tramite.getCatalogo_perfilempresa_idcatalogo_perfilempresa());
	 			bita.setIdestablecimiento(tramite.getCatalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento());
	 			bita.setIdregistro(String.valueOf(tramite.getIdtramite_cierre_operaciones()));
	 			bita.setTipoBitacora("Tramite");
	 			bitacorasService.inserta(bita);
	 		nuevo = Tramite_cierre_operacionesService.inserta(tramite);
	 		nuevo.setIdTipoTramite(catram.getCatalogoID());
	 		return nuevo;
	 	}
		@RequestMapping(value = "/listacomboTramite_cierre_operaciones", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody List <Tramite_cierre_operaciones> listacomboTramite_cierre_operaciones(@ModelAttribute("tramite_cierre_operaciones") Tramite_cierre_operaciones nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return Tramite_cierre_operacionesService.lista(rol);
	 	}
	 	@RequestMapping(value = "/consultaTramite_cierre_operaciones", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody Tramite_cierre_operaciones consultaTramite_cierre_operaciones(@ModelAttribute("tramite_cierre_operaciones") Tramite_cierre_operaciones nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return Tramite_cierre_operacionesService.consulta(nuevo, rol);
	 	}
	 	
	 	
	 	/***
		 *  tramite_modif_licencia

		 */
		
		@RequestMapping(value = "/registerTramite_modif_licencia", method = RequestMethod.POST, produces = "application/json")
	 	public @ResponseBody MensajeBean registerTramite_modif_licencia(@ModelAttribute("tramite_modif_licencia") Tramite_modif_licencia nuevo, BindingResult resul,HttpServletRequest request) {
				MensajeBean msj = new MensajeBean();
				Date date = new Date();
	 			Bitacoras bita =new  Bitacoras();
	 			bita.setEstatus(nuevo.getEstatus());
	 			bita.setFecha(dateFormat.format(date));
	 			bita.setHora(hourFormat.format(date));
	 			String auxi = request.getSession().getAttribute("usuario_id").toString();
	 			bita.setIdusuario(Integer.parseInt(auxi));
	 			CatalogoTramites catram = new CatalogoTramites();
	 			catram.setNombreTramite("Modificación de licencia");
	 			catram = cattramitesService.consultaTramiteByNombreTramite(catram);
	 			bita.setCatalogoID(catram.getCatalogoID());
	 			bita.setIdempresa(nuevo.getCatalogo_perfilempresa_idcatalogo_perfilempresa());
	 			bita.setIdestablecimiento(nuevo.getCatalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento());
	 			bita.setIdregistro(String.valueOf(nuevo.getIdtramite_modif_licencia()));
	 			bita.setTipoBitacora("Tramite");
	 			bitacorasService.inserta(bita);
	 			msj = tramite_modif_licenciaService.inserta(nuevo);
	 			msj.setIdTipoTramite(catram.getCatalogoID());
			return msj;
	 	}
		@RequestMapping(value = "/listacomboTramite_modif_licencia", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody List <Tramite_modif_licencia> listacomboTramite_modif_licencia(@ModelAttribute("tramite_modif_licencia") Tramite_modif_licencia nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_modif_licenciaService.lista(rol);
	 	}
	 	@RequestMapping(value = "/consultaTramite_modif_licencia", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody Tramite_modif_licencia consultaTramite_modif_licencia(@ModelAttribute("tramite_modif_licencia") Tramite_modif_licencia nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_modif_licenciaService.consulta(nuevo, rol);
	 	}
		
	 	
		/***
		 *  tramite_otros

		 */
		
		@RequestMapping(value = "/registerTramite_otros", method = RequestMethod.POST, produces = "application/json")
	 	public @ResponseBody MensajeBean registerTramite_otros(@ModelAttribute("tramite_otros") Tramite_otros nuevo, BindingResult resul,HttpServletRequest request) {
				MensajeBean bean = new MensajeBean();
				Date date = new Date();
	 			Bitacoras bita =new  Bitacoras();
	 			bita.setEstatus(nuevo.getEstatus());
	 			bita.setFecha(dateFormat.format(date));
	 			bita.setHora(hourFormat.format(date));
	 			String auxi = request.getSession().getAttribute("usuario_id").toString();
	 			bita.setIdusuario(Integer.parseInt(auxi));
	 			CatalogoTramites catram = new CatalogoTramites();
	 			catram.setNombreTramite("Otros");
	 			catram = cattramitesService.consultaTramiteByNombreTramite(catram);
	 			bita.setCatalogoID(catram.getCatalogoID());
	 			bita.setIdempresa(nuevo.getCatalogo_perfilempresa_idcatalogo_perfilempresa());
	 			bita.setIdestablecimiento(nuevo.getCatalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento());
	 			bita.setIdregistro(String.valueOf(nuevo.getIdtramite_otros()));
	 			bita.setTipoBitacora("Tramite");
	 			bitacorasService.inserta(bita);
	 			bean = tramite_otrosService.inserta(nuevo);
	 			bean.setIdTipoTramite(catram.getCatalogoID());
	 		
			return bean;
	 	}
		@RequestMapping(value = "/listacomboTramite_otros", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody List <Tramite_otros> listacomboTramite_otros(@ModelAttribute("tramite_otros") Tramite_otros nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_otrosService.lista(rol);
	 	}
	 	@RequestMapping(value = "/consultaTramite_otros", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody Tramite_otros consultaTramite_otros(@ModelAttribute("tramite_otros") Tramite_otros nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_otrosService.consulta(nuevo, rol);
	 	}
	 	
		/***
		 *  tramite_baja_permisos

		 */
		
		@RequestMapping(value = "/registerTramite_baja_permisos", method = RequestMethod.POST, produces = "application/json")
	 	public @ResponseBody MensajeBean registerTramite_baja_permisos(@ModelAttribute("tramite_baja_permisos") Tramite_baja_permisos nuevo, BindingResult resul,HttpServletRequest request) {
			MensajeBean bean = new MensajeBean();
			
				Date date = new Date();
	 			Bitacoras bita =new  Bitacoras();
	 			bita.setEstatus(nuevo.getEstatus());
	 			bita.setFecha(dateFormat.format(date));
	 			bita.setHora(hourFormat.format(date));
	 			String auxi = request.getSession().getAttribute("usuario_id").toString();
	 			bita.setIdusuario(Integer.parseInt(auxi));
	 			CatalogoTramites catram = new CatalogoTramites();
	 			catram.setNombreTramite("Baja de permisos");
	 			catram = cattramitesService.consultaTramiteByNombreTramite(catram);
	 			bita.setCatalogoID(catram.getCatalogoID());
	 			bita.setIdempresa(nuevo.getCatalogo_perfilempresa_idcatalogo_perfilempresa());
	 			bita.setIdestablecimiento(nuevo.getCatalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento());
	 			bita.setIdregistro(String.valueOf(nuevo.getIdtramite_baja_permisos()));
	 			bita.setTipoBitacora("Tramite");
	 			bitacorasService.inserta(bita);
	 			bean = tramite_baja_permisosService.inserta(nuevo);
	 			bean.setIdTipoTramite(catram.getCatalogoID());
	 		
			return bean;
	 	}
		
		@RequestMapping(value = "/listacomboTramite_baja_permisos", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody List <Tramite_baja_permisos> listacomboTramite_baja_permisos(@ModelAttribute("tramite_baja_permisos") Tramite_baja_permisos nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_baja_permisosService.lista(rol);
	 	}
	 	@RequestMapping(value = "/consultaTramite_baja_permisos", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody Tramite_baja_permisos consultaTramite_baja_permisos(@ModelAttribute("tramite_baja_permisos") Tramite_baja_permisos nuevo, BindingResult resul,HttpServletRequest request) {
			String rol = request.getParameter("rol_usuario");
			return tramite_baja_permisosService.consulta(nuevo, rol);
	 	}
	 	
	 	
/* Agregado por charly*/
	 	
	 	@RequestMapping(value = "/registerTramite_presentan_informacion_impacto", method = RequestMethod.POST, produces = "application/json")
	 	public @ResponseBody MensajeBean registerTramite_presentan_informacion_impacto(@ModelAttribute("tramite_presentan_info_impacto") Tramite_presentan_info_impacto nuevo, BindingResult result, HttpServletRequest request){
	 		MensajeBean msj = new MensajeBean();
	 		Date date = new Date();
	 		Bitacoras bita = new Bitacoras();
	 		bita.setEstatus(nuevo.getEstatus());
	 		bita.setFecha(dateFormat.format(date));
	 		bita.setHora(hourFormat.format(date));
 			String auxi = request.getSession().getAttribute("usuario_id").toString();
 			bita.setIdusuario(Integer.parseInt(auxi));
 			CatalogoTramites catram = new CatalogoTramites();
 			catram.setNombreTramite("Presentan información Impacto");
 			catram = cattramitesService.consultaTramiteByNombreTramite(catram);
 			bita.setCatalogoID(catram.getCatalogoID());
 			bita.setIdempresa(nuevo.getIdempresa());
 			bita.setIdestablecimiento(nuevo.getIdestablecimiento());
 			bita.setIdregistro(String.valueOf(nuevo.getIdtramite_impacto()));
 			bita.setTipoBitacora("Tramite");
 			
 			bitacorasService.inserta(bita);
 			
 			msj = this.tramite_presentan_info_impactoService.inserta(nuevo);
 			msj.setIdTipoTramite(catram.getCatalogoID());
 			System.out.println(nuevo.toString());
	 		return msj;
	 		
	 	}
	 	
	 	
	 	@RequestMapping(value = "/listacomboTramite_presentan_info_impacto", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody List<Tramite_presentan_info_impacto> listacomboTramite_presentan_info_impacto(@ModelAttribute("tramite_presentan_info_impacto") Tramite_presentan_info_impacto nuevo, BindingResult result, HttpServletRequest request){
	 		String rol = request.getParameter("rol_usuario");
	 		return tramite_presentan_info_impactoService.lista(rol);
	 	}
	 	
	 	@RequestMapping(value = "/consultaTramite_presentan_info_impacto", method = RequestMethod.GET, produces = "application/json")
	 	public @ResponseBody Tramite_presentan_info_impacto consultaTramite_presentan_info_impacto(@ModelAttribute("tramite_presentan_info_impacto") Tramite_presentan_info_impacto nuevo, BindingResult result, HttpServletRequest request){
	 		return tramite_presentan_info_impactoService.consulta(nuevo);
	 	}
	 	
	 	@RequestMapping(value = "/registerTramite_presentan_info_residuos", method = RequestMethod.POST, produces = "application/json")
	 	public @ResponseBody MensajeBean registerTramite_presentan_informacion_residuos(@ModelAttribute("tramite_presentan_info_residuos") Tramite_presentan_info_residuos nuevo, BindingResult result, HttpServletRequest request){
	 		MensajeBean bean = new MensajeBean();
	 		Date date = new Date();
	 		Bitacoras bita = new Bitacoras();
	 		bita.setEstatus(nuevo.getEstatus());
	 		bita.setFecha(dateFormat.format(date));
	 		bita.setHora(hourFormat.format(date));
	 		String auxi = request.getSession().getAttribute("usuario_id").toString();
 			bita.setIdusuario(Integer.parseInt(auxi));
 			CatalogoTramites catram = new CatalogoTramites();
 			catram.setNombreTramite("Presentan Información Residuos");
 			catram = cattramitesService.consultaTramiteByNombreTramite(catram);
 			bita.setCatalogoID(catram.getCatalogoID());
 			bita.setIdempresa(nuevo.getIdempresa());
 			bita.setIdestablecimiento(nuevo.getIdestablecimiento());
 			bita.setIdregistro(String.valueOf(nuevo.getIdtramite_residuos()));
 			bita.setTipoBitacora("Tramite");
 			bitacorasService.inserta(bita);
 			bean = tramite_presentan_info_residuosService.inserta(nuevo);
 			bean.setIdTipoTramite(catram.getCatalogoID());
	 		return bean;
	 	}
	 	
	 @RequestMapping(value = "/listacomboTramite_presentan_info_residuos", method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody List<Tramite_presentan_info_residuos> listacomboTramite_presentan_info_residuos(@ModelAttribute("tramite_presentan_info_residuos") Tramite_presentan_info_residuos nuevo, BindingResult result, HttpServletRequest request){
		 String rol = request.getParameter("rol_usuario");
		 return tramite_presentan_info_residuosService.lista(rol);
	 }
	 
	 @RequestMapping(value = "/consultaTramite_presentan_info_residuos", method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody Tramite_presentan_info_residuos consultaTramite_presentan_info_residuos(@ModelAttribute("tramite_presentan_info_residuos") Tramite_presentan_info_residuos nuevo, BindingResult result, HttpServletRequest request){
		 return tramite_presentan_info_residuosService.consulta(nuevo);
	 }
	 
	 @RequestMapping(value = "/registerTramite_pedreras", method = RequestMethod.POST, produces = "application/json")
	 public @ResponseBody MensajeBean registerTramite_pedreras(@ModelAttribute("tramite_pedreras") Tramite_pedreras nuevo, BindingResult result, HttpServletRequest request){
	 		
		 MensajeBean bean = new MensajeBean();
	 		System.out.println(nuevo.toString());
	 		Date date = new Date();
	 		Bitacoras bita = new Bitacoras();
	 		bita.setEstatus(nuevo.getEstatus());
	 		bita.setFecha(dateFormat.format(date));
	 		bita.setHora(hourFormat.format(date));
	 		String auxi = request.getSession().getAttribute("usuario_id").toString();
			bita.setIdusuario(Integer.parseInt(auxi));
			CatalogoTramites catram = new CatalogoTramites();
			catram.setNombreTramite("Pedreras");
			catram = cattramitesService.consultaTramiteByNombreTramite(catram);
			bita.setCatalogoID(catram.getCatalogoID());
			bita.setIdempresa(nuevo.getIdempresa());
			bita.setIdestablecimiento(nuevo.getIdestablecimiento());
			bita.setIdregistro(String.valueOf(nuevo.getIdtramite_pedreras()));
			bita.setTipoBitacora("Tramite");
			bitacorasService.inserta(bita);
			bean = tramite_pedrerasService.inserta(nuevo);
			bean.setIdTipoTramite(catram.getCatalogoID());
			System.out.println(nuevo.toString());
	 		return bean;
	 }
	 
	 @RequestMapping(value="/consultaTramite_pedreras", method= RequestMethod.GET, produces = "application/json")
	 public @ResponseBody Tramite_pedreras consultaTramite_pedreras(@ModelAttribute("tramite_pedreras") Tramite_pedreras nuevo, BindingResult result, HttpServletRequest request){
		 return tramite_pedrerasService.consulta(nuevo);
	 }

	 @RequestMapping(value="/listacomboTramite_pedreras", method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody List<Tramite_pedreras> listacomboTramite_pedreras(@ModelAttribute("tramite_pedreras") Tramite_pedreras nuevo, BindingResult result, HttpServletRequest request){
		 String rol = request.getParameter("rol_usuario");
		 return tramite_pedrerasService.lista(rol); 
	 }

}