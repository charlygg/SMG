package com.mkyong.users.dao;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.Tramite_otros;

public interface Tramite_otrosDao {

	public List<Tramite_otros> lista();
	public List<Tramite_otros> lista(String rol);
	public MensajeBean inserta(Tramite_otros nuevo);
	public MensajeBean actualiza(Tramite_otros nuevo);
	public MensajeBean elimina(Tramite_otros nuevo);
	public Tramite_otros consulta(Tramite_otros nuevo, String rol);
	public List<WrapperTramite> listaTramitesByZona(String municipio,String colonia);
	public List<Tramite_otros> busquedaById(Tramite_otros nuevo);
	
}
