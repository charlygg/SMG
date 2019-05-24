package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.dao.Tramite_quema_cielo_abiertoDao;
import com.mkyong.users.model.Tramite_quema_cielo_abierto;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class Tramite_quema_cielo_abiertoServiceImpl implements Tramite_quema_cielo_abiertoService {

	@Autowired
	Tramite_quema_cielo_abiertoDao tramite_quema_cielo_abiertoDao;

	@Override
	public List<Tramite_quema_cielo_abierto> lista() {
		// TODO Auto-generated method stub
		return tramite_quema_cielo_abiertoDao.lista();
	}

	@Override
	public List<Tramite_quema_cielo_abierto> lista(String rol) {
		// TODO Auto-generated method stub
		return tramite_quema_cielo_abiertoDao.lista(rol);
	}

	@Override
	public MensajeBean inserta(Tramite_quema_cielo_abierto nuevo) {
		// TODO Auto-generated method stub
		return tramite_quema_cielo_abiertoDao.inserta(nuevo);
	}

	@Override
	public MensajeBean actualiza(Tramite_quema_cielo_abierto nuevo) {
		// TODO Auto-generated method stub
		return tramite_quema_cielo_abiertoDao.actualiza(nuevo);
	}

	@Override
	public MensajeBean elimina(Tramite_quema_cielo_abierto nuevo) {
		// TODO Auto-generated method stub
		return tramite_quema_cielo_abiertoDao.elimina(nuevo);
	}

	@Override
	public Tramite_quema_cielo_abierto consulta(
			Tramite_quema_cielo_abierto nuevo, String rol) {
		// TODO Auto-generated method stub
		return tramite_quema_cielo_abiertoDao.consulta(nuevo, rol);
	}

	@Override
	public List<WrapperTramite> listaTramitesByZona(String municipio,
			String colonia) {
		// TODO Auto-generated method stub
		return tramite_quema_cielo_abiertoDao.listaTramitesByZona(municipio, colonia);
	}

	@Override
	public List<Tramite_quema_cielo_abierto> busquedaById(
			Tramite_quema_cielo_abierto nuevo) {
		// TODO Auto-generated method stub
		return tramite_quema_cielo_abiertoDao.busquedaById(nuevo);
	}
	


}
