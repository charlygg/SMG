<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
    <div class="box  box-info">
                <div class="box-header with-border">
                  <h3 class="box-title">Cambios de Trámites</h3>
                  <div class="box-tools pull-right">
                  </div><!-- /.box-tools -->
                </div><!-- /.box-header -->
                <div class="tools">
	              	<button class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-mdTramite" id="abreModalEditar"><i class="fa fa-edit">Editar</i></button>
                </div>
                <div class="box-body">
				<table id="tableTramite" class="table table-bordered table-striped">
			       <thead>
                  		<tr>
                  			<th>#</th>
                  			<th>ID área</th>
                        	<th>Nombre de Área</th>
                        	<th>Nombre de Trámite</th>
                        	<th>Descripción</th>
                  		</tr>
                  	</thead>
				
				</table>
                </div><!-- /.box-body -->
              </div><!-- /.box -->
	          <!-- modal actualizar -->
              	<div class="modal fade bs-example-modal-mdTramite" tabindex="-1" role="dialog" aria-labelledby="myNormalModalUpdateTramite	" aria-hidden="true" id="modalModifica">
  					<div class="modal-dialog modal-md" >
    					<div class="modal-content">
    					<form role="form" id="formaValidateTramite">
      						<div class="modal-header">
        						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
      							<h4 class="modal-title">Actualización Trámite</h4>
      						</div>
      						<div class="modal-body" >
                 				<div class="input-group">
                    				<span class="input-group-addon"><label for="catalogoID">Trámite</label></span>
                    					<input type="text" class="form-control" id="catalogoID" name="catalogoID"  readonly="readonly">
                  				</div>
                  				<br>
                  				<div class="input-group">
                    				<span class="input-group-addon"><label for="areaID">Área ID</label></span>
                    				<input type="text" class="form-control" placeholder="Identificador de Area" id="areaID" name="areaID" readonly="readonly">
                  				</div>
                  				<br>
                  				<div class="input-group">
                    				<span class="input-group-addon"><label for="areaNombre">Nombre del Área</label></span>
                    				<input type="text" class="form-control" placeholder="Descripción de Area" id="areaNombre" name="areaNombre" readonly="readonly">
                  				</div>
                  				<br>
                  				<div class="input-group">
                    				<span class="input-group-addon"><label for="nombreTramite">Nombre del Trámite</label></span>
                    				<input type="text" class="form-control" placeholder="Descripción de Trámite" id="nombreTramite" name="nombreTramite" required>
                  				</div>
                  				<br>
                  				<div class="input-group">
                    				<span class="input-group-addon"><label for="descripcion">Descripción</label></span>
                    				<input type="text" class="form-control" placeholder="Descripción de Trámite" id="descripcion" name="descripcion" required>
                  				</div>
                  				<br>
                  			</div>
      						<div class="modal-footer">
        						<button type="submit" class="btn btn-primary" onclick="modificaTramite()">Guardar Trámite</button>
      						</div>
      						</form>
    					</div>
  					</div>
				</div>
              <!-- finaliza modal -->
              
              
    <script type="text/javascript">
    		var recursoTransaccion = '';
    		var  tablaTramites =  $('#tableTramite').dataTable( {
     		    "sAjaxSource": "getListaTramites",
     		    "fnInitComplete":function(oSettings, json){
     		    	$('#tableTramite tbody').on( 'click', 'tr', function () {
         				if ( $(this).hasClass('selected') ) {
         		        	$(this).removeClass('selected');
         		        }
         		        else {
         		        	$('.selected').removeClass('selected');
    			            $(this).addClass('selected');
    			           	var idprincipaltabla = tablaTramites.fnGetData(this).catalogoID;
    			           	$('#catalogoID').val(idprincipaltabla);
    			           	consultaTramite();
         		        }
         		    } );
     		    },
    		      "aoColumns": [
 					{ "mDataProp": 'catalogoID', "bVisible":false },
 					{ "mDataProp": 'areaID' ,"bVisible":false},
 					{ "mDataProp": 'areaNombre' },
 					{ "mDataProp": 'nombreTramite' },
 					{ "mDataProp": 'descripcion' }
	 		      ],
	 		     "columns": [
	 		                { "width": "20%" },
		 		            { "width": "20%" },
		 		            { "width": "20%" },
		 		            { "width": "20%" },
		 		            { "width": "20%" }
	 		              ]
     		    });
    		
        	function exitoTransaccion(){
        		mensajeriaAlertas('Exito', 'En Modificación de Catálogo Trámites');
        		$('#modalModifica').modal('hide');
        		tablaTramites.api().ajax.reload();
        	}
    		function falloTransaccion(){
    			mensajeriaAlertas('Error', 'En Modificación de Catálogo Trámites');
    			tablaTramites.api().ajax.reload();
        	}
    		
	    	function modificaTramite(){
	    		recursoTransaccion = 'updateTramite';
	 		}
	    	function consultaTramite(){
	    		 $.ajax({
	     			url:'consultaTramite', //Url a donde la enviaremos
	     			type:'GET', //Metodo que usaremo
	     			data: $("#formaValidateTramite").serialize(),
	     		success: function(response){
 	     			$('#areaID').val(response.areaID);
	     			$('#areaNombre').val(response.areaNombre);
	     			$('#nombreTramite').val(response.nombreTramite);
	     			$('#descripcion').val(response.descripcion);
	     		},
	     		error: function(e){
	     			console.log(e);
	     		}
	     		});
	 		}
    
	    	 $(document).ready(function(){
	    		$.validator.setDefaults({submitHandler: function() { transaccionDatos( recursoTransaccion, 'formaValidateTramite', true, "exitoTransaccion()", "falloTransaccion()");}});
	    	    $('#formaValidateTramite').validate();
	     	});
	    	 
</script>