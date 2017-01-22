<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" >
<html>
	<head>
	<title>Register Page</title>
	</head>
	
	
	
	<body>
		<a  >Register</a>
		<br/>
		
		<form action="${pageContext.request.contextPath }/RegisterServlet" method='post'>
			<table id="formtable">
			<tr>
				<td class="td1"> id:</td>
				<td > 
					<input class="userinput" type="text" name="username" value="${form.username }">
					<span class="message">${form.errors.username } </span>
				</td>
			</tr>
			
			<tr>
				<td class="td1"> password:</td>
				<td > 
					<input class="userinput" type="text" name="password"value="${form.password }">
					<span class="message">${form.errors.password }</span>
				</td>
			</tr>
			
			<tr>
				<td class="td1"> repeat password:</td>
				<td > 
					<input class="userinput" type="text" name="password2"value='${form.password2 }'>
					<span class="message">${form.errors.password2 }</span>
				</td>
			</tr>
			
			
			<tr>
				<td class="td1">email:</td>
				<td > 
					<input class="userinput" type="text" name="email"value="${form.email }">
					<span class="message">${form.errors.email }</span>
				</td>
			</tr>
			
			<tr>
				<td class="td1"> birthday:</td>
				<td > 
					<input class="userinput" type="text" name="birthday"value="${form.birthday }">
					<span class="message">${form.errors.birthday }</span>
				</td>
			</tr>
			
			
			
			</table>
		
			<input class="btn" type="reset" name ="reset" value="Reset">
			<input  type="submit" name ="submit" value="Submit">
				
			
		
		</form>
		
	</body>
	
</html>