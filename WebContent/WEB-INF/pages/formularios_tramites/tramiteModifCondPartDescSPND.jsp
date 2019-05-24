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
$("#fecha").datepicker({dateFormat: "dd/mm/yy"});

$("#idempresa").change(function() {
    $("#idestablecimiento").empty();
    $.getJSON('getArrayEstablecimientosPorEmpresa?idempresa='+$("#idempresa").val(),function(data){
        console.log(JSON.stringify(data));
        $("#idestablecimiento").append("<option value=''>Escoja una opción</option>");

        $.each(data, function(i,item){
        	 console.log(item.idcatalogo_perfilestablecimiento);
            $("#idestablecimiento").append("<option value=\""+item.idcatalogo_perfilestablecimiento+"\">"+item.idcatalogo_perfilestablecimiento+"/"+item.colonia+"/"+item.municipio+"</option>");
        });
        $('#idestablecimiento').prop( "disabled", false );
    });
});

$("#idtramite").change(
		function() {
			$.getJSON(
				'consultaTramite_modif_condif_part_desc?idtramite='
				+ $("#idtramite").val(),
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
								$('#nfolio').val(beanDatos.nfolio);
								$('#esnuevousu').val(beanDatos.esnuevousu);
								$('#regnuedesexpant').val(beanDatos.regnuedesexpant);
								$('#modexpant').val(beanDatos.modexpant);
								$('#nomrepresentante').val(beanDatos.nomrepresentante);
								$('#telefono').val(beanDatos.telefono);
								$('#calle').val(beanDatos.calle);
								$('#numero').val(beanDatos.numero);
								$('#colonia').val(beanDatos.colonia);
								$('#municipio').val(beanDatos.municipio);
								$('#telefonodes').val(beanDatos.telefonodes);
								$('#entrecalles').val(beanDatos.entrecalles);
								$('#email').val(beanDatos.email);
								$('#direcciondes').val(beanDatos.direcciondes);
								$('#actividad').val(beanDatos.actividad);
								$('#servicio').val(beanDatos.servicio);
								$('#concesion').val(beanDatos.concesion);
								$('#contrato').val(beanDatos.contrato);
								$('#sadm').val(beanDatos.sadm);
								$('#cna').val(beanDatos.cna);
								$('#condesp').val(beanDatos.condesp);
								$('#oficio').val(beanDatos.oficio);
								$('#horadescarga').val(beanDatos.horadescarga);
								$('#tipodescarga').val(beanDatos.tipodescarga);
								$('#areaproviene').val(beanDatos.areaproviene);
								$('#tipodescargasda').val(beanDatos.tipodescargasda);
								$('#horadescargasda').val(beanDatos.horadescargasda);
								$('#tipodecargatra').val(beanDatos.tipodecargatra);
								$('#horadescargatra').val(beanDatos.horadescargatra);
								$('#areaprovienetra').val(beanDatos.areaprovienetra);
								$('#tipodecargacta').val(beanDatos.tipodecargacta);
								$('#horadescargacta').val(beanDatos.horadescargacta);
								$('#areaprovienecta').val(beanDatos.areaprovienecta);
								$('#pluvialdrenaje').val(beanDatos.pluvialdrenaje);
								$('#descripciondescargas').val(beanDatos.descripciondescargas);
								$('#cambiosdescargas').val(beanDatos.cambiosdescargas);
								$('#fecha').val(beanDatos.fecha);
								$('#tipopersona').val(beanDatos.tipopersona);
								$('#identificacion').val(beanDatos.identificacion);
								$('#actaconstitutiva').val(beanDatos.actaconstitutiva);
								$('#poderrepresentante').val(beanDatos.poderrepresentante);
								$('#solicitudcopias').val(beanDatos.solicitudcopias);
								$('#registrosbanqueta').val(beanDatos.registrosbanqueta);
								$('#tipodescargaqta').val(beanDatos.tipodescargaqta);
								$('#horadescargaqta').val(beanDatos.horadescargaqta);
								$('#conagua').val(beanDatos.conagua);
								$('#tipoprocedimiento').val(beanDatos.tipoprocedimiento);
								$('#ptar').val(beanDatos.ptar);
								
								
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
									
									// se supone que no tiene porque tener estatus 1 asi que aqui se va a cargar Bitacoras
									
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
		$.validator.setDefaults({submitHandler: function() { transaccionDatosRetornoID( 'registerTramite_modif_condif_part_desc', 'formulario', true, "exito()", "fallo()");}});
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
$('#idtramite').empty();
$.getJSON('listacomboTramite_modif_condif_part_desc?rol_usuario='
		+ $("#rol_usuario").val(), function(beanDatos) {
	console.log(JSON.stringify(beanDatos));
	//datos para el combo
	if ($("#rol_usuario").val() != 'ROLE_RECEP') {
		$("#idtramite").append(
				"<option value=''>Escoja una opción</option>");
	} else {
		$("#idtramite").append(
				"<option value='0'>Escoja una opción</option>");
	}

	$.each(beanDatos, function(i, item) {
		console.log(item.idtramite);
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
		$("#idtramite").append(
				"<option value=\""+item.idtramite+"\">Trámite No "
						+ item.idtramite
						+ " en Estatus " + estatus + "</option>");
	});

});
}	
	function exito(){
// 		mensajeriaAlertas('Exito', 'En Alta de Tramite Modificación de las condiciones particulares de descarga según el parámetro y/o número de descarga');
		comboListaTramite();
		$('#idtramite').eq(1).prop('selected', true);
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
		mensajeriaAlertas('Error', 'En Trámite Modificación de las condiciones particulares de descarga según el parámetro y/o número de descarga');
		$('#idtramite').eq(1).prop('selected', true);
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
			$('#divCargaBitacora').load('consultaBitacoraCatReg?idregistro='+$('#idtramite').val()+'&catalogoID='+$('#tramite_catalogoID').val());
		}
		
		
	}

</script>

<div class="row">
	<div class="col-lg-12">
		<div class="box box-success">
			<div class="box-header with-border">
				<h3 class="box-title">Trámite Modificación de las condiciones particulares de descarga según el parámetro y/o número de descarga.</h3>
			</div>

			<div class="box-body">
				<!-- elemntos que se cambian por tramite -->
				<input type="hidden" id="areaNumOficio" value="CD"> <input
					type="hidden" id="titleNumOficio"
					value="Tramite Actualización de Situación Particular de Descarga">
				<input type="hidden" id="tipoTramiteNumOficio" value="25">
				<%@ include
					file="/WEB-INF/pages/formularios_tramites/numerOficio.jsp"%>
				<!-- terminas elementos  -->
				<form id="formulario" role="form">
					<c:choose>
						<c:when test="${empty data}">
							<div class="input-group" id="dividtramite">
								<span class="input-group-addon">Trámites en Ejecución</span> <select
									class="form-control" id="idtramite" name="idtramite"></select>
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
								<span class="input-group-addon">Fecha de recepción de
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
								<span class="input-group-addon">Fecha de trámite
									concluido</span>
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
								<span class="input-group-addon">Número de Folio</span> <input
									maxlength="100" type="text" class="form-control" id="nfolio"
									name="nfolio" required>
							</div>
							<br>
							<div class="box box-success">
								<div class="box-header with-border">
									<h2 class="box-title">Datos Generales.</h2>
								</div>
							</div>
							<div class="input-group">
								<input type="radio" name="tipoprocedimiento">Nuevo
								Usuario &nbsp; &nbsp; &nbsp; &nbsp; <input type="radio"
									name="tipoprocedimiento">Registro de Nuevas descargas a
								expediente anterior &nbsp; &nbsp; &nbsp; &nbsp; <input
									type="radio" name="tipoprocedimiento">Modificaciones a
								expediente anterior
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon"> Nombre de la empresa y/o
									Persona Física:</span> <select id="idempresa" name="idempresa"
									class="form-control" required>
									<option value="">Escoja una opción</option>
									<c:forEach items="${empresas}" var="empresa">
										<option value="${empresa.idcatalogo_perfilempresa}">${empresa.nombreEmpresa}</option>
									</c:forEach>
								</select>
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Establecimiento municipio</span>
								<select id="idestablecimiento" name="idestablecimiento"
									class="form-control" disabled="disabled" required>
								</select>
							</div>
							<br>
							<%@ include
								file="/WEB-INF/pages/formularios_tramites/seccionEstableci.jsp"%>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Nombre del propietario
									y/o representante legal</span> <input maxlength="100" type="text"
									class="form-control" id="nomrepresentante"
									name="nomrepresentante" required>
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Teléfono y/o móvil :</span> <input
									maxlength="100" type="text" class="form-control" id="telefono"
									name="telefono">
							</div>
							<br>
							<div class="box box-success">
								<div class="box-header with-border">
									<h2 class="box-title">Domicilio para oír y recibir
										notificaciones:</h2>
								</div>
							</div>
							<div class="input-group">
								<span class="input-group-addon">Calle :</span> <input
									maxlength="100" type="text" class="form-control" id="calle"
									name="calle">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Numero :</span> <input
									maxlength="100" type="text" class="form-control" id="numero"
									name="numero">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Colonia :</span> <input
									maxlength="100" type="text" class="form-control" id="colonia"
									name="colonia">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Municipio :</span> <input
									maxlength="100" type="text" class="form-control" id="municipio"
									name="municipio">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Teléfono :</span> <input
									maxlength="100" type="text" class="form-control"
									id="telefonodes" name="telefonodes">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Entre Calles:</span> <input
									maxlength="100" type="text" class="form-control"
									id="entrecalles" name="entrecalles">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Correo eléctronico :</span> <input
									maxlength="100" type="email" class="form-control" id="email"
									name="email">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Dirección de la descarga
									soló en caso de ser diferente a la anterior:</span>
								<textarea class="form-control" id="direcciondes"
									name="direcciondes"> </textarea>
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon"> Actividad que realiza:</span>
								<textarea class="form-control" id="actividad" name="actividad"> </textarea>
							</div>
							<br>
							<div class="box box-success">
								<div class="box-header with-border">
									<h2 class="box-title">Suministro de Agua</h2>
								</div>
							</div>
							<div class="input-group">
								<span class="input-group-addon">Servicios de Agua y
									Drenaje de Mty. :&nbsp; &nbsp; Contrato:</span> <input maxlength="100"
									type="text" class="form-control" id="servicio" name="servicio">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Comisión Nacional del
									Agua:&nbsp; &nbsp; N° de concesión:</span> <input maxlength="100"
									type="text" class="form-control" id="concesion"
									name="concesion">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Residual Planta:&nbsp;
									&nbsp; N° de contrato:</span> <input maxlength="100" type="text"
									class="form-control" id="contrato" name="contrato">
							</div>
							<br>
							<div class="box box-success">
								<div class="box-header with-border">
									<h2 class="box-title">Descargas de Agua</h2>
								</div>
							</div>
							<div class="input-group">
								<span class="input-group-addon">Contratos:</span> <input
									type="checkbox" id="sadm" name="sadm">Servicios de Agua
								y Drenaje de Mty. (SADM) <input type="checkbox" id="cna"
									name="cna">Comisión Nacional del Agua (CNA) <input
									type="checkbox" id="ptar" name="ptar">Planta de
								Tratamiento de Aguas Residuales (PTAR)
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Cuenta con las
									Condiciones Particulares de Descarga:</span> <input type="radio"
									name="condesp" value="si">Si <input type="radio"
									name="condesp" value="no">No
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Oficio No:</span> <input
									maxlength="100" type="text" class="form-control" id="oficio"
									name="oficio">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Tipo de Descarga:</span> <input
									type="radio" name="tipodescarga" value="s">Sanitaria <input
									type="radio" name="tipodescarga" value="i">Industrial <input
									type="radio" name="tipodescarga" value="t">Intermitente
								<input type="radio" name="tipodescarga" value="c">Continua
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">(Especificar Horario):</span> <input
									maxlength="100" type="text" class="form-control"
									id="horadescarga" name="horadescarga">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Proviene de áreas:</span>
								<textarea class="form-control" id="areaproviene"
									name="areaproviene"></textarea>
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Tipo de Descarga:</span> <input
									type="radio" name="tipodescargasda" value="s">Sanitaria
								<input type="radio" name="tipodescargasda" value="i">Industrial
								<input type="radio" name="tipodescargasda" value="t">Intermitente
								<input type="radio" name="tipodescargasda" value="c">Continua
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">(Especificar Horario):</span> <input
									maxlength="100" type="text" class="form-control"
									id="horadescargasda" name="horadescargasda">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Proviene de áreas:</span><br>
								<textarea class="form-control" id="areaprovienesda"
									name="areaprovienesda"></textarea>
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Tipo de Descarga:</span> <input
									type="radio" name="tipodecargatra" value="s">Sanitaria
								<input type="radio" name="tipodecargatra" value="i">Industrial
								<input type="radio" name="tipodecargatra" value="t">Intermitente
								<input type="radio" name="tipodecargatra" value="c">Continua
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">(Especificar Horario):</span> <input
									maxlength="100" type="text" class="form-control"
									id="horadescargatra" name="horadescargatra">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Proviene de áreas:</span>
								<textarea class="form-control" id="areaprovienetra"
									name="areaprovienetra"></textarea>
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Tipo de Descarga:</span> <input
									type="radio" name="tipodecargacta" value="s">Sanitaria
								<input type="radio" name="tipodecargacta" value="i">Industrial
								<input type="radio" name="tipodecargacta" value="t">Intermitente
								<input type="radio" name="tipodecargacta" value="c">Continua
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">(Especificar Horario):</span> <input
									maxlength="100" type="text" class="form-control"
									id="horadescargacta" name="horadescargacta">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Proviene de áreas:</span>
								<textarea class="form-control" id="areaprovienecta"
									name="areaprovienecta"></textarea>
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">¿El pluvial de la empresa
									está<br> conectado al drenaje sanitario?:
								</span> <input type="radio" name="tipodecargatra" value="si">Si
								<input type="radio" name="tipodecargatra" value="no">No
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Procesos : Describir los
									procesos que<br> generan cada una de las descargas:
								</span>
								<textarea class="form-control" id="descripciondescargas"
									name="descripciondescargas"></textarea>
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Mencione todos los
									cambios en el proceso<br> que se han implementado desde la
									fecha de su primer solicitud<br> de registro de descarga
									ante Agua y Drenaje.
								</span>
								<textarea class="form-control" id="cambiosdescargas"
									name="cambiosdescargas"></textarea>
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Fecha de Alta de
									Registro:</span> <input maxlength="100" type="text"
									class="form-control" id="fecha" name="fecha">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon"></span> <select id="estatus"
									name="estatus" class="form-control"></select>
							</div>
						</c:when>
						<c:otherwise>
							<div class="input-group">
								<span class="input-group-addon">Número de Folio</span> <input
									maxlength="100" type="text" class="form-control" id="nfolio"
									name="nfolio" required value="${ data.nfolio }">
							</div>
							<br>
							<div class="box box-success">
								<div class="box-header with-border">
									<h2 class="box-title">Datos Generales.</h2>
								</div>
							</div>
							<div class="input-group">
								<c:choose>
									<c:when test="${ data.tipoprocedimiento == 'nue' }">
										<input type="radio" name="tipoprocedimiento" value="nue"
											checked>Nuevo Usuario &nbsp; &nbsp; &nbsp; &nbsp;
									<input type="radio" name="tipoprocedimiento" value="reg">Registro de Nuevas descargas a expediente anterior &nbsp; &nbsp; &nbsp; &nbsp;
									<input type="radio" name="tipoprocedimiento" value="modi">Modificaciones a expediente anterior
	                			</c:when>
									<c:when test="${ data.tipoprocedimiento == 'reg' }">
										<input type="radio" name="tipoprocedimiento" value="nue">Nuevo Usuario &nbsp; &nbsp; &nbsp; &nbsp;
									<input type="radio" name="tipoprocedimiento" value="reg"
											checked>Registro de Nuevas descargas a expediente anterior &nbsp; &nbsp; &nbsp; &nbsp;
									<input type="radio" name="tipoprocedimiento" value="modi">Modificaciones a expediente anterior
	                			</c:when>
									<c:when test="${ data.tipoprocedimiento == 'modi' }">
										<input type="radio" name="tipoprocedimiento" value="nue">Nuevo Usuario &nbsp; &nbsp; &nbsp; &nbsp;
									<input type="radio" name="tipoprocedimiento" value="reg">Registro de Nuevas descargas a expediente anterior &nbsp; &nbsp; &nbsp; &nbsp;
									<input type="radio" name="tipoprocedimiento" value="modi"
											checked>Modificaciones a expediente anterior
	                			</c:when>
								</c:choose>

							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon"> Nombre de la empresa y/o
									Persona Física:</span> <select id="idempresa" name="idempresa"
									class="form-control" required>
									<option value="">Escoja una opción</option>
									<c:forEach items="${empresas}" var="empresa">
										<c:choose>
											<c:when
												test="${empresa.idcatalogo_perfilempresa == data.idempresa}">
												<option value="${empresa.idcatalogo_perfilempresa}" selected>${empresa.idcatalogo_perfilestablecimiento}/${empresa.colonia}/${empresa.municipio}</option>
											</c:when>
										</c:choose>

									</c:forEach>
								</select>
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Establecimiento municipio</span>
								<select id="idestablecimiento" name="idestablecimiento"
									class="form-control" disabled="disabled" required>
									<c:forEach items="${establecimientos}" var="empresa">
										<c:choose>
											<c:when
												test="${empresa.idcatalogo_perfilestablecimiento == data.idestablecimiento}">
												<option value="${empresa.idcatalogo_perfilestablecimiento}"
													selected>${empresa.idcatalogo_perfilestablecimiento}/${empresa.colonia}/${empresa.municipio}</option>
											</c:when>
										</c:choose>
									</c:forEach>
								</select>
							</div>
							<br>
							<%@ include
								file="/WEB-INF/pages/formularios_tramites/seccionEstablecimiento.jsp"%>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Nombre del propietario
									y/o representante legal</span> <input maxlength="100" type="text"
									class="form-control" id="nomrepresentante"
									name="nomrepresentante" value="${ data.nomrepresentante }"
									required>
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Teléfono y/o móvil :</span> <input
									maxlength="100" type="text" class="form-control" id="telefono"
									name="telefono" value="${ data.telefono }">
							</div>
							<br>
							<div class="box box-success">
								<div class="box-header with-border">
									<h2 class="box-title">Domicilio para oír y recibir
										notificaciones:</h2>
								</div>
							</div>
							<div class="input-group">
								<span class="input-group-addon">Calle :</span> <input
									maxlength="100" type="text" class="form-control" id="calle"
									name="calle" value="${ data.calle }">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Numero :</span> <input
									maxlength="100" type="text" class="form-control" id="numero"
									name="numero" value="${ data.numero }">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Colonia :</span> <input
									maxlength="100" type="text" class="form-control" id="colonia"
									name="colonia" value="${ data.colonia }">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Municipio :</span> <input
									maxlength="100" type="text" class="form-control" id="municipio"
									name="municipio" value="${ data.municipio }">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Teléfono :</span> <input
									maxlength="100" type="text" class="form-control"
									id="telefonodes" name="telefonodes"
									value="${ data.telefonodes }">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Entre Calles:</span> <input
									maxlength="100" type="text" class="form-control"
									id="entrecalles" name="entrecalles"
									value="${ data.entrecalles }">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Correo eléctronico :</span> <input
									maxlength="100" type="email" class="form-control" id="email"
									name="email" value="${ data.email }">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Dirección de la descarga
									soló en caso de ser diferente a la anterior:</span>
								<textarea class="form-control" id="direcciondes"
									name="direcciondes">${ data.direcciondes } </textarea>
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon"> Actividad que realiza:</span>
								<textarea class="form-control" id="actividad" name="actividad">${ data.actividad }</textarea>
							</div>
							<br>
							<div class="box box-success">
								<div class="box-header with-border">
									<h2 class="box-title">Suministro de Agua</h2>
								</div>
							</div>
							<div class="input-group">
								<span class="input-group-addon">Servicios de Agua y
									Drenaje de Mty. :&nbsp; &nbsp; Contrato:</span> <input maxlength="100"
									type="text" class="form-control" id="servicio" name="servicio"
									value="${ data.servicio }">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Comisión Nacional del
									Agua:&nbsp; &nbsp; N° de concesión:</span> <input maxlength="100"
									type="text" class="form-control" id="concesion"
									name="concesion" value="${ data.concesion }">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Residual Planta:&nbsp;
									&nbsp; N° de contrato:</span> <input maxlength="100" type="text"
									class="form-control" id="contrato" name="contrato"
									value="${ data.contrato }">
							</div>
							<br>
							<div class="box box-success">
								<div class="box-header with-border">
									<h2 class="box-title">Descargas de Agua</h2>
								</div>
							</div>
							<div class="input-group">
								<span class="input-group-addon">Contratos:</span>
								<c:choose>
									<c:when test="${ data.sadm == 'on' }">
										<input type="checkbox" id="sadm" name="sadm" checked>Servicios de Agua y Drenaje de Mty. (SADM)
								</c:when>
									<c:otherwise>
										<input type="checkbox" id="sadm" name="sadm">Servicios de Agua y Drenaje de Mty. (SADM)
								</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${ data.sadm == 'on' }">
										<input type="checkbox" id="cna" name="cna" checked>Comisión Nacional del Agua (CNA)
								</c:when>
									<c:otherwise>
										<input type="checkbox" id="cna" name="cna">Comisión Nacional del Agua (CNA)
								</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${ data.sadm == 'on' }">
										<input type="checkbox" id="ptar" name="ptar" checked>Planta de Tratamiento de Aguas Residuales (PTAR)
								</c:when>
									<c:otherwise>
										<input type="checkbox" id="ptar" name="ptar">Planta de Tratamiento de Aguas Residuales (PTAR)
								</c:otherwise>
								</c:choose>



							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Cuenta con las
									Condiciones Particulares de Descarga:</span>
								<c:choose>
									<c:when test="${ data.condesp == 'si' }">
										<input type="radio" name="condesp" value="si" checked>Si
									<input type="radio" name="condesp" value="no">No
								</c:when>
									<c:when test="${ data.condesp == 'no'}">
										<input type="radio" name="condesp" value="si">Si
									<input type="radio" name="condesp" value="no" checked>No
								</c:when>
								</c:choose>

							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Oficio No:</span> <input
									maxlength="100" type="text" class="form-control" id="oficio"
									name="oficio" value="${ data.oficio }">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Tipo de Descarga:</span>
								<c:choose>
									<c:when test="${ data.tipodescarga == 's' }">
										<input type="radio" name="tipodescarga" value="s" checked>Sanitaria
									<input type="radio" name="tipodescarga" value="i">Industrial
									<input type="radio" name="tipodescarga" value="t">Intermitente
									<input type="radio" name="tipodescarga" value="c">Continua
								</c:when>
									<c:when test="${ data.tipodescarga == 'i' }">
										<input type="radio" name="tipodescarga" value="s">Sanitaria
									<input type="radio" name="tipodescarga" value="i" checked>Industrial
									<input type="radio" name="tipodescarga" value="t">Intermitente
									<input type="radio" name="tipodescarga" value="c">Continua
								</c:when>
									<c:when test="${ data.tipodescarga == 't' }">
										<input type="radio" name="tipodescarga" value="s">Sanitaria
									<input type="radio" name="tipodescarga" value="i">Industrial
									<input type="radio" name="tipodescarga" value="t" checked>Intermitente
									<input type="radio" name="tipodescarga" value="c">Continua
								</c:when>
									<c:when test="${ data.tipodescarga == 'c' }">
										<input type="radio" name="tipodescarga" value="s">Sanitaria
									<input type="radio" name="tipodescarga" value="i">Industrial
									<input type="radio" name="tipodescarga" value="t">Intermitente
									<input type="radio" name="tipodescarga" value="c" checked>Continua
								</c:when>

								</c:choose>
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">(Especificar Horario):</span> <input
									maxlength="100" type="text" class="form-control"
									id="horadescarga" name="horadescarga"
									value="${ data.horadescarga }">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Proviene de áreas:</span>
								<textarea class="form-control" id="areaproviene"
									name="areaproviene">${ data.areaproviene }</textarea>
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Tipo de Descarga:</span>
								<c:choose>
									<c:when test="${ data.tipodescargasda == 's' }">
										<input type="radio" name="tipodescargasda" value="s" checked>Sanitaria
									<input type="radio" name="tipodescargasda" value="i">Industrial
									<input type="radio" name="tipodescargasda" value="t">Intermitente
									<input type="radio" name="tipodescargasda" value="c">Continua
								</c:when>
									<c:when test="${ data.tipodescargasda == 'i' }">
										<input type="radio" name="tipodescargasda" value="s">Sanitaria
									<input type="radio" name="tipodescargasda" value="i" checked>Industrial
									<input type="radio" name="tipodescargasda" value="t">Intermitente
									<input type="radio" name="tipodescargasda" value="c">Continua
								</c:when>
									<c:when test="${ data.tipodescargasda == 't' }">
										<input type="radio" name="tipodescargasda" value="s">Sanitaria
									<input type="radio" name="tipodescargasda" value="i">Industrial
									<input type="radio" name="tipodescargasda" value="t" checked>Intermitente
									<input type="radio" name="tipodescargasda" value="c">Continua
								</c:when>
									<c:when test="${ data.tipodescargasda == 'c' }">
										<input type="radio" name="tipodescargasda" value="s">Sanitaria
									<input type="radio" name="tipodescargasda" value="i">Industrial
									<input type="radio" name="tipodescargasda" value="t">Intermitente
									<input type="radio" name="tipodescargasda" value="c" checked>Continua
								</c:when>

								</c:choose>
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">(Especificar Horario):</span> <input
									maxlength="100" type="text" class="form-control"
									id="horadescargasda" name="horadescargasda"
									value="${ data.horadescargasda }">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Proviene de áreas:</span><br>
								<textarea class="form-control" id="areaprovienesda"
									name="areaprovienesda">${ data.areaprovienesda }</textarea>
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Tipo de Descarga:</span>
								<c:choose>
									<c:when test="${ data.tipodecargatra =='s' }">
										<input type="radio" name="tipodecargatra" value="s" checked>Sanitaria
									<input type="radio" name="tipodecargatra" value="i">Industrial
									<input type="radio" name="tipodecargatra" value="t">Intermitente
									<input type="radio" name="tipodecargatra" value="c">Continua
								</c:when>
									<c:when test="${ data.tipodecargatra =='i' }">
										<input type="radio" name="tipodecargatra" value="s">Sanitaria
									<input type="radio" name="tipodecargatra" value="i" checked>Industrial
									<input type="radio" name="tipodecargatra" value="t">Intermitente
									<input type="radio" name="tipodecargatra" value="c">Continua
								</c:when>
									<c:when test="${ data.tipodecargatra =='t' }">
										<input type="radio" name="tipodecargatra" value="s">Sanitaria
									<input type="radio" name="tipodecargatra" value="i">Industrial
									<input type="radio" name="tipodecargatra" value="t" checked>Intermitente
									<input type="radio" name="tipodecargatra" value="c">Continua
								</c:when>
									<c:when test="${ data.tipodecargatra =='c' }">
										<input type="radio" name="tipodecargatra" value="s">Sanitaria
									<input type="radio" name="tipodecargatra" value="i">Industrial
									<input type="radio" name="tipodecargatra" value="t">Intermitente
									<input type="radio" name="tipodecargatra" value="c" checked>Continua
								</c:when>
								</c:choose>
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">(Especificar Horario):</span> <input
									maxlength="100" type="text" class="form-control"
									id="horadescargatra" name="horadescargatra"
									value="${ data.horadescargatra }">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Proviene de áreas:</span>
								<textarea class="form-control" id="areaprovienetra"
									name="areaprovienetra">${data.areaprovienetra} </textarea>
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Tipo de Descarga:</span>
								<c:choose>
									<c:when test="${ data.tipodecargacta == 's' }">
										<input type="radio" name="tipodecargacta" value="s" checked>Sanitaria
									<input type="radio" name="tipodecargacta" value="i">Industrial
									<input type="radio" name="tipodecargacta" value="t">Intermitente
									<input type="radio" name="tipodecargacta" value="c">Continua
								</c:when>
									<c:when test="${ data.tipodecargacta == 'i' }">
										<input type="radio" name="tipodecargacta" value="s">Sanitaria
									<input type="radio" name="tipodecargacta" value="i" checked>Industrial
									<input type="radio" name="tipodecargacta" value="t">Intermitente
									<input type="radio" name="tipodecargacta" value="c">Continua
								</c:when>
									<c:when test="${ data.tipodecargacta == 't' }">
										<input type="radio" name="tipodecargacta" value="s">Sanitaria
									<input type="radio" name="tipodecargacta" value="i">Industrial
									<input type="radio" name="tipodecargacta" value="t" checked>Intermitente
									<input type="radio" name="tipodecargacta" value="c">Continua
								</c:when>
									<c:when test="${ data.tipodecargacta == 'c' }">
										<input type="radio" name="tipodecargacta" value="s">Sanitaria
									<input type="radio" name="tipodecargacta" value="i">Industrial
									<input type="radio" name="tipodecargacta" value="t">Intermitente
									<input type="radio" name="tipodecargacta" value="c" checked>Continua
								</c:when>
								</c:choose>
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">(Especificar Horario):</span> <input
									maxlength="100" type="text" class="form-control"
									id="horadescargacta" name="horadescargacta"
									value="${ data.horadescargacta }">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Proviene de áreas:</span>
								<textarea class="form-control" id="areaprovienecta"
									name="areaprovienecta">${ data.areaprovienecta }</textarea>
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">¿El pluvial de la empresa
									está<br> conectado al drenaje sanitario?:
								</span>
								<c:choose>
									<c:when test="${ data.tipodecargatra == 'si' }">
										<input type="radio" name="tipodecargatra" value="si" checked>Si
									<input type="radio" name="tipodecargatra" value="no">No
								</c:when>
									<c:otherwise>
										<input type="radio" name="tipodecargatra" value="si">Si
									<input type="radio" name="tipodecargatra" value="no" checked>No
								</c:otherwise>
								</c:choose>

							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Procesos : Describir los
									procesos que<br> generan cada una de las descargas:
								</span>
								<textarea class="form-control" id="descripciondescargas"
									name="descripciondescargas">${ data.descripciondescargas }</textarea>
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Mencione todos los
									cambios en el proceso<br> que se han implementado desde la
									fecha de su primer solicitud<br> de registro de descarga
									ante Agua y Drenaje.
								</span>
								<textarea class="form-control" id="cambiosdescargas"
									name="cambiosdescargas">${ data.cambiosdescargas }</textarea>
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Fecha de Alta de
									Registro:</span> <input maxlength="100" type="text"
									class="form-control" id="fecha" name="fecha"
									value="${ data.fecha }">
							</div>
							<br>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${empty data}">
							<input type="hidden" id="UUID" name="UUID" value="${UUID}">
						</c:when>
						<c:otherwise>
							<input type="hidden" id="UUID" name="UUID" value="${data.UUID}">
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