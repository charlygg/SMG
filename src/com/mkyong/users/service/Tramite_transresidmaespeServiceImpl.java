package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.dao.Tramite_transresidmaespeDao;
import com.mkyong.users.model.Tramite_transresidmaespe;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class Tramite_transresidmaespeServiceImpl implements Tramite_transresidmaespeService {
	
	@Autowired
	Tramite_transresidmaespeDao tramite_transresidmaespeDao;

	@Override
	public List<Tramite_transresidmaespe> lista(String rol) {
		// TODO Auto-generated method stub
		return tramite_transresidmaespeDao.lista(rol);
	}

	@Override
	public MensajeBean inserta(Tramite_transresidmaespe nuevo) {
		// TODO Auto-generated method stub
		return tramite_transresidmaespeDao.inserta(nuevo);
	}

	@Override
	public MensajeBean actualiza(Tramite_transresidmaespe nuevo) {
		// TODO Auto-generated method stub
		return tramite_transresidmaespeDao.actualiza(nuevo);
	}

	@Override
	public MensajeBean elimina(Tramite_transresidmaespe nuevo) {
		// TODO Auto-generated method stub
		return tramite_transresidmaespeDao.elimina(nuevo);
	}

	@Override
	public Tramite_transresidmaespe consulta(Tramite_transresidmaespe nuevo, String rol) {
		return tramite_transresidmaespeDao.consulta(nuevo, rol);
	}

	@Override
	public List<WrapperTramite> listaTramitesByZona(String municipio,
			String colonia) {
		// TODO Auto-generated method stub
		return tramite_transresidmaespeDao.listaTramitesByZona(municipio, colonia);
	}

	@Override
	public List<Tramite_transresidmaespe> busquedaById(
			Tramite_transresidmaespe nuevo) {
		// TODO Auto-generated method stub
		return tramite_transresidmaespeDao.busquedaById(nuevo);
	}
}
