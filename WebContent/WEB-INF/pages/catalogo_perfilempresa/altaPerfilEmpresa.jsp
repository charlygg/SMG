<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

 <script type="text/javascript">
 	var recurso = 'insertaPerfilEmpresa';
 	$(document).ready(function() {
 		$.validator.setDefaults({submitHandler: function() { transaccionDatos( recurso, 'formulario', true, "exito()", "fallo()");}});
 		$('#formulario').validate();
    });
 	
 	function exito(){
 		mensajeriaAlertas('Exito', 'En Alta de Perfil Empresa')
 		
 	}
 	function fallo(){
 		mensajeriaAlertas('Error', 'En Alta de Perfil Empresa')
 	}
	
	</script>

 
<!-- Custom tabs (Charts with tabs)-->
<div class="row">
	<section class="col-lg-5 connectedSortable">
	<div class="box box-info">
                <div class="box-header with-border">
                  <h3 class="box-title">Alta Perfil Empresa</h3>
                </div>
                <form id="formulario" role="form">
                <div class="box-body">
                  <div class="input-group">
                    <span class="input-group-addon">Nombre de Empresa</span>
                    <input type="text" class="form-control" placeholder="Nombre Empresa" id="nombreEmpresa" name="nombreEmpresa" required >
                  </div>
                  <br>
                  <div class="input-group">
                    <span class="input-group-addon">Respresentante Legal</span>
                    <input type="text" class="form-control" placeholder="Representante Legal" id="representanteLegal" name="representanteLegal" required>
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
              