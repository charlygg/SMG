<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!-- InputMask -->
<!-- jQuery 2.1.3 -->
    
 <script type="text/javascript">
 $(document).ready(function() {
	 var recursoTransaccion = 'guardaActualizaDenuncia';
	 $.validator.setDefaults({submitHandler: function() { transaccionDatos( recursoTransaccion, 'formularioDenuncias', true, "exitoTransaccion()", "falloTransaccion()");}});
	 	$("#inputfile").fileinput({showCaption:false});
		listaCatDenuncia();
		$('#telefono').inputmask({mask: "(999) 999-9999"});  //static mask
		
		$('#actualizabtn').click(function (event){
   		 $('#tipoAct').val('1');
   		 $('#tipoTra').val('2');//actualizacion de estatus
   		 $('#tipoRol').val($("#rol_usuario").val());
   		 $('#usuario').val($("#usuario_id").val());
   		 $('#rolAgrego').val($("#rol_usuario").val());
   		});
    	$("#btn_enviar").click(function(event){
	   		 $('#tipoAct').val('0');
	   		 $('#tipoTra').val('1');//inserta y actualiza
			 $('#tipoRol').val($("#rol_usuario").val());
			 $('#usuario').val($("#usuario_id").val());
			 $('#rolAgrego').val($("#rol_usuario").val());
		});
    	//formularioDenuncias
    	$('#formularioDenuncias').validate();
    	$('#iddenuncia').bind('keyup',function(e){
   		  var camposLista = new Array();
   		  var parametrosLista = new Array();
   		  camposLista[0] = 'descripcion';
   		  parametrosLista[0] = $('#iddenuncia').val();
   		  camposLista[1] = 'tipoRol';
 		  parametrosLista[1] = $("#rol_usuario").val();
 		  camposLista[2] = 'onSelectFn';
		  parametrosLista[2] = 'consultaIdentificadorDenuncia';
		  
   		  listaGenerica('iddenuncia', '1', '1', camposLista, parametrosLista, 'listaBusquedaDenuncias');
	   	});

    	 $('#iddenuncia').blur(function(){consultaIdentificadorDenuncia($('#iddenuncia').val());});
      });
 function consultaIdentificadorDenuncia(denunciaIdentificador){
	setTimeout("$('#cajaLista').hide();", 200);
	console.log('entro por dividdenunciablur')
	if(isNaN(denunciaIdentificador.trim()) || denunciaIdentificador.trim() == '' || denunciaIdentificador.trim() == '0' ){
		$('#iddenuncia').val('0');
		$('#nombre').val('');
		$('#direccion').val('');
		$('#telefono').val('');
		$('#correo').val('');
		$('#anonimo').val('');
		$('#descripcion').val('');
		$('#calle').val('');
		$('#numero_int').val('');
		$('#numero_ext').val('');
		$('#colonia').val('');
		$('#ciudad').val('');
		$('#municipio').val('');
		$('#estatus').val('1');
		$('#nombreEstatus').val('Nuevo');
		document.getElementById('catalogo_denuncias_idcatalogo_denuncias').selectedIndex  = 0;
		$('#btn_enviar').prop('disabled',false);
		$('#actualizabtn').prop('disabled',true);
		$('#inputfile').prop('disabled',true);
	}else{
		$.ajax({
			url:'consultaDenuncia', 
			type:'GET', 
			data: 'iddenuncia='+denunciaIdentificador+'&tipoRol='+$("#rol_usuario").val(), 
 		success: function(response){
 			console.log('id denuncia ');
 			$('#iddenuncia').val(response.iddenuncia);
 			$('#nombre').val(response.nombre);
 			$('#direccion').val(response.direccion);
 			$('#telefono').val(response.telefono);
 			$('#correo').val(response.correo);
 			if(response.anonimo == 'on'){
 				console.log('chcked true');
 				$('#anonimo').prop('checked', true);
 			}
 			$('#descripcion').val(response.descripcion);
 			$('#calle').val(response.calle);
 			$('#numero_int').val(response.numero_int);
 			$('#numero_ext').val(response.numero_ext);
 			$('#colonia').val(response.colonia);
 			$('#ciudad').val(response.ciudad);
 			$('#municipio').val(response.municipio);
 			$('#catalogo_denuncias_idcatalogo_denuncias').val(response.catalogo_denuncias_idcatalogo_denuncias);
 			$('#estatus').val(response.estatus);
 			$('#rolAgrego').val(response.rolAgrego);
 			console.log('estatus es '+response.estatus);
 			switch(response.estatus){
 				case 1:
 					$('#nombreEstatus').val('Nueva');
 					$('#btn_enviar').prop('disabled',false);
 					$('#actualizabtn').prop('disabled',false);
 					$('#inputfile').prop('disabled',false);
 					break;
 				case 2:
 					$('#nombreEstatus').val('Recibido');
 					$('#btn_enviar').prop('disabled',false);
 					$('#actualizabtn').prop('disabled',false);
 					$('#inputfile').prop('disabled',false);
 					break;
 				case 3:
 					$('#nombreEstatus').val('Proceso');
 					$('#btn_enviar').prop('disabled',true);
 					$('#actualizabtn').prop('disabled',false);
 					$('#inputfile').prop('disabled',false);
 					break;
 				case 4:
 					$('#nombreEstatus').val('Documentación');
 					$('#btn_enviar').prop('disabled',true);
 					$('#actualizabtn').prop('disabled',false);
 					$('#inputfile').prop('disabled',false);
 					break;
 				case 5:
 					$('#nombreEstatus').val('Terminado');
 					$('#btn_enviar').prop('disabled',true);
 					$('#actualizabtn').prop('disabled',true);
 					$('#inputfile').prop('disabled',true);
 					break;
 				default:
 					$('#estatus').val('1');
 					$('#nombreEstatus').val('Nueva');
 					$('#btn_enviar').prop('disabled',true);
 					$('#actualizabtn').prop('disabled',true);
 					$('#inputfile').prop('disabled',true);
 					
 			}
 		},
 		error: function(e){
 		}
	    });
	}
 }
 
 function exitoTransaccion(){
		mensajeriaAlertas('Exito', 'En Transacción de Denuncias');
	}
	function falloTransaccion(){
		mensajeriaAlertas('Error', 'En Transacción de Denuncias');
	}
	
 function listaCatDenuncia(){
		$.ajax({
			url:'getListaCatDenuncias', 
			type:'GET', 
			data: 'role='+$("#rol_usuario").val(), 
 		success: function(response){
 			console.log('salida exitosa');
 			
 			var select = document.getElementById("catalogo_denuncias_idcatalogo_denuncias");
				while (select.length > 0) {
					select.remove(select.length-1);
 			}

 			for (var i=0; i < response.data.length; i++)
 			{
 			  var option = document.createElement("option");
 			  option.value = response.data[i].idcatalogo_denuncias;
 			  option.innerHTML = response.data[i].nombre_tramite;
 			  select.appendChild(option);
 			}
 		},
 		error: function(e){
 		}
	    });
	}
 
 //$("#input-700").fileinput({
	//    uploadUrl: "guardarImagen", // server upload action
	  //  uploadAsync: true,
	   // maxFileCount: 5
///	});

	</script>

 
<!-- Custom tabs (Charts with tabs)-->
<div class="row">
	<section class="col-lg-7 connectedSortable">
	<div class="box box-info">
                <div class="box-header with-border">
                  <h3 class="box-title">Denuncias</h3>
                </div>
                <div class="tools">
	              	 
                </div>
                
                <form id="formularioDenuncias" role="form" >
                <input type="hidden" id="tipoAct" name="tipoAct" value="0">
                <input type="hidden" id="tipoTra" name="tipoTra" value="0">
                <input type="hidden" id="tipoRol" name="tipoRol" value="">
                <input type="hidden" id="usuario" name="usuario" value="">
                <input type="hidden" id="rolAgrego" name="rolAgrego" value="">
                <div class="box-body">
               	
               	<!-- Tipo de denuncia -->
               	<div class="input-group" id="dividdenuncia">
               		<span class="input-group-addon">Identificador de denuncia</span>
                    <input type="text" class="form-control"  id="iddenuncia" name="iddenuncia" required >
             	</div>
				<br>
				<div class="input-group" >
               		<span class="input-group-addon">Estatus de la denuncia</span>
               		<input type="hidden" id="estatus" name="estatus" value="1">
                    <input type="text" class="form-control"  id="nombreEstatus" name="nombreEstatus" readonly="readonly">
             	</div>
				<br>
				
               	<div class="input-group">
               		<span class="input-group-addon">Tipo de denuncia</span>
                    <select id="catalogo_denuncias_idcatalogo_denuncias" name="catalogo_denuncias_idcatalogo_denuncias" class="form-control">
						<c:forEach items="${listdenuncias}" var="listdenuncia">
							<option value="${listdenuncia.idcatalogo_denuncias}">${listdenuncia.nombre_tramite}</option>
						</c:forEach>
					</select>
             	</div>
				<br>
               	<!-- fin tipo denuncia -->
               	<h4>Datos del denunciante</h4>
               	<!-- Nombre -->
				<div class="input-group">
					<span class="input-group-addon">Nombre</span>
					<input type="text" class="form-control"  id="nombre" name="nombre" required minlength="2">
				</div>
				<br>
				<!-- fin nombre -->
				<!-- direccion -->
				<div class="input-group">
					<span class="input-group-addon">Dirección</span>
					<input type="text" class="form-control"  id="direccion" name="direccion">
				</div>
				<br>
				<!-- fin direccion -->
				<!-- inicio telefono -->
				<div class="input-group">
					<span class="input-group-addon">Teléfono</span>
					<input type="text" class="form-control"  id="telefono" name="telefono" data-inputmask='"mask": "(999) 999-9999"' data-mask/>
				</div>
				<br>
				<!-- fin telefono -->
				<!-- correo electronico -->
				<div class="input-group">
					<span class="input-group-addon">Correo Electrónico</span>
					<input type="email" class="form-control" id="correo" name="correo" required minlength="2">
				</div>
				<br>
				<!-- fin correo -->
				<!-- inicio anonimo -->
				<div class="checkbox">
					<label>
						<input type="checkbox" name="anonimo" id="anonimo"> Anónimo
					</label>
				</div>
				<br>
				<!-- fin anonimo -->
				<h4>Descripción de la denuncia</h4>
				<!-- inicio descripcion -->
				<div class="input-group">
					<span class="input-group-addon">Descripción</span>
					<textarea class="form-control" placeholder="Escriba" name="descripcion" id="descripcion"></textarea>
				</div>
				<br>
				<!-- fin descripcion  -->
				<h4>Ubicación de la denuncia</h4>
				<!-- inciio calle -->
				<div class="input-group">
					<span class="input-group-addon">Calle</span>
					<input type="text" class="form-control" id="calle" name="calle" required >
				</div>
				<br>
				<!-- fin calle -->
				<!-- inicio num ext -->
				<div class="input-group">
					<span class="input-group-addon">Núm. Exterior</span>
					<input type="text" class="form-control" id="numero_ext" name="numero_ext" required minlength="3">
				</div>
				<br>
				<!-- fin num ext -->
				<!-- inicio num int -->
				<div class="input-group">
					<span class="input-group-addon">Núm. Interior</span>
					<input type="text" class="form-control"  id="numero_int" name="numero_int" required minlength="3">
				</div>
				<br>
				<!-- fin num int -->
				<!-- inicio colonia -->
				<div class="input-group">
					<span class="input-group-addon">Colonia</span>
					<input type="text" class="form-control"  id="colonia" name="colonia" required minlength="3">
				</div>
				<br>
				<!-- fin colonia -->
				<!-- inicio ciudad -->
				<div class="input-group">
					<span class="input-group-addon">Ciudad</span>
					<input type="text" class="form-control"  id="ciudad" name="ciudad" required minlength="3">
				</div>
				<br>
				<!-- fin ciudad -->
				<!-- inicio municipio -->
				<div class="input-group">
					<span class="input-group-addon">Municipio</span>
					<input type="text" class="form-control" id="municipio" name="municipio" required minlength="3">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</div>
				<br>
				<!-- fin municipio -->
                </div><!-- /.box-body -->
                <div class="box-footer">
                    <button id="btn_enviar" type="submit" class="btn btn-primary" >Guardar</button>
                    <button id="actualizabtn" type="submit" class="btn btn-primary" id="">Siguiente Estatus</button>
                </div>
                </form>
                <!-- <input id="input-700" name="kartik-input-700[]" type="file" multiple class="file-loading"> -->
              </div><!-- /.box -->
	</section>
	<section class="col-lg-7 connectedSortable">
	</section>
</div>
              