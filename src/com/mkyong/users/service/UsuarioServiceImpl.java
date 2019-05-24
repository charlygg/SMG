package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.MensajeBean;
import com.mkyong.users.dao.UsuarioDao;
import com.mkyong.users.model.Usuario;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	UsuarioDao usuarioDao;


	@Override
	public MensajeBean insertUsuario(Usuario nuevo) {
		// TODO Auto-generated method stub
		return usuarioDao.insertUsuario(nuevo);
	}

	@Override
	public MensajeBean actualizarUsuario(Usuario nuevo) {
		// TODO Auto-generated method stub
		return usuarioDao.actualizarUsuario(nuevo);
	}

	@Override
	public void eliminar(Usuario nuevo) {
		// TODO Auto-generated method stub
		usuarioDao.eliminar(nuevo);
	}

	@Override
	public List<Usuario> searchList() {
		// TODO Auto-generated method stub
		return usuarioDao.searchList();
	}

	@Override
	public Usuario findByUserName(String username) {
		// TODO Auto-generated method stub
		return usuarioDao.findByUserName(username);
	}
	
	@Override
	public Usuario consultaUsuario(Usuario nuevo){
		return usuarioDao.consultaUsuario(nuevo);
	}

}
