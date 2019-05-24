package com.mkyong.users.service;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.Tramite_cambio_titularidad;

public interface Tramite_cambio_titularidadService {

	public List<Tramite_cambio_titularidad> lista();
	public List<Tramite_cambio_titularidad> lista(String rol);
	public MensajeBean inserta(Tramite_cambio_titularidad nuevo);
	public MensajeBean actualiza(Tramite_cambio_titularidad nuevo);
	public MensajeBean elimina(Tramite_cambio_titularidad nuevo);
	public Tramite_cambio_titularidad consulta(Tramite_cambio_titularidad nuevo, String rol);
	public List<WrapperTramite> listaTramitesByZona(String municipio,String colonia);
	public List<Tramite_cambio_titularidad> busquedaById(Tramite_cambio_titularidad nuevo);
}
