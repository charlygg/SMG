package com.mkyong.users.service;

import com.ixanaui.utils.MensajeBean;
import com.mkyong.users.model.NumeroOficio;

public interface NumeroOficioService {

	public MensajeBean actualizarNumeroOficio(NumeroOficio data);
	public NumeroOficio buscarNumeroOficio(NumeroOficio data);
	
}
