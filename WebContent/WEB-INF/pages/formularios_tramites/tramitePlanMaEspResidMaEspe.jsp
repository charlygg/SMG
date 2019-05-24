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
 
 $("#idtramite_planes_manejo_especificos").change(function() {
	    $.getJSON('consultaTramite_planes_manejo_especificos?idtramite_planes_manejo_especificos='+$("#idtramite_planes_manejo_especificos").val(),function(data){
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
	        	
	        		 $('#f_recepcion_tramite').val(data.f_recepcion_tramite);
					 $('#f_tramite_concluido').val(data.f_tramite_concluido);	
	        	 $('#contacto_planta').val(data.contacto_planta); 
	        	 $('#UUID').val(data.uuid);
	        	 $('#asunto').val(data.asunto);
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
			$.getJSON('listacomboTramite_planes_manejo_especificos?rol_usuario='+$("#rol_usuario").val(),function(data){
		        console.log(JSON.stringify(data));
		        //datos para el combo
		        if($("#rol_usuario").val() != 'ROLE_RECEP'){
		        	$("#idtramite_planes_manejo_especificos").append("<option value='0'>Escoja una opción</option>");	
		        }else{
		        	$("#idtramite_planes_manejo_especificos").append("<option value='0'>Escoja una opción</option>");
		        }
		        
		        $.each(data, function(i,item){
		        	 console.log(item.idtramite_planes_manejo_especificos);
		        	 var estatus = ''; 
		        	switch(item.estatus){
		        		case 1 : estatus = 'Nuevo';break;
		        		case 2 : estatus = 'Recibido';break;
		        		case 3 : estatus = 'Proceso';break;
		        		case 4 : estatus = 'Documentación';break;
		        		case 5 : estatus = 'Terminado';break;
		        		default : estatus = 'nuevo..';
		        	}	 
		            $("#idtramite_planes_manejo_especificos").append("<option value=\""+item.idtramite_planes_manejo_especificos+"\">Trámite No "+item.idtramite_planes_manejo_especificos+" en Estatus "+estatus+"</option>");
		        });
		        
		    });
		}
 
/**
 * 
 */

$(document).ready(function() {
		$.validator.setDefaults({submitHandler: function() { transaccionDatosRetornoID( 'registerTramite_planes_manejo_especificos', 'formulario', true, "exito()", "fallo()");}});
		$('#formulario').validate();
		comboListaTramite();
		comboEstatus();
});
	
	function exito(){
// 		mensajeriaAlertas('Exito', 'En Alta de Tramite Planes de manejo específicos de residuos de manejo especial.');
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
		mensajeriaAlertas('Error', 'En Alta de Tramite Planes de manejo específicos de residuos de manejo especial.');
		document.getElementById("catalogo_perfilempresa_idcatalogo_perfilempresa").selectedIndex = 0;
		document.getElementById("catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento").selectedIndex = -1;
		document.getElementById("catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento1").selectedIndex = -1;
		document.getElementById("estatus").selectedIndex = 0;
		$('#divCargaBitacora').hide();
		$('#divCargaBitacora').empty();
	}
	
	
	///
	if($("#busquedaTramite").val() != 0){
	 $.getJSON('consultaTramite_planes_manejo_especificos?idtramite_planes_manejo_especificos='+$("#busquedaTramite").val(),function(data){
	        console.log(JSON.stringify(data));
	        //cargar datos en la vista:
	        	$('#catalogo_perfilempresa_idcatalogo_perfilempresa > option[value="'+data.catalogo_perfilempresa_idcatalogo_perfilempresa+'"]').attr('selected', 'selected');
	        	///LLenas catalogo de establecimientos
	        		 $.getJSON('getArrayEstablecimientosPorEmpresa?idempresa='+$("#catalogo_perfilempresa_idcatalogo_perfilempresa").val(),function(data){
        				console.log(JSON.stringify(data));
        				$.each(data, function(i,item){
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
			$('#divCargaBitacora').load('consultaBitacoraCatReg?idregistro='+$('#idtramite').val()+'&catalogoID='+$('#tramite_catalogoID').val());
		}
		
		
	}
</script>

<div class="row">
	<div class="col-lg-12">
		<div class="box box-success">
			<div class="box-header with-border">
				<h4 class="box-title">Tramite Planes de manejo específicos de
					residuos de manejo especial.</h4>
			</div>

			<div class="box-body">
				<!-- elemntos que se cambian por tramite -->
				<input type="hidden" id="areaNumOficio" value="RME"> <input
					type="hidden" id="titleNumOficio"
					value="Tramite Planes de manejo específicos de residuos de manejo especial">
				<input type="hidden" id="tipoTramiteNumOficio" value="37">
				<%@ include
					file="/WEB-INF/pages/formularios_tramites/numerOficio.jsp"%>
				<!-- terminas elementos  -->
				<form id="formulario" role="form">
					<!-- Agregar Esto -->
					<div class="input-group" id="dividtramite">
						<span class="input-group-addon">Trámites en Ejecución</span> <select
							class="form-control" id="idtramite_planes_manejo_especificos"
							name="idtramite_planes_manejo_especificos"></select>
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
						id="idtramite_planes_manejo_especificos"
						name="idtramite_planes_manejo_especificos" value="0">
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
								value="${data.idtramite_planes_manejo_especificos}">
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
					<h4>Planes de manejo específicos de residuos de manejo
						especial.</h4>
					<div class="input-group">
						<span class="input-group-addon">Plan de manejo que se
							presenta:</span>
						<div class="checkbox">
							<input type="checkbox" id="plan_manejo" name="plan_manejo">
							Residuos que se generen en cualquier actividad relacionada con la
							extracción, beneficio, transformación, procesamiento y/o
							utilización de materiales para producir bienes y servicios que
							no reúnen características domiciliares o no posen alguna de las
							características de peligrosidad. <br> <input
								type="checkbox" id="plan_manejo" name="plan_manejo">
							Residuos sólidos urbanos generados por un gran generador en una
							cantidad igual o mayor a 10 toneladas al año.
						</div>
					</div>
					<br>
					<div class="box-body">
						<div class="input-group">
							<span class="input-group-addon"> Modalidad del Plan de
								Manejo:</span> <select id="modalidad_plan" name="modalidad_plan"
								class="form-control">
								<option value="Privados">Privados</option>
								<option value="Individuales">Individuales</option>
								<option value="Mixtos">Mixtos</option>
								<option value="Colectivos">Colectivos</option>
							</select>
						</div>

					</div>
					<br>
					<table class="table table-condensed">
						<tr>
							<th>Nombre del residuo</th>
							<th>Generación mensual (toneladas)</th>
							<th>Formas de manejo: R (reciclaje, reuso o
								coprocesamiento)/ C (cofinamiento)</th>
						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="p_nombre_residuo1" name="p_nombre_residuo1"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="p_generacion_men1" name="p_generacion_men1"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="p_forma_manejo1" name="p_forma_manejo1"></td>
						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="p_nombre_residuo2" name="p_nombre_residuo2"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="p_generacion_men2" name="p_generacion_men2"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="p_forma_manejo2" name="p_forma_manejo2"></td>
						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="p_nombre_residuo3" name="p_nombre_residuo3"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="p_generacion_men3" name="p_generacion_men3"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="p_forma_manejo3" name="p_forma_manejo3"></td>
						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="p_nombre_residuo4" name="p_nombre_residuo4"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="p_generacion_men4" name="p_generacion_men4"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="p_forma_manejo4" name="p_forma_manejo4"></td>
						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="p_nombre_residuo5" name="p_nombre_residuo5"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="p_generacion_men5" name="p_generacion_men5"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="p_forma_manejo5" name="p_forma_manejo5"></td>
						</tr>

					</table>
					<br>
					<table class="table table-condensed">
						<tr>
							<th>Residuo</th>
							<th>Almacenamiento Temporal</th>

						</tr>
						<tr>
							<th>Residuo</th>
							<th>Tipo de contenedor</th>
							<th>Capacidad del contenedor</th>
							<th>Tiempo de almacenamiento</th>
						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
						</tr>
					</table>
					<br>
					<h4>Si genera el residuo de grasas y aceites vegetales
						provenientes de Trampa de Grasas resgistrada especifique la
						siguiente infromación</h4>

					<table class="table table-condensed">
						<tr>
							<th>Tipo deTrampa: I-Industrial A-Alimentos O-Otros,
								especificar</th>
							<th>Capacidad</th>
							<th>Frecuencia de limpieza</th>
							<th>Empresa o negociación que brinda el servicio de
								limpieza</th>
							<th>No. de autorización</th>
							<th>Vigencia de autorización</th>
						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="a_tipo_trampa1" name="a_tipo_trampa1"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="a_capacidad1" name="a_capacidad1"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="a_frecuencia_limp1" name="a_frecuencia_limp1"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="a_empresa1" name="a_empresa1"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="a_numero_autorizacion1" name="a_numero_autorizacion1"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="a_vigencia_autorizacion1" name="a_vigencia_autorizacion1"></td>
						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="a_tipo_trampa2" name="a_tipo_trampa2"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="a_capacidad2" name="a_capacidad2"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="a_frecuencia_limp2" name="a_frecuencia_limp2"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="a_empresa2" name="a_empresa2"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="a_numero_autorizacion2" name="a_numero_autorizacion2"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="a_vigencia_autorizacion2" name="a_vigencia_autorizacion2"></td>
						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="a_tipo_trampa3" name="a_tipo_trampa3"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="a_capacidad3" name="a_capacidad3"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="a_frecuencia_limp3" name="a_frecuencia_limp3"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="a_empresa3" name="a_empresa3"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="a_numero_autorizacion3" name="a_numero_autorizacion3"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="a_vigencia_autorizacion3" name="a_vigencia_autorizacion3"></td>
						</tr>

					</table>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Tipo deTrampa: I-Industrial
							A-Alimentos O-Otros, especificar</span>
						<textarea class="form-control" id="tipo_trampa_especificar"
							name="tipo_trampa_especificar"></textarea>
					</div>
					<br>
					<h4>Indicar los residuos de manejo especial sujetos al plan de
						manejo, de forma decreciente según su volumen de generación.</h4>
					<table class="table table-condensed">
						<tr>
							<th>Residuo</th>
							<th>Generación (tonela / día)</th>
							<th>Proceso del que se genera</th>
							<th>Composición del residuo</th>
						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="g_residuo1" name="g_residuo1"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="g_generacion_dia1" name="g_generacion_dia1"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="g_proceso_genera1" name="g_proceso_genera1"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="g_composicion_residuo1" name="g_composicion_residuo1"></td>
						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="g_residuo2" name="g_residuo2"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="g_generacion_dia2" name="g_generacion_dia2"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="g_proceso_genera2" name="g_proceso_genera2"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="g_composicion_residuo2" name="g_composicion_residuo2"></td>
						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="g_residuo3" name="g_residuo3"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="g_generacion_dia3" name="g_generacion_dia3"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="g_proceso_genera3" name="g_proceso_genera3"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="g_composicion_residuo3" name="g_composicion_residuo3"></td>
						</tr>

					</table>
					<br>
					<h4>Manejo Actual del Residuos objeto del Plan de Manejo.</h4>
					<h5>a) Minimización de Residuos de Manejo Especial.</h5>
					<div class="input-group">
						<span class="input-group-addon">Método de reducción:</span> <input
							maxlength="100" type="text" class="form-control"
							class="form-control" id="metodo_reduccion"
							name="metodo_reduccion">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Tipo de residuo:</span> <input
							maxlength="100" type="text" class="form-control"
							class="form-control" id="tipo_reduccion" name="tipo_reduccion">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Descripción del método:</span> <input
							maxlength="100" type="text" class="form-control"
							class="form-control" id="descripcion_metodo"
							name="descripcion_metodo">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Cantidad mensual promedio
							obtenida sin el método:</span> <input maxlength="100" type="text"
							class="form-control" class="form-control" id="CantMens_sinMetodo"
							name="CantMens_sinMetodo">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Cantidad mensual promedio
							obtenido con el método:</span> <input maxlength="100" type="text"
							class="form-control" class="form-control" id="CantMens_conMetodo"
							name="CantMens_conMetodo">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Porcentaje de reducción:</span> <input
							maxlength="100" type="text" class="form-control"
							class="form-control" id="Porcentaje_reduccion"
							name="Porcentaje_reduccion">
					</div>
					<br>
					<h5>b) Reuso o Coprosesamiento de los Residuos de Manejo
						Especial.</h5>
					<div class="input-group">
						<span class="input-group-addon">Residuo:</span> <input
							maxlength="100" type="text" class="form-control"
							class="form-control" id="nombre_residuo" name="nombre_residuo">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Cantidad de residuo que se
							somete a coprocesamiento y/o reuso (ton/mes):</span> <input
							maxlength="100" type="text" class="form-control"
							class="form-control" id="cantidad_coproceso"
							name="cantidad_coproceso">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon"></span> <select
							id="tipo_coproceso" name="tipo_coproceso" class="form-control"
							required>
							<option value="Coprosesamiento">Coprosesamiento</option>
							<option value="Reuso">Reuso</option>
						</select>
					</div>



					<div class="input-group">
						<span class="input-group-addon">Interno:</span> <input
							maxlength="100" type="text" class="form-control"
							class="form-control" id="interno" name="interno">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Externo:</span> <select
							id="externo" name="externo" class="form-control" required>
							<option value="Coprosesamiento">Donación del Residuo</option>
							<option value="Venta del Residuo">Venta del Residuo</option>
						</select>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Nombre de la empresa o
							negociación:</span> <input maxlength="100" type="text"
							class="form-control" class="form-control" id="e_nombre_empresa"
							name="e_nombre_empresa">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Domicilio de la empresa o
							negociación:</span> <input maxlength="100" type="text"
							class="form-control" class="form-control"
							id="e_domicilio_empresa" name="e_domicilio_empresa">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Giro de la empresa o
							negociación:</span> <input maxlength="100" type="text"
							class="form-control" class="form-control" id="e_giro_empresa"
							name="e_giro_empresa">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Sitio o etapa del proceso
							donde es utilizado:</span> <input maxlength="100" type="text"
							class="form-control" class="form-control" id="e_etapa_proceso"
							name="e_etapa_proceso">
					</div>
					<h4>Valorización de los Residuos de Manejo Especial.</h4>

					<table class="table table-condensed">
						<tr>
							<th>Residuo</th>
							<th>Cantidad de residuo destinada a la compra-venta
								(Ton/mes)</th>
							<th>Negociación con la que se lleva a cabo la compra-venta
								del residuo</th>
							<th>N° de autorización de la negociación para la actividad
								de compra-venta</th>
							<th>Vigencia de la autorización.</th>
						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="v_residuo1" name="v_residuo1"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="v_cantidad1" name="v_cantidad1"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="v_negociacion1" name="v_negociacion1"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="v_numero_actorizacion1" name="v_numero_actorizacion1"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="v_vigencia1" name="v_vigencia1"></td>
						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="v_residuo2" name="v_residuo2"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="v_cantidad2" name="v_cantidad2"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="v_negociacion2" name="v_negociacion2"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="v_numero_actorizacion2" name="v_numero_actorizacion2"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="v_vigencia2" name="v_vigencia2"></td>
						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="v_residuo3" name="v_residuo3"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="v_cantidad3" name="v_cantidad3"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="v_negociacion3" name="v_negociacion3"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="v_numero_actorizacion3" name="v_numero_actorizacion3"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="v_vigencia3" name="v_vigencia3"></td>
						</tr>
					</table>
					<br>
					<h4>Tratamiento de los Residuos de Manejo Especial.
						(formación de composta, producción de biogás , producción de
						combustible alterno, etc.</h4>
					<table class="table table-condensed">
						<tr>
							<th>Residuo</th>
							<th>Tratamiento al que fué sujeto</th>
							<th>Cantidad sujeta al tratamiento (ton/mes)</th>
							<th>Prestador del servicio</th>
							<th>No. de autorización correspondiente al tratamiento.</th>
							<th>Vigencia de autorización</th>
						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="t_residuo1" name="t_residuo1"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="t_tratamiento1" name="t_tratamiento1"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="t_cantidad1" name="t_cantidad1"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="t_prestador1" name="t_prestador1"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="t_num_actorizacion1" name="t_num_actorizacion1"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="t_vigencia1" name="t_vigencia1"></td>
						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="t_residuo2" name="t_residuo2"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="t_tratamiento2" name="t_tratamiento2"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="t_cantidad2" name="t_cantidad2"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="t_prestador2" name="t_prestador2"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="t_num_actorizacion2" name="t_num_actorizacion2"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="t_vigencia2" name="t_vigencia2"></td>
						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="t_residuo3" name="t_residuo3"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="t_tratamiento3" name="t_tratamiento3"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="t_cantidad3" name="t_cantidad3"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="t_prestador3" name="t_prestador3"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="t_num_actorizacion3" name="t_num_actorizacion3"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="t_vigencia3" name="t_vigencia3"></td>
						</tr>
					</table>
					<br>
					<h4>Tabla de resumen de las formas de manejo integral
						propuesta para los residuos generados.</h4>
					<table class="table table-condensed">
						<tr>
							<th></th>
							<th>Manejo Integral</th>
							<th>Servicio</th>
							<th>Razón Social</th>
							<th>No. de autorización</th>
							<th>Vigencia de autorización</th>
						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="r_sin1" name="r_sin1"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="r_manejo1" name="r_manejo1"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="r_servicio1" name="r_servicio1"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="r_razon1" name="r_razon1"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="r_num_autorizacion1" name="r_num_autorizacion1"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="r_vigencia1" name="r_vigencia1"></td>
						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="r_sin2" name="r_sin2"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="r_manejo2" name="r_manejo2"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="r_servicio2" name="r_servicio2"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="r_razon2" name="r_razon2"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="r_num_autorizacion2" name="r_num_autorizacion2"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="r_vigencia2" name="r_vigencia2"></td>
						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="r_sin3" name="r_sin3"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="r_manejo3" name="r_manejo3"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="r_servicio3" name="r_servicio3"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="r_razon3" name="r_razon3"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="r_num_autorizacion3" name="r_num_autorizacion3"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="r_vigencia3" name="r_vigencia3"></td>
						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="r_sin4" name="r_sin4"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="r_manejo4" name="r_manejo4"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="r_servicio4" name="r_servicio4"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="r_razon4" name="r_razon4"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="r_num_autorizacion4" name="r_num_autorizacion4"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="r_vigencia4" name="r_vigencia4"></td>
						</tr>

						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="r_sin5" name="r_sin5"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="r_manejo5" name="r_manejo5"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="r_servicio5" name="r_servicio5"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="r_razon5" name="r_razon5"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="r_num_autorizacion5" name="r_num_autorizacion5"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="r_vigencia5" name="r_vigencia5"></td>
						</tr>

						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="r_sin6" name="r_sin6"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="r_manejo6" name="r_manejo6"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="r_servicio6" name="r_servicio6"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="r_razon6" name="r_razon6"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="r_num_autorizacion6" name="r_num_autorizacion6"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="r_vigencia6" name="r_vigencia6"></td>
						</tr>

						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
						</tr>

						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
						</tr>

						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
						</tr>

						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
						</tr>

						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
						</tr>

						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
						</tr>

					</table>
					<br>
					<h4>Metas de cobertura del Plan de Manejo de recuperación o
						aprovechamiento del residuo, durante la aplicación del Plan de
						Manejo .</h4>
					<table class="table table-condensed">
						<tr>
							<th>Meta</th>
							<th>Descripción de las actividades</th>
							<th>Fecha de implementación de las actividades</th>
							<th>Periodicidad de evaluación de las actividades</th>
							<th>Entrega de actualizaciones para el alcance de objetivos</th>

						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="m_meta1" name="m_meta1"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="m_descripcion1" name="m_descripcion1"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="m_fecha1" name="m_fecha1"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="m_periodo1" name="m_periodo1"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="m_entrega1" name="m_entrega1"></td>

						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="m_meta2" name="m_meta2"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="m_descripcion2" name="m_descripcion2"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="m_fecha2" name="m_fecha2"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="m_periodo2" name="m_periodo2"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="m_entrega2" name="m_entrega2"></td>

						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="m_meta3" name="m_meta3"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="m_descripcion3" name="m_descripcion3"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="m_fecha3" name="m_fecha3"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="m_periodo3" name="m_periodo3"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="m_entrega3" name="m_entrega3"></td>

						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>

						</tr>
						<tr>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>
							<td><input maxlength="100" type="text" class="form-control"
								id="calle" name="calle"></td>

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