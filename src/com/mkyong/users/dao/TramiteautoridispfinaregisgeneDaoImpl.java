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
import com.mkyong.users.model.TramiteAutoriDispFinaRegisGene;

@Repository("tramiteautoridispfinaregisgeneDao")
public class TramiteautoridispfinaregisgeneDaoImpl implements TramiteautoridispfinaregisgeneDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<TramiteAutoriDispFinaRegisGene> lista(String rol) {
		List<TramiteAutoriDispFinaRegisGene> list = new ArrayList<TramiteAutoriDispFinaRegisGene>();
		if(rol.contentEquals("ROLE_RECEP")){
			list = sessionFactory.getCurrentSession().createCriteria(TramiteAutoriDispFinaRegisGene.class)
					.add(Restrictions.eq("estatus", 1))
					.list();
		}else{
			list = sessionFactory.getCurrentSession().createCriteria(TramiteAutoriDispFinaRegisGene.class)
					.add(Restrictions.ne("estatus", 1))
					.list();
		}
		
		return list;
	}

	@Override
	public MensajeBean inserta(TramiteAutoriDispFinaRegisGene nuevo) {
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
	public MensajeBean actualiza(TramiteAutoriDispFinaRegisGene nuevo) {
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
	public MensajeBean elimina(TramiteAutoriDispFinaRegisGene nuevo) {
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
	public TramiteAutoriDispFinaRegisGene consulta(TramiteAutoriDispFinaRegisGene nuevo, String rol){
		List<TramiteAutoriDispFinaRegisGene> list = new ArrayList<TramiteAutoriDispFinaRegisGene>();
		TramiteAutoriDispFinaRegisGene resultado = null;
		list = sessionFactory.getCurrentSession().createCriteria(TramiteAutoriDispFinaRegisGene.class).add(Restrictions.eq("idtramite", nuevo.getIdtramite())).list();
		
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
				"Select tramiteautoridispfinaregisgene.idtramite as idtramite,'Autorización para la disposición final y registro como generador' as tipo,'27' as idtipo,catalogo_perfilempresa.nombreEmpresa as nombre_empresa"+
				" from tramiteautoridispfinaregisgene "+
				" left join  catalogo_perfilestablecimiento"+ 
				" on catalogo_perfilestablecimiento.idcatalogo_perfilestablecimiento = tramiteautoridispfinaregisgene.idestablecimiento"+
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
	public List<TramiteAutoriDispFinaRegisGene> busquedaById(
			TramiteAutoriDispFinaRegisGene nuevo) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<TramiteAutoriDispFinaRegisGene> users = sessionFactory.getCurrentSession().createCriteria(TramiteAutoriDispFinaRegisGene.class).add(Restrictions.eq("idtramite",nuevo.getIdtramite())).list();
		System.out.println("Tamanio List: "+users.size());
		
		return users;
	}
}
