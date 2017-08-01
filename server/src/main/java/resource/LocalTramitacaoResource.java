package resource;

import java.sql.*;
import java.util.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import dao.*;
import modelo.LocalTramitacao;

@Path("locaistramitacao")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LocalTramitacaoResource {

	@GET
	public Response getAll() throws SQLException {
		try (Connection con = new ConnectionPool().getConnection()) {
			List<LocalTramitacao> lista = new ArrayList<>();
			LocalTramitacaoDao dao = new LocalTramitacaoDao(con);
			lista = dao.listAll();
			return Response.ok().entity(lista).build();
		}
	}

	@Path("{id}")
	@GET
	public LocalTramitacao getById(@PathParam("id") String id) throws SQLException {
		try (Connection con = new ConnectionPool().getConnection()) {
			return new LocalTramitacaoDao(con).search(id);
		}
	}

	@Path("{id}")
	@PUT
	public Response atualiza(@PathParam("id") String id, final LocalTramitacao localTramitacao) throws SQLException {
		try (Connection con = new ConnectionPool().getConnection()) {
			LocalTramitacaoDao dao = new LocalTramitacaoDao(con);
			int update = dao.update(id, localTramitacao);
			return update > 0 ? Response.ok().build() : Response.notModified().build();
		}
	}

	@POST
	public Response adiciona(final LocalTramitacao localTramitacao) throws SQLException {
		try (Connection con = new ConnectionPool().getConnection()) {
			new LocalTramitacaoDao(con).persist(localTramitacao);
			return Response.ok().build();

		}
	}

	@Path("{id}")
	@DELETE
	public Response delete(@PathParam("id") String id) throws SQLException {
		try (Connection con = new ConnectionPool().getConnection()) {
			int remove = new LocalTramitacaoDao(con).remove(id);
			if (remove == 1)
				return Response.ok().build();
			else
				return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

}
