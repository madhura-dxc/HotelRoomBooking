<%@page import="org.me.Room.RoomCrud"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		RoomCrud obj=new RoomCrud();
	%>
	No.of Days Stay : 
	<%=obj.noOfDays("B001") %>
	<br/><br/>
	Total Bill Amount : 
	<%=obj.billAmount("B001") %> <Br/>
	Status Change : 
	<%=obj.roomStatusChange("B001") %>
</body>
</html>