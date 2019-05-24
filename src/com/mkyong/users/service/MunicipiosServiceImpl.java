package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mkyong.users.dao.MunicipioDao;
import com.mkyong.users.model.Municipios;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class MunicipiosServiceImpl implements MunicipiosService {
	
	@Autowired
	MunicipioDao municipioDao;

	@Override
	public List<Municipios> lista(Municipios municipio) {
		// TODO Auto-generated method stub
		return municipioDao.lista(municipio);
	}

}
