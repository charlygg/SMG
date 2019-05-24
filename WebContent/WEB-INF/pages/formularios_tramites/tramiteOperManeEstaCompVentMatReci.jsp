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
 
 $("#idtramite_operacion_manejo_integral_establecimientos").change(function() {
	    $.getJSON('consultaTramite_operacion_manejo_integral_establecimientos?idtramite_operacion_manejo_integral_establecimientos='+$("#idtramite_operacion_manejo_integral_establecimientos").val(),function(data){
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
	        	 $('#asunto').val(data.asunto);
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
	        	 $('#numero_autorizacion_MIA').val(data.numero_autorizacion_MIA);
	        	 $('#numero_autorizacion_disposicion').val(data.numero_autorizacion_disposicion);
	        	 $('#numero_autorizacion_venta_compra').val(data.numero_autorizacion_venta_compra);
	        	 $('#describir_residuos').val(data.describir_residuos);
	        	 $('#nombre_residuo1').val(data.nombre_residuo1);
	        	 $('#cantidad_anual1').val(data.cantidad_anual1);
	        	 $('#generador_residuo1').val(data.generador_residuo1);
	        	 $('#nombre_residuo2').val(data.nombre_residuo2);
	        	 $('#cantidad_anual2').val(data.cantidad_anual2);
	        	 $('#generador_residuo2').val(data.generador_residuo2);
	        	 $('#nombre_residuo3').val(data.nombre_residuo3);
	        	 $('#cantidad_anual3').val(data.cantidad_anual3);
	        	 $('#generador_residuo3').val(data.generador_residuo3);
	        	 $('#nombre_residuo4').val(data.nombre_residuo4);
	        	 $('#cantidad_anual4').val(data.cantidad_anual4);
	        	 $('#generador_residuo4').val(data.generador_residuo4);
	        	 $('#nombre_residuo5').val(data.nombre_residuo5);
	        	 $('#cantidad_anual5').val(data.cantidad_anual5);
	        	 $('#generador_residuo5').val(data.generador_residuo5);
	        	 $('#descripcion_proceso_residuo').val(data.descripcion_proceso_residuo);
	        	 $('#productos_obtenidos').val(data.productos_obtenidos);
	        	 
	        	 $('#material1').val(data.material1);
	        	 $('#material2').val(data.material2);
	        	 $('#material3').val(data.material3);
	        	 $('#material4').val(data.material4);
	        	 $('#material5').val(data.material5);
	        	 $('#material6').val(data.material6);
	        	 $('#material7').val(data.material7);
	        	 $('#material8').val(data.material8);
	        	 $('#material9').val(data.material9);
	        	 $('#servicios_empresa').val(data.servicios_empresa);
	        	 $('#describir_manejo').val(data.describir_manejo);
	        	 $('#residuo1').val(data.residuo1);
	        	 $('#residuo2').val(data.generacion_mensual2);
	        	 $('#residuo3').val(data.generacion_mensual3);
	        	 $('#residuo4').val(data.residuo4);
	        	 $('#generacion_mensual1').val(data.generacion_mensual1);
	        	 $('#generacion_mensual2').val(data.generacion_mensual2);
	        	 $('#generacion_mensual3').val(data.generacion_mensual3);
	        	 $('#generacion_mensual4').val(data.generacion_mensual4);
	        	
	        	
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
			$.getJSON('listacomboTramite_operacion_manejo_integral_establecimientos?rol_usuario='+$("#rol_usuario").val(),function(data){
		        console.log(JSON.stringify(data));
		        //datos para el combo
		        if($("#rol_usuario").val() != 'ROLE_RECEP'){
		        	$("#idtramite_operacion_manejo_integral_establecimientos").append("<option value='0'>Escoja una opción</option>");	
		        }else{
		        	$("#idtramite_operacion_manejo_integral_establecimientos").append("<option value='0'>Escoja una opción</option>");
		        }
		        
		        $.each(data, function(i,item){
		        	 console.log(item.idtramite_operacion_manejo_integral_establecimientos);
		        	 var estatus = ''; 
		        	switch(item.estatus){
		        		case 1 : estatus = 'Nuevo';break;
		        		case 2 : estatus = 'Recibido';break;
		        		case 3 : estatus = 'Proceso';break;
		        		case 4 : estatus = 'Documentación';break;
		        		case 5 : estatus = 'Terminado';break;
		        		default : estatus = 'nuevo..';
		        	}	 
		            $("#idtramite_operacion_manejo_integral_establecimientos").append("<option value=\""+item.idtramite_operacion_manejo_integral_establecimientos+"\">Trámite No "+item.idtramite_operacion_manejo_integral_establecimientos+" en Estatus "+estatus+"</option>");
		        });
		        
		    });
		}
 
/**
 * 
 */	function cargaTablaMovsBitacora(estatus){
		if(estatus == 1){
			$('#divCargaBitacora').hide();
			$('#divCargaBitacora').empty();
		}else{
			$('#divCargaBitacora').show();
			$('#divCargaBitacora').load('consultaBitacoraCatReg?idregistro='+$('#idtramite').val()+'&catalogoID='+$('#tramite_catalogoID').val());
		}
		
		
	}

$(document).ready(function() {
		$.validator.setDefaults({submitHandler: function() { transaccionDatosRetornoID( 'registerTramite_operacion_manejo_integral_establecimientos', 'formulario', true, "exito()", "fallo()");}});
		$('#formulario').validate();
		comboListaTramite();
		comboEstatus();
});
	
	function exito(){
// 		mensajeriaAlertas('Exito', 'En Alta de Tramite Operación y Manejo Integral de los Establecimientos para la Compra y Venta de Materiales Reciclables.');
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
		mensajeriaAlertas('Error', 'En Alta de Tramite Operación y Manejo Integral de los Establecimientos para la Compra y Venta de Materiales Reciclables.');
		document.getElementById("catalogo_perfilempresa_idcatalogo_perfilempresa").selectedIndex = 0;
		document.getElementById("catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento").selectedIndex = -1;
		document.getElementById("catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento1").selectedIndex = -1;
		document.getElementById("estatus").selectedIndex = 0;
		$('#divCargaBitacora').hide();
		$('#divCargaBitacora').empty();
	}
	
	
	
	/////
		if($("#busquedaTramite").val() != 0){
		    $.getJSON('consultaTramite_operacion_manejo_integral_establecimientos?idtramite_operacion_manejo_integral_establecimientos='+$("#busquedaTramite").val(),function(data){
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
	        	 console.log(data.uuid);
	        	 $('#f_recepcion_tramite').val(data.f_recepcion_tramite);
				 $('#f_tramite_concluido').val(data.f_tramite_concluido);		
	        	 
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
	        	 $('#numero_autorizacion_MIA').val(data.numero_autorizacion_MIA);
	        	 $('#numero_autorizacion_disposicion').val(data.numero_autorizacion_disposicion);
	        	 $('#numero_autorizacion_venta_compra').val(data.numero_autorizacion_venta_compra);
	        	 $('#describir_residuos').val(data.describir_residuos);
	        	 $('#nombre_residuo1').val(data.nombre_residuo1);
	        	 $('#cantidad_anual1').val(data.cantidad_anual1);
	        	 $('#generador_residuo1').val(data.generador_residuo1);
	        	 $('#nombre_residuo2').val(data.nombre_residuo2);
	        	 $('#cantidad_anual2').val(data.cantidad_anual2);
	        	 $('#generador_residuo2').val(data.generador_residuo2);
	        	 $('#nombre_residuo3').val(data.nombre_residuo3);
	        	 $('#cantidad_anual3').val(data.cantidad_anual3);
	        	 $('#generador_residuo3').val(data.generador_residuo3);
	        	 $('#nombre_residuo4').val(data.nombre_residuo4);
	        	 $('#cantidad_anual4').val(data.cantidad_anual4);
	        	 $('#generador_residuo4').val(data.generador_residuo4);
	        	 $('#nombre_residuo5').val(data.nombre_residuo5);
	        	 $('#cantidad_anual5').val(data.cantidad_anual5);
	        	 $('#generador_residuo5').val(data.generador_residuo5);
	        	 $('#descripcion_proceso_residuo').val(data.descripcion_proceso_residuo);
	        	 $('#productos_obtenidos').val(data.productos_obtenidos);
	        	 
	        	 $('#material1').val(data.material1);
	        	 $('#material2').val(data.material2);
	        	 $('#material3').val(data.material3);
	        	 $('#material4').val(data.material4);
	        	 $('#material5').val(data.material5);
	        	 $('#material6').val(data.material6);
	        	 $('#material7').val(data.material7);
	        	 $('#material8').val(data.material8);
	        	 $('#material9').val(data.material9);
	        	 $('#servicios_empresa').val(data.servicios_empresa);
	        	 $('#describir_manejo').val(data.describir_manejo);
	        	 $('#residuo1').val(data.residuo1);
	        	 $('#residuo2').val(data.generacion_mensual2);
	        	 $('#residuo3').val(data.generacion_mensual3);
	        	 $('#residuo4').val(data.residuo4);
	        	 $('#generacion_mensual1').val(data.generacion_mensual1);
	        	 $('#generacion_mensual2').val(data.generacion_mensual2);
	        	 $('#generacion_mensual3').val(data.generacion_mensual3);
	        	 $('#generacion_mensual4').val(data.generacion_mensual4);
	        	
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
				$('#divCargaBitacora').load('consultaBitacoraCatReg?idregistro='+$('#idtramite_operacion_manejo_integral_establecimientos').val()+'&catalogoID='+$('#tramite_catalogoID').val());
			}
			
			
		}
</script>

<div class="row">
	<div class="col-lg-12">
		<div class="box box-success">
			<div class="box-header with-border">
				<h3 class="box-title">Tramite Operación y Manejo Integral de
					los Establecimientos para la Compra y Venta de Materiales
					Reciclables.</h3>
			</div>

			<div class="box-body">
				<!-- elemntos que se cambian por tramite -->
				<input type="hidden" id="areaNumOficio" value="RME"> <input
					type="hidden" id="titleNumOficio"
					value="Tramite Operación y Manejo Integral de los Establecimientos para la Compra y Venta de Materiales Reciclables">
				<input type="hidden" id="tipoTramiteNumOficio" value="36">
				<%@ include
					file="/WEB-INF/pages/formularios_tramites/numerOficio.jsp"%>
				<!-- terminas elementos  -->
				<form id="formulario" role="form">
					<!-- Agregar Esto -->
					<div class="input-group" id="dividtramite">
						<span class="input-group-addon">Trámites en Ejecución</span> <select
							class="form-control"
							id="idtramite_operacion_manejo_integral_establecimientos"
							name="idtramite_operacion_manejo_integral_establecimientos"></select>
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
						id="idtramite_operacion_manejo_integral_establecimientos"
						name="idtramite_operacion_manejo_integral_establecimientos"
						value="0">
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
								value="${data.idtramite_operacion_manejo_integral_establecimientos}">
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
					<h4>Operación y manejo integral de los establecimientos para
						la compra y venta de materiales reciclables.</h4>
					<table class="table table-condensed">
						<tr>
							<th>Material reciclable</th>
						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="material1" name="material1"></td>

						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="material2" name="material2"></td>

						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="material3" name="material3"></td>

						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="material4" name="material4"></td>

						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="material5" name="material5"></td>

						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="material6" name="material6"></td>

						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="material7" name="material7"></td>

						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="material8" name="material8"></td>

						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="material9" name="material9"></td>

						</tr>

					</table>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Servicios que ofrece la
							Empresa. (Además de la compra y venta de material reciclable)</span>
						<textarea class="form-control" id="servicios_empresa"
							name="servicios_empresa"></textarea>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Describir el manejo de los
							materiales reciclables desde la compra hasta la venta por medio
							de un diagrama de flujo.</span>
						<textarea class="form-control" id="describir_manejo"
							name="describir_manejo"></textarea>
					</div>
					<br>
					<table class="table table-condensed">
						<tr>
							<th>Residuo</th>
							<th>Generación mensual (Ton)</th>
						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="residuo1" name="residuo1"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="generacion_mensual1" name="generacion_mensual1"></td>
						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="residuo2" name="residuo2"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="generacion_mensual2" name="generacion_mensual2"></td>
						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="residuo3" name="residuo3"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="generacion_mensual3" name="generacion_mensual3"></td>
						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="residuo4" name="residuo4"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="generacion_mensual4" name="generacion_mensual4"></td>
						</tr>
					</table>
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