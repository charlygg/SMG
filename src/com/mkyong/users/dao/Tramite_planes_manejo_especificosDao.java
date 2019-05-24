package com.mkyong.users.dao;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.Tramite_planes_manejo_especificos;

public interface Tramite_planes_manejo_especificosDao {

	public List<Tramite_planes_manejo_especificos> lista();
	public List<Tramite_planes_manejo_especificos> lista(String rol);
	public MensajeBean inserta(Tramite_planes_manejo_especificos nuevo);
	public MensajeBean actualiza(Tramite_planes_manejo_especificos nuevo);
	public MensajeBean elimina(Tramite_planes_manejo_especificos nuevo);
	public Tramite_planes_manejo_especificos consulta(Tramite_planes_manejo_especificos nuevo, String rol);
	public List<WrapperTramite> listaTramitesByZona(String municipio,String colonia);
	public List<Tramite_planes_manejo_especificos> busquedaById(Tramite_planes_manejo_especificos nuevo);

}
