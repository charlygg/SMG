package com.mkyong.users.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mkyong.users.model.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	
	@SuppressWarnings("unchecked")
	@Override
	public User findByUserName(String username) {
		List<User> users = new ArrayList<User>();
		users = sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.like("username", username)).list();

		if (users.size() > 0) {
			System.out.println("username: "+ users.get(0).getUsername());
			System.out.println("contrasenia: "+ users.get(0).getPassword());
			return users.get(0);
		} else {
			return null;
		}

	}


	@Override
	public void insertUser(User nuevo) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(nuevo);
		} catch (HibernateException e) {
			System.out.println(e);
		}
	}


	@Override
	public void actualizarUser(User nuevo) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(nuevo);
		} catch (HibernateException e) {
			System.out.println(e);
		}
	}


	@Override
	public void eliminar(User nuevo) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(nuevo);
	}

}