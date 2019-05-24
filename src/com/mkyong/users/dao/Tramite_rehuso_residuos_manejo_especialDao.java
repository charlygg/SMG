package com.mkyong.users.dao;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.Tramite_rehuso_residuos_manejo_especial;

public interface Tramite_rehuso_residuos_manejo_especialDao {

	public List<Tramite_rehuso_residuos_manejo_especial> lista();
	public List<Tramite_rehuso_residuos_manejo_especial> lista(String rol);
	public MensajeBean inserta(Tramite_rehuso_residuos_manejo_especial nuevo);
	public MensajeBean actualiza(Tramite_rehuso_residuos_manejo_especial nuevo);
	public MensajeBean elimina(Tramite_rehuso_residuos_manejo_especial nuevo);
	public Tramite_rehuso_residuos_manejo_especial consulta(Tramite_rehuso_residuos_manejo_especial nuevo, String rol);
	public List<WrapperTramite> listaTramitesByZona(String municipio,String colonia);
	public List<Tramite_rehuso_residuos_manejo_especial> busquedaById(Tramite_rehuso_residuos_manejo_especial nuevo);
	
}
