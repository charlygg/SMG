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

$("#catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento").change(function() {
	llenarcatalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento($("#catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento").val());
});

function llenarcatalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento(datos){
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

$("#idtramite_cambio_titularidad")
.change(
		function() {
			$
					.getJSON(
							'consultaTramite_cambio_titularidad?idtramite_cambio_titularidad='
									+ $(
											"#idtramite_cambio_titularidad")
											.val(),
							function(beanDatos) {
								$(
										'#catalogo_perfilempresa_idcatalogo_perfilempresa > option[value="'
												+ beanDatos.catalogo_perfilempresa_idcatalogo_perfilempresa
												+ '"]').attr(
										'selected', 'selected');
								///LLenas catalogo de establecimientos
								var establecimientoASeleccionar =beanDatos.catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento;
								$
										.getJSON(
												'getArrayEstablecimientosPorEmpresa?idempresa='
														+ $(
																"#catalogo_perfilempresa_idcatalogo_perfilempresa")
																.val(),
												function(beanDatos) {
													console
															.log(JSON
																	.stringify(beanDatos));
													$("#catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento").empty();
													$
															.each(
																	beanDatos,
																	function(
																			i,
																			item) {
																		$(
																				"#catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento")
																				.append(
																						"<option value=\""+item.idcatalogo_perfilestablecimiento+"\">"
																								+ item.idcatalogo_perfilestablecimiento+"/"+item.colonia+"/"+item.municipio
																								+ "</option>");
																	});
													$(
															'#catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento')
															.prop(
																	"disabled",
																	false);
													$('#catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento > option[value="'
															+establecimientoASeleccionar + '"]').attr('selected', 'selected');
												});
								
								
								////
								 $('#UUID').val(beanDatos.uuid);
								 $('#asunto').val(beanDatos.asunto);
								 
								 $('#f_recepcion_tramite').val(beanDatos.f_recepcion_tramite);
								 $('#f_tramite_concluido').val(beanDatos.f_tramite_concluido);
								 
								 
								 llenarcatalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento(establecimientoASeleccionar);
	        	 console.log(beanDatos.uuid);
	        	 var codec= beanDatos.uuid;
	        	
	        	 //$( "#input-700" ).remove();

	        	 //$( "#primerGuardar" ).append( "<input id=\"input-700\" name=\"kartik-input-700[]\" type=\"file\" multiple class=\"file-loading\">" );
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
		$.validator.setDefaults({submitHandler: function() { transaccionDatosRetornoID( 'registerTramite_cambio_titularidad', 'formulario', true, "exito()", "fallo()");}});
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
$('#idtramite_cambio_titularidad').empty();
$.getJSON('listacomboTramite_cambio_titularidad?rol_usuario='
		+ $("#rol_usuario").val(), function(beanDatos) {
	console.log(JSON.stringify(beanDatos));
	//datos para el combo
	if ($("#rol_usuario").val() != 'ROLE_RECEP') {
		$("#idtramite_cambio_titularidad").append(
				"<option value=''>Escoja una opción</option>");
	} else {
		$("#idtramite_cambio_titularidad").append(
				"<option value='0'>Escoja una opción</option>");
	}

	$.each(beanDatos, function(i, item) {
		console.log(item.idtramite_cambio_titularidad);
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
		$("#idtramite_cambio_titularidad").append(
				"<option value=\""+item.idtramite_cambio_titularidad+"\">Trámite No "
						+ item.idtramite_cambio_titularidad
						+ " en Estatus " + estatus + "</option>");
	});

});
}
	function exito(){
// 		mensajeriaAlertas('Exito', 'En Alta de Cambio de titularidad');
		comboListaTramite();
		$('#idtramite_cambio_titularidad').eq(1).prop('selected', true);
		$('#catalogo_perfilempresa_idcatalogo_perfilempresa').eq(0).prop(
				'selected', true);
		$("#catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento")
				.eq(0).prop('selected', true);
		$('#divCargaDetalle').hide();
		document.getElementById("catalogo_perfilempresa_idcatalogo_perfilempresa").selectedIndex = 0;
		document.getElementById("catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento").selectedIndex = -1;
		document.getElementById("estatus").selectedIndex = 0;
		///mostar el numero de oficio
    	$('#ocultarNumOficio').hide(); //muestro mediante id
		$('#divCargaBitacora').hide();
		$('#divCargaBitacora').empty();
	}
	function fallo(){
		mensajeriaAlertas('Error', 'En Alta de Cambio de titularidad');
		$('#idtramite_cambio_titularidad').eq(1).prop('selected', true);
		$('#catalogo_perfilempresa_idcatalogo_perfilempresa').eq(0).prop(
				'selected', true);
		$("#catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento")
				.eq(0).prop('selected', true);
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
			$('#divCargaBitacora').load('consultaBitacoraCatReg?idregistro='+$('#idtramite_cambio_titularidad').val()+'&catalogoID='+$('#tramite_catalogoID').val());
		}
		
		
	}
</script>

<div class="row">
	<div class="col-lg-12">
		<div class="box box-success">
                <div class="box-header with-border">
                  <h3 class="box-title">Tramite Cambio de titularidad.</h3>
                </div>
                <div class="box-body">
                 <!-- elemntos que se cambian por tramite -->
					<input type="hidden" id="areaNumOficio" value="IA">
					<input type="hidden" id="titleNumOficio" value="Tramite Cambio de titularidad">
					<input type="hidden" id="tipoTramiteNumOficio" value="7">
					<%@ include file="/WEB-INF/pages/formularios_tramites/numerOficio.jsp" %>
					<!-- terminas elementos  -->
                 <form id="formulario" role="form">
                 <c:choose>
						<c:when test="${empty data}">
					<div class="input-group" id="dividtramite">
						<span class="input-group-addon">Trámites en Ejecución</span> <select
							class="form-control" id="idtramite_cambio_titularidad"
							name="idtramite_cambio_titularidad"></select>
					</div>
					<br>
						</c:when>
					</c:choose>
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
                    	<span class="input-group-addon">Fecha de recepcón de documentación de tramite</span>
                     	<c:choose>
								<c:when test="${!empty data}">
								<input type="text" id="f_recepcion_tramite" name="f_recepcion_tramite" class="form-control" value="${data.f_recepcion_tramite}">
								</c:when>
								<c:otherwise>
								<input type="text" id="f_recepcion_tramite" name="f_recepcion_tramite" class="form-control">
								</c:otherwise>
							</c:choose>
                    </div>
                    <br>
                    <div class="input-group">
                    	<span class="input-group-addon">Fecha de tramite concluido</span>
                     	<c:choose>
								<c:when test="${!empty data}">
								<input type="text"  id="f_tramite_concluido" name="f_tramite_concluido" class="form-control" value="${data.f_tramite_concluido}">
								
								</c:when>
								<c:otherwise>
								<input type="text"  id="f_tramite_concluido" name="f_tramite_concluido" class="form-control">
								</c:otherwise>
							</c:choose>
                    </div>
                    <br>
                  <div class="input-group">
                    <span class="input-group-addon">Nombre de Empresa</span>
                     <select id="catalogo_perfilempresa_idcatalogo_perfilempresa" name="catalogo_perfilempresa_idcatalogo_perfilempresa" class="form-control" required>
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
                    <span class="input-group-addon">Establecimiento municipio</span>
                   <select id="catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento" name="catalogo_perfilestablecimiento_idcatalogo_perfilestablecimiento" class="form-control" disabled="disabled" required>
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
                    <!-- inicia bloque oculto -->
                   	<div id="DatosEstablecimiento" class="container" hidden>
                   		<div class="col-lg-10">
                   		<div class="box box-success">
                		<div class="box-header with-border">
                		  <h3 class="box-title">Establecimiento</h3>
                		</div>
                		<div class="box-body">
                  			<div class="input-group">
                    			<span class="input-group-addon">Calle</span>
                     			<input maxlength="100" type="text" id="calle" class="form-control" readonly>
                  			</div>
                  			<br>
                  			<div class="input-group">
                    			<span class="input-group-addon">Número Exterior</span>
                     			<input maxlength="100" type="text" id="numeroExterior" class="form-control" readonly>
                  			</div>
                  			<br>
                  			<div class="input-group">
                    			<span class="input-group-addon">Número Interior</span>
                     			<input maxlength="100" type="text" id="numeroInterior" class="form-control" readonly>
                  			</div>
                  			<br>
                  			<div class="input-group">
                    			<span class="input-group-addon">Colonia</span>
                     			<input maxlength="100" type="text" id="colonia" class="form-control" readonly>
                  			</div>
                  			<br>
                  			<div class="input-group">
                    			<span class="input-group-addon">Municipio</span>
                     			<input maxlength="100" type="text" id="municipio" class="form-control" readonly>
                  			</div>
                  			<br>
                  			<div class="input-group">
                    			<span class="input-group-addon">Estado</span>
                     			<input maxlength="100" type="text" id="estado" class="form-control" readonly>
                  			</div>
                  			<br>
                  			<div class="input-group">
                    			<span class="input-group-addon">Latitud</span>
                     			<input maxlength="100" type="text" id="latitud" class="form-control" readonly>
                  			</div>
                  			<br><div class="input-group">
                    			<span class="input-group-addon">Longitud</span>
                     			<input maxlength="100" type="text" id="longitud" class="form-control" readonly>
                  			</div>
                  			<br>
                  		</div>
                  	</div>
                   
                   		</div>
                   	</div>
                   	
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
				
					<%@ include file="/WEB-INF/pages/formularios_tramites/seccionArchivos.jsp" %>
					<br>
					<br>
					 <c:choose>
					<c:when test="${empty data}">
						<input id="btn_enviar" type="submit"
							class="submit btn btn-primary" value="Guardar" />
					</c:when>
					</c:choose>
					<!--  -->
					 </form>
                   	<!--  -->
                </div><!-- /.box-body -->
                <div class="box-footer">
                </div>
              </div><!-- /.box -->
	</div>
</div>
<div class="row">
	<input type="hidden" id="tramite_catalogoID" value="${ catalogoID }">
	<div id="divCargaBitacora" style="overflow-y:scroll;"></div>
</div>