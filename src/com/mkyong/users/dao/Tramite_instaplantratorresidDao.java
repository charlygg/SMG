package com.mkyong.users.dao;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.Tramite_InstaPlanTraTorResid;

public  interface Tramite_instaplantratorresidDao {
	
	public List<Tramite_InstaPlanTraTorResid> lista();
	public MensajeBean inserta(Tramite_InstaPlanTraTorResid nuevo);
	public MensajeBean actualiza(Tramite_InstaPlanTraTorResid nuevo);
	public MensajeBean elimina(Tramite_InstaPlanTraTorResid nuevo);
	
	public Tramite_InstaPlanTraTorResid consulta(Tramite_InstaPlanTraTorResid nuevo, String rol);
	public List<Tramite_InstaPlanTraTorResid> lista(String rol);
	public List<WrapperTramite> listaTramitesByZona(String municipio,String colonia);
	public List<Tramite_InstaPlanTraTorResid> busquedaById(Tramite_InstaPlanTraTorResid nuevo);
}
