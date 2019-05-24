package com.mkyong.web.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
import com.ixanaui.utils.DenunciaListBean;
import com.mkyong.users.model.Area;
import com.mkyong.users.model.Denuncia;
import com.mkyong.users.model.Bitacoras;
import com.mkyong.users.model.RolMenu;
import com.mkyong.users.model.Usuario;
import com.mkyong.users.model.CatDenuncias;
import com.mkyong.users.service.CatDenunciasService;
import com.mkyong.users.service.DenunciaService;
import com.mkyong.users.service.EstadosService;
import com.mkyong.users.service.AreaService;
import com.mkyong.users.service.BitacorasService;


@Controller
public class DenunciasController {
	
	@Autowired
	private CatDenunciasService  catdenunciasService;
	
	@Autowired
	private DenunciaService  denunciaService;
	
	@Autowired
	private EstadosService estadosService;
	
	@Autowired
	private AreaService areaService;
	
	@Autowired
	private BitacorasService bitacorasService;


	/*
	 * Muestra el catalogo de la denuncias en forma de vista
	 */
	@RequestMapping(value = { "/showCatalogoDenuncias" }, method = RequestMethod.GET)
	public ModelAndView showCatalogoDenuncias(String role) {
		ModelAndView model = new ModelAndView();
		model.addObject("listestados", estadosService.lista());
		model.setViewName("reception/new_denuncia");
		return model;

	}
	
	 
	 @RequestMapping(value = "/guardaActualizaDenuncia", method = RequestMethod.POST, produces = "application/json")
	 public @ResponseBody MensajeBean guardaActualizaDenuncia(@ModelAttribute("denuncia") Denuncia denuncia,HttpServletRequest request) {
		 int tipoAct = Integer.parseInt( request.getParameter("tipoAct") == null ? "0":request.getParameter("tipoAct"));
		 int tipoTra = Integer.parseInt( request.getParameter("tipoTra") == null ? "0":request.getParameter("tipoTra"));
		 String tipoRol = request.getParameter("tipoRol") == null ? "":request.getParameter("tipoRol");
		 int usuario = Integer.parseInt(request.getParameter("usuario") == null ? "0":request.getParameter("usuario"));
		 MensajeBean mensajeBean = new MensajeBean();
		 mensajeBean.setMensaje("Actualización Exitosa");
		 mensajeBean.setNumero(0);
		 mensajeBean.setReferencia("iddenuncia");
		 
 		Date date = new Date();
		DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Bitacoras bitacoras = new Bitacoras();
		bitacoras.setFecha(dateFormat.format(date));
		bitacoras.setHora(hourFormat.format(date));
		bitacoras.setIdusuario(usuario);
		bitacoras.setIdregistro(Integer.toString(denuncia.getIddenuncia()));
		bitacoras.setTipoBitacora("Denuncia");
		 
		 switch(tipoTra){
		 	case 1:
		 		boolean cosa = false;
		 		if(denuncia.getIddenuncia() == 0){
		 			cosa = true;
		 		}
		 		if(denuncia.getAnonimo() == null)
					denuncia.setAnonimo("off");
		 		
		 		denunciaService.insertDenuncia(denuncia);
		 		System.out.print("roll por parametro "+tipoRol+" roll por bean "+ denuncia.getRolAgrego());
				if(cosa){
					bitacoras.setIdregistro(Integer.toString(denuncia.getIddenuncia()));
					bitacoras.setEstatus(1);
					bitacorasService.inserta(bitacoras);
				}
		 		
				break;
		 	case 2:
				switch(tipoAct){
					case 1:
						if(tipoRol.contentEquals("ROLE_RECEP")){
							//actualiza a recibido
							denunciaService.actualizaEstatusRecibido(denuncia);
							bitacoras.setEstatus(2);
							bitacorasService.inserta(bitacoras);
						}else{
							//actualiza a proceso
							int estatusiguiente = 3;
							switch(denuncia.getEstatus()){
								case 3:
									denunciaService.actualizaEstatusDocumentacion(denuncia);
									estatusiguiente = 4;
									break;
								case 4:
									denunciaService.actualizaEstatusTerminado(denuncia);
									estatusiguiente = 5;
									break;
								
								default:
									denunciaService.actualizaEstatusProceso(denuncia);
									estatusiguiente = 3;
							}
							bitacoras.setEstatus(estatusiguiente);
							bitacorasService.inserta(bitacoras);
						}
						break;
					default:
				}
		 		break;
		 	default:
		 }
		 mensajeBean.setConsecutivo(denuncia.getIddenuncia());
		 return mensajeBean;
	}


	 @RequestMapping(value = "/consultaDenuncia", method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody Denuncia consultaDenuncia(@ModelAttribute("denuncia") Denuncia denuncia, BindingResult resul, HttpServletRequest request) {
		 String tipoRol = request.getParameter("tipoRol") == null ? "":request.getParameter("tipoRol");
		return denunciaService.consultaDenuncia(denuncia, tipoRol);
	}

	 @RequestMapping(value = "/consultaDenunciaSinrol", method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody Denuncia consultaDenunciaSinrol(@ModelAttribute("denuncia") Denuncia denuncia, BindingResult resul, HttpServletRequest request) {
		return denunciaService.consultaDenuncia(denuncia);
	}
	@RequestMapping(value = { "/listaBusquedaDenuncias" }, method = RequestMethod.GET)
	public ModelAndView listaBusquedaDenuncias(
			@ModelAttribute("denuncia") Denuncia denuncia
			, HttpServletRequest request
			) {
		ModelAndView model = new ModelAndView();
		
		int tipoLista = Integer.parseInt( request.getParameter("tipoLista") == null ? "0":request.getParameter("tipoLista"));
		String tipoRol =  request.getParameter("tipoRol") == null ? "0":request.getParameter("tipoRol");
		String controlID = request.getParameter("controlID");
		String onSelectFn = request.getParameter("onSelectFn");
		model.addObject("tipoLista",tipoLista );
		model.addObject("controlID",controlID );
		model.addObject("onSelectFn",onSelectFn );
		model.addObject("listaResultado", denunciaService.searchList(denuncia,tipoRol));
		model.setViewName("/listaGenerica");
		return model;

	}
	
	@RequestMapping(value = { "/busquedaDenuncias" }, method = RequestMethod.GET)
	public ModelAndView busquedaDenuncias( ) {
		ModelAndView model = new ModelAndView();
		model.addObject("listmunicipios", denunciaService.denunciaComboMunicipio().toArray());
		model.setViewName("busquedas/busquedaDenuncia");
		return model;
	}
	
	@RequestMapping(value = "/getDenunciasComboColonia", method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody List <Denuncia> getDenunciasComboColonia(@ModelAttribute("denuncia") Denuncia nuevo, BindingResult resul) {
		return denunciaService.denunciaComboColonia(nuevo);
	}
	
	@RequestMapping(value = "/getDenunciasComboMunicipio", method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody List <Denuncia> getDenunciasComboMunicipio( BindingResult resul) {
		return denunciaService.denunciaComboMunicipio();
	}
	
	
	 @RequestMapping(value = "/getDenunciasList", method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody JsonDataWrapper getDenunciasList(@ModelAttribute("denuncia") Denuncia nuevo,BindingResult resul, HttpServletRequest request,HttpServletResponse response) {
		List<DenunciaListBean> list = new ArrayList<DenunciaListBean>();
		Denuncia auxiliar = new Denuncia();
		DenunciaListBean auxiliarList = new DenunciaListBean();
		CatDenuncias old = new CatDenuncias();
		Iterator <Denuncia> itera = denunciaService.denunciaList(nuevo).iterator();
		while(itera.hasNext()){
			auxiliar = itera.next();
			auxiliarList = new DenunciaListBean();
			auxiliarList.setIddenuncia(auxiliar.getIddenuncia());
			auxiliarList.setNombre(auxiliar.getNombre());
			old.setIdcatalogo_denuncias(auxiliar.getCatalogo_denuncias_idcatalogo_denuncias());
			auxiliarList.setTipo(catdenunciasService.busquedaCatDenuncia(old).getNombre_tramite());
			String dir = "";
			if(!auxiliar.getCalle().isEmpty()){
				dir = "Calle "+auxiliar.getCalle()+",";
			}
			if(!auxiliar.getNumero_ext().isEmpty()){
				dir = dir+" Número exterior "+auxiliar.getNumero_ext()+",";
			}
			if(!auxiliar.getNumero_int().isEmpty()){
				dir = dir+" Número Interior "+auxiliar.getNumero_int()+",";
			}
			if(!auxiliar.getColonia().isEmpty()){
				dir = dir+" Colonia "+auxiliar.getColonia()+",";
			}
			if(!auxiliar.getMunicipio().isEmpty()){
				dir = dir+ " Municipio "+auxiliar.getMunicipio()+",";
			}
			
			auxiliarList.setDireccion(auxiliar.getCalle()+auxiliar.getNumero_ext());
			if(auxiliar.getDescripcion().length()>20){
				auxiliarList.setDescripcion(auxiliar.getDescripcion().substring(0, 17)+"...");
			}else{
				auxiliarList.setDescripcion(auxiliar.getDescripcion());
			}
			list.add(auxiliarList);
		}
		
		
		JsonDataWrapper datos = new JsonDataWrapper(0,0,0,list.toArray());
		return datos;
	}
	 
	 
		@RequestMapping(value = { "/viewDenuncia" }, method = RequestMethod.GET)
		public ModelAndView getDenunciaView(
				@ModelAttribute("denuncia") Denuncia denuncia
				, HttpServletRequest request
				) {
			ModelAndView model = new ModelAndView();
			model.addObject("listdenuncias", catdenunciasService.searchList(null));
			model.addObject("denuncia", denunciaService.consultaDenuncia(denuncia));
			model.setViewName("catalogo_denuncias/view_denuncia");
			return model;

		}

}
