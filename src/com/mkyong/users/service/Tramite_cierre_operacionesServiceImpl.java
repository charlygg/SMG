package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.dao.Tramite_cierre_operacionesDao;
import com.mkyong.users.model.Tramite_cierre_operaciones;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class Tramite_cierre_operacionesServiceImpl implements Tramite_cierre_operacionesService {
	
	@Autowired
	Tramite_cierre_operacionesDao tramite_cierre_operacionesDao;

	@Override
	public List<Tramite_cierre_operaciones> lista() {
		// TODO Auto-generated method stub
		return tramite_cierre_operacionesDao.lista();
	}

	@Override
	public List<Tramite_cierre_operaciones> lista(String rol) {
		// TODO Auto-generated method stub
		return tramite_cierre_operacionesDao.lista(rol);
	}

	@Override
	public MensajeBean inserta(Tramite_cierre_operaciones nuevo) {
		// TODO Auto-generated method stub
		return tramite_cierre_operacionesDao.inserta(nuevo);
	}

	@Override
	public MensajeBean actualiza(Tramite_cierre_operaciones nuevo) {
		// TODO Auto-generated method stub
		return tramite_cierre_operacionesDao.actualiza(nuevo);
	}

	@Override
	public MensajeBean elimina(Tramite_cierre_operaciones nuevo) {
		// TODO Auto-generated method stub
		return tramite_cierre_operacionesDao.elimina(nuevo);
	}

	@Override
	public Tramite_cierre_operaciones consulta(
			Tramite_cierre_operaciones nuevo, String rol) {
		// TODO Auto-generated method stub
		return tramite_cierre_operacionesDao.consulta(nuevo, rol);
	}

	@Override
	public List<WrapperTramite> listaTramitesByZona(String municipio,
			String colonia) {
		// TODO Auto-generated method stub
		return tramite_cierre_operacionesDao.listaTramitesByZona(municipio, colonia);
	}

	@Override
	public List<Tramite_cierre_operaciones> busquedaById(
			Tramite_cierre_operaciones nuevo) {
		// TODO Auto-generated method stub
		return tramite_cierre_operacionesDao.busquedaById(nuevo);
	}



}