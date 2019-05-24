package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.dao.Tramite_consultasDao;
import com.mkyong.users.model.Tramite_consultas;
import com.mkyong.users.model.Tramite_modificacion_proyecto;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class Tramite_consultasServiceImpl implements  Tramite_consultasService{

	@Autowired
	Tramite_consultasDao tramite_consultasDao;

	@Override
	public List<Tramite_consultas> lista() {
		// TODO Auto-generated method stub
		return tramite_consultasDao.lista();
	}

	@Override
	public List<Tramite_consultas> lista(String rol) {
		// TODO Auto-generated method stub
		return tramite_consultasDao.lista(rol);
	}

	@Override
	public MensajeBean inserta(Tramite_consultas nuevo) {
		// TODO Auto-generated method stub
		return tramite_consultasDao.inserta(nuevo);
	}

	@Override
	public MensajeBean actualiza(Tramite_consultas nuevo) {
		// TODO Auto-generated method stub
		return tramite_consultasDao.actualiza(nuevo);
	}

	@Override
	public MensajeBean elimina(Tramite_consultas nuevo) {
		// TODO Auto-generated method stub
		return tramite_consultasDao.elimina(nuevo);
	}

	@Override
	public Tramite_consultas consulta(Tramite_consultas nuevo, String rol) {
		// TODO Auto-generated method stub
		return tramite_consultasDao.consulta(nuevo, rol);
	}

	@Override
	public List<WrapperTramite> listaTramitesByZona(String municipio,
			String colonia) {
		// TODO Auto-generated method stub
		return tramite_consultasDao.listaTramitesByZona(municipio, colonia);
	}

	@Override
	public List<Tramite_consultas> busquedaById(Tramite_consultas nuevo) {
		// TODO Auto-generated method stub
		return tramite_consultasDao.busquedaById(nuevo);
	}
	
	

}
