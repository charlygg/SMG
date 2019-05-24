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
$("#fechaemision").datepicker({dateFormat: "dd/mm/yy"});

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
});

$("#idestablecimiento").change(function() {
	llenaridestablecimiento($("#idestablecimiento").val());
});

function llenaridestablecimiento(datos){
	 $.getJSON('getEstablecimientosByID?idestablecimiento='+datos,function(data){
	        console.log(JSON.stringify(data));
	        $('#calle').val(data.calle);
	        $('#numeroExterior').val(data.numeroExterior);
	        $('#numeroInterior').val(data.numeroInterior);
	        $('#colonia').val(data.colonia);
	        $('#municipio').val(data.municipio);
	        $('#estado').val(data.estado);
	        $('#latitud').val(data.latitud);
	        $('#longitud').val(data.longitud);
	        $('#DatosEstablecimiento').prop( "hidden", false );
	    });
}

$("#idtramite_informesem").change(
		function() {
			$.getJSON(
				'consultaTramite_informe_Semestral?idtramite_informesem='
				+ $("#idtramite_informesem").val(),
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
								$('#fechaemision').val(beanDatos.fechaemision);
								$('#rfc').val(beanDatos.rfc);
								llenaridestablecimiento(establecimientoASeleccionar);
								////
								 $('#UUID').val(beanDatos.uuid);
								 $('#asunto').val(beanDatos.asunto);
	        	 console.log(beanDatos.uuid);
	        	 $('#f_recepcion_tramite').val(beanDatos.f_recepcion_tramite);
				 $('#f_tramite_concluido').val(beanDatos.f_tramite_concluido);	
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
		$.validator.setDefaults({submitHandler: function() { transaccionDatosRetornoID( 'registerTramite_informe_Semestral', 'formulario', true, "exito()", "fallo()");}});
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
$('#idtramite_informesem').empty();
$.getJSON('listacomboTramite_informe_Semestral?rol_usuario='
		+ $("#rol_usuario").val(), function(beanDatos) {
	console.log(JSON.stringify(beanDatos));
	//datos para el combo
	if ($("#rol_usuario").val() != 'ROLE_RECEP') {
		$("#idtramite_informesem").append(
				"<option value=''>Escoja una opción</option>");
	} else {
		$("#idtramite_informesem").append(
				"<option value='0'>Escoja una opción</option>");
	}

	$.each(beanDatos, function(i, item) {
		console.log(item.idtramite_informesem);
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
		$("#idtramite_informesem").append(
				"<option value=\""+item.idtramite_informesem+"\">Trámite No "
						+ item.idtramite_informesem
						+ " en Estatus " + estatus + "</option>");
	});

});
}		
	function exito(){
// 		mensajeriaAlertas('Exito', 'En Alta de Tramite Informe Semestral');
		comboListaTramite();
		$('#idtramite_informesem').eq(1).prop('selected', true);
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
		mensajeriaAlertas('Error', 'En Alta de Tramite Informe Semestral');
		$('#idtramite_informesem').eq(1).prop('selected', true);
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
			$('#divCargaBitacora').load('consultaBitacoraCatReg?idregistro='+$('#idtramite_informesem').val()+'&catalogoID='+$('#tramite_catalogoID').val());
		}
		
		
	}
</script>

<div class="row">
	<div class="col-lg-12">
		<div class="box box-success">
			<div class="box-header with-border">
				<h3 class="box-title">Tramite Informe Semestral</h3>
			</div>

			<div class="box-body">
				<!-- elemntos que se cambian por tramite -->
				<input type="hidden" id="areaNumOficio" value="CD"> <input
					type="hidden" id="titleNumOficio" value="Tramite Informe Semestral">
				<input type="hidden" id="tipoTramiteNumOficio" value="20">
				<%@ include
					file="/WEB-INF/pages/formularios_tramites/numerOficio.jsp"%>
				<!-- terminas elementos  -->
				<form id="formulario" role="form">
					<c:choose>
						<c:when test="${empty data}">
							<div class="input-group" id="dividtramite">
								<span class="input-group-addon">Trámites en Ejecución</span> <select
									class="form-control" id="idtramite_informesem"
									name="idtramite_informesem"></select>
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
								<span class="input-group-addon">Fecha de tramite
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
								<span class="input-group-addon">Establecimiento</span> <select
									id="idestablecimiento" name="idestablecimiento"
									class="form-control" disabled="disabled" required>
								</select>
							</div>
							<br>
						</c:when>
						<c:otherwise>
							<div class="input-group">
								<span class="input-group-addon">Nombre de Empresa</span> <select
									id="idempresa" name="idempresa" class="form-control" required>
									<option value="">Escoja una opción</option>
									<c:forEach items="${empresas}" var="empresa">
										<c:choose>
											<c:when
												test="${empresa.idcatalogo_perfilempresa == data.idempresa}">
												<option value="${empresa.idcatalogo_perfilempresa}" selected>${empresa.nombreEmpresa}</option>
											</c:when>
										</c:choose>
									</c:forEach>
								</select>
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Establecimiento</span> <select
									id="idestablecimiento" name="idestablecimiento"
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
						</c:otherwise>
					</c:choose>


					<!-- inicia bloque oculto -->
					<div id="DatosEstablecimiento" class="container" hidden>
						<div class="col-lg-10">
							<div class="box box-success">
								<div class="box-body"></div>
								<div class="box-header with-border">
									<h3 class="box-title">Establecimiento</h3>
								</div>
								<div class="box-body">
									<div class="input-group">
										<span class="input-group-addon">Calle</span> <input
											maxlength="100" type="text" id="calle" class="form-control"
											readonly>
									</div>
									<br>
									<div class="input-group">
										<span class="input-group-addon">Número Exterior</span> <input
											maxlength="100" type="text" id="numeroExterior"
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
											maxlength="100" type="text" id="colonia" class="form-control"
											readonly>
									</div>
									<br>
									<div class="input-group">
										<span class="input-group-addon">Municipio</span> <input
											maxlength="100" type="text" id="municipio"
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
										<span class="input-group-addon">Latitud</span> <input
											maxlength="100" type="text" id="latitud" class="form-control"
											readonly>
									</div>
									<br>
									<div class="input-group">
										<span class="input-group-addon">Longitud</span> <input
											maxlength="100" type="text" id="longitud"
											class="form-control" readonly>
									</div>
									<br>
								</div>
							</div>

						</div>
					</div>
					<c:choose>
						<c:when test="${empty data}">
							<div class="input-group">
								<span class="input-group-addon">Fecha</span> <input
									maxlength="100" type="text" id="fechaemision"
									name="fechaemision" class="form-control">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">RFC</span> <input
									maxlength="100" type="text" id="rfc" name="rfc"
									class="form-control">
							</div>
							<br>

							<div class="input-group">
								<span class="input-group-addon"></span> <select id="estatus"
									name="estatus" class="form-control"></select>
							</div>
						</c:when>
						<c:otherwise>
							<div class="input-group">
								<span class="input-group-addon">Fecha</span> <input
									maxlength="100" type="text" id="fechaemision"
									name="fechaemision" class="form-control"
									value="${data.fechaemision }">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">RFC</span> <input
									maxlength="100" type="text" id="rfc" name="rfc"
									class="form-control" value="${data.rfc }">
							</div>
							<br>
							<div class="input-group">
									<div class="input-group">
										<span class="input-group-addon">Notificado 
											<i class="fa fa-fw fa-question-circle"  data-toggle="tooltip" data-placement="top" 
											title="Indica si se ocupa Notificar al usuario el tramite o no, en caso de que se ocupe, se selecciona sí y se anota la fecha en que se notificó"></i> 
										</span>
										
											<select id="notificacion" name="notificacion" class="form-control" required>
												<option value="0">No</option>
												<option value="1">Si</option>
											</select>
											
										<span class="input-group-addon">Fecha de notificacion</span>
										<input type="text" class="form-control" name="f_notificacion" id="f_notificacion" />
									</div>
							</div>

						</c:otherwise>
					</c:choose>
					<!--  -->
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