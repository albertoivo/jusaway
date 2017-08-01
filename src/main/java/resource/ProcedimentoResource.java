package resource;

import java.sql.*;
import java.util.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import dao.*;
import modelo.Procedimento;

@Path("procedimentos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProcedimentoResource {

	@GET
	public Response getAll() throws SQLException {
		try (Connection con = new ConnectionPool().getConnection()) {
			List<Procedimento> lista = new ArrayList<>();
			ProcedimentoDao dao = new ProcedimentoDao(con);
			lista = dao.listAll();
			return Response.ok().entity(lista).build();
		}
	}

	@Path("{id}")
	@GET
	public Procedimento getById(@PathParam("id") String id) throws SQLException {
		try (Connection con = new ConnectionPool().getConnection()) {
			return new ProcedimentoDao(con).search(id);
		}
	}

	@Path("{id}")
	@PUT
	public Response atualiza(@PathParam("id") String id, final Procedimento procedimento) throws SQLException {
		try (Connection con = new ConnectionPool().getConnection()) {
			ProcedimentoDao dao = new ProcedimentoDao(con);
			int update = dao.update(id, procedimento);
			return update > 0 ? Response.ok().build() : Response.notModified().build();
		}
	}

	@POST
	public Response adiciona(final Procedimento procedimento) throws SQLException {
		try (Connection con = new ConnectionPool().getConnection()) {
			new ProcedimentoDao(con).persist(procedimento);
			return Response.ok().build();

		}
	}

	@Path("{id}")
	@DELETE
	public Response delete(@PathParam("id") String id) throws SQLException {
		try (Connection con = new ConnectionPool().getConnection()) {
			int remove = new ProcedimentoDao(con).remove(id);
			if (remove == 1)
				return Response.ok().build();
			else
				return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

}
