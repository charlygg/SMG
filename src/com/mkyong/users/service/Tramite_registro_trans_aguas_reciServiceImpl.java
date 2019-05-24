package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.dao.Tramite_registro_trans_aguas_reciDao;
import com.mkyong.users.model.Tramite_registro_trans_aguas_reci;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class Tramite_registro_trans_aguas_reciServiceImpl implements Tramite_registro_trans_aguas_reciService {
	
	@Autowired
	Tramite_registro_trans_aguas_reciDao tramite_registro_trans_aguas_reciDao;

	@Override
	public List<Tramite_registro_trans_aguas_reci> lista(String rol) {
		// TODO Auto-generated method stub
		return tramite_registro_trans_aguas_reciDao.lista(rol);
	}

	@Override
	public MensajeBean inserta(Tramite_registro_trans_aguas_reci nuevo) {
		// TODO Auto-generated method stub
		return tramite_registro_trans_aguas_reciDao.inserta(nuevo);
	}

	@Override
	public MensajeBean actualiza(Tramite_registro_trans_aguas_reci nuevo) {
		// TODO Auto-generated method stub
		return tramite_registro_trans_aguas_reciDao.actualiza(nuevo);
	}

	@Override
	public MensajeBean elimina(Tramite_registro_trans_aguas_reci nuevo) {
		// TODO Auto-generated method stub
		return tramite_registro_trans_aguas_reciDao.elimina(nuevo);
	}

	@Override
	public Tramite_registro_trans_aguas_reci consulta(Tramite_registro_trans_aguas_reci nuevo, String rol) {
		return tramite_registro_trans_aguas_reciDao.consulta(nuevo, rol);
	}

	@Override
	public List<WrapperTramite> listaTramitesByZona(String municipio,
			String colonia) {
		// TODO Auto-generated method stub
		return tramite_registro_trans_aguas_reciDao.listaTramitesByZona(municipio, colonia);
	}
}
