package com.mkyong.users.service;

import java.util.List;

import com.mkyong.users.model.RolMenu;


public interface RolMenuService {
	public List<RolMenu> ListaRolMenu();
	public List<RolMenu> ListaRolMenuPorRol(RolMenu nuevo);
	public void insertaRolMenu(RolMenu nuevo);
	public void actualizaRolMenu(RolMenu nuevo);
	public void eliminaRolMenu(RolMenu nuevo);
}
