package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.dao.Tramite_cambio_titularidadDao;
import com.mkyong.users.model.Tramite_cambio_titularidad;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class Tramite_cambio_titularidadServiceImpl implements Tramite_cambio_titularidadService {

	@Autowired
	Tramite_cambio_titularidadDao tramite_cambio_titularidadDao;

	@Override
	public List<Tramite_cambio_titularidad> lista() {
		// TODO Auto-generated method stub
		return tramite_cambio_titularidadDao.lista();
	}

	@Override
	public List<Tramite_cambio_titularidad> lista(String rol) {
		// TODO Auto-generated method stub
		return tramite_cambio_titularidadDao.lista(rol);
	}

	@Override
	public MensajeBean inserta(Tramite_cambio_titularidad nuevo) {
		// TODO Auto-generated method stub
		return tramite_cambio_titularidadDao.inserta(nuevo);
	}

	@Override
	public MensajeBean actualiza(Tramite_cambio_titularidad nuevo) {
		// TODO Auto-generated method stub
		return tramite_cambio_titularidadDao.actualiza(nuevo);
	}

	@Override
	public MensajeBean elimina(Tramite_cambio_titularidad nuevo) {
		// TODO Auto-generated method stub
		return tramite_cambio_titularidadDao.elimina(nuevo);
	}

	@Override
	public Tramite_cambio_titularidad consulta(
			Tramite_cambio_titularidad nuevo, String rol) {
		// TODO Auto-generated method stub
		return tramite_cambio_titularidadDao.consulta(nuevo, rol);
	}

	@Override
	public List<WrapperTramite> listaTramitesByZona(String municipio,
			String colonia) {
		// TODO Auto-generated method stub
		return tramite_cambio_titularidadDao.listaTramitesByZona(municipio, colonia);
	}

	@Override
	public List<Tramite_cambio_titularidad> busquedaById(
			Tramite_cambio_titularidad nuevo) {
		// TODO Auto-generated method stub
		return tramite_cambio_titularidadDao.busquedaById(nuevo);
	}
	
	

}
