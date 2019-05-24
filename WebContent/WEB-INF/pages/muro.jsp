<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page session="true"%>

<script type="text/javascript">
<!--

//-->
function mostrar_Tramite(idtramite,tipo){
	$.ajax({
		url:'getDataTramite', 
		type:'GET', 
		data: { idtramite: idtramite, tipo: tipo }, 
		success: function(response){
			console.log('lista exitosa');
			
			$("#mostrar_tramite").html(response);
			$('#modalDato').modal('show');
		},
		error: function(e){
			console.log('lista no exitosa');
		}
    });
	
}

function mostrar_Denuncia(idtramite){
	$.ajax({
		url:'viewDenuncia', 
		type:'GET', 
		data: { iddenuncia: idtramite}, 
		success: function(response){
			console.log('lista exitosa');
			
			$("#mostrar_tramite").html(response);
			$('#modalDato').modal('show');
		},
		error: function(e){
			console.log('lista no exitosa');
		}
    });
	
}

function showModal(){
	$('#modalDato').modal('show');
}
</script>

 <div class="row">
 	<section class="col-lg-7 connectedSortable">
 		<ul class="timeline">
			<c:forEach items="${listaMuro}" var="listamuro">
			<!-- Cuando es un tramite -->
				<c:if test="${listamuro.tipo_tramite == 'tramite'}">
					<!-- timeline time label -->
					<li class="time-label">
						<span class="bg-blue">
							<fmt:formatDate value="${listamuro.fecha}" pattern="MM/dd/yyyy" />
						</span>
					</li>
					<!-- /.timeline-label -->
					<li>
						<!-- timeline icon -->
						<i class="fa fa-newspaper-o bg-blue"></i>
						<div class="timeline-item">
							<span class="time"><i class="fa fa-clock-o"></i><fmt:formatDate value="${listamuro.fecha}" pattern="HH:mm" /></span>	
							<h3 class="timeline-header"><a href="#">Un ${listamuro.tipo_tramite} se ha ${listamuro.estado_tramite}</a> ...</h3>
							<div class="timeline-body">
								"${listamuro.nombre_empresa}-${listamuro.municipio_empresa}" ha solicitado una ${listamuro.nombreTramite}
							</div>
							<div class='timeline-footer'>
								<a class="btn btn-primary btn-xs"  onClick="mostrar_Tramite(${listamuro.idtramite},${listamuro.id_tipo_tramite})"> Ver detalle</a>
							</div>
						</div>
					</li>
				</c:if>
				<!-- Termina tramite -->
				<!-- Cuando en denuncia -->
				<c:if test="${listamuro.tipo_tramite == 'denuncia'}">
					<!-- timeline time label -->
					<li class="time-label">
						<span class="bg-green">
							<fmt:formatDate value="${listamuro.fecha}" pattern="MM/dd/yyyy" />
						</span>
					</li>
					<!-- /.timeline-label -->
					<li>
						<!-- timeline icon -->
						<i class="fa fa-newspaper-o bg-green"></i>
						<div class="timeline-item">
							<span class="time"><i class="fa fa-clock-o"></i><fmt:formatDate value="${listamuro.fecha}" pattern="HH:mm" /></span>	
							<h3 class="timeline-header" style="color:#00a65a"><a href="#" style="color:#00a65a">Un ${listamuro.tipo_tramite} se ha ${listamuro.estado_tramite}</a> ...</h3>
							<div class="timeline-body">
							<c:choose>
							<c:when test="${listamuro.nombre_empresa == ''}">Anonimo</c:when>
							<c:otherwise>"${listamuro.nombre_empresa}-${listamuro.municipio_empresa}"</c:otherwise>
							</c:choose>
								 ha solicitado una ${listamuro.nombreTramite}
							</div>
							<div class='timeline-footer'>
								<a class="btn btn-success btn-xs" onClick="mostrar_Denuncia(${listamuro.idtramite})"> Ver detalle</a>
							</div>
						</div>
					</li>
				</c:if>
			</c:forEach>
		</ul>
			<!-- Termina denuncia -->
			<!-- Modal -->
			<div id="modalDato" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myNormalModalUpdateTramite	" aria-hidden="true">
				<div class="modal-dialog modal-md" >
					<div class="modal-content">
						<form role="form" id="formaValidateTramite">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								<h4 class="modal-title"></h4>
							</div>
							<div id="mostrar_tramite" class="modal-body" >
								
								
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-primary"  data-dismiss="modal" >Cerrar</button>
							</div>
						</form>
					</div>
				</div>
			</div>
			<!-- Fin Modal -->
 	</section>
 </div>

