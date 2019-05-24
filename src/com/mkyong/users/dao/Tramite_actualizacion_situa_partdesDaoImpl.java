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
import com.mkyong.users.model.Tramite_actualizacion_situa_partdes;

@Repository("tramite_actualizacion_situa_partdesDao")
public class Tramite_actualizacion_situa_partdesDaoImpl implements Tramite_actualizacion_situa_partdesDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Tramite_actualizacion_situa_partdes> lista() {
		@SuppressWarnings("unchecked")
		List<Tramite_actualizacion_situa_partdes> users = sessionFactory.getCurrentSession().createCriteria(Tramite_actualizacion_situa_partdes.class).list();
		System.out.println("Tamanio List: "+users.size());
		return users;
	}

	@Override
	public MensajeBean inserta(Tramite_actualizacion_situa_partdes nuevo) {
		// TODO Auto-generated method stub
		MensajeBean mensaje =  new MensajeBean();
		mensaje.setMensaje("Ingreso de Perfil Empresa Exitoso");
		mensaje.setNumero(0);
		mensaje.setReferencia("nombreEmpresa");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(nuevo);
			mensaje.setIdNumTramite(nuevo.getIdtramite());
		} catch (HibernateException e) {
			System.out.println(e);
		}
		return mensaje;
	}

	@Override
	public MensajeBean actualiza(Tramite_actualizacion_situa_partdes nuevo) {
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
	public MensajeBean elimina(Tramite_actualizacion_situa_partdes nuevo) {
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
	public Tramite_actualizacion_situa_partdes consulta(Tramite_actualizacion_situa_partdes nuevo, String rol){
		List<Tramite_actualizacion_situa_partdes> list = new ArrayList<Tramite_actualizacion_situa_partdes>();
		Tramite_actualizacion_situa_partdes resultado = null;
		list = sessionFactory.getCurrentSession().createCriteria(Tramite_actualizacion_situa_partdes.class).add(Restrictions.eq("idtramite", nuevo.getIdtramite())).list();
		
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
	public List<Tramite_actualizacion_situa_partdes> lista(String rol) {
		List<Tramite_actualizacion_situa_partdes> list = new ArrayList<Tramite_actualizacion_situa_partdes>();
		if(rol.contentEquals("ROLE_RECEP")){
			list = sessionFactory.getCurrentSession().createCriteria(Tramite_actualizacion_situa_partdes.class)
					.add(Restrictions.eq("estatus", 1))
					.list();
		}else{
			list = sessionFactory.getCurrentSession().createCriteria(Tramite_actualizacion_situa_partdes.class)
					.add(Restrictions.ne("estatus", 1))
					.list();
		}
		
		return list;
	}
	
	@Override
	public List<Tramite_actualizacion_situa_partdes> busquedaById(
			Tramite_actualizacion_situa_partdes nuevo) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Tramite_actualizacion_situa_partdes> users = sessionFactory.getCurrentSession().createCriteria(Tramite_actualizacion_situa_partdes.class).add(Restrictions.eq("idtramite",nuevo.getIdtramite())).list();
		System.out.println("Tamanio List: "+users.size());
		
		return users;
	}
	
	@Override
	public List<WrapperTramite> listaTramitesByZona(String municipio, String colonia) {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unchecked")
		List<WrapperTramite> resultWithAliasedBean = sessionFactory.getCurrentSession().createSQLQuery(
				"Select tramite_actualizacion_situa_partdes.idtramite as idtramite,'Actualización de situación particular de descarga' as tipo,'23' as idtipo,catalogo_perfilempresa.nombreEmpresa as nombre_empresa"+
				" from tramite_actualizacion_situa_partdes"+
				" left join   catalogo_perfilestablecimiento"+ 
				" on catalogo_perfilestablecimiento.idcatalogo_perfilestablecimiento = tramite_actualizacion_situa_partdes.idestablecimiento"+
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
