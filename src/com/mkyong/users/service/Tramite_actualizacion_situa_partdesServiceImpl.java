package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.dao.Tramite_actualizacion_situa_partdesDao;
import com.mkyong.users.model.Tramite_actualizacion_situa_partdes;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class Tramite_actualizacion_situa_partdesServiceImpl implements Tramite_actualizacion_situa_partdesService {
	
	@Autowired
	Tramite_actualizacion_situa_partdesDao tramite_actualizacion_situa_partdesDao;

	@Override
	public List<Tramite_actualizacion_situa_partdes> lista() {
		// TODO Auto-generated method stub
		return tramite_actualizacion_situa_partdesDao.lista();
	}

	@Override
	public MensajeBean inserta(Tramite_actualizacion_situa_partdes nuevo) {
		// TODO Auto-generated method stub
		return tramite_actualizacion_situa_partdesDao.inserta(nuevo);
	}

	@Override
	public MensajeBean actualiza(Tramite_actualizacion_situa_partdes nuevo) {
		// TODO Auto-generated method stub
		return tramite_actualizacion_situa_partdesDao.actualiza(nuevo);
	}

	@Override
	public MensajeBean elimina(Tramite_actualizacion_situa_partdes nuevo) {
		// TODO Auto-generated method stub
		return tramite_actualizacion_situa_partdesDao.elimina(nuevo);
	}

	@Override
	public List<WrapperTramite> listaTramitesByZona(String municipio,
			String colonia) {
		// TODO Auto-generated method stub
		return tramite_actualizacion_situa_partdesDao.listaTramitesByZona(municipio, colonia);
	}

	@Override
	public List<Tramite_actualizacion_situa_partdes> busquedaById(Tramite_actualizacion_situa_partdes nuevo) {
		// TODO Auto-generated method stub
		return tramite_actualizacion_situa_partdesDao.busquedaById(nuevo);
	}

	@Override
	public List<Tramite_actualizacion_situa_partdes> lista(String rol) {
		// TODO Auto-generated method stub
		return tramite_actualizacion_situa_partdesDao.lista(rol);
	}

	@Override
	public Tramite_actualizacion_situa_partdes consulta(
			Tramite_actualizacion_situa_partdes nuevo, String rol) {
		// TODO Auto-generated method stub
		return tramite_actualizacion_situa_partdesDao.consulta(nuevo, rol);
	}
}
