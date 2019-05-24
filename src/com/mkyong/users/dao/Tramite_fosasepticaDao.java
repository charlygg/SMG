package com.mkyong.users.dao;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.Tramite_fosa_septica;

public  interface Tramite_fosasepticaDao {
	
	public List<Tramite_fosa_septica> lista();
	public List<Tramite_fosa_septica> lista(String rol);
	public MensajeBean inserta(Tramite_fosa_septica nuevo);
	public MensajeBean actualiza(Tramite_fosa_septica nuevo);
	public MensajeBean elimina(Tramite_fosa_septica nuevo);
	public Tramite_fosa_septica consulta(Tramite_fosa_septica nuevo);
	public List<WrapperTramite> listaTramitesByZona(String municipio,String colonia);
}
