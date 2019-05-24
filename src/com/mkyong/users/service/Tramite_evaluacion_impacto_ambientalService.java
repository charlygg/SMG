package com.mkyong.users.service;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.Tramite_evaluacion_impacto_ambiental;

public interface Tramite_evaluacion_impacto_ambientalService {

	public List<Tramite_evaluacion_impacto_ambiental> lista();
	public List<Tramite_evaluacion_impacto_ambiental> lista(String rol);
	public MensajeBean inserta(Tramite_evaluacion_impacto_ambiental nuevo);
	public MensajeBean actualiza(Tramite_evaluacion_impacto_ambiental nuevo);
	public MensajeBean elimina(Tramite_evaluacion_impacto_ambiental nuevo);
	public Tramite_evaluacion_impacto_ambiental consulta(Tramite_evaluacion_impacto_ambiental nuevo, String rol);
	public List<WrapperTramite> listaTramitesByZona(String municipio,String colonia);
	public List<Tramite_evaluacion_impacto_ambiental> busquedaById(Tramite_evaluacion_impacto_ambiental nuevo);
}
