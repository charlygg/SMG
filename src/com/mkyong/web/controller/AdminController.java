package com.mkyong.web.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.ConcurrencyFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ixanaui.utils.BitacorasListBean;
import com.ixanaui.utils.JsonDataWrapper;
import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.EstatusBitacoraRegistro;
import com.mkyong.users.model.Area;
import com.mkyong.users.model.Bitacoras;
import com.mkyong.users.model.RolMenu;
import com.mkyong.users.model.User;
import com.mkyong.users.model.Usuario;
import com.mkyong.users.model.CatPerfilEmpresa;
import com.mkyong.users.model.CatPerfilEstablecimiento;
import com.mkyong.users.model.CatalogoTramites;
import com.mkyong.users.service.AreaService;
import com.mkyong.users.service.BitacorasService;
import com.mkyong.users.service.MuroService;
import com.mkyong.users.service.RolMenuService;
import com.mkyong.users.service.UserService;
import com.mkyong.users.service.UsuarioService;
import com.mkyong.users.service.PerfilEmpresaService;
import com.mkyong.users.service.PerfilEstablecimientoService;
import com.mkyong.users.service.CatTramitesService;


@Controller
public class AdminController {
	
	@Autowired
	private AreaService areaService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private RolMenuService rolMenuService;
	
	@Autowired
	private MuroService muroService;
	
	@Autowired
	private BitacorasService bitacorasService;
	
	@Autowired
	private PerfilEmpresaService perfilEmpresaService;
	
	@Autowired
	private PerfilEstablecimientoService perfilEstablecimientoService;
	
	@Autowired
	private CatTramitesService catTramitesService;
	
	private EstatusBitacoraRegistro estatusBitacoraRegistro = new EstatusBitacoraRegistro();
	 @RequestMapping(value = "/registerUsuario", method = RequestMethod.POST, produces = "application/json")
	 public @ResponseBody MensajeBean registerUsuario(@ModelAttribute("usuario") Usuario usuario, BindingResult resul) {
		return usuarioService.insertUsuario(usuario);
 
	}
	 @RequestMapping(value = "/updateUsuario", method = RequestMethod.POST, produces = "application/json")
	 public @ResponseBody MensajeBean updateUsuario(@ModelAttribute("usuario") Usuario usuario, BindingResult resul) {
		 MensajeBean nuevo = new MensajeBean();
		 try{
			 nuevo = usuarioService.actualizarUsuario(usuario);
		 }catch(ConcurrencyFailureException e){System.out.println(e.getMessage());
		 	nuevo.setMensaje("Error en la Modificacion de Usuario-Service");
		 	nuevo.setNumero(999);
		 	nuevo.setReferencia("email");
		 }
		return nuevo;
	}
	 @RequestMapping(value = "/deleteUsuario", method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody String deleteUsuario(@ModelAttribute("usuario") Usuario usuario, BindingResult resul) {
		usuarioService.eliminar(usuario);
		return "success";
	}
	 @RequestMapping(value = "/consultaUsuario", method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody Usuario consultaUsuario(@ModelAttribute("usuario") Usuario usuario, BindingResult resul,HttpServletRequest request,HttpServletResponse response) {
		return usuarioService.consultaUsuario(usuario);
 	}
	 @RequestMapping(value = "/registerUser", method = RequestMethod.POST, produces = "application/json")
	 public @ResponseBody String registerUser(@ModelAttribute("user") User user, BindingResult resul) {
		userService.insertUser(user);
		return "success";
 	}
	 @RequestMapping(value = "/updateUser", method = RequestMethod.POST, produces = "application/json")
	 public @ResponseBody String updateUser(@ModelAttribute("user") User user, BindingResult resul) {
		userService.actualizarUser(user);
		return "success";
	}
	 @RequestMapping(value = "/deleteUser", method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody String deleteUser(@ModelAttribute("user") User user, BindingResult resul) {
		userService.eliminar(user);
		return "success";
	}
	 @RequestMapping(value = "/updateArea", method = RequestMethod.POST, produces = "application/json")
	 public @ResponseBody MensajeBean updateArea(@ModelAttribute("area") Area area, BindingResult resul) {
		 return areaService.actualizarArea(area);
	}
	 @RequestMapping(value = "/deleteArea", method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody String deleteArea(@ModelAttribute("area") Area area, BindingResult resul) {
		areaService.elimar(area);
		return "success";
	}
	 
	 @RequestMapping(value = "/getListAreas", method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody JsonDataWrapper getShopInJSON(HttpServletRequest request,HttpServletResponse response) {
		List<Area> list = areaService.searchList();
		JsonDataWrapper datos = new JsonDataWrapper(0,0,0,list.toArray());
		return datos;
	}
	 @RequestMapping(value = "/consultaArea", method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody Area consultaTramite(@ModelAttribute("area") Area area, BindingResult resul,HttpServletRequest request,HttpServletResponse response) {
		return areaService.consultaArea(area);
 	}
	 @RequestMapping(value = "/listaRolMenu", method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody List <RolMenu> getRolMenuLista(@ModelAttribute("rolMenu") RolMenu rolMenu, BindingResult resul) {
		 System.out.println("Controlador"+rolMenu.getRolID());
		return rolMenuService.ListaRolMenuPorRol(rolMenu);
 	}
	 
	 /*
		 * Muestra el muro en pantalla
		 */
		@RequestMapping(value = { "/showMuro" }, method = RequestMethod.GET)
		public ModelAndView generatorNums(HttpServletRequest request,
				HttpServletResponse response) {
			ModelAndView model = new ModelAndView();
			model.addObject("listaMuro", muroService.getDatosMuro());
			model.setViewName("muro");
			return model;

		}
	 
	 @RequestMapping(value = { "/consultaBitacoras" }, method = RequestMethod.GET)
		public ModelAndView consultaBitacora() {
			ModelAndView model = new ModelAndView();
			model.setViewName("admin/Bitacoras");
			return model;
	}	
	 
	 @RequestMapping(value = "/listaBitacora", method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody JsonDataWrapper listaBitacora(HttpServletRequest request,HttpServletResponse response) {
		List<Bitacoras> list = bitacorasService.lista();
		JsonDataWrapper datos = new JsonDataWrapper(0,0,0,list.toArray());
		return datos;
	}
	@RequestMapping(value = "/listaBitacoraporRegistro", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody JsonDataWrapper listaBitacoraporRegistro(@ModelAttribute("bitacoras") Bitacoras bitacoras, HttpServletRequest request,HttpServletResponse response) {
		List<Bitacoras> list = bitacorasService.lista(bitacoras);
		JsonDataWrapper datos = new JsonDataWrapper(0,0,0,list.toArray());
		return datos;
	}
	 
	 @RequestMapping(value = "/consultaBitacora", method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody Bitacoras consultaBitacora(@ModelAttribute("bitacoras") Bitacoras bitacoras, BindingResult resul,HttpServletRequest request,HttpServletResponse response) {
		 System.out.println(bitacoras.getIdbitacoraregistros()+"//"+bitacoras.getFecha()+"//"+bitacoras.getHora()+"//"+bitacoras.getEstatus()+"//"+bitacoras.getIdusuario()+"//"+bitacoras.getIdregistro());
		return bitacorasService.consulta(bitacoras);
	}
	 
	@RequestMapping(value = { "/busquedaBitacora" }, method = RequestMethod.GET)
	public ModelAndView busquedaDenuncias( ) {
		ModelAndView model = new ModelAndView();
		model.addObject("listBitEmpresa", bitacorasService.bitacoraComboEmpresa().toArray());
		model.setViewName("busquedas/busquedaBitacora");
		return model;
	}
	
	@RequestMapping(value = "/getBitacoraComboEstablecimiento", method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody List <BitacorasListBean> getDenunciasComboColonia(@ModelAttribute("bitacoras") Bitacoras nuevo, BindingResult resul) {
		return bitacorasService.bitacoraComboEstablecimiento(nuevo);
	}
	
	@RequestMapping(value = "/getBitacoraComboEmpresa", method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody List <BitacorasListBean> getBitacoraComboEmpresa( BindingResult resul) {
		return bitacorasService.bitacoraComboEmpresa();
	}
	 @RequestMapping(value = "/getbitacoraPorEmpresa", method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody JsonDataWrapper getbitacoraPorEmpresa(@ModelAttribute("bitacoras") Bitacoras nuevo,BindingResult resul, HttpServletRequest request,HttpServletResponse response) {
		List<BitacorasListBean> list = new ArrayList<BitacorasListBean>();
		Bitacoras auxiliar = new Bitacoras();
		BitacorasListBean auxiliarList = new BitacorasListBean();
		Iterator <Bitacoras> itera = bitacorasService.bitacoraPorEmpresa(nuevo).iterator();
		while(itera.hasNext()){
			auxiliar = itera.next();
			auxiliarList = new BitacorasListBean();
			auxiliarList.setIdbitacoraregistros(auxiliar.getIdbitacoraregistros());
			auxiliarList.setFecha(auxiliar.getFecha());
			auxiliarList.setHora(auxiliar.getHora());
			
			CatPerfilEmpresa empresa = new CatPerfilEmpresa();
			empresa.setIdcatalogo_perfilempresa(auxiliar.getIdempresa());
			empresa=perfilEmpresaService.consulta(empresa);
			auxiliarList.setEmpresa(empresa.getNombreEmpresa());
			
			CatPerfilEstablecimiento establecimiento = new CatPerfilEstablecimiento();
			establecimiento.setIdcatalogo_perfilempresa(auxiliar.getIdempresa());
			establecimiento.setIdcatalogo_perfilestablecimiento(auxiliar.getIdestablecimiento());
			establecimiento = perfilEstablecimientoService.consulta(establecimiento);
			auxiliarList.setEstablecimiento(establecimiento.getMunicipio());
			
			EstatusBitacoraRegistro est = new EstatusBitacoraRegistro();
			auxiliarList.setEstatus(est.getNombreEstatus(auxiliar.getEstatus()));
			
			auxiliarList.setRegistro(auxiliar.getIdregistro());
			
			if(auxiliar.getIdusuario() > 0){
				Usuario us = new Usuario();
				us.setIdusuarios(auxiliar.getIdusuario());
				us= usuarioService.consultaUsuario(us);
				auxiliarList.setUsuario(us.getNombre());
			}
			
			CatalogoTramites trami = new CatalogoTramites();
			trami.setCatalogoID(auxiliar.getCatalogoID());
			trami = catTramitesService.consultaTramite(trami);
			auxiliarList.setCatalogo(trami.getNombreTramite());
			auxiliarList.setIdcatalogo(trami.getCatalogoID());
			list.add(auxiliarList);
		}
		
		
		JsonDataWrapper datos = new JsonDataWrapper(0,0,0,list.toArray());
		return datos;
	}
	 
	 @RequestMapping(value = { "/consultaBitacoraCatReg" }, method = RequestMethod.GET)
		public ModelAndView consultaBitacoraCatReg(HttpServletRequest request) {
		 	ModelAndView model = new ModelAndView();
			String idregistro = request.getParameter("idregistro");
		 	String catalogoID = request.getParameter("catalogoID");
			model.addObject("idregistro", idregistro);
			model.addObject("catalogoID", catalogoID);
			model.setViewName("reusables/listaBitacora");
			return model;
	}
	 @RequestMapping(value = "/listConsultaBitacoraCatReg", method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody JsonDataWrapper  listConsultaBitacoraCatReg(HttpServletRequest request) {
		 	String idregistro = request.getParameter("idregistro");
		 	int catalogoID =Integer.parseInt( request.getParameter("catalogoID"));
		 	Bitacoras bitacoras = new Bitacoras();
		 	bitacoras.setCatalogoID(catalogoID);
		 	bitacoras.setIdregistro(idregistro);
		 List<Bitacoras> list = bitacorasService.lista(bitacoras);
		 List<BitacorasListBean> list2 = new ArrayList <BitacorasListBean>();
		 Iterator <Bitacoras> itera = list.iterator(); 
		 while(itera.hasNext()){
			 Bitacoras aux = itera.next();
			 BitacorasListBean aux2 = new BitacorasListBean();
			 Usuario usu = new Usuario();
			 usu.setIdusuarios(aux.getIdusuario());
			 usu = usuarioService.consultaUsuario(usu);
			 
			 aux2.setIdbitacoraregistros(aux.getIdbitacoraregistros());
			 aux2.setFecha(aux.getFecha());
			 aux2.setHora(aux.getHora());
			 aux2.setUsuario(usu.getUsername());
			 aux2.setEstatus(estatusBitacoraRegistro.getNombreEstatus(aux.getEstatus()));
			 list2.add(aux2);
		 }
			
			JsonDataWrapper datos = new JsonDataWrapper(0,0,0,list2.toArray());
			return datos;
	}

		
}
