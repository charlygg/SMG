package com.mkyong.users.service;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.Tramite_operacion_vehi_recolectores;

public interface Tramite_operacion_vehi_recolectoresService {

	public List<Tramite_operacion_vehi_recolectores> lista();
	public List<Tramite_operacion_vehi_recolectores> lista(String rol);
	public MensajeBean inserta(Tramite_operacion_vehi_recolectores nuevo);
	public MensajeBean actualiza(Tramite_operacion_vehi_recolectores nuevo);
	public MensajeBean elimina(Tramite_operacion_vehi_recolectores nuevo);
	public Tramite_operacion_vehi_recolectores consulta(Tramite_operacion_vehi_recolectores nuevo, String rol);
	public List<WrapperTramite> listaTramitesByZona(String municipio,String colonia);
	public List<Tramite_operacion_vehi_recolectores> busquedaById(Tramite_operacion_vehi_recolectores nuevo);
}
