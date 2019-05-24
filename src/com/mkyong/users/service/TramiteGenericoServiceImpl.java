package com.mkyong.users.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.WrapperTramiteCorrespondencia;
import com.mkyong.users.dao.TramiteGenericoDao;
import com.mkyong.users.model.TramiteGenerico;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TramiteGenericoServiceImpl implements TramiteGenericoService{
	
	@Autowired
	TramiteGenericoDao tramiteGenericoDao;

	@Override
	public List<TramiteGenerico> lista(String rol) {
		return tramiteGenericoDao.lista(rol);
	}

	@Override
	public List<WrapperTramiteCorrespondencia> listado(int modo, Date fechaInicio, Date fechaFin) {
		return tramiteGenericoDao.listado(modo, fechaInicio, fechaFin)
				;
	}

}
