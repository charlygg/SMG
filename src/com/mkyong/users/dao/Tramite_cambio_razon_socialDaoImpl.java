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
import com.mkyong.users.model.Tramite_cambio_razon_social;

@Repository("tramite_cambio_razon_socialDao")
public class Tramite_cambio_razon_socialDaoImpl implements Tramite_cambio_razon_socialDao{
	
	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public List<Tramite_cambio_razon_social> lista() {
		@SuppressWarnings("unchecked")
		List<Tramite_cambio_razon_social> users = sessionFactory.getCurrentSession().createCriteria(Tramite_cambio_razon_social.class).list();
		System.out.println("Tamanio List: "+users.size());
		return users;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Tramite_cambio_razon_social> lista(String rol) {
		List<Tramite_cambio_razon_social> list = new ArrayList<Tramite_cambio_razon_social>();
		if(rol.contentEquals("ROLE_RECEP")){
			list = sessionFactory.getCurrentSession().createCriteria(Tramite_cambio_razon_social.class)
					.add(Restrictions.eq("estatus", 1))
					.list();
		}else{
			list = sessionFactory.getCurrentSession().createCriteria(Tramite_cambio_razon_social.class)
					.add(Restrictions.ne("estatus", 1))
					.list();
		}
		
		return list;
	}


	@Override
	public MensajeBean inserta(Tramite_cambio_razon_social nuevo) {
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
			mensaje.setIdNumTramite(nuevo.getIdtramite_cambio_razon_social());
		} catch (HibernateException e) {
			System.out.println(e);
		}
		return mensaje;
	}

	@Override
	public MensajeBean actualiza(Tramite_cambio_razon_social nuevo) {
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
	public MensajeBean elimina(Tramite_cambio_razon_social nuevo) {
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
	public Tramite_cambio_razon_social consulta(Tramite_cambio_razon_social nuevo, String rol){
		List<Tramite_cambio_razon_social> list = new ArrayList<Tramite_cambio_razon_social>();
		Tramite_cambio_razon_social resultado = null;
		list = sessionFactory.getCurrentSession().createCriteria(Tramite_cambio_razon_social.class).add(Restrictions.eq("idtramite_cambio_razon_social", nuevo.getIdtramite_cambio_razon_social())).list();
		
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
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unchecked")
		List<WrapperTramite> resultWithAliasedBean = sessionFactory.getCurrentSession().createSQLQuery(
				"Select tramite_cambio_razon_social.idtramite_cambio_razon_social as idtramite,'Cambio de Razón Social' as tipo,'3' as idtipo,catalogo_perfilempresa.nombreEmpresa as nombre_empresa"+
				" from tramite_cambio_razon_social "+
				" left join  catalogo_perfilestablecimiento"+ 
				" on catalogo_perfilestablecimiento.idcatalogo_perfilestablecimiento = tramite_cambio_razon_social.catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento"+
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


	@Override
	public List<Tramite_cambio_razon_social> busquedaById(
			Tramite_cambio_razon_social nuevo) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Tramite_cambio_razon_social> users = sessionFactory.getCurrentSession().createCriteria(Tramite_cambio_razon_social.class).add(Restrictions.eq("idtramite_cambio_razon_social",nuevo.getIdtramite_cambio_razon_social())).list();
		System.out.println("Tamanio List: "+users.size());
		
		return users;
	}

}
