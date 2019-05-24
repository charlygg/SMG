<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<table id="tablaLista">
<c:choose>
<c:when test="${tipoLista == '1'}">
<tr id="encabezadoLista">
<td>Folio:</td>
<td>Descripción:</td>
<td>Estatus:</td>
</tr>
<c:forEach items="${listaResultado}" var="resultado" >
<tr onclick="cargaValorLista('${controlID}', '${resultado.iddenuncia}'
, '${onSelectFn}(\'${resultado.iddenuncia}\')'
);">
<td>${resultado.iddenuncia}</td>
<td>${resultado.descripcion}</td>
<%-- <td>${resultado.estatus}</td> --%>
<c:choose>
<c:when test="${resultado.estatus==1}"><td>Nuevo</td></c:when>
<c:when test="${resultado.estatus==2}"><td>Recibido</td></c:when>
<c:when test="${resultado.estatus==3}"><td>En Proceso</td></c:when>
<c:when test="${resultado.estatus==4}"><td>Documentación</td></c:when>
<c:when test="${resultado.estatus==5}"><td>Terminado</td></c:when>
</c:choose>
</tr>
</c:forEach>
</c:when>
</c:choose></table>
