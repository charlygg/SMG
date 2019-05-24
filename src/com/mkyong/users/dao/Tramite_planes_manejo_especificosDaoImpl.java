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
import com.mkyong.users.model.Tramite_planes_manejo_especificos;

@Repository("tramite_planes_manejo_especificosDao")
public class Tramite_planes_manejo_especificosDaoImpl implements Tramite_planes_manejo_especificosDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Tramite_planes_manejo_especificos> lista() {
		@SuppressWarnings("unchecked")
		List<Tramite_planes_manejo_especificos> users = sessionFactory.getCurrentSession().createCriteria(Tramite_planes_manejo_especificos.class).list();
		System.out.println("Tamanio List: "+users.size());
		return users;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Tramite_planes_manejo_especificos> lista(String rol) {
		List<Tramite_planes_manejo_especificos> list = new ArrayList<Tramite_planes_manejo_especificos>();
		if(rol.contentEquals("ROLE_RECEP")){
			list = sessionFactory.getCurrentSession().createCriteria(Tramite_planes_manejo_especificos.class)
					.add(Restrictions.eq("estatus", 1))
					.list();
		}else{
			list = sessionFactory.getCurrentSession().createCriteria(Tramite_planes_manejo_especificos.class)
					.add(Restrictions.ne("estatus", 1))
					.list();
		}
		
		return list;
	}


	@Override
	public MensajeBean inserta(Tramite_planes_manejo_especificos nuevo) {
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
			mensaje.setIdNumTramite(nuevo.getIdtramite_planes_manejo_especificos());
		} catch (HibernateException e) {
			System.out.println(e);
		}
		return mensaje;
	}

	@Override
	public MensajeBean actualiza(Tramite_planes_manejo_especificos nuevo) {
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
	public MensajeBean elimina(Tramite_planes_manejo_especificos nuevo) {
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
	public Tramite_planes_manejo_especificos consulta(Tramite_planes_manejo_especificos nuevo, String rol){
		List<Tramite_planes_manejo_especificos> list = new ArrayList<Tramite_planes_manejo_especificos>();
		Tramite_planes_manejo_especificos resultado = null;
		list = sessionFactory.getCurrentSession().createCriteria(Tramite_planes_manejo_especificos.class).add(Restrictions.eq("idtramite_planes_manejo_especificos", nuevo.getIdtramite_planes_manejo_especificos())).list();
		
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
				"Select tramite_planes_manejo_especificos.idtramite_planes_manejo_especificos as idtramite,'Planes de manejo específicos de residuos de manejo especial' as tipo,'37' as idtipo,catalogo_perfilempresa.nombreEmpresa as nombre_empresa"+
				" from tramite_planes_manejo_especificos "+
				" left join  catalogo_perfilestablecimiento"+ 
				" on catalogo_perfilestablecimiento.idcatalogo_perfilestablecimiento = tramite_planes_manejo_especificos.catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento"+
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
	public List<Tramite_planes_manejo_especificos> busquedaById(
			Tramite_planes_manejo_especificos nuevo) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Tramite_planes_manejo_especificos> users = sessionFactory.getCurrentSession().createCriteria(Tramite_planes_manejo_especificos.class).add(Restrictions.eq("idtramite_planes_manejo_especificos",nuevo.getIdtramite_planes_manejo_especificos())).list();
		System.out.println("Tamanio List: "+users.size());
		
		return users;
	}

}
