package com.mkyong.users.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mkyong.users.model.CatalogoTramites;
import com.mkyong.users.model.RelacionJspTramite;

@Repository("relacionjsptramiteDao")
public class RelacionJspTramiteDaoImpl implements RelacionJspTramiteDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public RelacionJspTramite consultaRelacionJspTramite(
			CatalogoTramites tramite) {
		// TODO Auto-generated method stub
		List<RelacionJspTramite> list = new ArrayList<RelacionJspTramite>();
		RelacionJspTramite resultado = null;
		list = sessionFactory.getCurrentSession().createCriteria(RelacionJspTramite.class)
				.add(Restrictions.like("catalogo_tramites_catalogoID", tramite.getCatalogoID())).list();
		
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
