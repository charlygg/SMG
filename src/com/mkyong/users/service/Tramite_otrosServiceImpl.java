package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.dao.Tramite_otrosDao;
import com.mkyong.users.model.Tramite_otros;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class Tramite_otrosServiceImpl implements Tramite_otrosService {
	
	@Autowired
	Tramite_otrosDao tramite_otrosDao;

	

	@Override
	public List<WrapperTramite> listaTramitesByZona(String municipio,
			String colonia) {
		// TODO Auto-generated method stub
		return tramite_otrosDao.listaTramitesByZona(municipio, colonia);
	}



	@Override
	public List<Tramite_otros> lista() {
		// TODO Auto-generated method stub
		return tramite_otrosDao.lista();
	}



	@Override
	public List<Tramite_otros> lista(String rol) {
		// TODO Auto-generated method stub
		return tramite_otrosDao.lista(rol);
	}



	@Override
	public MensajeBean inserta(Tramite_otros nuevo) {
		// TODO Auto-generated method stub
		return tramite_otrosDao.inserta(nuevo);
	}



	@Override
	public MensajeBean actualiza(Tramite_otros nuevo) {
		// TODO Auto-generated method stub
		return tramite_otrosDao.actualiza(nuevo);
	}



	@Override
	public MensajeBean elimina(Tramite_otros nuevo) {
		// TODO Auto-generated method stub
		return tramite_otrosDao.elimina(nuevo);
	}



	@Override
	public Tramite_otros consulta(
			Tramite_otros nuevo, String rol) {
		// TODO Auto-generated method stub
		return tramite_otrosDao.consulta(nuevo, rol);
	}



	@Override
	public List<Tramite_otros> busquedaById(
			Tramite_otros nuevo) {
		// TODO Auto-generated method stub
		return tramite_otrosDao.busquedaById(nuevo);
	}

}
