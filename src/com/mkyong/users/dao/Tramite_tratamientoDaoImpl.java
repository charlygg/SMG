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
import com.mkyong.users.model.Descargaaguasr;
import com.mkyong.users.model.Tramite_quema_cielo_abierto;
import com.mkyong.users.model.Tramite_tratamiento_aguasr;

@Repository("tramite_tratamientoDao")
public class Tramite_tratamientoDaoImpl implements Tramite_tratamientoDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Tramite_tratamiento_aguasr> lista() {
		@SuppressWarnings("unchecked")
		List<Tramite_tratamiento_aguasr> users = sessionFactory.getCurrentSession().createCriteria(Tramite_tratamiento_aguasr.class).list();
		System.out.println("Tamanio List: "+users.size());
		return users;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Tramite_tratamiento_aguasr> lista(String rol) {
		List<Tramite_tratamiento_aguasr> list = new ArrayList<Tramite_tratamiento_aguasr>();
		if(rol.contentEquals("ROLE_RECEP")){
			list = sessionFactory.getCurrentSession().createCriteria(Tramite_tratamiento_aguasr.class)
					.add(Restrictions.eq("estatus", 1))
					.list();
		}else{
			list = sessionFactory.getCurrentSession().createCriteria(Tramite_tratamiento_aguasr.class)
					.add(Restrictions.ne("estatus", 1))
					.list();
		}
		
		return list;
	}
	
	@Override
	public MensajeBean inserta(Tramite_tratamiento_aguasr nuevo) {
		// TODO Auto-generated method stub
		MensajeBean mensaje =  new MensajeBean();
		mensaje.setMensaje("Ingreso de Perfil Empresa Exitoso");
		mensaje.setNumero(0);
		mensaje.setReferencia("nombreEmpresa");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(nuevo);
			mensaje.setIdNumTramite(nuevo.getIdtramite_tratamiento());
		} catch (HibernateException e) {
			System.out.println(e);
		}
		return mensaje;
	}

	@Override
	public MensajeBean actualiza(Tramite_tratamiento_aguasr nuevo) {
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
	public MensajeBean elimina(Tramite_tratamiento_aguasr nuevo) {
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
	public Tramite_tratamiento_aguasr consulta(Tramite_tratamiento_aguasr nuevo){
		List<Tramite_tratamiento_aguasr> list = new ArrayList<Tramite_tratamiento_aguasr>();
		Tramite_tratamiento_aguasr resultado = null;
		list = sessionFactory.getCurrentSession().createCriteria(Tramite_tratamiento_aguasr.class).add(Restrictions.eq("idtramite_tratamiento", nuevo.getIdtramite_tratamiento())).list();
		
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
	public Tramite_tratamiento_aguasr consulta(Tramite_tratamiento_aguasr nuevo,String rol){
		List<Tramite_tratamiento_aguasr> list = new ArrayList<Tramite_tratamiento_aguasr>();
		Tramite_tratamiento_aguasr resultado = null;
		list = sessionFactory.getCurrentSession().createCriteria(Tramite_tratamiento_aguasr.class).add(Restrictions.eq("idtramite_tratamiento", nuevo.getIdtramite_tratamiento())).list();
		
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
				"Select tramite_tratamiento.idtramite_tratamiento as idtramite,'Registro de planta de tratamiento de aguas residuales' as tipo,'17' as idtipo, catalogo_perfilempresa.nombreEmpresa as nombre_empresa"+
				" from tramite_tratamiento "+
				" left join catalogo_perfilestablecimiento "+ 
				" on catalogo_perfilestablecimiento.idcatalogo_perfilestablecimiento = tramite_tratamiento.idestablecimiento"+
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
	public List<Tramite_tratamiento_aguasr> busquedaById(
			Tramite_tratamiento_aguasr nuevo) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Tramite_tratamiento_aguasr> users = sessionFactory.getCurrentSession().createCriteria(Tramite_tratamiento_aguasr.class).add(Restrictions.eq("idtramite_tratamiento",nuevo.getIdtramite_tratamiento())).list();
		System.out.println("Tamanio List: "+users.size());
		
		return users;
	}
}
