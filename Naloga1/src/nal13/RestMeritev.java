package nal13;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import nal8.ejb.MeritevEjbVmesnik;
import nal8.vao.ClanVao;
import nal8.vao.MeritevVao;

@Path("/meritve")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RestMeritev {
	@Context
    private UriInfo context;
	
	@EJB
	MeritevEjbVmesnik ejb;
//	
//	@GET
//	public Response vsiClani() {
//		return Response.ok(ejb.vsiClani()).build();
//	}

	@GET
	@Path("/meritev/{id}")
	public Response vrniMeriteve(@PathParam("id") int id) {
		
			return Response.ok(ejb.getSeznamMeritev(id)).build();
		
//			return Response.status(403).entity("clana ni mogoce najti!").build();

	}

	@POST
	@Path("/meritev")
	public Response dodajMeritev(MeritevRest c) {
	
		MeritevVao m = new MeritevVao();
	
	
		m.setTeza(c.getTeza());
		m.setTelesnaVisina(c.getTelesnaVisina());
		m.setObsegPasu(c.getObsegPasu());
		
		ejb.vpisiMeritev(m, c.getId());
		return Response.ok().build();

	}

//	@PUT
//	@Path("/clan/{id}")
//	public Response spremeniClana(@PathParam("id") int id, ClanRest c) {
//		ClanVao cv = ejb.izberiClana(id);
//		if (cv != null) {
//			//c.setId(cv.getId());
//			cv.setIme(c.getIme());
//			cv.setPriimek(c.getPriimek());
//			ejb.spremeniClana(cv);
//			return Response.ok().build();
//		}
//		return Response.status(403).entity("ne najdem osebe").build();
//	}
//
//	@DELETE
//	@Path("/clan/{id}")
//	public Response izbrisiClana(@PathParam("id") int id) {
//		if(ejb.izbrisiClana(id))
//			return Response.ok().build();
//		return Response.status(403).entity("brisanje ni uspelo").build();
//		
//		
//		
//		
//	}
	
	
	
}
