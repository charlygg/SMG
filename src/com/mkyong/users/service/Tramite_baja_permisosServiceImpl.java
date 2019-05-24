package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.dao.Tramite_baja_permisosDao;
import com.mkyong.users.model.Tramite_baja_permisos;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class Tramite_baja_permisosServiceImpl implements Tramite_baja_permisosService {
	
	@Autowired
	Tramite_baja_permisosDao tramite_baja_permisosDao;

	

	@Override
	public List<WrapperTramite> listaTramitesByZona(String municipio,
			String colonia) {
		// TODO Auto-generated method stub
		return tramite_baja_permisosDao.listaTramitesByZona(municipio, colonia);
	}



	@Override
	public List<Tramite_baja_permisos> lista() {
		// TODO Auto-generated method stub
		return tramite_baja_permisosDao.lista();
	}



	@Override
	public List<Tramite_baja_permisos> lista(String rol) {
		// TODO Auto-generated method stub
		return tramite_baja_permisosDao.lista(rol);
	}



	@Override
	public MensajeBean inserta(Tramite_baja_permisos nuevo) {
		// TODO Auto-generated method stub
		return tramite_baja_permisosDao.inserta(nuevo);
	}



	@Override
	public MensajeBean actualiza(Tramite_baja_permisos nuevo) {
		// TODO Auto-generated method stub
		return tramite_baja_permisosDao.actualiza(nuevo);
	}



	@Override
	public MensajeBean elimina(Tramite_baja_permisos nuevo) {
		// TODO Auto-generated method stub
		return tramite_baja_permisosDao.elimina(nuevo);
	}



	@Override
	public Tramite_baja_permisos consulta(
			Tramite_baja_permisos nuevo, String rol) {
		// TODO Auto-generated method stub
		return tramite_baja_permisosDao.consulta(nuevo, rol);
	}



	@Override
	public List<Tramite_baja_permisos> busquedaById(
			Tramite_baja_permisos nuevo) {
		// TODO Auto-generated method stub
		return tramite_baja_permisosDao.busquedaById(nuevo);
	}

}
