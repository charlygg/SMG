package com.mkyong.users.dao;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.mkyong.users.model.Area;
import com.mkyong.users.model.CatDenuncias;

public interface CatDenunciasDao {
	
	public List<CatDenuncias> searchList(Area area);
	public MensajeBean actualizarCatDenuncias(CatDenuncias nuevo);
	public CatDenuncias busquedaCatDenuncia(CatDenuncias old);

}
