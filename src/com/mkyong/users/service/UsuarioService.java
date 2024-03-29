package com.mkyong.users.service;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.mkyong.users.model.Usuario;



public interface UsuarioService {
	
	Usuario findByUserName(String username);
	public List<Usuario> searchList();
	public MensajeBean insertUsuario(Usuario nuevo);
	public MensajeBean actualizarUsuario(Usuario nuevo);
	public void eliminar(Usuario nuevo);
	public Usuario consultaUsuario(Usuario nuevo);

}
