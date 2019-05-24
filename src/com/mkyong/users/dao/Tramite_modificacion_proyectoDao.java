package com.mkyong.users.dao;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.Tramite_modificacion_proyecto;

public interface Tramite_modificacion_proyectoDao {

	public List<Tramite_modificacion_proyecto> lista();
	public List<Tramite_modificacion_proyecto> lista(String rol);
	public MensajeBean inserta(Tramite_modificacion_proyecto nuevo);
	public MensajeBean actualiza(Tramite_modificacion_proyecto nuevo);
	public MensajeBean elimina(Tramite_modificacion_proyecto nuevo);
	public Tramite_modificacion_proyecto consulta(Tramite_modificacion_proyecto nuevo, String rol);
	public List<WrapperTramite> listaTramitesByZona(String municipio,String colonia);
	public List<Tramite_modificacion_proyecto> busquedaById(Tramite_modificacion_proyecto nuevo);

}
