package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.dao.Tramite_UbiOperMaIntEscSitDisFiResidProConsDao;
import com.mkyong.users.model.Tramite_UbiOperMaIntEscSitDisFiResidProCons;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class Tramite_UbiOperMaIntEscSitDisFiResidProConsServiceImpl implements Tramite_UbiOperMaIntEscSitDisFiResidProConsService {
	
	@Autowired
	Tramite_UbiOperMaIntEscSitDisFiResidProConsDao tramite_UbiOperMaIntSitDisFiProEstTransfDao;

	@Override
	public List<Tramite_UbiOperMaIntEscSitDisFiResidProCons> lista(String rol) {
		// TODO Auto-generated method stub
		return tramite_UbiOperMaIntSitDisFiProEstTransfDao.lista(rol);
	}

	@Override
	public MensajeBean inserta(Tramite_UbiOperMaIntEscSitDisFiResidProCons nuevo) {
		// TODO Auto-generated method stub
		return tramite_UbiOperMaIntSitDisFiProEstTransfDao.inserta(nuevo);
	}

	@Override
	public MensajeBean actualiza(Tramite_UbiOperMaIntEscSitDisFiResidProCons nuevo) {
		// TODO Auto-generated method stub
		return tramite_UbiOperMaIntSitDisFiProEstTransfDao.actualiza(nuevo);
	}

	@Override
	public MensajeBean elimina(Tramite_UbiOperMaIntEscSitDisFiResidProCons nuevo) {
		// TODO Auto-generated method stub
		return tramite_UbiOperMaIntSitDisFiProEstTransfDao.elimina(nuevo);
	}

	@Override
	public Tramite_UbiOperMaIntEscSitDisFiResidProCons consulta(Tramite_UbiOperMaIntEscSitDisFiResidProCons nuevo, String rol) {
		return tramite_UbiOperMaIntSitDisFiProEstTransfDao.consulta(nuevo, rol);
	}

	@Override
	public List<WrapperTramite> listaTramitesByZona(String municipio,
			String colonia) {
		// TODO Auto-generated method stub
		return tramite_UbiOperMaIntSitDisFiProEstTransfDao.listaTramitesByZona(municipio, colonia);
	}

	@Override
	public List<Tramite_UbiOperMaIntEscSitDisFiResidProCons> busquedaById(
			Tramite_UbiOperMaIntEscSitDisFiResidProCons nuevo) {
		// TODO Auto-generated method stub
		return tramite_UbiOperMaIntSitDisFiProEstTransfDao.busquedaById(nuevo);
	}
}
