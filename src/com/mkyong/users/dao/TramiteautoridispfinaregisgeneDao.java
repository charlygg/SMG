package com.mkyong.users.dao;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.TramiteAutoriDispFinaRegisGene;

public  interface TramiteautoridispfinaregisgeneDao {
	
	public List<TramiteAutoriDispFinaRegisGene> lista(String rol);
	public MensajeBean inserta(TramiteAutoriDispFinaRegisGene nuevo);
	public MensajeBean actualiza(TramiteAutoriDispFinaRegisGene nuevo);
	public MensajeBean elimina(TramiteAutoriDispFinaRegisGene nuevo);
	public TramiteAutoriDispFinaRegisGene consulta(TramiteAutoriDispFinaRegisGene nuevo, String rol);
	public List<WrapperTramite> listaTramitesByZona(String municipio,String colonia);
	public List<TramiteAutoriDispFinaRegisGene> busquedaById(TramiteAutoriDispFinaRegisGene nuevo);
}
