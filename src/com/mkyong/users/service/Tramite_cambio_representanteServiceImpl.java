package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.dao.Tramite_cambio_representanteDao;
import com.mkyong.users.model.Tramite_cambio_representante;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class Tramite_cambio_representanteServiceImpl implements Tramite_cambio_representanteService {

	@Autowired
	Tramite_cambio_representanteDao tramite_cambio_representanteDao;

	@Override
	public List<Tramite_cambio_representante> lista() {
		// TODO Auto-generated method stub
		return tramite_cambio_representanteDao.lista();
	}

	@Override
	public List<Tramite_cambio_representante> lista(String rol) {
		// TODO Auto-generated method stub
		return tramite_cambio_representanteDao.lista(rol);
	}

	@Override
	public MensajeBean inserta(Tramite_cambio_representante nuevo) {
		// TODO Auto-generated method stub
		return tramite_cambio_representanteDao.inserta(nuevo);
	}

	@Override
	public MensajeBean actualiza(Tramite_cambio_representante nuevo) {
		// TODO Auto-generated method stub
		return tramite_cambio_representanteDao.actualiza(nuevo);
	}

	@Override
	public MensajeBean elimina(Tramite_cambio_representante nuevo) {
		// TODO Auto-generated method stub
		return tramite_cambio_representanteDao.elimina(nuevo);
	}

	@Override
	public Tramite_cambio_representante consulta(
			Tramite_cambio_representante nuevo, String rol) {
		// TODO Auto-generated method stub
		return tramite_cambio_representanteDao.consulta(nuevo, rol);
	}

	@Override
	public List<WrapperTramite> listaTramitesByZona(String municipio,
			String colonia) {
		// TODO Auto-generated method stub
		return tramite_cambio_representanteDao.listaTramitesByZona(municipio, colonia);
	}

	@Override
	public List<Tramite_cambio_representante> busquedaById(
			Tramite_cambio_representante nuevo) {
		// TODO Auto-generated method stub
		return tramite_cambio_representanteDao.busquedaById(nuevo);
	}
	


}
