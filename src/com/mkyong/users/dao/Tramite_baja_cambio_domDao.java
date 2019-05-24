package com.mkyong.users.dao;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.Tramite_baja_cambio_dom;

public interface Tramite_baja_cambio_domDao {
	
	public List<Tramite_baja_cambio_dom> busquedaById(Tramite_baja_cambio_dom nuevo);
	public List<Tramite_baja_cambio_dom> lista();
	public List<Tramite_baja_cambio_dom> lista(String rol);
	public MensajeBean inserta(Tramite_baja_cambio_dom nuevo);
	public MensajeBean actualiza(Tramite_baja_cambio_dom nuevo);
	public MensajeBean elimina(Tramite_baja_cambio_dom nuevo);
	public Tramite_baja_cambio_dom consulta(Tramite_baja_cambio_dom nuevo, String rol);
	public List<WrapperTramite> listaTramitesByZona(String municipio,String colonia);

}
