<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

<link
	href="<%=request.getContextPath()%>/resources/plugins/kartik-fileinput/css/fileinput.css"
	rel="stylesheet" type="text/css" />
<script
	src="<%=request.getContextPath()%>/resources/plugins/kartik-fileinput/js/fileinput.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/plugins/kartik-fileinput/js/fileinput_locale_es.js"></script>

<c:choose>
	<c:when test="${empty data}">
		<div id='primerGuardar'>
			<input id="input-700" name="kartik-input-700[]" type="file" multiple
				class="file-loading">
			<script>
				$("#input-700").fileinput({
					uploadUrl : "guardarImagen", // server upload action
					uploadAsync : false,

					showRemove : false,
					showUpload : false,
					showCaption : false,
					showPreview : true,
					showCancel : false,

					uploadExtraData : {
						UUID : $("#UUID").val()
					},

					maxFileCount : 5
				}).on("filebatchselected", function(event, files) {
					// trigger upload method immediately after files are selected
					$("#input-700").fileinput("upload");
				});
			</script>
		</div>
	</c:when>
	<c:otherwise>
		<div id='primerGuardar'>
			<input id="input-700" name="kartik-input-700[]" type="file" multiple
				class="file-loading">
			<script>
			 $.ajax({
					url:'imagenesUUI', //Url a donde la enviaremos
					type:'POST', //Metodo que usaremos
					data: "codec=" + $("#UUID").val(), //Le pasamos el objeto que creamos con los archivos
					success: function(response){
						// we have the response
						console.log(response);
						$("#input-700").fileinput({
						    uploadUrl: "guardarImagen", // server upload action
						    uploadAsync: false,
						    
						    showRemove: false,
						    showUpload:false,
							showCaption:false,
							showPreview:true,
							showCancel:false,
							
							uploadExtraData: {UUID: $("#UUID").val()},
							initialPreview: response.initialPreview,
							initialPreviewConfig: response.initialPreviewConfig,
						    

						    maxFileCount: 5
						}).on("filebatchselected", function(event, files) {
						    // trigger upload method immediately after files are selected
						    $("#input-700").fileinput("upload");
						});
						
					},
					error: function(e){
						
					}
					});
			</script>
		</div>
	</c:otherwise>
</c:choose>

