package com.mkyong.users.service;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.Tramite_modif_licencia;

public interface Tramite_modif_licenciaService {
	public List<Tramite_modif_licencia> busquedaById(Tramite_modif_licencia nuevo);
	public List<Tramite_modif_licencia> lista();
	public List<Tramite_modif_licencia> lista(String rol);
	public MensajeBean inserta(Tramite_modif_licencia nuevo);
	public MensajeBean actualiza(Tramite_modif_licencia nuevo);
	public MensajeBean elimina(Tramite_modif_licencia nuevo);
	public Tramite_modif_licencia consulta(Tramite_modif_licencia nuevo, String rol);
	public List<WrapperTramite> listaTramitesByZona(String municipio,String colonia);
}
