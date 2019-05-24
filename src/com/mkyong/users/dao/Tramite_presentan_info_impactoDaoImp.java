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
import com.mkyong.users.model.Tramite_presentan_info_impacto;

@Repository("tramite_presentan_info_impactoDao")
public class Tramite_presentan_info_impactoDaoImp implements Tramite_presentan_info_impactoDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public List<Tramite_presentan_info_impacto> lista() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Tramite_presentan_info_impacto> list = sessionFactory.getCurrentSession().createCriteria(Tramite_presentan_info_impacto.class).list();
		System.out.println("Tama;o de la lista " + list.size());
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tramite_presentan_info_impacto> lista(String rol) {
		// TODO Auto-generated method stub
		List<Tramite_presentan_info_impacto> list = new ArrayList<Tramite_presentan_info_impacto>();
		
		if(rol.contentEquals("ROLE_RECEP")){
			list = sessionFactory.getCurrentSession().createCriteria(Tramite_presentan_info_impacto.class)
					.add(Restrictions.eq("estatus",1)).list();
		} else {
			list = sessionFactory.getCurrentSession().createCriteria(Tramite_presentan_info_impacto.class)
					.add(Restrictions.ne("estatus",1)).list();
		}
		
		return list;
	}

	@Override
	public MensajeBean inserta(Tramite_presentan_info_impacto nuevo) {
		// TODO Auto-generated method stub
		MensajeBean mensajeBean = new MensajeBean();
		mensajeBean.setMensaje("Ingreso de tramite exitoso");
		mensajeBean.setNumero(0);
		mensajeBean.setReferencia("nombreEmpresa");
		
		if(nuevo.getEstatus() == 0){
			nuevo.setEstatus(1);
		}
		
		if(nuevo.getEstatus() == 4){
			nuevo.setEstatus(1);
		}
		
		try{
			sessionFactory.getCurrentSession().saveOrUpdate(nuevo);
			mensajeBean.setIdNumTramite(nuevo.getIdtramite_impacto());
		}catch(Exception ex){
			System.out.println(ex);
		}
		return mensajeBean;
	}

	@Override
	public MensajeBean actualiza(Tramite_presentan_info_impacto nuevo) {
		// TODO Auto-generated method stub
		MensajeBean mensaje =  new MensajeBean();
		mensaje.setMensaje("Modificación de Perfil Empresa Exitoso");
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
	public MensajeBean elimina(Tramite_presentan_info_impacto nuevo) {
		MensajeBean mensaje =  new MensajeBean();
		mensaje.setMensaje("Eliminación de Perfil Empresa Exitoso");
		mensaje.setNumero(0);
		mensaje.setReferencia("nombreEmpresa");
		sessionFactory.getCurrentSession().delete(nuevo);
		return mensaje;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Tramite_presentan_info_impacto consulta(Tramite_presentan_info_impacto nuevo) {
		List<Tramite_presentan_info_impacto> list = new ArrayList<Tramite_presentan_info_impacto>();
		Tramite_presentan_info_impacto resultado = null;
		list = sessionFactory.getCurrentSession().createCriteria(Tramite_presentan_info_impacto.class).add(Restrictions.eq("idtramite_impacto", nuevo.getIdtramite_impacto())).list();
		
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
		@SuppressWarnings("unchecked")
		List<WrapperTramite> resultWithAliasedBean = sessionFactory.getCurrentSession().createSQLQuery(""
				+ "Select tramite_presentan_info_impacto.idtramite_impacto as idtramite,'Presentan Información Impacto' as tipo,'45' as idtipo,catalogo_perfilempresa.nombreEmpresa as nombre_empresa "
				+ "from tramite_presentan_info_impacto "
				+ "left join catalogo_perfilestablecimiento "
				+ "on catalogo_perfilestablecimiento.idcatalogo_perfilestablecimiento = tramite_presentan_info_impacto.idestablecimiento "
				+ "left join catalogo_perfilempresa on catalogo_perfilestablecimiento.idcatalogo_perfilempresa=catalogo_perfilempresa.idcatalogo_perfilempresa "
				+ " where catalogo_perfilestablecimiento.municipio like'"+municipio+"' and catalogo_perfilestablecimiento.colonia like'"+colonia+"'")
		.addScalar("idtramite").addScalar("tipo").addScalar("idtipo").addScalar("nombre_empresa")
		.setResultTransformer(Transformers.aliasToBean(WrapperTramite.class)).list();
		return resultWithAliasedBean;
	}

	@Override
	public List<Tramite_presentan_info_impacto> busquedaById(Tramite_presentan_info_impacto nuevo) {
		@SuppressWarnings("unchecked")
		List<Tramite_presentan_info_impacto> listado = sessionFactory.getCurrentSession().createCriteria(Tramite_presentan_info_impacto.class).add(Restrictions.eq("idtramite_impacto", nuevo.getIdtramite_impacto())).list();
		System.out.println("Tamanio List: "+listado.size());
		return listado;
	}

}
