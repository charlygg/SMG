package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.dao.Tramite_instaplantratorresidDao;
import com.mkyong.users.model.Tramite_InstaPlanTraTorResid;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class Tramite_instaplantratorresidServiceImpl implements Tramite_instaplantratorresidService {
	
	@Autowired
	Tramite_instaplantratorresidDao tramite_instaplantratorresidDao;

	@Override
	public List<Tramite_InstaPlanTraTorResid> lista() {
		// TODO Auto-generated method stub
		return tramite_instaplantratorresidDao.lista();
	}

	@Override
	public MensajeBean inserta(Tramite_InstaPlanTraTorResid nuevo) {
		// TODO Auto-generated method stub
		return tramite_instaplantratorresidDao.inserta(nuevo);
	}

	@Override
	public MensajeBean actualiza(Tramite_InstaPlanTraTorResid nuevo) {
		// TODO Auto-generated method stub
		return tramite_instaplantratorresidDao.actualiza(nuevo);
	}

	@Override
	public MensajeBean elimina(Tramite_InstaPlanTraTorResid nuevo) {
		// TODO Auto-generated method stub
		return tramite_instaplantratorresidDao.elimina(nuevo);
	}

	@Override
	public Tramite_InstaPlanTraTorResid consulta(
			Tramite_InstaPlanTraTorResid nuevo, String rol) {
		// TODO Auto-generated method stub
		return tramite_instaplantratorresidDao.consulta(nuevo, rol);
	}

	@Override
	public List<Tramite_InstaPlanTraTorResid> lista(String rol) {
		// TODO Auto-generated method stub
		return tramite_instaplantratorresidDao.lista(rol);
	}

	@Override
	public List<WrapperTramite> listaTramitesByZona(String municipio,
			String colonia) {
		// TODO Auto-generated method stub
		return tramite_instaplantratorresidDao.listaTramitesByZona(municipio, colonia);
	}

	@Override
	public List<Tramite_InstaPlanTraTorResid> busquedaById(
			Tramite_InstaPlanTraTorResid nuevo) {
		// TODO Auto-generated method stub
		return tramite_instaplantratorresidDao.busquedaById(nuevo);
	}

	
}
