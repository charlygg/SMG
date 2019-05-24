package com.mkyong.users.dao;

import com.mkyong.users.model.User;

public interface UserDao {

	User findByUserName(String username);
	public void insertUser(User nuevo);
	public void actualizarUser(User nuevo);
	public void eliminar(User nuevo);

}