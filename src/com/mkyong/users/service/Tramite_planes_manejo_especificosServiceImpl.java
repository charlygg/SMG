package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.dao.Tramite_planes_manejo_especificosDao;
import com.mkyong.users.model.Tramite_planes_manejo_especificos;


@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class Tramite_planes_manejo_especificosServiceImpl implements Tramite_planes_manejo_especificosService {
	
	@Autowired
	Tramite_planes_manejo_especificosDao Tramite_planes_manejo_especificosDao;

	@Override
	public List<Tramite_planes_manejo_especificos> lista() {
		// TODO Auto-generated method stub
		return Tramite_planes_manejo_especificosDao.lista();
	}
	
	@Override
	public List<Tramite_planes_manejo_especificos> lista(String rol) {
		// TODO Auto-generated method stub
		return Tramite_planes_manejo_especificosDao.lista(rol);
	}


	@Override
	public MensajeBean inserta(Tramite_planes_manejo_especificos nuevo) {
		// TODO Auto-generated method stub
		return Tramite_planes_manejo_especificosDao.inserta(nuevo);
	}

	@Override
	public MensajeBean actualiza(Tramite_planes_manejo_especificos nuevo) {
		// TODO Auto-generated method stub
		return Tramite_planes_manejo_especificosDao.actualiza(nuevo);
	}

	@Override
	public MensajeBean elimina(Tramite_planes_manejo_especificos nuevo) {
		// TODO Auto-generated method stub
		return Tramite_planes_manejo_especificosDao.elimina(nuevo);
	}

	@Override
	public Tramite_planes_manejo_especificos consulta(Tramite_planes_manejo_especificos nuevo, String rol) {
		return Tramite_planes_manejo_especificosDao.consulta(nuevo, rol);
	}

	@Override
	public List<WrapperTramite> listaTramitesByZona(String municipio,
			String colonia) {
		// TODO Auto-generated method stub
		return Tramite_planes_manejo_especificosDao.listaTramitesByZona(municipio, colonia);
	}

	@Override
	public List<Tramite_planes_manejo_especificos> busquedaById(
			Tramite_planes_manejo_especificos nuevo) {
		// TODO Auto-generated method stub
		return Tramite_planes_manejo_especificosDao.busquedaById(nuevo);
	}
}

