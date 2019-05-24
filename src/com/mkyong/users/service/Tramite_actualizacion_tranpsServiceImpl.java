package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.dao.Tramite_actualizacion_tranpsDao;
import com.mkyong.users.model.Tramite_actualizacion_tranps;


@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class Tramite_actualizacion_tranpsServiceImpl implements Tramite_actualizacion_tranpsService {
	
	@Autowired
	Tramite_actualizacion_tranpsDao tramite_actualizacion_tranpsDao;

	

	@Override
	public List<WrapperTramite> listaTramitesByZona(String municipio,
			String colonia) {
		// TODO Auto-generated method stub
		return tramite_actualizacion_tranpsDao.listaTramitesByZona(municipio, colonia);
	}



	@Override
	public List<Tramite_actualizacion_tranps> lista() {
		// TODO Auto-generated method stub
		return tramite_actualizacion_tranpsDao.lista();
	}



	@Override
	public List<Tramite_actualizacion_tranps> lista(String rol) {
		// TODO Auto-generated method stub
		return tramite_actualizacion_tranpsDao.lista(rol);
	}



	@Override
	public MensajeBean inserta(Tramite_actualizacion_tranps nuevo) {
		// TODO Auto-generated method stub
		return tramite_actualizacion_tranpsDao.inserta(nuevo);
	}



	@Override
	public MensajeBean actualiza(Tramite_actualizacion_tranps nuevo) {
		// TODO Auto-generated method stub
		return tramite_actualizacion_tranpsDao.actualiza(nuevo);
	}



	@Override
	public MensajeBean elimina(Tramite_actualizacion_tranps nuevo) {
		// TODO Auto-generated method stub
		return tramite_actualizacion_tranpsDao.elimina(nuevo);
	}



	@Override
	public Tramite_actualizacion_tranps consulta(
			Tramite_actualizacion_tranps nuevo, String rol) {
		// TODO Auto-generated method stub
		return tramite_actualizacion_tranpsDao.consulta(nuevo, rol);
	}



	@Override
	public List<Tramite_actualizacion_tranps> busquedaById(
			Tramite_actualizacion_tranps nuevo) {
		// TODO Auto-generated method stub
		return tramite_actualizacion_tranpsDao.busquedaById(nuevo);
	}

}

