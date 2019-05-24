package com.mkyong.users.service;

import java.util.List;

import com.mkyong.users.model.Relation_files_uui;

public interface Relation_files_uuiService {

	public void insertRelation_files_uui(Relation_files_uui nuevo);
	public void eliminarRelation_files_uui(Relation_files_uui nuevo);
	public  List<Relation_files_uui> buscarByName(String nombre);
	public List<Relation_files_uui> consultaRelation_files_uui(Relation_files_uui nuevo);
	
	
}
