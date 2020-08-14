<%@page import="org.me.Room.RoomCrud"%>
<%@page import="org.me.Room.Room"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="3">
	<tr>
		<th>Room Id</th>
		<th>Type</th>
		<th>Status</th>
		<th>Cost Per Day</th>
	</tr>
<%
	List<Room> list = new RoomCrud().showRoom();
	for(Room room : list) {
%>
	<tr>
		<td><%=room.getRoomId() %> </td>
		<td><%=room.getType() %> </td>
		<%
			if (room.getStatus().equals("Available")) {
		%>
		<td bgcolor="green"><%=room.getStatus() %>  </td>
		<%
			} else {
		%>
		<td><%=room.getStatus() %>  </td>
		<%
			}
		%>
		
		<td><%=room.getCostPerDay() %>  </td>
	</tr>
<%
	}
%>
</table>
</body>
</html>