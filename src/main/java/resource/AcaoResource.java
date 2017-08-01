package resource;

import java.sql.*;
import java.util.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import dao.*;
import modelo.Acao;

@Path("acoes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AcaoResource {

	@GET
	public Response getAll() throws SQLException {
		try (Connection con = new ConnectionPool().getConnection()) {
			List<Acao> lista = new ArrayList<>();
			AcaoDao dao = new AcaoDao(con);
			lista = dao.listAll();
			return Response.ok().entity(lista).build();
		}
	}

	@Path("{id}")
	@GET
	public Acao getById(@PathParam("id") String id) throws SQLException {
		try (Connection con = new ConnectionPool().getConnection()) {
			return new AcaoDao(con).search(id);
		}
	}

	@Path("{id}")
	@PUT
	public Response atualiza(@PathParam("id") String id, final Acao acao) throws SQLException {
		try (Connection con = new ConnectionPool().getConnection()) {
			AcaoDao dao = new AcaoDao(con);
			int update = dao.update(id, acao);
			return update > 0 ? Response.ok().build() : Response.notModified().build();
		}
	}

	@POST
	public Response adiciona(final Acao acao) throws SQLException {
		try (Connection con = new ConnectionPool().getConnection()) {
			new AcaoDao(con).persist(acao);
			return Response.ok().build();

		}
	}

	@Path("{id}")
	@DELETE
	public Response delete(@PathParam("id") String id) throws SQLException {
		try (Connection con = new ConnectionPool().getConnection()) {
			int remove = new AcaoDao(con).remove(id);
			return remove == 1 ? Response.ok().build() : Response.status(Response.Status.NOT_FOUND).build();
		}
	}

}
