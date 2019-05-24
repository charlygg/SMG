package com.mkyong.users.dao;

import java.util.List;

import com.mkyong.users.model.RolMenu;

public  interface RolMenuDao {
	
	public List<RolMenu> listaRolMenu();
	public List<RolMenu> ListaRolMenuPorRol(RolMenu nuevo);
	public void insertaRolMenu(RolMenu nuevo);
	public void actualizaRolMenu(RolMenu nuevo);
	public void eliminaRolMenu(RolMenu nuevo);

}
