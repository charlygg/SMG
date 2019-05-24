package com.mkyong.users.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ixanaui.utils.WrapperMuro;
import com.mkyong.users.model.Muro;

@Repository("muroDao")
public class MuroDaoImpl implements MuroDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Muro> searchList() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Muro> users = sessionFactory.getCurrentSession().createCriteria(Muro.class).addOrder(Order.desc("fecha")).list();
		System.out.println("Tamanio List: "+users.size());
		return users;
	}

	@Override
	public void insertMuro(Muro nuevo) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(nuevo);
		} catch (HibernateException e) {
			System.out.println(e);
		}
	}

	@Override
	public Muro consultaMuro(Muro nuevo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WrapperMuro> getDatosMuro() {
		// TODO Auto-generated method stub
		
		
		
		@SuppressWarnings("unchecked")
		List<WrapperMuro> resultWithAliasedBean = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT muro.catalogo_tramites_catalogoID as idtramite, muro.estado_tramite as estado_tramite, "+
				"muro.tipo_tramite as tipo_tramite, muro.id_tipo_tramite as id_tipo_tramite, catalogo_perfilempresa.nombreEmpresa as nombre_empresa,  "+
				"catalogo_perfilestablecimiento.municipio as municipio_empresa, muro.fecha as fecha, catalogo_tramites.nombreTramite as nombreTramite "+
				"FROM testsecurity.catalogo_perfilestablecimiento "+
				"JOIN testsecurity.catalogo_perfilempresa "+
				"ON testsecurity.catalogo_perfilestablecimiento.idcatalogo_perfilempresa=testsecurity.catalogo_perfilempresa.idcatalogo_perfilempresa "+
				"join testsecurity.muro "+
				"on testsecurity.catalogo_perfilestablecimiento.idcatalogo_perfilestablecimiento=testsecurity.muro.catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento "+
				"join testsecurity.catalogo_tramites "+
				"on testsecurity.catalogo_tramites.catalogoID= testsecurity.muro.id_tipo_tramite "+
				"where testsecurity.muro.tipo_tramite='tramite'  ORDER BY muro.fecha DESC")
				  .addScalar("idtramite")
				  .addScalar("estado_tramite")
				   .addScalar("tipo_tramite")
				  .addScalar("id_tipo_tramite")
				  .addScalar("nombre_empresa")
				  .addScalar("municipio_empresa")
				  .addScalar("fecha")
				  .addScalar("nombreTramite")
				  .setResultTransformer( Transformers.aliasToBean(WrapperMuro.class))
				  .list();
		
		@SuppressWarnings("unchecked")
		List<WrapperMuro> resultWithAliasedBean2 = sessionFactory.getCurrentSession().createSQLQuery(
				"SELECT muro.catalogo_tramites_catalogoID as idtramite, muro.estado_tramite as estado_tramite, "+
				"muro.tipo_tramite as tipo_tramite, muro.id_tipo_tramite as id_tipo_tramite, testsecurity.denuncia.nombre as nombre_empresa,  "+
				"testsecurity.denuncia.direccion as municipio_empresa, muro.fecha as fecha, catalogo_denuncias.nombre_tramite as nombreTramite "+
				"FROM testsecurity.muro "+
				"join testsecurity.denuncia "+
				"on testsecurity.muro.catalogo_tramites_catalogoID=testsecurity.denuncia.iddenuncia "+
				"join testsecurity.catalogo_denuncias "+
				"on testsecurity.catalogo_denuncias.idcatalogo_denuncias = testsecurity.muro.id_tipo_tramite "+
				"where testsecurity.muro.tipo_tramite='denuncia' ORDER BY muro.fecha DESC")
				  .addScalar("idtramite")
				  .addScalar("estado_tramite")
				   .addScalar("tipo_tramite")
				  .addScalar("id_tipo_tramite")
				  .addScalar("nombre_empresa")
				  .addScalar("municipio_empresa")
				  .addScalar("fecha")
				  .addScalar("nombreTramite")
				  .setResultTransformer( Transformers.aliasToBean(WrapperMuro.class))
				  .list();
		
		resultWithAliasedBean.addAll(resultWithAliasedBean2);
		System.out.println("resultWithAliasedBean "+resultWithAliasedBean.size());
		return resultWithAliasedBean;
	}
	
}
