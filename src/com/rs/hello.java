package com.rs;
import java.util.List;

import javax.jws.WebParam;
import javax.ws.rs.FormParam; import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam; import javax.ws.rs.Produces; import javax.ws.rs.core.MediaType;

import org.bson.types.ObjectId;

import com.connect.connect;
//import com.connect.connect;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
@Path("/bookstore") 
public class hello {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello(){
	return "Hello Jersey";	
	}
	
	@GET
	@Path("/findname/{name}") @Produces(MediaType.TEXT_XML)
	public String sayFindNameBook(@PathParam("name")String name){
		DB db = new connect().mongo();
		DBCollection collection = db.getCollection("book");
		
		BasicDBObject q = new BasicDBObject();
		q.put("name",  java.util.regex.Pattern.compile(name));
		
		DBCursor cursor = collection.find(q);
		
		List<DBObject> myList = cursor.toArray(); 
		
		String xml = "<?xml version=\"1.0\"?>";
		xml += "<books>";
		for(DBObject object : myList)
		{
			xml += "<book>";
				xml += "<id_book>"+object.get("id_book").toString()+"</id_book>";
				xml += "<name>"+object.get("name").toString()+"</name>";
				xml += "<publisher>"+object.get("publisher").toString()+"</publisher>";
				xml += "<book_number>"+object.get("book_number").toString()+"</book_number>";
				xml += "<discovery>"+object.get("discovery").toString()+"</discovery>";
				xml += "<total_book>"+object.get("total_book").toString()+"</total_book>";
			xml += "</book>";
		}
		xml += "</books>";
		return xml;
		
	}
}
