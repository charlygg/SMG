<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

<script type="text/javascript">
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
	    $.getJSON('consultaTramite_UbiOperMaIntSitDisFiProEstTransf?idtramite='+$("#idtramite").val(),function(data){
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
	        	 $('#asunto').val(data.asunto);
	        	 $('#UUID').val(data.uuid);
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
	        	 /////
	        	 $('#nuexcat').val(data.nuexcat);
	        	 $('#sutoter').val(data.sutoter);
	        	 $('#suuteslar').val(data.suuteslar);
	        	 $('#suutesanc').val(data.suutesanc);
	        	 $('#suutespro').val(data.suutespro);
	        	 $('#colnorte').val(data.colnorte);
	        	 $('#colsur').val(data.colsur);
	        	 $('#coleste').val(data.coleste);
	        	 $('#coloeste').val(data.coloeste);
	        	 $('#depropestra').val(data.depropestra);
	        	 $('#tireqnseadestra').val(data.tireqnseadestra);
	        	 $('#mudoprser').val(data.mudoprser);
	        	 $('#tivepuinestra').val(data.tivepuinestra);
	        	 $('#maequtopestra').val(data.maequtopestra);
	        	 $('#nuofmia').val(data.nuofmia);
	        	 
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
			$.getJSON('listacomboTramite_UbiOperMaIntSitDisFiProEstTransf?rol_usuario='+$("#rol_usuario").val(),function(data){
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
		$.validator.setDefaults({submitHandler: function() { transaccionDatosRetornoID( 'registerTramite_UbiOperMaIntSitDisFiProEstTransf', 'formulario', true, "exito()", "fallo()");}});
		$('#formulario').validate();
		comboListaTramite();
		comboEstatus();
});
	
	function exito(){
// 		mensajeriaAlertas('Exito', 'En Alta de Tramite Instalación de plantas de tratamiento térmico de residuos.')
		$('#input-500').fileinput('reset');
		$('#input-700').fileinput('reset');
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
		mensajeriaAlertas('Error', 'Ubicación, operación y manejo integral de sitios de disposición final de residuos provenientes de las estaciones de transferencia.');
		$('#input-500').fileinput('reset');
		$('#input-700').fileinput('reset');
		document.getElementById("idempresa").selectedIndex = 0;
		document.getElementById("idestablecimiento").selectedIndex = -1;
		document.getElementById("idestablecimientomens").selectedIndex = -1;
		document.getElementById("estatus").selectedIndex = 0;
		$('#divCargaBitacora').hide();
		$('#divCargaBitacora').empty();
	}
	
	if($("#busquedaTramite").val() != 0){
		  $.getJSON('consultaTramite_UbiOperMaIntSitDisFiProEstTransf?idtramite='+$("#busquedaTramite").val(),function(data){
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
		        		 llenarcatalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento
		        		 llenaridestablecimientomens()
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
		        	 /////
		        	 $('#nuexcat').val(data.nuexcat);
		        	 $('#sutoter').val(data.sutoter);
		        	 $('#suuteslar').val(data.suuteslar);
		        	 $('#suutesanc').val(data.suutesanc);
		        	 $('#suutespro').val(data.suutespro);
		        	 $('#colnorte').val(data.colnorte);
		        	 $('#colsur').val(data.colsur);
		        	 $('#coleste').val(data.coleste);
		        	 $('#coloeste').val(data.coloeste);
		        	 $('#depropestra').val(data.depropestra);
		        	 $('#tireqnseadestra').val(data.tireqnseadestra);
		        	 $('#mudoprser').val(data.mudoprser);
		        	 $('#tivepuinestra').val(data.tivepuinestra);
		        	 $('#maequtopestra').val(data.maequtopestra);
		        	 $('#nuofmia').val(data.nuofmia);
		        	 
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
				<h3 class="box-title">Ubicación, operación y manejo integral de
					sitios de disposición final de residuos provenientes de las
					estaciones de transferencia.</h3>
			</div>

			<div class="box-body">
				<!-- elemntos que se cambian por tramite -->
				<input type="hidden" id="areaNumOficio" value="RME"> <input
					type="hidden" id="titleNumOficio"
					value="Tramite Ubicación, operación y manejo integral de sitios de disposición final de residuos provenientes de las estaciones de transferencia">
				<input type="hidden" id="tipoTramiteNumOficio" value="29">
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

					<h3 class="box-title">Ubicación, operación y manejo integral
						de sitios de disposición final de residuos provenientes de las
						estaciones de transferencia.(Anexo III):</h3>

					<br>

					<h2 class="box-title">Información general del terreno de la
						estación de transferencia:</h2>

					<br>
					<div class="input-group">
						<span class="input-group-addon">Número de expediente
							catastral:</span> <input maxlength="100" type="text" id="nuexcat"
							name="nuexcat" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Superficie total del
							terreno:</span> <input maxlength="100" type="text" id="sutoter"
							name="sutoter" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Superficie a utilizar como
							escombrera: Largo:</span> <input maxlength="100" type="text"
							id="suuteslar" name="suuteslar" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Superficie a utilizar como
							escombrera: Ancho:</span> <input maxlength="100" type="text"
							id="suutesanc" name="suutesanc" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Superficie a utilizar como
							escombrera: Profundidad:</span> <input maxlength="100" type="text"
							id="suutespro" name="suutespro" class="form-control">
					</div>
					<br>

					<h2 class="box-title">Colindancias</h2>

					<br>
					<div class="input-group">
						<span class="input-group-addon">Norte:</span> <input
							maxlength="100" type="text" id="colnorte" name="colnorte"
							class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Sur:</span> <input maxlength="100"
							type="text" id="colsur" name="colsur" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Este</span> <input maxlength="100"
							type="text" id="coleste" name="coleste" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Oeste</span> <input
							maxlength="100" type="text" id="coloeste" name="coloeste"
							class="form-control">
					</div>
					<br>


					<h2 class="box-title">Descripción del proceso de operación de
						la estación de transferencia</h2>
					<br>
					<div class="input-group">
						<span class="input-group-addon"></span>
						<textarea id="depropestra" name="depropestra" class="form-control"></textarea>
					</div>
					<br>



					<h2 class="box-title">Tipo de resiudos que no serán admitidos
						en las estaciones de transferencia</h2>
					<br>
					<div class="input-group">
						<span class="input-group-addon"></span> <input maxlength="100"
							type="text" id="tireqnseadestra" name="tireqnseadestra"
							class="form-control">
					</div>
					<br>


					<div class="input-group">
						<span class="input-group-addon">Municipios donde
							proporcionará servicio:</span> <input maxlength="100" type="text"
							id="mudoprser" name="mudoprser" class="form-control">
					</div>
					<br>


					<div class="input-group">
						<span class="input-group-addon"> Tipo de vehículos que
							pueden ingresar a la Estación de Transferencia:</span> <input
							maxlength="100" type="text" id="tivepuinestra"
							name="tivepuinestra" class="form-control">
					</div>
					<br>


					<div class="input-group">
						<span class="input-group-addon"> Maquinaria y equipo a
							utilizar en la operación de la Estación de Transferencia:</span> <input
							maxlength="100" type="text" id="maequtopestra"
							name="maequtopestra" class="form-control">
					</div>
					<br>

					<div class="input-group">
						<span class="input-group-addon">Número de Oficio de MIA:</span> <input
							maxlength="100" type="text" id="nuofmia" name="nuofmia"
							class="form-control">
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