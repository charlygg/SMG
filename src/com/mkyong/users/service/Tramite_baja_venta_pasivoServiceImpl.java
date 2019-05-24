package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.dao.Tramite_baja_venta_pasivoDao;
import com.mkyong.users.model.Tramite_baja_venta_pasivo;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class Tramite_baja_venta_pasivoServiceImpl implements Tramite_baja_venta_pasivoService {
	
	@Autowired
	Tramite_baja_venta_pasivoDao tramite_baja_venta_pasivoDao;

	

	@Override
	public List<WrapperTramite> listaTramitesByZona(String municipio,
			String colonia) {
		// TODO Auto-generated method stub
		return tramite_baja_venta_pasivoDao.listaTramitesByZona(municipio, colonia);
	}



	@Override
	public List<Tramite_baja_venta_pasivo> lista() {
		// TODO Auto-generated method stub
		return tramite_baja_venta_pasivoDao.lista();
	}



	@Override
	public List<Tramite_baja_venta_pasivo> lista(String rol) {
		// TODO Auto-generated method stub
		return tramite_baja_venta_pasivoDao.lista(rol);
	}



	@Override
	public MensajeBean inserta(Tramite_baja_venta_pasivo nuevo) {
		// TODO Auto-generated method stub
		return tramite_baja_venta_pasivoDao.inserta(nuevo);
	}



	@Override
	public MensajeBean actualiza(Tramite_baja_venta_pasivo nuevo) {
		// TODO Auto-generated method stub
		return tramite_baja_venta_pasivoDao.actualiza(nuevo);
	}



	@Override
	public MensajeBean elimina(Tramite_baja_venta_pasivo nuevo) {
		// TODO Auto-generated method stub
		return tramite_baja_venta_pasivoDao.elimina(nuevo);
	}



	@Override
	public Tramite_baja_venta_pasivo consulta(
			Tramite_baja_venta_pasivo nuevo, String rol) {
		// TODO Auto-generated method stub
		return tramite_baja_venta_pasivoDao.consulta(nuevo, rol);
	}



	@Override
	public List<Tramite_baja_venta_pasivo> busquedaById(
			Tramite_baja_venta_pasivo nuevo) {
		// TODO Auto-generated method stub
		return tramite_baja_venta_pasivoDao.busquedaById(nuevo);
	}

}
