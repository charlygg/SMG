package com.mkyong.users.dao;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.Tramite_baja_permisos;

public interface Tramite_baja_permisosDao {

	public List<Tramite_baja_permisos> lista();
	public List<Tramite_baja_permisos> lista(String rol);
	public MensajeBean inserta(Tramite_baja_permisos nuevo);
	public MensajeBean actualiza(Tramite_baja_permisos nuevo);
	public MensajeBean elimina(Tramite_baja_permisos nuevo);
	public Tramite_baja_permisos consulta(Tramite_baja_permisos nuevo, String rol);
	public List<WrapperTramite> listaTramitesByZona(String municipio,String colonia);
	public List<Tramite_baja_permisos> busquedaById(Tramite_baja_permisos nuevo);
	
}
