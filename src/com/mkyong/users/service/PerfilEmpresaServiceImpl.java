package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.MensajeBean;
import com.mkyong.users.dao.PerfilEmpresaDao;
import com.mkyong.users.model.CatPerfilEmpresa;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PerfilEmpresaServiceImpl implements PerfilEmpresaService {
	
	@Autowired
	PerfilEmpresaDao perfilEmpresaDao;

	@Override
	public List<CatPerfilEmpresa> lista() {
		// TODO Auto-generated method stub
		return perfilEmpresaDao.lista();
	}

	@Override
	public MensajeBean inserta(CatPerfilEmpresa nuevo) {
		// TODO Auto-generated method stub
		return perfilEmpresaDao.inserta(nuevo);
	}

	@Override
	public MensajeBean actualiza(CatPerfilEmpresa nuevo) {
		// TODO Auto-generated method stub
		return perfilEmpresaDao.actualiza(nuevo);
	}

	@Override
	public MensajeBean elimina(CatPerfilEmpresa nuevo) {
		// TODO Auto-generated method stub
		return perfilEmpresaDao.elimina(nuevo);
	}

	@Override
	public CatPerfilEmpresa consulta(CatPerfilEmpresa nuevo) {
		return perfilEmpresaDao.consulta(nuevo);
	}
}
