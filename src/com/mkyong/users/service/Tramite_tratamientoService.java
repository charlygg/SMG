package com.mkyong.users.service;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.Descargaaguasr;
import com.mkyong.users.model.Tramite_tratamiento_aguasr;


public interface Tramite_tratamientoService {
	public List<Tramite_tratamiento_aguasr> lista();
	public List<Tramite_tratamiento_aguasr> lista(String rol);
	public MensajeBean inserta(Tramite_tratamiento_aguasr nuevo);
	public MensajeBean actualiza(Tramite_tratamiento_aguasr nuevo);
	public MensajeBean elimina(Tramite_tratamiento_aguasr nuevo);
	public Tramite_tratamiento_aguasr consulta(Tramite_tratamiento_aguasr nuevo);
	public Tramite_tratamiento_aguasr consulta(Tramite_tratamiento_aguasr nuevo,String rol);
	public List<WrapperTramite> listaTramitesByZona(String municipio,String colonia);
	public List<Tramite_tratamiento_aguasr> busquedaById(Tramite_tratamiento_aguasr nuevo);
}
