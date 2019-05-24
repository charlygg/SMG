<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

<script type="text/javascript">
<!--

//-->
// $("#f_recepcion_tramite").inputmask("d/m/y",{ "placeholder": "dd/mm/yyyy" });
// $("#f_tramite_concluido").inputmask("d/m/y",{ "placeholder": "dd/mm/yyyy" });		

$("#f_recepcion_tramite").datepicker({dateFormat: "dd/mm/yy"});
$("#f_tramite_concluido").datepicker({dateFormat: "dd/mm/yy"});

$("#idempresa").change(function() {
    $("#idestablecimiento").empty();
    
    $.getJSON('getArrayEstablecimientosPorEmpresa?idempresa='+$("#idempresa").val(),function(data){
        $('#DatosEstablecimiento').prop( "hidden", true );
        $("#idestablecimiento").append("<option value=''>Escoja una opción</option>");
        $.each(data, function(i,item){
            $("#idestablecimiento").append("<option value=\""+item.idcatalogo_perfilestablecimiento+"\">"+item.idcatalogo_perfilestablecimiento+"/"+item.colonia+"/"+item.municipio+"</option>");
        });
        $('#idestablecimiento').prop( "disabled", false );
        $('#establecimientomensajeria').prop( "hidden", true );
        $("#idestablecimientomens").append("<option value='' selected>Escoja una opción</option>");
        $.each(data, function(i,item){
            $("#idestablecimientomens").append("<option value=\""+item.idcatalogo_perfilestablecimiento+"\">"+item.idcatalogo_perfilestablecimiento+"/"+item.colonia+"/"+item.municipio+"</option>");
        });
        $('#idestablecimientomens').prop( "disabled", false );
    });
});

function llenaridestablecimiento(datos){
	 $.getJSON('getEstablecimientosByID?idestablecimiento='+datos,function(data){
//       console.log(JSON.stringify(data));
console.log('entro a investigar estaa');
$('#calleEstablecimiento').val(data.calle);
$('#numeroExteriorEstablecimiento').val(data.numeroExterior);
$('#numeroInteriorEstablecimiento').val(data.numeroInterior);
$('#coloniaEstablecimiento').val(data.colonia);
$('#municipioEstablecimiento').val(data.municipio);
$('#estadoEstablecimiento').val(data.estado);
$('#latitudEstablecimiento').val(data.latitud);
$('#longitudEstablecimiento').val(data.longitud);
      $('#DatosEstablecimiento').prop( "hidden", false );
  });
}

$("#idestablecimiento").change(function() {
	llenaridestablecimiento($("#idestablecimiento").val());
});

function llenaridestablecimientomens(datos){
	 $.getJSON('getEstablecimientosByID?idestablecimiento='+datos,function(data){
	    	
			$('#calleEstablecimientos').val(data.calle);
	        $('#numeroExteriorEstablecimientos').val(data.numeroExterior);
	        $('#numeroInteriorEstablecimientos').val(data.numeroInterior);
	        $('#coloniaEstablecimientos').val(data.colonia);
	        $('#municipioEstablecimientos').val(data.municipio);
	        $('#estadoEstablecimientos').val(data.estado);
	        $('#latitudEstablecimientos').val(data.latitud);
	        $('#longitudEstablecimientos').val(data.longitud);
	        $('#establecimientomensajeria').prop( "hidden", false );
	    });
}

$("#idestablecimientomens").change(function() {
	llenaridestablecimientomens($("#idestablecimientomens").val());
});

$("#idtramite").change(function() {
	$('#idestablecimiento').prop( "disabled", false );
	comboEstatus();
    $.getJSON('consultatramiteAutoriDispFinaRegisGene?idtramite='+$("#idtramite").val(),function(data){
    	$('#idempresa > option[value="'+data.idempresa+'"]').attr('selected', 'selected');
    	///LLenas catalogo de establecimientos
    		 $.getJSON('getArrayEstablecimientosPorEmpresa?idempresa='+$("#idempresa").val(),function(lista){
				console.log(JSON.stringify(lista));
				$.each(lista, function(i,item){
    			$("#idestablecimiento").append("<option value=\""+item.idcatalogo_perfilestablecimiento+"\">"+item.idcatalogo_perfilestablecimiento+"/"+item.colonia+"/"+item.municipio+"</option>");
    			$("#idestablecimientomens").append("<option value=\""+item.idcatalogo_perfilestablecimiento+"\">"+item.idcatalogo_perfilestablecimiento+"/"+item.colonia+"/"+item.municipio+"</option>");
				});
				 $('#idestablecimientomens').prop( "disabled", false );
				 $('#idestablecimiento').prop( "disabled", false );
				 $('#idestablecimiento > option[value="'+data.idestablecimiento+'"]').attr('selected', 'selected');
			     $('#idestablecimientomens > option[value="'+data.idestablecimientomens+'"]').attr('selected', 'selected');
			       
				
		});
    		 llenaridestablecimiento(data.idestablecimiento);
    		 llenaridestablecimientomens(data.idestablecimientomens);
    		 $('#f_recepcion_tramite').val(data.f_recepcion_tramite);
			 $('#f_tramite_concluido').val(data.f_tramite_concluido);			

    	$('#asunto').val(data.asunto);
    	 $('#cp').val(data.cp);
        $('#nombreconp').val(data.nombreconp);
        $('#rfcp').val(data.rfcp);
        $('#ladap').val(data.ladap);
        $('#telefonop').val(data.telefonop);
        $('#extensionp').val(data.extensionp);
        $('#emailp').val(data.emailp);
        $('#idestablecimientomens').val(data.idestablecimientomens);
        $('#cps').val(data.cps);
        $('#nombrecons').val(data.nombrecons);
        $('#rfcs').val(data.rfcs);
        $('#ladas').val(data.ladas);
        $('#telefonos').val(data.telefonos);
        $('#extensions').val(data.extensions);
        $('#emails').val(data.emails);
       
        $('input[name="giro"][value="'+data.giro+'"]').prop('checked', true);
        
        $('#especificar').val(data.especificar);
        $('#productofinal').val(data.productofinal);
        $('#sitiodispfinac').val(data.sitiodispfinac);
        
        $('#descproceprod').val(data.descproceprod);
        $('#procesogeneraa').val(data.procesogeneraa);
        $('#emprecolectoraa').val(data.emprecolectoraa);
        $('#numautorizaciona').val(data.numautorizaciona);
        $('#residuoa').val(data.residuoa);
        $('#generamensuala').val(data.generamensuala);
        $('#sitiodispfinala').val(data.sitiodispfinala);
        $('#residuob').val(data.residuob);
        $('#procesogenerab').val(data.procesogenerab);
        $('#emprecolectorab').val(data.emprecolectorab);
        $('#generamensualb').val(data.generamensualb);
        $('#sitiodispfinalb').val(data.sitiodispfinalb);
        $('#numautorizacionb').val(data.numautorizacionb);
        $('#residuoc').val(data.residuoc);
        $('#procesogenerac').val(data.procesogenerac);
        $('#emprecolectorac').val(data.emprecolectorac);
        $('#numautorizacionc').val(data.numautorizacionc);
        $('#generamensualc').val(data.generamensualc);
        $('#sitiodispfinalc').val(data.sitiodispfinalc);
        $('#residuod').val(data.residuod);
        $('#procesogenerad').val(data.procesogenerad);
        $('#emprecolectorad').val(data.emprecolectorad);
        $('#numautorizaciond').val(data.numautorizaciond);
        $('#generamensuald').val(data.generamensuald);
        $('#sitiodispfinald').val(data.sitiodispfinald);
        $('#residuoe').val(data.residuoe);
        $('#procesogenerae').val(data.procesogenerae);
        $('#emprecolectorae').val(data.emprecolectorae);
        $('#numautorizacione').val(data.numautorizacione);
        $('#generamensuale').val(data.generamensuale);
        $('#generamensuale').val(data.generamensuale);
        $('#sitiodispfinale').val(data.sitiodispfinale);
        $('#residuof').val(data.residuof);
        $('#residuof').val(data.residuof);
        $('#procesogeneraf').val(data.procesogeneraf);
        $('#emprecolectoraf').val(data.emprecolectoraf);
        $('#numautorizacionf').val(data.numautorizacionf);
        $('#generamensualf').val(data.generamensualf);
        $('#sitiodispfinalf').val(data.sitiodispfinalf);
        $('#materialreciclablea').val(data.materialreciclablea);
        $('#gentonpormesa').val(data.gentonpormesa);
        $('#procgeneraa').val(data.procgeneraa);
        $('#empcompmata').val(data.empcompmata);
        $('#numautcompventa').val(data.numautcompventa);
        $('#numauttransrecica').val(data.numauttransrecica);
        $('#materialreciclableb').val(data.materialreciclableb);
        $('#gentonpormesb').val(data.gentonpormesb);
        $('#procgenerab').val(data.procgenerab);
        $('#empcompmatb').val(data.empcompmatb);
        $('#numautcompventb').val(data.numautcompventb);
        $('#numauttransrecicb').val(data.numauttransrecicb);
        $('#materialreciclablec').val(data.materialreciclablec);
        $('#gentonpormesc').val(data.gentonpormesc);
        $('#procgenerac').val(data.procgenerac);
        $('#empcompmatc').val(data.empcompmatc);
        $('#numautcompventc').val(data.numautcompventc);
        $('#numauttransrecicc').val(data.numauttransrecicc);
        $('#empcompmatc').val(data.empcompmatc);
        $('#materialreciclabled').val(data.materialreciclabled);
        $('#gentonpormesd').val(data.gentonpormesd);
        $('#procgenerad').val(data.procgenerad);
        $('#empcompmatd').val(data.empcompmatd);
        $('#numautcompventd').val(data.numautcompventd);
        $('#numauttransrecicd').val(data.numauttransrecicd);
        $('#materialreciclablee').val(data.materialreciclablee);
        $('#gentonpormese').val(data.gentonpormese);
        $('#procgenerae').val(data.procgenerae);
        $('#empcompmate').val(data.empcompmate);
        $('#numautcompvente').val(data.numautcompvente);
        $('#numauttransrecice').val(data.numauttransrecice);
        $('#usoindustrial').val(data.usoindustrial);
        $('#usotro').val(data.usotro);
        $('#rtgadescripcion').val(data.rtgadescripcion);
        $('#rtgafreclimp').val(data.rtgafreclimp);
        $('#rtgacapacidadm3tramp').val(data.rtgacapacidadm3tramp);
        $('#rtgageneramens').val(data.rtgageneramens);
        $('#rtgalugdisrestra').val(data.rtgalugdisrestra);
        $('#rtganumafprov').val(data.rtganumafprov);
        
        
        $('#UUID').val(data.uuid);
   	 console.log(data.uuid);
   	 var codec= data.uuid;
   	 //cargar las imagenes 
   	 $.ajax({
			url:'imagenesUUI', //Url a donde la enviaremos
			type:'POST', //Metodo que usaremos
			data: "codec=" + codec, //Le pasamos el objeto que creamos con los archivos
			success: function(response){
				// we have the response
				console.log(response);
				$("#input-700").fileinput('refresh',{
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
        
        $("#estatus").empty();
        cargaTablaMovsBitacora(data.estatus);
        if($("#rol_usuario").val() == 'ROLE_RECEP'){
        	if(data.estatus == 1){
        		$("#estatus").append("<option value='1'>Nuevo</option>");
        		$("#estatus").append("<option value='2'>Recibido</option>");
        	}else{
        		$("#estatus").append("<option value='1'>Nuevo</option>");
        	}
        }else{
        	switch(data.estatus){
	        case 2:
	        	$("#estatus").append("<option value='2'>Recibido</option>");
	        	$("#estatus").append("<option value='3'>Proceso</option>");
	        	$('#btn_enviar').prop('disabled', false);
	        	break;
	        case 3:
	        	$("#estatus").append("<option value='3'>Proceso</option>");
	        	$("#estatus").append("<option value='4'>Documentacion</option>");
	        	$("#estatus").append("<option value='5'>Terminado</option>");
	        	$('#btn_enviar').prop('disabled', false);
	        	///mostar el numero de oficio
	        	$('#ocultarNumOficio').show(); //muestro mediante id
	        	break;
	        case 4:
	        	$("#estatus").append("<option value='4'>Documentacion</option>");
	        	$('#btn_enviar').prop('disabled', false);
	        	break;
	        case 5:
	        	$("#estatus").append("<option value='5'>Terminado</option>");
	        	$('#btn_enviar').prop('disabled', true);
	        	break;
	        default:
        		$("#estatus").append("<option value='1'>Nuevo..</option>");
        		$('#btn_enviar').prop('disabled', false);
        	}
        	
        }
        
        
    });
});

$(document).ready(function() {
		$.validator.setDefaults({submitHandler: function() { transaccionDatosRetornoID( 'registertramiteAutoriDispFinaRegisGene', 'formulario', true, "exito()", "fallo()");}});
		$('#formulario').validate();
		comboListaTramite();
		comboEstatus();
});
	function comboEstatus(){
		$("#estatus").empty();
		if($("#rol_usuario").val() == 'ROLE_RECEP'){
        	$("#estatus").append("<option value='1'>Nuevo</option>");	
        }
    }
	function comboListaTramite(){
		$('#idtramite').empty();
		$.getJSON('listacombotramiteAutoriDispFinaRegisGene?rol_usuario='+$("#rol_usuario").val(),function(data){
	        //datos para el combo
	        if($("#rol_usuario").val() != 'ROLE_RECEP'){
	        	$("#idtramite").append("<option value=''>Escoja una opción</option>");	
	        }else{
	        	$("#idtramite").append("<option value='0'>Escoja una opción</option>");
	        }
	        
	        $.each(data, function(i,item){
// 	        	 console.log(item.idtramite);
	        	 var estatus = ''; 
	        	switch(item.estatus){
	        		case 1 : estatus = 'Nuevo';break;
	        		case 2 : estatus = 'Recibido';break;
	        		case 3 : estatus = 'Proceso';break;
	        		case 4 : estatus = 'Documentación';break;
	        		case 5 : estatus = 'Terminado';break;
	        		default : estatus = 'nuevo..';
	        	}	 
	            $("#idtramite").append("<option value=\""+item.idtramite+"\">Trámite No "+item.idtramite+" en Estatus "+estatus+"</option>");
	        });
	        
	    });
	}
	
	function exito(){
// 		mensajeriaAlertas('Exito', 'En Alta de Tramite Autorización para la disposición final y registro como generador.')
		comboListaTramite();
		$('#DatosEstablecimiento').hide();
		$('#idtramite').eq(1).prop('selected', true);
		$('#idempresa').eq(1).prop('selected', true);
		$("#idestablecimiento").eq(1).prop('selected', true);
		document.getElementById("idempresa").selectedIndex = 0;
		document.getElementById("idestablecimiento").selectedIndex = -1;
		document.getElementById("estatus").selectedIndex = 0;
		///mostar el numero de oficio
    	$('#ocultarNumOficio').hide(); //muestro mediante id
		$('#divCargaBitacora').hide();
		$('#divCargaBitacora').empty();
	}
	function fallo(){
		mensajeriaAlertas('Error', 'En Alta de Tramite Autorización para la disposición final y registro como generador.')
		$('#DatosEstablecimiento').hide();
		$('#idtramite').eq(1).prop('selected', true);
		$('#idempresa').eq(1).prop('selected', true);
		$("#idestablecimiento").eq(1).prop('selected', true);
		document.getElementById("idempresa").selectedIndex = 0;
		document.getElementById("idestablecimiento").selectedIndex = -1;
		document.getElementById("estatus").selectedIndex = 0;
		$('#divCargaBitacora').hide();
		$('#divCargaBitacora').empty();
	}
	
	if($("#busquedaTramite").val() != 0){
		$('#idestablecimiento').prop( "disabled", false );
		comboEstatus();
	    $.getJSON('consultatramiteAutoriDispFinaRegisGene?idtramite='+$("#busquedaTramite").val(),function(data){
	    	$('#idempresa > option[value="'+data.idempresa+'"]').attr('selected', 'selected');
	    	///LLenas catalogo de establecimientos
	    		 $.getJSON('getArrayEstablecimientosPorEmpresa?idempresa='+$("#idempresa").val(),function(lista){
					console.log(JSON.stringify(lista));
					$.each(lista, function(i,item){
	    			$("#idestablecimiento").append("<option value=\""+item.idcatalogo_perfilestablecimiento+"\">"+item.idcatalogo_perfilestablecimiento+"/"+item.colonia+"/"+item.municipio+"</option>");
	    			$("#idestablecimientomens").append("<option value=\""+item.idcatalogo_perfilestablecimiento+"\">"+item.idcatalogo_perfilestablecimiento+"/"+item.colonia+"/"+item.municipio+"</option>");
					});
					 $('#idestablecimientomens').prop( "disabled", false );
					 $('#idestablecimiento').prop( "disabled", false );
					 $('#idestablecimiento > option[value="'+data.idestablecimiento+'"]').attr('selected', 'selected');
				    	$('#idestablecimientomens > option[value="'+data.idestablecimientomens+'"]').attr('selected', 'selected');
				    	
					
			});
	    		 $('#f_recepcion_tramite').val(data.f_recepcion_tramite);
				 $('#f_tramite_concluido').val(data.f_tramite_concluido);			
	    	$('#asunto').val(data.asunto);
	        $('#cp').val(data.cp);
	        $('#nombreconp').val(data.nombreconp);
	        $('#rfcp').val(data.rfcp);
	        $('#ladap').val(data.ladap);
	        $('#telefonop').val(data.telefonop);
	        $('#extensionp').val(data.extensionp);
	        $('#emailp').val(data.emailp);
	        $('#idestablecimientomens').val(data.idestablecimientomens);
	        $('#cps').val(data.cps);
	        $('#nombrecons').val(data.nombrecons);
	        $('#rfcs').val(data.rfcs);
	        $('#ladas').val(data.ladas);
	        $('#telefonos').val(data.telefonos);
	        $('#extensions').val(data.extensions);
	        $('#emails').val(data.emails);
	        
	        $('input[name="giro"][value="'+data.giro+'"]').prop('checked', true);
	        $('#especificar').val(data.especificar);
	        $('#productofinal').val(data.productofinal);
	        $('#sitiodispfinac').val(data.sitiodispfinac);
	        
	        $('#descproceprod').val(data.descproceprod);
	        $('#procesogeneraa').val(data.procesogeneraa);
	        $('#emprecolectoraa').val(data.emprecolectoraa);
	        $('#numautorizaciona').val(data.numautorizaciona);
	        $('#residuoa').val(data.residuoa);
	        $('#generamensuala').val(data.generamensuala);
	        $('#sitiodispfinala').val(data.sitiodispfinala);
	        $('#residuob').val(data.residuob);
	        $('#procesogenerab').val(data.procesogenerab);
	        $('#emprecolectorab').val(data.emprecolectorab);
	        $('#generamensualb').val(data.generamensualb);
	        $('#sitiodispfinalb').val(data.sitiodispfinalb);
	        $('#numautorizacionb').val(data.numautorizacionb);
	        $('#residuoc').val(data.residuoc);
	        $('#procesogenerac').val(data.procesogenerac);
	        $('#emprecolectorac').val(data.emprecolectorac);
	        $('#numautorizacionc').val(data.numautorizacionc);
	        $('#generamensualc').val(data.generamensualc);
	        $('#sitiodispfinalc').val(data.sitiodispfinalc);
	        $('#residuod').val(data.residuod);
	        $('#procesogenerad').val(data.procesogenerad);
	        $('#emprecolectorad').val(data.emprecolectorad);
	        $('#numautorizaciond').val(data.numautorizaciond);
	        $('#generamensuald').val(data.generamensuald);
	        $('#sitiodispfinald').val(data.sitiodispfinald);
	        $('#residuoe').val(data.residuoe);
	        $('#procesogenerae').val(data.procesogenerae);
	        $('#emprecolectorae').val(data.emprecolectorae);
	        $('#numautorizacione').val(data.numautorizacione);
	        $('#generamensuale').val(data.generamensuale);
	        $('#generamensuale').val(data.generamensuale);
	        $('#sitiodispfinale').val(data.sitiodispfinale);
	        $('#residuof').val(data.residuof);
	        $('#residuof').val(data.residuof);
	        $('#procesogeneraf').val(data.procesogeneraf);
	        $('#emprecolectoraf').val(data.emprecolectoraf);
	        $('#numautorizacionf').val(data.numautorizacionf);
	        $('#generamensualf').val(data.generamensualf);
	        $('#sitiodispfinalf').val(data.sitiodispfinalf);
	        $('#materialreciclablea').val(data.materialreciclablea);
	        $('#gentonpormesa').val(data.gentonpormesa);
	        $('#procgeneraa').val(data.procgeneraa);
	        $('#empcompmata').val(data.empcompmata);
	        $('#numautcompventa').val(data.numautcompventa);
	        $('#numauttransrecica').val(data.numauttransrecica);
	        $('#materialreciclableb').val(data.materialreciclableb);
	        $('#gentonpormesb').val(data.gentonpormesb);
	        $('#procgenerab').val(data.procgenerab);
	        $('#empcompmatb').val(data.empcompmatb);
	        $('#numautcompventb').val(data.numautcompventb);
	        $('#numauttransrecicb').val(data.numauttransrecicb);
	        $('#materialreciclablec').val(data.materialreciclablec);
	        $('#gentonpormesc').val(data.gentonpormesc);
	        $('#procgenerac').val(data.procgenerac);
	        $('#empcompmatc').val(data.empcompmatc);
	        $('#numautcompventc').val(data.numautcompventc);
	        $('#numauttransrecicc').val(data.numauttransrecicc);
	        $('#empcompmatc').val(data.empcompmatc);
	        $('#materialreciclabled').val(data.materialreciclabled);
	        $('#gentonpormesd').val(data.gentonpormesd);
	        $('#procgenerad').val(data.procgenerad);
	        $('#empcompmatd').val(data.empcompmatd);
	        $('#numautcompventd').val(data.numautcompventd);
	        $('#numauttransrecicd').val(data.numauttransrecicd);
	        $('#materialreciclablee').val(data.materialreciclablee);
	        $('#gentonpormese').val(data.gentonpormese);
	        $('#procgenerae').val(data.procgenerae);
	        $('#empcompmate').val(data.empcompmate);
	        $('#numautcompvente').val(data.numautcompvente);
	        $('#numauttransrecice').val(data.numauttransrecice);
	        $('#usoindustrial').val(data.usoindustrial);
	        $('#usotro').val(data.usotro);
	        $('#rtgadescripcion').val(data.rtgadescripcion);
	        $('#rtgafreclimp').val(data.rtgafreclimp);
	        $('#rtgacapacidadm3tramp').val(data.rtgacapacidadm3tramp);
	        $('#rtgageneramens').val(data.rtgageneramens);
	        $('#rtgalugdisrestra').val(data.rtgalugdisrestra);
	        $('#rtganumafprov').val(data.rtganumafprov);
	        
	        $('#UUID').val(data.uuid);
       	 console.log(data.uuid);
       	 var codec= data.uuid;
       	 //cargar las imagenes 
       	 $.ajax({
				url:'imagenesUUI', //Url a donde la enviaremos
				type:'POST', //Metodo que usaremos
				data: "codec=" + codec, //Le pasamos el objeto que creamos con los archivos
				success: function(response){
					// we have the response
					console.log(response);
					 $('#primerGuardar').prop( "hidden", true );
					 $('#segundoGuardar').prop( "hidden", false );
					$("#input-700").fileinput('refresh',{
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
	        
	        $("#estatus").empty();
	        if($("#rol_usuario").val() == 'ROLE_RECEP'){
	        	if(data.estatus == 1){
	        		$("#estatus").append("<option value='1'>Nuevo</option>");
	        		$("#estatus").append("<option value='2'>Recibido</option>");
	        	}else{
	        		$("#estatus").append("<option value='1'>Nuevo</option>");
	        	}
	        }else{
	        	switch(data.estatus){
		        case 2:
		        	$("#estatus").append("<option value='2'>Recibido</option>");
		        	$("#estatus").append("<option value='3'>Proceso</option>");
		        	$('#btn_enviar').prop('disabled', false);
		        	break;
		        case 3:
		        	$("#estatus").append("<option value='3'>Proceso</option>");
		        	$("#estatus").append("<option value='4'>Documentacion</option>");
		        	$("#estatus").append("<option value='5'>Terminado</option>");
		        	$('#btn_enviar').prop('disabled', false);
		        	break;
		        case 4:
		        	$("#estatus").append("<option value='4'>Documentacion</option>");
		        	$('#btn_enviar').prop('disabled', false);
		        	break;
		        case 5:
		        	$("#estatus").append("<option value='5'>Terminado</option>");
		        	$('#btn_enviar').prop('disabled', true);
		        	break;
		        default:
	        		$("#estatus").append("<option value='1'>Nuevo..</option>");
	        		$('#btn_enviar').prop('disabled', false);
	        	}
	        	
	        }
	        
	        
	    });
	}
	function cargaTablaMovsBitacora(estatus){
		if(estatus == 1){
			$('#divCargaBitacora').hide();
			$('#divCargaBitacora').empty();
		}else{
			$('#divCargaBitacora').show();
			$('#divCargaBitacora').load('consultaBitacoraCatReg?idregistro='+$('#idtramite').val()+'&catalogoID='+$('#tramite_catalogoID').val());
		}
		
		
	}
</script>

<div class="row">
	<div class="col-lg-12">
		<div class="box box-success">
			<div class="box-header with-border">
				<h3>Autorización para la disposición final y registro como
					generador.</h3>
			</div>

			<div class="box-body">
				<!-- elemntos que se cambian por tramite -->
				<input type="hidden" id="areaNumOficio" value="RME"> <input
					type="hidden" id="titleNumOficio"
					value="Tramite Autorización para la disposición final y registro como generador">
				<input type="hidden" id="tipoTramiteNumOficio" value="27">
				<%@ include
					file="/WEB-INF/pages/formularios_tramites/numerOficio.jsp"%>
				<!-- terminas elementos  -->
				<form id="formulario" role="form">
					<c:choose>
						<c:when test="${empty data}">
							<div class="input-group" id="dividtramite">
								<span class="input-group-addon">Trámites en Ejecución</span> <select
									class="form-control" id="idtramite" name="idtramite"></select>

							</div>
							<br>

						</c:when>
					</c:choose>
					<div class="input-group">
						<span class="input-group-addon">Asunto</span>
						<c:choose>
							<c:when test="${!empty data}">
								<textarea id="asunto" name="asunto" class="form-control"
									required>${data.asunto}</textarea>
							</c:when>
							<c:otherwise>
								<textarea id="asunto" name="asunto" class="form-control"
									required></textarea>
							</c:otherwise>
						</c:choose>
					</div>
					<br>
					 <div class="input-group">
                    	<span class="input-group-addon">Fecha de recepcón de documentación de tramite</span>
                     	<c:choose>
								<c:when test="${!empty data}">
								<input type="text" id="f_recepcion_tramite" name="f_recepcion_tramite" class="form-control" value="${data.f_recepcion_tramite}">
								</c:when>
								<c:otherwise>
								<input type="text" id="f_recepcion_tramite" name="f_recepcion_tramite" class="form-control">
								</c:otherwise>
							</c:choose>
                    </div>
                    <br>
                    <div class="input-group">
                    	<span class="input-group-addon">Fecha de tramite concluido</span>
                     	<c:choose>
								<c:when test="${!empty data}">
								<input type="text"  id="f_tramite_concluido" name="f_tramite_concluido" class="form-control" value="${data.f_tramite_concluido}">
								
								</c:when>
								<c:otherwise>
								<input type="text"  id="f_tramite_concluido" name="f_tramite_concluido" class="form-control">
								</c:otherwise>
							</c:choose>
                    </div>
					<br>
					<!-- UUID clave archivos -->
					<!--  -->
					<c:choose>
						<c:when test="${empty data}">
							<input type="hidden" id="UUID" name="UUID" value="${UUID}">
							<input type="hidden" id="busquedaTramite" name="busquedaTramite"
								value="0">
						</c:when>
						<c:otherwise>
							<input type="hidden" id="UUID" name="UUID" value="${data.UUID}">
							<input type="hidden" id="busquedaTramite" name="busquedaTramite"
								value="${data.idtramite}">
						</c:otherwise>
					</c:choose>
					<!--  -->

					<div class="input-group">
						<!-- <input type="hidden" id="idtramite" name="idtramite" value="0"> -->
						<span class="input-group-addon">Nombre de Empresa</span> <select
							id="idempresa" name="idempresa" class="form-control" required>
							<option value="">Escoja una opción</option>
							<c:forEach items="${empresas}" var="empresa">
								<option value="${empresa.idcatalogo_perfilempresa}">${empresa.nombreEmpresa}</option>
							</c:forEach>
						</select>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Domicilio de la planta o
							negociación(Establecimiento)</span> <select id="idestablecimiento"
							name="idestablecimiento" class="form-control" required>
						</select>
					</div>
					<br>
					<!-- inicia bloque oculto -->
					<div id="DatosEstablecimiento" class="container" hidden>

						<h3>Domicilio:</h3>

						<div class="input-group">
							<span class="input-group-addon">Calle</span> <input type="text"
								maxlength="100" id="calleEstablecimiento" class="form-control"
								readonly>
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon">Número Exterior</span> <input
								maxlength="100" type="numeroExteriorEstablecimiento"
								id="numeroExterior" class="form-control" readonly>
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon">Número Interior</span> <input
								maxlength="100" type="text" id="numeroInteriorEstablecimiento"
								class="form-control" readonly>
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon">Colonia</span> <input type="text"
								maxlength="100" id="coloniaEstablecimiento" class="form-control"
								readonly>
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon">Municipio</span> <input
								maxlength="100" type="text" id="municipioEstablecimiento"
								class="form-control" readonly>
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon">Estado</span> <input type="text"
								maxlength="100" id="estadoEstablecimiento" class="form-control"
								readonly>
						</div>
						<br>

						<div class="input-group">
							<span class="input-group-addon">Latitud</span> <input type="text"
								maxlength="100" id="latitudEstablecimiento" class="form-control"
								readonly>
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon">Longitud</span> <input
								maxlength="100" type="text" id="longitudEstablecimiento"
								class="form-control" readonly>
						</div>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Código Postal</span> <input
							maxlength="100" type="text" id="cp" name="cp"
							class="form-control">
					</div>
					<br> <br>
					<div class="input-group">
						<span class="input-group-addon">Nombre del Contacto:</span> <input
							maxlength="100" type="text" id="nombreconp" name="nombreconp"
							class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">R.F.C.:</span> <input type="text"
							maxlength="100" id="rfcp" name="rfcp" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Lada:</span> <input type="text"
							maxlength="100" id="ladap" name="ladap" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Teléfono:</span> <input
							maxlength="100" type="text" id="telefonop" name="telefonop"
							class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Extensión:</span> <input
							maxlength="100" type="text" id="extensionp" name="extensionp"
							class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">e-mail:</span> <input type="text"
							maxlength="100" id="emailp" name="emailp" class="form-control">
					</div>
					<br>




					<div class="input-group">
						<span class="input-group-addon">Domicilio para oír y/o
							recibir notificaciones (omitir en caso que sea el mismo de la
							planta):</span> <select id="idestablecimientomens"
							name="idestablecimientomens" class="form-control" required>
						</select>
					</div>
					<br>
					<div id="establecimientomensajeria" class="container"
						hidden="hidden">

						<h3>Domicilio:</h3>

						<div class="input-group">
							<span class="input-group-addon">Calle</span> <input type="text"
								maxlength="100" id="calleEstablecimientos" class="form-control"
								readonly>
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon">Número Exterior</span> <input
								maxlength="100" type="text" id="numeroExteriorEstablecimientos"
								class="form-control" readonly>
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon">Número Interior</span> <input
								maxlength="100" type="text" id="numeroInteriorEstablecimientos"
								class="form-control" readonly>
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon">Colonia</span> <input type="text"
								maxlength="100" id="coloniaEstablecimientos"
								class="form-control" readonly>
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon">Municipio</span> <input
								maxlength="100" type="text" id="municipioEstablecimientos"
								class="form-control" readonly>
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon">Estado</span> <input type="text"
								maxlength="100" id="estadoEstablecimientos" class="form-control"
								readonly>
						</div>
						<br>


						<div class="input-group">
							<span class="input-group-addon">Latitud</span> <input type="text"
								maxlength="100" id="latitudEstablecimientos"
								class="form-control" readonly>
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon">Longitud</span> <input
								maxlength="100" type="text" id="longitudEstablecimientos"
								class="form-control" readonly>
						</div>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Código Postal</span> <input
							maxlength="100" type="text" id="cps" name="cps"
							class="form-control">
					</div>

					<br>
					<div class="input-group">
						<span class="input-group-addon">Nombre del Contacto:</span> <input
							maxlength="100" type="text" id="nombrecons" name="nombrecons"
							class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">R.F.C.:</span> <input type="text"
							maxlength="100" id="rfcs" name="rfcs" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Lada:</span> <input type="text"
							maxlength="100" id="ladas" name="ladas" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Teléfono:</span> <input
							maxlength="100" type="text" id="telefonos" name="telefonos"
							class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Extensión:</span> <input
							maxlength="100" type="text" id="extensions" name="extensions"
							class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">e-mail:</span> <input type="text"
							maxlength="100" id="emails" name="emails" class="form-control">
					</div>
					<br>

					<h3>ACTIVIDADES DE LA EMPRESA O NEGOCIACIÓN.:</h3>

					<div class="input-group">
						<span class="input-group-addon">Giro de la empresa o
							negociación:</span> <input type="radio" name="giro" value="I">Industrial
						&nbsp &nbsp &nbsp <input type="radio" name="giro" value="C">Comercial
						y/o Servicios &nbsp &nbsp &nbsp <input type="radio" name="giro"
							value="O">Otro
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Especificar:</span>
						<textarea id="especificar" name="especificar" class="form-control"></textarea>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Producto Final:</span>
						<textarea id="productofinal" name="productofinal"
							class="form-control"></textarea>
					</div>
					<br>

					<h3>Autorización para la disposición final y registro como
						generador:</h3>

					<div class="input-group">
						<span class="input-group-addon"> Descripción del proceso
							productivo.:</span>
						<textarea id="descproceprod" name="descproceprod"
							class="form-control"></textarea>
					</div>

					<h2>Describir los residuos que se generan del proceso
						productivo y actividades de la negociación que van a disposición
						final: (Relleno Sanitario)</h2>


					<div class="input-group">
						<span class="input-group-addon">Residuo</span> <input type="text"
							maxlength="100" id="residuoa" name="residuoa"
							class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Proceso del cual se genera</span>
						<input type="text" maxlength="100" id="procesogeneraa"
							name="procesogeneraa" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Empresa Recolectora</span> <input
							maxlength="100" type="text" id="emprecolectoraa"
							name="emprecolectoraa" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Nº de Autorización</span> <input
							maxlength="100" type="text" id="numautorizaciona"
							name="numautorizaciona" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Generación mensual (Ton)</span> <input
							maxlength="100" type="text" id="generamensuala"
							name="generamensuala" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Sitio de disposición final
							(Relleno Sanitario):</span>
						<textarea id="sitiodispfinala" name="sitiodispfinala"
							class="form-control"></textarea>
					</div>
					<br>

					<div class="input-group">
						<span class="input-group-addon">Residuo</span> <input type="text"
							maxlength="100" id="residuob" name="residuob"
							class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Proceso del cual se genera</span>
						<input type="text" maxlength="100" id="procesogenerab"
							name="procesogenerab" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Empresa Recolectora</span> <input
							maxlength="100" type="text" id="emprecolectorab"
							name="emprecolectorab" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Nº de Autorización</span> <input
							maxlength="100" type="text" id="numautorizacionb"
							name="numautorizacionb" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Generación mensual (Ton)</span> <input
							maxlength="100" type="text" id="generamensualb"
							name="generamensualb" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Sitio de disposición final
							(Relleno Sanitario):</span>
						<textarea id="sitiodispfinalb" name="sitiodispfinalb"
							class="form-control"></textarea>
					</div>
					<br>

					<div class="input-group">
						<span class="input-group-addon">Residuo</span> <input type="text"
							maxlength="100" id="residuoc" name="residuoc"
							class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Proceso del cual se genera</span>
						<input type="text" maxlength="100" id="procesogenerac"
							name="procesogenerac" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Empresa Recolectora</span> <input
							maxlength="100" type="text" id="emprecolectorac"
							name="emprecolectorac" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Nº de Autorización</span> <input
							maxlength="100" type="text" id="numautorizacionc"
							name="numautorizacionc" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Generación mensual (Ton)</span> <input
							maxlength="100" type="text" id="generamensualc"
							name="generamensualc" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Sitio de disposición final
							(Relleno Sanitario):</span>
						<textarea id="sitiodispfinalc" name="sitiodispfinalc"
							class="form-control"></textarea>
					</div>
					<br>

					<div class="input-group">
						<span class="input-group-addon">Residuo</span> <input type="text"
							maxlength="100" id="residuod" name="residuod"
							class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Proceso del cual se genera</span>
						<input type="text" maxlength="100" id="procesogenerad"
							name="procesogenerad" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Empresa Recolectora</span> <input
							maxlength="100" type="text" id="emprecolectorad"
							name="emprecolectorad" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Nº de Autorización</span> <input
							maxlength="100" type="text" id="numautorizaciond"
							name="numautorizaciond" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Generación mensual (Ton)</span> <input
							maxlength="100" type="text" id="generamensuald"
							name="generamensuald" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Sitio de disposición final
							(Relleno Sanitario):</span>
						<textarea id="sitiodispfinald" name="sitiodispfinald"
							class="form-control"></textarea>
					</div>
					<br>

					<div class="input-group">
						<span class="input-group-addon">Residuo</span> <input type="text"
							maxlength="100" id="residuoe" name="residuoe"
							class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Proceso del cual se genera</span>
						<input type="text" maxlength="100" id="procesogenerae"
							name="procesogenerae" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Empresa Recolectora</span> <input
							maxlength="100" type="text" id="emprecolectorae"
							name="emprecolectorae" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Nº de Autorización</span> <input
							maxlength="100" type="text" id="numautorizacione"
							name="numautorizacione" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Generación mensual (Ton)</span> <input
							maxlength="100" type="text" id="generamensuale"
							name="generamensuale" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Sitio de disposición final
							(Relleno Sanitario):</span>
						<textarea id="sitiodispfinale" name="sitiodispfinale"
							class="form-control"></textarea>
					</div>
					<br>

					<div class="input-group">
						<span class="input-group-addon">Residuo</span> <input type="text"
							maxlength="100" id="residuof" name="residuof"
							class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Proceso del cual se genera</span>
						<input type="text" maxlength="100" id="procesogeneraf"
							name="procesogeneraf" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Empresa Recolectora</span> <input
							maxlength="100" type="text" id="emprecolectoraf"
							name="emprecolectoraf" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Nº de Autorización</span> <input
							maxlength="100" type="text" id="numautorizacionf"
							name="numautorizacionf" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Generación mensual (Ton)</span> <input
							maxlength="100" type="text" id="generamensualf"
							name="generamensualf" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Sitio de disposición final
							(Relleno Sanitario):</span>
						<textarea id="sitiodispfinalf" name="sitiodispfinalf"
							class="form-control"></textarea>
					</div>
					<br>



					<h2>Describir los materiales reciclables que se generan del
						proceso productivo y actividades de la negociación.:</h2>

					<div class="input-group">
						<span class="input-group-addon">Material Reciclable</span> <input
							maxlength="100" type="text" id="materialreciclablea"
							name="materialreciclablea" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Generación (toneladas por
							mes)</span> <input type="text" maxlength="100" id="gentonpormesa"
							name="gentonpormesa" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Proceso del cual se genera</span>
						<input type="text" maxlength="100" id="procgeneraa"
							name="procgeneraa" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Empresa que compra el
							material.</span> <input type="text" maxlength="100" id="empcompmata"
							name="empcompmata" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Nº de Autorización de
							Compra Venta</span> <input type="text" maxlength="100"
							id="numautcompventa" name="numautcompventa" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Nº de Autorización de
							Transporte Reciclables</span> <input type="text" maxlength="100"
							id="numauttransrecica" name="numauttransrecica"
							class="form-control">
					</div>
					<br>

					<div class="input-group">
						<span class="input-group-addon">Material Reciclable</span> <input
							maxlength="100" type="text" id="materialreciclableb"
							name="materialreciclableb" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Generación (toneladas por
							mes)</span> <input type="text" maxlength="100" id="gentonpormesb"
							name="gentonpormesb" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Proceso del cual se genera</span>
						<input type="text" maxlength="100" id="procgenerab"
							name="procgenerab" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Empresa que compra el
							material.</span> <input type="text" maxlength="100" id="empcompmatb"
							name="empcompmatb" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Nº de Autorización de
							Compra Venta</span> <input type="text" maxlength="100"
							id="numautcompventb" name="numautcompventb" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Nº de Autorización de
							Transporte Reciclables</span> <input type="text" maxlength="100"
							id="numauttransrecicb" name="numauttransrecicb"
							class="form-control">
					</div>
					<br>

					<div class="input-group">
						<span class="input-group-addon">Material Reciclable</span> <input
							maxlength="100" type="text" id="materialreciclablec"
							name="materialreciclablec" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Generación (toneladas por
							mes)</span> <input type="text" maxlength="100" id="gentonpormesc"
							name="gentonpormesc" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Proceso del cual se genera</span>
						<input type="text" maxlength="100" id="procgenerac"
							name="procgenerac" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Empresa que compra el
							material.</span> <input type="text" maxlength="100" id="empcompmatc"
							name="empcompmatc" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Nº de Autorización de
							Compra Venta</span> <input type="text" maxlength="100"
							id="numautcompventc" name="numautcompventc" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Nº de Autorización de
							Transporte Reciclables</span> <input type="text" maxlength="100"
							id="numauttransrecicc" name="numauttransrecicc"
							class="form-control">
					</div>
					<br>

					<div class="input-group">
						<span class="input-group-addon">Material Reciclable</span> <input
							maxlength="100" type="text" id="materialreciclabled"
							name="materialreciclabled" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Generación (toneladas por
							mes)</span> <input type="text" maxlength="100" id="gentonpormesd"
							name="gentonpormesd" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Proceso del cual se genera</span>
						<input type="text" maxlength="100" id="procgenerad"
							name="procgenerad" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Empresa que compra el
							material.</span> <input type="text" maxlength="100" id="empcompmatd"
							name="empcompmatd" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Nº de Autorización de
							Compra Venta</span> <input type="text" maxlength="100"
							id="numautcompventd" name="numautcompventd" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Nº de Autorización de
							Transporte Reciclables</span> <input type="text" maxlength="100"
							id="numauttransrecicd" name="numauttransrecicd"
							class="form-control">
					</div>
					<br>

					<div class="input-group">
						<span class="input-group-addon">Material Reciclable</span> <input
							maxlength="100" type="text" id="materialreciclablee"
							name="materialreciclablee" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Generación (toneladas por
							mes)</span> <input type="text" maxlength="100" id="gentonpormese"
							name="gentonpormese" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Proceso del cual se genera</span>
						<input type="text" maxlength="100" id="procgenerae"
							name="procgenerae" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Empresa que compra el
							material.</span> <input type="text" maxlength="100" id="empcompmate"
							name="empcompmate" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Nº de Autorización de
							Compra Venta</span> <input type="text" maxlength="100"
							id="numautcompvente" name="numautcompvente" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Nº de Autorización de
							Transporte Reciclables</span> <input type="text" maxlength="100"
							id="numauttransrecice" name="numauttransrecice"
							class="form-control">
					</div>
					<br>

					<h2>Registro de la trampa de grasas y aceites.</h2>

					<br>
					<div class="input-group">
						<span class="input-group-addon">Uso</span> <input type="checkbox"
							id="usoindustrial" name="usoindustrial">Industrial de
						proceso &nbsp &nbsp &nbsp <input type="checkbox" id="usotro"
							name="usotro">Otros &nbsp &nbsp &nbsp
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Descripción</span>
						<textarea id="rtgadescripcion" name="rtgadescripcion"
							class="form-control"></textarea>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Frecuencia de Limpieza</span> <input
							maxlength="100" type="text" id="rtgafreclimp" name="rtgafreclimp"
							class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Capacidad m3 de la Trampa</span> <input
							maxlength="100" type="text" id="rtgacapacidadm3tramp"
							name="rtgacapacidadm3tramp" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Generación mensual:</span> <input
							maxlength="100" type="text" id="rtgageneramens"
							name="rtgageneramens" class="form-control">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Lugar de disposición de los
							residuos de la trampa:</span>
						<textarea id="rtgalugdisrestra" name="rtgalugdisrestra"
							class="form-control"></textarea>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Número de afolio
							provisional:</span> <input type="text" maxlength="100"
							id="rtganumafprov" name="rtganumafprov" class="form-control">
					</div>
					<br>

					<div class="input-group">
						<span class="input-group-addon"></span> <select id="estatus"
							name="estatus" class="form-control"></select>
					</div>
					<!-- Archivo -->
					<%@ include
						file="/WEB-INF/pages/formularios_tramites/seccionArchivos.jsp"%>
					<br> <br>
					<c:choose>
						<c:when test="${empty data}">
							<input id="btn_enviar" type="submit"
								class="submit btn btn-primary" value="Guardar" />
						</c:when>
					</c:choose>
					<!--  -->
				</form>
			</div>
			<!-- /.box-body -->
			<div class="box-footer"></div>
		</div>
		<!-- /.box -->
	</div>
</div>
<div class="row">
	<input type="hidden" id="tramite_catalogoID" value="${ catalogoID }">
	<div id="divCargaBitacora" style="overflow-y: scroll;"></div>
</div>