package com.mkyong.users.dao;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.Tramite_reciclaje_residuos_manejo_especial;

public interface Tramite_reciclaje_residuos_manejo_especialDao {

	public List<Tramite_reciclaje_residuos_manejo_especial> lista();
	public List<Tramite_reciclaje_residuos_manejo_especial> lista(String rol);
	public MensajeBean inserta(Tramite_reciclaje_residuos_manejo_especial nuevo);
	public MensajeBean actualiza(Tramite_reciclaje_residuos_manejo_especial nuevo);
	public MensajeBean elimina(Tramite_reciclaje_residuos_manejo_especial nuevo);
	public Tramite_reciclaje_residuos_manejo_especial consulta(Tramite_reciclaje_residuos_manejo_especial nuevo, String rol);
	public List<WrapperTramite> listaTramitesByZona(String municipio,String colonia);
	public List<Tramite_reciclaje_residuos_manejo_especial> busquedaById(Tramite_reciclaje_residuos_manejo_especial nuevo);
}
