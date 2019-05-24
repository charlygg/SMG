package com.mkyong.users.dao;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.Tramite_ubiopermaintrellsaniconfnormofimex;

public  interface Tramite_ubiopermaintrellsaniconfnormofimexDao {
	
	public List<Tramite_ubiopermaintrellsaniconfnormofimex> lista();
	public List<Tramite_ubiopermaintrellsaniconfnormofimex> lista(String rol);
	public MensajeBean inserta(Tramite_ubiopermaintrellsaniconfnormofimex nuevo);
	public MensajeBean actualiza(Tramite_ubiopermaintrellsaniconfnormofimex nuevo);
	public MensajeBean elimina(Tramite_ubiopermaintrellsaniconfnormofimex nuevo);
	public Tramite_ubiopermaintrellsaniconfnormofimex consulta(Tramite_ubiopermaintrellsaniconfnormofimex nuevo, String rol);
	public List<WrapperTramite> listaTramitesByZona(String municipio,String colonia);
	public List<Tramite_ubiopermaintrellsaniconfnormofimex> busquedaById(Tramite_ubiopermaintrellsaniconfnormofimex nuevo);
}
