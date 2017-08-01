package resource;

import java.sql.*;
import java.util.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import dao.*;
import modelo.Funcao;

@Path("funcoes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FuncaoResource {

	@GET
	public Response getAll() throws SQLException {
		try (Connection con = new ConnectionPool().getConnection()) {
			List<Funcao> lista = new ArrayList<>();
			FuncaoDao dao = new FuncaoDao(con);
			lista = dao.listAll();
			return Response.ok().entity(lista).build();
		}
	}

	@Path("{id}")
	@GET
	public Funcao getById(@PathParam("id") String id) throws SQLException {
		try (Connection con = new ConnectionPool().getConnection()) {
			return new FuncaoDao(con).search(id);
		}
	}

	@Path("{id}")
	@PUT
	public Response atualiza(@PathParam("id") String id, final Funcao acao) throws SQLException {
		try (Connection con = new ConnectionPool().getConnection()) {
			FuncaoDao dao = new FuncaoDao(con);
			int update = dao.update(id, acao);
			return update > 0 ? Response.ok().build() : Response.notModified().build();
		}
	}

	@POST
	public Response adiciona(final Funcao acao) throws SQLException {
		try (Connection con = new ConnectionPool().getConnection()) {
			new FuncaoDao(con).persist(acao);
			return Response.ok().build();

		}
	}

	@Path("{id}")
	@DELETE
	public Response delete(@PathParam("id") String id) throws SQLException {
		try (Connection con = new ConnectionPool().getConnection()) {
			int remove = new FuncaoDao(con).remove(id);
			if (remove == 1)
				return Response.ok().build();
			else
				return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

}
