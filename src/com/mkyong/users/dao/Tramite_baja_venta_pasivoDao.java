package com.mkyong.users.dao;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.Tramite_baja_venta_pasivo;


public interface Tramite_baja_venta_pasivoDao {
	
	public List<Tramite_baja_venta_pasivo> busquedaById(Tramite_baja_venta_pasivo nuevo);
	public List<Tramite_baja_venta_pasivo> lista();
	public List<Tramite_baja_venta_pasivo> lista(String rol);
	public MensajeBean inserta(Tramite_baja_venta_pasivo nuevo);
	public MensajeBean actualiza(Tramite_baja_venta_pasivo nuevo);
	public MensajeBean elimina(Tramite_baja_venta_pasivo nuevo);
	public Tramite_baja_venta_pasivo consulta(Tramite_baja_venta_pasivo nuevo, String rol);
	public List<WrapperTramite> listaTramitesByZona(String municipio,String colonia);

}