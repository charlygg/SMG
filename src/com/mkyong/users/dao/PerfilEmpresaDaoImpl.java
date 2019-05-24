package com.mkyong.users.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ixanaui.utils.MensajeBean;
import com.mkyong.users.model.CatPerfilEmpresa;

@Repository("perfilEmpresaDao")
public class PerfilEmpresaDaoImpl implements PerfilEmpresaDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<CatPerfilEmpresa> lista() {
		@SuppressWarnings("unchecked")
		List<CatPerfilEmpresa> users = sessionFactory.getCurrentSession().createCriteria(CatPerfilEmpresa.class).addOrder(Order.asc("nombreEmpresa")).list();
		System.out.println("Tamanio List: "+users.size());
		return users;
	}

//	@SuppressWarnings("unchecked")
//	@Override
//	public List<CatPerfilEmpresa> lista(String descripcionLista) {
//
//		List<CatPerfilEmpresa> list = new ArrayList<CatPerfilEmpresa>();
////		Denuncia resultado = new Denuncia();
//		try {
//			list=sessionFactory.getCurrentSession().createCriteria(CatPerfilEmpresa.class)
////					.add(Restrictions.like("nombre", "%"+descripcionLista.getDescripcion()+"%"))
////					.add(Restrictions.in("catalogo_denuncias_idcatalogo_denuncias", listacadenas))
//					.add(Restrictions.or(
//							Restrictions.like("nombre", "%"+descripcionLista.getDescripcion()+"%"))
//							,
//							Restrictions.like("nombre", "%"+descripcionLista.getDescripcion()+"%"))
//							)
//					.list();
//		System.out.println("El numero de objetos en la lista "+list.size());
//		} catch (HibernateException e) {
//			System.out.println(e);
//		}
//		return list;
//	}

	
	@Override
	public MensajeBean inserta(CatPerfilEmpresa nuevo) {
		// TODO Auto-generated method stub
		MensajeBean mensaje =  new MensajeBean();
		mensaje.setMensaje("Ingreso de Perfil Empresa Exitoso");
		mensaje.setNumero(0);
		mensaje.setReferencia("nombreEmpresa");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(nuevo);
		} catch (HibernateException e) {
			System.out.println(e);
		}
		return mensaje;
	}

	@Override
	public MensajeBean actualiza(CatPerfilEmpresa nuevo) {
		// TODO Auto-generated method stub
		MensajeBean mensaje =  new MensajeBean();
		mensaje.setMensaje("Modificaciíon de Perfil Empresa Exitoso");
		mensaje.setNumero(0);
		mensaje.setReferencia("nombreEmpresa");
		try {
			sessionFactory.getCurrentSession().update(nuevo);
		} catch (HibernateException e) {
			System.out.println(e);
			mensaje.setNumero(1);
			mensaje.setMensaje("Modificacion de Perfil Empresa");
		}
		return mensaje;
	}

	@Override
	public MensajeBean elimina(CatPerfilEmpresa nuevo) {
		// TODO Auto-generated method stub
		MensajeBean mensaje =  new MensajeBean();
		mensaje.setMensaje("Eliminación de Perfil Empresa Exitoso");
		mensaje.setNumero(0);
		mensaje.setReferencia("nombreEmpresa");
		sessionFactory.getCurrentSession().delete(nuevo);
		return mensaje;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public CatPerfilEmpresa consulta(CatPerfilEmpresa nuevo){
		List<CatPerfilEmpresa> list = new ArrayList<CatPerfilEmpresa>();
		CatPerfilEmpresa resultado = null;
		list = sessionFactory.getCurrentSession().createCriteria(CatPerfilEmpresa.class).add(Restrictions.eq("idcatalogo_perfilempresa", nuevo.getIdcatalogo_perfilempresa())).list();
		
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
