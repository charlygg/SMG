<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

<script type="text/javascript">
// $("#f_recepcion_tramite").inputmask("d/m/y",{ "placeholder": "dd/mm/yyyy" });
// $("#f_tramite_concluido").inputmask("d/m/y",{ "placeholder": "dd/mm/yyyy" });	

$("#f_recepcion_tramite").datepicker({dateFormat: "dd/mm/yy"});
$("#f_tramite_concluido").datepicker({dateFormat: "dd/mm/yy"});

$("#idempresa").change(function() {
    $("#idestablecimiento").empty();
    $("#idestablecimientomens").empty();
    
    $.getJSON('getArrayEstablecimientosPorEmpresa?idempresa='+$("#idempresa").val(),function(data){
        console.log(JSON.stringify(data));
        $('#DatosEstablecimiento').prop( "hidden", true );
        $("#idestablecimiento").append("<option value=''>Escoja una opción</option>");
        $.each(data, function(i,item){
        	 console.log(item.idcatalogo_perfilestablecimiento);
            $("#idestablecimiento").append("<option value=\""+item.idcatalogo_perfilestablecimiento+"\">"+item.idcatalogo_perfilestablecimiento+"/"+item.colonia+"/"+item.municipio+"</option>");
        });
        $('#idestablecimiento').prop( "disabled", false );
        
        $('#establecimientomensajeria').prop( "hidden", true );
        $("#idestablecimientomens").append("<option value=''>Escoja una opción</option>");
        $.each(data, function(i,item){
        	 console.log(item.idcatalogo_perfilestablecimiento);
            $("#idestablecimientomens").append("<option value=\""+item.idcatalogo_perfilestablecimiento+"\">"+item.idcatalogo_perfilestablecimiento+"/"+item.colonia+"/"+item.municipio+"</option>");
        });
        $('#idestablecimientomens').prop( "disabled", false );
    });
});

$("#idestablecimiento").change(function() {
    $.getJSON('getEstablecimientosByID?idestablecimiento='+$("#idestablecimiento").val(),function(data){
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
});


$("#idestablecimientomens").change(function() {
    $.getJSON('getEstablecimientosByID?idestablecimiento='+$("#idestablecimientomens").val(),function(data){
        console.log(JSON.stringify(data));
        $('#calles').val(data.calle);
        $('#numeroExteriors').val(data.numeroExterior);
        $('#numeroInteriors').val(data.numeroInterior);
        $('#colonias').val(data.colonia);
        $('#municipios').val(data.municipio);
        $('#estados').val(data.estado);
        $('#latituds').val(data.latitud);
        $('#longituds').val(data.longitud);
        $('#establecimientomensajeria').prop( "hidden", false );
    });
});

$("#idestablecimientomens").change(function() {
	llenaridestablecimientomens($("#idestablecimientomens").val());
});

$("#idtramite").change(function() {
	comboEstatus();
    $.getJSON('consultaTramite_ubiopermaintrellsaniconfnormofimex?idtramite='+$("#idtramite").val(),function(data){
    	$('#idempresa > option[value="'+data.idempresa+'"]').attr('selected', 'selected');
    	///LLenas catalogo de establecimientos
    		 $.getJSON('getArrayEstablecimientosPorEmpresa?idempresa='+$("#idempresa").val(),function(lista){
				console.log(JSON.stringify(lista));
				$.each(lista, function(i,item){
    			$("#idestablecimiento").append("<option value=\""+item.idcatalogo_perfilestablecimiento+"\">"+item.idcatalogo_perfilestablecimiento+"/"+item.colonia+"/"+item.municipio+"</option>");
    			$("#idestablecimientomens").append("<option value=\""+item.idcatalogo_perfilestablecimiento+"\">"+item.idcatalogo_perfilestablecimiento+"/"+item.colonia+"/"+item.municipio+"</option>");
				});
				 $('#idestablecimientomens').prop( "disabled", false );
				 $('#idestablecimiento').prop( "disabled", false );
				 $('#idestablecimiento > option[value="'+data.idestablecimiento+'"]').attr('selected', 'selected');
			    	$('#idestablecimientomens > option[value="'+data.idestablecimientomens+'"]').attr('selected', 'selected');
		});
    		 llenaridestablecimiento(data.idestablecimiento);
    		 llenaridestablecimientomens(data.idestablecimientomens);
    	
    		 $('#f_recepcion_tramite').val(data.f_recepcion_tramite);
			 $('#f_tramite_concluido').val(data.f_tramite_concluido);	
    	$('#asunto').val(data.asunto);
    	$('#cp').val(data.cp);
        $('#nombreconp').val(data.nombreconp);
        $('#rfcp').val(data.rfcp);
        $('#ladap').val(data.ladap);
        $('#telefonop').val(data.telefonop);
        $('#extensionp').val(data.extensionp);
        $('#emailp').val(data.emailp);
        $('#idestablecimientomens').val(data.idestablecimientomens);
        $('#cps').val(data.cps);
        $('#nombrecons').val(data.nombrecons);
        $('#rfcs').val(data.rfcs);
        $('#ladas').val(data.ladas);
        $('#telefonos').val(data.telefonos);
        $('#extensions').val(data.extensions);
        $('#emails').val(data.emails);
        $('#giro').val(data.giro);
        $('#especificar').val(data.especificar);
        $('#productofinal').val(data.productofinal);
        
        
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
		$.validator.setDefaults({submitHandler: function() { transaccionDatosRetornoID( 'registerTramite_ubiopermaintrellsaniconfnormofimex', 'formulario', true, "exito()", "fallo()");}});
		$('#formulario').validate();
		comboListaTramite();
		comboEstatus();
});
	function comboEstatus(){
		$("#estatus").empty();
		if($("#rol_usuario").val() == 'ROLE_RECEP'){
        	$("#estatus").append("<option value='1'>Nuevo</option>");	
        }
    }
	function comboListaTramite(){
		$('#idtramite').empty();
		$.getJSON('listacomboTramite_ubiopermaintrellsaniconfnormofimex?rol_usuario='+$("#rol_usuario").val(),function(data){
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
	function exito(){
// 		mensajeriaAlertas('Exito', 'En Alta de Trámite Ubicación, operación y manejo integral de un relleno sanitario, conforme a las Normas Oficiales Mexicanas y demás ordenamientos aplicables.');
		comboListaTramite();
		$('#DatosEstablecimiento').hide();
		$('#idtramite').eq(1).prop('selected', true);
		$('#idempresa').eq(1).prop('selected', true);
		$("#idestablecimiento").eq(1).prop('selected', true);
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
		mensajeriaAlertas('Error', 'En Alta de Trámite Ubicación, operación y manejo integral de un relleno sanitario, conforme a las Normas Oficiales Mexicanas y demós ordenamientos aplicables.');
		$('#DatosEstablecimiento').hide();
		$('#idtramite').eq(1).prop('selected', true);
		$('#idempresa').eq(1).prop('selected', true);
		$('#idempresa').change()
		$("#idestablecimiento").eq(1).prop('selected', true);
		document.getElementById("idempresa").selectedIndex = 0;
		document.getElementById("idestablecimiento").selectedIndex = -1;
		document.getElementById("idestablecimientomens").selectedIndex = -1;
		document.getElementById("estatus").selectedIndex = 0;
		$('#divCargaBitacora').hide();
		$('#divCargaBitacora').empty();
	}
	
	
	
	console.log("busquedaTramite "+$("#busquedaTramite").val());
	if($("#busquedaTramite").val() != 0){
		console.log("entro busquedaTramite ");
		 $.getJSON('consultaTramite_ubiopermaintrellsaniconfnormofimex?idtramite='+$("#busquedaTramite").val(),function(data){
		    	$('#idempresa > option[value="'+data.idempresa+'"]').attr('selected', 'selected');
		    	///LLenas catalogo de establecimientos
		    		 $.getJSON('getArrayEstablecimientosPorEmpresa?idempresa='+$("#idempresa").val(),function(lista){
						console.log(JSON.stringify(lista));
						$.each(lista, function(i,item){
		    			$("#idestablecimiento").append("<option value=\""+item.idcatalogo_perfilestablecimiento+"\">"+item.idcatalogo_perfilestablecimiento+"/"+item.colonia+"/"+item.municipio+"</option>");
		    			$("#idestablecimientomens").append("<option value=\""+item.idcatalogo_perfilestablecimiento+"\">"+item.idcatalogo_perfilestablecimiento+"/"+item.colonia+"/"+item.municipio+"</option>");
						});
						 $('#idestablecimientomens').prop( "disabled", false );
						 $('#idestablecimiento').prop( "disabled", false );
						 $('#idestablecimiento > option[value="'+data.idestablecimiento+'"]').attr('selected', 'selected');
					    	$('#idestablecimientomens > option[value="'+data.idestablecimientomens+'"]').attr('selected', 'selected');
				});
		    
		    	
		    		 $('#f_recepcion_tramite').val(data.f_recepcion_tramite);
					 $('#f_tramite_concluido').val(data.f_tramite_concluido);	
		    	$('#cp').val(data.cp);
		        $('#nombreconp').val(data.nombreconp);
		        $('#rfcp').val(data.rfcp);
		        $('#ladap').val(data.ladap);
		        $('#telefonop').val(data.telefonop);
		        $('#extensionp').val(data.extensionp);
		        $('#emailp').val(data.emailp);
		        $('#idestablecimientomens').val(data.idestablecimientomens);
		        $('#cps').val(data.cps);
		        $('#nombrecons').val(data.nombrecons);
		        $('#rfcs').val(data.rfcs);
		        $('#ladas').val(data.ladas);
		        $('#telefonos').val(data.telefonos);
		        $('#extensions').val(data.extensions);
		        $('#emails').val(data.emails);
		        $('#giro').val(data.giro);
		        $('#especificar').val(data.especificar);
		        $('#productofinal').val(data.productofinal);
		        
		        
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
					un relleno sanitario, conforme a las Normas Oficiales Mexicanas y
					demós ordenamientos aplicables.</h3>
			</div>

			<div class="box-body">
				<!-- elemntos que se cambian por tramite -->
				<input type="hidden" id="areaNumOficio" value="RME"> <input
					type="hidden" id="titleNumOficio"
					value="Tramite Ubicación, operación y manejo integral de un relleno sanitario, conforme a las Normas Oficiales Mexicanas y demós ordenamientos aplicables">
				<input type="hidden" id="tipoTramiteNumOficio" value="31">
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
						</c:when>
					</c:choose>
					<!-- UUID clave archivos -->

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
						<span class="input-group-addon">Domicilio de la planta o
							negociación(Establecimiento)</span> <select id="idestablecimiento"
							name="idestablecimiento" class="form-control" disabled="disabled"
							required>
						</select>
					</div>
					<br>
					<!-- inicia bloque oculto -->
					<div id="DatosEstablecimiento" class="container" hidden>
						<h3 class="box-title">Domicilio:</h3>


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
								maxlength="100" type="text" id="municipio" class="form-control"
								readonly>
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
								class="form-control">
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
					</div>
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
						<span class="input-group-addon">Domicilio para oír y/o
							recibir notificaciones (omitir en caso que sea el mismo de la
							planta):</span> <select id="idestablecimientomens"
							name="idestablecimientomens" class="form-control" required>
						</select>
					</div>
					<div id="establecimientomensajeria" class="container"
						hidden="hidden">

						<h3 class="box-title">Domicilio:</h3>

						<div class="input-group">
							<span class="input-group-addon">Calle</span> <input
								maxlength="100" type="text" id="calles" class="form-control"
								readonly>
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon">Número Exterior</span> <input
								maxlength="100" type="text" id="numeroExteriors"
								class="form-control" readonly>
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon">Número Interior</span> <input
								maxlength="100" type="text" id="numeroInteriors"
								class="form-control" readonly>
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon">Colonia</span> <input
								maxlength="100" type="text" id="colonias" class="form-control"
								readonly>
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon">Municipio</span> <input
								maxlength="100" type="text" id="municipios" class="form-control"
								readonly>
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon">Estado</span> <input
								maxlength="100" type="text" id="estados" class="form-control"
								readonly>
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon">Código Postal</span> <input
								maxlength="100" type="text" id="cps" name="cps"
								class="form-control">
						</div>
						<br>

						<div class="input-group">
							<span class="input-group-addon">Latitud</span> <input
								maxlength="100" type="text" id="latituds" class="form-control"
								readonly>
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon">Longitud</span> <input
								maxlength="100" type="text" id="longituds" class="form-control"
								readonly>
						</div>
					</div>
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
						de un relleno sanitario, conforme a las Normas</h3>


					<div class="input-group">
						<span class="input-group-addon"></span> <select id="estatus"
							name="estatus" class="form-control"></select>
					</div>
					<!-- Archivo -->
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