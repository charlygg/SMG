package com.mkyong.users.service;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.Tramite_impacto_ambiental;

public interface  Tramite_impacto_ambientalService {

	public List<Tramite_impacto_ambiental> lista();
	public List<Tramite_impacto_ambiental> lista(String rol);
	public MensajeBean inserta(Tramite_impacto_ambiental nuevo);
	public MensajeBean actualiza(Tramite_impacto_ambiental nuevo);
	public MensajeBean elimina(Tramite_impacto_ambiental nuevo);
	public Tramite_impacto_ambiental consulta(Tramite_impacto_ambiental nuevo, String rol);
	public List<WrapperTramite> listaTramitesByZona(String municipio,String colonia);
	
}
