package com.mkyong.users.service;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.Tramite_registro_trans_aguas_reci;

public interface Tramite_registro_trans_aguas_reciService {
	public List<Tramite_registro_trans_aguas_reci> lista(String rol);
	public MensajeBean inserta(Tramite_registro_trans_aguas_reci nuevo);
	public MensajeBean actualiza(Tramite_registro_trans_aguas_reci nuevo);
	public MensajeBean elimina(Tramite_registro_trans_aguas_reci nuevo);
	public Tramite_registro_trans_aguas_reci consulta(Tramite_registro_trans_aguas_reci nuevo, String rol);
	public List<WrapperTramite> listaTramitesByZona(String municipio,String colonia);
}
