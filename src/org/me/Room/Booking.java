package org.me.Room;

import java.sql.Date;


public class Booking {
private String bookId;
private String roomId;
private String custName;
private String city;
private Date bookDate;
private Date chkDate;




public Date getChkDate() {
	return chkDate;
}
public void setChkDate(Date chkDate) {
	this.chkDate = chkDate;
}
public Date getBookDate() {
	return bookDate;
}
public void setBookDate(Date bookDate) {
	this.bookDate = bookDate;
}
public String getBookId() {
	return bookId;
}
public void setBookId(String bookId) {
	this.bookId = bookId;
}
public String getRoomId() {
	return roomId;
}
public void setRoomId(String roomId) {
	this.roomId = roomId;
}
public String getCustName() {
	return custName;
}
public void setCustName(String custName) {
	this.custName = custName;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}

}
