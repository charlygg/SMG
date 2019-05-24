package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.dao.Tramite_ubiopermaintrellsaniconfnormofimexDao;
import com.mkyong.users.model.Tramite_ubiopermaintrellsaniconfnormofimex;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class Tramite_ubiopermaintrellsaniconfnormofimexServiceImpl implements Tramite_ubiopermaintrellsaniconfnormofimexService {
	
	@Autowired
	Tramite_ubiopermaintrellsaniconfnormofimexDao tramite_ubiopermaintrellsaniconfnormofimexDao;

	@Override
	public List<Tramite_ubiopermaintrellsaniconfnormofimex> lista() {
		// TODO Auto-generated method stub
		return tramite_ubiopermaintrellsaniconfnormofimexDao.lista();
	}
	
	@Override
	public List<Tramite_ubiopermaintrellsaniconfnormofimex> lista(String rol) {
		// TODO Auto-generated method stub
		return tramite_ubiopermaintrellsaniconfnormofimexDao.lista(rol);
	}


	@Override
	public MensajeBean inserta(Tramite_ubiopermaintrellsaniconfnormofimex nuevo) {
		// TODO Auto-generated method stub
		return tramite_ubiopermaintrellsaniconfnormofimexDao.inserta(nuevo);
	}

	@Override
	public MensajeBean actualiza(Tramite_ubiopermaintrellsaniconfnormofimex nuevo) {
		// TODO Auto-generated method stub
		return tramite_ubiopermaintrellsaniconfnormofimexDao.actualiza(nuevo);
	}

	@Override
	public MensajeBean elimina(Tramite_ubiopermaintrellsaniconfnormofimex nuevo) {
		// TODO Auto-generated method stub
		return tramite_ubiopermaintrellsaniconfnormofimexDao.elimina(nuevo);
	}

	@Override
	public Tramite_ubiopermaintrellsaniconfnormofimex consulta(Tramite_ubiopermaintrellsaniconfnormofimex nuevo, String rol) {
		return tramite_ubiopermaintrellsaniconfnormofimexDao.consulta(nuevo, rol);
	}

	@Override
	public List<WrapperTramite> listaTramitesByZona(String municipio,
			String colonia) {
		// TODO Auto-generated method stub
		return tramite_ubiopermaintrellsaniconfnormofimexDao.listaTramitesByZona(municipio, colonia);
	}

	@Override
	public List<Tramite_ubiopermaintrellsaniconfnormofimex> busquedaById(
			Tramite_ubiopermaintrellsaniconfnormofimex nuevo) {
		// TODO Auto-generated method stub
		return tramite_ubiopermaintrellsaniconfnormofimexDao.busquedaById(nuevo);
	}
}
