package com.mkyong.users.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mkyong.users.model.RolMenu;

@Repository("rolMenuDao")
public class RolMenuDaoImpl implements RolMenuDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<RolMenu> listaRolMenu() {
		@SuppressWarnings("unchecked")
		List<RolMenu> listas = 
			sessionFactory.getCurrentSession().createCriteria(RolMenu.class)
			.addOrder( Order.asc("menu") )
    		.list();
		System.out.println("Tamanio List: "+listas.size());
		return listas;
	}
	
	@Override
	public List<RolMenu> ListaRolMenuPorRol(RolMenu nuevo) {
		@SuppressWarnings("unchecked")
		List<RolMenu> listas = 
			sessionFactory.getCurrentSession().createCriteria(RolMenu.class)
				.add(Restrictions.eq("rolID", nuevo.getRolID()))
				.addOrder( Order.asc("menu") )
				.list();
		System.out.println("RolID envio: "+nuevo.getRolID());
		System.out.println("Tamanio List: "+listas.size());
		return listas;
	}

	@Override
	public void insertaRolMenu(RolMenu nuevo) {
		// TODO Auto-generated method stub
		
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(nuevo);
		} catch (HibernateException e) {
			System.out.println(e);
		}
	}

	@Override
	public void actualizaRolMenu(RolMenu nuevo) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(nuevo);
		} catch (HibernateException e) {
			System.out.println(e);
		}
		
	}

	@Override
	public void eliminaRolMenu(RolMenu nuevo) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(nuevo);
	}
	

}
