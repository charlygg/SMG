package com.mkyong.users.service;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.Tramite_informacion;

public interface Tramite_informacionService {

	public List<Tramite_informacion> busquedaById(Tramite_informacion nuevo);
	public List<Tramite_informacion> lista();
	public List<Tramite_informacion> lista(String rol);
	public MensajeBean inserta(Tramite_informacion nuevo);
	public MensajeBean actualiza(Tramite_informacion nuevo);
	public MensajeBean elimina(Tramite_informacion nuevo);
	public Tramite_informacion consulta(Tramite_informacion nuevo, String rol);
	public List<WrapperTramite> listaTramitesByZona(String municipio,String colonia);
}
