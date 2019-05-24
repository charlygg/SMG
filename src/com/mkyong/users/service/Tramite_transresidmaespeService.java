package com.mkyong.users.service;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.Tramite_transresidmaespe;


public interface Tramite_transresidmaespeService {
	public List<Tramite_transresidmaespe> lista(String rol);
	public MensajeBean inserta(Tramite_transresidmaespe nuevo);
	public MensajeBean actualiza(Tramite_transresidmaespe nuevo);
	public MensajeBean elimina(Tramite_transresidmaespe nuevo);
	public Tramite_transresidmaespe consulta(Tramite_transresidmaespe nuevo, String rol);
	public List<WrapperTramite> listaTramitesByZona(String municipio,String colonia);
	public List<Tramite_transresidmaespe> busquedaById(Tramite_transresidmaespe nuevo);
}
