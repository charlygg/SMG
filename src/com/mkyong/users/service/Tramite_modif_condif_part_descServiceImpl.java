package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.dao.Tramite_modif_condif_part_descDao;
import com.mkyong.users.model.Tramite_modif_condif_part_desc;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class Tramite_modif_condif_part_descServiceImpl implements Tramite_modif_condif_part_descService {
	
	@Autowired
	Tramite_modif_condif_part_descDao tramite_modif_condif_part_descDao;

	@Override
	public List<Tramite_modif_condif_part_desc> lista() {
		// TODO Auto-generated method stub
		return tramite_modif_condif_part_descDao.lista();
	}

	@Override
	public MensajeBean inserta(Tramite_modif_condif_part_desc nuevo) {
		// TODO Auto-generated method stub
		return tramite_modif_condif_part_descDao.inserta(nuevo);
	}

	@Override
	public MensajeBean actualiza(Tramite_modif_condif_part_desc nuevo) {
		// TODO Auto-generated method stub
		return tramite_modif_condif_part_descDao.actualiza(nuevo);
	}

	@Override
	public MensajeBean elimina(Tramite_modif_condif_part_desc nuevo) {
		// TODO Auto-generated method stub
		return tramite_modif_condif_part_descDao.elimina(nuevo);
	}

	@Override
	public List<WrapperTramite> listaTramitesByZona(String municipio,
			String colonia) {
		// TODO Auto-generated method stub
		return tramite_modif_condif_part_descDao.listaTramitesByZona(municipio, colonia);
	}

	@Override
	public List<Tramite_modif_condif_part_desc> busquedaById(Tramite_modif_condif_part_desc nuevo) {
		// TODO Auto-generated method stub
		return tramite_modif_condif_part_descDao.busquedaById(nuevo);
	}

	@Override
	public List<Tramite_modif_condif_part_desc> lista(String rol) {
		// TODO Auto-generated method stub
		return tramite_modif_condif_part_descDao.lista(rol);
	}

	@Override
	public Tramite_modif_condif_part_desc consulta(
			Tramite_modif_condif_part_desc nuevo, String rol) {
		// TODO Auto-generated method stub
		return tramite_modif_condif_part_descDao.consulta(nuevo, rol);
	}
}
