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
import com.mkyong.users.model.Tramite_actualizacion_tranps;


@Repository("tramite_actualizacion_tranpsDao")
public class Tramite_actualizacion_tranpsDaoImpl implements Tramite_actualizacion_tranpsDao{
	
	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public List<Tramite_actualizacion_tranps> lista() {
		@SuppressWarnings("unchecked")
		List<Tramite_actualizacion_tranps> users = sessionFactory.getCurrentSession().createCriteria(Tramite_actualizacion_tranps.class).list();
		System.out.println("Tamanio List: "+users.size());
		return users;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Tramite_actualizacion_tranps> lista(String rol) {
		List<Tramite_actualizacion_tranps> list = new ArrayList<Tramite_actualizacion_tranps>();
		if(rol.contentEquals("ROLE_RECEP")){
			list = sessionFactory.getCurrentSession().createCriteria(Tramite_actualizacion_tranps.class)
					.add(Restrictions.eq("estatus", 1))
					.list();
		}else{
			list = sessionFactory.getCurrentSession().createCriteria(Tramite_actualizacion_tranps.class)
					.add(Restrictions.ne("estatus", 1))
					.list();
		}
		
		return list;
	}


	@Override
	public MensajeBean inserta(Tramite_actualizacion_tranps nuevo) {
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
			mensaje.setIdNumTramite(nuevo.getIdtramite_actualizacion_tranps());
		} catch (HibernateException e) {
			System.out.println(e);
		}
		return mensaje;
	}

	@Override
	public MensajeBean actualiza(Tramite_actualizacion_tranps nuevo) {
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
	public MensajeBean elimina(Tramite_actualizacion_tranps nuevo) {
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
	public Tramite_actualizacion_tranps consulta(Tramite_actualizacion_tranps nuevo, String rol){
		List<Tramite_actualizacion_tranps> list = new ArrayList<Tramite_actualizacion_tranps>();
		Tramite_actualizacion_tranps resultado = null;
		list = sessionFactory.getCurrentSession().createCriteria(Tramite_actualizacion_tranps.class).add(Restrictions.eq("idtramite_actualizacion_tranps", nuevo.getIdtramite_actualizacion_tranps())).list();
		
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
				"Select tramite_actualizacion_tranps.idtramite_actualizacion_tranps as idtramite,'Actualización de transportistas' as tipo,'22' as idtipo,catalogo_perfilempresa.nombreEmpresa as nombre_empresa"+
				" from tramite_actualizacion_tranps "+
				" left join  catalogo_perfilestablecimiento"+ 
				" on catalogo_perfilestablecimiento.idcatalogo_perfilestablecimiento = tramite_actualizacion_tranps.catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento"+
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
	public List<Tramite_actualizacion_tranps> busquedaById(
			Tramite_actualizacion_tranps nuevo) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Tramite_actualizacion_tranps> users = sessionFactory.getCurrentSession().createCriteria(Tramite_actualizacion_tranps.class).add(Restrictions.eq("idtramite_actualizacion_tranps",nuevo.getIdtramite_actualizacion_tranps())).list();
		System.out.println("Tamanio List: "+users.size());
		
		return users;
	}

}
