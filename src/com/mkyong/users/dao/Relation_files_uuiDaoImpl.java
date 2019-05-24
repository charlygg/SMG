package com.mkyong.users.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mkyong.users.model.Relation_files_uui;

@Repository("relation_files_uuiDao")
public class Relation_files_uuiDaoImpl implements Relation_files_uuiDao  {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void insertRelation_files_uui(Relation_files_uui nuevo) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(nuevo);
		} catch (HibernateException e) {
			System.out.println(e);
		}
	}

	@Override
	public List<Relation_files_uui> consultaRelation_files_uui(
			Relation_files_uui nuevo) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Relation_files_uui> list = sessionFactory.getCurrentSession().createCriteria(Relation_files_uui.class).add(Restrictions.eq("UUI", nuevo.getUUI())).list();
	
		return list;
	}

	@Override
	public void eliminarRelation_files_uui(Relation_files_uui nuevo) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(nuevo);
	}

	@Override
	public List<Relation_files_uui> buscarByName(String nombre) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Relation_files_uui> list = sessionFactory.getCurrentSession().createCriteria(Relation_files_uui.class).add(Restrictions.eq("name",nombre)).list();
		return list;
	}

}
