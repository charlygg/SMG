<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

<!-- botones -->
<script type="text/javascript">

function regresandoIdtramite(id){
var	nombre="";
	switch(id) {
    case '1':
        nombre="idtramite_licencia_funcionamiento";
        break;
    case '2':
    	 nombre="idtramite_quema_cielo_abierto";
        break;
    case '3':
   	 nombre="idtramite_cambio_razon_social";
       break;
    case '4':
   	 nombre="idtramite_cambio_representante";
       break;
    case '5':
   	 nombre="idtramite_cierre_operaciones";
       break;
    case '6':
   	 nombre="idtramite_evaluacion_impacto_ambiental";
       break;
    case '7':
   	 nombre="idtramite_cambio_titularidad";
       break;
    case '8':
   	 nombre="idtramite_registro_prestador_servicio";
       break;
    case '9':
   	 nombre="idtramite_solicitud_prorroga";
       break;
    case '10':
   	 nombre="idtramite_solicitud_copias";
       break;
    case '11':
   	 nombre="idtramite_consultas";
       break;
    case '12':
   	 nombre="idtramite_modificacion_proyecto";
       break;
    case '16':
   	 nombre="idtramite";
       break;
    case '17':
   	 nombre="idtramite_tratamiento";
       break;
    case '18':
      	 nombre="idtramite_fosaseptica";
          break;
    case '19':
      	 nombre="idtramite_registro_trans_aguas_reci";
          break;
    case '20':
      	 nombre="idtramite_informesem";
          break;
    case '21':
      	 nombre="idtramite_informacion";
          break;
    case '22':
      	 nombre="idtramite_actualizacion_tranps";
          break;
    case '23':
      	 nombre="idtramite";
          break;
    case '24':
      	 nombre="idtramite_baja_cambio_dom";
          break;
    case '25':
      	 nombre="idtramite";
          break;
    case '26':
      	 nombre="idtramite_baja_venta_pasivo";
          break;
    case '27':
      	 nombre="idtramite";
          break;
    case '28':
      	 nombre="idtramite";
          break;
    case '29':
      	 nombre="idtramite";
          break;
    case '30':
      	 nombre="idtramite";
          break;
    case '31':
      	 nombre="idtramite";
          break;
    case '32':
      	 nombre="idtramite";
          break;
    case '33':
      	 nombre="idtramite";
          break;
    case '34':
      	 nombre="idtramite_reciclaje_residuos_manejo_especial";
          break;
    case '35':
      	 nombre="idtramite_operacion_vehi_recolectores";
          break;
    case '36':
     	 nombre="idtramite_operacion_manejo_integral_establecimientos";
         break;
    case '37':
     	 nombre="idtramite_planes_manejo_especificos";
         break;
    case '39':
     	 nombre="idtramite_reception_validacion_informacion";
         break;
    case '40':
     	 nombre="idtramite_rehuso_residuos_manejo_especial";
         break;
    case '41':
     	 nombre="idtramite_operacion_manejo_integral_centros";
         break;
}
	console.log('id '+id+' nombre_ '+nombre);
	return nombre;
}
					function generarNumOficioSPMARN(){
						console.log("generarNumOficioSPMARN");
						$.ajax({
							url:'getNumsOfics', //Url a donde la enviaremos
							type:'GET', //Metodo que usaremos
							data: "area=" + $('#areaNumOficio').val() + "&tipo="+ 'SPMARN',
							success: function(response){
									 $('#numero_oficinaNum').val(response);
									 var f = new Date();
									 $('#fechaNum').val(f);
									 $('#idtramiteNum').val($('#'+regresandoIdtramite($('#tipoTramiteNumOficio').val())+'').val());
									 $('#nombre_tramiteNum').val($('#titleNumOficio').val());
									 $('#numerotipo_oficinaNum').val('SPMARN');
									 $('#idtipo_tramiteNum').val($('#tipoTramiteNumOficio').val());
									 $('#descripcionNum').val('');
									$('#myModalNumeroOficio').modal('show');
									},
							error: function(e){
									
									}
						});
					}
					function generarNumOficioDMA(){
						console.log("generarNumOficioDMA");
						$.ajax({
							url:'getNumsOfics', //Url a donde la enviaremos
							type:'GET', //Metodo que usaremos
							data: "area=" + $('#areaNumOficio').val() + "&tipo="+ 'DMA',
							success: function(response){
									 $('#numero_oficinaNum').val(response);
									 var f = new Date();
									 $('#fechaNum').val(f);
									 $('#idtramiteNum').val($('#'+regresandoIdtramite($('#tipoTramiteNumOficio').val())+'').val());
									 $('#nombre_tramiteNum').val($('#titleNumOficio').val());
									 $('#numerotipo_oficinaNum').val('DMA');
									 $('#idtipo_tramiteNum').val($('#tipoTramiteNumOficio').val());
									 $('#descripcionNum').val('');
									$('#myModalNumeroOficio').modal('show');
									},
							error: function(e){
									
									}
						});
					}
					function saveNumOficio(){
						console.log("saveNumOficio");
						$.ajax({
							url:'saveNumOficio', //Url a donde la enviaremos
							type:'GET', //Metodo que usaremos
							data: "numero_oficina=" + $('#numero_oficinaNum').val() + "&numerotipo_oficina="+ $('#numerotipo_oficinaNum').val() + "&fecha="+ $('#fechaNum').val() 
							+ "&idtramite="+ $('#idtramiteNum').val()
							+ "&idtipo_tramite="+ $('#idtipo_tramiteNum').val()+ "&nombre_tramite="+ $('#nombre_tramiteNum').val()+ "&descripcion="+ $('#descripcionNum').val()
							+"&estado=valido",
							success: function(response){
									
									$('#myModalNumeroOficio').modal('hide');
									},
							error: function(e){
									
									}
						});
						
					}
					function referenceNumOfi(){
						console.log("referenceNumOfi");
						$.ajax({
							url:'historialGenNums', //Url a donde la enviaremos
							type:'GET', //Metodo que usaremos
							data:  "idtramite="+ $('#'+regresandoIdtramite($('#tipoTramiteNumOficio').val())+'').val() + "&idtipo_tramite="+ $('#tipoTramiteNumOficio').val(),
							success: function(response){
								$("#seccionHistorial").html(response);
									$('#myModalHistorial').modal('show');
									},
							error: function(e){
									
									}
						});
						
					}
					
					</script>

	<c:if test="${!empty view}">
		<div class="input-group">
		<a onclick="referenceNumOfi()">Historial de numeros de oficio</a>
	</div>
	<br>
	</c:if>

<div id="ocultarNumOficio" hidden>
	<div class="input-group">
		<button class="btn btn-success" onclick="generarNumOficioSPMARN()">Pedir
			número de oficio de Subsecretaria</button>
	</div>
	<br>
	<div class="input-group">
		<button class="btn btn-danger" onclick="generarNumOficioDMA()">Pedir
			número de oficio de Direccion</button>
	</div>
	<br>
	<div class="input-group">
		<a onclick="referenceNumOfi()">Historial de numeros de oficio</a>
	</div>
	<br>
	<!-- fin de botones -->
</div>
<!-- Modal -->
	<div class="modal fade" id="myModalNumeroOficio" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Número de oficio</h4>
				</div>
				<div class="modal-body">
					<div class="input-group">
						<span class="input-group-addon">Número de oficio</span> <input
							type="text" class="form-control" id="numero_oficinaNum"
							name="numero_oficina" disabled>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Fecha</span> <input type="text"
							class="form-control" id="fechaNum" name="fecha" disabled>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Identificador de tramite</span> <input
							type="text" class="form-control" id="idtramiteNum"
							name="idtramite" disabled>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Nombre de tramite</span> <input
							type="text" class="form-control" id="nombre_tramiteNum"
							name="nombre_tramite" disabled>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Descripción</span>
						<textarea id="descripcionNum" class="form-control"></textarea>
						<input type="hidden" id="numerotipo_oficinaNum" value="">
						<input type="hidden" id="idtipo_tramiteNum" value="">
					</div>
					<br>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary"
						onclick="saveNumOficio()">Guardar cambios</button>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="myModalHistorial" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog  modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Historial de numeros
						de oficio</h4>
				</div>
				<div id="seccionHistorial" class="modal-body"></div>
				<div class="modal-footer"></div>
			</div>
		</div>
	</div>