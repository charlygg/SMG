package com.mkyong.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ixanaui.comunication.HiloEmail;

@Controller
public class EmailController {
	
	 
	 @RequestMapping(value = "/sendEmailExample", method = RequestMethod.GET, produces = "application/json")
	 public ModelAndView sendEmailExample(HttpServletRequest request,HttpServletResponse response) {
		HiloEmail correo = new HiloEmail("hola",request.getParameter("correo"),"Prueba SGM");
		correo.run();
		ModelAndView model = new ModelAndView();
		model.setViewName("vacio");
		return model;
	}
	 
	
	 @RequestMapping(value = "/showEmailExample", method = RequestMethod.GET, produces = "application/json")
	 public ModelAndView showEmailExample() {
		ModelAndView model = new ModelAndView();
		model.setViewName("pruebaCorreo");
		return model;
	}

}
