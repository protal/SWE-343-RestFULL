package com.rs;
import java.util.List;

import javax.jws.WebParam;
import javax.ws.rs.FormParam; import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam; import javax.ws.rs.Produces; import javax.ws.rs.core.MediaType;

import org.bson.types.ObjectId;

//import com.connect.connect;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
@Path("/hello") 
public class hello {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello(){
	return "Hello Jersey";	
	}
}
