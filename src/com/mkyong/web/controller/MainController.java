package com.mkyong.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ixanaui.utils.JsonDataWrapper;
import com.mkyong.users.model.Area;
import com.mkyong.users.model.Usuario;
import com.mkyong.users.service.AreaService;
import com.mkyong.users.service.UserService;
import com.mkyong.users.service.UsuarioService;

@Controller
public class MainController {
	
	Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private AreaService areaService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UsuarioService usuarioService;

	/*@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView defaultPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "SGM");
		model.addObject("message", "This is default page!");
		model.setViewName("hello");
		return model;

	}*/
	
	@RequestMapping(value = { "/AltaUsuarios" }, method = RequestMethod.GET)
	public ModelAndView altaUsuarios() {
		List<Area> list= areaService.searchList();
		ModelAndView model = new ModelAndView();
		model.addObject("roles", list);
		model.setViewName("catalogo_usuario/AltaUsuario");
		return model;

	}
	
	@RequestMapping(value = { "/CambiosBajasUsuarios" }, method = RequestMethod.GET)
	public ModelAndView cambiosBajasUsuarios() {

		ModelAndView model = new ModelAndView();
		model.setViewName("catalogo_usuario/CambiosBajasUsuario");
		return model;

	}
	
	@RequestMapping(value = { "/CambiosBajasAreas" }, method = RequestMethod.GET)
	public ModelAndView cambiosBajasAreas() {

		ModelAndView model = new ModelAndView();
		model.setViewName("catalogo_areas/CambiosBajasAreas");
		return model;

	}
	

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {
		UserDetails userDetails =(UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView model = new ModelAndView();
		Usuario user=usuarioService.findByUserName(userDetails.getUsername());
		model.addObject("nombre", user.getNombre()+" "+user.getApellidoPaterno());
		model.addObject("usuario_id", user.getIdusuarios());
		model.addObject("role", "ROLE_ADMIN");
		model.setViewName("admin");

		return model;

	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ModelAndView userPage(HttpServletRequest request) {

		UserDetails userDetails =(UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView model = new ModelAndView();
		Usuario user=usuarioService.findByUserName(userDetails.getUsername());
		Area area = areaService.consultaAreaByRole(new Area("","",user.getRole()));
		model.addObject("nombre", user.getNombre()+" "+user.getApellidoPaterno());
		model.addObject("usuario_id", user.getIdusuarios());
		model.addObject("area", area.getNombre());
		model.addObject("idareas", area.getIdareas());
		model.addObject("role", user.getRole());
		model.setViewName("user");
		request.getSession().setAttribute("usuario_id",  user.getIdusuarios());
		request.getSession().setAttribute("area_id", area.getIdareas());
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;

	}

	// customize the error message
	private String getErrorMessage(HttpServletRequest request, String key) {

		Exception exception = (Exception) request.getSession().getAttribute(key);

		String error = "";
		if (exception instanceof BadCredentialsException) {
			error = "Invalido el usuario y contraseña";
		} else if (exception instanceof LockedException) {
			error = exception.getMessage();
		} else {
			error = "Invalido el usuario y contraseña";
		}

		return error;
	}

	// for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();

		// check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);

			model.addObject("username", userDetail.getUsername());

		}

		model.setViewName("403");
		return model;

	}

	 @RequestMapping(value = "/usuariosLista", method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody JsonDataWrapper usuariosListaJSON(HttpServletRequest request,HttpServletResponse response) {
		 List<Usuario> list = usuarioService.searchList();
		 JsonDataWrapper datos = new JsonDataWrapper(0,0,0,list.toArray());
		return datos;
 
	}
	 



}