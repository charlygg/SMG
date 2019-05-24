package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mkyong.users.dao.Relation_files_uuiDao;
import com.mkyong.users.model.Relation_files_uui;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class Relation_files_uuiServiceImpl implements Relation_files_uuiService {

	@Autowired
	Relation_files_uuiDao relation_files_uuiDao;
	
	@Override
	public void insertRelation_files_uui(Relation_files_uui nuevo) {
		// TODO Auto-generated method stub
		relation_files_uuiDao.insertRelation_files_uui(nuevo);
	}

	@Override
	public List<Relation_files_uui> consultaRelation_files_uui(
			Relation_files_uui nuevo) {
		// TODO Auto-generated method stub
		return relation_files_uuiDao.consultaRelation_files_uui(nuevo);
	}

	@Override
	public void eliminarRelation_files_uui(Relation_files_uui nuevo) {
		// TODO Auto-generated method stub
		relation_files_uuiDao.eliminarRelation_files_uui(nuevo);
	}

	@Override
	public List<Relation_files_uui> buscarByName(String nombre) {
		// TODO Auto-generated method stub
		return relation_files_uuiDao.buscarByName(nombre);
	}

	
	
}
