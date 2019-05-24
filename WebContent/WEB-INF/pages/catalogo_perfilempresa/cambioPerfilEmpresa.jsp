<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

	<!--  -->
			<div class="box  box-info">
                <div class="box-header with-border">
                  <h3 class="box-title">Cambios & Bajas Perfil Empresa</h3>
                  <div class="box-tools pull-right">
                  </div><!-- /.box-tools -->
                </div><!-- /.box-header -->
                <div class="tools">
	              	<button class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-md"><i class="fa fa-edit">Editar</i></button>
	              	<button type="button" class="btn btn-danger" data-toggle="modal" data-target=".bs-example-modal-sm"><i class="fa fa-trash-o">Eliminar</i></button>
                </div>
                <div class="box-body">
                  <table id="table" class="table table-bordered table-striped" cellspacing="0" width="100%">
                    <thead>
                      <tr>
                      	<th>#</th>
                        <th>Nombre Empresa</th>
                        <th>Representante Legal</th>
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
      							<h4 class="modal-title">Actualización Perfil de Empresa</h4>
      						</div>
      						<div class="modal-body" >
      							<div class="input-group">
                    				<span class="input-group-addon"><label for="idusuarios">Número de Perfil de Empresa</label></span>
                    					<input type="text" class="form-control" placeholder="Identificador de Empresa" id="idcatalogo_perfilempresa" name="idcatalogo_perfilempresa" readOnly="readonly">
                  				</div>
                  				<br>
      							<div class="input-group">
                    				<span class="input-group-addon"><label for="nombreEmpresa">Nombre Empresa</label></span>
                    				<input type="text" class="form-control" placeholder="Nombre de la Empresa" id="nombreEmpresa" name="nombreEmpresa" required>
                  				</div>
                  				<br>
                  				<div class="input-group">
                    				<span class="input-group-addon"><label for="representanteLegal">Representante Legal</label></span>
                    					<input type="text" class="form-control" placeholder="Representante legal" id="representanteLegal" name="representanteLegal" required>
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
 		    "sAjaxSource": "listaPerfilEmpresa",
 		    "fnInitComplete":function(oSettings, json){
 		    	$('#table tbody').on( 'click', 'tr', function () {
     				if ( $(this).hasClass('selected') ) {
     		        	$(this).removeClass('selected');
     		        }
     		        else {
     		        	$('.selected').removeClass('selected');
			            $(this).addClass('selected');
			           	var idprincipaltabla = table.fnGetData(this).idcatalogo_perfilempresa;
			           	$('#idcatalogo_perfilempresa').val(idprincipaltabla);
			           	consulta();
     		        }
     		    } );
 		    },
		      "aoColumns": [
					{ "mDataProp": 'idcatalogo_perfilempresa', "bVisible":false },
					{ "mDataProp": 'nombreEmpresa' },
					{ "mDataProp": 'representanteLegal' }
 		      ]
 		    });
    	
    	function exito(){
    		mensajeriaAlertas('Exito', 'En Modificación de Perfil de Empresa');
    		$('#modalModifica').modal('hide');
    		table.api().ajax.reload();
    	}
		function fallo(){
			mensajeriaAlertas('Error', 'En Modificación de Perfil de Empresa');
			table.api().ajax.reload();
    	}
        
		function modifica(){
			recursoTransaccion = 'actualizaPerfilEmpresa';
		}
		function consulta(){
 			$.ajax({
     			url:'consultaPerfilEmpresa', 
     			type:'GET', 
     			data: $("#formaValidate").serialize(), 
 	    		success: function(response){
 	    			$('#idcatalogo_perfilempresa').val(response.idcatalogo_perfilempresa);
 	    			$('#nombreEmpresa').val(response.nombreEmpresa);
 	    			$('#representanteLegal').val(response.representanteLegal);
 	    		},
 	    		error: function(e){
 	    		}
 	    		});
 		}
		
    	$(document).ready(function(){
    		$.validator.setDefaults({submitHandler: function() { transaccionDatos( recursoTransaccion, 'formaValidate', true, "exito()", "fallo()");}});
    		$('#formaValidate').validate(); 
    		
    	    $('#button').click( function () {
    	    	$.ajax({
        			url:'eliminaPerfilEmpresa', 
        			type:'GET', 
        			data:'idcatalogo_perfilempresa='+$('#idcatalogo_perfilempresa').val(),
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