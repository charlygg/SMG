package com.ixanaui.utils;

public class EstatusBitacoraRegistro {
	private String[] lista={"Nuevo","Recibido","En proceso","Requerimientos de Documentacion","Terminado"};
	int tam;
	public EstatusBitacoraRegistro(){
		tam = 5;
	}
	public String getNombreEstatus(int Estatus){
		String aux = "Estatus no definido";
		try{
			int auxiliar = (Estatus);
			if(auxiliar <= this.tam && auxiliar > 0){
				aux = this.lista[auxiliar-1];
			}
		}catch(Exception e){
			e.getMessage();
		}
		
		
		return aux;
	}
}
