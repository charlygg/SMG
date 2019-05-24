package com.mkyong.users.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mkyong.users.model.Municipios;

@Repository("municipiosDao")
public class MunicipiosDaoImpl implements MunicipioDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Municipios> lista(Municipios municipio) {
		@SuppressWarnings("unchecked")
		List<Municipios> list = sessionFactory.getCurrentSession().createCriteria(Municipios.class).add(Restrictions.eq("EstadoID", municipio.getEstadoID())).list();
		return list;
	}

	
}
