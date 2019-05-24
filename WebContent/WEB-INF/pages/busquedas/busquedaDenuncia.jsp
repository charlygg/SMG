<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

  <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <!-- Bootstrap 3.3.2 -->
    <link href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <!-- Font Awesome Icons -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Ionicons -->
    <link href="http://code.ionicframework.com/ionicons/2.0.0/css/ionicons.min.css" rel="stylesheet" type="text/css" />
    <!-- Theme style -->
    <link href="<%=request.getContextPath()%>/resources/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
    <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
          page. However, you can choose any other skin. Make sure you
          apply the skin class to the body tag so the changes take effect.
    -->
    <link href="<%=request.getContextPath()%>/resources/dist/css/skins/skin-blue.min.css" rel="stylesheet" type="text/css" />

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
	<!--  -->
	<div class="box  box-info">
                <div class="box-header with-border">
                  <h3 class="box-title">Busqueda Denuncias</h3>
                  <div class="box-tools pull-right">
                  </div><!-- /.box-tools -->
                </div><!-- /.box-header -->
                <div class="tools">
	              	<button class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-mdAMostrar"><i class="fa fa-edit">Mostrar</i></button>
                </div>
                <div class="box-body">
                	<div class="input-group">
	               		<span class="input-group-addon">Municipio</span>
	                    <select id="comboMunicipio" name="comboMunicipio" class="form-control">
	                    	<option value="">Escoja Una Opción</option>
							<c:forEach items="${listmunicipios}" var="municipio">
								<option value="${municipio}">${municipio}</option>
							</c:forEach>
						</select>
	             	</div>
					<br>
					<div class="input-group">
	               		<span class="input-group-addon">Colonia</span>
	                    <select id="comboColonia" name="comboColonia" class="form-control">
						</select>
	             	</div>
					<br>
                
                  <table id="tableDenuncias" class="table table-bordered table-striped">
                  	<thead>
                  		<tr>
                  			<th>Id Denuncia</th>
                  			<th>Descripción</th>
                  			<th>Dirección</th>
                  			<th>Tipo de Denuncia</th>
                        	<th>Nombre Denunciante</th>
                        </tr>
                  	</thead>
   					<tbody>
   					</tbody>
                  </table>
                </div><!-- /.box-body -->
              </div><!-- /.box -->
	          <!-- modal actualizar -->
              	<div class="modal fade bs-example-modal-mdAMostrar" tabindex="-1" role="dialog" aria-labelledby="myNormal" aria-hidden="true" id="modalModifica">
  					<div class="modal-dialog modal-md" >
    					<div class="modal-content">
						<form role="form" id="formaValidate">
      						<div class="modal-header">
        						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
      							<h4 class="modal-title">Muestra Denuncia</h4>
      						</div>
      						<div class="modal-body" >
      						<div class="box box-info">
      							
                				<div class="input-group" id="dividdenuncia">
				               		<span class="input-group-addon">Identificador de denuncia</span>
				                    <input type="text" class="form-control"  id="iddenuncia" name="iddenuncia"  disabled="disabled">
				             	</div>
								<br>
								<div class="input-group" >
				               		<span class="input-group-addon">Estatus de la denuncia</span>
				               		<input type="hidden" id="estatus" name="estatus" value="1">
				                    <input type="text" class="form-control"  id="nombreEstatus" name="nombreEstatus" readonly="readonly" >
				             	</div>
								<br>
								
				               	<div class="input-group">
				               		<span class="input-group-addon">Tipo de denuncia</span>
				                    <select id="catalogo_denuncias_idcatalogo_denuncias" name="catalogo_denuncias_idcatalogo_denuncias" class="form-control" disabled="disabled">
									</select>
				             	</div>
								<br>
				               	<!-- fin tipo denuncia -->
				               	<h4>Datos del denunciante</h4>
				               	<!-- Nombre -->
								<div class="input-group">
									<span class="input-group-addon">Nombre</span>
									<input type="text" class="form-control"  id="nombre" name="nombre" disabled="disabled">
								</div>
								<br>
								<!-- fin nombre -->
								<!-- direccion -->
								<div class="input-group">
									<span class="input-group-addon">Dirección</span>
									<input type="text" class="form-control"  id="direccion" name="direccion" disabled="disabled">
								</div>
								<br>
								<!-- fin direccion -->
								<!-- inicio telefono -->
								<div class="input-group">
									<span class="input-group-addon">Teléfono</span>
									<input type="text" class="form-control"  id="telefono" name="telefono" data-inputmask='"mask": "(999) 999-9999"' data-mask disabled="disabled"/>
								</div>
								<br>
								<!-- fin telefono -->
								<!-- correo electronico -->
								<div class="input-group">
									<span class="input-group-addon">Correo Electrónico</span>
									<input type="email" class="form-control" id="correo" name="correo" disabled="disabled">
								</div>
								<br>
								<!-- fin correo -->
								<!-- inicio anonimo -->
								<div class="checkbox">
									<label>
										<input type="checkbox" name="anonimo" id="anonimo" disabled="disabled"> Anónimo
									</label>
								</div>
								<br>
								<!-- fin anonimo -->
								<h4>Descripción de la denuncia</h4>
								<!-- inicio descripcion -->
								<div class="input-group">
									<span class="input-group-addon">Descripción</span>
									<textarea class="form-control" placeholder="Escriba" name="descripcion" id="descripcion" disabled="disabled"></textarea>
								</div>
								<br>
								<!-- fin descripcion  -->
								<h4>Ubicación de la denuncia</h4>
								<!-- inciio calle -->
								<div class="input-group">
									<span class="input-group-addon">Calle</span>
									<input type="text" class="form-control" id="calle" name="calle"  disabled="disabled">
								</div>
								<br>
								<!-- fin calle -->
								<!-- inicio num ext -->
								<div class="input-group">
									<span class="input-group-addon">Núm. Exterior</span>
									<input type="text" class="form-control" id="numero_ext" name="numero_ext" disabled="disabled">
								</div>
								<br>
								<!-- fin num ext -->
								<!-- inicio num int -->
								<div class="input-group">
									<span class="input-group-addon">Núm. Interior</span>
									<input type="text" class="form-control"  id="numero_int" name="numero_int" disabled="disabled">
								</div>
								<br>
								<!-- fin num int -->
								<!-- inicio colonia -->
								<div class="input-group">
									<span class="input-group-addon">Colonia</span>
									<input type="text" class="form-control"  id="colonia" name="colonia" disabled="disabled">
								</div>
								<br>
								<!-- fin colonia -->
								<!-- inicio ciudad -->
								<div class="input-group">
									<span class="input-group-addon">Ciudad</span>
									<input type="text" class="form-control"  id="ciudad" name="ciudad" disabled="disabled">
								</div>
								<br>
								<!-- fin ciudad -->
								<!-- inicio municipio -->
								<div class="input-group">
									<span class="input-group-addon">Municipio</span>
									<input type="text" class="form-control" id="municipio" name="municipio" disabled="disabled">
									<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
								</div>
								<br>
								
                  			</div>
                  			</div>
      						<div class="modal-footer">
      						</div>
      						</form>
    					</div>
  					</div>
				</div>
              <!-- finaliza modal -->
              
              <!-- modal eliminar -->
<script type="text/javascript">
	$(document).ready(function (){
		$('#comboMunicipio').change(function (){
			 $("#comboColonia").empty();
			    $.getJSON('getDenunciasComboColonia?municipio='+$("#comboMunicipio").val(),function(data){
		        $("#comboColonia").append("<option value=''>Escoja una opción</option>");
		        $.each(data, function(i,item){
		            $("#comboColonia").append("<option value=\""+item+"\">"+item+"</option>");
		        });
			});
		});
		$('#comboColonia').change(function(){
			tabla.api().ajax.reload();
		});
	});
	var tabla = $('#tableDenuncias').dataTable( {
	    "sAjaxSource": "getDenunciasList",
	    "fnServerParams": function ( aoData )   
		{
			aoData.push( { "name": "municipio", "value": $("#comboMunicipio").val() } );
			aoData.push( { "name": "colonia", "value": $("#comboColonia").val() } );
	    },
	    "fnInitComplete":function(oSettings, json){
	    	$('#tableDenuncias tbody').on( 'click', 'tr', function () {
				if ( $(this).hasClass('selected') ) {
		        	$(this).removeClass('selected');
		        }
		        else {
		        	$('.selected').removeClass('selected');
		            $(this).addClass('selected');
		           	var iddenuncia = tabla.fnGetData(this).iddenuncia;
		           	$('#iddenuncia').val(iddenuncia);
		           	consultaIdentificadorDenuncia(iddenuncia);
		        }
			});
	    },
      "aoColumns": [
			{ "mDataProp": 'iddenuncia'},
			{ "mDataProp": 'descripcion' },
			{ "mDataProp": 'direccion' },
			{ "mDataProp": 'tipo' },
			{ "mDataProp": 'nombre' }
		  ],
	     "columns": [
	                { "width": "10%" },
		            { "width": "10%" },
		            { "width": "10%" },
		            { "width": "20%" }
	              ]
	});
	listaCatDenuncia();
	function listaCatDenuncia(){
			$.ajax({
				url:'getListaCatDenuncias', 
				type:'GET', 
				data: 'role='+$("#rol_usuario").val(), 
	 		success: function(response){
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
	 function consultaIdentificadorDenuncia(denunciaIdentificador){
		setTimeout("$('#cajaLista').hide();", 200);
		if(isNaN(denunciaIdentificador) || denunciaIdentificador == '' || denunciaIdentificador == '0' ){
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
			$('#rolAgrego').val(response.rolAgrego);
 			
		}else{
			$.ajax({
				url:'consultaDenunciaSinrol', 
				type:'GET', 
				data: 'iddenuncia='+denunciaIdentificador, 
	 		success: function(response){
	 			$('#iddenuncia').val(response.iddenuncia);
	 			$('#nombre').val(response.nombre);
	 			$('#direccion').val(response.direccion);
	 			$('#telefono').val(response.telefono);
	 			$('#correo').val(response.correo);
	 			if(response.anonimo == 'on'){
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
	 			switch(response.estatus){
					case 1:
						$('#nombreEstatus').val('Nueva');
						break;
					case 2:
						$('#nombreEstatus').val('Recibido');
						break;
					case 3:
						$('#nombreEstatus').val('Proceso');
						break;
					case 4:
						$('#nombreEstatus').val('Documentación');
						break;
					case 5:
						$('#nombreEstatus').val('Terminado');
						break;
					default:
						$('#estatus').val('1');
						$('#nombreEstatus').val('Nueva');
				}
	 		},
	 		error: function(e){
	 		}
			});
		}
	 }

	 
	    	 
</script>