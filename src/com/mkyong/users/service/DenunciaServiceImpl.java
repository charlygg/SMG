package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mkyong.users.dao.DenunciaDao;
import com.mkyong.users.model.Denuncia;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DenunciaServiceImpl implements DenunciaService {

	@Autowired
	DenunciaDao denunciaDao;

	@Override
	public List<Denuncia> searchList() {
		// TODO Auto-generated method stub
		return denunciaDao.searchList();
	}

	@Override
	public List<Denuncia> denunciaList(Denuncia nuevo) {
		// TODO Auto-generated method stub
		return denunciaDao.denunciaList(nuevo);
	}

	@Override
	public List<Denuncia> denunciaComboMunicipio() {
		// TODO Auto-generated method stub
		return denunciaDao.denunciaComboMunicipio();
	}

	@Override
	public List<Denuncia> denunciaComboColonia(Denuncia nuevo) {
		// TODO Auto-generated method stub
		return denunciaDao.denunciaComboColonia(nuevo);
	}
	
	@Override
	public List<Denuncia> searchList(Denuncia descripcionLista, String rol) {
		// TODO Auto-generated method stub
		return denunciaDao.searchList(descripcionLista,rol);
	}

	@Override
	public int insertDenuncia(Denuncia nuevo) {
		// TODO Auto-generated method stub
		return denunciaDao.insertDenuncia(nuevo);
	}

	@Override
	public void actualizarDenuncia(Denuncia nuevo) {
		// TODO Auto-generated method stub
		denunciaDao.actualizarDenuncia(nuevo);
	}

	@Override
	public void elimar(Denuncia nuevo) {
		// TODO Auto-generated method stub
		denunciaDao.elimar(nuevo);
	}

	@Override
	public Denuncia consultaDenuncia(Denuncia nuevo, String rol) {
		// TODO Auto-generated method stub
		return denunciaDao.consultaDenuncia(nuevo,rol);
	}
	@Override
	public Denuncia consultaDenuncia(Denuncia nuevo) {
		// TODO Auto-generated method stub
		return denunciaDao.consultaDenuncia(nuevo);
	}
	
	@Override
	public void actualizaEstatusProceso(Denuncia nuevo) {
		// TODO Auto-generated method stub
		 denunciaDao.actualizaEstatusProceso(nuevo);
	}
	@Override
	public void actualizaEstatusRecibido(Denuncia nuevo) {
		// TODO Auto-generated method stub
		 denunciaDao.actualizaEstatusRecibido(nuevo);
	}
	@Override
	public void actualizaEstatusDocumentacion(Denuncia nuevo) {
		// TODO Auto-generated method stub
		 denunciaDao.actualizaEstatusDocumentacion(nuevo);
	}
	@Override
	public void actualizaEstatusTerminado(Denuncia nuevo) {
		// TODO Auto-generated method stub
		 denunciaDao.actualizaEstatusTerminado(nuevo);
	}
}
