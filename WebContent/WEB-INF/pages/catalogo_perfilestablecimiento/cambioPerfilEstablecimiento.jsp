<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

	<!--  -->
			<div class="box  box-info">
                <div class="box-header with-border">
                  <h3 class="box-title">Cambios & Bajas Perfil Establecimiento</h3>
                  <div class="box-tools pull-right">
                  </div><!-- /.box-tools -->
                </div><!-- /.box-header -->
                <div class="tools">
	              	<button class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-md"><i class="fa fa-edit">Editar</i></button>
	              	<button type="button" class="btn btn-danger" data-toggle="modal" data-target=".bs-example-modal-sm"><i class="fa fa-trash-o">Eliminar</i></button>
                </div>
                <div class="box-body" style="overflow-x:auto">
                  <table id="table" class="table table-bordered table-striped">
                    <thead>
                      <tr>	
                      	<th>#</th>
                      	<th>Id de Empresa</th>
                        <th>Nombre Empresa</th>
                        <th>Calle</th>
                        <th>Exterior</th>
                        <th>Interior</th>
                        <th>Colonia</th>
                        <th>Municipio</th>
                        <th>Estado</th>
                        <th>Lat</th>
                        <th>Long</th>
                        <th>email</th>
                        <th>tel</th>
                        <th>matriz</th>
                      </tr>
                    </thead>
                  </table>
                </div><!-- /.box-body -->
              </div><!-- /.box -->
              <!-- modal actualizar -->
              	<div class="modal fade bs-example-modal-md" tabindex="-1" role="dialog" aria-labelledby="myNormalModalUpdate" aria-hidden="true" id="modalModifica">
  					<div class="modal-dialog modal-md" >
    					<div class="modal-content">
    					<form role="form" id="formaValidate">
      						<div class="modal-header">
        						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
      							<h4 class="modal-title">Actualización Perfil de Establecimiento</h4>
      						</div>
      						<div class="modal-body" >
      							<div class="input-group">
                    				<span class="input-group-addon"><label for="idusuarios">Número de Perfil de Establecimiento</label></span>
                    				<input type="text" class="form-control" placeholder="Identificador de Eestablecimiento" id="idcatalogo_perfilestablecimiento" name="idcatalogo_perfilestablecimiento" readOnly="readonly">
                    			</div>
                  				<br>
                  <div class="input-group">
                    <span class="input-group-addon">Número de Empresa</span>
                    <input type="text" class="form-control" placeholder="Número de Empresa relacionada" id="idcatalogo_perfilempresa" name="idcatalogo_perfilempresa" required >
                  </div>
                  <br>
				 <div class="input-group">
                    <span class="input-group-addon">Nombre de Empresa</span>
                    <input type="text" class="form-control" placeholder="Nombre Empresa" id="nombreEmpresa" name="nombreEmpresa"  >
                  </div>
                  <br>
                  <div class="input-group">
                    <span class="input-group-addon">Email</span>
                    <input type="text" class="form-control" placeholder="Correo Electrónico" id="email" name="email"  >
                  </div>
                  <br>
                  <div class="input-group">
                    <span class="input-group-addon">Teléfono</span>
                    <input type="text" class="form-control" placeholder="Teléfono del Establecimiento" id="telefono" name="telefono"  >
                  </div>
                  <br>
                  <div class="input-group">
                    <span class="input-group-addon">Matriz</span>
                    <input type="checkbox" id="matriz" name="matriz"  >
                  </div>
                  <br>
                  <h3>Dirección</h3>
                  <div class="input-group">
                    <span class="input-group-addon">Calle</span>
                    <input type="text" class="form-control" placeholder="Calle" id="calle" name="calle">
                  </div>
                   <br>
                   <div class="input-group">
                    <span class="input-group-addon">Número Exterior</span>
                    <input type="text" class="form-control" placeholder="Número Exterior" id="numeroExterior" name="numeroExterior">
                  </div>
                   <br>
                   <div class="input-group">
                    <span class="input-group-addon">Número Interior</span>
                    <input type="text" class="form-control" placeholder="Número Interior" id="numeroInterior" name="numeroInterior">
                  </div>
                   <br>
                   <div class="input-group">
                    <span class="input-group-addon">Colonia</span>
                    <input type="text" class="form-control" placeholder="Colonia" id="colonia" name="colonia" >
                  </div>
                   <br>
                   <div class="input-group">
                    <span class="input-group-addon">Municipio</span>
                    <input type="text" class="form-control" placeholder="Municipio" id="municipio" name="municipio" >
                  </div>
                   <br>
                   <div class="input-group">
                    <span class="input-group-addon">Estado</span>
                    <input type="text" class="form-control" placeholder="Estado" id="estado" name="estado" >
                  </div>
                   <br>
                   <h3>Coordenadas</h3>
                   <div class="input-group">
                    <span class="input-group-addon">Latitud</span>
                    <input type="text" class="form-control" placeholder="Latitud" id="latitud" name="latitud" >
                  </div>
                   <br>
                   <div class="input-group">
                    <span class="input-group-addon">Longitud</span>
                    <input type="text" class="form-control" placeholder="Longitud" id="longitud" name="longitud" >
                  </div>
                   <br>

                  			</div>
      						<div class="modal-footer">
        						<input type="submit" class="submit btn btn-primary" onClick="modifica()" value="Guardar"/>
      						</div>
      						</form>
    					</div>
  					</div>
				</div>
              <!-- finaliza modal -->
              <!-- modal eliminar -->
              	<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
  					<div class="modal-dialog modal-sm">
    					<div class="modal-content">
      						<div class="modal-header">
        						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
      						</div>
      						<div class="modal-body">
      						<input type="hidden" id="idusuarios"  /> 
        						<p>¿Desea eliminar el Registro?</p>
      						</div>
      						<div class="modal-footer">
        					<button type="button" class="btn btn-default" data-dismiss="modal">No</button>
        						<button id="button" type="button" class="btn btn-danger"  data-dismiss="modal">Eliminar</button>
      						</div>
    					</div>
  					</div>
				</div>
              <!-- termina modal -->
        <script type="text/javascript">
        var recursoTransaccion = '';
    	var table = $('#table').dataTable( {
 		    "sAjaxSource": "listaPerfilEstablecimiento",
 		    "fnInitComplete":function(oSettings, json){
 		    	$('#table tbody').on( 'click', 'tr', function () {
     				if ( $(this).hasClass('selected') ) {
     		        	$(this).removeClass('selected');
     		        }
     		        else {
     		        	$('.selected').removeClass('selected');
			            $(this).addClass('selected');
			           	var idprincipaltabla = table.fnGetData(this).idcatalogo_perfilestablecimiento;
			           	$('#idcatalogo_perfilestablecimiento').val(idprincipaltabla);
			           	consulta();
     		        }
     		    } );
 		    },
		      "aoColumns": [
					{ "mDataProp": 'idcatalogo_perfilestablecimiento', "bVisible":false },
					{ "mDataProp": 'idcatalogo_perfilempresa', "bVisible":false },
					{ "mDataProp": 'nombreEmpresa'},
					{ "mDataProp": 'calle' },
					{ "mDataProp": 'numeroExterior' },
					{ "mDataProp": 'numeroInterior' },
					{ "mDataProp": 'colonia' },
					{ "mDataProp": 'municipio' },
					{ "mDataProp": 'estado' },
					{ "mDataProp": 'latitud' },
					{ "mDataProp": 'longitud' },
					{ "mDataProp": 'email' },
					{ "mDataProp": 'telefono' },
					{ "mDataProp": 'matriz' }
		      ]
 		    });
    	
    	function exito(){
    		mensajeriaAlertas('Exito', 'En Modificación de Perfil de Establecimiento');
    		$('#modalModifica').modal('hide');
    		table.api().ajax.reload();
    	}
		function fallo(){
			mensajeriaAlertas('Error', 'En Modificación de Perfil de Establecimiento');
			table.api().ajax.reload();
    	}
        
		function modifica(){
			recursoTransaccion = 'actualizaPerfilEstablecimiento';
		}
		function consulta(){
 			$.ajax({
     			url:'consultaPerfilEstablecimiento', 
     			type:'GET', 
     			data: $("#formaValidate").serialize(), 
 	    		success: function(response){
 	    			$('#idcatalogo_perfilestablecimiento').val(response.idcatalogo_perfilestablecimiento);
 	    			$('#idcatalogo_perfilempresa').val(response.idcatalogo_perfilempresa);
 	    			$('#nombreEmpresa').val(response.nombreEmpresa);
 	    			$('#calle').val(response.calle);
 	    			$('#numeroExterior').val(response.numeroExterior);
 	    			$('#numeroInterior').val(response.numeroInterior);
 	    			$('#colonia').val(response.colonia);
 	    			$('#municipio').val(response.municipio);
 	    			$('#estado').val(response.estado);
 	    			$('#latitud').val(response.latitud);
 	    			$('#longitud').val(response.longitud);
 	    			$('#matriz').val(response.matriz);
 	    			$('#email').val(response.email);
 	    			$('#telefono').val(response.telefono);
 	    		},
 	    		error: function(e){
 	    		}
 	    		});
 		}
		
    	$(document).ready(function(){
    		$.validator.setDefaults({submitHandler: function() { transaccionDatos( recursoTransaccion, 'formaValidate', true, "exito()", "fallo()");}});
    		$('#formaValidate').validate(); 
    		
    	    $('#button').click( function () {
    	    	//console.log(id);
    	    	$.ajax({
        			url:'eliminaPerfilEstablecimiento', 
        			type:'GET', 
        			data:'idcatalogo_perfilestablecimiento='+$('#idcatalogo_perfilestablecimiento').val(),
    	    		success: function(response){
    	    		},
    	    		error: function(e){
    	    		},
     	    		complete: function(){
     	    			table.api().ajax.reload();
     	    		}
    	    		});
		        table.row('.selected').remove().draw( false );
		    } );
    	    
    	});
</script>