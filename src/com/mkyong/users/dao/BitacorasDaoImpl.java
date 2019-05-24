package com.mkyong.users.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Column;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ixanaui.utils.BitacorasListBean;
import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.Bitacoras;
import com.mkyong.users.model.Denuncia;

@Repository("bitacorasDao")
public class BitacorasDaoImpl implements BitacorasDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Bitacoras> lista() {
		@SuppressWarnings("unchecked")
		List<Bitacoras> users = sessionFactory.getCurrentSession().createCriteria(Bitacoras.class).list();
		System.out.println("Tamanio List: "+users.size());
		return users;
	}

	@Override
	public List<BitacorasListBean> bitacoraComboEmpresa( ) {
		@SuppressWarnings("unchecked")
		List<BitacorasListBean> lista  = sessionFactory.getCurrentSession().createSQLQuery(
				" select distinct(idempresa ) as idcatalogo, nombreEmpresa as empresa "+
				" from bitacoraregistros, catalogo_perfilempresa "+
				" where idempresa = idcatalogo_perfilempresa; ")
				  .addScalar("idcatalogo")
				  .addScalar("empresa")
				  .setResultTransformer( Transformers.aliasToBean(BitacorasListBean.class)
						  )
				  .list();

		
		return lista;
	}

	@Override
	public List<BitacorasListBean> bitacoraComboEstablecimiento(Bitacoras nuevo ) {
		@SuppressWarnings("unchecked")
		List<BitacorasListBean> lista  = sessionFactory.getCurrentSession().createSQLQuery(
				" select distinct(idestablecimiento) as idcatalogo , municipio as establecimiento "+
				" from bitacoraregistros, catalogo_perfilestablecimiento "+
				" where idempresa = "+nuevo.getIdempresa()+
				" and idestablecimiento = idcatalogo_perfilestablecimiento; ")
				  .addScalar("idcatalogo")
				  .addScalar("establecimiento")
				  .setResultTransformer( Transformers.aliasToBean(BitacorasListBean.class)
						  )
				  .list();
		return lista;
	}

	@Override
	public List<Bitacoras> bitacoraPorEmpresa(Bitacoras nuevo ) {
		@SuppressWarnings("unchecked")
		List<Bitacoras> users = 
		sessionFactory.getCurrentSession().createCriteria(Bitacoras.class)
			.add(Restrictions.eq("tipoBitacora", "Tramite"))
			.add(Restrictions.eq("estatus", 5))
			.add(Restrictions.eq("idempresa", nuevo.getIdempresa()))
			.add(Restrictions.eq("idestablecimiento", nuevo.getIdestablecimiento()))
			.list();
		return users;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Bitacoras> lista(Bitacoras nuevo) {
		@SuppressWarnings("unchecked")
		List<Bitacoras> users = new ArrayList <Bitacoras>();
			
		
		if(nuevo.getCatalogoID() != 0){
			users = sessionFactory.getCurrentSession().createCriteria(Bitacoras.class)
			.add(Restrictions.eq("idregistro",nuevo.getIdregistro()))
			.add(Restrictions.eq("catalogoID",nuevo.getCatalogoID()))
			.list();
		}else{
			users = sessionFactory.getCurrentSession().createCriteria(Bitacoras.class)
			.add(Restrictions.eq("idregistro",nuevo.getIdregistro()))
			.list();
		}
		
		System.out.println("Tamanio List: "+users.size());
		return users;
	}
	
	@Override
	public MensajeBean inserta(Bitacoras nuevo) {
		// TODO Auto-generated method stub
		MensajeBean mensaje =  new MensajeBean();
		mensaje.setMensaje("Bitacoras Exitoso");
		mensaje.setNumero(0);
		mensaje.setReferencia("bitacoras");
		try {
//			sessionFactory.getCurrentSession().clear();
			System.out.println("registro-----------------"+nuevo.getIdregistro()+"$$"+nuevo.getIdusuario());
			sessionFactory.getCurrentSession().save(nuevo);
		} catch (HibernateException e) {
			System.out.println(e);
		}
		return mensaje;
	}

	@Override
	public MensajeBean actualiza(Bitacoras nuevo) {
		// TODO Auto-generated method stub
		MensajeBean mensaje =  new MensajeBean();
		mensaje.setMensaje("Modificaciíon de Area Exitoso");
		mensaje.setNumero(0);
		mensaje.setReferencia("nombre");
		try {
			sessionFactory.getCurrentSession().update(nuevo);
		} catch (HibernateException e) {
			System.out.println(e);
			mensaje.setNumero(1);
			mensaje.setMensaje("Modificacion de Área");
		}
		return mensaje;
	}

	@Override
	public MensajeBean elimina(Bitacoras nuevo) {
		// TODO Auto-generated method stub
		MensajeBean mensaje =  new MensajeBean();
		mensaje.setMensaje("Modificaciíon de Area Exitoso");
		mensaje.setNumero(0);
		mensaje.setReferencia("nombre");
		sessionFactory.getCurrentSession().delete(nuevo);
		return mensaje;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public Bitacoras consulta(Bitacoras nuevo){
		List<Bitacoras> list = new ArrayList<Bitacoras>();
		Bitacoras resultado = new Bitacoras();
		list = sessionFactory.getCurrentSession().createCriteria(Bitacoras.class).add(Restrictions.eq("idbitacoraregistros", nuevo.getIdbitacoraregistros())).list();
		try {
			if(list.size() == 1 ){
				resultado =  list.get(0);

			}
		} catch (HibernateException e) {
			System.out.println(e);
		}
		return resultado;
	}
}
