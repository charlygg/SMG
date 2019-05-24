package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.dao.Tramite_solicitud_prorrogaDao;
import com.mkyong.users.model.Tramite_solicitud_prorroga;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class Tramite_solicitud_prorrogaServiceImpl implements Tramite_solicitud_prorrogaService {

	@Autowired
	Tramite_solicitud_prorrogaDao tramite_solicitud_prorrogaDao;

	@Override
	public List<Tramite_solicitud_prorroga> lista() {
		// TODO Auto-generated method stub
		return tramite_solicitud_prorrogaDao.lista();
	}

	@Override
	public List<Tramite_solicitud_prorroga> lista(String rol) {
		// TODO Auto-generated method stub
		return tramite_solicitud_prorrogaDao.lista(rol);
	}

	@Override
	public MensajeBean inserta(Tramite_solicitud_prorroga nuevo) {
		// TODO Auto-generated method stub
		return tramite_solicitud_prorrogaDao.inserta(nuevo);
	}

	@Override
	public MensajeBean actualiza(Tramite_solicitud_prorroga nuevo) {
		// TODO Auto-generated method stub
		return tramite_solicitud_prorrogaDao.actualiza(nuevo);
	}

	@Override
	public MensajeBean elimina(Tramite_solicitud_prorroga nuevo) {
		// TODO Auto-generated method stub
		return tramite_solicitud_prorrogaDao.elimina(nuevo);
	}

	@Override
	public Tramite_solicitud_prorroga consulta(
			Tramite_solicitud_prorroga nuevo, String rol) {
		// TODO Auto-generated method stub
		return tramite_solicitud_prorrogaDao.consulta(nuevo, rol);
	}

	@Override
	public List<WrapperTramite> listaTramitesByZona(String municipio,
			String colonia) {
		// TODO Auto-generated method stub
		return tramite_solicitud_prorrogaDao.listaTramitesByZona(municipio, colonia);
	}

	@Override
	public List<Tramite_solicitud_prorroga> busquedaById(
			Tramite_solicitud_prorroga nuevo) {
		// TODO Auto-generated method stub
		return tramite_solicitud_prorrogaDao.busquedaById(nuevo);
	}

	
	

}
