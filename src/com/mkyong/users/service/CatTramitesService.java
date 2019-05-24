package com.mkyong.users.service;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.mkyong.users.model.CatalogoTramites;


public interface CatTramitesService {
	public List<CatalogoTramites> searchList();
	public List<CatalogoTramites> searchList(String rol);
	public MensajeBean actualizaTramite(CatalogoTramites nuevo);
	public CatalogoTramites consultaTramite(CatalogoTramites nuevo);
	public CatalogoTramites consultaTramiteByNombreTramite(CatalogoTramites tramite);
}
