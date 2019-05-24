package com.mkyong.users.service;

import java.util.List;

import com.ixanaui.utils.WrapperMuro;
import com.mkyong.users.model.Muro;

public interface MuroService {

	public List<Muro> searchList();
	public void insertMuro(Muro nuevo);
	public Muro consultaMuro(Muro nuevo);
	public List<WrapperMuro> getDatosMuro();
}
