package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.WrapperMuro;
import com.mkyong.users.dao.MuroDao;
import com.mkyong.users.model.Muro;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class MuroServiceImpl implements MuroService {

	@Autowired
	MuroDao muroDao;
	
	@Override
	public List<Muro> searchList() {
		// TODO Auto-generated method stub
		return muroDao.searchList();
	}

	@Override
	public void insertMuro(Muro nuevo) {
		// TODO Auto-generated method stub
		muroDao.insertMuro(nuevo);
	}

	@Override
	public Muro consultaMuro(Muro nuevo) {
		// TODO Auto-generated method stub
		return muroDao.consultaMuro(nuevo);
	}

	@Override
	public List<WrapperMuro> getDatosMuro() {
		// TODO Auto-generated method stub
		return muroDao.getDatosMuro();
	}

}
