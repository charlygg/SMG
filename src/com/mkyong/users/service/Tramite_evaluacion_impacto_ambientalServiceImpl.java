package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.dao.Tramite_evaluacion_impacto_ambientalDao;
import com.mkyong.users.model.Tramite_evaluacion_impacto_ambiental;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class Tramite_evaluacion_impacto_ambientalServiceImpl implements  Tramite_evaluacion_impacto_ambientalService{

	@Autowired
	Tramite_evaluacion_impacto_ambientalDao tramite_evaluacion_impacto_ambientalDao;

	@Override
	public List<Tramite_evaluacion_impacto_ambiental> lista() {
		// TODO Auto-generated method stub
		return tramite_evaluacion_impacto_ambientalDao.lista();
	}

	@Override
	public List<Tramite_evaluacion_impacto_ambiental> lista(String rol) {
		// TODO Auto-generated method stub
		return tramite_evaluacion_impacto_ambientalDao.lista(rol);
	}

	@Override
	public MensajeBean inserta(Tramite_evaluacion_impacto_ambiental nuevo) {
		// TODO Auto-generated method stub
		return tramite_evaluacion_impacto_ambientalDao.inserta(nuevo);
	}

	@Override
	public MensajeBean actualiza(Tramite_evaluacion_impacto_ambiental nuevo) {
		// TODO Auto-generated method stub
		return tramite_evaluacion_impacto_ambientalDao.actualiza(nuevo);
	}

	@Override
	public MensajeBean elimina(Tramite_evaluacion_impacto_ambiental nuevo) {
		// TODO Auto-generated method stub
		return tramite_evaluacion_impacto_ambientalDao.elimina(nuevo);
	}

	@Override
	public Tramite_evaluacion_impacto_ambiental consulta(
			Tramite_evaluacion_impacto_ambiental nuevo, String rol) {
		// TODO Auto-generated method stub
		return tramite_evaluacion_impacto_ambientalDao.consulta(nuevo, rol);
	}

	@Override
	public List<WrapperTramite> listaTramitesByZona(String municipio,
			String colonia) {
		// TODO Auto-generated method stub
		return tramite_evaluacion_impacto_ambientalDao.listaTramitesByZona(municipio, colonia);
	}

	@Override
	public List<Tramite_evaluacion_impacto_ambiental> busquedaById(
			Tramite_evaluacion_impacto_ambiental nuevo) {
		// TODO Auto-generated method stub
		return tramite_evaluacion_impacto_ambientalDao.busquedaById(nuevo);
	}

	

}
