package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.dao.Tramite_modif_licenciaDao;
import com.mkyong.users.model.Tramite_modif_licencia;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class Tramite_modif_licenciaServiceImpl implements Tramite_modif_licenciaService {
	
	@Autowired
	Tramite_modif_licenciaDao tramite_modif_licenciaDao;

	

	@Override
	public List<WrapperTramite> listaTramitesByZona(String municipio,
			String colonia) {
		// TODO Auto-generated method stub
		return tramite_modif_licenciaDao.listaTramitesByZona(municipio, colonia);
	}



	@Override
	public List<Tramite_modif_licencia> lista() {
		// TODO Auto-generated method stub
		return tramite_modif_licenciaDao.lista();
	}



	@Override
	public List<Tramite_modif_licencia> lista(String rol) {
		// TODO Auto-generated method stub
		return tramite_modif_licenciaDao.lista(rol);
	}



	@Override
	public MensajeBean inserta(Tramite_modif_licencia nuevo) {
		// TODO Auto-generated method stub
		return tramite_modif_licenciaDao.inserta(nuevo);
	}



	@Override
	public MensajeBean actualiza(Tramite_modif_licencia nuevo) {
		// TODO Auto-generated method stub
		return tramite_modif_licenciaDao.actualiza(nuevo);
	}



	@Override
	public MensajeBean elimina(Tramite_modif_licencia nuevo) {
		// TODO Auto-generated method stub
		return tramite_modif_licenciaDao.elimina(nuevo);
	}



	@Override
	public Tramite_modif_licencia consulta(
			Tramite_modif_licencia nuevo, String rol) {
		// TODO Auto-generated method stub
		return tramite_modif_licenciaDao.consulta(nuevo, rol);
	}



	@Override
	public List<Tramite_modif_licencia> busquedaById(
			Tramite_modif_licencia nuevo) {
		// TODO Auto-generated method stub
		return tramite_modif_licenciaDao.busquedaById(nuevo);
	}

}
