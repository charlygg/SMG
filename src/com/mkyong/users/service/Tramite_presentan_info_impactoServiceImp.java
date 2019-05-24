package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.dao.Tramite_presentan_info_impactoDao;
import com.mkyong.users.model.Tramite_presentan_info_impacto;

@Service
@Transactional(propagation=Propagation.SUPPORTS, readOnly = true)
public class Tramite_presentan_info_impactoServiceImp implements Tramite_presentan_info_impactoService {
	
	@Autowired
	Tramite_presentan_info_impactoDao tramite;

	@Override
	public List<Tramite_presentan_info_impacto> lista() {
		// TODO Auto-generated method stub
		return tramite.lista();
	}

	@Override
	public List<Tramite_presentan_info_impacto> lista(String rol) {
		// TODO Auto-generated method stub
		return tramite.lista(rol);
	}

	@Override
	public MensajeBean inserta(Tramite_presentan_info_impacto nuevo) {
		// TODO Auto-generated method stub
		return tramite.inserta(nuevo);
	}

	@Override
	public MensajeBean actualiza(Tramite_presentan_info_impacto nuevo) {
		// TODO Auto-generated method stub
		return tramite.actualiza(nuevo);
	}

	@Override
	public MensajeBean elimina(Tramite_presentan_info_impacto nuevo) {
		// TODO Auto-generated method stub
		return tramite.elimina(nuevo);
	}

	@Override
	public Tramite_presentan_info_impacto consulta(Tramite_presentan_info_impacto nuevo) {
		// TODO Auto-generated method stub
		return tramite.consulta(nuevo);
	}

	@Override
	public List<WrapperTramite> listaTramitesByZona(String municipio, String colonia) {
		// TODO Auto-generated method stub
		return tramite.listaTramitesByZona(municipio, colonia);
	}

	@Override
	public List<Tramite_presentan_info_impacto> busquedaById(Tramite_presentan_info_impacto nuevo) {
		// TODO Auto-generated method stub
		return tramite.busquedaById(nuevo);
	}

}
