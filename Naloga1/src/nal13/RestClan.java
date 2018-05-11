package nal13;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import nal8.ejb.ClanEjbVmesnik;
import nal8.vao.ClanVao;
import nal13.ClanRest;


@Path("/clani")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RestClan {
	@Context
	private UriInfo context;
	@EJB
	ClanEjbVmesnik ejb;

	@GET
	public Response vsiClani() {
		return Response.ok(ejb.vsiClani()).build();
	}

	@GET
	@Path("/clan/{id}")
	public Response vrniClana(@PathParam("id") int id) {
		ClanVao c = ejb.izberiClana(id);
		if (c != null)
			return Response.ok(c).build();
		
			return Response.status(403).entity("clana ni mogoce najti!").build();

	}

	@POST
	@Path("/clan")
	public Response dodajClana(ClanRest c) {
		
		ejb.vpisiClana(new ClanVao(c.getIme(),c.getPriimek(),null,null,null,null,null,null));
		return Response.ok().build();

	}

	@PUT
	@Path("/clan/{id}")
	public Response spremeniClana(@PathParam("id") int id, ClanRest c) {
		ClanVao cv = ejb.izberiClana(id);
		if (cv != null) {
			//c.setId(cv.getId());
			cv.setIme(c.getIme());
			cv.setPriimek(c.getPriimek());
			ejb.spremeniClana(cv);
			return Response.ok().build();
		}
		return Response.status(403).entity("ne najdem osebe").build();
	}

	@DELETE
	@Path("/clan/{id}")
	public Response izbrisiClana(@PathParam("id") int id) {
		if(ejb.izbrisiClana(id))
			return Response.ok().build();
		return Response.status(403).entity("brisanje ni uspelo").build();
		
		
		
		
	}

}
