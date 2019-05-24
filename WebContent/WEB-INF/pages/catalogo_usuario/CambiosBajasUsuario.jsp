<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

	<!--  -->
			<div class="box  box-info">
                <div class="box-header with-border">
                  <h3 class="box-title">Cambios & Bajas Usuarios</h3>
                  <div class="box-tools pull-right">
                  </div><!-- /.box-tools -->
                </div><!-- /.box-header -->
                <div class="tools">
	              	<button class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-md"><i class="fa fa-edit">Editar</i></button>
	              	<button type="button" class="btn btn-danger" data-toggle="modal" data-target=".bs-example-modal-sm"><i class="fa fa-trash-o">Eliminar</i></button>
                </div>
                <div class="box-body">
                  <table id="tableUsuarios" class="table table-bordered table-striped" cellspacing="0" width="100%">
                    <thead>
                      <tr>
                      	<th>#</th>
                        <th>Nickname</th>
                        <th>Nombre</th>
                        <th>Apellido P</th>
                        <th>Apellido M</th>
                        <th>Email</th>
                      </tr>
                    </thead>
                   
                  </table>
                </div><!-- /.box-body -->
              </div><!-- /.box -->
              <!-- modal actualizar -->
              	<div class="modal fade bs-example-modal-md" tabindex="-1" role="dialog" aria-labelledby="myNormalModalUpdateUsuarios" aria-hidden="true" id="modalModifica">
  					<div class="modal-dialog modal-md" >
    					<div class="modal-content">
    					<form role="form" id="formaValidate">
      						<div class="modal-header">
        						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
      							<h4 class="modal-title">Actualización Usuario</h4>
      						</div>
      						<div class="modal-body" >
      							<div class="input-group">
                    				<span class="input-group-addon"><label for="idusuarios">Número de Usuario</label></span>
                    					<input type="text" class="form-control" placeholder="Identificador de Usuario" id="idusuarios" name="idusuarios" readOnly="readonly">
                  				</div>
                  				<br>
      							<div class="input-group">
                    				<span class="input-group-addon"><label for="username">Usuario</label></span>
                    				<input type="text" class="form-control" placeholder="Usuario" id="username" name="username" readOnly="readonly">
                  				</div>
                  				<br>
                  				<div class="input-group">
                    				<span class="input-group-addon"><label for="nombre">Nombre</label></span>
                    					<input type="text" class="form-control" placeholder="Nombre" id="nombre" name="nombre" minlength="2" required>
                  				</div>
                  				<br>
                  				<div class="input-group">
                    				<span class="input-group-addon"><label for="apellidoPaterno">Apellido P</label></span>
                    				<input type="text" class="form-control" placeholder="Apellido Parterno" id="apellidoPaterno" name="apellidoPaterno">
                  				</div>
                  				<br>
                  				<div class="input-group">
                    				<span class="input-group-addon"><label for="apellidoMaterno">Apellido M</label></span>
                    				<input type="text" class="form-control" placeholder="Apellido Materno" id="apellidoMaterno" name="apellidoMaterno">
                  				</div>
                  				<br>
                  				<div class="input-group">
                    				<span class="input-group-addon"><label for="email">Email</label></span>
                    				<input type="email" class="form-control" placeholder="Correo Electrónico" id="email" name="email" required>
                  				</div>
                  				<br>
                  				<div class="input-group">
                    				<span class="input-group-addon"><label for="password">Pass</label></span>
                    				<input type="password" class="form-control" placeholder="Contraseña" id="password" name="password" required>
                  				</div>
                  				<br>
                  				<div class="input-group">
                    				<span class="input-group-addon"><label for="cpass">Confirma Pass</label></span>
                    				<input type="password" class="form-control" placeholder="Confirmación Contraseña" id="cpass" required equalTo="#password" >
									<input type="hidden" id="areaID" name="areaID"/>
									<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />                				
                  				</div>
                  			</div>
      						<div class="modal-footer">
        						<input type="submit" class="submit btn btn-primary" onClick="modificaUsuario()" value="Guardar"/>
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
        						<p>¿Desea eliminar el usuario?</p>
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
    	var table = $('#tableUsuarios').dataTable( {
 		    "sAjaxSource": "usuariosLista",
 		    "fnInitComplete":function(oSettings, json){
 		    	$('#tableUsuarios tbody').on( 'click', 'tr', function () {
     				if ( $(this).hasClass('selected') ) {
     		        	$(this).removeClass('selected');
     		        }
     		        else {
     		        	$('.selected').removeClass('selected');
			            $(this).addClass('selected');
			           	var idprincipaltabla = table.fnGetData(this).idusuarios;
			           	$('#idusuarios').val(idprincipaltabla);
			           	consultaUsuario();
     		        }
     		    } );
 		    },
		      "aoColumns": [
					{ "mDataProp": 'idusuarios' , "bVisible":false },
					{ "mDataProp": 'username' },
					{ "mDataProp": 'nombre' },
					{ "mDataProp": 'apellidoPaterno' },
					{ "mDataProp": 'apellidoMaterno' },
					{ "mDataProp": 'email' }
 		      ]
 		    });
    	
    	function exitoTransaccion(){
    		mensajeriaAlertas('Exito', 'En Modificación de Areas');
    		$('#modalModifica').modal('hide');
    		table.api().ajax.reload();
    	}
		function falloTransaccion(){
			mensajeriaAlertas('Error', 'En Modificación de Areas');
			table.api().ajax.reload();
    	}
        
		function modificaUsuario(){
			recursoTransaccion = 'updateUsuario';
		}
		function consultaUsuario(){
 			$.ajax({
     			url:'consultaUsuario', 
     			type:'GET', 
     			data: $("#formaValidate").serialize(), 
 	    		success: function(response){
 	    			$('#username').val(response.username);
 	    			$('#nombre').val(response.nombre);
 	    			$('#apellidoPaterno').val(response.apellidoPaterno);
 	    			$('#apellidoMaterno').val(response.apellidoMaterno);
 	    			$('#email').val(response.email);
 	    			$('#password').val(response.password);
 	    		},
 	    		error: function(e){
 	    		}
 	    		});
 		}
		
    	$(document).ready(function(){
    		$.validator.setDefaults({submitHandler: function() { transaccionDatos( recursoTransaccion, 'formaValidate', true, "exitoTransaccion()", "falloTransaccion()");}});
    		$('#formaValidate').validate(); 
    		
    	    $('#button').click( function () {
    	    	var id= $('#idusuarios').val();
    	    	//console.log(id);
    	    	$.ajax({
        			url:'deleteUsuario', 
        			type:'GET', 
        			data:'idusuarios='+id,
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