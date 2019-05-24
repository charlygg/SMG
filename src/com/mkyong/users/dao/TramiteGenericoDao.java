package com.mkyong.users.dao;

import java.util.Date;
import java.util.List;

import com.ixanaui.utils.WrapperTramiteCorrespondencia;
import com.mkyong.users.model.TramiteGenerico;

public interface TramiteGenericoDao {
	
	public List<TramiteGenerico> lista(String rol);
	public List<WrapperTramiteCorrespondencia> listado(int modo, Date fechaInicio, Date fechaFin);

}
