package com.mkyong.users.service;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.Descargaaguasr;


public interface DescargaaguasrService {
	public List<Descargaaguasr> lista();
	public List<Descargaaguasr> lista(String rol);
	public MensajeBean inserta(Descargaaguasr nuevo);
	public MensajeBean actualiza(Descargaaguasr nuevo);
	public MensajeBean elimina(Descargaaguasr nuevo);
	public Descargaaguasr consulta(Descargaaguasr nuevo);
	public List<WrapperTramite> listaTramitesByZona(String municipio, String colonia);
	public List<Descargaaguasr> busquedaById(Descargaaguasr nuevo);
}
