package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.dao.Tramite_cambio_razon_socialDao;
import com.mkyong.users.model.Tramite_cambio_razon_social;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class Tramite_cambio_razon_socialServiceImpl implements Tramite_cambio_razon_socialService {
	
	@Autowired
	Tramite_cambio_razon_socialDao tramite_cambio_razon_socialDao;

	

	@Override
	public List<WrapperTramite> listaTramitesByZona(String municipio,
			String colonia) {
		// TODO Auto-generated method stub
		return tramite_cambio_razon_socialDao.listaTramitesByZona(municipio, colonia);
	}



	@Override
	public List<Tramite_cambio_razon_social> lista() {
		// TODO Auto-generated method stub
		return tramite_cambio_razon_socialDao.lista();
	}



	@Override
	public List<Tramite_cambio_razon_social> lista(String rol) {
		// TODO Auto-generated method stub
		return tramite_cambio_razon_socialDao.lista(rol);
	}



	@Override
	public MensajeBean inserta(Tramite_cambio_razon_social nuevo) {
		// TODO Auto-generated method stub
		return tramite_cambio_razon_socialDao.inserta(nuevo);
	}



	@Override
	public MensajeBean actualiza(Tramite_cambio_razon_social nuevo) {
		// TODO Auto-generated method stub
		return tramite_cambio_razon_socialDao.actualiza(nuevo);
	}



	@Override
	public MensajeBean elimina(Tramite_cambio_razon_social nuevo) {
		// TODO Auto-generated method stub
		return tramite_cambio_razon_socialDao.elimina(nuevo);
	}



	@Override
	public Tramite_cambio_razon_social consulta(
			Tramite_cambio_razon_social nuevo, String rol) {
		// TODO Auto-generated method stub
		return tramite_cambio_razon_socialDao.consulta(nuevo, rol);
	}



	@Override
	public List<Tramite_cambio_razon_social> busquedaById(
			Tramite_cambio_razon_social nuevo) {
		// TODO Auto-generated method stub
		return tramite_cambio_razon_socialDao.busquedaById(nuevo);
	}

}
