package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.dao.Tramite_modificacion_proyectoDao;
import com.mkyong.users.model.Tramite_modificacion_proyecto;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class Tramite_modificacion_proyectoServiceImpl implements Tramite_modificacion_proyectoService  {

	@Autowired
	Tramite_modificacion_proyectoDao tramite_modificacion_proyectoDao;

	@Override
	public List<Tramite_modificacion_proyecto> lista() {
		// TODO Auto-generated method stub
		return tramite_modificacion_proyectoDao.lista();
	}

	@Override
	public List<Tramite_modificacion_proyecto> lista(String rol) {
		// TODO Auto-generated method stub
		return tramite_modificacion_proyectoDao.lista(rol);
	}

	@Override
	public MensajeBean inserta(Tramite_modificacion_proyecto nuevo) {
		// TODO Auto-generated method stub
		return tramite_modificacion_proyectoDao.inserta(nuevo);
	}

	@Override
	public MensajeBean actualiza(Tramite_modificacion_proyecto nuevo) {
		// TODO Auto-generated method stub
		return tramite_modificacion_proyectoDao.actualiza(nuevo);
	}

	@Override
	public MensajeBean elimina(Tramite_modificacion_proyecto nuevo) {
		// TODO Auto-generated method stub
		return tramite_modificacion_proyectoDao.elimina(nuevo);
	}

	@Override
	public Tramite_modificacion_proyecto consulta(
			Tramite_modificacion_proyecto nuevo, String rol) {
		// TODO Auto-generated method stub
		return tramite_modificacion_proyectoDao.consulta(nuevo, rol);
	}

	@Override
	public List<WrapperTramite> listaTramitesByZona(String municipio,
			String colonia) {
		// TODO Auto-generated method stub
		return tramite_modificacion_proyectoDao.listaTramitesByZona(municipio, colonia);
	}

	@Override
	public List<Tramite_modificacion_proyecto> busquedaById(
			Tramite_modificacion_proyecto nuevo) {
		// TODO Auto-generated method stub
		return tramite_modificacion_proyectoDao.busquedaById(nuevo);
	}
	
	

}
