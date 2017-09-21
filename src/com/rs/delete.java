package com.rs;
import java.util.List;
import javax.ws.rs.GET;
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

@Path("/delete")

public class delete {
	@GET
	@Path("/delete/{id}") 
	@Produces(MediaType.TEXT_PLAIN)  
	public String deletes(@PathParam("id") String id) {   
		System.out.println(id);
		DB db = new connect().mongo();
		DBCollection collection = db.getCollection("book");
		
		DBObject document = collection.findOne(new ObjectId(id));
		collection.remove(document);
		
		return "true";  
	}

}
