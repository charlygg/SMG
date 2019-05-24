package com.mkyong.users.service;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.Tramite_presentan_info_residuos;

public interface Tramite_presentan_info_residuosService {
	
	public List<Tramite_presentan_info_residuos> busquedaById(Tramite_presentan_info_residuos nuevo);
	public List<Tramite_presentan_info_residuos> lista();
	public List<Tramite_presentan_info_residuos> lista(String rol);
	public MensajeBean inserta(Tramite_presentan_info_residuos nuevo);
	public MensajeBean actualiza(Tramite_presentan_info_residuos nuevo);
	public MensajeBean elimina(Tramite_presentan_info_residuos nuevo);
	public Tramite_presentan_info_residuos consulta(Tramite_presentan_info_residuos nuevo);
	public List<WrapperTramite> listaTramitesByZona(String municipio, String colonia);

}
