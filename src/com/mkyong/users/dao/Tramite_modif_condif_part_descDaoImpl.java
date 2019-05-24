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
import com.mkyong.users.model.Tramite_modif_condif_part_desc;

@Repository("tramite_modif_condif_part_descDao")
public class Tramite_modif_condif_part_descDaoImpl implements Tramite_modif_condif_part_descDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Tramite_modif_condif_part_desc> lista() {
		@SuppressWarnings("unchecked")
		List<Tramite_modif_condif_part_desc> users = sessionFactory.getCurrentSession().createCriteria(Tramite_modif_condif_part_desc.class).list();
		System.out.println("Tamanio List: "+users.size());
		return users;
	}

	@Override
	public MensajeBean inserta(Tramite_modif_condif_part_desc nuevo) {
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
	public MensajeBean actualiza(Tramite_modif_condif_part_desc nuevo) {
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
	public MensajeBean elimina(Tramite_modif_condif_part_desc nuevo) {
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
	public Tramite_modif_condif_part_desc consulta(Tramite_modif_condif_part_desc nuevo, String rol){
		List<Tramite_modif_condif_part_desc> list = new ArrayList<Tramite_modif_condif_part_desc>();
		Tramite_modif_condif_part_desc resultado = null;
		list = sessionFactory.getCurrentSession().createCriteria(Tramite_modif_condif_part_desc.class).add(Restrictions.eq("idtramite", nuevo.getIdtramite())).list();
		
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
	public List<Tramite_modif_condif_part_desc> lista(String rol) {
		List<Tramite_modif_condif_part_desc> list = new ArrayList<Tramite_modif_condif_part_desc>();
		if(rol.contentEquals("ROLE_RECEP")){
			list = sessionFactory.getCurrentSession().createCriteria(Tramite_modif_condif_part_desc.class)
					.add(Restrictions.eq("estatus", 1))
					.list();
		}else{
			list = sessionFactory.getCurrentSession().createCriteria(Tramite_modif_condif_part_desc.class)
					.add(Restrictions.ne("estatus", 1))
					.list();
		}
		
		return list;
	}
	
	@Override
	public List<Tramite_modif_condif_part_desc> busquedaById(
			Tramite_modif_condif_part_desc nuevo) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Tramite_modif_condif_part_desc> users = sessionFactory.getCurrentSession().createCriteria(Tramite_modif_condif_part_desc.class).add(Restrictions.eq("idtramite",nuevo.getIdtramite())).list();
		System.out.println("Tamanio List: "+users.size());
		
		return users;
	}
	
	@Override
	public List<WrapperTramite> listaTramitesByZona(String municipio, String colonia) {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unchecked")
		List<WrapperTramite> resultWithAliasedBean = sessionFactory.getCurrentSession().createSQLQuery(
				"Select tramite_modif_condif_part_desc.idtramite as idtramite,'Modificación de las condiciones particulares de descarga según el parámetro y/o número de descarga.' as tipo,'25' as idtipo,catalogo_perfilempresa.nombreEmpresa as nombre_empresa"+
				" from tramite_modif_condif_part_desc "+
				" left join catalogo_perfilestablecimiento "+ 
				" on catalogo_perfilestablecimiento.idcatalogo_perfilestablecimiento = tramite_modif_condif_part_desc.idestablecimiento"+
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
