package com.mkyong.users.dao;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.mkyong.users.model.CatPerfilEmpresa;

public  interface PerfilEmpresaDao {
	
	public List<CatPerfilEmpresa> lista();
//	public List<CatPerfilEmpresa> lista(CatPerfilEmpresa nuevo);
	public MensajeBean inserta(CatPerfilEmpresa nuevo);
	public MensajeBean actualiza(CatPerfilEmpresa nuevo);
	public MensajeBean elimina(CatPerfilEmpresa nuevo);
	public CatPerfilEmpresa consulta(CatPerfilEmpresa nuevo);

}
