package com.mkyong.users.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ixanaui.utils.MensajeBean;
import com.mkyong.users.model.Area;

@Repository("areaDao")
public class AreaDaoImpl implements AreaDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Area> searchList() {
		@SuppressWarnings("unchecked")
		List<Area> users = sessionFactory.getCurrentSession().createCriteria(Area.class).list();
		System.out.println("Tamanio List: "+users.size());
		return users;
	}

	@Override
	public void insertArea(Area nuevo) {
		// TODO Auto-generated method stub
		
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(nuevo);
		} catch (HibernateException e) {
			System.out.println(e);
		}
		
	}

	@Override
	public MensajeBean actualizarArea(Area nuevo) {
		// TODO Auto-generated method stub
		MensajeBean mensaje =  new MensajeBean();
		mensaje.setMensaje("Modificaciíon de Area Exitoso");
		mensaje.setNumero(0);
		mensaje.setReferencia("nombre");
		try {
			sessionFactory.getCurrentSession().update(nuevo);
		} catch (HibernateException e) {
			System.out.println(e);
			mensaje.setNumero(1);
			mensaje.setMensaje("Modificacion de Área");
		}
		return mensaje;
	}

	@Override
	public void elimar(Area nuevo) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(nuevo);
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public Area consultaArea(Area nuevo){
		List<Area> list = new ArrayList<Area>();
		Area resultado = new Area();
		list = sessionFactory.getCurrentSession().createCriteria(Area.class).add(Restrictions.eq("idareas", nuevo.getIdareas())).list();
		
		try {
			if(list.size() == 1 ){
				resultado =  list.get(0);
			}
		} catch (HibernateException e) {
			System.out.println(e);
		}
		return resultado;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Area consultaAreaByRole(Area nuevo){
		List<Area> list = new ArrayList<Area>();
		Area resultado = new Area();
		list = sessionFactory.getCurrentSession().createCriteria(Area.class).add(Restrictions.eq("role", nuevo.getRole())).list();
		
		try {
			if(list.size() == 1 ){
				resultado =  list.get(0);
			}
		} catch (HibernateException e) {
			System.out.println(e);
		}
		return resultado;
	}
}
