<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!-- Custom tabs (Charts with tabs)-->
<div class="row">
	<section class="col-lg-12 connectedSortable">
		<div class="box box-info">
			<div class="box-header with-border">
				<h3 class="box-title">Denuncias</h3>
			</div>
			<div class="tools"></div>

			<form id="formularioDenuncias" role="form">
				<div class="box-body">

					<!-- Tipo de denuncia -->
					<div class="input-group">
						<span class="input-group-addon">Tipo de denuncia</span> 
						<select
							id="catalogo_denuncias_idcatalogo_denuncias"
							name="catalogo_denuncias_idcatalogo_denuncias"
							class="form-control">
							<c:forEach items="${listdenuncias}" var="listdenuncia">
								<c:if test="${listdenuncia.idcatalogo_denuncias == denuncia.catalogo_denuncias_idcatalogo_denuncias}"></c:if>
								<option value="${listdenuncia.idcatalogo_denuncias}">${listdenuncia.nombre_tramite}</option>
							</c:forEach>
						</select>
					</div>
					<br>
					<!-- fin tipo denuncia -->
					<h4>Datos del denunciante</h4>
					<!-- Nombre -->
					<div class="input-group">
						<span class="input-group-addon">Nombre</span> <input type="text"
							class="form-control" id="nombre" name="nombre" required
							minlength="2" value="${denuncia.nombre}">
					</div>
					<br>
					<!-- fin nombre -->
					<!-- direccion -->
					<div class="input-group">
						<span class="input-group-addon">Dirección</span> <input
							type="text" class="form-control" id="direccion" name="direccion" value="${denuncia.direccion}">
					</div>
					<br>
					<!-- fin direccion -->
					<!-- inicio telefono -->
					<div class="input-group">
						<span class="input-group-addon">Teléfono</span> <input type="text"
							class="form-control" id="telefono" name="telefono"
							data-inputmask='"mask": "(999) 999-9999"' data-mask  value="${denuncia.telefono}"/>
					</div>
					<br>
					<!-- fin telefono -->
					<!-- correo electronico -->
					<div class="input-group">
						<span class="input-group-addon">Correo Electrónico</span> <input
							type="email" class="form-control" id="correo" name="correo"
							required minlength="2" value="${denuncia.correo}">
					</div>
					<br>
					<!-- fin correo -->
					<!-- inicio anonimo -->
					<div class="checkbox">
						<label>
						<c:choose>
						<c:when test="${denuncia.anonimo == 'on'}"><input type="checkbox" name="anonimo" id="anonimo" selected>Anónimo</c:when>
						<c:otherwise><input type="checkbox" name="anonimo" id="anonimo">Anónimo</c:otherwise>
						</c:choose>
						
						</label>
					</div>
					<br>
					<!-- fin anonimo -->
					<h4>Descripción de la denuncia</h4>
					<!-- inicio descripcion -->
					<div class="input-group">
						<span class="input-group-addon">Descripción</span>
						<textarea class="form-control" placeholder="Escriba"
							name="descripcion" id="descripcion">${denuncia.descripcion}</textarea>
					</div>
					<br>
					<!-- fin descripcion  -->
					<h4>Ubicación de la denuncia</h4>
					<!-- inciio calle -->
					<div class="input-group">
						<span class="input-group-addon">Calle</span> <input type="text"
							class="form-control" id="calle" name="calle" required value="${denuncia.calle}">
					</div>
					<br>
					<!-- fin calle -->
					<!-- inicio num ext -->
					<div class="input-group">
						<span class="input-group-addon">Núm. Exterior</span> <input
							type="text" class="form-control" id="numero_ext"
							name="numero_ext" required minlength="3" value="${denuncia.numero_ext}">
					</div>
					<br>
					<!-- fin num ext -->
					<!-- inicio num int -->
					<div class="input-group">
						<span class="input-group-addon">Núm. Interior</span> <input
							type="text" class="form-control" id="numero_int"
							name="numero_int" required minlength="3" value="${denuncia.numero_int}">
					</div>
					<br>
					<!-- fin num int -->
					<!-- inicio colonia -->
					<div class="input-group">
						<span class="input-group-addon">Colonia</span> <input type="text"
							class="form-control" id="colonia" name="colonia" required
							minlength="3" value="${denuncia.colonia}">
					</div>
					<br>
					<!-- fin colonia -->
					<!-- inicio ciudad -->
					<div class="input-group">
						<span class="input-group-addon">Ciudad</span> <input type="text"
							class="form-control" id="ciudad" name="ciudad" required
							minlength="3" value="${denuncia.ciudad}">
					</div>
					<br>
					<!-- fin ciudad -->
					<!-- inicio municipio -->
					<div class="input-group">
						<span class="input-group-addon">Municipio</span> <input
							type="text" class="form-control" id="municipio" name="municipio"
							required minlength="3" value="${denuncia.municipio}"> <input type="hidden"
							name="${_csrf.parameterName}" value="${_csrf.token}" />
					</div>
					<br>
					<!-- fin municipio -->
				</div>
				<!-- /.box-body -->
				<div class="box-footer">
				</div>
			</form>
			<!-- <input id="input-700" name="kartik-input-700[]" type="file" multiple class="file-loading"> -->
		</div>
		<!-- /.box -->
	</section>
	<section class="col-lg-7 connectedSortable"></section>
</div>