package com.mkyong.users.dao;

import com.mkyong.users.model.RelacionNumeroOficio;
import java.util.List;


public interface RelacionNumeroOficioDao {

	public void insertRelacionNumeroOficio(RelacionNumeroOficio nuevo);
	public List<RelacionNumeroOficio> findRelacionNumeroOficioByIdtramiteIdTipoTramite(RelacionNumeroOficio busqueda);
	public List<RelacionNumeroOficio> findRelacionNumeroOficioById(RelacionNumeroOficio busqueda);
}
