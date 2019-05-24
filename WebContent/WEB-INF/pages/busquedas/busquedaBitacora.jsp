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
                	<div class="input-group">
	               		<span class="input-group-addon">Empresa</span>
	                    <select id="comboEmpresa" name="comboEmpresa" class="form-control">
	                    	<option value="">Escoja Una Opción</option>
							<c:forEach items="${listBitEmpresa}" var="empresa">
								<option value="${empresa.idcatalogo}">${empresa.empresa}</option>
							</c:forEach>
						</select>
	             	</div>
					<br>
					<div class="input-group">
	               		<span class="input-group-addon">Establecimiento</span>
	                    <select id="comboEstablecimiento" name="comboEstablecimiento" class="form-control">
						</select>
	             	</div>
					<br>
                
                  <table id="table" class="table table-bordered table-striped">
                  	<thead>
                  		<tr>
                  			<th>#</th>
                  			<th>Día</th>
                        	<th>Hora</th>
                        	<th>Usuario</th>
                        	<th>Estatus</th>
                        	<th>Registro</th>
                        	<th>Empresa</th>
                        	<th>Establecimmiento</th>
                        	<th>Id Catalogo</th>
                        	<th>Catalogo</th>
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
                 				<div id="mostrar_tramite">
      							
      							</div>
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
    	    "sAjaxSource": "getbitacoraPorEmpresa",
    	    "fnServerParams": function ( aoData )   
    		{
    			aoData.push( { "name": "idempresa", "value": $("#comboEmpresa").val() } );
    			aoData.push( { "name": "idestablecimiento", "value": $("#comboEstablecimiento").val() } );
    	    },
    	    "fnInitComplete":function(oSettings, json){
    	    	$('#table tbody').on( 'click', 'tr', function () {
    				if ( $(this).hasClass('selected') ) {
    		        	$(this).removeClass('selected');
    		        }
    		        else {
    		        	$('.selected').removeClass('selected');
    		            $(this).addClass('selected');
    		           	var idprincipaltabla = tabla.fnGetData(this).idbitacoraregistros;
    		           	var tipo = tabla.fnGetData(this).idcatalogo;
    		           
    		           	
    		           	mostrar_Tramite(idprincipaltabla,tipo);
    		        }
    			});
    	    },
          "aoColumns": [
				{ "mDataProp": 'idbitacoraregistros', "bVisible":false },
				{ "mDataProp": 'fecha' },
				{ "mDataProp": 'hora' },
				{ "mDataProp": 'usuario' },
				{ "mDataProp": 'estatus' },
				{ "mDataProp": 'registro' },
				{ "mDataProp": 'empresa' },
				{ "mDataProp": 'establecimiento' },
				{ "mDataProp": 'idcatalogo' },
				{ "mDataProp": 'catalogo' }
    		  ],

    	});
    	
	    function mostrar_Tramite(idtramite,tipo){
	    	$.ajax({
				url:'getDataTramite', 
				type:'GET', 
				data: { idtramite: idtramite, tipo: tipo }, 
	 		success: function(response){
	 			console.log('lista exitosa');
	 			
	 			$("#mostrar_tramite").html(response);
	 		},
	 		error: function(e){
	 			console.log('lista no exitosa');
	 		}
		    });
	    	
	    }
    	
  
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
 	    			console.log(response.idbitacoraregistros+'+'+response.fecha+'+'+response.hora+'+'+response.idusuario+'+'+response.estatus+'+'+response.idregistro);
 	    			
 	    		},
 	    		error: function(e){
 	    		}
 	    		});
 		}
   	 $(document).ready(function(){
   		 $('#comboEmpresa').change(function (){
   			 $("#comboEstablecimiento").empty();
   			    $.getJSON('getBitacoraComboEstablecimiento?idempresa='+$("#comboEmpresa").val(),function(data){
   		        $("#comboEstablecimiento").append("<option value=''>Escoja una opción</option>");
   		        $.each(data, function(i,item){
   		            $("#comboEstablecimiento").append("<option value=\""+item.idcatalogo+"\">"+item.establecimiento+"</option>");
   		        });
   			});
   		});
   		$('#comboEstablecimiento').change(function(){
   			tabla.api().ajax.reload();
   		});
   		$('#formaValidateArea').validate(); 
   	});
	    	 
</script>