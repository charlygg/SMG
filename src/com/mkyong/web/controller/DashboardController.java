package com.mkyong.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ixanaui.utils.WrapperTramiteCorrespondencia;
import com.mkyong.users.service.TramiteGenericoService;

@Controller
public class DashboardController {
	
	private Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private TramiteGenericoService tramiteGenericoService;
	
	@RequestMapping(value="/getDashboard", method=RequestMethod.GET)
	public ModelAndView getDashboard(HttpServletRequest request, HttpServletResponse response){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String fechaPruebaInicio = "2016-06-01";
		String fechaPruebaFin = "2016-06-30";
		
		Date fechaI = new Date();
		Date fechaF = new Date();
		try {
			fechaI = sdf.parse(fechaPruebaInicio);
			fechaF = sdf.parse(fechaPruebaFin);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		String area = request.getSession().getAttribute("area_id").toString();
		log.debug("El area que ingresa es " + area);
		List<WrapperTramiteCorrespondencia> listadoTramitesNuevo = new ArrayList<WrapperTramiteCorrespondencia>();
		listadoTramitesNuevo = tramiteGenericoService.listado(Integer.parseInt(area), fechaI, fechaF);
		return new ModelAndView("dashboard/dashboard_recepcion", "listadoTramiteNuevo", listadoTramitesNuevo);
	}
	
	@RequestMapping(value="/getPerfilUsuario", method=RequestMethod.GET)
	public ModelAndView getPerfilUsuario(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("perfil/perfilusuario");
	}

}
