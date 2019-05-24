package com.mkyong.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "relation_files_uui")
public class Relation_files_uui {

	@Id
	@GeneratedValue
	@Column(name = "idrelation_files_id")
	private int idrelation_files_id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "UUI")
	private String UUI;

	public int getIdrelation_files_id() {
		return idrelation_files_id;
	}

	public void setIdrelation_files_id(int idrelation_files_id) {
		this.idrelation_files_id = idrelation_files_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUUI() {
		return UUI;
	}

	public void setUUI(String uUI) {
		UUI = uUI;
	}
	
}

