package com.rs;
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
@Path("/create") 
public class createbook {
	@POST
	@Path("/create") 
	@Produces(MediaType.TEXT_PLAIN)  
	public String create(@FormParam("_id") String _id, @FormParam("name") String name, @FormParam("version") String version,@FormParam("price") String price,@FormParam("charge") String charge,@FormParam("days") String days,@FormParam("total") String total) {   
		
		DB db = new connect().mongo();
		DBCollection collection = db.getCollection("book");
		
		System.out.println(_id);
		System.out.println(name);
		System.out.println(version);
		System.out.println(price);
		System.out.println(charge);
		System.out.println(days);
		System.out.println(total);
		

		BasicDBObject document = new BasicDBObject();
		document.put("_id", _id);
		document.put("name", name);
		document.put("version", version);
		document.put("price", price);
		document.put("charge",charge);
		document.put("day", days);
		document.put("total", total);

		collection.insert(document);
		
		return "true";  
	}
}
