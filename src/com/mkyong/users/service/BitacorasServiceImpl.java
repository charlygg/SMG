package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.BitacorasListBean;
import com.ixanaui.utils.MensajeBean;
import com.mkyong.users.dao.BitacorasDao;
import com.mkyong.users.model.Bitacoras;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class BitacorasServiceImpl implements BitacorasService {
	
	@Autowired
	BitacorasDao bitacorasDao;

	@Override
	public List<Bitacoras> lista() {
		// TODO Auto-generated method stub
		return bitacorasDao.lista();
	}

	@Override
	public List<Bitacoras> lista(Bitacoras nuevo) {
		// TODO Auto-generated method stub
		return bitacorasDao.lista(nuevo);
	}
	
	@Override
	public List<BitacorasListBean> bitacoraComboEmpresa( ) {
		// TODO Auto-generated method stub
		return bitacorasDao.bitacoraComboEmpresa();
	}
	
	@Override
	public List<BitacorasListBean> bitacoraComboEstablecimiento(Bitacoras nuevo) {
		// TODO Auto-generated method stub
		return bitacorasDao.bitacoraComboEstablecimiento(nuevo);
	}
	
	@Override
	public List<Bitacoras> bitacoraPorEmpresa(Bitacoras nuevo) {
		// TODO Auto-generated method stub
		return bitacorasDao.bitacoraPorEmpresa(nuevo);
	}
	
	@Override
	public MensajeBean inserta(Bitacoras nuevo) {
		// TODO Auto-generated method stub
		return bitacorasDao.inserta(nuevo);
	}

	@Override
	public MensajeBean actualiza(Bitacoras nuevo) {
		// TODO Auto-generated method stub
		return bitacorasDao.actualiza(nuevo);
	}

	@Override
	public MensajeBean elimina(Bitacoras nuevo) {
		// TODO Auto-generated method stub
		return bitacorasDao.elimina(nuevo);
	}

	@Override
	public Bitacoras consulta(Bitacoras nuevo) {
		return bitacorasDao.consulta(nuevo);
	}
}
