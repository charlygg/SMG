package com.mkyong.users.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ixanaui.utils.MensajeBean;
import com.mkyong.users.model.Usuario;

@Repository("usuarioDao")
public class UsuarioDaoImpl implements UsuarioDao {

	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public List<Usuario> searchList() {
		@SuppressWarnings("unchecked")
		List<Usuario> users = sessionFactory.getCurrentSession().createCriteria(Usuario.class).list();
		System.out.println("Tamanio List: "+users.size());
		return users;
	}

	@SuppressWarnings("unchecked")
	@Override
	public MensajeBean insertUsuario(Usuario nuevo) {
		MensajeBean mensaje =  new MensajeBean();
		mensaje.setMensaje("ingreso de Usuario Exitoso");
		mensaje.setNumero(0);
		mensaje.setReferencia("username");
		
		// TODO Auto-generated method stub
		try {
			List<Usuario> usuarios = new ArrayList<Usuario>();
			usuarios = sessionFactory.getCurrentSession().createCriteria(Usuario.class).add(Restrictions.eq("username", nuevo.getUsername())).list();
			if(usuarios.size()>0){
				mensaje.setMensaje("Ya existe el nombre de usuario ingresado");
				mensaje.setNumero(1);
				mensaje.setReferencia("username");
				throw new HibernateException(mensaje.getMensaje());
			}
			usuarios = sessionFactory.getCurrentSession().createCriteria(Usuario.class).add(Restrictions.eq("email", nuevo.getEmail())).list();
			if(usuarios.size()>0){
				mensaje.setMensaje("El Email ingresado ya se encuentra vinculado a otro usuario");
				mensaje.setNumero(2);
				mensaje.setReferencia("select");
				throw new HibernateException(mensaje.getMensaje());
			}
			
			
			sessionFactory.getCurrentSession().saveOrUpdate(nuevo);
		} catch (HibernateException e) {
			System.out.println(e);
		}
		
		return mensaje;
	}

	@SuppressWarnings("unchecked")
	@Override
	public MensajeBean actualizarUsuario(Usuario nuevo) {
		// TODO Auto-generated method stub
		MensajeBean mensaje =  new MensajeBean();
		mensaje.setMensaje("Modificación de Usuario Exitoso");
		mensaje.setNumero(0);
		mensaje.setReferencia("username");
		
		try {
			List<Usuario> usuarios = new ArrayList<Usuario>();
			usuarios = (List<Usuario>) sessionFactory.getCurrentSession().createCriteria(Usuario.class)
					.add(Restrictions.eq("email", nuevo.getEmail()))
					.add(Restrictions.ne("idusuarios", nuevo.getIdusuarios()))
					.list();
			if(usuarios.size()>0){
				mensaje.setMensaje("El Email ingresado ya se encuentra vinculado a otro usuario");
				mensaje.setNumero(2);
				mensaje.setReferencia("select");
			}else{
				sessionFactory.getCurrentSession().update(nuevo);
			}
			
//	metodo3		
//			String sqlupdate = "update usuarios  set nombre = :nombre, "
//					+ "apellidoPaterno = :apellidoPaterno, "
//					+ "apellidoMaterno = :apellidoMaterno, "
//					+ "email = :email, "
//					+ "password = :password " +
//                    " where idusuarios = :idusuarios";

//			System.out.println(
//					"Degugerr Fercho:\n"+
//					nuevo.getIdusuarios()+"\n"+
//					nuevo.getNombre()+"\n"+
//					nuevo.getApellidoPaterno()+"\n"+
//					nuevo.getApellidoMaterno()+"\n"+
//					nuevo.getEmail()+"\n"+
//					nuevo.getPassword()+"\n"+
//					mensaje.getMensaje());
			
//metodo3			
//			  int updatedEntities = sessionFactory.getCurrentSession().createQuery(sqlupdate)
//					  .setParameter("nombre", nuevo.getNombre())
//                      .setParameter("apellidoPaterno", nuevo.getApellidoPaterno())
//                      .setParameter("apellidoMaterno", nuevo.getApellidoMaterno())
//                      .setParameter("email", nuevo.getEmail())
//                      .setParameter("password", nuevo.getPassword())
//                      .setParameter("idusuarios", nuevo.getIdusuarios())
//                      .executeUpdate();}
//			  		  sessionFactory.getCurrentSession().beginTransaction().commit();
//			  		  sessionFactory.getCurrentSession().close();
//                      System.out.println(updatedEntities);

//			metodo1
//			Usuario auxiliar = (Usuario) sessionFactory.getCurrentSession().load(Usuario.class, nuevo.getIdusuarios());;
//			BeanUtils.copyProperties(auxiliar, nuevo);
		
//			metodo2
//			sessionFactory.getCurrentSession().merge(nuevo);
		} catch (HibernateException e) {
			System.out.println(e);
			throw new IllegalStateException("Error occured when updating a Parent object", e);
		}
		return mensaje;
	}


    @Override
	public void eliminar(Usuario nuevo) {
		// TODO Auto-generated method stub
		try {
		sessionFactory.getCurrentSession().delete(nuevo);
		
	} catch (HibernateException e) {
		System.out.println(e);
	}
}

	@SuppressWarnings("unchecked")
	@Override
	public Usuario findByUserName(String username) {
		// TODO Auto-generated method stub
		List<Usuario> users = new ArrayList<Usuario>();
		users = sessionFactory.getCurrentSession().createCriteria(Usuario.class).add(Restrictions.like("username", username)).list();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public Usuario consultaUsuario(Usuario nuevo) {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Usuario usuario = null;
		usuarios = sessionFactory.getCurrentSession().createCriteria(Usuario.class).add(Restrictions.eq("idusuarios", nuevo.getIdusuarios())).list();
		if (usuarios.size() == 1) {
			usuario = usuarios.get(0);
		} 
		return usuario;
	}
	
	
	

}
