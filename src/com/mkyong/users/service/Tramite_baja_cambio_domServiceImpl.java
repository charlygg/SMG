package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.dao.Tramite_baja_cambio_domDao;
import com.mkyong.users.model.Tramite_baja_cambio_dom;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class Tramite_baja_cambio_domServiceImpl implements Tramite_baja_cambio_domService {
	
	@Autowired
	Tramite_baja_cambio_domDao tramite_baja_cambio_domDao;

	

	@Override
	public List<WrapperTramite> listaTramitesByZona(String municipio,
			String colonia) {
		// TODO Auto-generated method stub
		return tramite_baja_cambio_domDao.listaTramitesByZona(municipio, colonia);
	}



	@Override
	public List<Tramite_baja_cambio_dom> lista() {
		// TODO Auto-generated method stub
		return tramite_baja_cambio_domDao.lista();
	}



	@Override
	public List<Tramite_baja_cambio_dom> lista(String rol) {
		// TODO Auto-generated method stub
		return tramite_baja_cambio_domDao.lista(rol);
	}



	@Override
	public MensajeBean inserta(Tramite_baja_cambio_dom nuevo) {
		// TODO Auto-generated method stub
		return tramite_baja_cambio_domDao.inserta(nuevo);
	}



	@Override
	public MensajeBean actualiza(Tramite_baja_cambio_dom nuevo) {
		// TODO Auto-generated method stub
		return tramite_baja_cambio_domDao.actualiza(nuevo);
	}



	@Override
	public MensajeBean elimina(Tramite_baja_cambio_dom nuevo) {
		// TODO Auto-generated method stub
		return tramite_baja_cambio_domDao.elimina(nuevo);
	}



	@Override
	public Tramite_baja_cambio_dom consulta(
			Tramite_baja_cambio_dom nuevo, String rol) {
		// TODO Auto-generated method stub
		return tramite_baja_cambio_domDao.consulta(nuevo, rol);
	}



	@Override
	public List<Tramite_baja_cambio_dom> busquedaById(
			Tramite_baja_cambio_dom nuevo) {
		// TODO Auto-generated method stub
		return tramite_baja_cambio_domDao.busquedaById(nuevo);
	}

}
