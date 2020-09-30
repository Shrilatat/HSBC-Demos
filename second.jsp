<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>

	<h1>Welcome to Second JSP !!</h1>

	<form method="post" action="second.jsp">
		Radius : <input type="text" name="rad"><br> <br> <input
			type="submit">
	</form>

	<%
		double area = 0;
	
	if (request.getMethod().equals("POST")) {
		int rad = Integer.parseInt(request.getParameter("rad"));
		area = Math.PI * rad * rad;
	}
	%>
	area :
	<%=area%>
</body>
</html>