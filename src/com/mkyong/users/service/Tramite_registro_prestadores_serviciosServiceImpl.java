package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.dao.Tramite_registro_prestador_servicioDao;
import com.mkyong.users.model.Tramite_registro_prestadores_servicios;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class Tramite_registro_prestadores_serviciosServiceImpl implements Tramite_registro_prestadores_serviciosService {
	
	@Autowired
	Tramite_registro_prestador_servicioDao tramite_registro_prestador_servicioDao;

	@Override
	public List<Tramite_registro_prestadores_servicios> lista() {
		// TODO Auto-generated method stub
		return tramite_registro_prestador_servicioDao.lista();
	}

	@Override
	public List<Tramite_registro_prestadores_servicios> lista(String rol) {
		// TODO Auto-generated method stub
		return tramite_registro_prestador_servicioDao.lista(rol);
	}

	@Override
	public MensajeBean inserta(Tramite_registro_prestadores_servicios nuevo) {
		// TODO Auto-generated method stub
		return tramite_registro_prestador_servicioDao.inserta(nuevo);
	}

	@Override
	public MensajeBean actualiza(Tramite_registro_prestadores_servicios nuevo) {
		// TODO Auto-generated method stub
		return tramite_registro_prestador_servicioDao.actualiza(nuevo);
	}

	@Override
	public MensajeBean elimina(Tramite_registro_prestadores_servicios nuevo) {
		// TODO Auto-generated method stub
		return tramite_registro_prestador_servicioDao.elimina(nuevo);
	}

	@Override
	public Tramite_registro_prestadores_servicios consulta(
			Tramite_registro_prestadores_servicios nuevo, String rol) {
		// TODO Auto-generated method stub
		return tramite_registro_prestador_servicioDao.consulta(nuevo, rol);
	}

	@Override
	public List<WrapperTramite> listaTramitesByZona(String municipio,
			String colonia) {
		// TODO Auto-generated method stub
		return tramite_registro_prestador_servicioDao.listaTramitesByZona(municipio, colonia);
	}

	@Override
	public List<Tramite_registro_prestadores_servicios> busquedaById(
			Tramite_registro_prestadores_servicios nuevo) {
		// TODO Auto-generated method stub
		return tramite_registro_prestador_servicioDao.busquedaById(nuevo);
	}
	
	
	
}