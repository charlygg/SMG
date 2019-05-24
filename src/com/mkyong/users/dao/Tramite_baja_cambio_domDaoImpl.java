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
import com.mkyong.users.model.Tramite_baja_cambio_dom;

@Repository("tramite_baja_cambio_domDao")
public class Tramite_baja_cambio_domDaoImpl implements Tramite_baja_cambio_domDao{
	
	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public List<Tramite_baja_cambio_dom> lista() {
		@SuppressWarnings("unchecked")
		List<Tramite_baja_cambio_dom> users = sessionFactory.getCurrentSession().createCriteria(Tramite_baja_cambio_dom.class).list();
		System.out.println("Tamanio List: "+users.size());
		return users;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Tramite_baja_cambio_dom> lista(String rol) {
		List<Tramite_baja_cambio_dom> list = new ArrayList<Tramite_baja_cambio_dom>();
		if(rol.contentEquals("ROLE_RECEP")){
			list = sessionFactory.getCurrentSession().createCriteria(Tramite_baja_cambio_dom.class)
					.add(Restrictions.eq("estatus", 1))
					.list();
		}else{
			list = sessionFactory.getCurrentSession().createCriteria(Tramite_baja_cambio_dom.class)
					.add(Restrictions.ne("estatus", 1))
					.list();
		}
		
		return list;
	}


	@Override
	public MensajeBean inserta(Tramite_baja_cambio_dom nuevo) {
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
			mensaje.setIdNumTramite(nuevo.getIdtramite_baja_cambio_dom());
		} catch (HibernateException e) {
			System.out.println(e);
		}
		return mensaje;
	}

	@Override
	public MensajeBean actualiza(Tramite_baja_cambio_dom nuevo) {
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
	public MensajeBean elimina(Tramite_baja_cambio_dom nuevo) {
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
	public Tramite_baja_cambio_dom consulta(Tramite_baja_cambio_dom nuevo, String rol){
		List<Tramite_baja_cambio_dom> list = new ArrayList<Tramite_baja_cambio_dom>();
		Tramite_baja_cambio_dom resultado = null;
		list = sessionFactory.getCurrentSession().createCriteria(Tramite_baja_cambio_dom.class).add(Restrictions.eq("idtramite_baja_cambio_dom", nuevo.getIdtramite_baja_cambio_dom())).list();
		
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
				"Select tramite_baja_cambio_dom.idtramite_baja_cambio_dom as idtramite,'Baja por cambio de domicilio' as tipo,'24' as idtipo,catalogo_perfilempresa.nombreEmpresa as nombre_empresa"+
				" from tramite_baja_cambio_dom "+
				" left join  catalogo_perfilestablecimiento"+ 
				" on catalogo_perfilestablecimiento.idcatalogo_perfilestablecimiento = tramite_baja_cambio_dom.catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento"+
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
	public List<Tramite_baja_cambio_dom> busquedaById(
			Tramite_baja_cambio_dom nuevo) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Tramite_baja_cambio_dom> users = sessionFactory.getCurrentSession().createCriteria(Tramite_baja_cambio_dom.class).add(Restrictions.eq("idtramite_baja_cambio_dom",nuevo.getIdtramite_baja_cambio_dom())).list();
		System.out.println("Tamanio List: "+users.size());
		
		return users;
	}

}

