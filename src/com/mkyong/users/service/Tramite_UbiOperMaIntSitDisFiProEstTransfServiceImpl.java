package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.dao.Tramite_UbiOperMaIntSitDisFiProEstTransfDao;
import com.mkyong.users.model.Tramite_UbiOperMaIntSitDisFiProEstTransf;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class Tramite_UbiOperMaIntSitDisFiProEstTransfServiceImpl implements Tramite_UbiOperMaIntSitDisFiProEstTransfService {
	
	@Autowired
	Tramite_UbiOperMaIntSitDisFiProEstTransfDao tramite_UbiOperMaIntSitDisFiProEstTransfDao;

	@Override
	public List<Tramite_UbiOperMaIntSitDisFiProEstTransf> lista() {
		// TODO Auto-generated method stub
		return tramite_UbiOperMaIntSitDisFiProEstTransfDao.lista();
	}

	@Override
	public MensajeBean inserta(Tramite_UbiOperMaIntSitDisFiProEstTransf nuevo) {
		// TODO Auto-generated method stub
		return tramite_UbiOperMaIntSitDisFiProEstTransfDao.inserta(nuevo);
	}

	@Override
	public MensajeBean actualiza(Tramite_UbiOperMaIntSitDisFiProEstTransf nuevo) {
		// TODO Auto-generated method stub
		return tramite_UbiOperMaIntSitDisFiProEstTransfDao.actualiza(nuevo);
	}

	@Override
	public MensajeBean elimina(Tramite_UbiOperMaIntSitDisFiProEstTransf nuevo) {
		// TODO Auto-generated method stub
		return tramite_UbiOperMaIntSitDisFiProEstTransfDao.elimina(nuevo);
	}

	@Override
	public Tramite_UbiOperMaIntSitDisFiProEstTransf consulta(
			Tramite_UbiOperMaIntSitDisFiProEstTransf nuevo, String rol) {
		// TODO Auto-generated method stub
		return tramite_UbiOperMaIntSitDisFiProEstTransfDao.consulta(nuevo, rol);
	}

	@Override
	public List<Tramite_UbiOperMaIntSitDisFiProEstTransf> lista(String rol) {
		// TODO Auto-generated method stub
		return tramite_UbiOperMaIntSitDisFiProEstTransfDao.lista(rol);
	}

	@Override
	public List<WrapperTramite> listaTramitesByZona(String municipio,
			String colonia) {
		// TODO Auto-generated method stub
		return tramite_UbiOperMaIntSitDisFiProEstTransfDao.listaTramitesByZona(municipio, colonia);
	}

	@Override
	public List<Tramite_UbiOperMaIntSitDisFiProEstTransf> busquedaById(
			Tramite_UbiOperMaIntSitDisFiProEstTransf nuevo) {
		// TODO Auto-generated method stub
		return tramite_UbiOperMaIntSitDisFiProEstTransfDao.busquedaById(nuevo);
	}

	
}
