package com.mkyong.users.dao;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.Tramite_licencia_funcionamiento;

public interface Tramite_licencia_funcionamientoDao {

	public List<Tramite_licencia_funcionamiento> lista();
	public List<Tramite_licencia_funcionamiento> lista(String rol);
	public MensajeBean inserta(Tramite_licencia_funcionamiento nuevo);
	public MensajeBean actualiza(Tramite_licencia_funcionamiento nuevo);
	public MensajeBean elimina(Tramite_licencia_funcionamiento nuevo);
	public Tramite_licencia_funcionamiento consulta(Tramite_licencia_funcionamiento nuevo, String rol);
	public List<WrapperTramite> listaTramitesByZona(String municipio,String colonia);
	public List<Tramite_licencia_funcionamiento> busquedaById(Tramite_licencia_funcionamiento nuevo);
}
