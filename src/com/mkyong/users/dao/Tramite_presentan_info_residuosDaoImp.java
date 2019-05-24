package com.mkyong.users.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.model.Tramite_presentan_info_residuos;

@Repository("tramite_presentan_info_residuosDao")
public class Tramite_presentan_info_residuosDaoImp implements Tramite_presentan_info_residuosDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Tramite_presentan_info_residuos> lista() {
		@SuppressWarnings("unchecked")
		List<Tramite_presentan_info_residuos> list = sessionFactory.getCurrentSession().createCriteria(Tramite_presentan_info_residuos.class).list();
		System.out.println("Tamaño de la lista " + list.size());
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tramite_presentan_info_residuos> lista(String rol) {
		List<Tramite_presentan_info_residuos> lista = new ArrayList<Tramite_presentan_info_residuos>();
		
		if(rol.contentEquals("ROLE_RECEP")){
			lista = sessionFactory.getCurrentSession().createCriteria(Tramite_presentan_info_residuos.class)
					.add(Restrictions.eq("estatus", 1)).list();
		} else {
			lista = sessionFactory.getCurrentSession().createCriteria(Tramite_presentan_info_residuos.class)
					.add(Restrictions.ne("estatus", 1)).list();
		}
		
		return lista;
	}

	@Override
	public MensajeBean inserta(Tramite_presentan_info_residuos nuevo) {
		MensajeBean mensajeBean = new MensajeBean();
		mensajeBean.setMensaje("Ingreso de tramite exitoso");
		mensajeBean.setNumero(0);
		mensajeBean.setReferencia("nombeEmpresa");
		
		if(nuevo.getEstatus() == 0){
			nuevo.setEstatus(1);
		}
		
		if(nuevo.getEstatus() == 1){
			nuevo.setEstatus(1);
		}
		
		try{
			sessionFactory.getCurrentSession().saveOrUpdate(nuevo);
			mensajeBean.setIdNumTramite(nuevo.getIdtramite_residuos());
		}catch(Exception ex){
			System.out.println(ex);
		}
		
		return mensajeBean;
	}

	@Override
	public MensajeBean actualiza(Tramite_presentan_info_residuos nuevo) {
		MensajeBean mensaje = new MensajeBean();
		mensaje.setMensaje("Modificación de Perfil Empresa Exitoso");
		mensaje.setNumero(0);
		mensaje.setReferencia("nombreEmpresa");
		try{
		sessionFactory.getCurrentSession().update(nuevo);
		}catch(Exception ex){
			System.out.println(ex);
			mensaje.setNumero(1);
			mensaje.setMensaje("Modificacion de Perfil Empresa");
		}
		
		return mensaje;
	}

	@Override
	public MensajeBean elimina(Tramite_presentan_info_residuos nuevo) {
		MensajeBean mensajeBean = new MensajeBean();
		mensajeBean.setMensaje("Eliminación de Perfil Empresa Exitoso");
		mensajeBean.setNumero(0);
		mensajeBean.setMensaje("nombreEmpesa");
		sessionFactory.getCurrentSession().delete(nuevo);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Tramite_presentan_info_residuos consulta(Tramite_presentan_info_residuos nuevo) {
		List<Tramite_presentan_info_residuos> list = new ArrayList<Tramite_presentan_info_residuos>();
		Tramite_presentan_info_residuos resultado = null;
		list = sessionFactory.getCurrentSession().createCriteria(Tramite_presentan_info_residuos.class).add(Restrictions.eq("idtramite_residuos", nuevo.getIdtramite_residuos())).list();
		
		try{
			if(list.size() == 1){
				resultado = list.get(0);
			}
		}catch(Exception ex){
			System.out.println(ex);
		}
		
		return resultado;
	}

	@Override
	public List<WrapperTramite> listaTramitesByZona(String municipio, String colonia) {
		@SuppressWarnings("unchecked")
		List<WrapperTramite> resultWithAliasedBean = sessionFactory.getCurrentSession().createSQLQuery(""
				+ "Select tramite_presentan_info_residuos.idtramite_residuos as idtramite,'Presentan Información Residuos' as tipo,'47' as idtipo,catalogo_perfilempresa.nombreEmpresa as nombre_empresa "
				+ "from tramite_presentan_info_residuos "
				+ "left join catalogo_perfilestablecimiento "
				+ "on catalogo_perfilestablecimiento.idcatalogo_perfilestablecimiento = tramite_presentan_info_residuos.idestablecimiento "
				+ "left join catalogo_perfilempresa on catalogo_perfilestablecimiento.idcatalogo_perfilempresa=catalogo_perfilempresa.idcatalogo_perfilempresa "
				+ " where catalogo_perfilestablecimiento.municipio like'"+municipio+"' and catalogo_perfilestablecimiento.colonia like'"+colonia+"'")
		.addScalar("idtramite").addScalar("tipo").addScalar("idtipo").addScalar("nombre_empresa")
		.setResultTransformer(Transformers.aliasToBean(WrapperTramite.class)).list();
		return resultWithAliasedBean;
	}

	@Override
	public List<Tramite_presentan_info_residuos> busquedaById(Tramite_presentan_info_residuos nuevo) {
		@SuppressWarnings("unchecked")
		List<Tramite_presentan_info_residuos> lista = sessionFactory.getCurrentSession().createCriteria(Tramite_presentan_info_residuos.class).add(Restrictions.eq("idtramite_residuos", nuevo.getIdtramite_residuos())).list();
		System.out.println("Tamanio List: "+lista.size());
		return lista;
	}

}
