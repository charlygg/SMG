package com.mkyong.users.dao;

import java.util.List;

import com.ixanaui.utils.WrapperMuro;
import com.mkyong.users.model.Muro;

public interface MuroDao {

	public List<Muro> searchList();
	public void insertMuro(Muro nuevo);
	public Muro consultaMuro(Muro nuevo);
	public List<WrapperMuro> getDatosMuro();
}
