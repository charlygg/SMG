package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.dao.Tramite_presentan_info_residuosDao;
import com.mkyong.users.model.Tramite_presentan_info_residuos;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class Tramite_presentan_info_residuosServiceImp implements Tramite_presentan_info_residuosService {
	
	@Autowired
	Tramite_presentan_info_residuosDao tramite;

	@Override
	public List<WrapperTramite> listaTramitesByZona(String municipio, String colonia) {
		// TODO Auto-generated method stub
		return tramite.listaTramitesByZona(municipio, colonia);
	}

	@Override
	public List<Tramite_presentan_info_residuos> lista() {
		return tramite.lista();
	}

	@Override
	public List<Tramite_presentan_info_residuos> lista(String rol) {
		return tramite.lista(rol);
	}

	@Override
	public MensajeBean inserta(Tramite_presentan_info_residuos nuevo) {
		return tramite.inserta(nuevo);
	}

	@Override
	public MensajeBean actualiza(Tramite_presentan_info_residuos nuevo) {
		return tramite.actualiza(nuevo);
	}

	@Override
	public MensajeBean elimina(Tramite_presentan_info_residuos nuevo) {
		return tramite.elimina(nuevo);
	}

	@Override
	public Tramite_presentan_info_residuos consulta(Tramite_presentan_info_residuos nuevo) {
		return tramite.consulta(nuevo);
	}

	@Override
	public List<Tramite_presentan_info_residuos> busquedaById(Tramite_presentan_info_residuos nuevo) {
		// TODO Auto-generated method stub
		return tramite.busquedaById(nuevo);
	}

}
