package com.mkyong.users.dao;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.Tramite_operacion_manejo_integral_centros;

public interface Tramite_operacion_manejo_integral_centrosDao {
	
	public List<Tramite_operacion_manejo_integral_centros> lista();
	public List<Tramite_operacion_manejo_integral_centros> lista(String rol);
	public MensajeBean inserta(Tramite_operacion_manejo_integral_centros nuevo);
	public MensajeBean actualiza(Tramite_operacion_manejo_integral_centros nuevo);
	public MensajeBean elimina(Tramite_operacion_manejo_integral_centros nuevo);
	public Tramite_operacion_manejo_integral_centros consulta(Tramite_operacion_manejo_integral_centros nuevo, String rol);
	public List<WrapperTramite> listaTramitesByZona(String municipio,String colonia);
	public List<Tramite_operacion_manejo_integral_centros> busquedaById(Tramite_operacion_manejo_integral_centros nuevo);


}
