package com.mkyong.web.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ixanaui.utils.MensajeBean;
import com.mkyong.users.model.NumeroOficio;
import com.mkyong.users.model.RelacionNumeroOficio;
import com.mkyong.users.service.NumeroOficioService;
import com.mkyong.users.service.RelacionNumeroOficioService;


@Controller
public class GeneratorController {

	@Autowired
	private NumeroOficioService numeroOficioService;
	
	@Autowired
	private RelacionNumeroOficioService relacionNumeroOficioService;
	
	/*
	 * Muestra pantalla de prueba del uso de generador de numeros de oficio
	 */
	@RequestMapping(value = { "/generatorNums" }, method = RequestMethod.GET)
	public ModelAndView generatorNums() {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin/GeneratorNumsOficio");
		return model;

	}
	
	 /*
	  * Retorno el numero el numero de oficio
	  */
	 @RequestMapping(value = "/getNumsOfics", method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody List<String> getNumsOfics(@ModelAttribute("numerooficio") NumeroOficio numeroOficio, BindingResult resul) {
		 List<String> list = new ArrayList<String>();
		 Calendar fecha = new GregorianCalendar();
		 int anio = fecha.get(Calendar.YEAR);
		 String cadena="";
		 NumeroOficio busqueda= null;
		System.out.println("Generador de numeros de oficio");
		System.out.println(numeroOficio.getTipo());
		System.out.println(numeroOficio.getArea());
		String area= numeroOficio.getArea();
		/// Cuando es una autorizacion 
		if(numeroOficio.getTipo().equals("AUTO")){
			busqueda=numeroOficioService.buscarNumeroOficio(numeroOficio);
			cadena= cadena+String.format("%05d", busqueda.getUltimo_numero());
		}
		else
		{
			numeroOficio.setArea("ALL");
			busqueda=numeroOficioService.buscarNumeroOficio(numeroOficio);
			cadena= cadena+String.format("%05d", busqueda.getUltimo_numero());
			cadena= cadena+"/";
			cadena= cadena+busqueda.getTipo();
			cadena= cadena+"-";
			cadena= cadena+area;
			cadena= cadena+"/";
			cadena= cadena+Integer.toString(anio%100);
		}
			list.add(cadena);
			////
			System.out.println("cadena armada: "+ cadena);
			busqueda.setUltimo_numero(busqueda.getUltimo_numero()+1);
			numeroOficioService.actualizarNumeroOficio(busqueda);
		
		return list;

	}
	 
	 @RequestMapping(value = "/saveNumOficio", method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody MensajeBean saveNumOficio(@ModelAttribute("relacionNumeroOficio") RelacionNumeroOficio relacionNumeroOficio, BindingResult resul) {
		 MensajeBean message = new MensajeBean();
		// 1) create a java calendar instance
		 Calendar calendar = Calendar.getInstance();
		  
		 // 2) get a java.util.Date from the calendar instance.
//		     this date will represent the current instant, or "now".
		 java.util.Date now = calendar.getTime();
		  
		 // 3) a java current time (now) instance
		 java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
		 relacionNumeroOficio.setFecha(currentTimestamp);
		 relacionNumeroOficioService.insertRelacionNumeroOficio(relacionNumeroOficio);
		return message;

	}
	
	 
		/*
		 * Muestra pantalla de prueba del uso de generador de numeros de oficio
		 */
		@RequestMapping(value = { "/historialGenNums" }, method = RequestMethod.GET)
		public ModelAndView historialGenNums(@ModelAttribute("relacionNumeroOficio") RelacionNumeroOficio relacionNumeroOficio, BindingResult resul){
			ModelAndView model = new ModelAndView();
			System.out.println(relacionNumeroOficio.getIdtramite()+"/"+relacionNumeroOficio.getIdtipo_tramite());
			model.addObject("list", relacionNumeroOficioService.findRelacionNumeroOficioByIdtramiteIdTipoTramite(relacionNumeroOficio));
			model.setViewName("formularios_tramites/seccionHistorialNumOficio");
			return model;

		}
	
		 @RequestMapping(value = "/invalidaNumero", method = RequestMethod.GET)
		 public ModelAndView invalidaNumero(@ModelAttribute("relacionNumeroOficio") RelacionNumeroOficio relacionNumeroOficio, BindingResult resul) {
			 ModelAndView model = new ModelAndView();
			 System.out.println("idnumeroRelacionNumeroOficio"+relacionNumeroOficio.getIdrelacion_numeros_oficio());
			 RelacionNumeroOficio data = relacionNumeroOficioService.findRelacionNumeroOficioById(relacionNumeroOficio).get(0);
			 data.setEstado("invalido");
			 relacionNumeroOficioService.insertRelacionNumeroOficio(data);
				model.addObject("list", relacionNumeroOficioService.findRelacionNumeroOficioByIdtramiteIdTipoTramite(data));
				model.setViewName("formularios_tramites/seccionHistorialNumOficio");
			return model;

		}
}
