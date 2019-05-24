<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

<!DOCTYPE html>
<html>
<head>
<style>
body {
  padding-top: 40px;
  padding-bottom: 40px;
  background-color: #eee;
}

.form-signin {
  max-width: 330px;
  padding: 15px;
  margin: 0 auto;
}
.form-signin .form-signin-heading,
.form-signin .checkbox {
  margin-bottom: 10px;
}
.form-signin .checkbox {
  font-weight: normal;
}
.form-signin .form-control {
  position: relative;
  height: auto;
  -webkit-box-sizing: border-box;
     -moz-box-sizing: border-box;
          box-sizing: border-box;
  padding: 10px;
  font-size: 16px;
}
.form-signin .form-control:focus {
  z-index: 2;
}
.form-signin input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}
.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
</style>

    <title>Gobierno</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
  </head>

  <body>

    <div class="container">
		<div class="">
				<c:if test="${not empty error}">
					<div class="alert alert-danger alert-dismissible" role="alert">
					 <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
					<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					${error}
					</div>
				</c:if>
				<c:if test="${not empty msg}">
					<div class="alert alert-warning alert-dismissible" role="alert">
					<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					${msg}</div>
				</c:if>
		</div>
      <form class="form-signin" name='loginForm' action="<c:url value='/j_spring_security_check' />" method='POST'>
      <img src="<%=request.getContextPath()%>/resources/imagenes/SGN.png" class="img-responsive" alt="Responsive image">
        <label for="inputEmail" class="sr-only">Usuario</label>
        <input type="text" id="username" name="username" class="form-control" placeholder="Usuario" required autofocus>
        <label for="inputPassword" class="sr-only">Contraseña</label>
        <input type="password" id="password" name="password" class="form-control" placeholder="Contraseña" required>
        <br>
        <button class="btn btn-lg btn-success btn-block" type="submit">Entrar</button>
        <input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
        
      </form>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="<%=request.getContextPath()%>/resources/plugins/jQuery/jQuery-2.1.3.min.js"></script>
  	<script src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
  	</body>
</html>