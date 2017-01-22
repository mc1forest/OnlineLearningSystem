<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Webpage</title>
</head>


<body>
	<form action="${pageContext.request.contextPath }/LoginServlet" method="post" >
		<table id="formtable">
			<tr>
				<td class="td1"> id:</td>
				<td > 
				
					<input class="userinput" type="text" name="username">
					<span class="message">${form.errors.username } </span>
				</td>
			</tr>
			
			<tr>
				<td class="td1"> password:</td>
				<td > 
					<input class="userinput" type="password" name="password">
					<span class="message">${form.errors.password }</span>
				</td>
			</tr>
		</table>
		
			<div id="btn">
				<input class="btn" type="button" name ="register" value="Register" onclick="location.href='${pageContext.request.contextPath}/RegisterUIServlet'">
				<input class="btn" type="reset" name ="Reset" value="Reset">
				<input class="btn" type="submit" name ="login" value="Login">
			</div>
		</form>
		
</body>
</html>