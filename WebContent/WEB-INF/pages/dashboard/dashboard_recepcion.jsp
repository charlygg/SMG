<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

<div class="row">
	<div class="col-lg-12">
		<div class="box box-success">
			<div class="box-header with-border">
				<h3 class="box-title">Correspondencia de Solicitudes SMG</h3>
			</div>

			<div class="box-body">
			<p>Establecer las fechas</p>
				<table id="tblTramites" class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>No. Tramite</th>
							<th>Tramite</th>
							<th>Empresa</th>
							<th>Rep. Legal</th>
							<th>Asunto</th>
							<th>Turnado</th>
						</tr>
					</thead>
					<tbody>
							<c:forEach var="tramite" items="${listadoTramiteNuevo}">
								<tr>
									<td>${tramite.idTramite }</td>
									<td>${tramite.tramite }</td>
									<td>${tramite.empresa }</td>
									<td>${tramite.rep_legal }</td>
									<td>${tramite.asunto }</td>
									<td>${tramite.turnado }</td>
								</tr>
							</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="box-footer"></div>

		</div>
		<!-- /.box -->
	</div>
</div>

<script>
$(function(){
	$('#tblTramites').DataTable({
		
	});
});
</script>