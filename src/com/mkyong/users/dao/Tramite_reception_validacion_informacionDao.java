package com.mkyong.users.dao;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.Tramite_reception_validacion_informacion;

public interface Tramite_reception_validacion_informacionDao {

	public List<Tramite_reception_validacion_informacion> lista();
	public List<Tramite_reception_validacion_informacion> lista(String rol);
	public MensajeBean inserta(Tramite_reception_validacion_informacion nuevo);
	public MensajeBean actualiza(Tramite_reception_validacion_informacion nuevo);
	public MensajeBean elimina(Tramite_reception_validacion_informacion nuevo);
	public Tramite_reception_validacion_informacion consulta(Tramite_reception_validacion_informacion nuevo, String rol);
	public List<WrapperTramite> listaTramitesByZona(String municipio,String colonia);
	public List<Tramite_reception_validacion_informacion> busquedaById(Tramite_reception_validacion_informacion nuevo);
}
