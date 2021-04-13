package fr.umfds.TPtestServicesREST;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/Brainstorm")
@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})


public class BrainstormResource {
	
	//@Inject
	BrainstormDB database;
	
	public BrainstormResource() {
		this.database = new BrainstormDB();
	}

	@GET
	public List<Brainstorm> getBrainstorm() {
		return database.getDB();
	}

	@GET @Path("brainstorm-{id}")
	public Response getBrainstormID(@PathParam("id")int id) throws NotFoundException{
		

		List<Brainstorm> temp = database.getDB();
		for(Brainstorm i : temp) {
			if(i.getId() == id) {
				return Response.ok(i).build();
			}
		}
		 throw new NotFoundException();
	}
	
	@PUT @Path("brainstorm/{id}/{name}")
	public Response addBrainstorm(@PathParam("id")int id, @PathParam("name")String name) {
		Brainstorm res = new Brainstorm(name,id);
		BrainstormDB.BrainstormList.add(res);
		return Response.ok(res).build();
	}
	

}
