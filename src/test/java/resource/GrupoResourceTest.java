package resource;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.net.URI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.GrupoDao;
import dao.ConnectionPool;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import modelo.Grupo;
import server.ServidorGrizzly;

public class GrupoResourceTest {
	
	private static final String ID_QUE_NAO_EXISTE = "id_que_n@o_existe";
	private static final String LOCALHOST = "http://localhost:8080";
	
	private static final String NOME_1 = "nome-1";
	private static final String DESCRICAO_1 = "descricao-1";
	private static final String NOME_2 = "nome-2";
	private static final String DESCRICAO_2 = "descricao-2";
	private static final String NOVA_DESCRICAO = "nova-descricao";

	private GrupoDao dao;
	private Grupo grupo;

	private static WebTarget target;
	private static Client client;

	@BeforeClass
	public static void startServidor() {
		new ServidorGrizzly().startServidor();

		client = ClientBuilder.newClient();
		target = client.target(LOCALHOST);
	}

	@Before
	public void init() {
		try (Connection con = new ConnectionPool().getConnection()) {
			grupo = new Grupo(NOME_1, DESCRICAO_1);
			dao = new GrupoDao(con);
			dao.persist(grupo);
		} catch (SQLException e) {
			fail(e.getMessage());
		}
	}

	@After
	public void finish() {
		try (Connection con = new ConnectionPool().getConnection()) {
			try (PreparedStatement stmt = con.prepareStatement("truncate table grupo")) {
				stmt.execute();
			}
		} catch (SQLException e) {
			fail(e.getMessage());
		}
	}

	@AfterClass
	public static void stopServidor() {
		new ServidorGrizzly().stopServidor();
	}

	@Test
	public void trazTodos() {
		String result = target.path("grupos").request().get(String.class);
		assertTrue(result.contains(NOME_1));
	}

	@Test
	public void trazUm() {
		JsonPath jsonPath = given()
			.accept(ContentType.JSON)
			.get("/grupos/" + NOME_1)
			.andReturn().jsonPath();

		Grupo novaGrupo = jsonPath.getObject("", Grupo.class);
		assertEquals(novaGrupo.getNome(), NOME_1);
	}

	@Test
	public void trazOutro() {
		get("/grupos/" + NOME_1).then().body("nome", equalTo(NOME_1));
	}
	
	@Test
	public void trazNenhum() {
		get("/grupos/" + ID_QUE_NAO_EXISTE).equals(null);
	}

	@Test
	public void adicionaUm() {
		given()
		.contentType(ContentType.JSON)
		.body(new Grupo(NOME_2, DESCRICAO_2))
		.expect().statusCode(Response.Status.OK.getStatusCode())
		.when()
		.post("/grupos");
	}

	@Test
	public void atualizaUm() throws SQLException {
		URI uri = URI.create(LOCALHOST + "/grupos/" + NOME_1);
		Grupo novaGrupo = new Grupo(NOME_1, NOVA_DESCRICAO);
		given()
		.contentType(ContentType.JSON)
		.body(novaGrupo)
		.expect().statusCode(Response.Status.OK.getStatusCode())
		.when()
		.put(uri);
	}

	@Test
	public void atualizaNaoExistente() throws SQLException {
		URI uri = URI.create(LOCALHOST + "/grupos/" + ID_QUE_NAO_EXISTE);
		Grupo novaGrupo = new Grupo(NOME_1, NOVA_DESCRICAO);
		given()
		.contentType(ContentType.JSON)
		.body(novaGrupo)
		.expect().statusCode(Response.Status.NOT_MODIFIED.getStatusCode())
		.when()
		.put(uri);
	}
	
	@Test
	public void removeUm() {
		URI uri = URI.create(LOCALHOST + "/grupos/" + NOME_1);
		given()
		.contentType(ContentType.JSON)
		.expect().statusCode(Response.Status.OK.getStatusCode())
		.when()
		.delete(uri);
	}
	
	@Test
	public void removeUmQueNaExiste() {
		URI uri = URI.create(LOCALHOST + "/grupos/" + ID_QUE_NAO_EXISTE);
		given()
		.contentType(ContentType.JSON)
		.expect().statusCode(Response.Status.NOT_FOUND.getStatusCode())
		.when()
		.delete(uri);
	}
	
}
