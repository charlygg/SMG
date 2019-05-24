package com.mkyong.users.service;

import java.util.List;

import com.mkyong.users.model.Denuncia;

public interface DenunciaService {

	public List<Denuncia> searchList();
	public List<Denuncia> denunciaList(Denuncia nuevo);
	public List<Denuncia> denunciaComboMunicipio();
	public List<Denuncia> denunciaComboColonia(Denuncia nuevo);
	public List<Denuncia> searchList(Denuncia descripcionLista, String rol);
	public int insertDenuncia(Denuncia nuevo);
	public void actualizarDenuncia(Denuncia nuevo);
	public void elimar(Denuncia nuevo);
	public Denuncia consultaDenuncia(Denuncia nuevo, String rol);
	public Denuncia consultaDenuncia(Denuncia nuevo);
	public void actualizaEstatusProceso(Denuncia nuevo);
	public void actualizaEstatusRecibido(Denuncia nuevo);
	public void actualizaEstatusDocumentacion(Denuncia nuevo);
	public void actualizaEstatusTerminado(Denuncia nuevo);
	
	
}
