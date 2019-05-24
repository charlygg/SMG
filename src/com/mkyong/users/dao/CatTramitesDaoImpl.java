package com.mkyong.users.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ixanaui.utils.MensajeBean;
import com.mkyong.users.model.Area;
import com.mkyong.users.model.CatDenuncias;
import com.mkyong.users.model.CatalogoTramites;
import com.mkyong.users.model.Denuncia;

@Repository("TramitesDao")
public class CatTramitesDaoImpl implements CatTramitesDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<CatalogoTramites> searchList() {
		@SuppressWarnings("unchecked")
		List<CatalogoTramites> lista = sessionFactory.getCurrentSession().createCriteria(CatalogoTramites.class).list();
		System.out.println("Tamanio List: "+lista.size());
		return lista;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CatalogoTramites> searchList(String rol) {
		System.out.println(rol);
		List<CatalogoTramites> list = new ArrayList<CatalogoTramites>();
		try{
		
			if(rol.contentEquals("ROLE_RECEP")){
				list = sessionFactory.getCurrentSession().createCriteria(CatalogoTramites.class)
						.list();
			}else if(rol.contentEquals("ROLE_DIREC_MA")){
				
				list= sessionFactory.getCurrentSession().createCriteria(CatalogoTramites.class).list();
			}else{
				//obtener el area por rol
				List<Area> listareas = new ArrayList<Area>();
				Area resultadoarea = new Area();
				listareas = sessionFactory.getCurrentSession().createCriteria(Area.class).add(Restrictions.eq("role", rol)).list();
				
				resultadoarea = listareas.get(0);
				
				System.out.println("rol nombre :"+rol+ "identificador de area"+ resultadoarea.getIdareas());
				List<CatalogoTramites> catalogoTramites = null;
				if(resultadoarea.getIdareas() != 0 && !resultadoarea.getRole().contentEquals("ROLE_RECEP")){
					catalogoTramites = sessionFactory.getCurrentSession().createCriteria(CatalogoTramites.class)
							.add(Restrictions.eq("areaID", resultadoarea.getIdareas())).list();
				}else{//caso base por si ocurre algun tipo de error (no tenga area o el rol sea a recepcion cuando dice que no lo sea)
					catalogoTramites = sessionFactory.getCurrentSession().createCriteria(CatDenuncias.class).list();
				}
				list = catalogoTramites;
			}
			
		}catch(HibernateException e){
			
		}
		
		return list;
		
	}


	@Override
	public MensajeBean actualizaTramites(CatalogoTramites nuevo) {
		// TODO Auto-generated method stub
		MensajeBean mensaje =  new MensajeBean();
		mensaje.setMensaje("ModificaciÃ­on de Area Exitoso");
		mensaje.setNumero(0);
		mensaje.setReferencia("nombre");
		try {
			sessionFactory.getCurrentSession().update(nuevo);
		} catch (HibernateException e) {
			System.out.println(e);
			mensaje.setNumero(1);
			mensaje.setMensaje("Modificacion de Ã�rea");
		}
		return mensaje;
	}

	@SuppressWarnings("unchecked")
	@Override
	public CatalogoTramites consultaTramite(CatalogoTramites nuevo) {
		// TODO Auto-generated method stub
		List<CatalogoTramites> catalogoTramites = new ArrayList<CatalogoTramites>();
		catalogoTramites = sessionFactory.getCurrentSession().createCriteria(CatalogoTramites.class).add(Restrictions.eq("catalogoID", nuevo.getCatalogoID())).list();

		if (catalogoTramites.size() == 1) {
			return catalogoTramites.get(0);
		} else {
			return null;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public CatalogoTramites consultaTramiteByNombreTramite(CatalogoTramites tramite) {
		// TODO Auto-generated method stub
		List<CatalogoTramites> catalogoTramites = new ArrayList<CatalogoTramites>();
		catalogoTramites = sessionFactory.getCurrentSession().createCriteria(CatalogoTramites.class).add(Restrictions.like("nombreTramite", tramite.getNombreTramite())).list();

		if (catalogoTramites.size() == 1) {
			return catalogoTramites.get(0);
		} else {
			return null;
		}
		
	}
	

}
