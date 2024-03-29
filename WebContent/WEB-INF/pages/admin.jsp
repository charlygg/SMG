<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
  <head>
    <meta charset="UTF-8">
    <title>Admin | Dashboard</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <!-- Bootstrap 3.3.2 -->
    <link href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <!-- Font Awesome Icons -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Ionicons -->
    <link href="http://code.ionicframework.com/ionicons/2.0.0/css/ionicons.min.css" rel="stylesheet" type="text/css" />
    <!-- Theme style -->
    <link href="<%=request.getContextPath()%>/resources/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
    <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
          page. However, you can choose any other skin. Make sure you
          apply the skin class to the body tag so the changes take effect.
    -->
	<link href="<%=request.getContextPath()%>/resources/funciones/css/fileinput.css" media="all" rel="stylesheet" type="text/css" />
	<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
    <!-- jQuery 2.1.3 -->
    <script src="<%=request.getContextPath()%>/resources/plugins/jQuery/jQuery-2.1.3.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/funciones/fileinput.js" type="text/javascript"></script>
	
    <!-- Bootstrap 3.3.2 JS -->
    <script src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <!-- AdminLTE App -->
    <script src="<%=request.getContextPath()%>/resources/dist/js/app.min.js" type="text/javascript"></script> 
    <!-- Optionally, you can add Slimscroll and FastClick plugins. 
          Both of these plugins are recommended to enhance the 
          user experience -->
     <!-- REQUIRED JS SCRIPTS -->
    
    <!-- Optionally, you can add Slimscroll and FastClick plugins. 
          Both of these plugins are recommended to enhance the 
          user experience -->
    <script src="//cdn.datatables.net/1.10.5/js/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/resources/plugins/datatables/dataTables.bootstrap.js" type="text/javascript"></script>
<!--     <script src="http://cdn.jsdelivr.net/jquery.validation/1.13.1/jquery.validate.js" type="text/javascript"></script> -->
    <script src="<%=request.getContextPath()%>/resources/funciones/jquery.validate.min.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/resources/funciones/funcionesGenerales.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/resources/funciones/pnotify.js" type="text/javascript"></script>
	<link href="<%=request.getContextPath()%>/resources/funciones/css/pnotify.css" media="all" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath()%>/resources/funciones/css/lista.css" media="all" rel="stylesheet" type="text/css" />
	<script src="<%=request.getContextPath()%>/resources/funciones/fileinput_locale_es.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/resources/plugins/input-mask/jquery.inputmask.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/resources/plugins/input-mask/jquery.inputmask.date.extensions.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/resources/plugins/input-mask/jquery.inputmask.extensions.js" type="text/javascript"></script>
    <link href="<%=request.getContextPath()%>/resources/dist/css/skins/_all-skins.min.css" rel="stylesheet" type="text/css" />
	
  </head>
  <!--
  BODY TAG OPTIONS:
  =================
  Apply one or more of the following classes to get the 
  desired effect
  |---------------------------------------------------------|
  | SKINS         | skin-blue                               |
  |               | skin-black                              |
  |               | skin-purple                             |
  |               | skin-yellow                             |
  |               | skin-red                                |
  |               | skin-green                              |
  |---------------------------------------------------------|
  |LAYOUT OPTIONS | fixed                                   |
  |               | layout-boxed                            |
  |               | layout-top-nav                          |
  |               | sidebar-collapse                        |  
  |---------------------------------------------------------|
  
  -->
  <body class="skin-red-light">
  	<div id="datosGenerales">
  		<input type="hidden" id="rol_usuario" value="${role}">
  		<input type="hidden" id="nombre_usuario" value="${nombre}">
  		<input type="hidden" id="usuario_id" value="${usuario_id}">
  	</div>
    <div class="wrapper">

      <!-- Main Header -->
      <header class="main-header">

        <!-- Logo -->
        <a href="#" class="logo"><b>Administrador </b>SMG</a>

        <!-- Header Navbar -->
        <nav class="navbar navbar-static-top" role="navigation">
          <!-- Sidebar toggle button-->
          <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">Toggle navigation</span>
          </a>
          <!-- Navbar Right Menu -->
          <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
              <!-- Messages: style can be found in dropdown.less -->
              <!-- Menu toggle button -->
              <!-- Notifications Menu -->
              <!-- Menu toggle button -->
              <!-- Tasks Menu -->
              <!-- User Account Menu -->
              <li class="dropdown user user-menu">
                <!-- Menu Toggle Button -->
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                  <!-- The user image in the navbar-->
                  <img src="<%=request.getContextPath()%>/resources/dist/img/user2-160x160.jpg" class="user-image" alt="User Image"/>
                  <!-- hidden-xs hides the username on small devices so only the image appears. -->
                  <span class="hidden-xs">${role}</span>
                </a>
                <ul class="dropdown-menu">
                  <!-- The user image in the menu -->
                  <li class="user-header">
                    <img src="<%=request.getContextPath()%>/resources/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image" />
                    <p>
                     Admin - Administrador
                      <small></small>
                    </p>
                  </li>
                  <!-- Menu Body                  <li class="user-body">
                    <div class="col-xs-4 text-center">
                      <a href="#">Seguidores</a>
                    </div>
                    <div class="col-xs-4 text-center">
                      <a href="#">Ventas</a>
                    </div>
                    <div class="col-xs-4 text-center">
                      <a href="#">Amigos</a>
                    </div>
                  </li> -->
                  <!-- Menu Footer-->
                  <li class="user-footer">
                    <div class="pull-left">
                      <a href="#" class="btn btn-default btn-flat">Perfil</a>
                    </div>
                    <div class="pull-right">
                    	<c:url value="/j_spring_security_logout" var="logoutUrl" />
						<form action="${logoutUrl}" method="post" id="logoutForm">
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
							<button class="btn btn-default btn-flat" type="submit">Cerrar sesion</button>
						</form>
                    </div>
                  </li>
                </ul>
              </li>
            </ul>
          </div>
        </nav>
      </header>
      <!-- Left side column. contains the logo and sidebar -->
      <aside class="main-sidebar">

        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">

          <!-- Sidebar user panel (optional) -->
          <div class="user-panel">
            <div class="pull-left image">
              <img src="<%=request.getContextPath()%>/resources/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image" />
            </div>
            <div class="pull-left info">
              <p>${role}</p>
              <!-- Status -->
              <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
          </div>

          <!-- search form (Optional) -->
          <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
              <input type="text" name="q" class="form-control" placeholder="Buscar..."/>
              <span class="input-group-btn">
                <button type='submit' name='search' id='search-btn' class="btn btn-flat"><i class="fa fa-search"></i></button>
              </span>
            </div>
          </form>
          <!-- /.search form -->

          <!-- Sidebar Menu -->
          <ul class="sidebar-menu">
            <li class="header">Menu</li>
            <!-- Optionally, you can add icons to the links -->
            <li><a href="#"><i class="fa fa-newspaper-o"></i><span>Actividades</span></a></li>
            <li class="treeview">
            	<a href="#"><i class="fa fa-users"></i><span>Usuarios</span><i class="fa fa-angle-left pull-right"></i></a>
            	<ul class="treeview-menu">
                <li><a href="javascript: " onclick="$('#contenidoAUsuarios').load('AltaUsuarios');"><i class="fa fa-circle-o"></i>Altas</a></li>
                <li><a href="javascript: " onclick="$('#contenidoAUsuarios').load('CambiosBajasUsuarios')"><i class="fa fa-circle-o"></i>Cambios & Bajas</a></li>
              </ul>
            </li>
            <li class="treeview">
              <a href="#"><i class="fa fa-bars"></i><span>Areas</span> <i class="fa fa-angle-left pull-right"></i></a>
              <ul class="treeview-menu">
                <li><a href="javascript: " onclick="$('#contenidoAUsuarios').load('CambiosBajasAreas')"><i class="fa fa-circle-o"></i>Cambios</a></li>
              </ul>
            </li>
            <li class="treeview">
              <a href="#"><i class="fa fa-bars"></i><span>Catálogo de Trámites</span> <i class="fa fa-angle-left pull-right"></i></a>
              <ul class="treeview-menu">
                <li><a href="javascript: " onclick="$('#contenidoAUsuarios').load('CambiosCatTramites')"><i class="fa fa-circle-o"></i>Cambios</a></li>
              </ul>
            </li>
            <li class="treeview">
              <a href="#"><i class="fa fa-bars"></i><span>Catálogo de Denuncias</span> <i class="fa fa-angle-left pull-right"></i></a>
              <ul class="treeview-menu">
                <li><a href="javascript: " onclick="$('#contenidoAUsuarios').load('CambiosBajasCatDenuncias')"><i class="fa fa-circle-o"></i>Cambios</a></li>
              </ul>
            </li>
             <li class="treeview">
              <a href="#"><i class="fa fa-bars"></i><span>Prueba Correo</span> <i class="fa fa-angle-left pull-right"></i></a>
              <ul class="treeview-menu">
                <li><a href="javascript: " onclick="$('#contenidoAUsuarios').load('showEmailExample')"><i class="fa fa-circle-o"></i>Enviar</a></li>
              </ul>
            </li>
             <li class="treeview">
              <a href="#"><i class="fa fa-bars"></i><span>Prueba new_denuncia&new_tramite</span> <i class="fa fa-angle-left pull-right"></i></a>
              <ul class="treeview-menu">
                <li><a href="javascript: " onclick="$('#contenidoAUsuarios').load('showCatalogoDenuncias?${role}')"><i class="fa fa-circle-o"></i>Mostrar_denuncia</a></li>
                  <li><a href="javascript: " onclick="$('#contenidoAUsuarios').load('showCatalogoTramites')"><i class="fa fa-circle-o"></i>Mostrar_tramite</a></li>
              </ul>
            </li>
            <li class="treeview">
              <a href="#"><i class="fa fa-bars"></i><span>Perfil Empresa</span> <i class="fa fa-angle-left pull-right"></i></a>
              <ul class="treeview-menu">
                <li><a href="javascript: " onclick="$('#contenidoAUsuarios').load('altaPerfilEmpresa')"><i class="fa fa-circle-o"></i>Alta Perfil Empresa</a></li>
                <li><a href="javascript: " onclick="$('#contenidoAUsuarios').load('cambioPerfilEmpresa')"><i class="fa fa-circle-o"></i>Cambios & Bajas Perfil Empresa</a></li>
              </ul>
            </li>
            <li class="treeview">
              <a href="#"><i class="fa fa-bars"></i><span>Perfil Establecimiento</span> <i class="fa fa-angle-left pull-right"></i></a>
              <ul class="treeview-menu">
                <li><a href="javascript: " onclick="$('#contenidoAUsuarios').load('altaPerfilEstablecimiento')"><i class="fa fa-circle-o"></i>Alta Perfil Establecimiento</a></li>
                <li><a href="javascript: " onclick="$('#contenidoAUsuarios').load('cambioPerfilEstablecimiento')"><i class="fa fa-circle-o"></i>Cambios & Bajas Perfil Establecimiento</a></li>
              </ul>
            </li>
             <li class="treeview">
              <a href="#"><i class="fa fa-bars"></i><span>Generador de numeros</span> <i class="fa fa-angle-left pull-right"></i></a>
              <ul class="treeview-menu">
                <li><a href="javascript: " onclick="$('#contenidoAUsuarios').load('generatorNums')"><i class="fa fa-circle-o"></i>Mostrar generador</a></li>
              </ul>
            </li>
             <li class="treeview">
              <a href="#"><i class="fa fa-bars"></i><span>Prueba de muro</span> <i class="fa fa-angle-left pull-right"></i></a>
              <ul class="treeview-menu">
                <li><a href="javascript: " onclick="$('#contenidoAUsuarios').load('showMuro')"><i class="fa fa-circle-o"></i>Mostrar</a></li>
              </ul>
            </li>
             <li class="treeview">
              <a href="#"><i class="fa fa-bars"></i><span>Bitacora</span> <i class="fa fa-angle-left pull-right"></i></a>
              <ul class="treeview-menu">
                <li><a href="javascript: " onclick="$('#contenidoAUsuarios').load('consultaBitacoras')"><i class="fa fa-circle-o"></i>Consulta Bitacora</a></li>
                <li><a href="javascript: " onclick="$('#contenidoAUsuarios').load('busquedaBitacora')"><i class="fa fa-circle-o"></i>Consulta Bitacora por tramite</a></li>
              </ul>
            </li>
            <li class="treeview">
              <a href="#"><i class="fa fa-bars"></i><span>Busqueda Tramite</span> <i class="fa fa-angle-left pull-right"></i></a>
              <ul class="treeview-menu">
                <li><a href="javascript: " onclick="$('#contenidoAUsuarios').load('busquedaTramite')"><i class="fa fa-circle-o"></i>Buscar</a></li>
              </ul>
            </li>
            
            
          </ul><!-- /.sidebar-menu -->
        </section>
        <!-- /.sidebar -->
      </aside>

      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
            Panel de control
            <small>Dashboard</small>
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
            <li class="active">Here</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
        
          
          <!-- Your Page Content Here -->
          <!-- Main row -->
          <div class="row">
            <!-- Left col -->
            <section class="col-lg-12 connectedSortable">
              
              <!-- div altas usuarios -->
              <div id="contenidoAUsuarios"></div>     
	          <div id="cajaLista" style="display: none;">
				<div id="elementoLista"></div>
			  </div>
	              
            </section><!-- /.Left col -->
            <!-- right col (We are only adding the ID to make the widgets sortable)-->
          </div><!-- /.row (main row) -->

        </section><!-- /.content -->
      </div><!-- /.content-wrapper -->

      <!-- Main Footer -->
      <footer class="main-footer">
        <!-- To the right -->
        <div class="pull-right hidden-xs">
         
        </div>
        <!-- Default to the left --> 
        <strong>Secretaria de Desarrollo Sustentable  <a href="www.nuevoleon.gob.mx">  Gobierno del Estado de Nuevo Leon</a>.</strong>
      </footer>

    </div><!-- ./wrapper -->

   
  </body>
</html>
