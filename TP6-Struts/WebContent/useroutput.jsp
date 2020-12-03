<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="beans.*" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"
%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		UserinputForm utilisateur= (UserinputForm)
		session.getAttribute("user");
		%>
		Nom : <%=utilisateur.getNom() %><br/>
		Prenom :<%=utilisateur.getPrenom() %><br/>
		Email : <%=utilisateur.getEmail() %>
</body>
</html>