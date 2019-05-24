package com.mkyong.users.service;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.Tramite_UbiOperMaIntEscSitDisFiResidProCons;


public interface Tramite_UbiOperMaIntEscSitDisFiResidProConsService {
	public List<Tramite_UbiOperMaIntEscSitDisFiResidProCons> lista(String rol);
	public MensajeBean inserta(Tramite_UbiOperMaIntEscSitDisFiResidProCons nuevo);
	public MensajeBean actualiza(Tramite_UbiOperMaIntEscSitDisFiResidProCons nuevo);
	public MensajeBean elimina(Tramite_UbiOperMaIntEscSitDisFiResidProCons nuevo);
	public Tramite_UbiOperMaIntEscSitDisFiResidProCons consulta(Tramite_UbiOperMaIntEscSitDisFiResidProCons nuevo, String rol);
	public List<WrapperTramite> listaTramitesByZona(String municipio,String colonia);
	public List<Tramite_UbiOperMaIntEscSitDisFiResidProCons> busquedaById(Tramite_UbiOperMaIntEscSitDisFiResidProCons nuevo);
}
