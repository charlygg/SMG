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
                	<input type="hidden" id="listaBitacora_idregistro" value="${ idregistro }">
                	<input type="hidden" id="listaBitacora_catalogoID" value="${ catalogoID }">
                </div><!-- /.box-header -->
                <div class="box-body">
                  <table id="table" class="table table-bordered table-striped">
                  	<thead>
                  		<tr>
                  			<th>#</th>
                  			<th>Día</th>
                        	<th>Hora</th>
                        	<th>Usuario</th>
                        	<th>Estatus</th>
                  		</tr>
                  	</thead>
   					<tbody>
   					</tbody>
                  </table>
                </div><!-- /.box-body -->
              </div><!-- /.box -->

    <script type="text/javascript">
    $(document).ready(function() {
    	console.log('llego a la declaracion de la tabla ');
    	var tabla = $('#table').dataTable( {
    	    "sAjaxSource": "listConsultaBitacoraCatReg",
    	    "fnServerParams": function ( aoData )   
    		{
    			aoData.push( { "name": "idregistro", "value": $("#listaBitacora_idregistro").val() });
    			aoData.push( { "name": "catalogoID", "value": $("#listaBitacora_catalogoID").val() });
    			 
    	    },
    	    "fnInitComplete":function(oSettings, json){},
          "aoColumns": [
				{ "mDataProp": 'idbitacoraregistros', "bVisible":false },
				{ "mDataProp": 'fecha' },
				{ "mDataProp": 'hora' },
				{ "mDataProp": 'usuario' },
				{ "mDataProp": 'estatus' }
    		  ],

    	});

    });
	    	 
</script>