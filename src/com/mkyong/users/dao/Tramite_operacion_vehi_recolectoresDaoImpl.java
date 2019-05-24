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
import com.mkyong.users.model.Tramite_operacion_vehi_recolectores;

@Repository("tramite_operacion_vehi_recolectoresDao")
public class Tramite_operacion_vehi_recolectoresDaoImpl implements Tramite_operacion_vehi_recolectoresDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Tramite_operacion_vehi_recolectores> lista() {
		@SuppressWarnings("unchecked")
		List<Tramite_operacion_vehi_recolectores> users = sessionFactory.getCurrentSession().createCriteria(Tramite_operacion_vehi_recolectores.class).list();
		System.out.println("Tamanio List: "+users.size());
		return users;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Tramite_operacion_vehi_recolectores> lista(String rol) {
		List<Tramite_operacion_vehi_recolectores> list = new ArrayList<Tramite_operacion_vehi_recolectores>();
		if(rol.contentEquals("ROLE_RECEP")){
			list = sessionFactory.getCurrentSession().createCriteria(Tramite_operacion_vehi_recolectores.class)
					.add(Restrictions.eq("estatus", 1))
					.list();
		}else{
			list = sessionFactory.getCurrentSession().createCriteria(Tramite_operacion_vehi_recolectores.class)
					.add(Restrictions.ne("estatus", 1))
					.list();
		}
		
		return list;
	}


	@Override
	public MensajeBean inserta(Tramite_operacion_vehi_recolectores nuevo) {
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
			mensaje.setIdNumTramite(nuevo.getIdtramite_operacion_vehi_recolectores());
		} catch (HibernateException e) {
			System.out.println(e);
		}
		return mensaje;
	}

	@Override
	public MensajeBean actualiza(Tramite_operacion_vehi_recolectores nuevo) {
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
	public MensajeBean elimina(Tramite_operacion_vehi_recolectores nuevo) {
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
	public Tramite_operacion_vehi_recolectores consulta(Tramite_operacion_vehi_recolectores nuevo, String rol){
		List<Tramite_operacion_vehi_recolectores> list = new ArrayList<Tramite_operacion_vehi_recolectores>();
		Tramite_operacion_vehi_recolectores resultado = null;
		list = sessionFactory.getCurrentSession().createCriteria(Tramite_operacion_vehi_recolectores.class).add(Restrictions.eq("idtramite_operacion_vehi_recolectores", nuevo.getIdtramite_operacion_vehi_recolectores())).list();
		
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
				"Select tramite_operacion_vehi_recolectores.idtramite_operacion_vehi_recolectores as idtramite,'Operación de los vehículos recolectores de residuos sólidos urbanos cuando presenten el servicio a dos o más municipios' as tipo,'35' as idtipo,catalogo_perfilempresa.nombreEmpresa as nombre_empresa"+
				" from tramite_operacion_vehi_recolectores "+
				" left join  catalogo_perfilestablecimiento"+ 
				" on catalogo_perfilestablecimiento.idcatalogo_perfilestablecimiento = tramite_operacion_vehi_recolectores.catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento"+
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
	public List<Tramite_operacion_vehi_recolectores> busquedaById(
			Tramite_operacion_vehi_recolectores nuevo) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Tramite_operacion_vehi_recolectores> users = sessionFactory.getCurrentSession().createCriteria(Tramite_operacion_vehi_recolectores.class).add(Restrictions.eq("idtramite_operacion_vehi_recolectores",nuevo.getIdtramite_operacion_vehi_recolectores())).list();
		System.out.println("Tamanio List: "+users.size());
		
		return users;
	}

}
