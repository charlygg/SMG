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
	
	$("#idempresa").change(
			function() {
				$("#idestablecimiento").empty();
				$.getJSON('getArrayEstablecimientosPorEmpresa?idempresa='
						+ $("#idempresa").val(), function(data) {
					console.log(JSON.stringify(data));
					$.each(data, function(i, item) {
						console.log(item.idcatalogo_perfilestablecimiento);
						$("#idestablecimiento").append(
								"<option value=\""+item.idcatalogo_perfilestablecimiento+"\">"
										+ item.idcatalogo_perfilestablecimiento+"/"+item.colonia+"/"+item.municipio + "</option>");
					});
					$('#idestablecimiento').prop("disabled", false);
				});
			});

	$("#idtramite").change(function() {
	    $.getJSON('consultaTramite_registro_Aguas_Residuales?idtramite='+$("#idtramite").val(),function(data){
	    	$('#idempresa > option[value="'+data.idempresa+'"]').attr('selected', 'selected');
	    	///LLenas catalogo de establecimientos
	    	var establecimientoASeleccionar =data.idestablecimiento;
	   		$.getJSON('getArrayEstablecimientosPorEmpresa?idempresa='+$("#idempresa").val(),function(data){
				console.log(JSON.stringify(data));
				$("#idestablecimiento").empty();
				$.each(data, function(i,item){
	   				$("#idestablecimiento").append("<option value=\""+item.idcatalogo_perfilestablecimiento+"\">"+item.idcatalogo_perfilestablecimiento+"/"+item.colonia+"/"+item.municipio+"</option>");
	   			});
				 $('#idestablecimiento').prop( "disabled", false );
				 $('#idestablecimiento > option[value="'+establecimientoASeleccionar+'"]').attr('selected', 'selected');
			});
	   		llenaridestablecimiento(establecimientoASeleccionar);
	   		$('#f_recepcion_tramite').val(data.f_recepcion_tramite);
			 $('#f_tramite_concluido').val(data.f_tramite_concluido);			
	   	 $('#asunto').val(data.asunto);
	   		$('#nfolio').val(data.nfolio);
	   		$('#esnuevousu').val(data.esnuevousu);
	   		$('#regnuedesexpant').val(data.regnuedesexpant);
	   		$('#modexpant').val(data.modexpant);
	   		$('#nomrepresentante').val(data.nomrepresentante);
	   		$('#telefono').val(data.telefono);
	   		$('#calle').val(data.calle);
	   		$('#numero').val(data.numero);
	   		$('#colonia').val(data.colonia);
	   		$('#municipio').val(data.municipio);
	   		$('#telefonodes').val(data.telefonodes);
	   		$('#entrecalles').val(data.entrecalles);
	   		$('#email').val(data.email);
	   		$('#direcciondes').val(data.direcciondes);
	   		$('#actividad').val(data.actividad);
	   		$('#servicio').val(data.servicio);
	   		$('#concesion').val(data.concesion);
	   		$('#contrato').val(data.contrato);
	   		
	   		//adm cna ptar
	   		
	   		$('#sadm').val(data.sadm);
	   		$('#cna').val(data.cna);
	   		$('#condesp').val(data.condesp);
	   		$('#oficio').val(data.oficio);
	   		$('#tipodescarga').val(data.tipodescarga);
	   		$('#horadescarga').val(data.horadescarga);
	   		$('#areaproviene').val(data.areaproviene);
	   		$('#tipodescargasda').val(data.tipodescargasda);
	   		$('#horadescargasda').val(data.horadescargasda);
	   		$('#areaprovienesda').val(data.areaprovienesda);
	   		$('#tipodecargatra').val(data.tipodecargatra);
	   		$('#horadescargatra').val(data.horadescargatra);
	   		$('#areaprovienetra').val(data.areaprovienetra);
	   		$('#tipodecargacta').val(data.tipodecargacta);
	   		$('#horadescargacta').val(data.horadescargacta);
	   		$('#areaprovienecta').val(data.areaprovienecta);
	   		$('#pluvialdrenaje').val(data.pluvialdrenaje);
	   		$('#descripciondescargas').val(data.descripciondescargas);
	   		$('#cambiosdescargas').val(data.cambiosdescargas);
	   		$('#fecha').val(data.fecha);
	   		$('#tipopersona').val(data.tipopersona);
	   		$('#identificacion').val(data.identificacion);
	   		$('#actaconstitutiva').val(data.actaconstitutiva);
	   		$('#poderrepresentante').val(data.poderrepresentante);
	   		$('#solicitudcopias').val(data.solicitudcopias);
	   		$('#registrosbanqueta').val(data.registrosbanqueta);
	   		$('#tipodescargaqta').val(data.tipodescargaqta);
	   		$('#horadescargaqta').val(data.horadescargaqta);
	   		
	   		if(data.conagua == 'si')
	   			$('input:radio[name=conagua]:nth(0)').attr('checked',true);
	   		else
	   			$('input:radio[name=conagua]:nth(1)').attr('checked',true);
	   		
	   		
	   		switch(data.tipoprocedimiento){
	   		case 'newuser':
	   			$('input:radio[name=tipoprocedimiento]:nth(0)').attr('checked',true);
	   			break;
	   		case 'regnew':
	   			$('input:radio[name=tipoprocedimiento]:nth(1)').attr('checked',true);
	   			break;
	   		case 'mofuser':
	   			$('input:radio[name=tipoprocedimiento]:nth(2)').attr('checked',true);
	   			break;
	   		}
	   		
	   		
	   		$('#ptar').val(data.ptar);
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
	    	
	    	$('#tipo_combustible').val(data.tipo_combustible);
	    	$('#cantidad').val(data.cantidad);
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

	$(document).ready(
			function() {
				$.validator.setDefaults({
					submitHandler : function() {
						transaccionDatosRetornoID(
								'registerTramite_registro_Aguas_Residuales',
								'formulario', true, "exito()", "fallo()");
					}
				});
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
			$('#idtramite').empty();
			$.getJSON('listacomboTramite_registro_Aguas_Residuales?rol_usuario='+$("#rol_usuario").val(),function(data){
		        console.log(JSON.stringify(data));
		        //datos para el combo
		        if($("#rol_usuario").val() != 'ROLE_RECEP'){
		        	$("#idtramite").append("<option value=''>Escoja una opción</option>");	
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

	function exito() {
// 		mensajeriaAlertas('Exito', 'En Alta de Tramite Aguas Residuales');
		comboListaTramite();
		$('#idtramite').eq(1).prop('selected', true);
		$('#idempresa').eq(0).prop('selected', true);
		$("#idestablecimiento").eq(0).prop('selected', true);
		$('#divCargaDetalle').hide();
		///mostar el numero de oficio
    	$('#ocultarNumOficio').hide(); //muestro mediante id
		$('#divCargaBitacora').hide();
		$('#divCargaBitacora').empty();
	}
	function fallo() {
		mensajeriaAlertas('Error', 'En Alta de Tramite Aguas Residuales');
		$('#idtramite').eq(1).prop('selected', true);
		$('#idempresa').eq(0).prop('selected', true);
		$("#idestablecimiento").eq(0).prop('selected', true);
		$('#divCargaDetalle').hide();
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
				<h3 class="box-title">Registro de Aguas Residuales.</h3>
			</div>

			<div class="box-body">
				<!-- elemntos que se cambian por tramite -->
				<input type="hidden" id="areaNumOficio" value="CD"> <input
					type="hidden" id="titleNumOficio"
					value="Registro de Aguas Residuales"> <input type="hidden"
					id="tipoTramiteNumOficio" value="16">
				<%@ include
					file="/WEB-INF/pages/formularios_tramites/numerOficio.jsp"%>
				<!-- terminas elementos  -->
				<form id="formulario" role="form">
					<c:choose>
						<c:when test="${empty data}">
							<div class="input-group" id="dividtramite">
								<span class="input-group-addon">Trámites en Ejecución</span> <select
									class="form-control" id="idtramite" name="idtramite">
								</select>
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
						<span class="input-group-addon">Número de Folio</span>
						<c:choose>
							<c:when test="${empty data}">
								<input maxlength="100" type="text" class="form-control"
									id="nfolio" name="nfolio" required>
							</c:when>
							<c:otherwise>
								<input maxlength="100" type="text" class="form-control"
									id="nfolio" name="nfolio" required value="${data.nfolio}">
							</c:otherwise>
						</c:choose>

					</div>
					<br>
					<div class="input-group">
						<c:choose>
							<c:when test="${empty data}">
								<input type="radio" name="conagua" value="si">Con Agua
								<input type="radio" name="conagua" value="no">Sin Agua
							</c:when>
							<c:otherwise>
								<c:choose>
									<c:when test="${data.conagua == 'si'}">
										<input type="radio" name="conagua" value="si" checked>Con Agua
										<input type="radio" name="conagua" value="no">Sin Agua
								</c:when>
									<c:otherwise>
										<input type="radio" name="conagua" value="si">Con Agua
										<input type="radio" name="conagua" value="no" checked>Sin Agua
								</c:otherwise>
								</c:choose>
							</c:otherwise>
						</c:choose>


					</div>
					<br>
					<div class="box box-success">
						<div class="box-header with-border">
							<h2 class="box-title">Datos Generales.</h2>
						</div>
					</div>
					<div class="input-group">
						<input id="tipoprocedimiento" type="radio"
							name="tipoprocedimiento" value="newuser">Nuevo Usuario
						&nbsp; &nbsp; &nbsp; &nbsp; <input id="tipoprocedimiento"
							type="radio" name="tipoprocedimiento" value="regnew">Registro
						de Nuevas descargas a expediente anterior &nbsp; &nbsp; &nbsp;
						&nbsp; <input id="tipoprocedimiento" type="radio"
							name="tipoprocedimiento" value="mofuser">Modificaciones a
						expediente anterior
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon"> Nombre de la empresa y/o
							Persona Física:</span> <select id="idempresa" name="idempresa"
							class="form-control" required>
							<option value="">Escoja una opción</option>
							<c:choose>
								<c:when test="${!empty data}">
									<c:forEach items="${empresas}" var="empresa">
										<c:choose>
											<c:when
												test="${empresa.idcatalogo_perfilempresa == data.idempresa}">
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
							id="idestablecimiento" name="idestablecimiento"
							class="form-control" disabled="disabled" required>
							<c:choose>
								<c:when test="${!empty data}">
									<c:forEach items="${establecimientos}" var="empresa">
										<c:choose>
											<c:when
												test="${empresa.idcatalogo_perfilestablecimiento == data.idestablecimiento}">
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
					<%@ include
						file="/WEB-INF/pages/formularios_tramites/seccionEstableci.jsp"%>

					<br>
					<div class="input-group">
						<span class="input-group-addon">Nombre del propietario y/o
							representante legal</span>
						<c:choose>
							<c:when test="${!empty data}">
								<input maxlength="100" type="text" class="form-control"
									id="nomrepresentante" name="nomrepresentante" required
									value="${data.nomrepresentante}">
							</c:when>
							<c:otherwise>
								<input maxlength="100" type="text" class="form-control"
									id="nomrepresentante" name="nomrepresentante" required>
							</c:otherwise>
						</c:choose>


					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Teléfono y/o móvil :</span>
						<c:choose>
							<c:when test="${!empty data}">
								<input maxlength="100" type="text" class="form-control"
									id="telefono" name="telefono" value="${data.telefono}">
							</c:when>
							<c:otherwise>
								<input maxlength="100" type="text" class="form-control"
									id="telefono" name="telefono">
							</c:otherwise>
						</c:choose>

					</div>
					<br>
					<div class="box box-success">
						<div class="box-header with-border">
							<h2 class="box-title">Domicilio para oír y recibir
								notificaciones:</h2>
						</div>
					</div>
					<div class="input-group">

						<span class="input-group-addon">Calle :</span>
						<c:choose>
							<c:when test="${!empty data}">
								<input maxlength="100" type="text" class="form-control"
									id="calle" name="calle" value="${data.telefono}">
							</c:when>
							<c:otherwise>
								<input maxlength="100" type="text" class="form-control"
									id="calle" name="calle">
							</c:otherwise>
						</c:choose>

					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Numero :</span>
						<c:choose>
							<c:when test="${!empty data}">
								<input maxlength="100" type="text" class="form-control"
									id="numero" name="numero" value="${data.numero}">
							</c:when>
							<c:otherwise>
								<input maxlength="100" type="text" class="form-control"
									id="numero" name="numero">
							</c:otherwise>
						</c:choose>

					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Colonia :</span>
						<c:choose>
							<c:when test="${!empty data}">
								<input maxlength="100" type="text" class="form-control"
									id="colonia" name="colonia" value="${data.colonia}">
							</c:when>
							<c:otherwise>
								<input maxlength="100" type="text" class="form-control"
									id="colonia" name="colonia">
							</c:otherwise>
						</c:choose>

					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Municipio :</span>
						<c:choose>
							<c:when test="${!empty data}">
								<input maxlength="100" type="text" class="form-control"
									id="municipio" name="municipio" value="${data.municipio}">
							</c:when>
							<c:otherwise>
								<input maxlength="100" type="text" class="form-control"
									id="municipio" name="municipio">
							</c:otherwise>
						</c:choose>

					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Teléfono :</span>
						<c:choose>
							<c:when test="${!empty data}">
								<input maxlength="100" type="text" class="form-control"
									id="telefonodes" name="telefonodes" value="${data.telefonodes}">
							</c:when>
							<c:otherwise>
								<input maxlength="100" type="text" class="form-control"
									id="telefonodes" name="telefonodes">
							</c:otherwise>
						</c:choose>

					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Entre Calles:</span>
						<c:choose>
							<c:when test="${!empty data}">

								<input maxlength="100" type="text" class="form-control"
									id="entrecalles" name="entrecalles" value="${data.entrecalles}">
							</c:when>
							<c:otherwise>
								<input maxlength="100" type="text" class="form-control"
									id="entrecalles" name="entrecalles">
							</c:otherwise>
						</c:choose>

					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Correo eléctronico :</span>
						<c:choose>
							<c:when test="${!empty data}">
								<input maxlength="100" type="email" class="form-control"
									id="email" name="email">
							</c:when>
							<c:otherwise>
								<input maxlength="100" type="email" class="form-control"
									id="email" name="email">
							</c:otherwise>
						</c:choose>

					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Dirección de la descarga
							soló en caso de ser diferente a la anterior:</span>
						<c:choose>
							<c:when test="${!empty data}">
								<textarea class="form-control" id="direcciondes"
									name="direcciondes">${data.direcciondes} </textarea>
							</c:when>
							<c:otherwise>
								<textarea class="form-control" id="direcciondes"
									name="direcciondes"> </textarea>
							</c:otherwise>
						</c:choose>


					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon"> Actividad que realiza:</span>
						<c:choose>
							<c:when test="${!empty data}">
								<textarea class="form-control" id="actividad" name="actividad"> ${data.actividad}</textarea>
							</c:when>
							<c:otherwise>
								<textarea class="form-control" id="actividad" name="actividad"> </textarea>
							</c:otherwise>
						</c:choose>

					</div>
					<br>
					<div class="box box-success">
						<div class="box-header with-border">
							<h2 class="box-title">Suministro de Agua</h2>
						</div>
					</div>
					<div class="input-group">
						<span class="input-group-addon">Servicios de Agua y Drenaje
							de Mty. :&nbsp; &nbsp; Contrato:</span>

						<c:choose>
							<c:when test="${!empty data}">
								<input maxlength="100" type="text" class="form-control"
									id="servicio" name="servicio" value="${data.servicio}">
							</c:when>
							<c:otherwise>
								<input maxlength="100" type="text" class="form-control"
									id="servicio" name="servicio">
							</c:otherwise>
						</c:choose>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Comisión Nacional del
							Agua:&nbsp; &nbsp; N° de concesión:</span>

						<c:choose>
							<c:when test="${!empty data}">
								<input maxlength="100" type="text" class="form-control"
									id="concesion" name="concesion" value="${data.concesion}">
							</c:when>
							<c:otherwise>
								<input maxlength="100" type="text" class="form-control"
									id="concesion" name="concesion">
							</c:otherwise>
						</c:choose>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Residual Planta:&nbsp;
							&nbsp; N° de contrato:</span>

						<c:choose>
							<c:when test="${!empty data}">
								<input maxlength="100" type="text" class="form-control"
									id="contrato" name="contrato" value="${data.contrato}">
							</c:when>
							<c:otherwise>
								<input maxlength="100" type="text" class="form-control"
									id="contrato" name="contrato">
							</c:otherwise>
						</c:choose>
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
							<c:when test="${empty data}">
								<input type="checkbox" id="sadm" name="sadm">Servicios de Agua y
						Drenaje de Mty. (SADM) <input type="checkbox" id="cna" name="cna">Comisión
						Nacional del Agua (CNA) <input type="checkbox" id="ptar"
									name="ptar">Planta de Tratamiento de Aguas Residuales
						(PTAR)
							</c:when>
							<c:otherwise>
								<c:choose>
									<c:when test="${data.sadm=='on'}">
										<input type="checkbox" id="sadm" name="sadm" checked>Servicios de Agua y Drenaje de Mty. (SADM)
									</c:when>
									<c:otherwise>
										<input type="checkbox" id="sadm" name="sadm">Servicios de Agua y Drenaje de Mty. (SADM)
								</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${data.sadm=='on'}">
										<input type="checkbox" id="cna" name="cna" checked>Comisión Nacional del Agua (CNA) 
									</c:when>
									<c:otherwise>
										<input type="checkbox" id="cna" name="cna">Comisión Nacional del Agua (CNA) 
								</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${data.sadm=='on'}">
										<input type="checkbox" id="ptar" name="ptar" checked>Planta de Tratamiento de Aguas Residuales (PTAR)
									</c:when>
									<c:otherwise>
										<input type="checkbox" id="ptar" name="ptar">Planta de Tratamiento de Aguas Residuales (PTAR)
								</c:otherwise>
								</c:choose>
							</c:otherwise>
						</c:choose>



					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Cuenta con las Condiciones
							Particulares de Descarga:</span>
						<c:choose>
							<c:when test="${empty data}">
								<input type="radio" name="condesp" value="si">Si <input
									type="radio" name="condesp" value="no">No
							</c:when>
							<c:otherwise>
								<c:choose>
									<c:when test="${data.condesp=='si'}">
										<input type="radio" name="condesp" value="si" checked>Si <input
											type="radio" name="condesp" value="no">No
								</c:when>
									<c:otherwise>
										<input type="radio" name="condesp" value="si" checked>Si <input
											type="radio" name="condesp" value="no" checked>No
								</c:otherwise>
								</c:choose>
							</c:otherwise>
						</c:choose>



					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Oficio No:</span>
						<c:choose>
							<c:when test="${empty data}">
								<input maxlength="100" type="text" class="form-control"
									id="oficio" name="oficio">
							</c:when>
							<c:otherwise>
								<input maxlength="100" type="text" class="form-control"
									id="oficio" name="oficio" value="${data.oficio}">
							</c:otherwise>
						</c:choose>

					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Tipo de Descarga:</span>

						<c:choose>
							<c:when test="${empty data}">
								<input type="radio" name="tipodescarga" value="s">Sanitaria <input
									type="radio" name="tipodescarga" value="i">Industrial <input
									type="radio" name="tipodescarga" value="t">Intermitente <input
									type="radio" name="tipodescarga" value="c">Continua
						
						</c:when>
							<c:otherwise>
								<c:choose>
									<c:when test="${data.tipodescarga=='s'}">
										<input type="radio" name="tipodescarga" value="s" checked>Sanitaria 
						</c:when>
									<c:otherwise>
										<input type="radio" name="tipodescarga" value="s" checked>Sanitaria 
						</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${data.tipodescarga=='i'}">
										<input type="radio" name="tipodescarga" value="i" checked>Industrial
						</c:when>
									<c:otherwise>
										<input type="radio" name="tipodescarga" value="i">Industrial
						</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${data.tipodescarga=='t'}">
										<input type="radio" name="tipodescarga" value="t" checked>Intermitente
						</c:when>
									<c:otherwise>
										<input type="radio" name="tipodescarga" value="t">Intermitente
						</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${data.tipodescarga=='c'}">
										<input type="radio" name="tipodescarga" value="c" checked>Continua
						</c:when>
									<c:otherwise>
										<input type="radio" name="tipodescarga" value="c">Continua
						</c:otherwise>
								</c:choose>


							</c:otherwise>

						</c:choose>

					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">(Especificar Horario):</span>

						<c:choose>
							<c:when test="${empty data}">
								<input maxlength="100" type="text" class="form-control"
									id="horadescarga" name="horadescarga">
							</c:when>
							<c:otherwise>
								<input maxlength="100" type="text" class="form-control"
									id="horadescarga" name="horadescarga"
									value="${data.horadescarga}">
							</c:otherwise>
						</c:choose>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Proviene de áreas:</span>
						<c:choose>
							<c:when test="${empty data}">
								<textarea class="form-control" id="areaproviene"
									name="areaproviene"></textarea>
							</c:when>
							<c:otherwise>
								<textarea class="form-control" id="areaproviene"
									name="areaproviene">${data.areaproviene}</textarea>
							</c:otherwise>
						</c:choose>


					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Tipo de Descarga:</span>
						<c:choose>
							<c:when test="${empty data}">
								<input type="radio" name="tipodescargasda" value="s">Sanitaria <input
									type="radio" name="tipodescargasda" value="i">Industrial <input
									type="radio" name="tipodescargasda" value="t">Intermitente <input
									type="radio" name="tipodescargasda" value="c">Continua
						
						</c:when>
							<c:otherwise>
								<c:choose>
									<c:when test="${data.tipodescargasda=='s'}">
										<input type="radio" name="tipodescargasda" value="s" checked>Sanitaria 
						</c:when>
									<c:otherwise>
										<input type="radio" name="tipodescargasda" value="s" checked>Sanitaria 
						</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${data.tipodescargasda=='i'}">
										<input type="radio" name="tipodescargasda" value="i" checked>Industrial
						</c:when>
									<c:otherwise>
										<input type="radio" name="tipodescargasda" value="i">Industrial
						</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${data.tipodescargasda=='t'}">
										<input type="radio" name="tipodescargasda" value="t" checked>Intermitente
						</c:when>
									<c:otherwise>
										<input type="radio" name="tipodescargasda" value="t">Intermitente
						</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${data.tipodescargasda=='c'}">
										<input type="radio" name="tipodescargasda" value="c" checked>Continua
						</c:when>
									<c:otherwise>
										<input type="radio" name="tipodescargasda" value="c">Continua
						</c:otherwise>
								</c:choose>


							</c:otherwise>

						</c:choose>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">(Especificar Horario):</span>
						<c:choose>
							<c:when test="${empty data}">
								<input maxlength="100" type="text" class="form-control"
									id="horadescargasda" name="horadescargasda">
							</c:when>
							<c:otherwise>
								<input maxlength="100" type="text" class="form-control"
									id="horadescargasda" name="horadescargasda"
									value="${data.horadescargasda}">
							</c:otherwise>
						</c:choose>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Proviene de áreas:</span><br>
						<c:choose>
							<c:when test="${empty data}">
								<textarea class="form-control" id="areaprovienesda"
									name="areaprovienesda"></textarea>
							</c:when>
							<c:otherwise>
								<textarea class="form-control" id="areaprovienesda"
									name="areaprovienesda">${data.areaprovienesda}</textarea>
							</c:otherwise>
						</c:choose>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Tipo de Descarga:</span>
						<c:choose>
							<c:when test="${empty data}">
								<input type="radio" name="tipodecargatra" value="s">Sanitaria <input
									type="radio" name="tipodecargatra" value="i">Industrial <input
									type="radio" name="tipodecargatra" value="t">Intermitente <input
									type="radio" name="tipodecargatra" value="c">Continua
						
						</c:when>
							<c:otherwise>
								<c:choose>
									<c:when test="${data.tipodecargatra=='s'}">
										<input type="radio" name="tipodecargatra" value="s" checked>Sanitaria 
						</c:when>
									<c:otherwise>
										<input type="radio" name="tipodecargatra" value="s" checked>Sanitaria 
						</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${data.tipodecargatra=='i'}">
										<input type="radio" name="tipodecargatra" value="i" checked>Industrial
						</c:when>
									<c:otherwise>
										<input type="radio" name="tipodecargatra" value="i">Industrial
						</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${data.tipodecargatra=='t'}">
										<input type="radio" name="tipodecargatra" value="t" checked>Intermitente
						</c:when>
									<c:otherwise>
										<input type="radio" name="tipodecargatra" value="t">Intermitente
						</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${data.tipodecargatra=='c'}">
										<input type="radio" name="tipodecargatra" value="c" checked>Continua
						</c:when>
									<c:otherwise>
										<input type="radio" name="tipodecargatra" value="c">Continua
						</c:otherwise>
								</c:choose>


							</c:otherwise>

						</c:choose>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">(Especificar Horario):</span>

						<c:choose>
							<c:when test="${empty data}">
								<input maxlength="100" type="text" class="form-control"
									id="horadescargatra" name="horadescargatra">
							</c:when>
							<c:otherwise>
								<input maxlength="100" type="text" class="form-control"
									id="horadescargatra" name="horadescargatra"
									value="${data.horadescargatra}">
							</c:otherwise>
						</c:choose>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Proviene de áreas:</span>


						<c:choose>
							<c:when test="${empty data}">
								<textarea class="form-control" id="areaprovienetra"
									name="areaprovienetra"></textarea>
							</c:when>
							<c:otherwise>
								<textarea class="form-control" id="areaprovienetra"
									name="areaprovienetra">${data.areaprovienetra}</textarea>
							</c:otherwise>
						</c:choose>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Tipo de Descarga:</span>
						<c:choose>
							<c:when test="${empty data}">
								<input type="radio" name="tipodecargacta" value="s">Sanitaria <input
									type="radio" name="tipodecargacta" value="i">Industrial <input
									type="radio" name="tipodecargacta" value="t">Intermitente <input
									type="radio" name="tipodecargacta" value="c">Continua
						
						</c:when>
							<c:otherwise>
								<c:choose>
									<c:when test="${data.tipodecargacta=='s'}">
										<input type="radio" name="tipodecargacta" value="s" checked>Sanitaria 
						</c:when>
									<c:otherwise>
										<input type="radio" name="tipodecargacta" value="s" checked>Sanitaria 
						</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${data.tipodecargacta=='i'}">
										<input type="radio" name="tipodecargacta" value="i" checked>Industrial
						</c:when>
									<c:otherwise>
										<input type="radio" name="tipodecargacta" value="i">Industrial
						</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${data.tipodecargacta=='t'}">
										<input type="radio" name="tipodecargacta" value="t" checked>Intermitente
						</c:when>
									<c:otherwise>
										<input type="radio" name="tipodecargacta" value="t">Intermitente
						</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${data.tipodecargacta=='c'}">
										<input type="radio" name="tipodecargacta" value="c" checked>Continua
						</c:when>
									<c:otherwise>
										<input type="radio" name="tipodecargacta" value="c">Continua
						</c:otherwise>
								</c:choose>


							</c:otherwise>

						</c:choose>

					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">(Especificar Horario):</span>

						<c:choose>
							<c:when test="${empty data}">
								<input maxlength="100" type="text" class="form-control"
									id="horadescargacta" name="horadescargacta">
							</c:when>
							<c:otherwise>
								<input maxlength="100" type="text" class="form-control"
									id="horadescargacta" name="horadescargacta"
									value="${data.areaprovienetra}">
							</c:otherwise>
						</c:choose>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Proviene de áreas:</span>


						<c:choose>
							<c:when test="${empty data}">
								<textarea class="form-control" id="areaprovienecta"
									name="areaprovienecta"></textarea>
							</c:when>
							<c:otherwise>
								<textarea class="form-control" id="areaprovienecta"
									name="areaprovienecta">${data.areaprovienecta}</textarea>
							</c:otherwise>
						</c:choose>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">¿El pluvial de la empresa
							está<br> conectado al drenaje sanitario?:
						</span>
						<c:choose>
							<c:when test="${empty data}">
								<input type="radio" name="tipodecargatra" value="si">Si <input
									type="radio" name="tipodecargatra" value="no">No
							</c:when>
							<c:otherwise>
								<c:choose>
									<c:when test="${data.tipodecargatra=='si'}">
										<input type="radio" name="tipodecargatra" value="si" checked>Si <input
											type="radio" name="tipodecargatra" value="no">No
								</c:when>
									<c:otherwise>
										<input type="radio" name="tipodecargatra" value="si">Si <input
											type="radio" name="tipodecargatra" value="no" checked>No
								</c:otherwise>
								</c:choose>
							</c:otherwise>
						</c:choose>


					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Procesos : Describir los
							procesos que<br> generan cada una de las descargas:
						</span>
						<c:choose>
							<c:when test="${empty data}">
								<textarea class="form-control" id="descripciondescargas"
									name="descripciondescargas"></textarea>
							</c:when>
							<c:otherwise>
								<textarea class="form-control" id="descripciondescargas"
									name="descripciondescargas">${data.descripciondescargas}</textarea>
							</c:otherwise>
						</c:choose>

					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Mencione todos los cambios
							en el proceso<br> que se han implementado desde la fecha de
							su primer solicitud<br> de registro de descarga ante Agua y
							Drenaje.
						</span>
						<c:choose>
							<c:when test="${empty data}">
								<textarea class="form-control" id="cambiosdescargas"
									name="cambiosdescargas"></textarea>
							</c:when>
							<c:otherwise>
								<textarea class="form-control" id="cambiosdescargas"
									name="cambiosdescargas">${data.cambiosdescargas}</textarea>

							</c:otherwise>
						</c:choose>


					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Fecha de Alta de Registro:</span>
						<c:choose>
							<c:when test="${empty data}">
								<input maxlength="100" type="text" class="form-control"
									id="fecha" name="fecha">
							</c:when>
							<c:otherwise>
								<input maxlength="100" type="text" class="form-control"
									id="fecha" name="fecha" value="${data.fecha}">
							</c:otherwise>
						</c:choose>

					</div>
					<br>
					<c:choose>
						<c:when test="${empty data}">
							<div class="input-group">
								<span class="input-group-addon"></span> <select id="estatus"
									name="estatus" class="form-control"></select>
							</div>

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