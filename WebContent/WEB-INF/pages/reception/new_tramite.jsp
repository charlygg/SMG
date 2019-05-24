<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
 	<script src="<%=request.getContextPath()%>/resources/plugins/typeahead/bootstrap3-typeahead.js"></script>
	<script src="<%=request.getContextPath()%>/resources/plugins/typeahead/bloodhound.js"></script>
<style>


</style>
<script>

var tramites = new Bloodhound({
	  datumTokenizer: Bloodhound.tokenizers.obj.whitespace('name'),
	  queryTokenizer: Bloodhound.tokenizers.whitespace,
	  //limit: 10,
	  prefetch: {
	    // url points to a json file that contains an array of tramite names, see
	    // https://github.com/twitter/typeahead.js/blob/gh-pages/data/tramites.json
	    url: '<%=request.getContextPath()%>/getArrayCatalogoTramites?rol='+$("#rol_usuario").val(),
	    // the json file contains an array of strings, but the Bloodhound
	    // suggestion engine expects JavaScript objects so this converts all of
	    // those strings
	    filter: function(list) {
	      return $.map(list, function(tramite) { return { name: tramite }; });
	    }
	  }
	});
	 
	// kicks off the loading/processing of `local` and `prefetch`
	tramites.initialize();
	 
	// passing in `null` for the `options` arguments will result in the default
	// options being used
	$('#typeahead').typeahead( {
	  source: tramites.ttAdapter()
	});
	
	function retornarDenuncias(){
		   $.ajax({
	           type: "GET",
	           url: "getFormTramite",
	           data: $("#formularioTramite").serialize(), // Adjuntar los campos del formulario enviado.
	           success: function(data)
	           {
	        	   $('#carga_tramite').html(data);
	        	   console.log("Entre success");
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
           		<form id="formularioTramite" role="form" >
           		<div id="prefetch" class="input-group input-group-sm">
  					<input id="typeahead" type="text" placeholder="Tramites" name="tramite" style=" width: 100%"> 
						<div class="input-group-btn">
						 	<span class="input-group-btn">
							<button class="btn btn-success btn-flat" type="button" onclick="retornarDenuncias()">Mostrar</button>
							</span>
						</div>
				</div>
				</form>
           	</div>
		</div>
	</section>
</div>
<div class="row">
	<section id="carga_tramite" class="col-lg-12">
	</section>
</div>
