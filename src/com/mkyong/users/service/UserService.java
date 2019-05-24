package com.mkyong.users.service;

import com.mkyong.users.model.User;

public interface UserService {
	
	User findByUserName(String username);
	public void insertUser(User nuevo);
	public void actualizarUser(User nuevo);
	public void eliminar(User nuevo);

}
