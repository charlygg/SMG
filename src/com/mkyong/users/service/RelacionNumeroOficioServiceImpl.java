package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mkyong.users.dao.RelacionNumeroOficioDao;
import com.mkyong.users.model.RelacionNumeroOficio;


@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class RelacionNumeroOficioServiceImpl implements RelacionNumeroOficioService {
	
	@Autowired
	RelacionNumeroOficioDao relacionNumeroOficioDao;

	@Override
	public void insertRelacionNumeroOficio(RelacionNumeroOficio nuevo) {
		// TODO Auto-generated method stub
		relacionNumeroOficioDao.insertRelacionNumeroOficio(nuevo);
	}

	@Override
	public List<RelacionNumeroOficio> findRelacionNumeroOficioByIdtramiteIdTipoTramite(
			RelacionNumeroOficio busqueda) {
		// TODO Auto-generated method stub
		return relacionNumeroOficioDao.findRelacionNumeroOficioByIdtramiteIdTipoTramite(busqueda);
	}

	@Override
	public List<RelacionNumeroOficio> findRelacionNumeroOficioById(
			RelacionNumeroOficio busqueda) {
		// TODO Auto-generated method stub
		return relacionNumeroOficioDao.findRelacionNumeroOficioById(busqueda);
	}

	
	
}