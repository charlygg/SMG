<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

 <script type="text/javascript">
 	$(document).ready(function() {
 		$.validator.setDefaults({submitHandler: function() { transaccionDatos( 'registerUsuario', 'formularioUser', true, "mensajeriaAlertas('Exito', 'En Alta de Usuarios')", "mensajeriaAlertas('Error', 'En Alta de Usuarios')");}});
 		$('#formularioUser').validate();
    });
	</script>

 
<!-- Custom tabs (Charts with tabs)-->
<div class="row">
	<section class="col-lg-5 connectedSortable">
	<div class="box box-info">
                <div class="box-header with-border">
                  <h3 class="box-title">Altas Usuarios</h3>
                </div>
                <form id="formularioUser" role="form" >
                <div class="box-body">
                  <div class="input-group">
                    <span class="input-group-addon">Nombre</span>
                    <input type="text" class="form-control" placeholder="Nombre" id="nombre" name="nombre" required minlength="2">
                  </div>
                  <br>
                  <div class="input-group">
                    <span class="input-group-addon">Apellido Paterno</span>
                    <input type="text" class="form-control" placeholder="Apellido Parterno" id="apellidoPaterno" name="apellidoPaterno">
                  </div>
                   <br>
                  <div class="input-group">
                    <span class="input-group-addon">Apellido Materno</span>
                    <input type="text" class="form-control" placeholder="Apellido Materno" id="apellidoMaterno" name="apellidoMaterno">
                  </div>
                   <br>
                  <div class="input-group">
                    <span class="input-group-addon">Usuario</span>
                    <input type="text" class="form-control" placeholder="Usuario" id="username" name="username" required minlength="2">
                  </div>
                   <br>
                  <div class="input-group">
                    <span class="input-group-addon">Email</span>
                    <input type="email" class="form-control" placeholder="Correo Electrónico" id="email" name="email" required >
                  </div>
                   <br>
                   <div class="input-group">
                    <span class="input-group-addon">ID Rol</span>
                    <select id="role" name="role" class="form-control">
						<c:forEach items="${roles}" var="roles">
							<option value="${roles.role}">${roles.nombre}</option>
						</c:forEach>
					</select>
                  </div>
                   <br>
                  <div class="input-group">
                    <span class="input-group-addon">Pass</span>
                    <input type="password" class="form-control" placeholder="Contraseña" id="password" name="password" required minlength="3">
                  </div>
                   <br>
                  <div class="input-group">
                    <span class="input-group-addon">Confirma Pass</span>
                    <input type="password" class="form-control" placeholder="Confirmación Contraseña" id="cpasswordAltaU" required equalTo="#password">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                  </div>
					<br>
                </div><!-- /.box-body -->
                <div class="box-footer">
                    <input id="btn_enviar" type="submit" class="submit btn btn-primary" value="Guardar"/>
                </div>
                </form>
              </div><!-- /.box -->
	</section>
	<section class="col-lg-7 connectedSortable">
	</section>
</div>
              