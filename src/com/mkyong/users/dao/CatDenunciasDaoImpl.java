package com.mkyong.users.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ixanaui.utils.MensajeBean;
import com.mkyong.users.model.CatDenuncias;
import com.mkyong.users.model.Area;


@Repository("catdenunciasDao")
public class CatDenunciasDaoImpl implements CatDenunciasDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<CatDenuncias> searchList(Area area) {
		// TODO Auto-generated method stub
		List<CatDenuncias> denuncias = null;
		if(area != null){
			if(area.getIdareas() != 0 && !area.getRole().contentEquals("ROLE_RECEP")){
				denuncias = sessionFactory.getCurrentSession().createCriteria(CatDenuncias.class)
						.add(Restrictions.eq("area_idarea", area.getIdareas())).list();
				
			}else{
				denuncias = sessionFactory.getCurrentSession().createCriteria(CatDenuncias.class).list();
			}
		}else{
			denuncias = sessionFactory.getCurrentSession().createCriteria(CatDenuncias.class).list();
		}
		System.out.println("Tamanio List: "+denuncias.size());
		return denuncias;
	}

	@Override
	public MensajeBean actualizarCatDenuncias(CatDenuncias nuevo) {
		// TODO Auto-generated method stub
		MensajeBean mensaje =  new MensajeBean();
		mensaje.setMensaje("Modificaciíon de Catálogo de Denuncia Exitoso");
		mensaje.setNumero(0);
		mensaje.setReferencia("idcatalogo_denuncias");
		try {
			sessionFactory.getCurrentSession().update(nuevo);
		} catch (HibernateException e) {
			System.out.println(e);
			mensaje.setMensaje("Modificaciíon de Catálogo de Denuncia Fallido");
			mensaje.setNumero(1);
		}
		return mensaje;
	}

	@Override
	public CatDenuncias busquedaCatDenuncia(CatDenuncias old) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<CatDenuncias> denuncias = sessionFactory.getCurrentSession().createCriteria(CatDenuncias.class)
		.add((Restrictions.like("idcatalogo_denuncias", old.getIdcatalogo_denuncias()))).list();
		if(denuncias.size()>0)
		return denuncias.get(0);
		else
			return null;
	}
	
	
}
