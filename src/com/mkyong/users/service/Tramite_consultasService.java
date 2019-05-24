package com.mkyong.users.service;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.Tramite_consultas;
import com.mkyong.users.model.Tramite_modificacion_proyecto;

public interface Tramite_consultasService {
	
	public List<Tramite_consultas> lista();
	public List<Tramite_consultas> lista(String rol);
	public MensajeBean inserta(Tramite_consultas nuevo);
	public MensajeBean actualiza(Tramite_consultas nuevo);
	public MensajeBean elimina(Tramite_consultas nuevo);
	public Tramite_consultas consulta(Tramite_consultas nuevo, String rol);
	public List<WrapperTramite> listaTramitesByZona(String municipio,String colonia);
	public List<Tramite_consultas> busquedaById(Tramite_consultas nuevo);
}
