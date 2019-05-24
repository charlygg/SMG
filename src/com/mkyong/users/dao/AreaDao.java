package com.mkyong.users.dao;

import java.util.List;

import com.ixanaui.utils.MensajeBean;
import com.mkyong.users.model.Area;

public  interface AreaDao {
	
	public List<Area> searchList();
	public void insertArea(Area nuevo);
	public MensajeBean actualizarArea(Area nuevo);
	public void elimar(Area nuevo);
	public Area consultaArea(Area nuevo);
	public Area consultaAreaByRole(Area nuevo);
}
