package resource;

import java.sql.*;
import java.util.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import dao.*;
import modelo.Area;

@Path("areas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AreaResource {

	@GET
	public Response getAll() throws SQLException {
		try (Connection con = new ConnectionPool().getConnection()) {
			List<Area> lista = new ArrayList<>();
			AreaDao dao = new AreaDao(con);
			lista = dao.listAll();
			return Response.ok().entity(lista).build();
		}
	}

	@Path("{id}")
	@GET
	public Area getById(@PathParam("id") String id) throws SQLException {
		try (Connection con = new ConnectionPool().getConnection()) {
			return new AreaDao(con).search(id);
		}
	}

	@Path("{id}")
	@PUT
	public Response atualiza(@PathParam("id") String id, final Area area) throws SQLException {
		try (Connection con = new ConnectionPool().getConnection()) {
			AreaDao dao = new AreaDao(con);
			int update = dao.update(id, area);
			return update > 0 ? Response.ok().build() : Response.notModified().build();
		}
	}

	@POST
	public Response adiciona(final Area area) throws SQLException {
		try (Connection con = new ConnectionPool().getConnection()) {
			new AreaDao(con).persist(area);
			return Response.ok().build();

		}
	}

	@Path("{id}")
	@DELETE
	public Response delete(@PathParam("id") String id) throws SQLException {
		try (Connection con = new ConnectionPool().getConnection()) {
			int remove = new AreaDao(con).remove(id);
			return remove == 1 ? Response.ok().build() : Response.status(Response.Status.NOT_FOUND).build();
		}
	}

}
