package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mkyong.users.dao.RolMenuDao;
import com.mkyong.users.model.RolMenu;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class RolMenuServiceImpl implements RolMenuService {
	
	@Autowired
	RolMenuDao rolMenuDao;

	@Override
	public List<RolMenu> ListaRolMenu() {
		// TODO Auto-generated method stub
		return rolMenuDao.listaRolMenu();
	}

	@Override
	public List<RolMenu> ListaRolMenuPorRol(RolMenu nuevo) {
		// TODO Auto-generated method stub
		return rolMenuDao.ListaRolMenuPorRol(nuevo);
	}
	
	@Override
	public void insertaRolMenu(RolMenu nuevo) {
		// TODO Auto-generated method stub
		rolMenuDao.insertaRolMenu(nuevo);
	}

	@Override
	public void actualizaRolMenu(RolMenu nuevo) {
		// TODO Auto-generated method stub
		rolMenuDao.actualizaRolMenu(nuevo);
	}

	@Override
	public void eliminaRolMenu(RolMenu nuevo) {
		// TODO Auto-generated method stub
		rolMenuDao.eliminaRolMenu(nuevo);
	}

}
