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
import com.mkyong.users.model.Tramite_reception_validacion_informacion;


@Repository("tramite_reception_validacion_informacionDao")
public class Tramite_reception_validacion_informacionDaoImpl implements Tramite_reception_validacion_informacionDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Tramite_reception_validacion_informacion> lista() {
		@SuppressWarnings("unchecked")
		List<Tramite_reception_validacion_informacion> users = sessionFactory.getCurrentSession().createCriteria(Tramite_reception_validacion_informacion.class).list();
		System.out.println("Tamanio List: "+users.size());
		return users;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Tramite_reception_validacion_informacion> lista(String rol) {
		List<Tramite_reception_validacion_informacion> list = new ArrayList<Tramite_reception_validacion_informacion>();
		if(rol.contentEquals("ROLE_RECEP")){
			list = sessionFactory.getCurrentSession().createCriteria(Tramite_reception_validacion_informacion.class)
					.add(Restrictions.eq("estatus", 1))
					.list();
		}else{
			list = sessionFactory.getCurrentSession().createCriteria(Tramite_reception_validacion_informacion.class)
					.add(Restrictions.ne("estatus", 1))
					.list();
		}
		
		return list;
	}


	@Override
	public MensajeBean inserta(Tramite_reception_validacion_informacion nuevo) {
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
			mensaje.setIdNumTramite(nuevo.getIdtramite_reception_validacion_informacion());
		} catch (HibernateException e) {
			System.out.println(e);
		}
		return mensaje;
	}

	@Override
	public MensajeBean actualiza(Tramite_reception_validacion_informacion nuevo) {
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
	public MensajeBean elimina(Tramite_reception_validacion_informacion nuevo) {
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
	public Tramite_reception_validacion_informacion consulta(Tramite_reception_validacion_informacion nuevo, String rol){
		List<Tramite_reception_validacion_informacion> list = new ArrayList<Tramite_reception_validacion_informacion>();
		Tramite_reception_validacion_informacion resultado = null;
		list = sessionFactory.getCurrentSession().createCriteria(Tramite_reception_validacion_informacion.class).add(Restrictions.eq("idtramite_reception_validacion_informacion", nuevo.getIdtramite_reception_validacion_informacion())).list();
		
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
				"Select tramite_reception_validacion_informacion.idtramite_reception_validacion_informacion as idtramite,'Recepción y Validación de información del COA' as tipo,'39' as idtipo,catalogo_perfilempresa.nombreEmpresa as nombre_empresa"+
				" from tramite_reception_validacion_informacion "+
				" left join catalogo_perfilestablecimiento "+ 
				" on catalogo_perfilestablecimiento.idcatalogo_perfilestablecimiento = tramite_reception_validacion_informacion.catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento"+
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
	public List<Tramite_reception_validacion_informacion> busquedaById(
			Tramite_reception_validacion_informacion nuevo) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Tramite_reception_validacion_informacion> users = sessionFactory.getCurrentSession().createCriteria(Tramite_reception_validacion_informacion.class).add(Restrictions.eq("idtramite_reception_validacion_informacion",nuevo.getIdtramite_reception_validacion_informacion())).list();
		System.out.println("Tamanio List: "+users.size());
		
		return users;
	}
}

