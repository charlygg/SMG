package com.mkyong.users.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ixanaui.utils.MensajeBean;
import com.mkyong.users.model.NumeroOficio;

@Repository("numerooficioDao")
public class NumeroOficioDaoImpl implements NumeroOficioDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public MensajeBean actualizarNumeroOficio(NumeroOficio nuevo) {
		// TODO Auto-generated method stub
		MensajeBean mensaje =  new MensajeBean();
		mensaje.setMensaje("Modificaciíon de NumeroOficio Exitoso");
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

	@SuppressWarnings("unchecked")
	@Override
	public NumeroOficio buscarNumeroOficio(NumeroOficio data) {
		// TODO Auto-generated method stub
		List<NumeroOficio> list = new ArrayList<NumeroOficio>();
		NumeroOficio resultado = null;
		list = sessionFactory.getCurrentSession().createCriteria(NumeroOficio.class)
				.add(Restrictions.and(Restrictions.like("tipo", data.getTipo()), Restrictions.like("area", data.getArea()))).list();
		
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
