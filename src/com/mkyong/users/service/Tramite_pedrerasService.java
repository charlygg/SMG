package com.mkyong.users.service;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.Tramite_pedreras;

public interface Tramite_pedrerasService {
	
	public List<Tramite_pedreras> busquedaById(Tramite_pedreras nuevo);
	public List<Tramite_pedreras> lista();
	public List<Tramite_pedreras> lista(String rol);
	public MensajeBean inserta(Tramite_pedreras nuevo);
	public MensajeBean actualiza(Tramite_pedreras nuevo);
	public MensajeBean elimina(Tramite_pedreras nuevo);
	public Tramite_pedreras consulta(Tramite_pedreras nuevo);
	public List<WrapperTramite> listaTramitesByZona(String municipio,String colonia);

}
