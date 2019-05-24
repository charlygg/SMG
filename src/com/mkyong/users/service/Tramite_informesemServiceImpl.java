package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.dao.Tramite_informesemDao;
import com.mkyong.users.model.Tramite_informesem;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class Tramite_informesemServiceImpl implements Tramite_informesemService {
	
	@Autowired
	Tramite_informesemDao tramite_informesemDao;

	@Override
	public List<Tramite_informesem> lista() {
		// TODO Auto-generated method stub
		return tramite_informesemDao.lista();
	}

	public List<Tramite_informesem> lista(String rol) {
		// TODO Auto-generated method stub
		return tramite_informesemDao.lista(rol);
	}

	@Override
	public MensajeBean inserta(Tramite_informesem nuevo) {
		// TODO Auto-generated method stub
		return tramite_informesemDao.inserta(nuevo);
	}

	@Override
	public MensajeBean actualiza(Tramite_informesem nuevo) {
		// TODO Auto-generated method stub
		return tramite_informesemDao.actualiza(nuevo);
	}

	@Override
	public MensajeBean elimina(Tramite_informesem nuevo) {
		// TODO Auto-generated method stub
		return tramite_informesemDao.elimina(nuevo);
	}

	@Override
	public Tramite_informesem consulta(Tramite_informesem nuevo) {
		return tramite_informesemDao.consulta(nuevo);
	}

	@Override
	public List<WrapperTramite> listaTramitesByZona(String municipio,
			String colonia) {
		// TODO Auto-generated method stub
		return tramite_informesemDao.listaTramitesByZona(municipio, colonia);
	}
}
