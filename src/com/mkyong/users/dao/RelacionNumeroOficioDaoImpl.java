package com.mkyong.users.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mkyong.users.model.RelacionNumeroOficio;


@Repository("relacionNumeroOficioDao")
public class RelacionNumeroOficioDaoImpl implements RelacionNumeroOficioDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insertRelacionNumeroOficio(RelacionNumeroOficio nuevo) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(nuevo);
		} catch (HibernateException e) {
			System.out.println(e);
		}
		
	}

	@Override
	public List<RelacionNumeroOficio> findRelacionNumeroOficioByIdtramiteIdTipoTramite(
			RelacionNumeroOficio busqueda) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<RelacionNumeroOficio> list = 
				sessionFactory.getCurrentSession().createCriteria(RelacionNumeroOficio.class)
				.add(Restrictions.eq("idtramite", busqueda.getIdtramite()))
				.add(Restrictions.eq("idtipo_tramite", busqueda.getIdtipo_tramite())).list();
		return list;
	}
	
	@Override
	public List<RelacionNumeroOficio> findRelacionNumeroOficioById(
			RelacionNumeroOficio busqueda) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<RelacionNumeroOficio> list = 
				sessionFactory.getCurrentSession().createCriteria(RelacionNumeroOficio.class)
				.add(Restrictions.eq("idrelacion_numeros_oficio", busqueda.getIdrelacion_numeros_oficio())).list();
		return list;
	}
}