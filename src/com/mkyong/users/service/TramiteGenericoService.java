package com.mkyong.users.service;

import java.util.Date;
import java.util.List;

import com.ixanaui.utils.WrapperTramiteCorrespondencia;
import com.mkyong.users.model.TramiteGenerico;

public interface TramiteGenericoService {
	public List<TramiteGenerico> lista(String rol);
	public List<WrapperTramiteCorrespondencia> listado(int modo, Date fechaInicio, Date fechaFin);
}
