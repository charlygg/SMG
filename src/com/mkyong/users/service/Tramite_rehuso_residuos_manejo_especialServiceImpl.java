package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.dao.Tramite_rehuso_residuos_manejo_especialDao;
import com.mkyong.users.model.Tramite_rehuso_residuos_manejo_especial;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class Tramite_rehuso_residuos_manejo_especialServiceImpl implements Tramite_rehuso_residuos_manejo_especialService {
	
	@Autowired
	Tramite_rehuso_residuos_manejo_especialDao tramite_ubiopermaintrellsaniconfnormofimexDao;

	@Override
	public List<Tramite_rehuso_residuos_manejo_especial> lista() {
		// TODO Auto-generated method stub
		return tramite_ubiopermaintrellsaniconfnormofimexDao.lista();
	}
	
	@Override
	public List<Tramite_rehuso_residuos_manejo_especial> lista(String rol) {
		// TODO Auto-generated method stub
		return tramite_ubiopermaintrellsaniconfnormofimexDao.lista(rol);
	}


	@Override
	public MensajeBean inserta(Tramite_rehuso_residuos_manejo_especial nuevo) {
		// TODO Auto-generated method stub
		return tramite_ubiopermaintrellsaniconfnormofimexDao.inserta(nuevo);
	}

	@Override
	public MensajeBean actualiza(Tramite_rehuso_residuos_manejo_especial nuevo) {
		// TODO Auto-generated method stub
		return tramite_ubiopermaintrellsaniconfnormofimexDao.actualiza(nuevo);
	}

	@Override
	public MensajeBean elimina(Tramite_rehuso_residuos_manejo_especial nuevo) {
		// TODO Auto-generated method stub
		return tramite_ubiopermaintrellsaniconfnormofimexDao.elimina(nuevo);
	}

	@Override
	public Tramite_rehuso_residuos_manejo_especial consulta(Tramite_rehuso_residuos_manejo_especial nuevo, String rol) {
		return tramite_ubiopermaintrellsaniconfnormofimexDao.consulta(nuevo, rol);
	}

	@Override
	public List<WrapperTramite> listaTramitesByZona(String municipio,
			String colonia) {
		// TODO Auto-generated method stub
		return tramite_ubiopermaintrellsaniconfnormofimexDao.listaTramitesByZona(municipio, colonia);
	}

	@Override
	public List<Tramite_rehuso_residuos_manejo_especial> busquedaById(
			Tramite_rehuso_residuos_manejo_especial nuevo) {
		// TODO Auto-generated method stub
		return tramite_ubiopermaintrellsaniconfnormofimexDao.busquedaById(nuevo);
	}
}
