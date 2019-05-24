package com.mkyong.users.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.Tramite_pedreras;

@Repository("tramite_pedrerasDao")
public class Tramite_pedrerasDaoImpl implements Tramite_pedrerasDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Tramite_pedreras> busquedaById(Tramite_pedreras nuevo) {	
		@SuppressWarnings("unchecked")
		List<Tramite_pedreras> users = sessionFactory.getCurrentSession().createCriteria(Tramite_pedreras.class).add(Restrictions.eq("idtramite_pedreras",nuevo.getIdtramite_pedreras())).list();
		System.out.println("Tamanio List: "+users.size());
		return users;
	}

	@Override
	public List<Tramite_pedreras> lista() {
		@SuppressWarnings("unchecked")
		List<Tramite_pedreras> users = sessionFactory.getCurrentSession().createCriteria(Tramite_pedreras.class).list();
		System.out.println("Tamanio List: "+users.size());
		return users;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tramite_pedreras> lista(String rol) {
		List<Tramite_pedreras> list = new ArrayList<Tramite_pedreras>();
		if(rol.contentEquals("ROLE_RECEP")){
			list = sessionFactory.getCurrentSession().createCriteria(Tramite_pedreras.class)
					.add(Restrictions.eq("estatus", 1))
					.list();
		}else{
			list = sessionFactory.getCurrentSession().createCriteria(Tramite_pedreras.class)
					.add(Restrictions.ne("estatus", 1))
					.list();
		}
		return list;
	}

	@Override
	public MensajeBean inserta(Tramite_pedreras nuevo) {
		// TODO Auto-generated method stub
		MensajeBean mensaje =  new MensajeBean();
		mensaje.setMensaje("Ingreso de Perfil Empresa Exitoso");
		mensaje.setNumero(0);
		mensaje.setReferencia("nombreEmpresa");
		
		if(nuevo.getEstatus() == 0){
			nuevo.setEstatus(1);
		}
		if(nuevo.getEstatus() == 4){
			nuevo.setEstatus(1);
		}
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(nuevo);
			mensaje.setIdNumTramite(nuevo.getIdtramite_pedreras());
		} catch (HibernateException e) {
			System.out.println(e);
		}
		return mensaje;

	}

	@Override
	public MensajeBean actualiza(Tramite_pedreras nuevo) {
		// TODO Auto-generated method stub
		MensajeBean mensaje =  new MensajeBean();
		mensaje.setMensaje("Modificación de Perfil Empresa Exitoso");
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
	public MensajeBean elimina(Tramite_pedreras nuevo) {
		MensajeBean mensaje =  new MensajeBean();
		mensaje.setMensaje("Eliminación de Perfil Empresa Exitoso");
		mensaje.setNumero(0);
		mensaje.setReferencia("nombreEmpresa");
		sessionFactory.getCurrentSession().delete(nuevo);
		return mensaje;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Tramite_pedreras consulta(Tramite_pedreras nuevo) {
		List<Tramite_pedreras> list = new ArrayList<Tramite_pedreras>();
		Tramite_pedreras resultado = null;
		list = sessionFactory.getCurrentSession().createCriteria(Tramite_pedreras.class).add(Restrictions.eq("idtramite_pedreras", nuevo.getIdtramite_pedreras())).list();
		
		try {
			if(list.size() == 1 ){
				resultado =  list.get(0);
			}
		} catch (HibernateException e) {
			System.out.println(e);
		}
		return resultado;
	}

	@Override
	public List<WrapperTramite> listaTramitesByZona(String municipio, String colonia) {
		@SuppressWarnings("unchecked")
		List<WrapperTramite> resultWithAliasedBean = sessionFactory.getCurrentSession().createSQLQuery(
				"Select tramite_pedreras.idtramite_pedreras as idtramite,'Pedreras' as tipo,'49' as idtipo,catalogo_perfilempresa.nombreEmpresa as nombre_empresa"+
				" from tramite_pedreras "+
				" left join  catalogo_perfilestablecimiento"+ 
				" on catalogo_perfilestablecimiento.idcatalogo_perfilestablecimiento = tramite_pedreras.catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento"+
				" left join catalogo_perfilempresa on catalogo_perfilestablecimiento.idcatalogo_perfilempresa=catalogo_perfilempresa.idcatalogo_perfilempresa "+
				" where catalogo_perfilestablecimiento.municipio like'"+municipio+"' and catalogo_perfilestablecimiento.colonia like'"+colonia+"'")
				  .addScalar("idtramite")
				  .addScalar("tipo")
				   .addScalar("idtipo")
				  .addScalar("nombre_empresa")
				  .setResultTransformer( Transformers.aliasToBean(WrapperTramite.class))
				  .list();
		return resultWithAliasedBean;

	}

}
