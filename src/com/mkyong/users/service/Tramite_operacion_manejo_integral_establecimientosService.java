package com.mkyong.users.service;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.Tramite_operacion_manejo_integral_establecimientos;

public interface Tramite_operacion_manejo_integral_establecimientosService {
	public List<Tramite_operacion_manejo_integral_establecimientos> lista();
	public List<Tramite_operacion_manejo_integral_establecimientos> lista(String rol);
	public MensajeBean inserta(Tramite_operacion_manejo_integral_establecimientos nuevo);
	public MensajeBean actualiza(Tramite_operacion_manejo_integral_establecimientos nuevo);
	public MensajeBean elimina(Tramite_operacion_manejo_integral_establecimientos nuevo);
	public Tramite_operacion_manejo_integral_establecimientos consulta(Tramite_operacion_manejo_integral_establecimientos nuevo, String rol);
	public List<WrapperTramite> listaTramitesByZona(String municipio,String colonia);
	public List<Tramite_operacion_manejo_integral_establecimientos> busquedaById(Tramite_operacion_manejo_integral_establecimientos nuevo);
}
