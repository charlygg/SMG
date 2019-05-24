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

$("#idempresa").change(function() {
    $("#idestablecimiento").empty();
    $.getJSON('getArrayEstablecimientosPorEmpresa?idempresa='+$("#idempresa").val(),function(data){
        console.log(JSON.stringify(data));
        $('#DatosEstablecimiento').prop( "hidden", true );
        $("#idestablecimiento").append("<option value=''>Escoja una opción</option>");

        $.each(data, function(i,item){
        	 console.log(item.idcatalogo_perfilestablecimiento);
            $("#idestablecimiento").append("<option value=\""+item.idcatalogo_perfilestablecimiento+"\">"+item.idcatalogo_perfilestablecimiento+"/"+item.colonia+"/"+item.municipio+"</option>");
        });
        $('#idestablecimiento').prop( "disabled", false );
    });
    ///
    $("#idestablecimientomens").empty();
    $.getJSON('getArrayEstablecimientosPorEmpresa?idempresa='+$("#idempresa").val(),function(data){
        console.log(JSON.stringify(data));
        $('#DatosEstablecimiento').prop( "hidden", true );
        $("#idestablecimientomens").append("<option value=''>Escoja una opción</option>");

        $.each(data, function(i,item){
        	 console.log(item.idcatalogo_perfilestablecimiento);
            $("#idestablecimientomens").append("<option value=\""+item.idcatalogo_perfilestablecimiento+"\">"+item.idcatalogo_perfilestablecimiento+"/"+item.colonia+"/"+item.municipio+"</option>");
        });
        $('#idestablecimientomens').prop( "disabled", false );
    });
    
});

/**
 * 
 */
 
 $("#idtramite").change(function() {
	    $.getJSON('consultaTramite_instaplantratorresid?idtramite='+$("#idtramite").val(),function(data){
	        console.log(JSON.stringify(data));
	        //cargar datos en la vista:
	        	$('#idempresa > option[value="'+data.idempresa+'"]').attr('selected', 'selected');
	        	///LLenas catalogo de establecimientos
	        		 $.getJSON('getArrayEstablecimientosPorEmpresa?idempresa='+$("#idempresa").val(),function(lista){
        				console.log(JSON.stringify(lista));
        				$.each(lista, function(i,item){
        	 			console.log(item.idcatalogo_perfilestablecimiento);
            			$("#idestablecimiento").append("<option value=\""+item.idcatalogo_perfilestablecimiento+"\">"+item.idcatalogo_perfilestablecimiento+"/"+item.colonia+"/"+item.municipio+"</option>");
            			$("#idestablecimientomens").append("<option value=\""+item.idcatalogo_perfilestablecimiento+"\">"+item.idcatalogo_perfilestablecimiento+"/"+item.colonia+"/"+item.municipio+"</option>");
        				});
        				 $('#idestablecimiento').prop( "disabled", false );
        				 $('#idestablecimientomens').prop( "disabled", false );
        				 $('#idestablecimiento > option[value="'+data.idestablecimiento+'"]').attr('selected', 'selected');
        		        	$('#idestablecimientomens > option[value="'+data.idestablecimientomens+'"]').attr('selected', 'selected');
    			});
	        		 llenaridestablecimiento(data.idestablecimiento);
	        		 llenaridestablecimientomens(data.idestablecimientomens);
	        		 $('#f_recepcion_tramite').val(data.f_recepcion_tramite);
					 $('#f_tramite_concluido').val(data.f_tramite_concluido);			
	        	 $('#nombreconp').val(data.nombreconp); 
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
	        	 
	        	 
	        	 $('#rfcp').val(data.rfcp);
	        	 $('#ladap').val(data.ladap);
	        	 $('#telefonop').val(data.telefonop);
	        	 $('#extensionp').val(data.extensionp);
	        	 $('#emailp').val(data.emailp);
	        	 $('#cp').val(data.cp);
	        	 $('#cps').val(data.cps);
	        	 $('#nombrecons').val(data.nombrecons);
	        	 $('#rfcs').val(data.rfcs);
	        	 $('input:radio[name="giro"]').filter('[value='+data.giro+']').attr('checked', true);
	        	 $('#ladas').val(data.ladas);
	        	 $('#telefonos').val(data.telefonos);
	        	///Empieza diferencia entre tablas
	        	 $('#extensions').val(data.extensions);
	        	 $('#emails').val(data.emails);
	        	 $('#especificar').val(data.especificar);
	        	 $('#productofinal').val(data.productofinal);
	        	 $('#innuaudifiremaesp').val(data.innuaudifiremaesp);
	        	 $('#innuaumaimamb').val(data.innuaumaimamb);
	        	 $('#inussuauprdosipltrter').val(data.inussuauprdosipltrter);
	        	 $('#detitrteut').val(data.detitrteut);
	        	 $('#nores_a').val(data.nores_a);
	        	 $('#caanestra_a').val(data.caanestra_a);
	        	 $('#gere_a').val(data.gere_a);
	        	 $('#nuaut_a').val(data.nuaut_a);
	        	 $('#nores_b').val(data.nores_b);
	        	 $('#caanestra_b').val(data.caanestra_b);
	        	 $('#gere_b').val(data.gere_b);
	        	 $('#nuaut_b').val(data.nuaut_b);
	        	 $('#nores_c').val(data.nores_c);
	        	 $('#caanestra_c').val(data.caanestra_c);
	        	 $('#gere_c').val(data.gere_c);
	        	 $('#nuaut_c').val(data.nuaut_c);
	        	 $('#nores_d').val(data.nores_d);
	        	 
	        	 $('#caanestra_d').val(data.caanestra_d);
	        	 $('#gere_d').val(data.gere_d);
	        	 $('#nuaut_d').val(data.nuaut_d);
	        	 $('#nores_e').val(data.nores_e);
	        	 $('#caanestra_e').val(data.caanestra_e);
	        	 $('#gere_e').val(data.gere_e);
	        	 $('#nuaut_e').val(data.nuaut_e);
	        	 $('#nores_f').val(data.nores_f);
	        	 $('#caanestra_f').val(data.caanestra_f);
	        	 $('#gere_f').val(data.gere_f);
	        	 $('#nuaut_f').val(data.nuaut_f);
	        	 $('#nores_g').val(data.nores_g);
	        	 $('#caanestra_g').val(data.caanestra_g);
	        	 $('#gere_g').val(data.gere_g);
	        	 $('#nuaut_g').val(data.nuaut_g);
	        	 $('#nuaut_g').val(data.nuaut_g);
	        	 $('#caanestra_h').val(data.caanestra_h);
	        	 $('#gere_h').val(data.gere_h);
	        	 $('#nuaut_h').val(data.nuaut_h);
	        	 $('#insidifiregetrter').val(data.insidifiregetrter);
	        	

	        	 
	        	 
	        	
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
			$.getJSON('listacomboTramite_instaplantratorresid?rol_usuario='+$("#rol_usuario").val(),function(data){
		        console.log(JSON.stringify(data));
		        //datos para el combo
		        if($("#rol_usuario").val() != 'ROLE_RECEP'){
		        	$("#idtramite").append("<option value='0'>Escoja una opción</option>");	
		        }else{
		        	$("#idtramite").append("<option value='0'>Escoja una opción</option>");
		        }
		        
		        $.each(data, function(i,item){
		        	 console.log(item.idtramite);
		        	 var estatus = ''; 
		        	switch(item.estatus){
		        		case 1 : estatus = 'Nuevo';break;
		        		case 2 : estatus = 'Recibido';break;
		        		case 3 : estatus = 'Proceso';break;
		        		case 4 : estatus = 'Documentación';break;
		        		case 5 : estatus = 'Terminado';break;
		        		default : estatus = 'nuevo..';
		        	}	 
		            $("#idtramite").append("<option value=\""+item.idtramite+"\">Trámite No "+item.idtramite+" en Estatus "+estatus+"</option>");
		        });
		        
		    });
		}
 
/**
 * 
 */

$(document).ready(function() {
		$.validator.setDefaults({submitHandler: function() { transaccionDatosRetornoID( 'registertramite_instaplantratorresid', 'formulario', true, "exito()", "fallo()");}});
		$('#formulario').validate();
		comboListaTramite();
		comboEstatus();
});
	
	function exito(){
// 		mensajeriaAlertas('Exito', 'En Alta de Tramite Instalación de plantas de tratamiento térmico de residuos.');
		document.getElementById("idempresa").selectedIndex = 0;
		document.getElementById("idestablecimiento").selectedIndex = -1;
		document.getElementById("idestablecimientomens").selectedIndex = -1;
		document.getElementById("estatus").selectedIndex = 0;
		///mostar el numero de oficio
    	$('#ocultarNumOficio').hide(); //muestro mediante id
		$('#divCargaBitacora').hide();
		$('#divCargaBitacora').empty();
	}
	function fallo(){
		mensajeriaAlertas('Error', 'En Alta de Tramite Instalación de plantas de tratamiento térmico de residuos.');
		document.getElementById("idempresa").selectedIndex = 0;
		document.getElementById("idestablecimiento").selectedIndex = -1;
		document.getElementById("idestablecimientomens").selectedIndex = -1;
		document.getElementById("estatus").selectedIndex = 0;
		$('#divCargaBitacora').hide();
		$('#divCargaBitacora').empty();
	}
	
	if($("#busquedaTramite").val() != 0){
		 $.getJSON('consultaTramite_instaplantratorresid?idtramite='+$("#busquedaTramite").val(),function(data){
		        console.log(JSON.stringify(data));
		        //cargar datos en la vista:
		        	$('#idempresa > option[value="'+data.idempresa+'"]').attr('selected', 'selected');
		        	///LLenas catalogo de establecimientos
		        		 $.getJSON('getArrayEstablecimientosPorEmpresa?idempresa='+$("#idempresa").val(),function(lista){
	        				console.log(JSON.stringify(lista));
	        				$.each(lista, function(i,item){
	        	 			console.log(item.idcatalogo_perfilestablecimiento);
	            			$("#idestablecimiento").append("<option value=\""+item.idcatalogo_perfilestablecimiento+"\">"+item.idcatalogo_perfilestablecimiento+"/"+item.colonia+"/"+item.municipio+"</option>");
	            			$("#idestablecimientomens").append("<option value=\""+item.idcatalogo_perfilestablecimiento+"\">"+item.idcatalogo_perfilestablecimiento+"/"+item.colonia+"/"+item.municipio+"</option>");
	        				});
	        				 $('#idestablecimiento').prop( "disabled", false );
	        				 $('#idestablecimientomens').prop( "disabled", false );
	        				 $('#idestablecimiento > option[value="'+data.idestablecimiento+'"]').attr('selected', 'selected');
	     		        	$('#idestablecimientomens > option[value="'+data.idestablecimientomens+'"]').attr('selected', 'selected');
	    			});
		        
		        	
		        	 $('#nombreconp').val(data.nombreconp); 
		        	 $('#UUID').val(data.uuid);
		        	 console.log(data.uuid);
		        	 $('#f_recepcion_tramite').val(data.f_recepcion_tramite);
					 $('#f_tramite_concluido').val(data.f_tramite_concluido);	
		        	 
		        	 
		        	 $('#rfcp').val(data.rfcp);
		        	 $('#ladap').val(data.ladap);
		        	 $('#telefonop').val(data.telefonop);
		        	 $('#extensionp').val(data.extensionp);
		        	 $('#emailp').val(data.emailp);
		        	 $('#cp').val(data.cp);
		        	 $('#cps').val(data.cps);
		        	 $('#nombrecons').val(data.nombrecons);
		        	 $('#rfcs').val(data.rfcs);
		        	 $('input:radio[name="giro"]').filter('[value='+data.giro+']').attr('checked', true);
		        	 $('#ladas').val(data.ladas);
		        	 $('#telefonos').val(data.telefonos);
		        	///Empieza diferencia entre tablas
		        	 $('#extensions').val(data.extensions);
		        	 $('#emails').val(data.emails);
		        	 $('#especificar').val(data.especificar);
		        	 $('#productofinal').val(data.productofinal);
		        	 $('#innuaudifiremaesp').val(data.innuaudifiremaesp);
		        	 $('#innuaumaimamb').val(data.innuaumaimamb);
		        	 $('#inussuauprdosipltrter').val(data.inussuauprdosipltrter);
		        	 $('#detitrteut').val(data.detitrteut);
		        	 $('#nores_a').val(data.nores_a);
		        	 $('#caanestra_a').val(data.caanestra_a);
		        	 $('#gere_a').val(data.gere_a);
		        	 $('#nuaut_a').val(data.nuaut_a);
		        	 $('#nores_b').val(data.nores_b);
		        	 $('#caanestra_b').val(data.caanestra_b);
		        	 $('#gere_b').val(data.gere_b);
		        	 $('#nuaut_b').val(data.nuaut_b);
		        	 $('#nores_c').val(data.nores_c);
		        	 $('#caanestra_c').val(data.caanestra_c);
		        	 $('#gere_c').val(data.gere_c);
		        	 $('#nuaut_c').val(data.nuaut_c);
		        	 $('#nores_d').val(data.nores_d);
		        	 
		        	 $('#caanestra_d').val(data.caanestra_d);
		        	 $('#gere_d').val(data.gere_d);
		        	 $('#nuaut_d').val(data.nuaut_d);
		        	 $('#nores_e').val(data.nores_e);
		        	 $('#caanestra_e').val(data.caanestra_e);
		        	 $('#gere_e').val(data.gere_e);
		        	 $('#nuaut_e').val(data.nuaut_e);
		        	 $('#nores_f').val(data.nores_f);
		        	 $('#caanestra_f').val(data.caanestra_f);
		        	 $('#gere_f').val(data.gere_f);
		        	 $('#nuaut_f').val(data.nuaut_f);
		        	 $('#nores_g').val(data.nores_g);
		        	 $('#caanestra_g').val(data.caanestra_g);
		        	 $('#gere_g').val(data.gere_g);
		        	 $('#nuaut_g').val(data.nuaut_g);
		        	 $('#nuaut_g').val(data.nuaut_g);
		        	 $('#caanestra_h').val(data.caanestra_h);
		        	 $('#gere_h').val(data.gere_h);
		        	 $('#nuaut_h').val(data.nuaut_h);
		        	 $('#insidifiregetrter').val(data.insidifiregetrter);
		        	
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
				<h3 class="box-title">Instalación de plantas de tratamiento
					térmico de residuos.</h3>
			</div>

			<div class="box-body">

				<!-- elemntos que se cambian por tramite -->
				<input type="hidden" id="areaNumOficio" value="RME"> <input
					type="hidden" id="titleNumOficio"
					value="Tramite Instalación de plantas de tratamiento
					térmico de residuos">
				<input type="hidden" id="tipoTramiteNumOficio" value="30">
				<%@ include
					file="/WEB-INF/pages/formularios_tramites/numerOficio.jsp"%>
				<!-- terminas elementos  -->
				<form id="formulario" role="form">
					<!-- Agregar Esto -->
					<c:choose>
						<c:when test="${empty data}">
							<div class="input-group" id="dividtramite">
								<span class="input-group-addon">Trámites en Ejecución</span> <select
									class="form-control" id="idtramite" name="idtramite"></select>

							</div>
							<br>
						</c:when>
					</c:choose>
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
					<br> <input type="hidden" id="idtramite" name="idtramite"
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
								value="${data.idtramite}">
						</c:otherwise>
					</c:choose>
					<!--  -->
					<!-- Termina Agregar -->

					<div class="input-group">
						<input type="hidden" id="idtramite" name="idtramite" value="0">
						<span class="input-group-addon">Nombre de Empresa</span> <select
							id="idempresa" name="idempresa" class="form-control" required>
							<option value="">Escoja una opción</option>
							<c:forEach items="${empresas}" var="empresa">
								<option value="${empresa.idcatalogo_perfilempresa}">${empresa.nombreEmpresa}</option>
							</c:forEach>
						</select>
					</div>
					<br>

					<div class="input-group">
						<span class="input-group-addon">Establecimiento municipio</span> <select
							id="idestablecimiento" name="idestablecimiento"
							class="form-control" disabled="disabled" required>
						</select>
					</div>
					<br>
					<%@ include
						file="/WEB-INF/pages/formularios_tramites/seccionEstableci.jsp"%>
					<!--  -->
					<br>
					<div class="input-group">
						<span class="input-group-addon">Nombre del Contacto:</span> <input
							maxlength="100" type="text" id="nombreconp" name="nombreconp"
							class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">R.F.C.:</span> <input
							maxlength="100" type="text" id="rfcp" name="rfcp"
							class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Lada:</span> <input
							maxlength="100" type="text" id="ladap" name="ladap"
							class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Teléfono:</span> <input
							maxlength="100" type="text" id="telefonop" name="telefonop"
							class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Extensión:</span> <input
							maxlength="100" type="text" id="extensionp" name="extensionp"
							class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">e-mail:</span> <input
							maxlength="100" type="text" id="emailp" name="emailp"
							class="form-control">
					</div>
					<br>



					<div class="input-group">
						<span class="input-group-addon">Establecimiento municipio</span> <select
							id="idestablecimientomens" name="idestablecimientomens"
							class="form-control" disabled="disabled" required>
						</select>
					</div>
					<br>
					<%@ include
						file="/WEB-INF/pages/formularios_tramites/seccionEstableciMa.jsp"%>


					<br>
					<div class="input-group">
						<span class="input-group-addon">Nombre del Contacto:</span> <input
							maxlength="100" type="text" id="nombrecons" name="nombrecons"
							class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">R.F.C.:</span> <input
							maxlength="100" type="text" id="rfcs" name="rfcs"
							class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Lada:</span> <input
							maxlength="100" type="text" id="ladas" name="ladas"
							class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Teléfono:</span> <input
							maxlength="100" type="text" id="telefonos" name="telefonos"
							class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Extensión:</span> <input
							maxlength="100" type="text" id="extensions" name="extensions"
							class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">e-mail:</span> <input
							maxlength="100" type="text" id="emails" name="emails"
							class="form-control">
					</div>
					<br>



					<h3 class="box-title">ACTIVIDADES DE LA EMPRESA O
						NEGOCIACIÓN.:</h3>

					<div class="input-group">
						<span class="input-group-addon">Giro de la empresa o
							negociación:</span> <input type="radio" name="giro" value="I">Industrial
						&nbsp &nbsp &nbsp <input type="radio" name="giro" value="C">Comercial
						y/o Servicios &nbsp &nbsp &nbsp <input type="radio" name="giro"
							value="O">Otro
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Especificar:</span>
						<textarea id="especificar" name="especificar" class="form-control"></textarea>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Producto Final:</span>
						<textarea id="productofinal" name="productofinal"
							class="form-control"></textarea>
					</div>
					<br>

					<h3 class="box-title">Instalación de plantas de tratamiento
						térmico de residuos.:</h3>

					<div class="input-group">
						<span class="input-group-addon">Indicar el número de
							Autorización para la disposición final de resiudos de manejo
							especial:</span> <input maxlength="100" type="text"
							id="innuaudifiremaesp" name="innuaudifiremaesp"
							class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Indicar el número de
							autorización en materia de impacto ambiental (referenciar el
							número de autorización y/o oficio).:</span> <input maxlength="100"
							type="text" id="innuaumaimamb" name="innuaumaimamb"
							class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Indicar el uso de suelo
							autorizado en el predio donde se situará la planta de tratamiento
							térmico. Referenciar el número de autorización y/o oficio.:</span> <input
							maxlength="100" type="text" id="inussuauprdosipltrter"
							name="inussuauprdosipltrter" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Descripción del tipo de
							tratamiento térmico a utilizar.:</span>
						<textarea id="detitrteut" name="detitrteut" class="form-control"></textarea>
					</div>
					<br>



					<h2 class="box-title">Describir los residuos a los que se
						pretende dar tratamiento térmico.</h2>

					<br>




					<table class="table table-condensed">
						<thead>
							<tr>
								<th>Nombre del residuo</th>
								<th>Cantidad anual estimada de tratamiento (tonelada / año)</th>
								<th>Generador del residuo (procedencia)</th>
								<th>Nº de Autorización</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><input maxlength="100" type="text" class="form-control"
									id="nores_a" name="nores_a"></td>
								<td><input maxlength="100" type="text" class="form-control"
									id="caanestra_a" name="caanestra_a"></td>
								<td><input maxlength="100" type="text" class="form-control"
									id="gere_a" name="gere_a"></td>
								<td><input maxlength="100" type="text" class="form-control"
									id="nuaut_a" name="nuaut_a"></td>
							</tr>
							<tr>
								<td><input maxlength="100" type="text" class="form-control"
									id="nores_b" name="nores_b"></td>
								<td><input maxlength="100" type="text" class="form-control"
									id="caanestra_b" name="caanestra_b"></td>
								<td><input maxlength="100" type="text" class="form-control"
									id="gere_b" name="gere_b"></td>
								<td><input maxlength="100" type="text" class="form-control"
									id="nuaut_b" name="nuaut_b"></td>
							</tr>
							<tr>
								<td><input maxlength="100" type="text" class="form-control"
									id="nores_c" name="nores_c"></td>
								<td><input maxlength="100" type="text" class="form-control"
									id="caanestra_c" name="caanestra_c"></td>
								<td><input maxlength="100" type="text" class="form-control"
									id="gere_c" name="gere_c"></td>
								<td><input maxlength="100" type="text" class="form-control"
									id="nuaut_c" name="nuaut_c"></td>
							</tr>
							<tr>
								<td><input maxlength="100" type="text" class="form-control"
									id="nores_d" name="nores_d"></td>
								<td><input maxlength="100" type="text" class="form-control"
									id="caanestra_d" name="caanestra_d"></td>
								<td><input maxlength="100" type="text" class="form-control"
									id="gere_d" name="gere_d"></td>
								<td><input maxlength="100" type="text" class="form-control"
									id="nuaut_d" name="nuaut_d"></td>
							</tr>
							<tr>
								<td><input maxlength="100" type="text" class="form-control"
									id="nores_e" name="nores_e"></td>
								<td><input maxlength="100" type="text" class="form-control"
									id="caanestra_e" name="caanestra_e"></td>
								<td><input maxlength="100" type="text" class="form-control"
									id="gere_e" name="gere_e"></td>
								<td><input maxlength="100" type="text" class="form-control"
									id="nuaut_e" name="nuaut_e"></td>
							</tr>
							<tr>
								<td><input maxlength="100" type="text" class="form-control"
									id="nores_f" name="nores_f"></td>
								<td><input maxlength="100" type="text" class="form-control"
									id="caanestra_f" name="caanestra_f"></td>
								<td><input maxlength="100" type="text" class="form-control"
									id="gere_f" name="gere_f"></td>
								<td><input maxlength="100" type="text" class="form-control"
									id="nuaut_f" name="nuaut_f"></td>
							</tr>
							<tr>
								<td><input maxlength="100" type="text" class="form-control"
									id="nores_g" name="nores_g"></td>
								<td><input maxlength="100" type="text" class="form-control"
									id="caanestra_g" name="caanestra_g"></td>
								<td><input maxlength="100" type="text" class="form-control"
									id="gere_g" name="gere_g"></td>
								<td><input maxlength="100" type="text" class="form-control"
									id="nuaut_g" name="nuaut_g"></td>
							</tr>
							<tr>
								<td><input maxlength="100" type="text" class="form-control"
									id="nores_h" name="nores_h"></td>
								<td><input maxlength="100" type="text" class="form-control"
									id="caanestra_h" name="caanestra_h"></td>
								<td><input maxlength="100" type="text" class="form-control"
									id="gere_h" name="gere_h"></td>
								<td><input maxlength="100" type="text" class="form-control"
									id="nuaut_h" name="nuaut_h"></td>
							</tr>
						</tbody>
					</table>

					<br>


					<div class="input-group">
						<span class="input-group-addon">Indicar el sitio de
							disposición final de los residuos generados del tratamiento
							térmico.</span>
						<textarea id="insidifiregetrter" name="insidifiregetrter"
							class="form-control"></textarea>
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
							<input maxlength="100" id="btn_enviar" type="submit"
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