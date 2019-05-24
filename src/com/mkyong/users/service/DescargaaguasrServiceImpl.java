package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.dao.DescargaaguasrDao;
import com.mkyong.users.model.Descargaaguasr;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DescargaaguasrServiceImpl implements DescargaaguasrService {
	
	@Autowired
	DescargaaguasrDao descargaaguasrDao;

	@Override
	public List<Descargaaguasr> lista() {
		// TODO Auto-generated method stub
		return descargaaguasrDao.lista();
	}

	@Override
	public List<Descargaaguasr> lista(String rol) {
		// TODO Auto-generated method stub
		return descargaaguasrDao.lista(rol);
	}

	@Override
	public MensajeBean inserta(Descargaaguasr nuevo) {
		// TODO Auto-generated method stub
		return descargaaguasrDao.inserta(nuevo);
	}

	@Override
	public MensajeBean actualiza(Descargaaguasr nuevo) {
		// TODO Auto-generated method stub
		return descargaaguasrDao.actualiza(nuevo);
	}

	@Override
	public MensajeBean elimina(Descargaaguasr nuevo) {
		// TODO Auto-generated method stub
		return descargaaguasrDao.elimina(nuevo);
	}

	@Override
	public Descargaaguasr consulta(Descargaaguasr nuevo) {
		return descargaaguasrDao.consulta(nuevo);
	}

	@Override
	public List<WrapperTramite> listaTramitesByZona(String municipio,
			String colonia) {
		// TODO Auto-generated method stub
		return descargaaguasrDao.listaTramitesByZona(municipio, colonia);
	}

	@Override
	public List<Descargaaguasr> busquedaById(Descargaaguasr nuevo) {
		// TODO Auto-generated method stub
		return descargaaguasrDao.busquedaById(nuevo);
	}
}
