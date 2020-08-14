package org.me.Room;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class RoomCrud {
	
	public String bookRoom(Booking objBooking){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("org/me/Room/application-context.xml");
		HibernateTemplate ht=(HibernateTemplate)ctx.getBean("hibernateTemplate");
		objBooking.setBookId(generateBookId());
		ht.save(objBooking);
		ht=(HibernateTemplate)ctx.getBean("hibernateTemplate");
		Room r=(Room)ht.get(Room.class,objBooking.getRoomId());
		r.setStatus("Booked...");
		ht.update(r);
		return "Room Booked...";
	}
	
	public List<Room> showRoom() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("org/me/Room/application-context.xml");
		HibernateTemplate ht=(HibernateTemplate)ctx.getBean("hibernateTemplate");
	    List<Room> lstRoom=ht.find("from Room");
	    return lstRoom;

	}
public String generateRoomId(){
	ApplicationContext ctx=new ClassPathXmlApplicationContext("org/me/Room/application-context.xml");
	HibernateTemplate ht=(HibernateTemplate)ctx.getBean("hibernateTemplate");
    List<Room> lstRoom=ht.find("from Room");
    
    String roomId="";
    if(lstRoom.size()==0){
    	roomId="R001";
    	return roomId;
    }
    else {
    	for(Room r : lstRoom){
    		roomId=r.getRoomId();
    	}
    	 int rid= Integer.parseInt(roomId.substring(1));
    	 rid++;
    	 if(rid>=1&&rid<=9){
    		 roomId="R00"+rid;
    	 }
    	 if(rid>9&&rid<99)
    	 {
    		 roomId="R0"+rid;
    	 }
    	 if(rid>99&&rid<999)
    	 {
    		 roomId="R"+rid;
    	 }
    	 System.out.println("Room ID is " +roomId);
    	 return roomId;
    }
    
   
	 
	

}
public String addRoom(Room obj){
	ApplicationContext ctx=new ClassPathXmlApplicationContext("org/me/Room/application-context.xml");
	HibernateTemplate ht=(HibernateTemplate)ctx.getBean("hibernateTemplate");
	obj.setRoomId(generateRoomId());
	ht.save(obj);
	
	return "Rooms added";
}

public List<String> available() {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("org/me/Room/application-context.xml");
	HibernateTemplate ht=(HibernateTemplate)ctx.getBean("hibernateTemplate");
    List<Room> lstBook=ht.find("from Room where status='Available'");
    List<String> lstAvail=new ArrayList<String>();
    for(Room b : lstBook){
    	lstAvail.add(b.getRoomId());
    }
    return lstAvail;
}

public String generateBookId(){
	ApplicationContext ctx=new ClassPathXmlApplicationContext("org/me/Room/application-context.xml");
	HibernateTemplate ht=(HibernateTemplate)ctx.getBean("hibernateTemplate");
    List<Booking> lstBook=ht.find("from Booking");
    
    String bookId="";
    if(lstBook.size()==0){
    	bookId="B001";
    	return bookId;
    }
    else {
    	for(Booking r : lstBook){
    		bookId=r.getBookId();
    	}
    	 int bid= Integer.parseInt(bookId.substring(1));
    	 bid++;
    	 if(bid>=1&&bid<=9){
    		 bookId="B00"+bid;
    	 }
    	 if(bid>9&&bid<99)
    	 {
    		 bookId="B0"+bid;
    	 }
    	 if(bid>99&&bid<999)
    	 {
    		 bookId="B"+bid;
    	 }
    	 System.out.println("booking ID is " +bookId);
    	 return bookId;
    }
    

	 
	

}

public String finalBook(Billing objBilling){
	ApplicationContext ctx=new ClassPathXmlApplicationContext("org/me/Room/application-context.xml");
	HibernateTemplate ht=(HibernateTemplate)ctx.getBean("hibernateTemplate");
	
	ht.save(objBilling);
	ht.update(objBilling);
	return "Bill Over...";
	
}

public String getRoomid(String bookId){
	ApplicationContext ctx=new ClassPathXmlApplicationContext("org/me/Room/application-context.xml");
	HibernateTemplate ht=(HibernateTemplate)ctx.getBean("hibernateTemplate");
	Booking b=(Booking)ht.get(Booking.class,bookId);
	String rid=b.getRoomId();
	return rid;
}

public String roomCheckDate(String bookId,Date chkDate){
	ApplicationContext ctx=new ClassPathXmlApplicationContext("org/me/Room/application-context.xml");
	HibernateTemplate ht=(HibernateTemplate)ctx.getBean("hibernateTemplate");
	Booking b=(Booking)ht.get(Booking.class,bookId); 
	b.setChkDate(chkDate); 
	ht.update(b); 
	return "Checkout Complete";
}

public String roomStatusChange(String bookId){
	ApplicationContext ctx=new ClassPathXmlApplicationContext("org/me/Room/application-context.xml");
	HibernateTemplate ht=(HibernateTemplate)ctx.getBean("hibernateTemplate");
	Booking b=(Booking)ht.get(Booking.class,bookId);
	String rid=b.getRoomId();
	Room r=(Room)ht.get(Room.class,rid);
	r.setStatus("Available");
	ht.update(r);
	return r.getStatus();
}

public int billAmount(String bookId){
	ApplicationContext ctx=new ClassPathXmlApplicationContext("org/me/Room/application-context.xml");
	HibernateTemplate ht=(HibernateTemplate)ctx.getBean("hibernateTemplate"); 
	Booking b=(Booking)ht.get(Booking.class,bookId);
	String rid=b.getRoomId();
	Room r=(Room)ht.get(Room.class,rid); 
	int price=r.getCostPerDay(); 
	int total=price* noOfDays(bookId); 
	return total;
}

public int noOfDays(String bookId){
	ApplicationContext ctx=new ClassPathXmlApplicationContext("org/me/Room/application-context.xml");
	HibernateTemplate ht=(HibernateTemplate)ctx.getBean("hibernateTemplate");
	List lst=ht.find("select DATEDIFF(ChkDate,BookDate) from Booking where bookId='"+bookId+"'");
	int days=0;
	for(Object ob : lst){
		days=(Integer)ob;
	}
	return days;
	
}

}
