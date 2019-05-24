package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.dao.Tramite_operacion_vehi_recolectoresDao;
import com.mkyong.users.model.Tramite_operacion_vehi_recolectores;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class Tramite_operacion_vehi_recolectoresServiceImpl implements Tramite_operacion_vehi_recolectoresService {
	
	@Autowired
	Tramite_operacion_vehi_recolectoresDao tramite_operacion_vehi_recolectoresDao;

	@Override
	public List<Tramite_operacion_vehi_recolectores> lista() {
		// TODO Auto-generated method stub
		return tramite_operacion_vehi_recolectoresDao.lista();
	}
	
	@Override
	public List<Tramite_operacion_vehi_recolectores> lista(String rol) {
		// TODO Auto-generated method stub
		return tramite_operacion_vehi_recolectoresDao.lista(rol);
	}


	@Override
	public MensajeBean inserta(Tramite_operacion_vehi_recolectores nuevo) {
		// TODO Auto-generated method stub
		return tramite_operacion_vehi_recolectoresDao.inserta(nuevo);
	}

	@Override
	public MensajeBean actualiza(Tramite_operacion_vehi_recolectores nuevo) {
		// TODO Auto-generated method stub
		return tramite_operacion_vehi_recolectoresDao.actualiza(nuevo);
	}

	@Override
	public MensajeBean elimina(Tramite_operacion_vehi_recolectores nuevo) {
		// TODO Auto-generated method stub
		return tramite_operacion_vehi_recolectoresDao.elimina(nuevo);
	}

	@Override
	public Tramite_operacion_vehi_recolectores consulta(Tramite_operacion_vehi_recolectores nuevo, String rol) {
		return tramite_operacion_vehi_recolectoresDao.consulta(nuevo, rol);
	}

	@Override
	public List<WrapperTramite> listaTramitesByZona(String municipio,
			String colonia) {
		// TODO Auto-generated method stub
		return tramite_operacion_vehi_recolectoresDao.listaTramitesByZona(municipio, colonia);
	}

	@Override
	public List<Tramite_operacion_vehi_recolectores> busquedaById(
			Tramite_operacion_vehi_recolectores nuevo) {
		// TODO Auto-generated method stub
		return tramite_operacion_vehi_recolectoresDao.busquedaById(nuevo);
	}
}

