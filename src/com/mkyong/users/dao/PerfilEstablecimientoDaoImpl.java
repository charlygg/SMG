package com.mkyong.users.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ixanaui.utils.MensajeBean;
import com.mkyong.users.model.CatPerfilEstablecimiento;

@Repository("perfilEstablecimientoDao")
public class PerfilEstablecimientoDaoImpl implements PerfilEstablecimientoDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<CatPerfilEstablecimiento> lista() {
		@SuppressWarnings("unchecked")
		List<CatPerfilEstablecimiento> users = sessionFactory.getCurrentSession().createCriteria(CatPerfilEstablecimiento.class).list();
		System.out.println("Tamanio List: "+users.size());
		return users;
	}

	@Override
	public MensajeBean inserta(CatPerfilEstablecimiento nuevo) {
		// TODO Auto-generated method stub
		MensajeBean mensaje =  new MensajeBean();
		mensaje.setMensaje("Ingreso de Perfil Empresa Exitoso");
		mensaje.setNumero(0);
		mensaje.setReferencia("nombreEmpresa");
		try {
			MensajeBean aux = consultaMatriz(nuevo);
			
			if(aux.getNumero() > 0 && nuevo.getMatriz() != null){
				mensaje = aux;
			}
			sessionFactory.getCurrentSession().saveOrUpdate(nuevo);
		} catch (HibernateException e) {
			System.out.println(e);
		}
		return mensaje;
	}

	@Override
	public MensajeBean actualiza(CatPerfilEstablecimiento nuevo) {
		// TODO Auto-generated method stub
		MensajeBean mensaje =  new MensajeBean();
		mensaje.setMensaje("Modificaciíon de Perfil Establecimiento Exitoso");
		mensaje.setNumero(0);
		mensaje.setReferencia("nombreEmpresa");
		try {
			sessionFactory.getCurrentSession().update(nuevo);
		} catch (HibernateException e) {
			System.out.println(e);
			mensaje.setNumero(1);
			mensaje.setMensaje("Modificacion de Perfil Establecimiento");
		}
		return mensaje;
	}

	@Override
	public MensajeBean elimina(CatPerfilEstablecimiento nuevo) {
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
	public CatPerfilEstablecimiento consulta(CatPerfilEstablecimiento nuevo){
		List<CatPerfilEstablecimiento> list = new ArrayList<CatPerfilEstablecimiento>();
		CatPerfilEstablecimiento resultado = null;
		list = sessionFactory.getCurrentSession().createCriteria(CatPerfilEstablecimiento.class).add(Restrictions.eq("idcatalogo_perfilestablecimiento", nuevo.getIdcatalogo_perfilestablecimiento())).list();
		
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
	public List<CatPerfilEstablecimiento> consultaListByEmpresa(CatPerfilEstablecimiento nuevo){
		List<CatPerfilEstablecimiento> list  = sessionFactory.getCurrentSession().createCriteria(CatPerfilEstablecimiento.class).add(Restrictions.eq("idcatalogo_perfilempresa", nuevo.getIdcatalogo_perfilempresa())).list();
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public MensajeBean consultaMatriz(CatPerfilEstablecimiento nuevo){
		MensajeBean mensaje =  new MensajeBean();
		mensaje.setMensaje("Ingreso no existe Matriz aún");
		mensaje.setNumero(0);
		mensaje.setReferencia("matriz");
		try {
			List<CatPerfilEstablecimiento> list = new ArrayList<CatPerfilEstablecimiento>();
			list = sessionFactory.getCurrentSession().createCriteria(CatPerfilEstablecimiento.class)
					.add(Restrictions.eq("idcatalogo_perfilempresa", nuevo.getIdcatalogo_perfilempresa()))
					.add(Restrictions.eq("matriz", "on"))
					.list();
			
			if(list.size() > 0 ){
				mensaje.setMensaje("Ya existe un establecimiento Matriz");
				mensaje.setNumero(1);
				mensaje.setReferencia("matriz");
			}
		} catch (HibernateException e) {
			System.out.println(e);
		}
		return mensaje;
	}

	@Override
	public List<String> getMunicipiosEstablecimientos() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<String> list = sessionFactory.getCurrentSession().createCriteria(CatPerfilEstablecimiento.class).setProjection(Projections.distinct(Projections.property("municipio"))).list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getColoniasPorMunicipios(String municipio) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(CatPerfilEstablecimiento.class).setProjection(Projections.distinct(Projections.property("colonia"))).add(Restrictions.eq("municipio", municipio)).list();
	}
}
