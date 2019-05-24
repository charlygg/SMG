package com.mkyong.users.service;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.mkyong.users.model.Area;
import com.mkyong.users.model.CatDenuncias;

public interface CatDenunciasService {
	
	public List<CatDenuncias> searchList(Area area);
	public MensajeBean actualizarCatDenuncias(CatDenuncias nuevo);
	public CatDenuncias busquedaCatDenuncia(CatDenuncias old);

}
