package com.mkyong.users.dao;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.mkyong.users.model.CatalogoTramites;

public  interface CatTramitesDao {
	
	public List<CatalogoTramites> searchList();
	public List<CatalogoTramites> searchList(String rol);
	public MensajeBean actualizaTramites(CatalogoTramites nuevo);
	public CatalogoTramites consultaTramite(CatalogoTramites nuevo);
	public CatalogoTramites consultaTramiteByNombreTramite(CatalogoTramites tramite);
}

