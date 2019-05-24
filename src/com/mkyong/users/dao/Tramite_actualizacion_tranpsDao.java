package com.mkyong.users.dao;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.Tramite_actualizacion_tranps;

public interface Tramite_actualizacion_tranpsDao {
	
	public List<Tramite_actualizacion_tranps> busquedaById(Tramite_actualizacion_tranps nuevo);
	public List<Tramite_actualizacion_tranps> lista();
	public List<Tramite_actualizacion_tranps> lista(String rol);
	public MensajeBean inserta(Tramite_actualizacion_tranps nuevo);
	public MensajeBean actualiza(Tramite_actualizacion_tranps nuevo);
	public MensajeBean elimina(Tramite_actualizacion_tranps nuevo);
	public Tramite_actualizacion_tranps consulta(Tramite_actualizacion_tranps nuevo, String rol);
	public List<WrapperTramite> listaTramitesByZona(String municipio,String colonia);

}
