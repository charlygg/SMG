package com.mkyong.users.dao;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.Tramite_cambio_razon_social;

public interface Tramite_cambio_razon_socialDao {
	
	public List<Tramite_cambio_razon_social> busquedaById(Tramite_cambio_razon_social nuevo);
	public List<Tramite_cambio_razon_social> lista();
	public List<Tramite_cambio_razon_social> lista(String rol);
	public MensajeBean inserta(Tramite_cambio_razon_social nuevo);
	public MensajeBean actualiza(Tramite_cambio_razon_social nuevo);
	public MensajeBean elimina(Tramite_cambio_razon_social nuevo);
	public Tramite_cambio_razon_social consulta(Tramite_cambio_razon_social nuevo, String rol);
	public List<WrapperTramite> listaTramitesByZona(String municipio,String colonia);

}
