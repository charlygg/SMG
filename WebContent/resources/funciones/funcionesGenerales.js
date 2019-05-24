function mensajeriaAlertas(tipo, mensaje){
	var tipoNoti = '';
	
	switch(tipo){
		case 'Exito':
			tipoNoti = 'success';
			break;
		case 'Info':
			tipoNoti = 'info';
			break;
		case 'Adv':
			tipoNoti = 'notice';
			break;
		case 'Error':
			tipoNoti = 'error';
			break;
		default:
			tipoNoti = 'info';
	}
 new PNotify({
		 type: tipoNoti,
         title: tipo,
         text: mensaje
     });
}


function cargaMenu(datosEnvia){
	$.ajax({
			url:'listaRolMenu', 
			type:'GET', 
			data: datosEnvia,
 		success: function(response){
 			var div = document.getElementById("cargaListamenu");
 			if(response != null){
 				console.log(response);
 				var tam = response.length;
 				var contenedorMenu = document.getElementById('contenedorMenu');
 				var menuAuxiliar = null;
 				var menu = null;
 				var submenu = null;
 				for (var i= 0; i<tam; i++){
 					if(menuAuxiliar != response[i].menu){
 						menuAuxiliar = response[i].menu;
 						menu = document.createElement("li");
		 	    			menu.setAttribute("class", "treeview");
	 	    				var menua = document.createElement("a");
		 	    			menua.setAttribute("href", "#");
			 	    			var menui = document.createElement("i");
			 	    			menui.setAttribute("class", "fa "+response[i].nombreicono);
			 	    			var menuspan = document.createElement("span");
			 	    				var menutext = document.createTextNode(response[i].menu);
			 	    				menuspan.appendChild(menutext);
			 	    			var menui2 = document.createElement("i");
			 	    			menui2.setAttribute("class", "fa fa-angle-left pull-right");
			 	    			menua.appendChild(menui);
			 	    			menua.appendChild(menuspan);
			 	    			menua.appendChild(menui2);
			 	    		menu.appendChild(menua);
				 	    		submenu = document.createElement("ul");
			 	    			submenu.setAttribute("class", "treeview-menu");
			 	    			submenu.setAttribute("style", "display: none;");	
 					}
 								var submenuli = document.createElement("li");
 	    						var submenua = document.createElement("a");
 	    						submenua.setAttribute("href", "javascript:");
 	    						submenua.setAttribute("onclick", "$('#contenidoAUsuarios').load('"+response[i].recurso+"');");
 	    							var submenui = document.createElement("i");
 	    							submenui.setAttribute("class", "fa fa-circle-o");
 	    							var submenutext = document.createTextNode(response[i].submenu);
	 	    							console.log('rol-'+response[i].rolID+' menu-'+response[i].menu+' submenu-'+response[i].submenu+' recurso-'+response[i].recurso+' indice-'+i);
 	    							submenua.appendChild(submenui);
 	    							submenua.appendChild(submenutext);
	 	    						submenuli.appendChild(submenua);
	 	    					submenu.appendChild(submenuli);
 					
 					if(menuAuxiliar != null){
							menu.appendChild(submenu);
							contenedorMenu.appendChild(menu);
						}
						
 				}
 			}
 			$.AdminLTE.tree('.sidebar-menu');
 			
 		},
 		error: function(e){
 			console.log(e);
 		}
 		});
}

function transaccionDatos(URLrecurso,  idForma, inicializaforma, funcionExito, funcionFallo) {
//	console.log(URLrecurso+"//"+ idForma+"//"+ inicializaforma+"//"+ funcionExito+"//"+ funcionFallo);
	var jqForma = eval("'#" + idForma + "'");
	var resultadoTransaccion = false;	
		$.ajax({
          type: "POST",
          url: URLrecurso,
          data: $(jqForma).serialize(),
          success: function(response){
        	if(response.numero!=0){
        		eval(funcionFallo);
    			mensajeriaAlertas('Info', response.numero+'-'+response.mensaje+', contactar con el Administrador del Sistema, Ing. Carlos G. G., Ext. 32119');
    			var elementfocus = document.getElementById(response.referencia);
    			elementfocus.focus();
    			elementfocus.select();
    			console.log("exito: funcion Exito ejecutada error en db");
        	}else{
        		
        		if(inicializaforma){limpiaForm(jqForma);console.log('forma inicializada -'+idForma);}
    			eval(funcionExito); 
    			resultadoTransaccion = true;
    			console.log("exito: funcion Exito ejecutada");
    			console.log(response);
    			console.log(response.idNumTramite)
        	}
          },
          error:function(response){
			eval(funcionFallo);
			mensajeriaAlertas('Info', response.numero+'-'+response.mensaje+', contactar con el Administrador del Sistema, Ing. Carlos G. G., Ext. 32119');
			var elementfocus = document.getElementById(response.referencia);
			if(elementfocus != undefined && elementfocus != null){
				elementfocus.focus();
				elementfocus.select();
			}
			console.log("error funcion fallo disparada " + response);
          }
        });
	return resultadoTransaccion;
}


function limpiaForm(limforma) {
	$(':input', limforma).each(function() {
		var type = this.type;
		if (type == 'text' || type == 'password' || type == "textarea" || type == "email")
			this.value = "";
		else if (type == 'checkbox' || type == 'radio')
			this.checked = false;
		else if (type == 'select')
			this.selectedIndex = 0;
	});
	$("#input-700").fileinput("reset");
	$("#input-700").fileinput("clear");

}

function listaGenerica(controlId, minCaracteres, tipoListaVal, campoLista, parametroLista, vista) {
	jqControl = eval("'#" + controlId + "'");
	var positionpadre = $(jqControl).parent("div").position();
	var positionhijo = $(jqControl).position();
	var params = {};	
	if($(jqControl).val().length <= minCaracteres || !isNaN($(jqControl).val())) {
		$('#cajaLista').hide();		
	} else {

		//Si la Variable de CampoLista es un Arreglo
		if ( (typeof campoLista == 'object') && campoLista.length != null){
			for (i=0;i<campoLista.length;i++){				 		 	
				params[campoLista[i]] = parametroLista[i];
			}
		}else{
			params[campoLista] = parametroLista;			
		}		
		params['controlID'] = controlId; 						
		params['tipoLista'] = tipoListaVal;

		$('#cajaLista').css({
			position:'absolute',
			left: eval("'" + (positionpadre.left+positionhijo.left+11) + "px'"),
			top:  eval("'" + (positionpadre.top +40) + "px'"),
			zIndex: 1000
		}
		);
		
		
		$.ajax({
			url:vista, 
			type:'GET', 
			data: params, 
 		success: function(response){
 			console.log('lista exitosa');
 			if(response.length >0) {
				$('#cajaLista').show();
				$('#elementoLista').html(response);
				$('#cajaLista').focus();
				posicionamiento(jqControl, 'cajaLista');
				posicionamiento(jqControl, 'elementoLista');
			}
 			
 		},
 		error: function(e){
 			console.log('lista exitosa');
 		}
	    });
	}
}

function posicionamiento(jqControl, elemento) {
	jqElemento = eval("'#" + elemento + "'");

	$(jqElemento).position({
		my: "left top",
		at: "left bottom",
		of: jqControl
	});

}


function cargaValorLista(control, valor
		, funcion
	) {	
	jqControl = eval("'#" + control + "'");
	$(jqControl).val(valor);
	$(jqControl).focus();
	console.log(funcion);
	eval(funcion);
	setTimeout("$('#cajaLista').hide();", 200);
}

/* Transaccion datos modificada por Charly para retornar ID generado del tramite*/
/* Fecha de modificacion 09/06/2016 */
function transaccionDatosRetornoID(URLrecurso,  idForma, inicializaforma, funcionExito, funcionFallo) {
//	console.log(URLrecurso+"//"+ idForma+"//"+ inicializaforma+"//"+ funcionExito+"//"+ funcionFallo);
	var jqForma = eval("'#" + idForma + "'");
	var resultadoTransaccion = false;	
		$.ajax({
          type: "POST",
          url: URLrecurso,
          data: $(jqForma).serialize(),
          success: function(response){
        	if(response.numero!=0){
        		eval(funcionFallo);
    			mensajeriaAlertas('Info', response.numero+'-'+response.mensaje+', contactar con el Administrador del Sistema, Ing. Carlos G. G., Ext. 32119');
    			var elementfocus = document.getElementById(response.referencia);
    			elementfocus.focus();
    			elementfocus.select();
    			console.log("exito: funcion Exito ejecutada error en db");
        	}else{
        		/* Identificar el tipo de tramite y retornar ID */
        		switch(response.idTipoTramite){
        		case 1: mensajeriaAlertas('Exito', 'En Alta de Tramite Licencia de funcionamiento, tramite ID = ' + response.idNumTramite);
        			break;
        		case 2: mensajeriaAlertas('Exito', 'En Alta de Tramite Quema a Cielo Abierto, tramite ID = ' + response.idNumTramite);
        			break;
        		case 3: mensajeriaAlertas('Exito', 'En Alta de Tramite Cambio de Razón Social, tramite ID = ' + response.idNumTramite);
        			break;
        		case 4:	mensajeriaAlertas('Exito', 'En Alta de Tramite Cambio de Representante Legal, tramite ID = ' + response.idNumTramite);
        			break;
        		case 5: mensajeriaAlertas('Exito', 'En Alta de Tramite Cierre de operaciones, tramite ID = ' + response.idNumTramite);
        			break;
        		case 6: mensajeriaAlertas('Exito', 'En Alta de Tramite Evaluación de Impacto Ambiental, tramite ID = ' + response.idNumTramite);
        			break;
        		case 7: mensajeriaAlertas('Exito', 'En Alta de Cambio de titularidad, tramite ID = ' + response.idNumTramite);
        			break;
        		case 8: mensajeriaAlertas('Exito', 'En Alta de Tramite Registro de Prestadores de Servicio, tramite ID = ' + response.idNumTramite);
        			break;
        		case 9: mensajeriaAlertas('Exito', 'En Alta de Solicitud de prorrogas, tramite ID = ' + response.idNumTramite);
        			break;
        		case 10: mensajeriaAlertas('Exito', 'En Alta de Tramite Solicitud de Copias, tramite ID = ' + response.idNumTramite);
        			break;
        		case 11: mensajeriaAlertas('Exito', 'En Alta de Tramite Consultas de Impacto Ambiental, tramite ID = ' + response.idNumTramite);
        			break;
        		case 12: mensajeriaAlertas('Exito', 'En Alta de Tramite Modificación de proyectos, tramite ID = ' + response.idNumTramite);
        			break;
        		case 16: mensajeriaAlertas('Exito', 'En Alta de Tramite Aguas Residuales, tramite ID = ' + response.idNumTramite);
        			break;
        		case 17: mensajeriaAlertas('Exito', 'En Alta de Trámite Planta de Tratamento de Agua Residual, tramite ID = ' + response.idNumTramite);
        			break;
        		case 18: mensajeriaAlertas('Exito', 'En Alta de Trámite Registro de Fosa Séptica, tramite ID = ' + response.idNumTramite);
        			break;
        		case 19: mensajeriaAlertas('Exito', 'En Alta de Tramite Registro de Transportistas de Aguas Residuales, tramite ID = ' + response.idNumTramite);
        			break;
        		case 20: mensajeriaAlertas('Exito', 'En Alta de Tramite Informe Semestral, tramite ID = ' + response.idNumTramite);
        			break;
        		case 21: mensajeriaAlertas('Exito', 'En Alta de Tramite Solicitud de Información de Descargas, tramite ID = ' + response.idNumTramite);
        			break;
        		case 22: mensajeriaAlertas('Exito', 'En Alta de Tramite Actualización de transportistas, tramite ID = ' + response.idNumTramite);
        			break;
        		case 23: mensajeriaAlertas('Exito', 'En Alta de Tramite Actualización de Situación Particular de Descarga, tramite ID = ' + response.idNumTramite);
        			break;
        		case 24: mensajeriaAlertas('Exito', 'En Alta de Tramite Baja por cambio de domicilio, tramite ID =  ' + response.idNumTramite);
        			break;
        		case 25: mensajeriaAlertas('Exito', 'En Alta de Tramite Modificación de las condiciones particulares de descarga según el parámetro y/o número de descarga, tramite ID =  ' + response.idNumTramite);
        			break;
        		case 26: mensajeriaAlertas('Exito', 'En Alta de Tramite Baja por venta de pasivo ambiental, tramite ID  =  ' + response.idNumTramite);
        			break;
        		case 27: mensajeriaAlertas('Exito', 'En Alta de Tramite Autorización para la disposición final y registro como generador, tramite ID  =  ' + response.idNumTramite);
        			break;
        		case 28: mensajeriaAlertas('Exito', 'En Alta de Tramite Ubicación, operación y manejo integral de escombreras o sitios de disposición final de residuos provenientes de la construcción, tramite ID  =  ' + response.idNumTramite);
        			break;
        		case 29: mensajeriaAlertas('Exito', 'Ubicación, operación y manejo integral de sitios de disposición final de residuos provenientes de las estaciones de transferencia, tramite ID  =  ' + response.idNumTramite);
        			break;
        		case 30: mensajeriaAlertas('Exito', 'En Alta de Tramite Instalación de plantas de tratamiento térmico de residuos, tramite ID  =  ' + response.idNumTramite);
        			break;
        		case 31: mensajeriaAlertas('Exito', 'En Alta de Trámite Ubicación, operación y manejo integral de un relleno sanitario, conforme a las Normas Oficiales Mexicanas y demás ordenamientos aplicables, tramite ID  =  ' + response.idNumTramite);
        			break;
        		case 32: mensajeriaAlertas('Exito', 'En Alta de Trámite Transportes de residuos de manejo especial, tramite ID  =  ' + response.idNumTramite);
        			break;
        		case 33: mensajeriaAlertas('Exito', 'En Alta de Trámite Recolección de residuos de manejo especial, tramite ID  =  ' + response.idNumTramite);
        			break;
        		case 34: mensajeriaAlertas('Exito', 'En Alta de Tramite Reciclaje de Residuos de Manejo Especial, tramite ID  =  ' + response.idNumTramite);
        			break;
        		case 35: mensajeriaAlertas('Exito', 'En Alta de Tramite Operación de los Vehículos Recolectores de Residuos Sólidos Urbanos Cuando Presenten el Servicio a dos o más Municipios, tramite ID  =  ' + response.idNumTramite);
        			break;
        		case 36: mensajeriaAlertas('Exito', 'En Alta de Tramite Operación y Manejo Integral de los Establecimientos para la Compra y Venta de Materiales Reciclables, tramite ID  =  ' + response.idNumTramite);
        			break;
        		case 37: mensajeriaAlertas('Exito', 'En Alta de Tramite Planes de manejo específicos de residuos de manejo especial, tramite ID  =  ' + response.idNumTramite);
        			break;
        		case 39: mensajeriaAlertas('Exito', 'En Alta de Tramite Recepción y Validación de información del COA, tramite ID  =  ' + response.idNumTramite);
        			break;
        		case 40: mensajeriaAlertas('Exito', 'En Alta de Tramite Reuso de residuos de manejo especial, tramite ID  =  ' + response.idNumTramite);
        			break;
        		case 41: mensajeriaAlertas('Exito', 'En Alta de Tramite Operación y Manejo Integral de los Centros de Composteo, tramite ID  =  ' + response.idNumTramite);
        			break;
        		case 42: mensajeriaAlertas('Exito', 'En Alta de Tramite Modificación de Licencia de Funcionamiento, tramite ID  =  ' + response.idNumTramite);
        			break;
        		case 43: mensajeriaAlertas('Exito', 'En Alta de Otros de Inspección y Vigilancia, tramite ID  =  ' + response.idNumTramite);
        			break;
        		case 44: mensajeriaAlertas('Exito', 'En Alta de Tramite Baja de Permisos, tramite ID = ' + response.idNumTramite);
        			break;
        		case 45: mensajeriaAlertas('Exito', 'En Alta de Tramite Presentan Información Impacto Ambiental, tramite ID = ' + response.idNumTramite);
        			break;
        		case 47: mensajeriaAlertas('Exito', 'En Alta de Tramite Presentan Información Residuos de Manejo Especial, tramite ID = ' + response.idNumTramite);
        			break;
        		case 49: mensajeriaAlertas('Exito', 'En Alta de Tramite Pedreras, tramite ID = ' + response.idNumTramite);
        			break;
        			
        			default: mensajeriaAlertas('Error', 'En funcion Javascript, contactar con el Administrador del Sistema, Ing. Carlos G. G., Ext. 32119');
        		}
        		//mensajeriaAlertas('Exito', 'En Alta de Tramite Presentan Información Impacto Ambiental');
        		if(inicializaforma){limpiaForm(jqForma);console.log('forma inicializada -'+idForma);}
    			eval(funcionExito); 
    			resultadoTransaccion = true;
    			console.log("exito: funcion Exito ejecutada");
    			console.log(response);
    			console.log(response.idNumTramite)
        	}
          },
          error:function(response){
			eval(funcionFallo);
			mensajeriaAlertas('Info', response.numero+'-'+response.mensaje+', contactar con el Administrador del Sistema, Ing. Carlos G. G., Ext. 32119');
			var elementfocus = document.getElementById(response.referencia);
			if(elementfocus != undefined && elementfocus != null){
				elementfocus.focus();
				elementfocus.select();
			}
			console.log("error funcion fallo disparada " + response);
          }
        });
	return resultadoTransaccion;
}