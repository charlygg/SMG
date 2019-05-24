package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.MensajeBean;
import com.mkyong.users.dao.CatTramitesDao;
import com.mkyong.users.model.CatalogoTramites;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CatTramitesServiceImpl implements CatTramitesService {
	
	@Autowired
	CatTramitesDao tramitesDao;

	@Override
	public List<CatalogoTramites> searchList() {
		// TODO Auto-generated method stub
		return tramitesDao.searchList();
	}

	public List<CatalogoTramites> searchList(String rol) {
		// TODO Auto-generated method stub
		return tramitesDao.searchList(rol);
	}
	
	@Override
	public MensajeBean actualizaTramite(CatalogoTramites nuevo) {
		return tramitesDao.actualizaTramites(nuevo);
	}

	@Override
	public CatalogoTramites consultaTramite(CatalogoTramites nuevo) {
		return tramitesDao.consultaTramite(nuevo);
	}


	@Override
	public CatalogoTramites consultaTramiteByNombreTramite(
			CatalogoTramites tramite) {
		// TODO Auto-generated method stub
		return tramitesDao.consultaTramiteByNombreTramite(tramite);
	}
}
