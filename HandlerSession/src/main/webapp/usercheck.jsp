<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="mipk.beanDB"%>
<%@page import="java.sql.SQLException"%>

<%

boolean sessionCorrecta = false;
String resultado = "";

try {  //AQUI VA EL CONTROL DE SESION
	String acceso = session.getAttribute("attributo1").toString();
	// COMPRUEBA EL NIVEL DE USUARIO
 	if (acceso.equals("1")){
 		resultado = "<div style='color: white; font-weight: bold;'>Inicio de sesión correcto, es de nivel 1, Usuario</div>";
 	}
	else if (acceso.equals("2")){
		resultado = "<div style='color: white; font-weight: bold;'>Inicio de sesión correcto, es de nivel 2, Administrador</div>";
 	}
 	
} catch (Exception e) {
	resultado = "<div style='color: darkred; font-weight: bold;'>No ha iniciado ninguna sesión</div>";
}




%>
<html>
<head>

<link rel="stylesheet" href="common/general.css">

</head>
<body>
<h1>Session Checker</h1>
<hr/>
<hr/>
<%=resultado %>
<div id="contenedor1">
</div>

</body></html>