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
import com.mkyong.users.model.Tramite_registro_prestadores_servicios;


@Repository("tramite_registro_prestador_servicioDao")
public class Tramite_registro_prestador_servicioDaoImpl implements Tramite_registro_prestador_servicioDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Tramite_registro_prestadores_servicios> lista() {
		@SuppressWarnings("unchecked")
		List<Tramite_registro_prestadores_servicios> users = sessionFactory.getCurrentSession().createCriteria(Tramite_registro_prestadores_servicios.class).list();
		System.out.println("Tamanio List: "+users.size());
		return users;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Tramite_registro_prestadores_servicios> lista(String rol) {
		List<Tramite_registro_prestadores_servicios> list = new ArrayList<Tramite_registro_prestadores_servicios>();
		if(rol.contentEquals("ROLE_RECEP")){
			list = sessionFactory.getCurrentSession().createCriteria(Tramite_registro_prestadores_servicios.class)
					.add(Restrictions.eq("estatus", 1))
					.list();
		}else{
			list = sessionFactory.getCurrentSession().createCriteria(Tramite_registro_prestadores_servicios.class)
					.add(Restrictions.ne("estatus", 1))
					.list();
		}
		
		return list;
	}


	@Override
	public MensajeBean inserta(Tramite_registro_prestadores_servicios nuevo) {
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
			mensaje.setIdNumTramite(nuevo.getIdtramite_registro_prestador_servicio());
		} catch (HibernateException e) {
			System.out.println(e);
		}
		return mensaje;
	}

	@Override
	public MensajeBean actualiza(Tramite_registro_prestadores_servicios nuevo) {
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
	public MensajeBean elimina(Tramite_registro_prestadores_servicios nuevo) {
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
	public Tramite_registro_prestadores_servicios consulta(Tramite_registro_prestadores_servicios nuevo, String rol){
		List<Tramite_registro_prestadores_servicios> list = new ArrayList<Tramite_registro_prestadores_servicios>();
		Tramite_registro_prestadores_servicios resultado = null;
		list = sessionFactory.getCurrentSession().createCriteria(Tramite_registro_prestadores_servicios.class).add(Restrictions.eq("idtramite_registro_prestador_servicio", nuevo.getIdtramite_registro_prestador_servicio())).list();
		
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
				"Select tramite_rehuso_residuos_manejo_especial.idtramite_rehuso_residuos_manejo_especial as idtramite,'Reuso de residuos de manejo especial' as tipo,'40' as idtipo,catalogo_perfilempresa.nombreEmpresa as nombre_empresa"+
				" from tramite_rehuso_residuos_manejo_especial "+
				" left join  catalogo_perfilestablecimiento"+ 
				" on catalogo_perfilestablecimiento.idcatalogo_perfilestablecimiento = tramite_rehuso_residuos_manejo_especial.catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento"+
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
	public List<Tramite_registro_prestadores_servicios> busquedaById(
			Tramite_registro_prestadores_servicios nuevo) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Tramite_registro_prestadores_servicios> users = sessionFactory.getCurrentSession().createCriteria(Tramite_registro_prestadores_servicios.class).add(Restrictions.eq("idtramite_registro_prestador_servicio",nuevo.getIdtramite_registro_prestador_servicio())).list();
		System.out.println("Tamanio List: "+users.size());
		
		return users;
	}
}