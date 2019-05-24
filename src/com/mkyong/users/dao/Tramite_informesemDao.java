package com.mkyong.users.dao;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.Tramite_informesem;

public  interface Tramite_informesemDao {
	
	public List<Tramite_informesem> lista();
	public List<Tramite_informesem> lista(String rol);
	public MensajeBean inserta(Tramite_informesem nuevo);
	public MensajeBean actualiza(Tramite_informesem nuevo);
	public MensajeBean elimina(Tramite_informesem nuevo);
	public Tramite_informesem consulta(Tramite_informesem nuevo);
	public List<WrapperTramite> listaTramitesByZona(String municipio,String colonia);
	
}
