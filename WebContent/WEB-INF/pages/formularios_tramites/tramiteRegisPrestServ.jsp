<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<script
	src="<%=request.getContextPath()%>/resources/plugins/input-mask/jquery.inputmask.js"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath()%>/resources/plugins/input-mask/jquery.inputmask.date.extensions.js"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath()%>/resources/plugins/input-mask/jquery.inputmask.extensions.js"
	type="text/javascript"></script>

<script type="text/javascript">
<!--

//-->
$('#tel').inputmask({mask: "(999) 999-9999"});  //static mask
$('#cel').inputmask({mask: "(999) 999-9999"});  //static mask
// $("#fecha_declaracion").inputmask("d/m/y",{ "placeholder": "dd/mm/yyyy" });
// $("#f_recepcion_tramite").inputmask("d/m/y",{ "placeholder": "dd/mm/yyyy" });
// $("#f_tramite_concluido").inputmask("d/m/y",{ "placeholder": "dd/mm/yyyy" });		

$("#fecha_declaracion").datepicker({dateFormat: "dd/mm/yy"});
$("#f_tramite_concluido").datepicker({dateFormat: "dd/mm/yy"});
$("#f_recepcion_tramite").datepicker({dateFormat: "dd/mm/yy"});

$("#idtramite_registro_prestador_servicio").change(
		function() {
			$.getJSON(
				'consultaTramite_registro_de_prestadores_de_servicios?idtramite_registro_prestador_servicio=' + $("#idtramite_registro_prestador_servicio").val(),
							function(beanDatos) {
					
					$('#f_recepcion_tramite').val(beanDatos.f_recepcion_tramite);
					 $('#f_tramite_concluido').val(beanDatos.f_tramite_concluido);
					 $('#asunto').val(beanDatos.asunto);
								$('#clave_registro').val(beanDatos.clave_registro);
								$('#apellido_paterno').val(beanDatos.apellido_paterno);
								$('#apellido_materno').val(beanDatos.apellido_materno);
								$('#nombre').val(beanDatos.nombre);
								$('#calle').val(beanDatos.calle);
								$('#num_exterior').val(beanDatos.num_exterior);
								$('#colonia').val(beanDatos.colonia);
								$('#num_interior').val(beanDatos.num_interior);
								$('#cp').val(beanDatos.cp);
								$('#tel').val(beanDatos.tel);
								$('#fax').val(beanDatos.fax);
								$('#cel').val(beanDatos.cel);
								$('#municipio').val(beanDatos.municipio);
								$('#correo').val(beanDatos.correo);
								if(beanDatos.actividad='f'){
									 document.getElementsByName("tipo")[0].checked = true;
								}else{
									 document.getElementsByName("tipo")[1].checked = true;
								}
// 								$('#tipo').val(beanDatos.actividad);
								$('#sexo_fisica').val(beanDatos.sexo_fisica);
								$('#nacionalidad_fisica').val(beanDatos.nacionalidad_fisica);
								$('#lugar_nacimiento_fisica').val(beanDatos.lugar_nacimiento_fisica);
								$('#pais_fisica').val(beanDatos.pais_fisica);
								$('#rfc_fisica').val(beanDatos.rfc_fisica);
								$('#curp_fisica').val(beanDatos.curp_fisica);
								$('#domicilio_fisica').val(beanDatos.domicilio_fisica);
								$('#fecha_declaracion_fisica').val(beanDatos.fecha_declaracion_fisica);
								$('#factura_fisica').val(beanDatos.factura_fisica);
								$('#academico_fisica').val(beanDatos.academico_fisica);
								$('#carrera_fisica').val(beanDatos.carrera_fisica);
								$('#periodo_fin_fisica').val(beanDatos.periodo_fin_fisica);
								$('#tesis_fisica').val(beanDatos.tesis_fisica);
								$('#curso_fisica').val(beanDatos.curso_fisica);
								$('#nivel_curso_fisica').val(beanDatos.nivel_curso_fisica);
								$('#donde_laboral_fisica').val(beanDatos.donde_laboral_fisica);
								$('#antiguedad_fisica').val(beanDatos.antiguedad_fisica);
								$('#causa_fisica').val(beanDatos.causa_fisica);
								$('#donde_laboral_fisica2').val(beanDatos.donde_laboral_fisica2);
								$('#antiguedad_fisica2').val(beanDatos.antiguedad_fisica2);
								$('#causa_fisica2').val(beanDatos.causa_fisica2);
								$('#tipo_proyecto_fisica').val(beanDatos.tipo_proyecto_fisica);
								$('#duracion_proyecto_fisica').val(beanDatos.duracion_proyecto_fisica);
								$('#ubicacion_proyecto_fisica').val(beanDatos.ubicacion_proyecto_fisica);
								$('#municipio_proyecto_fisica').val(beanDatos.municipio_proyecto_fisica);
								$('#estado_proyecto_fisca').val(beanDatos.estado_proyecto_fisca);
								$('#federacion_proyecto_fisica').val(beanDatos.federacion_proyecto_fisica);
								$('#tipo_proyecto_fisica2').val(beanDatos.tipo_proyecto_fisica2);
								$('#duracion_proyecto_fisica2').val(beanDatos.duracion_proyecto_fisica2);
								$('#ubicacion_proyecto_fisica2').val(beanDatos.ubicacion_proyecto_fisica2);
								$('#municipio_proyecto_fisica2').val(beanDatos.municipio_proyecto_fisica2);
								$('#estado_proyecto_fisca2').val(beanDatos.estado_proyecto_fisca2);
								$('#federacion_proyecto_fisica2').val(beanDatos.federacion_proyecto_fisica2);
								$('#tipo_proyecto_fisica3').val(beanDatos.tipo_proyecto_fisica3);
								$('#duracion_proyecto_fisica3').val(beanDatos.duracion_proyecto_fisica3);
								$('#ubicacion_proyecto_fisica3').val(beanDatos.ubicacion_proyecto_fisica3);
								$('#municipio_proyecto_fisica3').val(beanDatos.municipio_proyecto_fisica3);
								$('#estado_proyecto_fisca3').val(beanDatos.estado_proyecto_fisca3);
								$('#federacion_proyecto_fisica3').val(beanDatos.federacion_proyecto_fisica3);
								$('#rfc_morales').val(beanDatos.rfc_morales);
								$('#curp_morales').val(beanDatos.curp_morales);
								$('#domicilio_morales').val(beanDatos.domicilio_morales);
								$('#fecha_declaracion_morales').val(beanDatos.fecha_declaracion_morales);
								$('#factura_morales').val(beanDatos.factura_morales);
								$('#estudio_morales').val(beanDatos.estudio_morales);
								$('#nombre_estudios_morales').val(beanDatos.nombre_estudios_morales);
								$('#domicilio_estudios_morales').val(beanDatos.domicilio_estudios_morales);
								$('#fecha_estudios_morales').val(beanDatos.fecha_estudios_morales);
								$('#estudio_morales2').val(beanDatos.estudio_morales2);
								$('#nombre_estudios_morales2').val(beanDatos.nombre_estudios_morales2);
								$('#domicilio_estudios_morales2').val(beanDatos.domicilio_estudios_morales2);
								$('#fecha_estudios_morales2').val(beanDatos.fecha_estudios_morales2);
								$('#estudio_morales3').val(beanDatos.estudio_morales3);
								$('#nombre_estudios_morales3').val(beanDatos.nombre_estudios_morales3);
								$('#domicilio_estudios_morales3').val(beanDatos.domicilio_estudios_morales3);
								$('#fecha_estudios_morales3').val(beanDatos.fecha_estudios_morales3);
								$('#estudio_morales4').val(beanDatos.estudio_morales4);
								$('#nombre_estudios_morales4').val(beanDatos.nombre_estudios_morales4);
								$('#domicilio_estudios_morales4').val(beanDatos.domicilio_estudios_morales4);
								$('#fecha_estudios_morales4').val(beanDatos.fecha_estudios_morales4);
								$('#estudio_morales5').val(beanDatos.estudio_morales5);
								$('#nombre_estudios_morales5').val(beanDatos.nombre_estudios_morales5);
								$('#domicilio_estudios_morales5').val(beanDatos.domicilio_estudios_morales5);
								$('#fecha_estudios_morales5').val(beanDatos.fecha_estudios_morales5);
								$('#disponibilidad_equipo_infraestructuras').val(beanDatos.disponibilidad_equipo_infraestructuras);
								$('#cartografia').val(beanDatos.cartografia);
								$('#bibliografia').val(beanDatos.bibliografia);
								$('#curso_capacitacion').val(beanDatos.curso_capacitacion);
								$('#ingresos_mensuales').val(beanDatos.ingresos_mensuales);
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
	$.validator.setDefaults({submitHandler: function() { transaccionDatosRetornoID( 'registerTramite_registro_de_prestadores_de_servicios', 'principal', true, "exito()", "fallo()");}});
	$('#principal').validate();
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
$('#idtramite_registro_prestador_servicio').empty();
$.getJSON('listaTramite_registro_de_prestadores_de_servicios?rol_usuario='
	+ $("#rol_usuario").val(), function(beanDatos) {
console.log(JSON.stringify(beanDatos));
//datos para el combo
if ($("#rol_usuario").val() != 'ROLE_RECEP') {
	$("#idtramite_registro_prestador_servicio").append(
			"<option value=''>Escoja una opción</option>");
} else {
	$("#idtramite_registro_prestador_servicio").append(
			"<option value='0'>Escoja una opción</option>");
}

$.each(beanDatos, function(i, item) {
	console.log(item.idtramite_registro_prestador_servicio);
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
	$("#idtramite_registro_prestador_servicio").append(
			"<option value=\""+item.idtramite_registro_prestador_servicio+"\">Trámite No "
					+ item.idtramite_registro_prestador_servicio
					+ " en Estatus " + estatus + "</option>");
});

});
}	
function exito(){
// 	mensajeriaAlertas('Exito', 'En Alta de Tramite Registro de Prestadores de Servicio');
	comboListaTramite();
	$('#idtramite_registro_prestador_servicio').eq(1).prop('selected', true);
	$('#divCargaDetalle').hide();
	document.getElementById("estatus").selectedIndex = 0;
	$('#divCargaBitacora').hide();
	$('#divCargaBitacora').empty();

}
function fallo(){
	mensajeriaAlertas('Error', 'En Alta de Tramite Registro de Prestadores de Servicio');
	$('#idtramite_registro_prestador_servicio').eq(1).prop('selected', true);
	$('#divCargaDetalle').hide();
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
		$('#divCargaBitacora').load('consultaBitacoraCatReg?idregistro='+$('#idtramite_registro_prestador_servicio').val()+'&catalogoID='+$('#tramite_catalogoID').val());
	}
	
	
}

</script>
<div class="box box-success">
	<div class="box-header with-border">
		<h3 class="box-title">Tramite Registro de prestadores de
			servicios</h3>
	</div>
	<!-- /.box-header -->
	<form id="principal" role="form">
		<div class="box-body">
			<div class="input-group"
				id="dividtramite_registro_prestador_servicio">
				<span class="input-group-addon">Trámites en Ejecución</span> <select
					class="form-control" id="idtramite_registro_prestador_servicio"
					name="idtramite_registro_prestador_servicio"></select>
			</div>
			<br>
			<div class="input-group">
				<span class="input-group-addon">Asunto</span>
				<c:choose>
					<c:when test="${!empty data}">
						<textarea id="asunto" name="asunto" class="form-control" required>${data.asunto}</textarea>
					</c:when>
					<c:otherwise>
						<textarea id="asunto" name="asunto" class="form-control" required></textarea>
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
				<span class="input-group-addon">Clave de Registro</span> <input
					maxlength="100" type="text" class="form-control"
					id="clave_registro" name="clave_registro">
			</div>
			<br>
			<div class="input-group">
				<span class="input-group-addon">Apellido Paterno</span> <input
					maxlength="100" type="text" class="form-control"
					id="apellido_paterno" name="apellido_paterno">
			</div>
			<br>
			<div class="input-group">
				<span class="input-group-addon">Apellido Materno</span> <input
					maxlength="100" type="text" class="form-control"
					id="apellido_materno" name="apellido_materno">
			</div>
			<br>
			<div class="input-group">
				<span class="input-group-addon">Nombre</span> <input maxlength="100"
					type="text" class="form-control" id="nombre" name="nombre" required
					minlength="2">
			</div>
			<br>
			<div class="input-group">
				<span class="input-group-addon">Calle</span> <input maxlength="100"
					type="text" class="form-control" id="calle" name="calle">
			</div>
			<br>
			<div class="input-group">
				<span class="input-group-addon">Número Exterior</span> <input
					maxlength="100" type="text" class="form-control" id="num_exterior"
					name="num_exterior">
			</div>
			<br>
			<div class="input-group">
				<span class="input-group-addon">Colonia</span> <input
					maxlength="100" type="text" class="form-control" id="colonia"
					name="colonia" required minlength="2">
			</div>
			<br>
			<div class="input-group">
				<span class="input-group-addon">Número Interior</span> <input
					maxlength="100" type="text" class="form-control" id="num_interior"
					name="num_interior">
			</div>
			<br>
			<div class="input-group">
				<span class="input-group-addon">C.P.</span> <input maxlength="100"
					type="text" class="form-control" id="cp" name="cp">
			</div>
			<br>
			<div class="input-group">
				<span class="input-group-addon">Télefono</span> <input
					maxlength="100" type="text" class="form-control" id="tel"
					name="tel">
			</div>
			<br>
			<div class="input-group">
				<span class="input-group-addon">Fax</span> <input maxlength="100"
					type="text" class="form-control" id="fax" name="fax">
			</div>
			<br>
			<div class="input-group">
				<span class="input-group-addon">Celular</span> <input
					maxlength="100" type="text" class="form-control" id="cel"
					name="cel">
			</div>
			<br>
			<div class="input-group">
				<span class="input-group-addon">Municipio</span> <input
					maxlength="100" type="text" class="form-control" id="municipio"
					name="municipio">
			</div>
			<br>
			<div class="input-group">
				<span class="input-group-addon">Correo Electrónico</span> <input
					maxlength="100" type="email" class="form-control" id="correo"
					name="correo">
			</div>
			<br>

			<!-- inicia acordion -->
			<div class="box-group" id="accordion">
				<!-- we are adding the .panel class so bootstrap.js collapse plugin detects it -->
				<div class="panel box box-primary">
					<div class="box-header with-border">
						<h4 class="box-title">
							<a data-toggle="collapse" data-parent="#accordion"
								href="#collapseOne"> Personas Fisicas </a> <input type="radio"
								name="tipo" value="f">
						</h4>
					</div>
					<div id="collapseOne" class="panel-collapse collapse in">
						<div class="box-body">
							<div class="input-group">
								<span class="input-group-addon">Sexo</span> <input
									maxlength="100" type="text" class="form-control"
									id="sexo_fisica" name="sexo_fisica" minlength="2">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Nacionalidad</span> <input
									maxlength="100" type="text" class="form-control"
									id="nacionalidad_fisica" name="nacionalidad_fisica"
									minlength="2">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Lugar de nacimiento</span> <input
									maxlength="100" type="text" class="form-control"
									id="lugar_nacimiento_fisica" name="lugar_nacimiento_fisica"
									minlength="2">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">País</span> <input
									maxlength="100" type="text" class="form-control"
									id="pais_fisica" name="pais_fisica" minlength="2">
							</div>
							<br>
							<h4>Situación Fiscal</h4>
							<div class="input-group">
								<span class="input-group-addon">R.F.C</span> <input
									maxlength="100" type="text" class="form-control"
									id="rfc_fisica" name="rfc_fisica" minlength="2">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">C.U.R.P.</span> <input
									maxlength="100" type="text" class="form-control"
									id="curp_fisica" name="curp_fisica" minlength="2">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Domicilio Fiscal</span> <input
									maxlength="100" type="text" class="form-control"
									id="domicilio_fisica" name="domicilio_fisica" minlength="2">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Fecha de Última
									Declaración</span> <input maxlength="100" type="text"
									class="form-control" id="fecha_declaracion_fisica"
									name="fecha_declaracion_fisica" minlength="2">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Presentar Factura/Recibo
									No.</span> <input maxlength="100" type="text" class="form-control"
									id="factura_fisica" name="factura_fisica" minlength="2">
							</div>
							<br>
							<h4>Situacíon Académica</h4>
							<div class="input-group">
								<span class="input-group-addon"></span> <select
									id="academico_fisica" name="academico_fisica"
									class="form-control">
									<option value="Licenciatura">Licenciatura</option>
									<option value="Maestria">Maestria</option>
									<option value="Doctorado">Doctorado</option>
									<option value="Otro">Otro</option>
								</select>
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Nombre de la Carrera o de
									los Estudios</span> <input maxlength="100" type="text"
									class="form-control" id="carrera_fisica" name="carrera_fisica"
									minlength="2">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Periodo de los Estudios</span> <input
									maxlength="100" type="text" class="form-control"
									id="periodo_in_fisica" name="periodo_in_fisica"> <input
									maxlength="100" type="text" class="form-control"
									id="periodo_fin_fisica" name="periodo_fin_fisica">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Título de Tesis</span> <input
									maxlength="100" type="text" class="form-control"
									id="tesis_fisica" name="tesis_fisica" minlength="2">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Cursa Estudios
									Actualmente</span> <select id="curso_fisica" name="curso_fisica"
									class="form-control">
									<option value="si">Si</option>
									<option value="no">No</option>

								</select>
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">En caso afirmativo
									indique el nivel y el nombre del curso</span> <input maxlength="100"
									type="text" class="form-control" id="nivel_curso_fisica"
									name="nivel_curso_fisica" minlength="2">
							</div>
							<br>
							<h4>Antecedentes de los últimos dos empleos</h4>
							<div class="box box-success">
								<div class="box-header with-border"></div>

								<div class="box-body">
									<div class="input-group">
										<span class="input-group-addon">Donde Laboró</span> <input
											maxlength="100" type="text" class="form-control"
											id="donde_laboral_fisica" name="donde_laboral_fisica"
											minlength="2">
									</div>
									<br>
									<div class="input-group">
										<span class="input-group-addon">Antigüedad</span> <input
											maxlength="100" type="text" class="form-control"
											id="antiguedad_fisica" name="antiguedad_fisica" minlength="2">
									</div>
									<br>
									<div class="input-group">
										<span class="input-group-addon">Causa de Separacion del
											empleo</span> <input maxlength="100" type="text"
											class="form-control" id="causa_fisica" name="causa_fisica"
											minlength="2">
									</div>
									<br>
								</div>
								<!-- /.box-body -->

							</div>
							<!-- /.box -->
							<div class="box box-success">
								<div class="box-header with-border"></div>

								<div class="box-body">
									<div class="input-group">
										<span class="input-group-addon">Donde Laboró</span> <input
											maxlength="100" type="text" class="form-control"
											id="donde_laboral_fisica2" name="donde_laboral_fisica2"
											minlength="2">
									</div>
									<br>
									<div class="input-group">
										<span class="input-group-addon">Antigüedad</span> <input
											maxlength="100" type="text" class="form-control"
											id="antiguedad_fisica2" name="antiguedad_fisica2"
											minlength="2">
									</div>
									<br>
									<div class="input-group">
										<span class="input-group-addon">Causa de Separacion del
											empleo</span> <input maxlength="100" type="text"
											class="form-control" id="causa_fisica2" name="causa_fisica2"
											minlength="2">
									</div>
									<br>
								</div>
								<!-- /.box-body -->

							</div>
							<!-- /.box -->
							<h4>Experiencia como prestador de servicio</h4>
							<div class="box box-success">
								<div class="box-header with-border"></div>

								<div class="box-body">
									<div class="input-group">
										<span class="input-group-addon">Tipo de Proyecto</span> <input
											maxlength="100" type="text" class="form-control"
											id="tipo_proyecto_fisica" name="tipo_proyecto_fisica"
											minlength="2">
									</div>
									<br>
									<div class="input-group">
										<span class="input-group-addon">Duración</span> <input
											maxlength="100" type="text" class="form-control"
											id="duracion_proyecto_fisica" name="duracion_proyecto_fisica"
											minlength="2">
									</div>
									<br>
									<div class="input-group">
										<span class="input-group-addon">Ubicación</span> <input
											maxlength="100" type="text" class="form-control"
											id="ubicacion_proyecto_fisica"
											name="ubicacion_proyecto_fisica" minlength="2">
									</div>
									<br>
									<div class="input-group">
										<span class="input-group-addon">Municipio</span> <input
											maxlength="100" type="text" class="form-control"
											id="municipio_proyecto_fisica"
											name="municipio_proyecto_fisica" minlength="2">
									</div>
									<br>
									<div class="input-group">
										<span class="input-group-addon">Estado</span> <input
											maxlength="100" type="text" class="form-control"
											id="estado_proyecto_fisca" name="estado_proyecto_fisca"
											minlength="2">
									</div>
									<br>
									<div class="input-group">
										<span class="input-group-addon">Federación</span> <input
											maxlength="100" type="text" class="form-control"
											id="federacion_proyecto_fisica"
											name="federacion_proyecto_fisica" minlength="2">
									</div>
									<br>
								</div>
								<!-- /.box-body -->

							</div>
							<!-- /.box -->
							<!-- experincia 2 -->
							<div class="box box-success">
								<div class="box-header with-border"></div>

								<div class="box-body">
									<div class="input-group">
										<span class="input-group-addon">Tipo de Proyecto</span> <input
											maxlength="100" type="text" class="form-control"
											id="tipo_proyecto_fisica2" name="tipo_proyecto_fisica2"
											minlength="2">
									</div>
									<br>
									<div class="input-group">
										<span class="input-group-addon">Duración</span> <input
											maxlength="100" type="text" class="form-control"
											id="duracion_proyecto_fisica2"
											name="duracion_proyecto_fisica2" minlength="2">
									</div>
									<br>
									<div class="input-group">
										<span class="input-group-addon">Ubicación</span> <input
											maxlength="100" type="text" class="form-control"
											id="ubicacion_proyecto_fisica2"
											name="ubicacion_proyecto_fisica2" minlength="2">
									</div>
									<br>
									<div class="input-group">
										<span class="input-group-addon">Municipio</span> <input
											maxlength="100" type="text" class="form-control"
											id="municipio_proyecto_fisica2"
											name="municipio_proyecto_fisica2" minlength="2">
									</div>
									<br>
									<div class="input-group">
										<span class="input-group-addon">Estado</span> <input
											maxlength="100" type="text" class="form-control"
											id="estado_proyecto_fisca2" name="estado_proyecto_fisca2"
											minlength="2">
									</div>
									<br>
									<div class="input-group">
										<span class="input-group-addon">Federación</span> <input
											maxlength="100" type="text" class="form-control"
											id="federacion_proyecto_fisica2"
											name="federacion_proyecto_fisica2" minlength="2">
									</div>
									<br>
								</div>
								<!-- /.box-body -->

							</div>
							<!-- /.box -->
							<!-- termina experiencia 2 -->
							<!-- Experiencia 3 -->
							<div class="box box-success">
								<div class="box-header with-border"></div>

								<div class="box-body">
									<div class="input-group">
										<div class="input-group">
											<span class="input-group-addon">Tipo de Proyecto</span> <input
												maxlength="100" type="text" class="form-control"
												id="tipo_proyecto_fisica3" name="tipo_proyecto_fisica3"
												minlength="2">
										</div>
										<br>
										<div class="input-group">
											<span class="input-group-addon">Duración</span> <input
												maxlength="100" type="text" class="form-control"
												id="duracion_proyecto_fisica3"
												name="duracion_proyecto_fisica3" minlength="2">
										</div>
										<br>
										<div class="input-group">
											<span class="input-group-addon">Ubicación</span> <input
												maxlength="100" type="text" class="form-control"
												id="ubicacion_proyecto_fisica3"
												name="ubicacion_proyecto_fisica3" minlength="2">
										</div>
										<br>
										<div class="input-group">
											<span class="input-group-addon">Municipio</span> <input
												maxlength="100" type="text" class="form-control"
												id="municipio_proyecto_fisica3"
												name="municipio_proyecto_fisica3" minlength="2">
										</div>
										<br>
										<div class="input-group">
											<span class="input-group-addon">Estado</span> <input
												maxlength="100" type="text" class="form-control"
												id="estado_proyecto_fisca3" name="estado_proyecto_fisca3"
												minlength="2">
										</div>
										<br>
										<div class="input-group">
											<span class="input-group-addon">Federación</span> <input
												maxlength="100" type="text" class="form-control"
												id="federacion_proyecto_fisica3"
												name="federacion_proyecto_fisica3" minlength="2">
										</div>
										<br>
									</div>
									<!-- /.box-body -->

								</div>
								<!-- /.box -->
								<!-- termina experiencia 3 -->
							</div>
						</div>
					</div>
					<div class="panel box box-primary">
						<div class="box-header with-border">
							<h4 class="box-title">
								<a data-toggle="collapse" data-parent="#accordion"
									href="#collapseTwo"> Personas Morales </a> <input type="radio"
									name="tipo" value="m">
							</h4>
						</div>
						<div id="collapseTwo" class="panel-collapse collapse">
							<div class="box-body">
								<h4>Situación Fiscal</h4>
								<div class="input-group">
									<span class="input-group-addon">R.F.C</span> <input
										maxlength="100" type="text" class="form-control"
										id="rfc_morales" name="rfc_morales" minlength="2">
								</div>
								<br>
								<div class="input-group">
									<span class="input-group-addon">C.U.R.P.</span> <input
										maxlength="100" type="text" class="form-control"
										id="curp_morales" name="curp_morales" minlength="2">
								</div>
								<br>
								<div class="input-group">
									<span class="input-group-addon">Domicilio Fiscal</span> <input
										maxlength="100" type="text" class="form-control"
										id="domicilio_morales" name="domicilio_morales" minlength="2">
								</div>
								<br>
								<div class="input-group">
									<span class="input-group-addon">Fecha de Última
										Declaración</span> <input maxlength="100" type="text"
										class="form-control" id="fecha_declaracion_morales"
										name="fecha_declaracion_morales" minlength="2">
								</div>
								<br>
								<div class="input-group">
									<span class="input-group-addon">Presentar Factura/Recibo
										No.</span> <input maxlength="100" type="text" class="form-control"
										id="factura_morales" name="correo" minlength="2">
								</div>
								<br>
								<h4>Mencione los últimos 5 estudios realizados</h4>
								<!-- estudio 1 -->
								<div class="box box-success">
									<div class="box-header with-border"></div>

									<div class="box-body">
										<div class="input-group">
											<span class="input-group-addon">Estudio Realizado</span> <input
												maxlength="100" type="text" class="form-control"
												id="estudio_morales" name="estudio_morales" minlength="2">
										</div>
										<br>
										<div class="input-group">
											<span class="input-group-addon">Nombre</span> <input
												maxlength="100" type="text" class="form-control"
												id="nombre_estudios_morales" name="nombre_estudios_morales"
												minlength="2">
										</div>
										<br>
										<div class="input-group">
											<span class="input-group-addon">Domicilio</span> <input
												maxlength="100" type="text" class="form-control"
												id="domicilio_estudios_morales"
												name="domicilio_estudios_morales" minlength="2">
										</div>
										<br>
										<div class="input-group">
											<span class="input-group-addon">Fecha de realización</span> <input
												maxlength="100" type="text" class="form-control"
												id="fecha_estudios_morales" name="fecha_estudios_morales"
												minlength="2">
										</div>
										<br>
									</div>
									<!-- /.box-body -->

								</div>
								<!-- /.box -->
								<!-- termina estudio 1 -->
								<!-- estudio 2 -->
								<div class="box box-success">
									<div class="box-header with-border"></div>

									<div class="box-body">
										<div class="input-group">
											<span class="input-group-addon">Estudio Realizado</span> <input
												maxlength="100" type="text" class="form-control"
												id="estudio_morales2" name="estudio_morales2" minlength="2">
										</div>
										<br>
										<div class="input-group">
											<span class="input-group-addon">Nombre</span> <input
												maxlength="100" type="text" class="form-control"
												id="nombre_estudios_morales2"
												name="nombre_estudios_morales2" minlength="2">
										</div>
										<br>
										<div class="input-group">
											<span class="input-group-addon">Domicilio</span> <input
												maxlength="100" type="text" class="form-control"
												id="domicilio_estudios_morales2"
												name="domicilio_estudios_morales2" minlength="2">
										</div>
										<br>
										<div class="input-group">
											<span class="input-group-addon">Fecha de realización</span> <input
												maxlength="100" type="text" class="form-control"
												id="fecha_estudios_morales2" name="fecha_estudios_morales2"
												minlength="2">
										</div>
										<br>
									</div>
									<!-- /.box-body -->

								</div>
								<!-- /.box -->
								<!-- termina estudio 2 -->
								<!-- estudio 3 -->
								<div class="box box-success">
									<div class="box-header with-border"></div>

									<div class="box-body">
										<div class="input-group">
											<span class="input-group-addon">Estudio Realizado</span> <input
												maxlength="100" type="text" class="form-control"
												id="estudio_morales3" name="estudio_morales3" minlength="2">
										</div>
										<br>
										<div class="input-group">
											<span class="input-group-addon">Nombre</span> <input
												maxlength="100" type="text" class="form-control"
												id="nombre_estudios_morales3"
												name="nombre_estudios_morales3" minlength="2">
										</div>
										<br>
										<div class="input-group">
											<span class="input-group-addon">Domicilio</span> <input
												maxlength="100" type="text" class="form-control"
												id="domicilio_estudios_morales3"
												name="domicilio_estudios_morales3" minlength="2">
										</div>
										<br>
										<div class="input-group">
											<span class="input-group-addon">Fecha de realización</span> <input
												maxlength="100" type="text" class="form-control"
												id="fecha_estudios_morales3" name="fecha_estudios_morales3"
												minlength="2">
										</div>
										<br>
									</div>
									<!-- /.box-body -->

								</div>
								<!-- /.box -->
								<!-- termina estudio 3 -->
								<!-- estudio 4 -->
								<div class="box box-success">
									<div class="box-header with-border"></div>

									<div class="box-body">
										<div class="input-group">
											<span class="input-group-addon">Estudio Realizado</span> <input
												maxlength="100" type="text" class="form-control"
												id="estudio_morales4" name="estudio_morales4" minlength="2">
										</div>
										<br>
										<div class="input-group">
											<span class="input-group-addon">Nombre</span> <input
												maxlength="100" type="text" class="form-control"
												id="nombre_estudios_morales4"
												name="nombre_estudios_morales4" minlength="2">
										</div>
										<br>
										<div class="input-group">
											<span class="input-group-addon">Domicilio</span> <input
												maxlength="100" type="text" class="form-control"
												id="domicilio_estudios_morales4"
												name="domicilio_estudios_morales4" minlength="2">
										</div>
										<br>
										<div class="input-group">
											<span class="input-group-addon">Fecha de realización</span> <input
												maxlength="100" type="text" class="form-control"
												id="fecha_estudios_morales4" name="fecha_estudios_morales4"
												minlength="2">
										</div>
										<br>
									</div>
									<!-- /.box-body -->

								</div>
								<!-- /.box -->
								<!-- termina estudio 4 -->
								<!-- estudio 5 -->
								<div class="box box-success">
									<div class="box-header with-border"></div>

									<div class="box-body">
										<div class="input-group">
											<span class="input-group-addon">Estudio Realizado</span> <input
												maxlength="100" type="text" class="form-control"
												id="estudio_morales5" name="estudio_morales5" minlength="2">
										</div>
										<br>
										<div class="input-group">
											<span class="input-group-addon">Nombre</span> <input
												maxlength="100" type="text" class="form-control"
												id="nombre_estudios_morales5"
												name="nombre_estudios_morales5" minlength="2">
										</div>
										<br>
										<div class="input-group">
											<span class="input-group-addon">Domicilio</span> <input
												maxlength="100" type="text" class="form-control"
												id="domicilio_estudios_morales5"
												name="domicilio_estudios_morales5" minlength="2">
										</div>
										<br>
										<div class="input-group">
											<span class="input-group-addon">Fecha de realización</span> <input
												maxlength="100" type="text" class="form-control"
												id="fecha_estudios_morales5" name="fecha_estudios_morales5"
												minlength="2">
										</div>
										<br>
									</div>
									<!-- /.box-body -->

								</div>
								<!-- /.box -->
								<!-- termina estudio 5  -->
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- termina acordion -->
			<h4>Disponibilidad de equipo e infraestructura</h4>
			<div class="input-group">
				<span class="input-group-addon">incluye oficina, vehículo,
					equipo de cómputo, de medición , software, etc.</span>
				<textarea class="form-control"
					id="disponibilidad_equipo_infraestructuras"
					name="disponibilidad_equipo_infraestructuras" required
					minlength="2"></textarea>
			</div>
			<br>
			<h4>Cartografía</h4>
			<div class="input-group">
				<span class="input-group-addon">Listado de cartografía del
					Estado de Nuevo León con la que cuenta para consulta, fotos
					aéreas, de satélite, etc.</span>
				<textarea class="form-control" id="cartografia" name="cartografia"></textarea>
			</div>
			<br>
			<h4>Bibliografía</h4>
			<div class="input-group">
				<span class="input-group-addon">Listado de la bibliografía
					aplicable para consulta y referencias.</span>
				<textarea class="form-control" id="bibliografia" name="bibliografia"></textarea>
			</div>
			<br>
			<h4>Curso de capacitación o actualización</h4>
			<div class="input-group">
				<span class="input-group-addon">Listar los cursos tomados y
					sus respectivos comprobantes.</span>
				<textarea class="form-control" id="curso_capacitacion"
					name="curso_capacitacion"></textarea>
			</div>
			<br>
			<h4>Ingresos Mensuales</h4>
			<div class="input-group">
				<span class="input-group-addon"></span> <select
					id="ingresos_mensuales" name="ingresos_mensuales"
					class="form-control" required>
					<option value="Entre 10,000 y 20,000">Entre 10,000 y
						20,000</option>
					<option value="Entre 21000 y 30,000">Entre 21000 y 30,000</option>
					<option value="Mas de 50,000">Mas de 50,000</option>
				</select>
			</div>
			<br>
			<div class="input-group">
				<span class="input-group-addon"></span> <select id="estatus"
					name="estatus" class="form-control"></select>
			</div>
			<br>
			<%@ include
				file="/WEB-INF/pages/formularios_tramites/seccionArchivos.jsp"%>
		</div>
		<!-- /.box-body -->
		<div class="box-footer">
			<input id="btn_enviar" type="submit" class="submit btn btn-primary"
				value="Guardar" />
		</div>
	</form>
</div>
<!-- /.box -->
<div class="row">
	<input type="hidden" id="tramite_catalogoID" value="${ catalogoID }">
	<div id="divCargaBitacora" style="overflow-y: scroll;"></div>
</div>