package com.mkyong.users.dao;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.Tramite_solicitud_copias;

public interface Tramite_solicitud_copiasDao {

	public List<Tramite_solicitud_copias> lista();
	public List<Tramite_solicitud_copias> lista(String rol);
	public MensajeBean inserta(Tramite_solicitud_copias nuevo);
	public MensajeBean actualiza(Tramite_solicitud_copias nuevo);
	public MensajeBean elimina(Tramite_solicitud_copias nuevo);
	public Tramite_solicitud_copias consulta(Tramite_solicitud_copias nuevo, String rol);
	public List<WrapperTramite> listaTramitesByZona(String municipio,String colonia);
	public List<Tramite_solicitud_copias> busquedaById(Tramite_solicitud_copias nuevo);
}
