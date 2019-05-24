package com.mkyong.users.service;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.Tramite_presentan_info_impacto;

public interface Tramite_presentan_info_impactoService {
	
	public List<Tramite_presentan_info_impacto> busquedaById(Tramite_presentan_info_impacto nuevo);
	public List<Tramite_presentan_info_impacto> lista();
	public List<Tramite_presentan_info_impacto> lista(String rol);
	public MensajeBean inserta(Tramite_presentan_info_impacto nuevo);
	public MensajeBean actualiza(Tramite_presentan_info_impacto nuevo);
	public MensajeBean elimina(Tramite_presentan_info_impacto nuevo);
	public Tramite_presentan_info_impacto consulta(Tramite_presentan_info_impacto nuevo);
	public List<WrapperTramite> listaTramitesByZona(String municipio, String colonia);

}
