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
import com.mkyong.users.model.Tramite_quema_cielo_abierto;

@Repository("tramite_quema_cielo_abiertoDao")
public class Tramite_quema_cielo_abiertoDaoImpl implements Tramite_quema_cielo_abiertoDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Tramite_quema_cielo_abierto> lista() {
		@SuppressWarnings("unchecked")
		List<Tramite_quema_cielo_abierto> users = sessionFactory.getCurrentSession().createCriteria(Tramite_quema_cielo_abierto.class).list();
		System.out.println("Tamanio List: "+users.size());
		return users;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Tramite_quema_cielo_abierto> lista(String rol) {
		List<Tramite_quema_cielo_abierto> list = new ArrayList<Tramite_quema_cielo_abierto>();
		if(rol.contentEquals("ROLE_RECEP")){
			list = sessionFactory.getCurrentSession().createCriteria(Tramite_quema_cielo_abierto.class)
					.add(Restrictions.eq("estatus", 1))
					.list();
		}else{
			list = sessionFactory.getCurrentSession().createCriteria(Tramite_quema_cielo_abierto.class)
					.add(Restrictions.ne("estatus", 1))
					.list();
		}
		
		return list;
	}


	@Override
	public MensajeBean inserta(Tramite_quema_cielo_abierto nuevo) {
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
			mensaje.setIdNumTramite(nuevo.getIdtramite_quema_cielo_abierto());
		} catch (HibernateException e) {
			System.out.println(e);
		}
		return mensaje;
	}

	@Override
	public MensajeBean actualiza(Tramite_quema_cielo_abierto nuevo) {
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
	public MensajeBean elimina(Tramite_quema_cielo_abierto nuevo) {
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
	public Tramite_quema_cielo_abierto consulta(Tramite_quema_cielo_abierto nuevo, String rol){
		List<Tramite_quema_cielo_abierto> list = new ArrayList<Tramite_quema_cielo_abierto>();
		Tramite_quema_cielo_abierto resultado = null;
		list = sessionFactory.getCurrentSession().createCriteria(Tramite_quema_cielo_abierto.class).add(Restrictions.eq("idtramite_quema_cielo_abierto", nuevo.getIdtramite_quema_cielo_abierto())).list();
		
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
				"Select tramite_quema_cielo_abierto.idtramite_quema_cielo_abierto as idtramite,'Quema a cielo abierto' as tipo,'2' as idtipo,catalogo_perfilempresa.nombreEmpresa as nombre_empresa"+
				" from tramite_quema_cielo_abierto "+
				" left join  catalogo_perfilestablecimiento"+ 
				" on catalogo_perfilestablecimiento.idcatalogo_perfilestablecimiento = tramite_quema_cielo_abierto.catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento"+
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
	public List<Tramite_quema_cielo_abierto> busquedaById(
			Tramite_quema_cielo_abierto nuevo) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Tramite_quema_cielo_abierto> users = sessionFactory.getCurrentSession().createCriteria(Tramite_quema_cielo_abierto.class).add(Restrictions.eq("idtramite_quema_cielo_abierto",nuevo.getIdtramite_quema_cielo_abierto())).list();
		System.out.println("Tamanio List: "+users.size());
		
		return users;
	}
}
