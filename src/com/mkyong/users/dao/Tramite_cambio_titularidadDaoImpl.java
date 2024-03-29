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
import com.mkyong.users.model.Tramite_cambio_titularidad;

@Repository("tramite_cambio_titularidadDao")
public class Tramite_cambio_titularidadDaoImpl implements Tramite_cambio_titularidadDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Tramite_cambio_titularidad> lista() {
		@SuppressWarnings("unchecked")
		List<Tramite_cambio_titularidad> users = sessionFactory.getCurrentSession().createCriteria(Tramite_cambio_titularidad.class).list();
		System.out.println("Tamanio List: "+users.size());
		return users;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Tramite_cambio_titularidad> lista(String rol) {
		List<Tramite_cambio_titularidad> list = new ArrayList<Tramite_cambio_titularidad>();
		if(rol.contentEquals("ROLE_RECEP")){
			list = sessionFactory.getCurrentSession().createCriteria(Tramite_cambio_titularidad.class)
					.add(Restrictions.eq("estatus", 1))
					.list();
		}else{
			list = sessionFactory.getCurrentSession().createCriteria(Tramite_cambio_titularidad.class)
					.add(Restrictions.ne("estatus", 1))
					.list();
		}
		
		return list;
	}


	@Override
	public MensajeBean inserta(Tramite_cambio_titularidad nuevo) {
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
			mensaje.setIdNumTramite(nuevo.getIdtramite_cambio_titularidad());
		} catch (HibernateException e) {
			System.out.println(e);
		}
		return mensaje;
	}

	@Override
	public MensajeBean actualiza(Tramite_cambio_titularidad nuevo) {
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
	public MensajeBean elimina(Tramite_cambio_titularidad nuevo) {
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
	public Tramite_cambio_titularidad consulta(Tramite_cambio_titularidad nuevo, String rol){
		List<Tramite_cambio_titularidad> list = new ArrayList<Tramite_cambio_titularidad>();
		Tramite_cambio_titularidad resultado = null;
		list = sessionFactory.getCurrentSession().createCriteria(Tramite_cambio_titularidad.class).add(Restrictions.eq("idtramite_cambio_titularidad", nuevo.getIdtramite_cambio_titularidad())).list();
		
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
				"Select tramite_cambio_titularidad.idtramite_cambio_titularidad as idtramite,'Cambio de titularidad' as tipo,'7' as idtipo,catalogo_perfilempresa.nombreEmpresa as nombre_empresa"+
				" from tramite_cambio_titularidad"+
				" left join   catalogo_perfilestablecimiento"+ 
				" on catalogo_perfilestablecimiento.idcatalogo_perfilestablecimiento = tramite_cambio_titularidad.catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento"+
				" left join catalogo_perfilempresa on catalogo_perfilestablecimiento.idcatalogo_perfilempresa=catalogo_perfilempresa.idcatalogo_perfilempresa "+
				" where catalogo_perfilestablecimiento.municipio like'"+municipio+"' and catalogo_perfilestablecimiento.colonia like'"+colonia+"'")
				  .addScalar("idtramite")
				   .addScalar("idtipo")
				  .addScalar("tipo")
				  .addScalar("nombre_empresa")
				  .setResultTransformer( Transformers.aliasToBean(WrapperTramite.class))
				  .list();
		return resultWithAliasedBean;
	}
	
	@Override
	public List<Tramite_cambio_titularidad> busquedaById(
			Tramite_cambio_titularidad nuevo) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Tramite_cambio_titularidad> users = sessionFactory.getCurrentSession().createCriteria(Tramite_cambio_titularidad.class).add(Restrictions.eq("idtramite_cambio_titularidad",nuevo.getIdtramite_cambio_titularidad())).list();
		System.out.println("Tamanio List: "+users.size());
		
		return users;
	}
}
