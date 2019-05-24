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
import com.mkyong.users.model.Tramite_cambio_razon_social;

@Repository("descargaaguasrDao")
public class DescargaaguasrDaoImpl implements DescargaaguasrDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Descargaaguasr> lista() {
		@SuppressWarnings("unchecked")
		List<Descargaaguasr> users = sessionFactory.getCurrentSession().createCriteria(Descargaaguasr.class).list();
		System.out.println("Tamanio List: "+users.size());
		return users;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Descargaaguasr> lista(String rol) {
		List<Descargaaguasr> list = new ArrayList<Descargaaguasr>();
		if(rol.contentEquals("ROLE_RECEP")){
			list = sessionFactory.getCurrentSession().createCriteria(Descargaaguasr.class)
					.add(Restrictions.eq("estatus", 1))
					.list();
		}else{
			list = sessionFactory.getCurrentSession().createCriteria(Descargaaguasr.class)
					.add(Restrictions.ne("estatus", 1))
					.list();
		}
		
		return list;

	}

	@Override
	public MensajeBean inserta(Descargaaguasr nuevo) {
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
	public MensajeBean actualiza(Descargaaguasr nuevo) {
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
	public MensajeBean elimina(Descargaaguasr nuevo) {
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
	public Descargaaguasr consulta(Descargaaguasr nuevo){
		List<Descargaaguasr> list = new ArrayList<Descargaaguasr>();
		Descargaaguasr resultado = null;
		list = sessionFactory.getCurrentSession().createCriteria(Descargaaguasr.class).add(Restrictions.eq("idtramite", nuevo.getIdtramite())).list();
		
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
				"Select tramite_descargaaguasr.idtramite as idtramite,'Registro de aguas residuales' as tipo,'16' as idtipo,catalogo_perfilempresa.nombreEmpresa as nombre_empresa"+
				" from catalogo_perfilestablecimiento"+
				" left join  tramite_descargaaguasr"+ 
				" on catalogo_perfilestablecimiento.idcatalogo_perfilestablecimiento = tramite_descargaaguasr.idestablecimiento"+
				" left join catalogo_perfilempresa on catalogo_perfilestablecimiento.idcatalogo_perfilempresa=catalogo_perfilempresa.idcatalogo_perfilempresa "+
				" where catalogo_perfilestablecimiento.municipio like '"+municipio+"' and catalogo_perfilestablecimiento.colonia like '"+colonia+"'")
				  .addScalar("idtramite")
				  .addScalar("tipo")
				   .addScalar("idtipo")
				  .addScalar("nombre_empresa")
				  .setResultTransformer( Transformers.aliasToBean(WrapperTramite.class))
				  .list();
		return resultWithAliasedBean;
	}


	@Override
	public List<Descargaaguasr> busquedaById(
			Descargaaguasr nuevo) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Descargaaguasr> users = sessionFactory.getCurrentSession().createCriteria(Descargaaguasr.class).add(Restrictions.eq("idtramite",nuevo.getIdtramite())).list();
		System.out.println("Tamanio List: "+users.size());
		
		return users;
	}
}
