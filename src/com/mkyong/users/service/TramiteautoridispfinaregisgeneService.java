package com.mkyong.users.service;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.TramiteAutoriDispFinaRegisGene;


public interface TramiteautoridispfinaregisgeneService {
	public List<TramiteAutoriDispFinaRegisGene> lista(String rol);
	public MensajeBean inserta(TramiteAutoriDispFinaRegisGene nuevo);
	public MensajeBean actualiza(TramiteAutoriDispFinaRegisGene nuevo);
	public MensajeBean elimina(TramiteAutoriDispFinaRegisGene nuevo);
	public TramiteAutoriDispFinaRegisGene consulta(TramiteAutoriDispFinaRegisGene nuevo, String rol);
	public List<WrapperTramite> listaTramitesByZona(String municipio,String colonia);
	public List<TramiteAutoriDispFinaRegisGene> busquedaById(TramiteAutoriDispFinaRegisGene nuevo);
}
