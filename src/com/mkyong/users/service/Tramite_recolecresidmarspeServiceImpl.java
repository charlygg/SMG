package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.dao.Tramite_recolecresidmarspeDao;
import com.mkyong.users.model.Tramite_recolecresidmaespe;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class Tramite_recolecresidmarspeServiceImpl implements Tramite_recolecresidmarspeService {
	
	@Autowired
	Tramite_recolecresidmarspeDao tramite_recolecresidmarspeDao;

	@Override
	public List<Tramite_recolecresidmaespe> lista(String rol) {
		// TODO Auto-generated method stub
		return tramite_recolecresidmarspeDao.lista(rol);
	}

	@Override
	public MensajeBean inserta(Tramite_recolecresidmaespe nuevo) {
		// TODO Auto-generated method stub
		return tramite_recolecresidmarspeDao.inserta(nuevo);
	}

	@Override
	public MensajeBean actualiza(Tramite_recolecresidmaespe nuevo) {
		// TODO Auto-generated method stub
		return tramite_recolecresidmarspeDao.actualiza(nuevo);
	}

	@Override
	public MensajeBean elimina(Tramite_recolecresidmaespe nuevo) {
		// TODO Auto-generated method stub
		return tramite_recolecresidmarspeDao.elimina(nuevo);
	}

	@Override
	public Tramite_recolecresidmaespe consulta(Tramite_recolecresidmaespe nuevo, String rol) {
		return tramite_recolecresidmarspeDao.consulta(nuevo, rol);
	}

	@Override
	public List<WrapperTramite> listaTramitesByZona(String municipio,
			String colonia) {
		// TODO Auto-generated method stub
		return tramite_recolecresidmarspeDao.listaTramitesByZona(municipio, colonia);
	}

	@Override
	public List<Tramite_recolecresidmaespe> busquedaById(
			Tramite_recolecresidmaespe nuevo) {
		// TODO Auto-generated method stub
		return tramite_recolecresidmarspeDao.busquedaById(nuevo);
	}
}
