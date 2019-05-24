package com.mkyong.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mkyong.users.dao.UserDao;
import com.mkyong.users.model.User;


@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;

	@Override
	public User findByUserName(String username) {
		// TODO Auto-generated method stub
		return userDao.findByUserName(username);
	}

	@Override
	public void insertUser(User nuevo) {
		// TODO Auto-generated method stub
		userDao.insertUser(nuevo);
	}

	@Override
	public void actualizarUser(User nuevo) {
		// TODO Auto-generated method stub
		userDao.actualizarUser(nuevo);
	}

	@Override
	public void eliminar(User nuevo) {
		// TODO Auto-generated method stub
		userDao.eliminar(nuevo);
	}


}
