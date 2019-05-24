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
    $.getJSON('consultaPerfilEmpresa?idcatalogo_perfilempresa='+$("#idempresa").val(),function(data){
        console.log(JSON.stringify(data));
        $('#nombreRepresentante').val(data.representanteLegal);
        
    });
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
});
function llenaridestablecimiento(datos){
	  $.getJSON('getEstablecimientosByID?idestablecimiento='+datos,function(data){
	        console.log(JSON.stringify(data));
	        $('#calleEstablecimiento').val(data.calle);
	        $('#numeroExteriorEstablecimiento').val(data.numeroExterior);
	        $('#numeroInteriorEstablecimiento').val(data.numeroInterior);
	        $('#coloniaEstablecimiento').val(data.colonia);
	        $('#municipioEstablecimiento').val(data.municipio);
	        $('#estadoEstablecimiento').val(data.estado);
	        $('#latitudEstablecimiento').val(data.latitud);
	        $('#longitudEstablecimiento').val(data.longitud);
	        $('#DatosEstablecimiento').prop( "hidden", false );
	    });
}

$("#idestablecimiento").change(function() {
	llenaridestablecimiento($("#idestablecimiento").val());
});

$("#idtramite_fosaseptica").change(
		function() {
			$.getJSON(
				'consultaTramite_fosa_septica?idtramite_fosaseptica='
				+ $("#idtramite_fosaseptica").val(),
							function(beanDatos) {
								$('#idempresa > option[value="'+ beanDatos.idempresa+ '"]').attr('selected', 'selected');
								///LLenas catalogo de establecimientos
								var establecimientoASeleccionar = beanDatos.idestablecimiento;
								$.getJSON('getArrayEstablecimientosPorEmpresa?idempresa='+$("#idempresa").val(),
												function(beanDatos) {
													console.log(JSON.stringify(beanDatos));
													$("#idestablecimiento").empty();
													$.each(beanDatos,function(i,item) {
																		$("#idestablecimiento").append(
																						"<option value=\""+item.idcatalogo_perfilestablecimiento+"\">"
																								+ item.idcatalogo_perfilestablecimiento+"/"+item.colonia+"/"+item.municipio
																								+ "</option>");
													});
													$('#idestablecimiento').prop("disabled",false);
													console.log('el valor del establecimiento seleccionado deberia ser '+establecimientoASeleccionar);
													$('#idestablecimiento > option[value='+establecimientoASeleccionar+']').attr('selected', 'selected');
												});
								llenaridestablecimiento(establecimientoASeleccionar);
								$('#f_recepcion_tramite').val(beanDatos.f_recepcion_tramite);
								 $('#f_tramite_concluido').val(beanDatos.f_tramite_concluido);		
								 $('#asunto').val(beanDatos.asunto);
								$('#telefono').val(beanDatos.telefono);
								$('#calles').val(beanDatos.calles);
								$('#numero').val(beanDatos.numero);
								$('#colonia').val(beanDatos.colonia);
								$('#cp').val(beanDatos.cp);
								$('#telefonoDomicilio').val(beanDatos.telefonoDomicilio);
								$('#municipio').val(beanDatos.municipio);
								$('#actividad').val(beanDatos.actividad);
								$('#callesfosa').val(beanDatos.callesfosa);
								$('#numerofosa').val(beanDatos.numerofosa);
								$('#coloniafosa').val(beanDatos.coloniafosa);
								$('#cpfosa').val(beanDatos.cpfosa);
								$('#telefonofosa').val(beanDatos.telefonofosa);
								$('#municipiofosa').val(beanDatos.municipiofosa);
								$('#contratoagua').val(beanDatos.contratoagua);
								$('input[name="empresa_contratoagua"][value="'+beanDatos.empresa_contratoagua+'"]').prop('checked', true);
 								$('#numerodefosas').val(beanDatos.numerodefosas);
								$('input[name="tipoinstalacion1"][value="'+beanDatos.tipoinstalacion1+'"]').prop('checked', true);
								$('#capacidadm31').val(beanDatos.capacidadm31);
								$('input[name="tipoinstalacion2"][value="'+beanDatos.tipoinstalacion2+'"]').prop('checked', true);
								$('#capacidadm32').val(beanDatos.capacidadm32);
								$('#estatus').val(beanDatos.estatus);
								$("#estatus").empty();
								
								////
								 $('#UUID').val(beanDatos.uuid);
	        	 console.log(beanDatos.uuid);
	        	 var codec= beanDatos.uuid;
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
	        	 cargaTablaMovsBitacora(beanDatos.estatus);
								if ($("#rol_usuario").val() == 'ROLE_RECEP') {
									if (beanDatos.estatus == 1) {
										$("#estatus")
												.append(
														"<option value='1'>Nuevo</option>");
										$("#estatus")
												.append(
														"<option value='2'>Recibido</option>");
									} else {
										$("#estatus")
												.append(
														"<option value='1'>Nuevo</option>");
									}
								} else {
									switch (beanDatos.estatus) {
									case 2:
										$("#estatus")
												.append(
														"<option value='2'>Recibido</option>");
										$("#estatus")
												.append(
														"<option value='3'>Proceso</option>");
										$('#btn_enviar').prop(
												'disabled', false);
										break;
									case 3:
										$("#estatus")
												.append(
														"<option value='3'>Proceso</option>");
										$("#estatus")
												.append(
														"<option value='4'>Documentacion</option>");
										$("#estatus")
												.append(
														"<option value='5'>Terminado</option>");
										$('#btn_enviar').prop(
												'disabled', false);
										///mostar el numero de oficio
							        	$('#ocultarNumOficio').show(); //muestro mediante id
										break;
									case 4:
										$("#estatus")
												.append(
														"<option value='4'>Documentacion</option>");
										$('#btn_enviar').prop(
												'disabled', false);
										break;
									case 5:
										$("#estatus")
												.append(
														"<option value='5'>Terminado</option>");
										$('#btn_enviar').prop(
												'disabled', true);
										break;
									default:
										$("#estatus")
												.append(
														"<option value='1'>Nuevo..</option>");
										$('#btn_enviar').prop(
												'disabled', false);
									}
								}
							});
		});

$(document).ready(function() {
		$.validator.setDefaults({submitHandler: function() { transaccionDatosRetornoID( 'registerTramite_fosa_septica', 'formulario', true, "exito()", "fallo()");}});
		$('#formulario').validate();
		comboListaTramite();
		comboEstatus();
	});
function comboEstatus() {
$("#estatus").empty();
if ($("#rol_usuario").val() == 'ROLE_RECEP') {
	$("#estatus").append("<option value='1'>Nuevo</option>");
}else{
	$('#btn_enviar').prop(
			'disabled', true);
}
}
function comboListaTramite() {
$('#idtramite_fosaseptica').empty();
$.getJSON('listacomboTramite_fosa_septica?rol_usuario='
		+ $("#rol_usuario").val(), function(beanDatos) {
	console.log(JSON.stringify(beanDatos));
	//datos para el combo
	if ($("#rol_usuario").val() != 'ROLE_RECEP') {
		$("#idtramite_fosaseptica").append(
				"<option value=''>Escoja una opción</option>");
	} else {
		$("#idtramite_fosaseptica").append(
				"<option value='0'>Escoja una opción</option>");
	}

	$.each(beanDatos, function(i, item) {
		console.log(item.idtramite_fosaseptica);
		var estatus = '';
		switch (item.estatus) {
		case 1:
			estatus = 'Nuevo';
			break;
		case 2:
			estatus = 'Recibido';
			break;
		case 3:
			estatus = 'Proceso';
			break;
		case 4:
			estatus = 'Documentación';
			break;
		case 5:
			estatus = 'Terminado';
			break;
		default:
			estatus = 'nuevo..';
		}
		$("#idtramite_fosaseptica").append(
				"<option value=\""+item.idtramite_fosaseptica+"\">Trámite No "
						+ item.idtramite_fosaseptica
						+ " en Estatus " + estatus + "</option>");
	});

});
}	
	function exito(){
// 		mensajeriaAlertas('Exito', 'En Alta de Trámite Registro de Fosa Séptica');
		comboListaTramite();
		$('#idtramite_fosaseptica').eq(1).prop('selected', true);
		$('#idempresa').eq(0).prop(
				'selected', true);
		$("#idestablecimiento")
				.eq(0).prop('selected', true);
		$('#divCargaDetalle').hide();
		document.getElementById("idempresa").selectedIndex = 0;
		document.getElementById("idestablecimiento").selectedIndex = -1;
		document.getElementById("estatus").selectedIndex = 0;
		///mostar el numero de oficio
    	$('#ocultarNumOficio').hide(); //muestro mediante id
		$('#divCargaBitacora').hide();
		$('#divCargaBitacora').empty();
	}
	function fallo(){
		mensajeriaAlertas('Error', 'En Alta de Trámite Registro de Fosa Séptica');
		$('#idtramite_fosaseptica').eq(1).prop('selected', true);
		$('#idempresa').eq(0).prop(
				'selected', true);
		$("#idestablecimiento")
				.eq(0).prop('selected', true);
		$('#divCargaDetalle').hide();
		document.getElementById("idempresa").selectedIndex = 0;
		document.getElementById("idestablecimiento").selectedIndex = -1;
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
			$('#divCargaBitacora').load('consultaBitacoraCatReg?idregistro='+$('#idtramite_fosaseptica').val()+'&catalogoID='+$('#tramite_catalogoID').val());
		}
		
		
	}
	
	
	if($("#busquedaTramite").val() != 0){
		console.log("entro busquedaTramite");
		$.getJSON(
				'consultaTramite_fosa_septica?idtramite_fosaseptica='
				+ $("#busquedaTramite").val(),
							function(beanDatos) {
								$('#idempresa > option[value="'+ beanDatos.idempresa+ '"]').attr('selected', 'selected');
								///LLenas catalogo de establecimientos
								var establecimientoASeleccionar = beanDatos.idestablecimiento;
								$.getJSON('getArrayEstablecimientosPorEmpresa?idempresa='+$("#idempresa").val(),
												function(beanDatos) {
													console.log(JSON.stringify(beanDatos));
													$("#idestablecimiento").empty();
													$.each(beanDatos,function(i,item) {
																		$("#idestablecimiento").append(
																						"<option value=\""+item.idcatalogo_perfilestablecimiento+"\">"
																								+ item.idcatalogo_perfilestablecimiento+"/"+item.colonia+"/"+item.municipio
																								+ "</option>");
													});
													$('#idestablecimiento').prop("disabled",false);
													console.log('el valor del establecimiento seleccionado deberia ser '+establecimientoASeleccionar);
													$('#idestablecimiento > option[value='+establecimientoASeleccionar+']').attr('selected', 'selected');
												});
								$('#f_recepcion_tramite').val(beanDatos.f_recepcion_tramite);
								 $('#f_tramite_concluido').val(beanDatos.f_tramite_concluido);		
								 $('#asunto').val(beanDatos.asunto);
								$('#telefono').val(beanDatos.telefono);
								$('#calles').val(beanDatos.calles);
								$('#numero').val(beanDatos.numero);
								$('#colonia').val(beanDatos.colonia);
								$('#cp').val(beanDatos.cp);
								$('#telefonoDomicilio').val(beanDatos.telefonoDomicilio);
								$('#municipio').val(beanDatos.municipio);
								$('#actividad').val(beanDatos.actividad);
								$('#callesfosa').val(beanDatos.callesfosa);
								$('#numerofosa').val(beanDatos.numerofosa);
								$('#coloniafosa').val(beanDatos.coloniafosa);
								$('#cpfosa').val(beanDatos.cpfosa);
								$('#telefonofosa').val(beanDatos.telefonofosa);
								$('#municipiofosa').val(beanDatos.municipiofosa);
								$('#contratoagua').val(beanDatos.contratoagua);
								
								$('input[name="empresa_contratoagua"][value="'+beanDatos.empresa_contratoagua+'"]').prop('checked', true);
 								$('#numerodefosas').val(beanDatos.numerodefosas);
								$('input[name="tipoinstalacion1"][value="'+beanDatos.tipoinstalacion1+'"]').prop('checked', true);
								$('#capacidadm31').val(beanDatos.capacidadm31);
								$('input[name="tipoinstalacion2"][value="'+beanDatos.tipoinstalacion2+'"]').prop('checked', true);
								$('#capacidadm32').val(beanDatos.capacidadm32);
								$('#estatus').val(beanDatos.estatus);
								$("#estatus").empty();
								
								////
								 $('#UUID').val(beanDatos.uuid);
	        	 console.log(beanDatos.uuid);
	        	 var codec= beanDatos.uuid;
	        	 //cargar las imagenes 
	        	
	        	 $("#estatus").empty();
	        	 cargaTablaMovsBitacora(beanDatos.estatus);
								if ($("#rol_usuario").val() == 'ROLE_RECEP') {
									if (beanDatos.estatus == 1) {
										$("#estatus")
												.append(
														"<option value='1'>Nuevo</option>");
										$("#estatus")
												.append(
														"<option value='2'>Recibido</option>");
									} else {
										$("#estatus")
												.append(
														"<option value='1'>Nuevo</option>");
									}
								} else {
									switch (beanDatos.estatus) {
									case 2:
										$("#estatus")
												.append(
														"<option value='2'>Recibido</option>");
										$("#estatus")
												.append(
														"<option value='3'>Proceso</option>");
										$('#btn_enviar').prop(
												'disabled', false);
										break;
									case 3:
										$("#estatus")
												.append(
														"<option value='3'>Proceso</option>");
										$("#estatus")
												.append(
														"<option value='4'>Documentacion</option>");
										$("#estatus")
												.append(
														"<option value='5'>Terminado</option>");
										$('#btn_enviar').prop(
												'disabled', false);
										///mostar el numero de oficio
							        	$('#ocultarNumOficio').show(); //muestro mediante id
										break;
									case 4:
										$("#estatus")
												.append(
														"<option value='4'>Documentacion</option>");
										$('#btn_enviar').prop(
												'disabled', false);
										break;
									case 5:
										$("#estatus")
												.append(
														"<option value='5'>Terminado</option>");
										$('#btn_enviar').prop(
												'disabled', true);
										break;
									default:
										$("#estatus")
												.append(
														"<option value='1'>Nuevo..</option>");
										$('#btn_enviar').prop(
												'disabled', false);
									}
								}
			    });
	}
</script>

<div class="row">
	<div class="col-lg-12">
		<div class="box box-success">
			<div class="box-header with-border">
				<h3 class="box-title">Trámite Registro de Fosa Séptica</h3>
			</div>

			<div class="box-body">
				<!-- elemntos que se cambian por tramite -->
				<input type="hidden" id="areaNumOficio" value="CD"> <input
					type="hidden" id="titleNumOficio"
					value="Trámite Registro de Fosa Séptica"> <input
					type="hidden" id="tipoTramiteNumOficio" value="18">
				<%@ include
					file="/WEB-INF/pages/formularios_tramites/numerOficio.jsp"%>
				<!-- terminas elementos  -->
				<form id="formulario" role="form">
					<c:choose>
						<c:when test="${empty data}">
							<div class="input-group" id="dividtramite">
								<span class="input-group-addon">Trámites en Ejecución</span> <select
									class="form-control" id="idtramite_fosaseptica"
									name="idtramite_fosaseptica"></select>
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
					<br>
					<div class="input-group">
						<span class="input-group-addon">Nombre de Empresa</span> <select
							id="idempresa" name="idempresa" class="form-control" required>
							<option value="">Escoja una opción</option>
							<c:forEach items="${empresas}" var="empresa">
								<option value="${empresa.idcatalogo_perfilempresa}">${empresa.nombreEmpresa}</option>
							</c:forEach>
						</select>
					</div>
					<!-- UUID clave archivos -->
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
								value="${data.idtramite_fosaseptica}">
						</c:otherwise>
					</c:choose>
					<!--  -->
					<br>
					<div class="input-group">
						<span class="input-group-addon">Establecimiento</span> <select
							id="idestablecimiento" name="idestablecimiento"
							class="form-control" disabled="disabled" required>
						</select>
					</div>
					<br>
					<c:choose>
						<c:when test="${empty data}">
							<div id="DatosEstablecimiento" class="container" hidden="hidden">
								<div class="box-header with-border">
									<h3 class="box-title">Domicilio para recibir
										notificaciones</h3>
								</div>
								<div class="input-group">
									<span class="input-group-addon">Calle</span> <input
										maxlength="100" type="text" id="calleEstablecimiento"
										name="calles" class="form-control" readonly>
								</div>
								<br>
								<div class="input-group">
									<span class="input-group-addon">Número Exterior</span> <input
										maxlength="100" type="text" id="numeroExteriorEstablecimiento"
										name="numero" class="form-control" readonly>
								</div>
								<br>
								<div class="input-group">
									<span class="input-group-addon">Número Interior</span> <input
										maxlength="100" type="text" id="numeroInteriorEstablecimiento"
										class="form-control" readonly>
								</div>
								<br>
								<div class="input-group">
									<span class="input-group-addon">Colonia</span> <input
										maxlength="100" type="text" id="coloniaEstablecimiento"
										name="colonia" class="form-control" readonly>
								</div>
								<br>
								<div class="input-group">
									<span class="input-group-addon">Municipio</span> <input
										maxlength="100" type="text" id="municipioEstablecimiento"
										name="municipio" class="form-control" readonly>
								</div>
								<br>
								<div class="input-group">
									<span class="input-group-addon">Estado</span> <input
										maxlength="100" type="text" id="estadoEstablecimiento"
										class="form-control" readonly>
								</div>
								<br>
								<div class="input-group">
									<span class="input-group-addon">Código Postal</span> <input
										maxlength="100" type="text" id="cp" name="cp"
										class="form-control">
								</div>
								<br>
								<div class="input-group">
									<span class="input-group-addon">Latitud</span> <input
										maxlength="100" type="text" id="latitudEstablecimiento"
										class="form-control" readonly>
								</div>
								<br>
								<div class="input-group">
									<span class="input-group-addon">Longitud</span> <input
										maxlength="100" type="text" id="longitudEstablecimiento"
										class="form-control" readonly>
								</div>
								<br>
								<div class="input-group">
									<span class="input-group-addon">Teléfono </span> <input
										maxlength="100" type="text" id="telefonoDomicilio"
										name="telefonoDomicilio" class="form-control">
								</div>
								<br>
							</div>
							<div class="box-header with-border">
								<h3 class="box-title">Actividad</h3>
							</div>
							<div class="input-group">
								<span class="input-group-addon">Actividad</span><input
									maxlength="100" type="text" id="actividad" name="actividad"
									class="form-control">
							</div>
							<br>
							<div class="box-header with-border">
								<h3 class="box-title">Domicilio de la empresa o razón
									social donde se ubica la fosa</h3>
							</div>
							<div class="input-group">
								<span class="input-group-addon">Calles</span> <input
									maxlength="100" type="text" id="callesfosa" name="callesfosa"
									class="form-control">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Número</span> <input
									maxlength="100" type="text" id="numerofosa" name="numerofosa"
									class="form-control">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Colonia</span> <input
									maxlength="100" type="text" id="coloniafosa" name="coloniafosa"
									class="form-control">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Codigo Postal</span> <input
									maxlength="100" type="text" id="cpfosa" name="cpfosa"
									class="form-control">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Teléfono</span> <input
									maxlength="100" type="text" id="telefonofosa"
									name="telefonofosa" class="form-control">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Municipio</span> <input
									maxlength="100" type="text" id="municipiofosa"
									name="municipiofosa" class="form-control">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Contrato conagua</span> <input
									maxlength="100" type="text" id="contratoagua"
									name="contratoagua" class="form-control">
							</div>
							<br>
							<div class="box-header with-border">
								<h3 class="box-title">Suministro de Agua</h3>
							</div>
							<div class="input-group">
								<span class="input-group-addon">Empresa con la que tiene
									o tendrá contrato de suministro de agua.</span> <input type="radio"
									name="empresa_contratoagua" value="SADM"> S.A.D.M.
								&nbsp <input type="radio" name="empresa_contratoagua"
									value="CNA"> C.N.A. &nbsp <input type="radio"
									name="empresa_contratoagua" value="PTAR"> P.T.A.R.&nbsp
							</div>
							<br>
							<div class="box-header with-border">
								<h3 class="box-title">Descarga de Agua</h3>
							</div>
							<div class="input-group">
								<span class="input-group-addon">Indica el número de Fosas
									con las que cuenta:</span> <input maxlength="100" type="text"
									id="numerodefosas" name="numerodefosas" class="form-control">
							</div>
							<br>
							<div class="box-header with-border">
								<h3 class="box-title">Fosa 1</h3>
							</div>
							<div class="input-group">
								<span class="input-group-addon">Tipo de Instalación:</span> <input
									type="radio" name="tipoinstalacion1" value="SADM">Séptica
								de infiltración &nbsp <input type="radio"
									name="tipoinstalacion1" value="CNA">Séptica impermeable
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Capacidad M3:</span> <input
									maxlength="100" type="text" id="capacidadm31"
									name="capacidadm31" class="form-control">
							</div>
							<br>
							<h3 class="box-title">Fosa 2</h3>
							<div class="input-group">
								<span class="input-group-addon">Tipo de Instalación:</span> <input
									type="radio" name="tipoinstalacion2" value="SADM">Séptica
								de infiltración &nbsp <input type="radio"
									name="tipoinstalacion2" value="CNA">Séptica impermeable
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Capacidad M3:</span> <input
									maxlength="100" type="text" id="capacidadm32"
									name="capacidadm32" class="form-control"
									value="${ data.capacidadm32 }">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon"></span> <select id="estatus"
									name="estatus" class="form-control"></select>
							</div>
						</c:when>
						<c:otherwise>
							<div id="DatosEstablecimiento" class="container" hidden="hidden">
								<div class="box-header with-border">
									<h3 class="box-title">Domicilio para recibir
										notificaciones</h3>
								</div>
								<div class="input-group">
									<span class="input-group-addon">Calle</span> <input
										maxlength="100" type="text" id="calles" name="calles"
										class="form-control" readonly>
								</div>
								<br>
								<div class="input-group">
									<span class="input-group-addon">Número Exterior</span> <input
										maxlength="100" type="text" id="numero" name="numero"
										class="form-control" readonly>
								</div>
								<br>
								<div class="input-group">
									<span class="input-group-addon">Número Interior</span> <input
										maxlength="100" type="text" id="numeroInterior"
										class="form-control" readonly>
								</div>
								<br>
								<div class="input-group">
									<span class="input-group-addon">Colonia</span> <input
										maxlength="100" type="text" id="colonia" name="colonia"
										class="form-control" readonly>
								</div>
								<br>
								<div class="input-group">
									<span class="input-group-addon">Municipio</span> <input
										maxlength="100" type="text" id="municipio" name="municipio"
										class="form-control" readonly>
								</div>
								<br>
								<div class="input-group">
									<span class="input-group-addon">Estado</span> <input
										maxlength="100" type="text" id="estado" class="form-control"
										readonly>
								</div>
								<br>
								<div class="input-group">
									<span class="input-group-addon">Código Postal</span> <input
										maxlength="100" type="text" id="cp" name="cp"
										class="form-control" value="${ data.cp }">
								</div>
								<br>
								<div class="input-group">
									<span class="input-group-addon">Latitud</span> <input
										maxlength="100" type="text" id="latitud" class="form-control"
										readonly>
								</div>
								<br>
								<div class="input-group">
									<span class="input-group-addon">Longitud</span> <input
										maxlength="100" type="text" id="longitud" class="form-control"
										readonly>
								</div>
								<br>
								<div class="input-group">
									<span class="input-group-addon">Teléfono </span> <input
										maxlength="100" type="text" id="telefonoDomicilio"
										name="telefonoDomicilio" class="form-control"
										value="${ data.telefonoDomicilio }">
								</div>
								<br>
							</div>
							<div class="box-header with-border">
								<h3 class="box-title">Actividad</h3>
							</div>
							<div class="input-group">
								<span class="input-group-addon">Actividad</span><input
									maxlength="100" type="text" id="actividad" name="actividad"
									class="form-control" value="${ data.actividad }">
							</div>
							<br>
							<div class="box-header with-border">
								<h3 class="box-title">Domicilio de la empresa o razón
									social donde se ubica la fosa</h3>
							</div>
							<div class="input-group">
								<span class="input-group-addon">Calles</span> <input
									maxlength="100" type="text" id="callesfosa" name="callesfosa"
									class="form-control" value="${ data.callesfosa }">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Número</span> <input
									maxlength="100" type="text" id="numerofosa" name="numerofosa"
									class="form-control" value="${ data.numerofosa }">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Colonia</span> <input
									maxlength="100" type="text" id="coloniafosa" name="coloniafosa"
									class="form-control" value="${ data.coloniafosa }">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Codigo Postal</span> <input
									maxlength="100" type="text" id="cpfosa" name="cpfosa"
									class="form-control" value="${ data.cpfosa }">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Teléfono</span> <input
									maxlength="100" type="text" id="telefonofosa"
									name="telefonofosa" class="form-control"
									value="${ data.telefonofosa }">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Municipio</span> <input
									maxlength="100" type="text" id="municipiofosa"
									name="municipiofosa" class="form-control"
									value="${ data.municipiofosa }">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Contrato conagua</span> <input
									maxlength="100" type="text" id="contratoagua"
									name="contratoagua" class="form-control"
									value="${ data.contratoagua }">
							</div>
							<br>
							<div class="box-header with-border">
								<h3 class="box-title">Suministro de Agua</h3>
							</div>
							<div class="input-group">
								<span class="input-group-addon">Empresa con la que tiene
									o tendrá contrato de suministro de agua.</span>
								<c:choose>
									<c:when test="${data.empresa_contratoagua == 'SADM' }">
										<input type="radio" name="empresa_contratoagua" value="SADM"
											checked>S.A.D.M. &nbsp
										<input type="radio" name="empresa_contratoagua" value="CNA">C.N.A. &nbsp
										<input type="radio" name="empresa_contratoagua" value="PTAR">P.T.A.R.
                    				</c:when>
									<c:when test="${data.empresa_contratoagua == 'CNA' }">
										<input type="radio" name="empresa_contratoagua" value="SADM">S.A.D.M. &nbsp
										<input type="radio" name="empresa_contratoagua" value="CNA"
											checked>C.N.A. &nbsp
										<input type="radio" name="empresa_contratoagua" value="PTAR">P.T.A.R.
                    				</c:when>
									<c:when test="${data.empresa_contratoagua == 'SADM' }">
										<input type="radio" name="empresa_contratoagua" value="SADM">S.A.D.M. &nbsp
										<input type="radio" name="empresa_contratoagua" value="CNA">C.N.A. &nbsp
										<input type="radio" name="empresa_contratoagua" value="PTAR"
											checked>P.T.A.R.
                    				</c:when>
								</c:choose>
							</div>
							<br>
							<div class="box-header with-border">
								<h3 class="box-title">Descarga de Agua</h3>
							</div>
							<div class="input-group">
								<span class="input-group-addon">Indica el número de Fosas
									con las que cuenta:</span> <input maxlength="100" type="text"
									id="numerodefosas" name="numerodefosas"
									value="${data.numerodefosas}" class="form-control">
							</div>
							<br>
							<h3 class="box-title">Fosa 1</h3>
							<div class="input-group">
								<span class="input-group-addon">Tipo de Instalación:</span>
								<c:choose>
									<c:when test="${data.tipoinstalacion1 == 'SADM'}">
										<input type="radio" name="tipoinstalacion1" value="SADM"
											checked>Séptica de infiltración &nbsp
										<input type="radio" name="tipoinstalacion1" value="CNA">Séptica impermeable
                    				</c:when>
									<c:otherwise>
										<input type="radio" name="tipoinstalacion1" value="SADM">Séptica de infiltración &nbsp
										<input type="radio" name="tipoinstalacion1" value="CNA"
											checked>Séptica impermeable
                    				</c:otherwise>
								</c:choose>

							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Capacidad M3:</span> <input
									maxlength="100" type="text" id="capacidadm31"
									name="capacidadm31" value="${data.capacidadm31 }"
									class="form-control">
							</div>
							<br>
							<h3 class="box-title">Fosa 2</h3>
							<div class="input-group">
								<span class="input-group-addon">Tipo de Instalación:</span>
								<c:choose>
									<c:when test="${data.tipoinstalacion1 == 'SADM'}">
										<input type="radio" name="tipoinstalacion2" value="SADM"
											checked>Séptica de infiltración &nbsp
										<input type="radio" name="tipoinstalacion2" value="CNA">Séptica impermeable
                    				</c:when>
									<c:otherwise>
										<input type="radio" name="tipoinstalacion2" value="SADM">Séptica de infiltración &nbsp
										<input type="radio" name="tipoinstalacion2" value="CNA"
											checked>Séptica impermeable
                    				</c:otherwise>
								</c:choose>
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Capacidad M3:</span> <input
									maxlength="100" type="text" id="capacidadm32"
									name="capacidadm32" value="${data.capacidadm32 }"
									class="form-control">
							</div>
							<br>

						</c:otherwise>
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