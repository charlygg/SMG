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
    <link href="<%=request.getContextPath()%>/resources/dist/css/skins/skin-blue.min.css" rel="stylesheet" type="text/css" />
	<!--  -->
	<div class="box  box-info">
                <div class="box-header with-border">
                  <h3 class="box-title">Consulta Bitacora</h3>
                  <div class="box-tools pull-right">
                  </div><!-- /.box-tools -->
                </div><!-- /.box-header -->
                <div class="tools">
	              	<button class="btn btn-primary" data-toggle="modal" data-target=".bs-modal-md"><i class="fa fa-edit">Consultar</i></button>
                </div>
                <div class="box-body">
                	<label>Identificador de Regristro:</label>	<input id="idregistro" name="idregistro" type="text" > 	<button class="btn btn-primary" onclick="consultalista();">Consulta Registro</button>
                  <table id="table" class="table table-bordered table-striped">
                  	<thead>
                  		<tr>
                  			<th>#</th>
                  			<th>Día</th>
                        	<th>Hora</th>
                        	<th>Usuario</th>
                        	<th>Estatus</th>
                        	<th>Tipo Registro</th>
                  		</tr>
                  	</thead>
   					<tbody>
   					</tbody>
                  </table>
                </div><!-- /.box-body -->
              </div><!-- /.box -->
	          <!-- modal actualizar -->
              	<div class="modal fade bs-modal-md" tabindex="-1" role="dialog" aria-labelledby="myNormal" aria-hidden="true" id="modalModifica">
  					<div class="modal-dialog modal-md" >
    					<div class="modal-content">
						<form role="form" id="formaValidate">
      						<div class="modal-header">
        						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
      							<h4 class="modal-title">Detalle de Registro</h4>
      						</div>
      						<div class="modal-body" >
                 				<div class="input-group">
                    				<span class="input-group-addon"><label for="idbitacoraregistros">Identificador</label></span>
                    					<input type="text" class="form-control" id="idbitacoraregistros" name="idbitacoraregistros"  readonly="readonly">
                  				</div>
                  				<br>
                  				<div class="input-group">
                    				<span class="input-group-addon"><label for="fecha">Fecha</label></span>
                    				<input type="text" class="form-control" placeholder="Fecha" id="fecha" name="fecha" readonly="readonly">
                  				</div>
                  				<br>
                  				<div class="input-group">
                    				<span class="input-group-addon"><label for="hora">Hora</label></span>
                    				<input type="text" class="form-control" placeholder="Descripción de Area" id="hora" name="hora" readonly="readonly">
                  				</div>
                  				<br>
                  				<div class="input-group">
                    				<span class="input-group-addon"><label for="idusuario">Usuario</label></span>
                    				<input type="text" class="form-control" placeholder="Usuario" id="idusuario" name="idusuario" readonly="readonly">
                  				</div>
                  				<br>
                  				<div class="input-group">
                    				<span class="input-group-addon"><label for="estatus">Estatus</label></span>
                    				<input type="text" class="form-control" placeholder="Estatus" id="estatus" name="estatus" readonly="readonly">
                  				</div>
                  				<br>
                  				<div class="input-group">
                    				<span class="input-group-addon"><label for="idregistroconsulta">Folio de Registro</label></span>
                    				<input type="text" class="form-control" placeholder="Número de Registro" id="idregistroconsulta" name="idregistroconsulta" readonly="readonly">
                  				</div>
                  				<br>
                  				<div class="input-group">
                    				<span class="input-group-addon"><label for="tipoBitacora">Tipo de Registro</label></span>
                    				<input type="text" class="form-control" placeholder="Número de Registro" id="tipoBitacora" name="tipoBitacora" readonly="readonly">
                  				</div>
                  				<br>
                  			</div>
      						<div class="modal-footer">
        						<input type="button" class="btn btn-primary" data-dismiss="modal" value="cerrar"/>
      						</div>
      						</form>
    					</div>
  					</div>
				</div>
              <!-- finaliza modal -->
    <script type="text/javascript">
    	var recursoTransaccion = '';
    	
    	var tabla = $('#table').dataTable( {
    	    "sAjaxSource": "listaBitacoraporRegistro",
    	    "fnServerParams": function ( aoData )   
    		{
    			aoData.push( { "name": "idregistro", "value": $("#idregistro").val() } );
    	    },
    	    "fnInitComplete":function(oSettings, json){
    	    	$('#table tbody').on( 'click', 'tr', function () {
    				if ( $(this).hasClass('selected') ) {
    		        	$(this).removeClass('selected');
    		        }
    		        else {
    		        	$('.selected').removeClass('selected');
    		            $(this).addClass('selected');
    		           	var idbitacoraregistros = tabla.fnGetData(this).idbitacoraregistros;
    		           	$('#idbitacoraregistros').val(idbitacoraregistros);
    		           	consulta();
    		        }
    			});
    	    },
          "aoColumns": [
				{ "mDataProp": 'idbitacoraregistros', "bVisible":false },
				{ "mDataProp": 'fecha' },
				{ "mDataProp": 'hora' },
				{ "mDataProp": 'idusuario' },
				{ "mDataProp": 'estatus' },
				{ "mDataProp": 'tipoBitacora' }
    		  ],

    	});
    	
    	
    	
    	
//     	var tabla = $('#table').dataTable( {
//     		"ajax": {
//     		    "url": "listaBitacoraporRegistro",
//     		    "type": "GET",
//     		    "data":
//     		    	function(){
//     		    		return "idbitacoraregistros=0&idregistro="+$('#idregistro').val();
//     		    	}
//     		},
//     		"fnInitComplete":function(oSettings, json){
//  		    	$('#table tbody').on( 'click', 'tr', function () {
//      				if ( $(this).hasClass('selected') ) {
//      		        	$(this).removeClass('selected');
//      		        }
//      		        else {
//      		        	$('.selected').removeClass('selected');
// 			            $(this).addClass('selected');
// 			           	var idprincipaltabla = tabla.fnGetData(this).idbitacoraregistros;
// 			           	$('#idbitacoraregistros').val(idprincipaltabla);
// 			           	consulta();
//      		        }
//      		    } );
//  		    },
// 		      "aoColumns": [
// 					{ "mDataProp": 'idbitacoraregistros', "bVisible":false },
// 					{ "mDataProp": 'fecha' },
// 					{ "mDataProp": 'hora' },
// 					{ "mDataProp": 'idusuario' },
// 					{ "mDataProp": 'estatus' }
//  		      ],
//  		     "columns": [
//  		                { "width": "10%" },
// 	 		            { "width": "10%" },
// 	 		            { "width": "20%" }
//  		              ]
//  		    });
    	function consultalista(){
    		tabla.api().ajax.reload();
    	}
    	function consulta(){
 			$.ajax({
     			url:'consultaBitacora', 
     			type:'GET', 
     			data: $("#formaValidate").serialize(), 
 	    		success: function(response){
 	    			$('#idbitacoraregistros').val(response.idbitacoraregistros);
 	    			$('#fecha').val(response.fecha);
 	    			$('#hora').val(response.hora);
 	    			$('#idusuario').val(response.idusuario);
 	    			$('#estatus').val(response.estatus);
 	    			$('#idregistroconsulta').val(response.idregistro);
 	    			$('#tipoBitacora').val(response.tipoBitacora);
 	    			console.log(response.idbitacoraregistros+'+'+response.fecha+'+'+response.hora+'+'+response.idusuario+'+'+response.estatus+'+'+response.idregistro);
 	    			
 	    		},
 	    		error: function(e){
 	    		}
 	    		});
 		}
    
	    	 $(document).ready(function(){
	    		$('#formaValidateArea').validate(); 
	     	});
	    	 
</script>