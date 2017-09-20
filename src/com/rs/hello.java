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
		xml += "<return>";
		for(DBObject object : myList)
		{
			xml += "<book>";
				xml += "<id>"+object.get("_id").toString()+"</id>";
				xml += "<name>"+object.get("name").toString()+"</name>";
				xml += "<type>"+object.get("type").toString()+"</type>";
				xml += "<price>"+object.get("price").toString()+"</price>";
				xml += "<days>"+object.get("days").toString()+"</days>";
				xml += "<charge>"+object.get("charge").toString()+"</charge>";
				xml += "<total>"+object.get("total").toString()+"</total>";
			xml += "</book>";
		}
		xml += "</return>";
		
		System.out.println(xml);
		
		return xml;
		
	}
	@GET
	@Path("/findname") 
	@Produces(MediaType.TEXT_XML)  
	public String sayFindAllBook(){
		DB db = new connect().mongo();
		DBCollection collection = db.getCollection("book");

		DBCursor cursor = collection.find();
		
		List<DBObject> myList = cursor.toArray(); 
		
		String xml = "<?xml version=\"1.0\"?>";
		xml += "<return>";
		for(DBObject object : myList)
		{
			xml += "<book>";
				xml += "<id>"+object.get("_id").toString()+"</id>";
				xml += "<name>"+object.get("name").toString()+"</name>";
				xml += "<type>"+object.get("type").toString()+"</type>";
				xml += "<price>"+object.get("price").toString()+"</price>";
				xml += "<days>"+object.get("days").toString()+"</days>";
				xml += "<charge>"+object.get("charge").toString()+"</charge>";
				xml += "<total>"+object.get("total").toString()+"</total>";
			xml += "</book>";
		}
		xml += "</return>";
		
		System.out.println(xml);
		
		return xml;
		
	}
}
