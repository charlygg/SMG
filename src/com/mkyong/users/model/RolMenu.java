package com.mkyong.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "rolmenu")
public class RolMenu {

	@Id
	@GeneratedValue
	@Column(name = "rolmenuID")
	private int rolmenuID;
	
	@Column(name = "rolID")
	private String rolID;
	
	@Column(name = "menu")
	private String menu;
	
	@Column(name = "submenu")
	private String submenu;
	
	@Column(name = "recurso")
	private String recurso;
	
	@Column(name = "nombreicono")
	private String nombreicono;
	
	
	
	public RolMenu(){
		
	}
	public RolMenu(int rolmenuID, String rolID, String menu, String  submenu, String recurso){
		this.rolmenuID = rolmenuID;
		this.rolID = rolID;
		this.menu = menu;
		this.submenu = submenu;
		this.recurso = recurso;
	}

	
	
	public int getRolmenuID() {
		return rolmenuID;
	}
	public void setRolmenuID(int rolmenuID) {
		this.rolmenuID = rolmenuID;
	}
	
		public String getRecurso() {
		return recurso;
	}
	public void setRecurso(String recurso) {
		this.recurso = recurso;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getSubmenu() {
		return submenu;
	}
	public void setSubmenu(String submenu) {
		this.submenu = submenu;
	}
	public String getRolID() {
		return rolID;
	}
	public void setRolID(String rolID) {
		this.rolID = rolID;
	}
	public String getNombreicono() {
		return nombreicono;
	}
	public void setNombreicono(String nombreicono) {
		this.nombreicono = nombreicono;
	}

	
	
}
