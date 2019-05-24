package com.ixanaui.comunication;



public class HiloEmail extends Thread{
	
	String mensaje;
	String correo;
	String mensajeSubjet;
	
	public HiloEmail(String mensaje,String correo,String mensajeSubjet){
		this.mensaje= mensaje;
		this.correo=correo;
		this.mensajeSubjet= mensajeSubjet;
	}

	@Override
	public void run(){
		
		SendEmail mailto = new SendEmail();
		
					try {
						mailto.sendMessage( correo, mensaje,mensajeSubjet);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		
		
	}
}
