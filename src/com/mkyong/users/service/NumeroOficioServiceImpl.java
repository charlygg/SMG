package com.mkyong.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.MensajeBean;
import com.mkyong.users.dao.NumeroOficioDao;
import com.mkyong.users.model.NumeroOficio;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class NumeroOficioServiceImpl implements NumeroOficioService  {

	@Autowired
	NumeroOficioDao numeroOficioDao;

	@Override
	public MensajeBean actualizarNumeroOficio(NumeroOficio data) {
		// TODO Auto-generated method stub
		return numeroOficioDao.actualizarNumeroOficio(data);
	}

	@Override
	public NumeroOficio buscarNumeroOficio(NumeroOficio data) {
		// TODO Auto-generated method stub
		return numeroOficioDao.buscarNumeroOficio(data);
	}
	
}
