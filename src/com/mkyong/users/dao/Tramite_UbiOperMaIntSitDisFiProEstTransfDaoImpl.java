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
import com.mkyong.users.model.Tramite_UbiOperMaIntSitDisFiProEstTransf;

@Repository("tramite_UbiOperMaIntSitDisFiProEstTransfDao")
public class Tramite_UbiOperMaIntSitDisFiProEstTransfDaoImpl implements Tramite_UbiOperMaIntSitDisFiProEstTransfDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Tramite_UbiOperMaIntSitDisFiProEstTransf> lista() {
		@SuppressWarnings("unchecked")
		List<Tramite_UbiOperMaIntSitDisFiProEstTransf> users = sessionFactory.getCurrentSession().createCriteria(Tramite_UbiOperMaIntSitDisFiProEstTransf.class).list();
		System.out.println("Tamanio List: "+users.size());
		return users;
	}

	@Override
	public MensajeBean inserta(Tramite_UbiOperMaIntSitDisFiProEstTransf nuevo) {
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
	public MensajeBean actualiza(Tramite_UbiOperMaIntSitDisFiProEstTransf nuevo) {
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
	public MensajeBean elimina(Tramite_UbiOperMaIntSitDisFiProEstTransf nuevo) {
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
	public Tramite_UbiOperMaIntSitDisFiProEstTransf consulta(Tramite_UbiOperMaIntSitDisFiProEstTransf nuevo, String rol){
		List<Tramite_UbiOperMaIntSitDisFiProEstTransf> list = new ArrayList<Tramite_UbiOperMaIntSitDisFiProEstTransf>();
		Tramite_UbiOperMaIntSitDisFiProEstTransf resultado = null;
		list = sessionFactory.getCurrentSession().createCriteria(Tramite_UbiOperMaIntSitDisFiProEstTransf.class).add(Restrictions.eq("idtramite", nuevo.getIdtramite())).list();
		
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
	public List<Tramite_UbiOperMaIntSitDisFiProEstTransf> lista(String rol) {
		List<Tramite_UbiOperMaIntSitDisFiProEstTransf> list = new ArrayList<Tramite_UbiOperMaIntSitDisFiProEstTransf>();
		if(rol.contentEquals("ROLE_RECEP")){
			list = sessionFactory.getCurrentSession().createCriteria(Tramite_UbiOperMaIntSitDisFiProEstTransf.class)
					.add(Restrictions.eq("estatus", 1))
					.list();
		}else{
			list = sessionFactory.getCurrentSession().createCriteria(Tramite_UbiOperMaIntSitDisFiProEstTransf.class)
					.add(Restrictions.ne("estatus", 1))
					.list();
		}
		
		return list;
	}
	
	@Override
	public List<WrapperTramite> listaTramitesByZona(String municipio, String colonia) {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unchecked")
		List<WrapperTramite> resultWithAliasedBean = sessionFactory.getCurrentSession().createSQLQuery(
				"Select tramite_ubiopermaintsitdisfiproesttransf.idtramite as idtramite,'Ubicación, operación y manejo integral de sitios de disposición final de residuos provenientes de las estaciones de transferencia.' as tipo,'29' as idtipo,catalogo_perfilempresa.nombreEmpresa as nombre_empresa"+
				" from tramite_ubiopermaintsitdisfiproesttransf "+
				" left join catalogo_perfilestablecimiento "+ 
				" on catalogo_perfilestablecimiento.idcatalogo_perfilestablecimiento = tramite_ubiopermaintsitdisfiproesttransf.idestablecimiento"+
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
	public List<Tramite_UbiOperMaIntSitDisFiProEstTransf> busquedaById(
			Tramite_UbiOperMaIntSitDisFiProEstTransf nuevo) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Tramite_UbiOperMaIntSitDisFiProEstTransf> users = sessionFactory.getCurrentSession().createCriteria(Tramite_UbiOperMaIntSitDisFiProEstTransf.class).add(Restrictions.eq("idtramite",nuevo.getIdtramite())).list();
		System.out.println("Tamanio List: "+users.size());
		
		return users;
	}
}
