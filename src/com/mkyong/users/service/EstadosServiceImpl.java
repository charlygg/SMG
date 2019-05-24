package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mkyong.users.dao.EstadosDao;
import com.mkyong.users.model.Estados;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class EstadosServiceImpl implements EstadosService {
	
	@Autowired
	EstadosDao estadosDao;

	@Override
	public List<Estados> lista() {
		// TODO Auto-generated method stub
		return estadosDao.lista();
	}

}
