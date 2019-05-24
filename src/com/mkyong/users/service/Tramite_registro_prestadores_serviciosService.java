package com.mkyong.users.service;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.Tramite_registro_prestadores_servicios;

public interface Tramite_registro_prestadores_serviciosService {
	
	public List<Tramite_registro_prestadores_servicios> lista();
	public List<Tramite_registro_prestadores_servicios> lista(String rol);
	public MensajeBean inserta(Tramite_registro_prestadores_servicios nuevo);
	public MensajeBean actualiza(Tramite_registro_prestadores_servicios nuevo);
	public MensajeBean elimina(Tramite_registro_prestadores_servicios nuevo);
	public Tramite_registro_prestadores_servicios consulta(Tramite_registro_prestadores_servicios nuevo, String rol);
	public List<WrapperTramite> listaTramitesByZona(String municipio,String colonia);
	public List<Tramite_registro_prestadores_servicios> busquedaById(Tramite_registro_prestadores_servicios nuevo);

}
