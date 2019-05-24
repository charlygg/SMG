package com.mkyong.users.dao;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.Tramite_UbiOperMaIntSitDisFiProEstTransf;

public  interface Tramite_UbiOperMaIntSitDisFiProEstTransfDao {
	
	public List<Tramite_UbiOperMaIntSitDisFiProEstTransf> lista();
	public MensajeBean inserta(Tramite_UbiOperMaIntSitDisFiProEstTransf nuevo);
	public MensajeBean actualiza(Tramite_UbiOperMaIntSitDisFiProEstTransf nuevo);
	public MensajeBean elimina(Tramite_UbiOperMaIntSitDisFiProEstTransf nuevo);
	
	public Tramite_UbiOperMaIntSitDisFiProEstTransf consulta(Tramite_UbiOperMaIntSitDisFiProEstTransf nuevo, String rol);
	public List<Tramite_UbiOperMaIntSitDisFiProEstTransf> lista(String rol);
	public List<WrapperTramite> listaTramitesByZona(String municipio,String colonia);
	public List<Tramite_UbiOperMaIntSitDisFiProEstTransf> busquedaById(Tramite_UbiOperMaIntSitDisFiProEstTransf nuevo);
}
