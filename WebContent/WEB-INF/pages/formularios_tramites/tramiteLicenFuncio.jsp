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
});

$("#idtramite_licencia_funcionamiento").change(function() {
    $.getJSON('consultaTramite_licencia_funcionamiento?idtramite_licencia_funcionamiento='+$("#idtramite_licencia_funcionamiento").val(),function(data){
    	$('#catalogo_perfilempresa_idcatalogo_perfilempresa > option[value="'+data.catalogo_perfilempresa_idcatalogo_perfilempresa+'"]').attr('selected', 'selected');
    	///LLenas catalogo de establecimientos
    	var establecimientoASeleccionar = data.catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento;
   		$.getJSON('getArrayEstablecimientosPorEmpresa?idempresa='+$("#catalogo_perfilempresa_idcatalogo_perfilempresa").val(),function(data){
			console.log(JSON.stringify(data));
			$("#catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento").empty();
			$.each(data, function(i,item){
   				$("#catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento").append("<option value=\""+item.idcatalogo_perfilestablecimiento+"\">"+item.idcatalogo_perfilestablecimiento+"/"+item.colonia+"/"+item.municipio+"</option>");
   			});
			 $('#catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento').prop( "disabled", false );
			 $('#catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento > option[value="'+establecimientoASeleccionar+'"]').attr('selected', 'selected');
		});
   		
   		llenarcatalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento(establecimientoASeleccionar);
		if(data.actaC=='on'){$('#actaC').prop('checked',true);}
		if(data.poderRL=='on'){$('#poderRL').prop('checked',true);}
		if(data.licenciaUS=='on'){$('#licenciaUS').prop('checked',true);}
		if(data.analisisEFF=='on'){$('#analisisEFF').prop('checked',true);}
		
		$('#f_recepcion_tramite').val(data.f_recepcion_tramite);
		 $('#f_tramite_concluido').val(data.f_tramite_concluido);			
		$('#asunto').val(data.asunto);
   		$('#observaciones').val(data.observaciones);
   		$('#personaEAA').val(data.personaEAA);
   		$('#telefonoP').val(data.telefonoP);
   		$('#emailP').val(data.emailP);
   		$('#actividadG').val(data.actividadG);
   		$('#fechaIA').val(data.fechaIA);
   		$('#registroFC').val(data.registroFC);
   		$('#numeroEA').val(data.numeroEA);
   		$('#numeroEO').val(data.numeroEO);
   		$('#numeroET').val(data.numeroET);
   		$('#tiempoOHD').val(data.tiempoOHD);
   		$('#tiempoODS').val(data.tiempoODS);
   		$('#tiempoOSA').val(data.tiempoOSA);
   		$('#coordenadasG').val(data.coordenadasG);
   		$('#colindanciasN').val(data.colindanciasN);
   		$('#coordenadasS').val(data.coordenadasS);
   		$('#coordenadasE').val(data.coordenadasE);
   		$('#coordenadasO').val(data.coordenadasO);
   		$('#areaTP').val(data.areaTP);
   		$('#areaTC').val(data.areaTC);
   		$('#materiasPEP11').val(data.materiasPEP11);
   		$('#materiasPEP12').val(data.materiasPEP12);
   		$('#materiasPEP13').val(data.materiasPEP13);
   		$('#materiasPEP14').val(data.materiasPEP14);
   		$('#materiasPEP15').val(data.materiasPEP15);
   		$('#materiasPEP16').val(data.materiasPEP16);
   		$('#materiasPEP17').val(data.materiasPEP17);
   		$('#materiasPEP21').val(data.materiasPEP21);
   		$('#materiasPEP22').val(data.materiasPEP22);
   		$('#materiasPEP23').val(data.materiasPEP23);
   		$('#materiasPEP24').val(data.materiasPEP24);
   		$('#materiasPEP25').val(data.materiasPEP25);
   		$('#materiasPEP26').val(data.materiasPEP26);
   		$('#materiasPEP27').val(data.materiasPEP27);
   		$('#materiasPEP31').val(data.materiasPEP31);
   		$('#materiasPEP32').val(data.materiasPEP32);
   		$('#materiasPEP33').val(data.materiasPEP33);
   		$('#materiasPEP34').val(data.materiasPEP34);
   		$('#materiasPEP35').val(data.materiasPEP35);
   		$('#materiasPEP36').val(data.materiasPEP36);
   		$('#materiasPEP37').val(data.materiasPEP37);
   		$('#materiasPEP41').val(data.materiasPEP41);
   		$('#materiasPEP42').val(data.materiasPEP42);
   		$('#materiasPEP43').val(data.materiasPEP43);
   		$('#materiasPEP44').val(data.materiasPEP44);
   		$('#materiasPEP45').val(data.materiasPEP45);
   		$('#materiasPEP46').val(data.materiasPEP46);
   		$('#materiasPEP47').val(data.materiasPEP47);
   		$('#productosST11').val(data.productosST11);
   		$('#productosST12').val(data.productosST12);
   		$('#productosST13').val(data.productosST13);
   		$('#productosST14').val(data.productosST14);
   		$('#productosST15').val(data.productosST15);
   		$('#productosST16').val(data.productosST16);
   		$('#productosST17').val(data.productosST17);
   		$('#productosST18').val(data.productosST18);
   		$('#productosST21').val(data.productosST21);
   		$('#productosST22').val(data.productosST22);
   		$('#productosST23').val(data.productosST23);
   		$('#productosST24').val(data.productosST24);
   		$('#productosST25').val(data.productosST25);
   		$('#productosST26').val(data.productosST26);
   		$('#productosST27').val(data.productosST27);
   		$('#productosST28').val(data.productosST28);
   		$('#productosST31').val(data.productosST31);
   		$('#productosST32').val(data.productosST32);
   		$('#productosST33').val(data.productosST33);
   		$('#productosST34').val(data.productosST34);
   		$('#productosST35').val(data.productosST35);
   		$('#productosST36').val(data.productosST36);
   		$('#productosST37').val(data.productosST37);
   		$('#productosST38').val(data.productosST38);
   		$('#equiposFGEA11').val(data.equiposFGEA11);
   		$('#equiposFGEA12').val(data.equiposFGEA12);
   		$('#equiposFGEA13').val(data.equiposFGEA13);
   		$('#equiposFGEA14').val(data.equiposFGEA14);
   		$('#equiposFGEA15').val(data.equiposFGEA15);
   		$('#equiposFGEA16').val(data.equiposFGEA16);
   		$('#equiposFGEA17').val(data.equiposFGEA17);
   		$('#equiposFGEA21').val(data.equiposFGEA21);
   		$('#equiposFGEA22').val(data.equiposFGEA22);
   		$('#equiposFGEA23').val(data.equiposFGEA23);
   		$('#equiposFGEA24').val(data.equiposFGEA24);
   		$('#equiposFGEA25').val(data.equiposFGEA25);
   		$('#equiposFGEA26').val(data.equiposFGEA26);
   		$('#equiposFGEA27').val(data.equiposFGEA27);
   		$('#equiposFGEA31').val(data.equiposFGEA31);
   		$('#equiposFGEA32').val(data.equiposFGEA32);
   		$('#equiposFGEA33').val(data.equiposFGEA33);
   		$('#equiposFGEA34').val(data.equiposFGEA34);
   		$('#equiposFGEA35').val(data.equiposFGEA35);
   		$('#equiposFGEA36').val(data.equiposFGEA36);
   		$('#equiposFGEA37').val(data.equiposFGEA37);
   		$('#equiposFGEA41').val(data.equiposFGEA41);
   		$('#equiposFGEA42').val(data.equiposFGEA42);
   		$('#equiposFGEA43').val(data.equiposFGEA43);
   		$('#equiposFGEA44').val(data.equiposFGEA44);
   		$('#equiposFGEA45').val(data.equiposFGEA45);
   		$('#equiposFGEA46').val(data.equiposFGEA46);
   		$('#equiposFGEA47').val(data.equiposFGEA47);

   		///
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


$(document).ready(function() {
		$.validator.setDefaults({submitHandler: function() { transaccionDatosRetornoID( 'registerTramite_licencia_funcionamiento', 'formulario', true, "exito()", "fallo()");}});
		$('#formulario').validate();
		comboListaTramite();
		comboEstatus();
});
function comboEstatus(){
	$("#estatus").empty();
	if($("#rol_usuario").val() == 'ROLE_RECEP'){
    	$("#estatus").append("<option value='1'>Nuevo</option>");	
    }else{
    	$('#btn_enviar').prop(
    			'disabled', true);
    }
}

function comboListaTramite(){
	$('#idtramite_licencia_funcionamiento').empty();
	$.getJSON('listacomboTramite_licencia_funcionamiento?rol_usuario='+$("#rol_usuario").val(),function(data){
        console.log(JSON.stringify(data));
        //datos para el combo
        if($("#rol_usuario").val() != 'ROLE_RECEP'){
        	$("#idtramite_licencia_funcionamiento").append("<option value=''>Escoja una opción</option>");	
        }else{
        	$("#idtramite_licencia_funcionamiento").append("<option value='0'>Escoja una opción</option>");
        }
        
        $.each(data, function(i,item){
        	 console.log(item.idtramite_licencia_funcionamiento);
        	 var estatus = ''; 
        	switch(item.estatus){
        		case 1 : estatus = 'Nuevo';break;
        		case 2 : estatus = 'Recibido';break;
        		case 3 : estatus = 'Proceso';break;
        		case 4 : estatus = 'Documentación';break;
        		case 5 : estatus = 'Terminado';break;
        		default : estatus = 'nuevo..';
        	}	 
            $("#idtramite_licencia_funcionamiento").append("<option value=\""+item.idtramite_licencia_funcionamiento+"\">Trámite No "+item.idtramite_licencia_funcionamiento+" en Estatus "+estatus+"</option>");
        });
        
    });
}

	function exito(){
// 		mensajeriaAlertas('Exito', 'En Alta de Tramite Licencia de funcionamiento');
		comboListaTramite();
		$('#idtramite_licencia_funcionamiento').eq(1).prop('selected', true);
		$('#catalogo_perfilempresa_idcatalogo_perfilempresa').eq(0).prop('selected', true);
		$("#catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento").eq(0).prop('selected', true);
		$('#divCargaDetalle').hide();
		document.getElementById("catalogo_perfilempresa_idcatalogo_perfilempresa").selectedIndex = 0;
		document.getElementById("catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento").selectedIndex = -1;
		document.getElementById("estatus").selectedIndex = 0;
		$("#input-700").fileinput("reset");
		$("#input-700").fileinput("clear");
		///mostar el numero de oficio
    	$('#ocultarNumOficio').hide(); //muestro mediante id
		$('#divCargaBitacora').hide();
		$('#divCargaBitacora').empty();

	}
	function fallo(){
		mensajeriaAlertas('Error', 'En Alta de Tramite Licencia de funcionamiento');
		$('#idtramite_licencia_funcionamiento').eq(1).prop('selected', true);
		$('#catalogo_perfilempresa_idcatalogo_perfilempresa').eq(0).prop('selected', true);
		$("#catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento").eq(0).prop('selected', true);
		$('#divCargaDetalle').hide();
		document.getElementById("catalogo_perfilempresa_idcatalogo_perfilempresa").selectedIndex = 0;
		document.getElementById("catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento").selectedIndex = -1;
		document.getElementById("estatus").selectedIndex = 0;
		$('#divCargaBitacora').hide();
		$('#divCargaBitacora').empty();
	}
	function cargaTablaMovsBitacora(estatus){
		if(estatus == 1){
			$('#divCargaBitacora').hide();
			$('#divCargaBitacora').empty();
		}else{
			$('#divCargaBitacora').show();
			$('#divCargaBitacora').load('consultaBitacoraCatReg?idregistro='+$('#idtramite_licencia_funcionamiento').val()+'&catalogoID='+$('#tramite_catalogoID').val());
		}
		
		
	}
</script>

<div class="row">
	<div class="col-lg-12">
		<div class="box box-success">
			<div class="box-header with-border">
				<h3 class="box-title">Tramite Licencia de funcionamiento.</h3>
			</div>

			<div class="box-body">
				<!-- elemntos que se cambian por tramite -->
				<input type="hidden" id="areaNumOficio" value="IV"> <input
					type="hidden" id="titleNumOficio"
					value="Tramite Licencia de funcionamiento"> <input
					type="hidden" id="tipoTramiteNumOficio" value="1">
				<%@ include
					file="/WEB-INF/pages/formularios_tramites/numerOficio.jsp"%>
				<!-- terminas elementos  -->
				<form id="formulario" role="form">
					<c:choose>
						<c:when test="${empty data}">
							<div class="input-group" id="dividtramite">
								<span class="input-group-addon">Trámites en Ejecución</span> <select
									class="form-control" id="idtramite_licencia_funcionamiento"
									name="idtramite_licencia_funcionamiento"></select>
							</div>
							<br>
						</c:when>
					</c:choose>
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
					<br>
					<div class="input-group">
						<span class="input-group-addon">Nombre de Empresa</span> <select
							id="catalogo_perfilempresa_idcatalogo_perfilempresa"
							name="catalogo_perfilempresa_idcatalogo_perfilempresa"
							class="form-control" required>
							<option value="">Escoja una opción</option>
							<c:choose>
								<c:when test="${!empty data}">
									<c:forEach items="${empresas}" var="empresa">
										<c:choose>
											<c:when
												test="${empresa.idcatalogo_perfilempresa == data.catalogo_perfilempresa_idcatalogo_perfilempresa}">
												<option value="${empresa.idcatalogo_perfilempresa}" selected>${empresa.nombreEmpresa}</option>
											</c:when>
											<c:otherwise>
												<option value="${empresa.idcatalogo_perfilempresa}">${empresa.nombreEmpresa}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<c:forEach items="${empresas}" var="empresa">
										<option value="${empresa.idcatalogo_perfilempresa}">${empresa.nombreEmpresa}</option>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</select>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Establecimiento municipio</span> <select
							id="catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento"
							name="catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento"
							class="form-control" disabled="disabled" required>
							<c:choose>
								<c:when test="${!empty data}">
									<c:forEach items="${establecimientos}" var="empresa">
										<c:choose>
											<c:when
												test="${empresa.idcatalogo_perfilestablecimiento == data.catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento}">
												<option value="${empresa.idcatalogo_perfilestablecimiento}"
													selected>${empresa.idcatalogo_perfilestablecimiento}/${empresa.colonia}/${empresa.municipio}</option>
											</c:when>
											<c:otherwise>
												<option value="${empresa.idcatalogo_perfilestablecimiento}">${empresa.idcatalogo_perfilestablecimiento}/${empresa.colonia}/${empresa.municipio}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</c:when>
							</c:choose>
						</select>
					</div>
					<br>
					<div id="divCargaDetalle">
						<%@ include
							file="/WEB-INF/pages/formularios_tramites/seccionEstablecimiento.jsp"%>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Anexos Incluidos:</span> <input
							type="checkbox" id="actaC" name="actaC">Acta Constitutiva
						<input type="checkbox" id="poderRL" name="poderRL">Poder
						del Representante Legal <input type="checkbox" id="licenciaUS"
							name="licenciaUS">Licencia de uso de suelo <input
							type="checkbox" id="analisisEFF" name="analisisEFF">Análisis
						de emisión o fuentes fijas
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Observaciones:</span>
						<textarea class="form-control" id="observaciones"
							name="observaciones"> </textarea>
					</div>
					<br>
					<div class="box-header with-border">
						<h4 class="box-title">1 DATOS GENERALES DE LA EMPRESA:</h4>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">1.5 Persona encargada del
							área ambiental y/o reponsable técnico:</span> <input maxlength="100"
							type="text" class="form-control" id="personaEAA"
							name="personaEAA">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">1.5.1 Teléfono:</span> <input
							maxlength="100" type="text" class="form-control" id="telefonoP"
							name="telefonoP">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">1.5.2 Correo Electrónico:</span> <input
							maxlength="100" type="text" class="form-control" id="emailP"
							name="emailP">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">1.6 Actividad o giro:</span> <input
							maxlength="100" type="text" class="form-control" id="actividadG"
							name="actividadG">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">1.7 Fecha de inicio de
							Actividades:</span> <input maxlength="100" type="text"
							class="form-control" id="fechaIA" name="fechaIA">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">1.8 Registro Federal de
							Causantes:</span> <input maxlength="100" type="text"
							class="form-control" id="registroFC" name="registroFC">
					</div>
					<br>

					<div class="box-header with-border">
						<h5 class="box-title">1.9 Número de empleados:</h5>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Administrativos:</span> <input
							maxlength="100" type="text" class="form-control" id="numeroEA"
							name="numeroEA">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Obreros:</span> <input
							maxlength="100" type="text" class="form-control" id="numeroEO"
							name="numeroEO">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Otros:</span> <input
							maxlength="100" type="text" class="form-control" id="numeroET"
							name="numeroET">
					</div>
					<br>
					<div class="box-header with-border">
						<h5 class="box-title">1.10 Tiempo de Operación:</h5>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Horas/Día:</span> <input
							maxlength="100" type="text" class="form-control" id="tiempoOHD"
							name="tiempoOHD">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Días/Semanas:</span> <input
							maxlength="100" type="text" class="form-control" id="tiempoODS"
							name="tiempoODS">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Semanas/Año:</span> <input
							maxlength="100" type="text" class="form-control" id="tiempoOSA"
							name="tiempoOSA">
					</div>
					<br>

					<div class="box-header with-border">
						<h4 class="box-title">2.- LOCALIZACIÓN Y UBICACIÓN:</h4>
					</div>
					<div class="input-group">
						<span class="input-group-addon">2.1 Coordenadas
							Geográficas:</span> <input maxlength="100" type="text"
							class="form-control" id="coordenadasG" name="coordenadasG">
					</div>
					<br>
					<div class="box-header with-border">
						<h5 class="box-title">2.2 Colindancias:</h5>
					</div>
					<div class="input-group">
						<span class="input-group-addon">Norte</span> <input
							maxlength="100" type="text" class="form-control"
							id="colindanciasN" name="colindanciasN">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Sur:</span> <input maxlength="100"
							type="text" class="form-control" id="coordenadasS"
							name="coordenadasS">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Este:</span> <input
							maxlength="100" type="text" class="form-control"
							id="coordenadasE" name="coordenadasE">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Oeste:</span> <input
							maxlength="100" type="text" class="form-control"
							id="coordenadasO" name="coordenadasO">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">2.3 Área Total del Predio:</span>
						<input maxlength="100" type="text" class="form-control"
							id="areaTP" name="areaTP">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Área Total de Construcción:</span>
						<input maxlength="100" type="text" class="form-control"
							id="areaTC" name="areaTC">
					</div>
					<br>
					<div class="box-header with-border">
						<h4 class="box-title">3.- MATERIAS PRIMAS EMPLEADAS EN EL
							PROCESO:</h4>
					</div>
					<div class="table-responsive">
						<table class="table table-condensed" style="width: 900px;">
							<thead>
								<tr>
									<th>Nombre comercial y químico</th>
									<th>Clave CRETI</th>
									<th>Estado Físico</th>
									<th>Consumo Mensual</th>
									<th>Proveedor</th>
									<th>Transportista</th>
									<th>Tipo de almacenamiento</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input maxlength="100" type="text"
										class="form-control" id="materiasPEP11" name="materiasPEP11"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="materiasPEP12" name="materiasPEP12"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="materiasPEP13" name="materiasPEP13"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="materiasPEP14" name="materiasPEP14"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="materiasPEP15" name="materiasPEP15"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="materiasPEP16" name="materiasPEP16"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="materiasPEP17" name="materiasPEP17"></td>
								</tr>
								<tr>
									<td><input maxlength="100" type="text"
										class="form-control" id="materiasPEP21" name="materiasPEP21"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="materiasPEP22" name="materiasPEP22"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="materiasPEP23" name="materiasPEP23"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="materiasPEP24" name="materiasPEP24"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="materiasPEP25" name="materiasPEP25"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="materiasPEP26" name="materiasPEP26"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="materiasPEP27" name="materiasPEP27"></td>
								</tr>
								<tr>
									<td><input maxlength="100" type="text"
										class="form-control" id="materiasPEP31" name="materiasPEP31"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="materiasPEP32" name="materiasPEP32"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="materiasPEP33" name="materiasPEP33"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="materiasPEP34" name="materiasPEP34"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="materiasPEP35" name="materiasPEP35"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="materiasPEP36" name="materiasPEP36"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="materiasPEP37" name="materiasPEP37"></td>
								</tr>
								<tr>
									<td><input maxlength="100" type="text"
										class="form-control" id="materiasPEP41" name="materiasPEP41"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="materiasPEP42" name="materiasPEP42"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="materiasPEP43" name="materiasPEP43"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="materiasPEP44" name="materiasPEP44"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="materiasPEP45" name="materiasPEP45"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="materiasPEP46" name="materiasPEP46"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="materiasPEP47" name="materiasPEP47"></td>
								</tr>
							</tbody>
						</table>
					</div>
					<br>
					<div class="table-responsive">
						<div class="box-header with-border">
							<h4 class="box-title">4.- PRODUCTOS Y SUBPRODUCTOS
								TERMINADOS</h4>
						</div>
						<table class="table table-condensed" style="width: 900px;">
							<thead>
								<tr>
									<th>Nombre comercial y químico</th>
									<th>Clave CRETI</th>
									<th>Estado Físico</th>
									<th>Capacidad de producción mensual</th>
									<th>Producción Mensual Real</th>
									<th>Tipo de almacenamiento</th>
									<th>Transportista</th>
									<th>Volumen anual</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input maxlength="100" type="text"
										class="form-control" id="productosST11" name="productosST11"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="productosST12" name="productosST12"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="productosST13" name="productosST13"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="productosST14" name="productosST14"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="productosST15" name="productosST15"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="productosST16" name="productosST16"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="productosST17" name="productosST17"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="productosST18" name="productosST18"></td>
								</tr>
								<tr>
									<td><input maxlength="100" type="text"
										class="form-control" id="productosST21" name="productosST21"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="productosST22" name="productosST22"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="productosST23" name="productosST23"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="productosST24" name="productosST24"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="productosST25" name="productosST25"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="productosST26" name="productosST26"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="productosST27" name="productosST27"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="productosST28" name="productosST28"></td>
								</tr>
								<tr>
									<td><input maxlength="100" type="text"
										class="form-control" id="productosST31" name="productosST31"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="productosST32" name="productosST32"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="productosST33" name="productosST33"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="productosST34" name="productosST34"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="productosST35" name="productosST35"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="productosST36" name="productosST36"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="productosST37" name="productosST37"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="productosST38" name="productosST38"></td>
								</tr>
							</tbody>
						</table>
					</div>
					<br>
					<div class="box-header with-border">
						<h4 class="box-title">7.- EQUIPOS Y FUENTES GENERADORAS DE
							EMISIONES A LA ATMOSFERA</h4>
					</div>
					<div class="table-responsive">
						<table class="table table-condensed" style="width: 900px;">
							<thead>
								<tr>
									<th>Fuente Generadora</th>
									<th>Capacidad y combustible utilizado</th>
									<th>Componentes de la emisión en %</th>
									<th>Conducidas: (diámetro y altura de la chimenea o ducto)</th>
									<th>Emisión sin control (kg/h)</th>
									<th>Emisión con control (kg/h)</th>
									<th>Método o equipo de control de emisiones indicando su
										capacidad y eficiencia</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input maxlength="100" type="text"
										class="form-control" id="equiposFGEA11" name="equiposFGEA11"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="equiposFGEA12" name="equiposFGEA12"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="equiposFGEA13" name="equiposFGEA13"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="equiposFGEA14" name="equiposFGEA14"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="equiposFGEA15" name="equiposFGEA15"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="equiposFGEA16" name="equiposFGEA16"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="equiposFGEA17" name="equiposFGEA17"></td>
								</tr>
								<tr>
									<td><input maxlength="100" type="text"
										class="form-control" id="equiposFGEA21" name="equiposFGEA21"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="equiposFGEA22" name="equiposFGEA22"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="equiposFGEA23" name="equiposFGEA23"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="equiposFGEA24" name="equiposFGEA24"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="equiposFGEA25" name="equiposFGEA25"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="equiposFGEA26" name="equiposFGEA26"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="equiposFGEA27" name="equiposFGEA27"></td>
								</tr>
								<tr>
									<td><input maxlength="100" type="text"
										class="form-control" id="equiposFGEA31" name="equiposFGEA31"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="equiposFGEA32" name="equiposFGEA32"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="equiposFGEA33" name="equiposFGEA33"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="equiposFGEA34" name="equiposFGEA34"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="equiposFGEA35" name="equiposFGEA35"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="equiposFGEA36" name="equiposFGEA36"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="equiposFGEA37" name="equiposFGEA37"></td>
								</tr>
								<tr>
									<td><input maxlength="100" type="text"
										class="form-control" id="equiposFGEA41" name="equiposFGEA41"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="equiposFGEA42" name="equiposFGEA42"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="equiposFGEA43" name="equiposFGEA43"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="equiposFGEA44" name="equiposFGEA44"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="equiposFGEA45" name="equiposFGEA45"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="equiposFGEA46" name="equiposFGEA46"></td>
									<td><input maxlength="100" type="text"
										class="form-control" id="equiposFGEA47" name="equiposFGEA47"></td>
								</tr>
							</tbody>
						</table>
					</div>
					<br>








					<!-- seccion nueva -->
					<c:choose>
						<c:when test="${empty data}">
							<input type="hidden" id="UUID" name="UUID" value="${UUID}">
						</c:when>
						<c:otherwise>
							<input type="hidden" id="UUID" name="UUID" value="${data.UUID}">
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${empty data}">
							<div class="input-group">
								<span class="input-group-addon"></span> <select id="estatus"
									name="estatus" class="form-control"></select>
							</div>
						</c:when>
					</c:choose>


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