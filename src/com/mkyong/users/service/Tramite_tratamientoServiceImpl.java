package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.dao.Tramite_tratamientoDao;
import com.mkyong.users.model.Descargaaguasr;
import com.mkyong.users.model.Tramite_tratamiento_aguasr;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class Tramite_tratamientoServiceImpl implements Tramite_tratamientoService {
	
	@Autowired
	Tramite_tratamientoDao tramite_tratamientoDao;

	@Override
	public List<Tramite_tratamiento_aguasr> lista() {
		// TODO Auto-generated method stub
		return tramite_tratamientoDao.lista();
	}

	@Override
	public List<Tramite_tratamiento_aguasr> lista(String rol) {
		// TODO Auto-generated method stub
		return tramite_tratamientoDao.lista(rol);
	}
	
	@Override
	public MensajeBean inserta(Tramite_tratamiento_aguasr nuevo) {
		// TODO Auto-generated method stub
		return tramite_tratamientoDao.inserta(nuevo);
	}

	@Override
	public MensajeBean actualiza(Tramite_tratamiento_aguasr nuevo) {
		// TODO Auto-generated method stub
		return tramite_tratamientoDao.actualiza(nuevo);
	}

	@Override
	public MensajeBean elimina(Tramite_tratamiento_aguasr nuevo) {
		// TODO Auto-generated method stub
		return tramite_tratamientoDao.elimina(nuevo);
	}

	@Override
	public Tramite_tratamiento_aguasr consulta(Tramite_tratamiento_aguasr nuevo) {
		return tramite_tratamientoDao.consulta(nuevo);
	}

	@Override
	public Tramite_tratamiento_aguasr consulta(Tramite_tratamiento_aguasr nuevo,String rol) {
		return tramite_tratamientoDao.consulta(nuevo,rol);
	}
	
	@Override
	public List<WrapperTramite> listaTramitesByZona(String municipio,
			String colonia) {
		// TODO Auto-generated method stub
		return tramite_tratamientoDao.listaTramitesByZona(municipio, colonia);
	}
	
	@Override
	public List<Tramite_tratamiento_aguasr> busquedaById(Tramite_tratamiento_aguasr nuevo) {
		// TODO Auto-generated method stub
		return tramite_tratamientoDao.busquedaById(nuevo);
	}
}
