package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.MensajeBean;
import com.mkyong.users.dao.AreaDao;
import com.mkyong.users.model.Area;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AreaServiceImpl implements AreaService {
	
	@Autowired
	AreaDao areaDao;

	@Override
	public List<Area> searchList() {
		// TODO Auto-generated method stub
		return areaDao.searchList();
	}

	@Override
	public void insertArea(Area nuevo) {
		// TODO Auto-generated method stub
		areaDao.insertArea(nuevo);
	}

	@Override
	public MensajeBean actualizarArea(Area nuevo) {
		// TODO Auto-generated method stub
		return areaDao.actualizarArea(nuevo);
	}

	@Override
	public void elimar(Area nuevo) {
		// TODO Auto-generated method stub
		areaDao.elimar(nuevo);
	}

	@Override
	public Area consultaArea(Area nuevo) {
		return areaDao.consultaArea(nuevo);
	}

	@Override
	public Area consultaAreaByRole(Area nuevo) {
		// TODO Auto-generated method stub
		return areaDao.consultaAreaByRole(nuevo);
	}
}
