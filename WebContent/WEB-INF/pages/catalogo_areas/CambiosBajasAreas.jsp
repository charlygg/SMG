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
                  <h3 class="box-title">Cambios & Bajas Areas</h3>
                  <div class="box-tools pull-right">
                  </div><!-- /.box-tools -->
                </div><!-- /.box-header -->
                <div class="tools">
	              	<button class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-mdArea"><i class="fa fa-edit">Editar</i></button>
<!-- 	              	<button type="button" class="btn btn-danger" data-toggle="modal" data-target=".bs-example-modal-smArea"><i class="fa fa-trash-o">Eliminar</i></button> -->
                </div>
                <div class="box-body">
                  <table id="tableAreas" class="table table-bordered table-striped">
                  	<thead>
                  		<tr>
                  			<th>#</th>
                        	<th>nombre</th>
                        	<th>descripcion</th>
                  		</tr>
                  	</thead>
   					<tbody>
   					</tbody>
                  </table>
                </div><!-- /.box-body -->
              </div><!-- /.box -->
	          <!-- modal actualizar -->
              	<div class="modal fade bs-example-modal-mdArea" tabindex="-1" role="dialog" aria-labelledby="myNormal" aria-hidden="true" id="modalModifica">
  					<div class="modal-dialog modal-md" >
    					<div class="modal-content">
						<form role="form" id="formaValidateArea">
      						<div class="modal-header">
        						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
      							<h4 class="modal-title">Actualización Área</h4>
      						</div>
      						<div class="modal-body" >
                 				<div class="input-group">
                    				<span class="input-group-addon"><label for="idareas">Identificador</label></span>
                    					<input type="text" class="form-control" id="idareas" name="idareas"  readonly="readonly">
                  				</div>
                  				<br>
                  				<div class="input-group">
                    				<span class="input-group-addon"><label for="nombre">Nombre de Area</label></span>
                    				<input type="text" class="form-control" placeholder="Nombre de Area" id="nombre" name="nombre" required>
                  				</div>
                  				<br>
                  				<div class="input-group">
                    				<span class="input-group-addon"><label for="descripcionArea">Descripción</label></span>
                    				<input type="text" class="form-control" placeholder="Descripción de Area" id="descripcion" name="descripcion" required>
                  				</div>
                  				<br>
                  			</div>
      						<div class="modal-footer">
        						<input type="submit" class="btn btn-primary"  onclick="modificaArea()" value="Guardar Area"/>
      						</div>
      						</form>
    					</div>
  					</div>
				</div>
              <!-- finaliza modal -->
              
              <!-- modal eliminar -->
<!--               	<div class="modal fade bs-example-modal-smArea" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true"> -->
<!--   					<div class="modal-dialog modal-sm"> -->
<!--     					<div class="modal-content"> -->
<!--       						<div class="modal-header"> -->
<!--         						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button> -->
<!--       						</div> -->
<!--       						<div class="modal-body"> -->
<!--         						<p>¿Desea eliminar el Area?</p> -->
<!--       						</div> -->
<!--       						<div class="modal-footer"> -->
<!--         					<button type="button" class="btn btn-default" data-dismiss="modal">No</button> -->
<!--         						<button type="button" class="btn btn-danger"  data-dismiss="modal" id="eliminaArea" >Eliminar</button> -->
<!--       						</div> -->
<!--     					</div> -->
<!--   					</div> -->
<!-- 				</div> -->
    <script type="text/javascript">
    	var recursoTransaccion = '';
    	var tablaAreasRef = $('#tableAreas').dataTable( {
 		    "sAjaxSource": "getListAreas",
 		    "fnInitComplete":function(oSettings, json){
 		    	$('#tableAreas tbody').on( 'click', 'tr', function () {
					if ( $(this).hasClass('selected') ) {
			        	$(this).removeClass('selected');
			        }
			        else {
			        	$('.selected').removeClass('selected');
			            $(this).addClass('selected');
			           	var idAreaentabla = tablaAreasRef.fnGetData(this).idareas;
			           	$('#idareas').val(idAreaentabla);
			           	consultaArea();
			        }
			    });
 		    },
		      "aoColumns": [
					{ "mDataProp": 'idareas', "bVisible":false },
					{ "mDataProp": 'nombre' },
					{ "mDataProp": 'descripcion' }
 		      ],
 		     "columns": [
 		                { "width": "10%" },
	 		            { "width": "10%" },
	 		            { "width": "20%" }
 		              ]
 		    });
    	
    	function exitoTransaccion(){
    		mensajeriaAlertas('Exito', 'En Modificación de Areas');
    		$('#modalModifica').modal('hide');
    		tablaAreasRef.api().ajax.reload();
    	}
		function falloTransaccion(){
			mensajeriaAlertas('Error', 'En Modificación de Areas');
			tablaAreasRef.api().ajax.reload();
    	}
    	
    
    	function modificaArea(){
    		recursoTransaccion = 'updateArea';
 		}
    	function consultaArea(){
 			$.ajax({
     			url:'consultaArea', 
     			type:'GET', 
     			data: $("#formaValidateArea").serialize(), 
 	    		success: function(response){
 	    			$('#nombre').val(response.nombre);
 	    			$('#descripcion').val(response.descripcion);
 	    		},
 	    		error: function(e){
 	    		}
 	    		});
 		}
    
	    	 $(document).ready(function(){
	    	 	$.validator.setDefaults({submitHandler: function() { transaccionDatos( recursoTransaccion, 'formaValidateArea', true, "exitoTransaccion()", "falloTransaccion()");}});
	    		$('#formaValidateArea').validate(); 
	    		 
	     	    $('#eliminaArea').click( function () {
	     	    	tablaAreasRef.row('.selected').remove().draw( false );
	     	    	$.ajax({
	        			url:'deleteArea', 
	        			type:'GET', 
	        			data:'idareas='+$('#idareas').val(),
	    	    		success: function(response){
	    	    		},
	    	    		error: function(e){
	    	    		},
	     	    		complete: function(){
	     	    			tablaAreasRef.api().ajax.reload();
	     	    		}
	    	    		});
	 		    } );
	     	});
	    	 
</script>