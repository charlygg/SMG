package com.mkyong.users.dao;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.Tramite_quema_cielo_abierto;

public interface Tramite_quema_cielo_abiertoDao {

	public List<Tramite_quema_cielo_abierto> lista();
	public List<Tramite_quema_cielo_abierto> lista(String rol);
	public MensajeBean inserta(Tramite_quema_cielo_abierto nuevo);
	public MensajeBean actualiza(Tramite_quema_cielo_abierto nuevo);
	public MensajeBean elimina(Tramite_quema_cielo_abierto nuevo);
	public Tramite_quema_cielo_abierto consulta(Tramite_quema_cielo_abierto nuevo, String rol);
	public List<WrapperTramite> listaTramitesByZona(String municipio,String colonia);
	public List<Tramite_quema_cielo_abierto> busquedaById(Tramite_quema_cielo_abierto nuevo);
}
