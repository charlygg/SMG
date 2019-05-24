package com.mkyong.users.service;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.Tramite_actualizacion_situa_partdes;

public interface Tramite_actualizacion_situa_partdesService {
	
	public List<Tramite_actualizacion_situa_partdes> busquedaById(Tramite_actualizacion_situa_partdes nuevo);
	public List<Tramite_actualizacion_situa_partdes> lista();
	public List<Tramite_actualizacion_situa_partdes> lista(String rol);
	public MensajeBean inserta(Tramite_actualizacion_situa_partdes nuevo);
	public MensajeBean actualiza(Tramite_actualizacion_situa_partdes nuevo);
	public MensajeBean elimina(Tramite_actualizacion_situa_partdes nuevo);
	public Tramite_actualizacion_situa_partdes consulta(Tramite_actualizacion_situa_partdes nuevo, String rol);
	public List<WrapperTramite> listaTramitesByZona(String municipio,String colonia);
	
}