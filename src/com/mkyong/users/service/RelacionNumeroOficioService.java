package com.mkyong.users.service;

import java.util.List;

import com.mkyong.users.model.RelacionNumeroOficio;

public interface RelacionNumeroOficioService {
	
	public void insertRelacionNumeroOficio(RelacionNumeroOficio nuevo);
	public List<RelacionNumeroOficio> findRelacionNumeroOficioByIdtramiteIdTipoTramite(RelacionNumeroOficio busqueda);
	public List<RelacionNumeroOficio> findRelacionNumeroOficioById(RelacionNumeroOficio busqueda);

}
