package resource;

import java.sql.*;
import java.util.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import dao.*;
import modelo.Grupo;

@Path("grupos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GrupoResource {

	@GET
	public Response getAll() throws SQLException {
		try (Connection con = new ConnectionPool().getConnection()) {
			List<Grupo> lista = new ArrayList<>();
			GrupoDao dao = new GrupoDao(con);
			lista = dao.listAll();
			return Response.ok().entity(lista).build();
		}
	}

	@Path("{id}")
	@GET
	public Grupo getById(@PathParam("id") String id) throws SQLException {
		try (Connection con = new ConnectionPool().getConnection()) {
			return new GrupoDao(con).search(id);
		}
	}

	@Path("{id}")
	@PUT
	public Response atualiza(@PathParam("id") String id, final Grupo grupo) throws SQLException {
		try (Connection con = new ConnectionPool().getConnection()) {
			GrupoDao dao = new GrupoDao(con);
			int update = dao.update(id, grupo);
			return update > 0 ? Response.ok().build() : Response.notModified().build();
		}
	}

	@POST
	public Response adiciona(final Grupo grupo) throws SQLException {
		try (Connection con = new ConnectionPool().getConnection()) {
			new GrupoDao(con).persist(grupo);
			return Response.ok().build();

		}
	}

	@Path("{id}")
	@DELETE
	public Response delete(@PathParam("id") String id) throws SQLException {
		try (Connection con = new ConnectionPool().getConnection()) {
			int remove = new GrupoDao(con).remove(id);
			if (remove == 1)
				return Response.ok().build();
			else
				return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

}
