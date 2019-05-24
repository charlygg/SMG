package com.mkyong.users.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mkyong.users.model.Estados;

@Repository("estadosDao")
public class EstadosDaoImpl implements EstadosDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Estados> lista() {
		@SuppressWarnings("unchecked")
		List<Estados> users = sessionFactory.getCurrentSession().createCriteria(Estados.class).list();
		return users;
	}

	
}
