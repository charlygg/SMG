package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.dao.Tramite_pedrerasDao;
import com.mkyong.users.model.Tramite_pedreras;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class Tramite_pedrerasServiceImpl implements Tramite_pedrerasService {
	
	@Autowired
	Tramite_pedrerasDao tramite_predrerasDao;

	@Override
	public List<Tramite_pedreras> busquedaById(Tramite_pedreras nuevo) {
		return tramite_predrerasDao.busquedaById(nuevo);
	}

	@Override
	public List<Tramite_pedreras> lista() {
		return tramite_predrerasDao.lista();
	}

	@Override
	public List<Tramite_pedreras> lista(String rol) {
		return tramite_predrerasDao.lista(rol);
	}

	@Override
	public MensajeBean inserta(Tramite_pedreras nuevo) {
		return tramite_predrerasDao.inserta(nuevo);
	}

	@Override
	public MensajeBean actualiza(Tramite_pedreras nuevo) {
		return tramite_predrerasDao.actualiza(nuevo);
	}

	@Override
	public MensajeBean elimina(Tramite_pedreras nuevo) {
		return tramite_predrerasDao.elimina(nuevo);
	}

	@Override
	public Tramite_pedreras consulta(Tramite_pedreras nuevo) {
		return tramite_predrerasDao.consulta(nuevo);
	}

	@Override
	public List<WrapperTramite> listaTramitesByZona(String municipio, String colonia) {
		return tramite_predrerasDao.listaTramitesByZona(municipio, colonia);
	}

}
