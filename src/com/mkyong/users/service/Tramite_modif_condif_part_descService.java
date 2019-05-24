package com.mkyong.users.service;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.Tramite_modif_condif_part_desc;

public interface Tramite_modif_condif_part_descService {
	public List<Tramite_modif_condif_part_desc> busquedaById(Tramite_modif_condif_part_desc nuevo);
	public List<Tramite_modif_condif_part_desc> lista();
	public List<Tramite_modif_condif_part_desc> lista(String rol);
	public MensajeBean inserta(Tramite_modif_condif_part_desc nuevo);
	public MensajeBean actualiza(Tramite_modif_condif_part_desc nuevo);
	public MensajeBean elimina(Tramite_modif_condif_part_desc nuevo);
	public Tramite_modif_condif_part_desc consulta(Tramite_modif_condif_part_desc nuevo, String rol);
	public List<WrapperTramite> listaTramitesByZona(String municipio,String colonia);
}