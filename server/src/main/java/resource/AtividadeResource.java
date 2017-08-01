package resource;

import java.sql.*;
import java.util.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import dao.*;
import modelo.Atividade;

@Path("atividades")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AtividadeResource {

	@GET
	public Response getAll() throws SQLException {
		try (Connection con = new ConnectionPool().getConnection()) {
			List<Atividade> lista = new ArrayList<>();
			AtividadeDao dao = new AtividadeDao(con);
			lista = dao.listAll();
			return Response.ok().entity(lista).build();
		}
	}

	@Path("{id}")
	@GET
	public Atividade getById(@PathParam("id") String id) throws SQLException {
		try (Connection con = new ConnectionPool().getConnection()) {
			return new AtividadeDao(con).search(id);
		}
	}

	@Path("{id}")
	@PUT
	public Response atualiza(@PathParam("id") String id, final Atividade atividade) throws SQLException {
		try (Connection con = new ConnectionPool().getConnection()) {
			AtividadeDao dao = new AtividadeDao(con);
			int update = dao.update(id, atividade);
			return update > 0 ? Response.ok().build() : Response.notModified().build();
		}
	}

	@POST
	public Response adiciona(final Atividade atividade) throws SQLException {
		try (Connection con = new ConnectionPool().getConnection()) {
			new AtividadeDao(con).persist(atividade);
			return Response.ok().build();

		}
	}

	@Path("{id}")
	@DELETE
	public Response delete(@PathParam("id") String id) throws SQLException {
		try (Connection con = new ConnectionPool().getConnection()) {
			int remove = new AtividadeDao(con).remove(id);
			if (remove == 1)
				return Response.ok().build();
			else
				return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

}
