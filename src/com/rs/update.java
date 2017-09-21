package com.rs;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import org.bson.types.ObjectId;

import com.connect.connect;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;

@Path("/update")
public class update {
	@POST
	@Path("/update") 
	@Produces(MediaType.TEXT_PLAIN)  
	public String updates( @FormParam("name") String name, @FormParam("version") String version, @FormParam("type") String type,@FormParam("price") String price,
			@FormParam("day") String day, @FormParam("charge") String charge,@FormParam("total") String total) {   
		
		DB db = new connect().mongo();
		DBCollection collection = db.getCollection("course");
		
		BasicDBObject document = new BasicDBObject();
		document.put("name", name);
		document.put("version", version);
		document.put("type", type);
		document.put("price", price);
		document.put("day", day);
		document.put("charge", charge);
		document.put("total", total);
		
		BasicDBObject setQuery = new BasicDBObject();
        setQuery.put("$set", document);
		
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("name", new ObjectId(name));

		collection.update(searchQuery, setQuery);
		
		return "true";  
	} 
}
