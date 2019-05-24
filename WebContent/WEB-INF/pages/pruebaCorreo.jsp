<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<script type="text/javascript">
<!--

//-->
function enviarCorreo(){
	   $.ajax({
        type: "GET",
        url: "sendEmailExample",
        data: $("#formularioCorreo").serialize(), // Adjuntar los campos del formulario enviado.
        success: function(data)
        {
     	   console.log(data);
        },
        error: function(data){
     	   console.log("Entre error");
        }
      });
}
</script>
<div class="row">
	<section class="col-lg-6 connectedSortable">
		<div class="box box-success">
           	<div class="box-body">
           		<form id="formularioCorreo" role="form" >
           		<div id="prefetch" class="input-group input-group-sm">
  					<input id="typeahead" type="text" placeholder="Correo" name="correo" style=" width: 100%"> 
					<div class="input-group-btn">
					 <span class="input-group-btn">
						<button class="btn btn-success btn-flat" type="button" onclick="enviarCorreo()">Enviar</button>
					</span>
					</div>
				</div>
				</form>
           	</div>
		</div>
	</section>
</div>