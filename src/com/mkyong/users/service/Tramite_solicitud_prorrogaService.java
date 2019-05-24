package com.mkyong.users.service;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.Tramite_solicitud_prorroga;

public interface Tramite_solicitud_prorrogaService {

	public List<Tramite_solicitud_prorroga> lista();
	public List<Tramite_solicitud_prorroga> lista(String rol);
	public MensajeBean inserta(Tramite_solicitud_prorroga nuevo);
	public MensajeBean actualiza(Tramite_solicitud_prorroga nuevo);
	public MensajeBean elimina(Tramite_solicitud_prorroga nuevo);
	public Tramite_solicitud_prorroga consulta(Tramite_solicitud_prorroga nuevo, String rol);
	public List<WrapperTramite> listaTramitesByZona(String municipio,String colonia);
	public List<Tramite_solicitud_prorroga> busquedaById(Tramite_solicitud_prorroga nuevo);
}
