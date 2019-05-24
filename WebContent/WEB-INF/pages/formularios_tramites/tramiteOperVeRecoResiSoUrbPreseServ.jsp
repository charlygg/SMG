<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

<script type="text/javascript">
<!--

//-->
// $("#f_recepcion_tramite").inputmask("d/m/y",{ "placeholder": "dd/mm/yyyy" });
// $("#f_tramite_concluido").inputmask("d/m/y",{ "placeholder": "dd/mm/yyyy" });		

$("#f_recepcion_tramite").datepicker({dateFormat: "dd/mm/yy"});
$("#f_tramite_concluido").datepicker({dateFormat: "dd/mm/yy"});

$("#catalogo_perfilempresa_idcatalogo_perfilempresa").change(function() {
    $("#catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento").empty();
    $.getJSON('getArrayEstablecimientosPorEmpresa?idempresa='+$("#catalogo_perfilempresa_idcatalogo_perfilempresa").val(),function(data){
        console.log(JSON.stringify(data));
        $('#DatosEstablecimiento').prop( "hidden", true );
        $("#catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento").append("<option value=''>Escoja una opción</option>");

        $.each(data, function(i,item){
        	 console.log(item.idcatalogo_perfilestablecimiento);
            $("#catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento").append("<option value=\""+item.idcatalogo_perfilestablecimiento+"\">"+item.idcatalogo_perfilestablecimiento+"/"+item.colonia+"/"+item.municipio+"</option>");
        });
        $('#catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento').prop( "disabled", false );
    });
    ///
    $("#catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento1").empty();
    $.getJSON('getArrayEstablecimientosPorEmpresa?idempresa='+$("#catalogo_perfilempresa_idcatalogo_perfilempresa").val(),function(data){
        console.log(JSON.stringify(data));
        $('#DatosEstablecimiento').prop( "hidden", true );
        $("#catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento1").append("<option value=''>Escoja una opción</option>");

        $.each(data, function(i,item){
        	 console.log(item.idcatalogo_perfilestablecimiento);
            $("#catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento1").append("<option value=\""+item.idcatalogo_perfilestablecimiento+"\">"+item.idcatalogo_perfilestablecimiento+"/"+item.colonia+"/"+item.municipio+"</option>");
        });
        $('#catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento1').prop( "disabled", false );
    });
    
});


/**
 * 
 */
 
 $("#idtramite_operacion_vehi_recolectores").change(function() {
	    $.getJSON('consultaTramite_operacion_vehi_recolectores?idtramite_operacion_vehi_recolectores='+$("#idtramite_operacion_vehi_recolectores").val(),function(data){
	        console.log(JSON.stringify(data));
	        //cargar datos en la vista:
	        	$('#catalogo_perfilempresa_idcatalogo_perfilempresa > option[value="'+data.catalogo_perfilempresa_idcatalogo_perfilempresa+'"]').attr('selected', 'selected');
	        	///LLenas catalogo de establecimientos
	        		 $.getJSON('getArrayEstablecimientosPorEmpresa?idempresa='+$("#catalogo_perfilempresa_idcatalogo_perfilempresa").val(),function(lista){
        				console.log(JSON.stringify(lista));
        				$.each(lista, function(i,item){
        	 			console.log(item.idcatalogo_perfilestablecimiento);
            			$("#catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento").append("<option value=\""+item.idcatalogo_perfilestablecimiento+"\">"+item.idcatalogo_perfilestablecimiento+"/"+item.colonia+"/"+item.municipio+"</option>");
            			$("#catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento1").append("<option value=\""+item.idcatalogo_perfilestablecimiento+"\">"+item.idcatalogo_perfilestablecimiento+"/"+item.colonia+"/"+item.municipio+"</option>");
        				});
        				 $('#catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento').prop( "disabled", false );
        				 $('#catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento1').prop( "disabled", false );
        				 $('#catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento > option[value="'+data.catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento+'"]').attr('selected', 'selected');
        		        	$('#catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento1 > option[value="'+data.catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento1+'"]').attr('selected', 'selected');
        		        	
    			});
	        	
	        		 llenarcatalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento(data.catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento);
	        		 llenarcatalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento1(data.catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento1);
	        
	        	 $('#contacto_planta').val(data.contacto_planta); 
	        	 $('#UUID').val(data.uuid);
	        	 $('#asunto').val(data.asunto);
	        	 $('#f_recepcion_tramite').val(data.f_recepcion_tramite);
				 $('#f_tramite_concluido').val(data.f_tramite_concluido);	
	        	 console.log(data.uuid);
	        	 var codec= data.uuid;
	        	 //cargar las imagenes 
	        	 $.ajax({
					url:'imagenesUUI', //Url a donde la enviaremos
					type:'POST', //Metodo que usaremos
					data: "codec=" + codec, //Le pasamos el objeto que creamos con los archivos
					success: function(response){
						// we have the response
						console.log(response);
						$("#input-700").fileinput('refresh',{
						    uploadUrl: "guardarImagen", // server upload action
						    uploadAsync: false,
						    
						    showRemove: false,
						    showUpload:false,
							showCaption:false,
							showPreview:true,
							showCancel:false,
							
							uploadExtraData: {UUID: $("#UUID").val()},
							initialPreview: response.initialPreview,
							initialPreviewConfig: response.initialPreviewConfig,
						    

						    maxFileCount: 5
						}).on("filebatchselected", function(event, files) {
						    // trigger upload method immediately after files are selected
						    $("#input-700").fileinput("upload");
						});
						
					},
					error: function(e){
						
					}
					});
	        	 
	        	 
	        	 $('#rfc_planta').val(data.rfc_planta);
	        	 $('#lada_planta').val(data.lada_planta);
	        	 $('#telefono_planta').val(data.telefono_planta);
	        	 $('#email_planta').val(data.email_planta);
	        	 $('#contacto_notificacion').val(data.contacto_notificacion);
	        	 $('#rfc_notificacion').val(data.rfc_notificacion);
	        	 $('#lada_notificacion').val(data.lada_notificacion);
	        	 $('#telefono_notificacion').val(data.telefono_notificacion);
	        	 $('#email_notificacion').val(data.email_notificacion);
	        	 $('input:radio[name="giro_empresa"]').filter('[value='+data.giro_empresa+']').attr('checked', true);
	        	 $('#especificar').val(data.especificar);
	        	 $('#producto_final').val(data.producto_final);
	        	 
	        	///Empieza diferencia entre tablas
	        	 $('#numero_placa1').val(data.numero_placa1);
	        	 $('#niv1').val(data.niv1);
	        	 $('#marca1').val(data.marca1);
	        	 $('#tipo_vehiculo1').val(data.tipo_vehiculo1);
	        	 $('#modelo1').val(data.modelo1);
	        	 
	        	 $('#numero_placa2').val(data.numero_placa2);
	        	 $('#niv2').val(data.niv2);
	        	 $('#marca2').val(data.marca2);
	        	 $('#tipo_vehiculo2').val(data.tipo_vehiculo2);
	        	 $('#modelo2').val(data.modelo2);
	        	 
	        	 $('#numero_placa3').val(data.numero_placa3);
	        	 $('#niv3').val(data.niv3);
	        	 $('#marca3').val(data.marca3);
	        	 $('#tipo_vehiculo3').val(data.tipo_vehiculo3);
	        	 $('#modelo3').val(data.modelo3);
	        	 
	        	 $('#numero_placa4').val(data.numero_placa4);
	        	 $('#niv4').val(data.niv4);
	        	 $('#marca4').val(data.marca4);
	        	 $('#tipo_vehiculo4').val(data.tipo_vehiculo4);
	        	 $('#modelo4').val(data.modelo4);
	        	 
	        	 $('#numero_placa5').val(data.numero_placa5);
	        	 $('#niv5').val(data.niv5);
	        	 $('#marca5').val(data.marca5);
	        	 $('#tipo_vehiculo5').val(data.tipo_vehiculo5);
	        	 $('#modelo5').val(data.modelo5);
	        	 
	        	 $('#numero_placa6').val(data.numero_placa6);
	        	 $('#niv6').val(data.niv6);
	        	 $('#marca6').val(data.marca6);
	        	 $('#tipo_vehiculo6').val(data.tipo_vehiculo6);
	        	 $('#modelo6').val(data.modelo6);
	        	 
	        	 $('#numero_placa7').val(data.numero_placa7);
	        	 $('#niv7').val(data.niv7);
	        	 $('#marca7').val(data.marca7);
	        	 $('#tipo_vehiculo7').val(data.tipo_vehiculo7);
	        	 $('#modelo7').val(data.modelo7);
	        	 
	        	 $('#numero_placa8').val(data.numero_placa8);
	        	 $('#niv8').val(data.niv8);
	        	 $('#marca8').val(data.marca8);
	        	 $('#tipo_vehiculo8').val(data.tipo_vehiculo8);
	        	 $('#modelo8').val(data.modelo8);
	        	 
	        	 $('#numero_placa9').val(data.numero_placa9);
	        	 $('#niv9').val(data.niv9);
	        	 $('#marca9').val(data.marca9);
	        	 $('#tipo_vehiculo9').val(data.tipo_vehiculo9);
	        	 $('#modelo9').val(data.modelo9);
	        	 
	        	 $('#descripcion_proceso_residuo').val(data.descripcion_proceso_residuo);
	        	 $('#productos_obtenidos').val(data.productos_obtenidos);
	        	
	        $("#estatus").empty();
	        cargaTablaMovsBitacora(data.estatus);
	        if($("#rol_usuario").val() == 'ROLE_RECEP'){
	        	if(data.estatus == 1){
	        		$("#estatus").append("<option value='1'>Nuevo</option>");
	        		$("#estatus").append("<option value='2'>Recibido</option>");
	        	}else{
	        		$("#estatus").append("<option value='1'>Nuevo</option>");
	        	}
	        }else{
	        	switch(data.estatus){
		        case 2:
		        	$("#estatus").append("<option value='2'>Recibido</option>");
		        	$("#estatus").append("<option value='3'>Proceso</option>");
		        	$('#btn_enviar').prop('disabled', false);
		        	break;
		        case 3:
		        	$("#estatus").append("<option value='3'>Proceso</option>");
		        	$("#estatus").append("<option value='4'>Documentacion</option>");
		        	$("#estatus").append("<option value='5'>Terminado</option>");
		        	$('#btn_enviar').prop('disabled', false);
		        	///mostar el numero de oficio
		        	$('#ocultarNumOficio').show(); //muestro mediante id
		        	break;
		        case 4:
		        	$("#estatus").append("<option value='4'>Documentacion</option>");
		        	$('#btn_enviar').prop('disabled', false);
		        	break;
		        case 5:
		        	$("#estatus").append("<option value='5'>Terminado</option>");
		        	$('#btn_enviar').prop('disabled', true);
		        	break;
		        default:
	        		$("#estatus").append("<option value='1'>Nuevo..</option>");
	        		$('#btn_enviar').prop('disabled', false);
	        	}
	        	
	        }
	        
	        
	    });
	});
		function comboEstatus(){
			if($("#rol_usuario").val() == 'ROLE_RECEP'){
	        	$("#estatus").append("<option value='1'>Nuevo</option>");	
	        }
	    }
		function comboListaTramite(){
			$.getJSON('listacomboTramite_operacion_vehi_recolectores?rol_usuario='+$("#rol_usuario").val(),function(data){
		        console.log(JSON.stringify(data));
		        //datos para el combo
		        if($("#rol_usuario").val() != 'ROLE_RECEP'){
		        	$("#idtramite_operacion_vehi_recolectores").append("<option value='0'>Escoja una opción</option>");	
		        }else{
		        	$("#idtramite_operacion_vehi_recolectores").append("<option value='0'>Escoja una opción</option>");
		        }
		        
		        $.each(data, function(i,item){
		        	 console.log(item.idtramite_operacion_vehi_recolectores);
		        	 var estatus = ''; 
		        	switch(item.estatus){
		        		case 1 : estatus = 'Nuevo';break;
		        		case 2 : estatus = 'Recibido';break;
		        		case 3 : estatus = 'Proceso';break;
		        		case 4 : estatus = 'Documentación';break;
		        		case 5 : estatus = 'Terminado';break;
		        		default : estatus = 'nuevo..';
		        	}	 
		            $("#idtramite_operacion_vehi_recolectores").append("<option value=\""+item.idtramite_operacion_vehi_recolectores+"\">Trámite No "+item.idtramite_operacion_vehi_recolectores+" en Estatus "+estatus+"</option>");
		        });
		        
		    });
		}
 
/**
 * 
 */

$(document).ready(function() {
		$.validator.setDefaults({submitHandler: function() { transaccionDatosRetornoID( 'registerTramite_operacion_vehi_recolectores', 'formulario', true, "exito()", "fallo()");}});
		$('#formulario').validate();
		comboListaTramite();
		comboEstatus();
});
	
	function exito(){
// 		mensajeriaAlertas('Exito', 'En Alta de Tramite Operación de los Vehículos Recolectores de Residuos Sólidos Urbanos Cuando Presenten el Servicio a dos o más Municipios.');
		document.getElementById("catalogo_perfilempresa_idcatalogo_perfilempresa").selectedIndex = 0;
		document.getElementById("catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento").selectedIndex = -1;
		document.getElementById("catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento1").selectedIndex = -1;
		document.getElementById("estatus").selectedIndex = 0;
		///mostar el numero de oficio
    	$('#ocultarNumOficio').hide(); //muestro mediante id
		$('#divCargaBitacora').hide();
		$('#divCargaBitacora').empty();
	}
	function fallo(){
		mensajeriaAlertas('Error', 'En Alta de Tramite Operación de los Vehículos Recolectores de Residuos Sólidos Urbanos Cuando Presenten el Servicio a dos o más Municipios.');
		document.getElementById("catalogo_perfilempresa_idcatalogo_perfilempresa").selectedIndex = 0;
		document.getElementById("catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento").selectedIndex = -1;
		document.getElementById("catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento1").selectedIndex = -1;
		document.getElementById("estatus").selectedIndex = 0;
		$('#divCargaBitacora').hide();
		$('#divCargaBitacora').empty();
	}
	
	if($("#busquedaTramite").val() != 0){
		 $.getJSON('consultaTramite_operacion_vehi_recolectores?idtramite_operacion_vehi_recolectores='+$("#busquedaTramite").val(),function(data){
		        console.log(JSON.stringify(data));
		        //cargar datos en la vista:
		        	$('#catalogo_perfilempresa_idcatalogo_perfilempresa > option[value="'+data.catalogo_perfilempresa_idcatalogo_perfilempresa+'"]').attr('selected', 'selected');
		        	///LLenas catalogo de establecimientos
		        		 $.getJSON('getArrayEstablecimientosPorEmpresa?idempresa='+$("#catalogo_perfilempresa_idcatalogo_perfilempresa").val(),function(lista){
	        				console.log(JSON.stringify(lista));
	        				$.each(lista, function(i,item){
	        	 			console.log(item.idcatalogo_perfilestablecimiento);
	            			$("#catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento").append("<option value=\""+item.idcatalogo_perfilestablecimiento+"\">"+item.idcatalogo_perfilestablecimiento+"/"+item.colonia+"/"+item.municipio+"</option>");
	            			$("#catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento1").append("<option value=\""+item.idcatalogo_perfilestablecimiento+"\">"+item.idcatalogo_perfilestablecimiento+"/"+item.colonia+"/"+item.municipio+"</option>");
	        				});
	        				 $('#catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento').prop( "disabled", false );
	        				 $('#catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento1').prop( "disabled", false );
	        				 $('#catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento > option[value="'+data.catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento+'"]').attr('selected', 'selected');
	     		        	$('#catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento1 > option[value="'+data.catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento1+'"]').attr('selected', 'selected');
	     		        	 
	    			});
		        
		        	$('#contacto_planta').val(data.contacto_planta); 
		        	 $('#UUID').val(data.uuid);
		        	 $('#f_recepcion_tramite').val(data.f_recepcion_tramite);
					 $('#f_tramite_concluido').val(data.f_tramite_concluido);	
		        	 console.log(data.uuid);
		        	 
		        	 var codec= data.uuid;
		        	 //cargar las imagenes 
		        	 $.ajax({
						url:'imagenesUUI', //Url a donde la enviaremos
						type:'POST', //Metodo que usaremos
						data: "codec=" + codec, //Le pasamos el objeto que creamos con los archivos
						success: function(response){
							// we have the response
							console.log(response);
							$("#input-700").fileinput('refresh',{
							    uploadUrl: "guardarImagen", // server upload action
							    uploadAsync: false,
							    
							    showRemove: false,
							    showUpload:false,
								showCaption:false,
								showPreview:true,
								showCancel:false,
								
								uploadExtraData: {UUID: $("#UUID").val()},
								initialPreview: response.initialPreview,
								initialPreviewConfig: response.initialPreviewConfig,
							    

							    maxFileCount: 5
							}).on("filebatchselected", function(event, files) {
							    // trigger upload method immediately after files are selected
							    $("#input-700").fileinput("upload");
							});
							
						},
						error: function(e){
							
						}
						});
		        	
		        	 $('#rfc_planta').val(data.rfc_planta);
		        	 $('#lada_planta').val(data.lada_planta);
		        	 $('#telefono_planta').val(data.telefono_planta);
		        	 $('#email_planta').val(data.email_planta);
		        	 $('#contacto_notificacion').val(data.contacto_notificacion);
		        	 $('#rfc_notificacion').val(data.rfc_notificacion);
		        	 $('#lada_notificacion').val(data.lada_notificacion);
		        	 $('#telefono_notificacion').val(data.telefono_notificacion);
		        	 $('#email_notificacion').val(data.email_notificacion);
		        	 $('input:radio[name="giro_empresa"]').filter('[value='+data.giro_empresa+']').attr('checked', true);
		        	 $('#especificar').val(data.especificar);
		        	 $('#producto_final').val(data.producto_final);
		        	 
		        	///Empieza diferencia entre tablas
		        	 $('#numero_placa1').val(data.numero_placa1);
		        	 $('#niv1').val(data.niv1);
		        	 $('#marca1').val(data.marca1);
		        	 $('#tipo_vehiculo1').val(data.tipo_vehiculo1);
		        	 $('#modelo1').val(data.modelo1);
		        	 
		        	 $('#numero_placa2').val(data.numero_placa2);
		        	 $('#niv2').val(data.niv2);
		        	 $('#marca2').val(data.marca2);
		        	 $('#tipo_vehiculo2').val(data.tipo_vehiculo2);
		        	 $('#modelo2').val(data.modelo2);
		        	 
		        	 $('#numero_placa3').val(data.numero_placa3);
		        	 $('#niv3').val(data.niv3);
		        	 $('#marca3').val(data.marca3);
		        	 $('#tipo_vehiculo3').val(data.tipo_vehiculo3);
		        	 $('#modelo3').val(data.modelo3);
		        	 
		        	 $('#numero_placa4').val(data.numero_placa4);
		        	 $('#niv4').val(data.niv4);
		        	 $('#marca4').val(data.marca4);
		        	 $('#tipo_vehiculo4').val(data.tipo_vehiculo4);
		        	 $('#modelo4').val(data.modelo4);
		        	 
		        	 $('#numero_placa5').val(data.numero_placa5);
		        	 $('#niv5').val(data.niv5);
		        	 $('#marca5').val(data.marca5);
		        	 $('#tipo_vehiculo5').val(data.tipo_vehiculo5);
		        	 $('#modelo5').val(data.modelo5);
		        	 
		        	 $('#numero_placa6').val(data.numero_placa6);
		        	 $('#niv6').val(data.niv6);
		        	 $('#marca6').val(data.marca6);
		        	 $('#tipo_vehiculo6').val(data.tipo_vehiculo6);
		        	 $('#modelo6').val(data.modelo6);
		        	 
		        	 $('#numero_placa7').val(data.numero_placa7);
		        	 $('#niv7').val(data.niv7);
		        	 $('#marca7').val(data.marca7);
		        	 $('#tipo_vehiculo7').val(data.tipo_vehiculo7);
		        	 $('#modelo7').val(data.modelo7);
		        	 
		        	 $('#numero_placa8').val(data.numero_placa8);
		        	 $('#niv8').val(data.niv8);
		        	 $('#marca8').val(data.marca8);
		        	 $('#tipo_vehiculo8').val(data.tipo_vehiculo8);
		        	 $('#modelo8').val(data.modelo8);
		        	 
		        	 $('#numero_placa9').val(data.numero_placa9);
		        	 $('#niv9').val(data.niv9);
		        	 $('#marca9').val(data.marca9);
		        	 $('#tipo_vehiculo9').val(data.tipo_vehiculo9);
		        	 $('#modelo9').val(data.modelo9);
		        	 
		        	 $('#descripcion_proceso_residuo').val(data.descripcion_proceso_residuo);
		        	 $('#productos_obtenidos').val(data.productos_obtenidos);
		        	
		        $("#estatus").empty();
		        if($("#rol_usuario").val() == 'ROLE_RECEP'){
		        	if(data.estatus == 1){
		        		$("#estatus").append("<option value='1'>Nuevo</option>");
		        		$("#estatus").append("<option value='2'>Recibido</option>");
		        	}else{
		        		$("#estatus").append("<option value='1'>Nuevo</option>");
		        	}
		        }else{
		        	switch(data.estatus){
			        case 2:
			        	$("#estatus").append("<option value='2'>Recibido</option>");
			        	$("#estatus").append("<option value='3'>Proceso</option>");
			        	$('#btn_enviar').prop('disabled', false);
			        	break;
			        case 3:
			        	$("#estatus").append("<option value='3'>Proceso</option>");
			        	$("#estatus").append("<option value='4'>Documentacion</option>");
			        	$("#estatus").append("<option value='5'>Terminado</option>");
			        	$('#btn_enviar').prop('disabled', false);
			        	break;
			        case 4:
			        	$("#estatus").append("<option value='4'>Documentacion</option>");
			        	$('#btn_enviar').prop('disabled', false);
			        	break;
			        case 5:
			        	$("#estatus").append("<option value='5'>Terminado</option>");
			        	$('#btn_enviar').prop('disabled', true);
			        	break;
			        default:
		        		$("#estatus").append("<option value='1'>Nuevo..</option>");
		        		$('#btn_enviar').prop('disabled', false);
		        	}
		        	
		        }
		        
		        
		    });
	}
	function cargaTablaMovsBitacora(estatus){
		if(estatus == 1){
			$('#divCargaBitacora').hide();
			$('#divCargaBitacora').empty();
		}else{
			$('#divCargaBitacora').show();
			$('#divCargaBitacora').load('consultaBitacoraCatReg?idregistro='+$('#idtramite_operacion_vehi_recolectores').val()+'&catalogoID='+$('#tramite_catalogoID').val());
		}
		
		
	}
</script>

<div class="row">
	<div class="col-lg-12">
		<div class="box box-success">
			<div class="box-header with-border">
				<h3 class="box-title">Tramite Operación de los Vehículos
					Recolectores de Residuos Sólidos Urbanos Cuando Presenten el
					Servicio a dos o más Municipios.</h3>
			</div>

			<div class="box-body">
				<!-- elemntos que se cambian por tramite -->
				<input type="hidden" id="areaNumOficio" value="RME"> <input
					type="hidden" id="titleNumOficio"
					value="Tramite Operación de los Vehículos Recolectores de Residuos Sólidos Urbanos Cuando Presenten el Servicio a dos o más Municipios">
				<input type="hidden" id="tipoTramiteNumOficio" value="35">
				<%@ include
					file="/WEB-INF/pages/formularios_tramites/numerOficio.jsp"%>
				<!-- terminas elementos  -->
				<form id="formulario" role="form">
					<!-- Agregar Esto -->
					<div class="input-group" id="dividtramite">
						<span class="input-group-addon">Trámites en Ejecución</span> <select
							class="form-control" id="idtramite_operacion_vehi_recolectores"
							name="idtramite_operacion_vehi_recolectores"></select>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Asunto</span>
						<c:choose>
							<c:when test="${!empty data}">
								<textarea id="asunto" name="asunto" class="form-control"
									required>${data.asunto}</textarea>
							</c:when>
							<c:otherwise>
								<textarea id="asunto" name="asunto" class="form-control"
									required></textarea>
							</c:otherwise>
						</c:choose>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Fecha de recepcón de
							documentación de tramite</span>
						<c:choose>
							<c:when test="${!empty data}">
								<input type="text" id="f_recepcion_tramite"
									name="f_recepcion_tramite" class="form-control"
									value="${data.f_recepcion_tramite}">
							</c:when>
							<c:otherwise>
								<input type="text" id="f_recepcion_tramite"
									name="f_recepcion_tramite" class="form-control">
							</c:otherwise>
						</c:choose>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Fecha de tramite concluido</span>
						<c:choose>
							<c:when test="${!empty data}">
								<input type="text" id="f_tramite_concluido"
									name="f_tramite_concluido" class="form-control"
									value="${data.f_tramite_concluido}">

							</c:when>
							<c:otherwise>
								<input type="text" id="f_tramite_concluido"
									name="f_tramite_concluido" class="form-control">
							</c:otherwise>
						</c:choose>
					</div>
					<br> <input type="hidden"
						id="idtramite_operacion_vehi_recolectores"
						name="idtramite_operacion_vehi_recolectores" value="0">
					<!--  -->
					<c:choose>
						<c:when test="${empty data}">
							<input type="hidden" id="UUID" name="UUID" value="${UUID}">
							<input type="hidden" id="busquedaTramite" name="busquedaTramite"
								value="0">
						</c:when>
						<c:otherwise>
							<input type="hidden" id="UUID" name="UUID" value="${data.UUID}">
							<input type="hidden" id="busquedaTramite" name="busquedaTramite"
								value="${data.idtramite_operacion_vehi_recolectores}">
						</c:otherwise>
					</c:choose>
					<!--  -->
					<!-- Termina Agregar -->
					<div class="input-group">
						<span class="input-group-addon">Nombre de Empresa</span> <select
							id="catalogo_perfilempresa_idcatalogo_perfilempresa"
							name="catalogo_perfilempresa_idcatalogo_perfilempresa"
							class="form-control" required>
							<option value="">Escoja una opción</option>
							<c:forEach items="${empresas}" var="empresa">
								<option value="${empresa.idcatalogo_perfilempresa}">${empresa.nombreEmpresa}</option>
							</c:forEach>
						</select>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Establecimiento municipio</span> <select
							id="catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento"
							name="catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento"
							class="form-control" disabled="disabled" required>
						</select>
					</div>
					<br>
					<%@ include
						file="/WEB-INF/pages/formularios_tramites/seccionEstablecimiento.jsp"%>
					<div class="input-group">
						<span class="input-group-addon">Nombre del contacto:</span> <input
							maxlength="100" type="text" class="form-control"
							id="contacto_planta" name="contacto_planta">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">R.F.C.:</span> <input
							maxlength="100" type="text" class="form-control" id="rfc_planta"
							name="rfc_planta">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Lada: </span> <input
							maxlength="100" type="text" class="form-control" id="lada_planta"
							name="lada_planta">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Teléfono:</span> <input
							maxlength="100" type="text" class="form-control"
							id="telefono_planta" name="telefono_planta">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">e-mail:</span> <input
							maxlength="100" type="text" class="form-control"
							id="email_planta" name="email_planta">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Establecimiento municipio</span> <select
							id="catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento1"
							name="catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento1"
							class="form-control" disabled="disabled" required>
						</select>
					</div>
					<br>
					<%@ include
						file="/WEB-INF/pages/formularios_tramites/seccionEstablecimientoMatriz.jsp"%>
					<div class="input-group">
						<span class="input-group-addon">Nombre del contacto:</span> <input
							maxlength="100" type="text" class="form-control"
							id="contacto_notificacion" name="contacto_notificacion">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">R.F.C.:</span> <input
							maxlength="100" type="text" class="form-control"
							id="rfc_notificacion" name="rfc_notificacion">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Lada: </span> <input
							maxlength="100" type="text" class="form-control"
							id="lada_notificacion" name="lada_notificacion">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Teléfono:</span> <input
							maxlength="100" type="text" class="form-control"
							id="telefono_notificacion" name="telefono_notificacion">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">e-mail:</span> <input
							maxlength="100" type="text" class="form-control"
							id="email_notificacion" name="email_notificacion">
					</div>
					<br>
					<h4>Actividades de la empresa o negociación.</h4>
					<div class="input-group">
						<span class="input-group-addon">Giro de la empresa o
							negociación:</span> <input type="radio" id="giro_empresa"
							name="giro_empresa" value="I">Industrial &nbsp &nbsp
						&nbsp <input type="radio" id="giro_empresa" name="giro_empresa"
							value="C">Comercial y/o Servicios &nbsp &nbsp &nbsp <input
							type="radio" id="giro_empresa" name="giro_empresa" value="O">Otro
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Especificar:</span>
						<textarea id="especificar" name="especificar" class="form-control"></textarea>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Producto Final:</span>
						<textarea id="producto_final" name="producto_final"
							class="form-control"></textarea>
					</div>
					<br>
					<h4>Operación de los vehículos recolectores de residuos
						sólidos urbanos cuando presten el servicio a dos o más
						municipios y para la recolección y tranposrte de residuos de
						manejo especial.</h4>
					<table class="table table-condensed">
						<tr>
							<th>Número de placa</th>
							<th>NIV</th>
							<th>Marca</th>
							<th>Tipo de vehículo</th>
							<th>Modelo</th>
						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="numero_placa1" name="numero_placa1"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="niv1" name="niv1"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="marca1" name="marca1"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="tipo_vehiculo1" name="tipo_vehiculo1"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="modelo1" name="modelo1"></td>
						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="numero_placa2" name="numero_placa2"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="niv2" name="niv2"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="marca2" name="marca2"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="tipo_vehiculo2" name="tipo_vehiculo2"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="modelo2" name="modelo2"></td>
						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="numero_placa3" name="numero_placa3"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="niv3" name="niv3"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="marca3" name="marca3"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="tipo_vehiculo3" name="tipo_vehiculo3"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="modelo3" name="modelo3"></td>
						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="numero_placa4" name="numero_placa4"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="niv4" name="niv4"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="marca4" name="marca4"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="tipo_vehiculo4" name="tipo_vehiculo4"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="modelo4" name="modelo4"></td>
						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="numero_placa5" name="numero_placa5"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="niv5" name="niv5"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="marca5" name="marca5"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="tipo_vehiculo5" name="tipo_vehiculo5"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="modelo5" name="modelo5"></td>
						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="numero_placa6" name="numero_placa6"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="niv6" name="niv6"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="marca6" name="marca6"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="tipo_vehiculo6" name="tipo_vehiculo6"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="modelo6" name="modelo6"></td>
						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="numero_placa7" name="numero_placa7"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="niv7" name="niv7"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="marca7" name="marca7"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="tipo_vehiculo7" name="tipo_vehiculo7"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="modelo7" name="modelo7"></td>
						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="numero_placa8" name="numero_placa8"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="niv8" name="niv8"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="marca8" name="marca8"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="tipo_vehiculo8" name="tipo_vehiculo8"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="modelo8" name="modelo8"></td>
						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="numero_placa9" name="numero_placa9"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="niv9" name="niv9"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="marca9" name="marca9"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="tipo_vehiculo9" name="tipo_vehiculo9"></td>
							<td><input type="text" class="form-control" id="modelo9"
								name="modelo9"></td>
						</tr>

					</table>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Número total de
							vehículos:</span> <input maxlength="100" type="text"
							class="form-control" id="numero_vehiculos"
							name="numero_vehiculos">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Destino final de los
							residuos de manejo especial:</span>
						<textarea class="form-control" id="destino_final"
							name="destino_final"></textarea>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon"></span> <select id="estatus"
							name="estatus" class="form-control"></select>
					</div>
					<!--  -->
					<%@ include
						file="/WEB-INF/pages/formularios_tramites/seccionArchivos.jsp"%>
					<br> <br>
					<c:choose>
						<c:when test="${empty data}">
							<input id="btn_enviar" type="submit"
								class="submit btn btn-primary" value="Guardar" />
						</c:when>
					</c:choose>
					<!--  -->
				</form>
			</div>
			<!-- /.box-body -->
			<div class="box-footer"></div>
		</div>
		<!-- /.box -->
	</div>
</div>
<div class="row">
	<input type="hidden" id="tramite_catalogoID" value="${ catalogoID }">
	<div id="divCargaBitacora" style="overflow-y: scroll;"></div>
</div>