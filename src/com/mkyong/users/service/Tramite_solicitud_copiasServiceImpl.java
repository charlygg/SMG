package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.dao.Tramite_solicitud_copiasDao;
import com.mkyong.users.model.Tramite_solicitud_copias;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class Tramite_solicitud_copiasServiceImpl implements Tramite_solicitud_copiasService {

	@Autowired
	Tramite_solicitud_copiasDao tramite_solicitud_copiasDao;

	@Override
	public List<Tramite_solicitud_copias> lista() {
		// TODO Auto-generated method stub
		return tramite_solicitud_copiasDao.lista();
	}

	@Override
	public List<Tramite_solicitud_copias> lista(String rol) {
		// TODO Auto-generated method stub
		return tramite_solicitud_copiasDao.lista(rol);
	}

	@Override
	public MensajeBean inserta(Tramite_solicitud_copias nuevo) {
		// TODO Auto-generated method stub
		return tramite_solicitud_copiasDao.inserta(nuevo);
	}

	@Override
	public MensajeBean actualiza(Tramite_solicitud_copias nuevo) {
		// TODO Auto-generated method stub
		return tramite_solicitud_copiasDao.actualiza(nuevo);
	}

	@Override
	public MensajeBean elimina(Tramite_solicitud_copias nuevo) {
		// TODO Auto-generated method stub
		return tramite_solicitud_copiasDao.elimina(nuevo);
	}

	@Override
	public Tramite_solicitud_copias consulta(Tramite_solicitud_copias nuevo,
			String rol) {
		// TODO Auto-generated method stub
		return tramite_solicitud_copiasDao.consulta(nuevo, rol);
	}

	@Override
	public List<WrapperTramite> listaTramitesByZona(String municipio,
			String colonia) {
		// TODO Auto-generated method stub
		return tramite_solicitud_copiasDao.listaTramitesByZona(municipio, colonia);
	}

	@Override
	public List<Tramite_solicitud_copias> busquedaById(
			Tramite_solicitud_copias nuevo) {
		// TODO Auto-generated method stub
		return tramite_solicitud_copiasDao.busquedaById(nuevo);
	}
	
	
}
