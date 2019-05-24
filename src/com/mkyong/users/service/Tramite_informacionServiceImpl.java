package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.dao.Tramite_informacionDao;
import com.mkyong.users.model.Tramite_informacion;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class Tramite_informacionServiceImpl implements Tramite_informacionService {
	
	@Autowired
	Tramite_informacionDao tramite_informacionDao;

	

	@Override
	public List<WrapperTramite> listaTramitesByZona(String municipio,
			String colonia) {
		return tramite_informacionDao.listaTramitesByZona(municipio, colonia);
	}



	@Override
	public List<Tramite_informacion> lista() {
		return tramite_informacionDao.lista();
	}



	@Override
	public List<Tramite_informacion> lista(String rol) {
		return tramite_informacionDao.lista(rol);
	}



	@Override
	public MensajeBean inserta(Tramite_informacion nuevo) {
		return tramite_informacionDao.inserta(nuevo);
	}



	@Override
	public MensajeBean actualiza(Tramite_informacion nuevo) {
		return tramite_informacionDao.actualiza(nuevo);
	}



	@Override
	public MensajeBean elimina(Tramite_informacion nuevo) {
		return tramite_informacionDao.elimina(nuevo);
	}



	@Override
	public Tramite_informacion consulta(
			Tramite_informacion nuevo, String rol) {
		return tramite_informacionDao.consulta(nuevo, rol);
	}



	@Override
	public List<Tramite_informacion> busquedaById(
			Tramite_informacion nuevo) {
		return tramite_informacionDao.busquedaById(nuevo);
	}

}
