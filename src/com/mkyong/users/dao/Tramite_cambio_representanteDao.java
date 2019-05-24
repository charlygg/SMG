package com.mkyong.users.dao;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.Tramite_cambio_representante;

public interface Tramite_cambio_representanteDao {

	public List<Tramite_cambio_representante> lista();
	public List<Tramite_cambio_representante> lista(String rol);
	public MensajeBean inserta(Tramite_cambio_representante nuevo);
	public MensajeBean actualiza(Tramite_cambio_representante nuevo);
	public MensajeBean elimina(Tramite_cambio_representante nuevo);
	public Tramite_cambio_representante consulta(Tramite_cambio_representante nuevo, String rol);
	public List<WrapperTramite> listaTramitesByZona(String municipio,String colonia);
	public List<Tramite_cambio_representante> busquedaById(Tramite_cambio_representante nuevo);
	
}
