package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.dao.Tramite_licencia_funcionamientoDao;
import com.mkyong.users.model.Tramite_licencia_funcionamiento;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class Tramite_licencia_funcionamientoServiceImpl implements Tramite_licencia_funcionamientoService {

	@Autowired
	Tramite_licencia_funcionamientoDao tramite_licencia_funcionamientoDao;

	@Override
	public List<Tramite_licencia_funcionamiento> lista() {
		// TODO Auto-generated method stub
		return tramite_licencia_funcionamientoDao.lista();
	}

	@Override
	public List<Tramite_licencia_funcionamiento> lista(String rol) {
		// TODO Auto-generated method stub
		return tramite_licencia_funcionamientoDao.lista(rol);
	}

	@Override
	public MensajeBean inserta(Tramite_licencia_funcionamiento nuevo) {
		// TODO Auto-generated method stub
		return tramite_licencia_funcionamientoDao.inserta(nuevo);
	}

	@Override
	public MensajeBean actualiza(Tramite_licencia_funcionamiento nuevo) {
		// TODO Auto-generated method stub
		return tramite_licencia_funcionamientoDao.actualiza(nuevo);
	}

	@Override
	public MensajeBean elimina(Tramite_licencia_funcionamiento nuevo) {
		// TODO Auto-generated method stub
		return tramite_licencia_funcionamientoDao.elimina(nuevo);
	}

	@Override
	public Tramite_licencia_funcionamiento consulta(
			Tramite_licencia_funcionamiento nuevo, String rol) {
		// TODO Auto-generated method stub
		return tramite_licencia_funcionamientoDao.consulta(nuevo, rol);
	}

	@Override
	public List<WrapperTramite> listaTramitesByZona(String municipio,
			String colonia) {
		// TODO Auto-generated method stub
		return tramite_licencia_funcionamientoDao.listaTramitesByZona(municipio, colonia);
	}

	@Override
	public List<Tramite_licencia_funcionamiento> busquedaById(
			Tramite_licencia_funcionamiento nuevo) {
		// TODO Auto-generated method stub
		return tramite_licencia_funcionamientoDao.busquedaById(nuevo);
	}
	
	

}
