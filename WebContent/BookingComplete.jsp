<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.me.Room.RoomCrud"%>
<%@page import="org.me.Room.Booking"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="bean1" class="org.me.Room.BookRoom"/>
<jsp:setProperty property="*" name="bean1"/>
<%

Booking objRoom=new Booking();
out.println(bean1.getBookDate() + "<br/>");
java.sql.Date sqlDate = java.sql.Date.valueOf(bean1.getBookDate());
out.println(sqlDate);
 objRoom.setBookDate(sqlDate);
objRoom.setCustName(bean1.getCustName());
objRoom.setCity(bean1.getCity());
objRoom.setRoomId(bean1.getRoomId());

RoomCrud obj=new RoomCrud();

out.println(obj.generateBookId());

out.println(obj.bookRoom(objRoom)); 

 
%>

</body>
</html>