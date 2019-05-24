<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
 	<script src="<%=request.getContextPath()%>/resources/plugins/input-mask/jquery.inputmask.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/resources/plugins/input-mask/jquery.inputmask.date.extensions.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/resources/plugins/input-mask/jquery.inputmask.extensions.js" type="text/javascript"></script>
 <script type="text/javascript">
 	$('#telefono').inputmask({mask: "(999) 999-9999"});  //static mask
	
 	var recurso = 'insertaPerfilEstablecimiento';
 	$(document).ready(function() {
 		$.validator.setDefaults({submitHandler: function() { transaccionDatos( recurso, 'formulario', true, "exito()", "fallo()");}});
 		$('#formulario').validate({
 			rules:{
 				idcatalogo_perfilempresa:{
 					number:true
 				}
 			},
 			messages:{
 				idcatalogo_perfilempresa:{
 					number:'Se requiene un número entero'
 				}
 			}
 		});
 		$('#estado_select').change().blur(function(){
 			console.log('paso por el change del estado');
 			cargaMunicipiosCombo();
 			$('#estado').val($('#estado_select option:selected').text());
 		});
 		$('#municipio_select').change().blur(function(){
 			console.log('paso por el change del municipio');
			$('#municipio').val($('#municipio_select option:selected').text());
 		});
 		$('#matriz').change(function(){
 			console.log('paso por el change del matriz');
 			
 			if($("#matriz").is(':checked')){
 				console.log('paso ischeked');
 				consutaMatrizDisponible();
 			}
 			
 		});
    });
 	function consutaMatrizDisponible(){
 		$.ajax({
 			url:'consultaExisteMatrizPEstablecimiento', 
 			type:'GET', 
 			data: 'idcatalogo_perfilempresa='+$("#idcatalogo_perfilempresa").val(), 
    		success: function(response){
    			console.log('salida exitosa');
    			
    			if(Number(response.numero) > 0){
    				mensajeriaAlertas('Error', response.mensaje);
    				var elementfocus = document.getElementById(response.referencia);
    				if(elementfocus != undefined && elementfocus != null){
    					elementfocus.focus();
    					elementfocus.select();
    				}
    			}
    		},
    		error: function(e){
    		}
	    		});
 	}
 	function cargaMunicipiosCombo(){
 		$.ajax({
 			url:'listaMunicipios', 
 			type:'GET', 
 			data: 'estadoID='+$("#estado_select").val(), 
    		success: function(response){
    			console.log('salida exitosa');
    			
    			var select = document.getElementById("municipio_select");
				while (select.length > 0) {
					select.remove(select.length-1);
    			}

    			for (var i=0; i < response.data.length; i++)
    			{
    			  var option = document.createElement("option");
    			  option.value = response.data[i].nombre;
    			  option.innerHTML = response.data[i].nombre;
    			  select.appendChild(option);
    			}
    		},
    		error: function(e){
    		}
	    		});
 	}
 	function exito(){
 		mensajeriaAlertas('Exito', 'En Alta de Perfil Establecimiento')
 	}
 	function fallo(){
 		mensajeriaAlertas('Error', 'En Alta de Perfil Establecimiento')
 	}
	
	</script>

 
<!-- Custom tabs (Charts with tabs)-->
<div class="row">
	<section class="col-lg-5 connectedSortable">
	<div class="box box-info">
                <div class="box-header with-border">
                  <h3 class="box-title">Alta Perfil Establecimiento</h3>
                </div>
                <form id="formulario" role="form">
                <div class="box-body">
                   <div class="input-group">
                    <span class="input-group-addon">Nombre de Empresa</span>
                    <select id="idcatalogo_perfilempresa" name="idcatalogo_perfilempresa" class="form-control">
						<c:forEach items="${empresas}" var="empresa">
							<option value="${empresa.idcatalogo_perfilempresa}">${empresa.nombreEmpresa}</option>
						</c:forEach>
					</select>
                  </div>
                  <br>
                  <div class="input-group">
                    <span class="input-group-addon">Email</span>
                    <input type="email" class="form-control" placeholder="Correo Electrónico" id="email" name="email" required >
                  </div>
                  <br>
                  <div class="input-group">
                    <span class="input-group-addon">Teléfono</span>
                    <input type="text" class="form-control" placeholder="Teléfono del Establecimiento" id="telefono" name="telefono" required >
                  </div>
                  <br>
                  <div class="input-group">
                    <span class="input-group-addon">Matriz</span>
                    <input type="checkbox" id="matriz" name="matriz" >
                  </div>
                  <br>
                  <h3>Dirección</h3>
                   <br>
                  <div class="input-group">
               		<span class="input-group-addon">Estado</span>
                    <select id="estado_select" name="estado_select" class="form-control">
						<c:forEach items="${estados}" var="estad">
							<option value="${estad.estadoID}" >${estad.nombre}</option>
						</c:forEach>
					</select>
					<input type="hidden" id="estado" name="estado">
             		</div>
                   <br>
                   <div class="input-group">
                    <span class="input-group-addon">Municipio</span>
                    <select id="municipio_select" name="municipio_select" class="form-control"></select>
                    <input type="hidden" id="municipio" name="municipio">
                  </div>
                  <br>
                   <div class="input-group">
                    <span class="input-group-addon">Colonia</span>
                    <input type="text" class="form-control" placeholder="Colonia" id="colonia" name="colonia" >
                  </div>
                  <br>
                  <div class="input-group">
                    <span class="input-group-addon">Calle</span>
                    <input type="text" class="form-control" placeholder="Calle" id="calle" name="calle">
                  </div>
                   <br>
                   <div class="input-group">
                    <span class="input-group-addon">Número Exterior</span>
                    <input type="text" class="form-control" placeholder="Número Exterior" id="numeroExterior" name="numeroExterior">
                  </div>
                   <br>
                   <div class="input-group">
                    <span class="input-group-addon">Número Interior</span>
                    <input type="text" class="form-control" placeholder="Número Interior" id="numeroInterior" name="numeroInterior">
                  </div>
                   <br>
                   <h3>Coordenadas</h3>
                   <div class="input-group">
                    <span class="input-group-addon">Latitud</span>
                    <input type="text" class="form-control" placeholder="Latitud" id="latitud" name="latitud" >
                  </div>
                   <br>
                   <div class="input-group">
                    <span class="input-group-addon">Longitud</span>
                    <input type="text" class="form-control" placeholder="Longitud" id="longitud" name="longitud" >
                  </div>
                   <br>
                   
                </div><!-- /.box-body -->
                <div class="box-footer">
                    <input id="btn_enviar" type="submit" class="submit btn btn-primary" value="Guardar"/>
                </div>
                </form>
              </div><!-- /.box -->
	</section>

</div>
              