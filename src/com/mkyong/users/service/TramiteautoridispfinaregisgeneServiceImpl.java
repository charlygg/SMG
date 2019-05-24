package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.dao.TramiteautoridispfinaregisgeneDao;
import com.mkyong.users.model.TramiteAutoriDispFinaRegisGene;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TramiteautoridispfinaregisgeneServiceImpl implements TramiteautoridispfinaregisgeneService {
	
	@Autowired
	TramiteautoridispfinaregisgeneDao tramiteautoridispfinaregisgeneDao;

	@Override
	public List<TramiteAutoriDispFinaRegisGene> lista(String rol) {
		// TODO Auto-generated method stub
		return tramiteautoridispfinaregisgeneDao.lista(rol);
	}

	@Override
	public MensajeBean inserta(TramiteAutoriDispFinaRegisGene nuevo) {
		// TODO Auto-generated method stub
		return tramiteautoridispfinaregisgeneDao.inserta(nuevo);
	}

	@Override
	public MensajeBean actualiza(TramiteAutoriDispFinaRegisGene nuevo) {
		// TODO Auto-generated method stub
		return tramiteautoridispfinaregisgeneDao.actualiza(nuevo);
	}

	@Override
	public MensajeBean elimina(TramiteAutoriDispFinaRegisGene nuevo) {
		// TODO Auto-generated method stub
		return tramiteautoridispfinaregisgeneDao.elimina(nuevo);
	}

	@Override
	public TramiteAutoriDispFinaRegisGene consulta(TramiteAutoriDispFinaRegisGene nuevo, String rol) {
		return tramiteautoridispfinaregisgeneDao.consulta(nuevo, rol);
	}

	@Override
	public List<WrapperTramite> listaTramitesByZona(String municipio,
			String colonia) {
		// TODO Auto-generated method stub
		return tramiteautoridispfinaregisgeneDao.listaTramitesByZona(municipio, colonia);
	}

	@Override
	public List<TramiteAutoriDispFinaRegisGene> busquedaById(
			TramiteAutoriDispFinaRegisGene nuevo) {
		// TODO Auto-generated method stub
		return tramiteautoridispfinaregisgeneDao.busquedaById(nuevo);
	}
}
