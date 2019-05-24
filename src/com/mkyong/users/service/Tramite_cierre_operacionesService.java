package com.mkyong.users.service;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.Tramite_cierre_operaciones;

public interface Tramite_cierre_operacionesService {

	public List<Tramite_cierre_operaciones> lista();
	public List<Tramite_cierre_operaciones> lista(String rol);
	public MensajeBean inserta(Tramite_cierre_operaciones nuevo);
	public MensajeBean actualiza(Tramite_cierre_operaciones nuevo);
	public MensajeBean elimina(Tramite_cierre_operaciones nuevo);
	public Tramite_cierre_operaciones consulta(Tramite_cierre_operaciones nuevo, String rol);
	public List<WrapperTramite> listaTramitesByZona(String municipio,String colonia);
	public List<Tramite_cierre_operaciones> busquedaById(Tramite_cierre_operaciones nuevo);
}
