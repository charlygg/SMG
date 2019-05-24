package com.mkyong.users.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mkyong.users.model.Area;
import com.mkyong.users.model.CatDenuncias;
import com.mkyong.users.model.Denuncia;

@Repository("denunciaDao")
public class DenunciaDaoImpl implements DenunciaDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Denuncia> searchList() {
		@SuppressWarnings("unchecked")
		List<Denuncia> users = sessionFactory.getCurrentSession().createCriteria(Denuncia.class).list();
		return users;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Denuncia> denunciaComboColonia(Denuncia nuevo) {
		List<Denuncia> denuncias = new ArrayList<Denuncia>(); 
			denuncias = sessionFactory.getCurrentSession().createCriteria(Denuncia.class)
				.add(Restrictions.eq("municipio", nuevo.getMunicipio()))
				.setProjection(Projections.distinct(Projections.property("colonia")))
				.list();
		return denuncias;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Denuncia> denunciaComboMunicipio() {
		List<Denuncia> denuncias = new ArrayList<Denuncia>(); 
			denuncias = sessionFactory.getCurrentSession().createCriteria(Denuncia.class)
				.setProjection(Projections.distinct(Projections.property("municipio")))
				.list();
			Iterator <Denuncia>itera = denuncias.iterator();
		return denuncias;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Denuncia> denunciaList(Denuncia nuevo) {
		List<Denuncia> denuncias = new ArrayList<Denuncia>(); 
			denuncias = sessionFactory.getCurrentSession().createCriteria(Denuncia.class)
				.add(Restrictions.eq("municipio", nuevo.getMunicipio()))
				.add(Restrictions.eq("colonia", nuevo.getColonia()))
				.list();
		return denuncias;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Denuncia> searchList(Denuncia descripcionLista, String rol) {

		List<Denuncia> list = new ArrayList<Denuncia>();
//		Denuncia resultado = new Denuncia();
		try {
			
		if(rol.contentEquals("ROLE_RECEP")){
			list = sessionFactory.getCurrentSession().createCriteria(Denuncia.class)
					.add(Restrictions.like("descripcion", "%"+descripcionLista.getDescripcion()+"%"))
					.add(Restrictions.eq("estatus", 1))
					.add(Restrictions.eq("rolAgrego", "ROLE_RECEP"))
					.list();
		}else{
			//obtener el area por rol
			List<Area> listareas = new ArrayList<Area>();
			Area resultadoarea = new Area();
			listareas = sessionFactory.getCurrentSession().createCriteria(Area.class).add(Restrictions.eq("role", rol)).list();
			resultadoarea = listareas.get(0);
			//obtener catalogos de denuncias por area
			
			List<CatDenuncias> denuncias = null;
			if(resultadoarea.getIdareas() != 0 && !resultadoarea.getRole().contentEquals("ROLE_RECEP")){
				denuncias = sessionFactory.getCurrentSession().createCriteria(CatDenuncias.class)
						.add(Restrictions.eq("area_idarea", resultadoarea.getIdareas())).list();
				
			}else{
				denuncias = sessionFactory.getCurrentSession().createCriteria(CatDenuncias.class).list();
			}
			//crear la lista de cadena
			List<Integer> listacadenas = new ArrayList<Integer>();
			for(int i = 0 ; i < denuncias.size(); i++){
				listacadenas.add(denuncias.get(i).getIdcatalogo_denuncias());
			}
			//compara contra la lista de busqueda
//			list = 
					
//			Criteria c=	sessionFactory.getCurrentSession().createCriteria(Denuncia.class);
					
			list=sessionFactory.getCurrentSession().createCriteria(Denuncia.class).add(Restrictions.like("nombre", "%"+descripcionLista.getDescripcion()+"%"))
					.add(Restrictions.in("catalogo_denuncias_idcatalogo_denuncias", listacadenas))
					.add(Restrictions.or(
							Restrictions.and(Restrictions.eq("estatus", 1),Restrictions.eq("rolAgrego", rol))
							,
							Restrictions.ne("estatus", 1))
							)
					.list();
		}
		} catch (HibernateException e) {
			System.out.println(e);
		}
		return list;
	}

	@Override
	public int insertDenuncia(Denuncia nuevo) {
		// TODO Auto-generated method stub
		int nuevoID = 0;
		try {
			
			sessionFactory.getCurrentSession().saveOrUpdate(nuevo);
		} catch (HibernateException e) {
			System.out.println(e);
		}
		return nuevoID;
	}

	@Override
	public void actualizarDenuncia(Denuncia nuevo) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(nuevo);
		} catch (HibernateException e) {
			System.out.println(e);
		}
		
	}

	@Override
	public void elimar(Denuncia nuevo) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(nuevo);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Denuncia consultaDenuncia(Denuncia nuevo){
		List<Denuncia> list = new ArrayList<Denuncia>();
		Denuncia resultado = new Denuncia();
		list = sessionFactory.getCurrentSession().createCriteria(Denuncia.class)
				.add(Restrictions.eq("iddenuncia", nuevo.getIddenuncia()))
				.list();
		if(list.size() == 1 ){
			resultado =  list.get(0);
		}
		return resultado;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Denuncia consultaDenuncia(Denuncia nuevo, String rol){
		List<Denuncia> list = new ArrayList<Denuncia>();
		Denuncia resultado = new Denuncia();
		try {
		if(rol.contentEquals("ROLE_RECEP")){
			list = sessionFactory.getCurrentSession().createCriteria(Denuncia.class)
					.add(Restrictions.eq("iddenuncia", nuevo.getIddenuncia()))
					.add(Restrictions.eq("estatus", 1))
					.add(Restrictions.eq("rolAgrego", "ROLE_RECEP"))
					.list();
		}else{
			//obtener el area por rol
			List<Area> listareas = new ArrayList<Area>();
			Area resultadoarea = new Area();
			listareas = sessionFactory.getCurrentSession().createCriteria(Area.class).add(Restrictions.eq("role", rol)).list();
			resultadoarea = listareas.get(0);
			//obtener catalogos de denuncias por area
			
			List<CatDenuncias> denuncias = null;
			if(resultadoarea.getIdareas() != 0 && !resultadoarea.getRole().contentEquals("ROLE_RECEP")){
				denuncias = sessionFactory.getCurrentSession().createCriteria(CatDenuncias.class)
						.add(Restrictions.eq("area_idarea", resultadoarea.getIdareas())).list();
				
			}else{
				denuncias = sessionFactory.getCurrentSession().createCriteria(CatDenuncias.class).list();
			}
			//crear la lista de cadena
			List<Integer> listacadenas = new ArrayList<Integer>();
			
			for(int i = 0 ; i < denuncias.size(); i++){
				listacadenas.add(denuncias.get(i).getIdcatalogo_denuncias());
			}
			//compara contra la lista de busqueda
			
			list = sessionFactory.getCurrentSession().createCriteria(Denuncia.class)
					.add(Restrictions.eq("iddenuncia", nuevo.getIddenuncia()))
					.add(Restrictions.in("catalogo_denuncias_idcatalogo_denuncias", listacadenas))
					.add(Restrictions.or(
							Restrictions.and(Restrictions.eq("estatus", 1),Restrictions.eq("rolAgrego", rol))
							,
							Restrictions.ne("estatus", 1))
							)
					.list();
		}
			if(list.size() == 1 ){
				resultado =  list.get(0);
			}
		} catch (HibernateException e) {
			System.out.println(e);
		}
		return resultado;
	}
	
	@Override
	public void actualizaEstatusRecibido(Denuncia nuevo){
		Denuncia denuncia = (Denuncia)sessionFactory.getCurrentSession().get(Denuncia.class, nuevo.getIddenuncia()); 
		denuncia.setEstatus(2);
		sessionFactory.getCurrentSession().update(denuncia); 
	}
	
	@Override
	public void actualizaEstatusProceso(Denuncia nuevo){
		Denuncia denuncia = (Denuncia)sessionFactory.getCurrentSession().get(Denuncia.class, nuevo.getIddenuncia()); 
		denuncia.setEstatus(3);
		sessionFactory.getCurrentSession().update(denuncia); 
	}
	
	@Override
	public void actualizaEstatusDocumentacion(Denuncia nuevo){
		Denuncia denuncia = (Denuncia)sessionFactory.getCurrentSession().get(Denuncia.class, nuevo.getIddenuncia()); 
		denuncia.setEstatus(4);
		sessionFactory.getCurrentSession().update(denuncia); 
	}
	
	@Override
	public void actualizaEstatusTerminado(Denuncia nuevo){
		Denuncia denuncia = (Denuncia)sessionFactory.getCurrentSession().get(Denuncia.class, nuevo.getIddenuncia()); 
		denuncia.setEstatus(5);
		sessionFactory.getCurrentSession().update(denuncia); 
	}
}