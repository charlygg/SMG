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
                  <h3 class="box-title">Cambios & Bajas Denuncias</h3>
                  <div class="box-tools pull-right">
                  </div><!-- /.box-tools -->
                </div><!-- /.box-header -->
                <div class="tools">
	              	<button class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-mdArea"><i class="fa fa-edit">Editar</i></button>
                </div>
                <div class="box-body">
                  <table id="table_cat_denuncias" class="table table-bordered table-striped">
                  	<thead>
                  		<tr>
                  			<th>idcatalogo_denuncias</th>
                        	<th>nombre_tramite</th>
                        	<th>descripcion</th>
                        	<th>area</th>
                  		</tr>
                  	</thead>
   					<tbody>
   					</tbody>
                 
                  </table>
                </div><!-- /.box-body -->
              </div><!-- /.box -->
	
              <!-- modal actualizar -->
              	<div class="modal fade bs-example-modal-mdArea" tabindex="-1" role="dialog" aria-labelledby="myNormalModalUpdateUsuarios" aria-hidden="true" id="modalModifica">
  					<div class="modal-dialog modal-md" >
    					<div class="modal-content">
    					<form role="form" id="formaValidateDenuncia">
      						<div class="modal-header">
        						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
      							<h4 class="modal-title">Actualización Denuncia</h4>
      						</div>
      						<div class="modal-body" >
                 				<div class="input-group">
                    				<span class="input-group-addon"><label for="idcatalogo_denuncias">Identificador</label></span>
                    					<input type="text" class="form-control" id="idcatalogo_denuncias" name="idcatalogo_denuncias"  readonly="readonly">
                  				</div>
                  				<br>
                  				<div class="input-group">
                    				<span class="input-group-addon"><label for="nombre_tramite">Nombre de tramite</label></span>
                    				<input type="text" class="form-control" placeholder="Nombre de tramite" id="nombre_tramite" name="nombre_tramite" required>
                  				</div>
                  				<br>
                  				<div class="input-group">
                    				<span class="input-group-addon"><label for="descripcion">Descripción</label></span>
                    				<input type="text" class="form-control" placeholder="Descripción" id="descripcion" name="descripcion" required>
                  				</div>
                  				<br>
                  				<div class="input-group">
                    				<span class="input-group-addon"><label for="area">Area</label></span>
                    					<input type="text" class="form-control" id="area" name="area"  readonly="readonly">
                    					<input type="hidden" id="area_idarea" name="area_idarea" value="">
                  				</div>
                  				<br>
                  			</div>
      						<div class="modal-footer">
        						<input type="submit" class="btn btn-primary" onclick="modificarDenuncia()" value="Guardar Denuncia"/>
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
<!--         						<p>¿Desea eliminar la denuncia?</p> -->
<!--       						</div> -->
<!--       						<div class="modal-footer"> -->
<!--         					<button type="button" class="btn btn-default" data-dismiss="modal">No</button> -->
<!--         						<button type="button" class="btn btn-danger"  data-dismiss="modal" id="eliminaDenuncia" >Eliminar</button> -->
<!--       						</div> -->
<!--     					</div> -->
<!--   					</div> -->
<!-- 				</div> -->
    <script type="text/javascript">
    		var recursoTransaccion = '';
    		var tabla = $('#table_cat_denuncias')
    				.dataTable({
    					processing: true,
    			        serverSide: false,
    			        ajax : {
    		            	url: "getListaCatDenuncias",
    		            	type : "GET"
    		        },
    		        "fnInitComplete":function(oSettings, json){
    		        	$('#table_cat_denuncias tbody').on( 'click', 'tr', function () {
    	    				if ( $(this).hasClass('selected') ) {
    	    		        	$(this).removeClass('selected');
    	    		        }
    	    		        else {
    	    		        	$('.selected').removeClass('selected');
        			            $(this).addClass('selected');
        			           	var idprincipaltabla = tabla.fnGetData(this).idcatalogo_denuncias;
        			           	$('#idcatalogo_denuncias').val(idprincipaltabla);
        			           	consultaDenuncia();
    	    		        }
    	    		    });
    	 		    },
    					columns:[
							{ data: 'idcatalogo_denuncias', "bVisible":false },
							{ data: 'nombre_tramite' },
							{ data: 'descripcion' },
							{ data: 'area' }
    					         ]
    				});
    			function exitoTransaccion(){
    	    		mensajeriaAlertas('Exito', 'En Modificación de Denuncias');
    	    		$('#modalModifica').modal('hide');
    	    		tabla.api().ajax.reload();
    	    	}
    			function falloTransaccion(){
    				mensajeriaAlertas('Error', 'En Modificación de Denuncias');
    				tabla.api().ajax.reload();
    	    	}
    	    	function modificarDenuncia(){
	    		 recursoTransaccion = 'updateCatDenuncias';
	   	 		}

			function consultaDenuncia(){
	  			$.ajax({
	      			url:'busquedaCatDenuncias', 
	      			type:'GET', 
	      			data: $("#formaValidateDenuncia").serialize(), 
	  	    		success: function(response){
	  	    			$('#idcatalogo_denuncias').val(response.idcatalogo_denuncias);
	  	    			$('#nombre_tramite').val(response.nombre_tramite);
	  	    			$('#descripcion').val(response.descripcion);
	  	    			$('#area').val(response.area);
	  	    			if(isNaN(response.area_idarea)){
	  	    				$('#area_idarea').val('0');	
	  	    			}else{
	  	    				$('#area_idarea').val(response.area_idarea);
	  	    			}
	  	    			
					},
	  	    		error: function(e){
	  	    		}
	  			});
	  		}
	    	 $(document).ready(function(){
	    		 	$.validator.setDefaults({submitHandler: function() {
	    		 		transaccionDatos( recursoTransaccion, 'formaValidateDenuncia', true, "exitoTransaccion()", "falloTransaccion()");}});
	    			$('#formaValidateDenuncia').validate(); 
	    	});
	    		
</script>