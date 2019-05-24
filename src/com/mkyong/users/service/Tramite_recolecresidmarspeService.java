package com.mkyong.users.service;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.Tramite_recolecresidmaespe;


public interface Tramite_recolecresidmarspeService {
	public List<Tramite_recolecresidmaespe> lista(String rol);
	public MensajeBean inserta(Tramite_recolecresidmaespe nuevo);
	public MensajeBean actualiza(Tramite_recolecresidmaespe nuevo);
	public MensajeBean elimina(Tramite_recolecresidmaespe nuevo);
	public Tramite_recolecresidmaespe consulta(Tramite_recolecresidmaespe nuevo, String rol);
	public List<WrapperTramite> listaTramitesByZona(String municipio,String colonia);
	public List<Tramite_recolecresidmaespe> busquedaById(Tramite_recolecresidmaespe nuevo);
}
