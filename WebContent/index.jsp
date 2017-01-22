<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" >
<html>
	<head>

	<title>HomePage</title>
	</head>
	<body style="text-align:center;">
		
		<h2>xxxxxx WebSite</h2>
		<br/><br/>
		
		<div style="text-align:right;">
		<c:if test="${user!=null }">
			Welcome: ${user.username } 
			<a href="${pageContext.request.contextPath }/LogoutServlet" >Logout</a>
			
		</c:if>
		<c:if test="${user==null }" >
		<a href="${pageContext.request.contextPath}/RegisterUIServlet" >Register</a>
		<a  href="${pageContext.request.contextPath}/LoginUIServlet" >Login</a>
		</c:if>
		</div>
		<br/>
		<hr>
	</body>
</html>