package resource;

import java.sql.*;
import java.util.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import dao.*;
import modelo.SubArea;

@Path("subareas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SubAreaResource {

	@GET
	public Response getAll() throws SQLException {
		try (Connection con = new ConnectionPool().getConnection()) {
			List<SubArea> lista = new ArrayList<>();
			SubAreaDao dao = new SubAreaDao(con);
			lista = dao.listAll();
			return Response.ok().entity(lista).build();
		}
	}

	@Path("{id}")
	@GET
	public SubArea getById(@PathParam("id") String id) throws SQLException {
		try (Connection con = new ConnectionPool().getConnection()) {
			return new SubAreaDao(con).search(id);
		}
	}

	@Path("{id}")
	@PUT
	public Response atualiza(@PathParam("id") String id, final SubArea sub) throws SQLException {
		try (Connection con = new ConnectionPool().getConnection()) {
			SubAreaDao dao = new SubAreaDao(con);
			int update = dao.update(id, sub);
			return update > 0 ? Response.ok().build() : Response.notModified().build();
		}
	}

	@POST
	public Response adiciona(final SubArea sub) throws SQLException {
		try (Connection con = new ConnectionPool().getConnection()) {
			new SubAreaDao(con).persist(sub);
			return Response.ok().build();

		}
	}

	@Path("{id}")
	@DELETE
	public Response delete(@PathParam("id") String id) throws SQLException {
		try (Connection con = new ConnectionPool().getConnection()) {
			int remove = new SubAreaDao(con).remove(id);
			if (remove == 1)
				return Response.ok().build();
			else
				return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

}
