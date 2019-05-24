<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

<script type="text/javascript">
<!--

//-->
$("#idestablecimientomens").change(function() {
	llenaridestablecimientomens($("#idestablecimientomens").val());
});

function llenaridestablecimientomens(datos){
	  $.getJSON('getEstablecimientosByID?idestablecimiento='+datos,function(data){
	        console.log(JSON.stringify(data));
	        $('#calleMatriz').val(data.calle);
	        $('#numeroExteriorMatriz').val(data.numeroExterior);
	        $('#numeroInteriorMatriz').val(data.numeroInterior);
	        $('#coloniaMatriz').val(data.colonia);
	        $('#municipioMatriz').val(data.municipio);
	        $('#estadoMatriz').val(data.estado);
	        $('#latitudMatriz').val(data.latitud);
	        $('#longitudMatriz').val(data.longitud);
	        $('#DatosEstablecimientoMatriz').prop( "hidden", false );
	    });
}
</script>

       <!-- inicia bloque oculto -->
                   	<div id="DatosEstablecimientoMatriz" class="container" hidden>
                   		<div class="col-lg-10">
                   		<div class="box box-success">
                		<div class="box-header with-border">
                		  <h3 class="box-title">Establecimiento</h3>
                		</div>
                		<div class="box-body">
                  			<div class="input-group">
                    			<span class="input-group-addon">Calle</span>
                     			<input type="text" id="calleMatriz" class="form-control" readonly>
                  			</div>
                  			<br>
                  			<div class="input-group">
                    			<span class="input-group-addon">Número Exterior</span>
                     			<input type="text" id="numeroExteriorMatriz" class="form-control" readonly>
                  			</div>
                  			<br>
                  			<div class="input-group">
                    			<span class="input-group-addon">Número Interior</span>
                     			<input type="text" id="numeroInteriorMatriz" class="form-control" readonly>
                  			</div>
                  			<br>
                  			<div class="input-group">
                    			<span class="input-group-addon">Colonia</span>
                     			<input type="text" id="coloniaMatriz" class="form-control" readonly>
                  			</div>
                  			<br>
                  			<div class="input-group">
                    			<span class="input-group-addon">Municipio</span>
                     			<input type="text" id="municipioMatriz" class="form-control" readonly>
                  			</div>
                  			<br>
                  			<div class="input-group">
                    			<span class="input-group-addon">Estado</span>
                     			<input type="text" id="estadoMatriz" class="form-control" readonly>
                  			</div>
                  			<br>
                  			<div class="input-group">
                    			<span class="input-group-addon">Latitud</span>
                     			<input type="text" id="latitudMatriz" class="form-control" readonly>
                  			</div>
                  			<br><div class="input-group">
                    			<span class="input-group-addon">Longitud</span>
                     			<input type="text" id="longitudMatriz" class="form-control" readonly>
                  			</div>
                  			<br>
                  		</div>
                  	</div>
                   
                   		</div>
                   	</div>
                   	<!--  -->
              