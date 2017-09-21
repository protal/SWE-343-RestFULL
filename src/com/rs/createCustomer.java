package com.rs;

import java.util.List;


import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.bson.types.ObjectId;

import com.connect.connect;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
@Path("/createcustomer")
public class createCustomer {
	@GET
	@Path("/create") 
	@Produces(MediaType.TEXT_PLAIN)
	public String createCustomers(
			@FormParam("firstname") String firstname,
			@FormParam("lastname") String lastname,
			@FormParam("phone") String phone, 
			@FormParam("email") String email, 
			@FormParam("password") String password,
			@FormParam("address") String address 
			){   
		
		DB db = new connect().mongo();
		DBCollection collection = db.getCollection("customer");
		
		System.out.println(firstname);
		System.out.println(lastname);
		System.out.println(phone);
		System.out.println(email);
		System.out.println(password);
		System.out.println(address);
		
		BasicDBObject document = new BasicDBObject();
		document.put("firstname", firstname);
		document.put("lastname", lastname);
		document.put("phone", phone);
		document.put("email", email);
		document.put("password", password);
		document.put("address", address);

		collection.insert(document);
		
		return "true";  
	}
}
