package com.mkyong.users.service;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.CatPerfilEstablecimiento;


public interface PerfilEstablecimientoService {
	public List<CatPerfilEstablecimiento> lista();
	public MensajeBean inserta(CatPerfilEstablecimiento nuevo);
	public MensajeBean actualiza(CatPerfilEstablecimiento nuevo);
	public MensajeBean elimina(CatPerfilEstablecimiento nuevo);
	public CatPerfilEstablecimiento consulta(CatPerfilEstablecimiento nuevo);
	public List<CatPerfilEstablecimiento> consultaListByEmpresa( CatPerfilEstablecimiento nuevo);
	public MensajeBean consultaMatriz(CatPerfilEstablecimiento nuevo);
	public List<String> getMunicipiosEstablecimientos();
	public List<String> getColoniasPorMunicipios(String municipio);
}
