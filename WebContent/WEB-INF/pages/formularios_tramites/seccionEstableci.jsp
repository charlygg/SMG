<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

<script type="text/javascript">
<!--

//-->
$("#idestablecimiento").change(function() {
	llenaridestablecimiento($("#idestablecimiento").val());
});

function llenaridestablecimiento(idestablecimiento){
	 $.getJSON('getEstablecimientosByID?idestablecimiento='+idestablecimiento,function(data){
	        console.log(JSON.stringify(data));
	        $('#calle').val(data.calle);
	        $('#numeroExterior').val(data.numeroExterior);
	        $('#numeroInterior').val(data.numeroInterior);
	        $('#colonia').val(data.colonia);
	        $('#municipio').val(data.municipio);
	        $('#estado').val(data.estado);
	        $('#latitud').val(data.latitud);
	        $('#longitud').val(data.longitud);
	        $('#DatosEstablecimiento').prop( "hidden", false );
	    });
}
</script>

       <!-- inicia bloque oculto -->
                   	<div id="DatosEstablecimiento" class="container" hidden>
                   		<div class="col-lg-10">
                   		<div class="box box-success">
                		<div class="box-header with-border">
                		  <h3 class="box-title">Establecimiento</h3>
                		</div>
                		<div class="box-body">
                  			<div class="input-group">
                    			<span class="input-group-addon">Calle</span>
                     			<input type="text" id="calle" class="form-control" readonly>
                  			</div>
                  			<br>
                  			<div class="input-group">
                    			<span class="input-group-addon">Número Exterior</span>
                     			<input type="text" id="numeroExterior" class="form-control" readonly>
                  			</div>
                  			<br>
                  			<div class="input-group">
                    			<span class="input-group-addon">Número Interior</span>
                     			<input type="text" id="numeroInterior" class="form-control" readonly>
                  			</div>
                  			<br>
                  			<div class="input-group">
                    			<span class="input-group-addon">Colonia</span>
                     			<input type="text" id="colonia" class="form-control" readonly>
                  			</div>
                  			<br>
                  			<div class="input-group">
                    			<span class="input-group-addon">Municipio</span>
                     			<input type="text" id="municipio" class="form-control" readonly>
                  			</div>
                  			<br>
                  			<div class="input-group">
                    			<span class="input-group-addon">Estado</span>
                     			<input type="text" id="estado" class="form-control" readonly>
                  			</div>
                  			<br>
                  			<div class="input-group">
                    			<span class="input-group-addon">Latitud</span>
                     			<input type="text" id="latitud" class="form-control" readonly>
                  			</div>
                  			<br><div class="input-group">
                    			<span class="input-group-addon">Longitud</span>
                     			<input type="text" id="longitud" class="form-control" readonly>
                  			</div>
                  			<br>
                  		</div>
                  	</div>
                   
                   		</div>
                   	</div>
                   	<!--  -->
              