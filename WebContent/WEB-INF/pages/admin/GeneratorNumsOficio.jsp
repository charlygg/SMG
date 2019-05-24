<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

<script type="text/javascript">
<!--

//-->
function consultaGenerator(){
	console.log($("#fomularioGenerator").serialize());
$.ajax({
	url:'getNumsOfics', //Url a donde la enviaremos
	type:'GET', //Metodo que usaremos
	data: $("#fomularioGenerator").serialize(), 
	success: function(response){
			alert(response);
			},
	error: function(e){
			
			}
});
}
</script>

<div class="row">
	<section class="col-lg-5 connectedSortable">
	<div class="box box-info">
                <div class="box-header with-border">
                  <h3 class="box-title">Generador de numeros </h3>
                </div>
                <form id="fomularioGenerator" role="form" >
                <div class="box-body">
					<div class="input-group">
						<span class="input-group-addon">Area</span>
						<select id="area" name="area" class="form-control">
							<option value="PA">Proteccion animal</option>
							<option value="IA">Impacto Ambiental</option>
							<option value="IV">Inspeccion y Vigilancia</option>
							<option value="CD">Control de descargas</option>
							<option value="RME">Residuos de Manejo especial</option>
							<option value="DJ">Direccion de Juridico</option>
						</select>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Tipo de numero</span>
						<select id="tipo" name="tipo" class="form-control">
							<option value="SPMARN">Oficio de Subsecretaria</option>
							<option value="DMA">Oficio de Direccion</option>
							<option value="AUTO">Numero de Autorizacion </option>
						</select>
					</div>
					<br>
                </div><!-- /.box-body -->
                <div class="box-footer">
                    <input id="btn_enviar" type="button" onclick="consultaGenerator()" class="submit btn btn-primary" value="Pedir"/>
                </div>
                </form>
              </div><!-- /.box -->
	</section>
	<section class="col-lg-7 connectedSortable">
	</section>
</div>