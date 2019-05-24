<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

<script type="text/javascript">
<!--

//-->
$("#municipio_tramite").change(function() {
    $("#colonia_tramite").empty();
    
    $.getJSON('getArrayColoniasPorMunicipio?municipio_tramite='+$("#municipio_tramite").val(),function(data){
        console.log(JSON.stringify(data));
        $("#colonia_tramite").append("<option value='%'>Todos</option>");
        $.each(data, function(i,item){
        	 console.log(item.idcatalogo_perfilestablecimiento);
            $("#colonia_tramite").append("<option value=\""+item+"\">"+item+"</option>");
        });
    });
});


	function busquedaTramite(){
		table.api().ajax.reload();
 	}

</script>

<div class="row">
	<section class="col-lg-5 connectedSortable">
	<div class="box box-info">
                <div class="box-header with-border">
                  <h3 class="box-title">Busqueda Tramites</h3>
                </div>
                <form id="formularioUser" role="form" >
                <div class="box-body">
                  <div class="input-group">
                    <span class="input-group-addon">Tipo de tramite</span>
                    <select id="tipo_tramite" name="tipo_tramite" class="form-control">
                    	<option value="0">Todos</option>
						<c:forEach items="${tiposTramite}" var="tiposTramite">
							<option value="${tiposTramite.catalogoID}">${tiposTramite.nombreTramite}</option>
						</c:forEach>
					</select>
                  </div>
                  <br>
                  <div class="input-group">
                    <span class="input-group-addon">Municipio</span>
                    <select id="municipio_tramite" name="municipio_tramite" class="form-control">
						<option value="%">Todos</option>
						<c:forEach items="${municipios}" var="municipios">
							<option value="${municipios}">${municipios}</option>
						</c:forEach>
					</select>
                  </div>
                   <br>
                  <div class="input-group">
                    <span class="input-group-addon">Colonia</span>
                   <select id="colonia_tramite" name="colonia_tramite" class="form-control">
                   <option value="%">Todos</option>
                   </select>
                  </div>
                </div><!-- /.box-body -->
                <div class="box-footer">
                    <input onclick="busquedaTramite()" type="button" class="btn btn-success" value="Buscar"/>
                </div>
                </form>
              </div><!-- /.box -->
	</section>
	<section class="col-lg-7 connectedSortable">
	</section>
</div>
<div class="row">
<section class="col-lg-12 connectedSortable">
<div class="box box-success">
                <div class="box-header with-border">
                
                </div>
                <div class="tools">
	              	<button class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-md"><i class="fa fa-edit">Mostrar</i></button>
	              	
                </div>
                <div class="box-body">
                
                <table id="table" class="table table-bordered table-striped" cellspacing="0" width="100%">
                    <thead>
                      <tr>	
                      	<th>Id Tramite</th>
                      	<th>id Tipo</th>
                      	<th>Tipo Tramite</th>
                        <th>Nombre Empresa</th>
                      </tr>
                    </thead>
                  </table>
                  
                </div><!-- /.box-body -->
                <div class="box-footer">
                    
                </div>

              </div><!-- /.box -->
              
              <!-- modal actualizar -->
              	<div class="modal fade bs-example-modal-md" tabindex="-1" role="dialog" aria-labelledby="myNormalModalUpdate" aria-hidden="true" id="modalModifica">
  					<div class="modal-dialog modal-lg" >
    					<div class="modal-content">
    					
      						<div class="modal-header">
        						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
      							<h4 class="modal-title">Mostrar tramite</h4>
      						</div>
      						<div class="modal-body" >
      							<div id="mostrar_tramite">
      							
      							</div>
      						
                  			</div>
      						<div class="modal-footer">
        					
      						</div>

    					</div>
  					</div>
				</div>
              <!-- finaliza modal -->
              
              </section>
</div>

<!--  -->
<script>
var table = $('#table').dataTable( {
	    "sAjaxSource": "getBusquedaTramite",
	    "fnServerParams": function ( aoData )   
	    {  
	        aoData.push( { "name": "tipo_tramite", "value": $("#tipo_tramite").val() } );  
	        aoData.push( { "name": "municipio_tramite", "value": $("#municipio_tramite").val() } );  
	        aoData.push( { "name": "colonia_tramite", "value": $("#colonia_tramite").val() } );  
	  
	    },
	    "fnInitComplete":function(oSettings, json){
	    	$('#table tbody').on( 'click', 'tr', function () {
				if ( $(this).hasClass('selected') ) {
		        	$(this).removeClass('selected');
		        }
		        else {
		        	$('.selected').removeClass('selected');
	            $(this).addClass('selected');
	           	var idprincipaltabla = table.fnGetData(this).idtramite;
	        	var tipo = table.fnGetData(this).idtipo;
	          		console.log("id: "+idprincipaltabla+"tipo: "+tipo)
	          		mostrar_Tramite(idprincipaltabla,tipo);
		        }
		    } );
	    },
      "aoColumns": [
			{ "mDataProp": 'idtramite'},
			{ "mDataProp": 'idtipo'},
			{ "mDataProp": 'tipo'},
			{ "mDataProp": 'nombre_empresa'}
      ]
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
</script>