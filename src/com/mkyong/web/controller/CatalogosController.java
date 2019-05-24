package com.mkyong.web.controller;

import java.util.List;

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
import com.mkyong.users.model.Area;
import com.mkyong.users.model.CatDenuncias;
import com.mkyong.users.model.CatalogoTramites;
import com.mkyong.users.model.CatPerfilEmpresa;
import com.mkyong.users.model.CatPerfilEstablecimiento;
import com.mkyong.users.model.Municipios;
import com.mkyong.users.service.CatDenunciasService;
import com.mkyong.users.service.CatTramitesService;
import com.mkyong.users.service.PerfilEmpresaService;
import com.mkyong.users.service.PerfilEstablecimientoService;
import com.mkyong.users.service.EstadosService;
import com.mkyong.users.service.MunicipiosService;
import com.mkyong.users.service.AreaService;


@Controller
public class CatalogosController {
	// controladores para tramites 
	
	
	@Autowired
	private CatTramitesService tramiteS;
	
	@Autowired
	private CatDenunciasService catdenunciasService;
	
	
	@Autowired
	private PerfilEmpresaService perfilEmpresaService;
	
	@Autowired
	private PerfilEstablecimientoService perfilEstablecimientoService;
	
	@Autowired
	private EstadosService estadosService;
	
	@Autowired
	private MunicipiosService municipiosService;
	
	@Autowired
	private AreaService areaService;
	
	@RequestMapping(value = { "/CambiosCatTramites" }, method = RequestMethod.GET)
	public ModelAndView cambiosTramites() {
		ModelAndView model = new ModelAndView();
		model.setViewName("catalogo_tramites/CambiosTramites");
		return model;
	}
	
	
	
	@RequestMapping(value = "/getListaTramites", method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody JsonDataWrapper listaTramites(HttpServletRequest request,HttpServletResponse response) {
		List<CatalogoTramites> list = tramiteS.searchList();
		JsonDataWrapper datos = new JsonDataWrapper(0,0,0,list.toArray());
		return datos;
	}
	 
	
	
	 @RequestMapping(value = "/updateTramite", method = RequestMethod.POST, produces = "application/json")
	 public @ResponseBody MensajeBean actualizaTramite(@ModelAttribute("catalogoTramites") CatalogoTramites catalogoTramites, BindingResult resul) {
		 return tramiteS.actualizaTramite(catalogoTramites);
		
	}
	 
	 
	 @RequestMapping(value = "/consultaTramite", method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody CatalogoTramites consultaTramite(@ModelAttribute("catalogoTramites") CatalogoTramites catalogoTramites, BindingResult resul,HttpServletRequest request,HttpServletResponse response) {
		return tramiteS.consultaTramite(catalogoTramites);
 
	}
	 
	/*Controladores del catalago denuncias
	 * 
	 */
	 
	 /*
	  * Muestra la vista de cambios y bajas de denuncias
	  */
	 @RequestMapping(value = { "/CambiosBajasCatDenuncias" }, method = RequestMethod.GET)
		public ModelAndView CambiosBajasCatDenuncias() {

			ModelAndView model = new ModelAndView();
			model.setViewName("admin/RU_cat_denuncias");
			return model;

		}
	 
	 /*
	  * Retorna la lista en json de todos el catalogo de denuncias
	  */
	 @RequestMapping(value = "/getListaCatDenuncias", method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody JsonDataWrapper getListaCatDenunciasJSON(Area area, HttpServletRequest request,HttpServletResponse response) {
//		List<CatDenuncias> list = catdenunciasService.searchList(area);
		 Area aux = new Area();
		 System.out.println("get Area:"+area.getIdareas()+" Role:"+area.getRole());
		 aux = areaService.consultaAreaByRole(area);
		 System.out.println("post Area:"+aux.getIdareas()+" Role:"+aux.getRole());
		 List<CatDenuncias> listaDenuncias = catdenunciasService.searchList(aux);
		JsonDataWrapper datos = new JsonDataWrapper(0,0,0,listaDenuncias.toArray());
		return datos;
	}
	
	/*
	 * Actualiza el elemento del catalogo de denuncias
	 */
	
	 @RequestMapping(value = "/updateCatDenuncias", method = RequestMethod.POST, produces = "application/json")
	 public @ResponseBody MensajeBean updateCatDenuncias(@ModelAttribute("catDenuncias") CatDenuncias catDenuncias, BindingResult result) {
		return catdenunciasService.actualizarCatDenuncias(catDenuncias); 

	}
	 /*
	  * 
	  */
	 @RequestMapping(value = "/busquedaCatDenuncias", method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody CatDenuncias busquedaCatDenuncias(@ModelAttribute("catDenuncias") CatDenuncias catDenuncias, BindingResult resul,HttpServletRequest request,HttpServletResponse response) {
		return catdenunciasService.busquedaCatDenuncia(catDenuncias);
	 }
	 /*
	  * Termina catalogo denuncias
	  */
	 
	 //catalogo perfiles de empresa
	 @RequestMapping(value = { "/altaPerfilEmpresa" }, method = RequestMethod.GET)
		public ModelAndView altaPerfilEmpresa() {
			ModelAndView model = new ModelAndView();
			model.setViewName("catalogo_perfilempresa/altaPerfilEmpresa");
			return model;
	}
	 @RequestMapping(value = { "/cambioPerfilEmpresa" }, method = RequestMethod.GET)
		public ModelAndView cambiosPerfilEmpresa() {
			ModelAndView model = new ModelAndView();
			model.setViewName("catalogo_perfilempresa/cambioPerfilEmpresa");
			return model;
	}
		@RequestMapping(value = "/listaPerfilEmpresa", method = RequestMethod.GET, produces = "application/json")
		 public @ResponseBody JsonDataWrapper listaPerfilEmpresa(HttpServletRequest request,HttpServletResponse response) {
			List<CatPerfilEmpresa> list = perfilEmpresaService.lista();
			JsonDataWrapper datos = new JsonDataWrapper(0,0,0,list.toArray());
			return datos;
		}
		 @RequestMapping(value = "/actualizaPerfilEmpresa", method = RequestMethod.POST, produces = "application/json")
		 public @ResponseBody MensajeBean actualizaPerfilEmpresa(@ModelAttribute("catPerfilEmpresa") CatPerfilEmpresa catPerfilEmpresa, BindingResult resul) {
			 return perfilEmpresaService.actualiza(catPerfilEmpresa);
			
		}
		 @RequestMapping(value = "/insertaPerfilEmpresa", method = RequestMethod.POST, produces = "application/json")
		 public @ResponseBody MensajeBean insertaPerfilEmpresa(@ModelAttribute("catPerfilEmpresa") CatPerfilEmpresa catPerfilEmpresa, BindingResult resul) {
			 return perfilEmpresaService.inserta(catPerfilEmpresa);
			
		}
		 @RequestMapping(value = "/eliminaPerfilEmpresa", method = RequestMethod.GET, produces = "application/json")
		 public @ResponseBody MensajeBean eliminaPerfilEmpresa(@ModelAttribute("catPerfilEmpresa") CatPerfilEmpresa catPerfilEmpresa, BindingResult resul) {
			 return perfilEmpresaService.elimina(catPerfilEmpresa);
			
		}
		 @RequestMapping(value = "/consultaPerfilEmpresa", method = RequestMethod.GET, produces = "application/json")
		 public @ResponseBody CatPerfilEmpresa consultaPerfilEmpresa(@ModelAttribute("catPerfilEmpresa") CatPerfilEmpresa catPerfilEmpresa, BindingResult resul,HttpServletRequest request,HttpServletResponse response) {
			return perfilEmpresaService.consulta(catPerfilEmpresa);
		}
		 
		 //catalogo perfiles de establecimiento
		 @RequestMapping(value = { "/altaPerfilEstablecimiento" }, method = RequestMethod.GET)
			public ModelAndView altaPerfilEstablecimiento() {
				ModelAndView model = new ModelAndView();
				model.addObject("empresas", perfilEmpresaService.lista());
				model.addObject("estados", estadosService.lista());
				model.setViewName("catalogo_perfilestablecimiento/altaPerfilEstablecimiento");
				return model;
		}
		 @RequestMapping(value = { "/cambioPerfilEstablecimiento" }, method = RequestMethod.GET)
			public ModelAndView cambiosPerfilEstablecimiento() {
				ModelAndView model = new ModelAndView();
				model.setViewName("catalogo_perfilestablecimiento/cambioPerfilEstablecimiento");
				return model;
		}	
			@RequestMapping(value = "/listaPerfilEstablecimiento", method = RequestMethod.GET, produces = "application/json")
			 public @ResponseBody JsonDataWrapper listaPerfilEstablecimiento(HttpServletRequest request,HttpServletResponse response) {
				List<CatPerfilEstablecimiento> list = perfilEstablecimientoService.lista();
				JsonDataWrapper datos = new JsonDataWrapper(0,0,0,list.toArray());
				return datos;
			}
			
			@RequestMapping(value = "/listaPerfilEstablecimientoporNombre", method = RequestMethod.GET, produces = "application/json")
			 public @ResponseBody ModelAndView listaPerfilEstablecimientoporNombre(@ModelAttribute("catPerfilEstablecimiento") CatPerfilEstablecimiento catPerfilEstablecimiento, BindingResult resul,HttpServletRequest request,HttpServletResponse response) {
				ModelAndView model = new ModelAndView();
				
				int tipoLista = Integer.parseInt( request.getParameter("tipoLista") == null ? "0":request.getParameter("tipoLista"));
				String tipoRol =  request.getParameter("tipoRol") == null ? "0":request.getParameter("tipoRol");
				String controlID = request.getParameter("controlID");
				String onSelectFn = request.getParameter("onSelectFn");
				System.out.println("\n\n\n"+controlID +"//"+tipoLista+"//"+catPerfilEstablecimiento.getEstado()+catPerfilEstablecimiento.getMunicipio()
//						+"///"+onSelectFn
						+"\n\n\n");
				model.addObject("tipoLista",tipoLista );
				model.addObject("controlID",controlID );
				model.addObject("onSelectFn",onSelectFn );
//				model.addObject("listaResultado", denunciaService.searchList(denuncia,tipoRol));
				model.setViewName("/listaGenerica");
				return model;

			}


			 @RequestMapping(value = "/actualizaPerfilEstablecimiento", method = RequestMethod.POST, produces = "application/json")
			 public @ResponseBody MensajeBean actualizaPerfilEstablecimiento(@ModelAttribute("catPerfilEstablecimiento") CatPerfilEstablecimiento catPerfilEstablecimiento, BindingResult resul) {
				 return perfilEstablecimientoService.actualiza(catPerfilEstablecimiento);
				
			}
			 @RequestMapping(value = "/insertaPerfilEstablecimiento", method = RequestMethod.POST, produces = "application/json")
			 public @ResponseBody MensajeBean insertaPerfilEstablecimiento(@ModelAttribute("catPerfilEstablecimiento") CatPerfilEstablecimiento catPerfilEstablecimiento, BindingResult resul) {
				 return perfilEstablecimientoService.inserta(catPerfilEstablecimiento);
				
			}
			 @RequestMapping(value = "/eliminaPerfilEstablecimiento", method = RequestMethod.GET, produces = "application/json")
			 public @ResponseBody MensajeBean eliminaPerfilEstablecimiento(@ModelAttribute("catPerfilEstablecimiento") CatPerfilEstablecimiento catPerfilEstablecimiento, BindingResult resul) {
				 return perfilEstablecimientoService.elimina(catPerfilEstablecimiento);
				
			}
			 @RequestMapping(value = "/consultaPerfilEstablecimiento", method = RequestMethod.GET, produces = "application/json")
			 public @ResponseBody CatPerfilEstablecimiento consultaPerfilEstablecimiento(@ModelAttribute("catPerfilEstablecimiento") CatPerfilEstablecimiento catPerfilEstablecimiento, BindingResult resul,HttpServletRequest request,HttpServletResponse response) {
				return perfilEstablecimientoService.consulta(catPerfilEstablecimiento);
		 
			}

			 @RequestMapping(value = "/listaMunicipios", method = RequestMethod.GET, produces = "application/json")
			 public @ResponseBody JsonDataWrapper listaMunicipios(@ModelAttribute("municipios") Municipios municipios, HttpServletRequest request,HttpServletResponse response) {
				List<Municipios> list = municipiosService.lista(municipios);
				JsonDataWrapper datos = new JsonDataWrapper(0,0,0,list.toArray());
				return datos;
			}
			 @RequestMapping(value = "/consultaExisteMatrizPEstablecimiento", method = RequestMethod.GET, produces = "application/json")
			 public @ResponseBody MensajeBean consultaExisteMatrizPEstablecimiento(@ModelAttribute("catPerfilEstablecimiento") CatPerfilEstablecimiento catPerfilEstablecimiento, BindingResult resul,HttpServletRequest request,HttpServletResponse response) {
				return perfilEstablecimientoService.consultaMatriz(catPerfilEstablecimiento);
		 
			}
	
}
