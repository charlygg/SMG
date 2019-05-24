package com.mkyong.users.dao;

import com.ixanaui.utils.MensajeBean;
import com.mkyong.users.model.NumeroOficio;

public interface NumeroOficioDao {

	public MensajeBean actualizarNumeroOficio(NumeroOficio data);
	public NumeroOficio buscarNumeroOficio(NumeroOficio data);
}
