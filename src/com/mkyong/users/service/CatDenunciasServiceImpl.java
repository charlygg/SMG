package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.MensajeBean;
import com.mkyong.users.dao.CatDenunciasDao;
import com.mkyong.users.model.Area;
import com.mkyong.users.model.CatDenuncias;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CatDenunciasServiceImpl implements  CatDenunciasService{
	
	@Autowired
	CatDenunciasDao catdenunciasDao;

	@Override
	public List<CatDenuncias> searchList(Area area) {
		// TODO Auto-generated method stub
		return catdenunciasDao.searchList(area);
	}

	@Override
	public MensajeBean actualizarCatDenuncias(CatDenuncias nuevo) {
		// TODO Auto-generated method stub
		return catdenunciasDao.actualizarCatDenuncias(nuevo);
		
	}

	@Override
	public CatDenuncias busquedaCatDenuncia(CatDenuncias old) {
		// TODO Auto-generated method stub
		return catdenunciasDao.busquedaCatDenuncia(old);
	}

}
