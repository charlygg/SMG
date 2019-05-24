package com.mkyong.users.service;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.mkyong.users.model.CatPerfilEmpresa;


public interface PerfilEmpresaService {
	public List<CatPerfilEmpresa> lista();
	public MensajeBean inserta(CatPerfilEmpresa nuevo);
	public MensajeBean actualiza(CatPerfilEmpresa nuevo);
	public MensajeBean elimina(CatPerfilEmpresa nuevo);
	public CatPerfilEmpresa consulta(CatPerfilEmpresa nuevo);
}
