<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

<script type="text/javascript">
<!--

//-->
function invalidaNumero(id){
	console.log("referenceNumOfi");
	$.ajax({
		url:'invalidaNumero', //Url a donde la enviaremos
		type:'GET', //Metodo que usaremos
		data:  "idrelacion_numeros_oficio="+ id,
		success: function(response){
			$("#seccionTabla").html(response);
				},
		error: function(e){
				
				}
	});
	
}
</script>

<div id="seccionTabla">
<div class="row">
	<div class="col-sm-12 col-xs-12 col-lg-12" style="padding:10px">
	<c:if test="${!empty list}">
		<table class="table table-striped">
			<tr style="background: #00a65a; color: white;">
				<th>Número de oficio</th>
				<th>Fecha</th>
				<th>Nombre de tramite</th>
				<th>Descripción</th>
				<th>Descripción</th>
				<th>Estado</th>
				<th></th>
			</tr>
			<c:forEach items="${list}" var="numero">
				<tr>
					<td>${numero.numero_oficina}</td>
					<td>${numero.fecha}</td>
					<td>${numero.nombre_tramite}</td>
					<td>${numero.descripcion}</td>
					<td>${numero.estado}</td>
					<td><c:if test="${numero.estado =='valido'}"><button class="btn btn-danger" onclick="invalidaNumero(${numero.idrelacion_numeros_oficio})">Invalido</button></c:if></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<c:if test="${empty list}">
		<h4>No tiene números previos</h4>
	</c:if>
	</div>
</div>
</div>