package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.dao.Tramite_fosasepticaDao;
import com.mkyong.users.model.Tramite_fosa_septica;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class Tramite_fosasepticaServiceImpl implements Tramite_fosasepticaService {
	
	@Autowired
	Tramite_fosasepticaDao tramite_fosasepticaDao;

	@Override
	public List<Tramite_fosa_septica> lista() {
		// TODO Auto-generated method stub
		return tramite_fosasepticaDao.lista();
	}

	@Override
	public List<Tramite_fosa_septica> lista(String rol) {
		// TODO Auto-generated method stub
		return tramite_fosasepticaDao.lista(rol);
	}
	
	@Override
	public MensajeBean inserta(Tramite_fosa_septica nuevo) {
		// TODO Auto-generated method stub
		return tramite_fosasepticaDao.inserta(nuevo);
	}

	@Override
	public MensajeBean actualiza(Tramite_fosa_septica nuevo) {
		// TODO Auto-generated method stub
		return tramite_fosasepticaDao.actualiza(nuevo);
	}

	@Override
	public MensajeBean elimina(Tramite_fosa_septica nuevo) {
		// TODO Auto-generated method stub
		return tramite_fosasepticaDao.elimina(nuevo);
	}

	@Override
	public Tramite_fosa_septica consulta(Tramite_fosa_septica nuevo) {
		return tramite_fosasepticaDao.consulta(nuevo);
	}

	@Override
	public List<WrapperTramite> listaTramitesByZona(String municipio,
			String colonia) {
		// TODO Auto-generated method stub
		return tramite_fosasepticaDao.listaTramitesByZona(municipio, colonia);
	}
}
