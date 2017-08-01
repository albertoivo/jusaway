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

import dao.SubAreaDao;
import dao.ConnectionPool;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import modelo.SubArea;
import server.ServidorGrizzly;

public class SubAreaResourceTest {
	
	private static final String ID_QUE_NAO_EXISTE = "id_que_n@o_existe";
	private static final String LOCALHOST = "http://localhost:8080";
	
	private static final String NOME_1 = "nome-1";
	private static final String DESCRICAO_1 = "descricao-1";
	private static final String NOME_2 = "nome-2";
	private static final String DESCRICAO_2 = "descricao-2";
	private static final String NOVA_DESCRICAO = "nova-descricao";

	private SubAreaDao dao;
	private SubArea funcao;

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
			funcao = new SubArea(NOME_1, DESCRICAO_1);
			dao = new SubAreaDao(con);
			dao.persist(funcao);
		} catch (SQLException e) {
			fail(e.getMessage());
		}
	}

	@After
	public void finish() {
		try (Connection con = new ConnectionPool().getConnection()) {
			try (PreparedStatement stmt = con.prepareStatement("truncate table subarea")) {
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
		String result = target.path("subareas").request().get(String.class);
		assertTrue(result.contains(NOME_1));
	}

	@Test
	public void trazUm() {
		JsonPath jsonPath = given()
			.accept(ContentType.JSON)
			.get("/subareas/" + NOME_1)
			.andReturn().jsonPath();

		SubArea novaSubArea = jsonPath.getObject("", SubArea.class);
		assertEquals(novaSubArea.getNome(), NOME_1);
	}

	@Test
	public void trazOutro() {
		get("/subareas/" + NOME_1).then().body("nome", equalTo(NOME_1));
	}
	
	@Test
	public void trazNenhum() {
		get("/subareas/" + ID_QUE_NAO_EXISTE).equals(null);
	}

	@Test
	public void adicionaUm() {
		given()
		.contentType(ContentType.JSON)
		.body(new SubArea(NOME_2, DESCRICAO_2))
		.expect().statusCode(Response.Status.OK.getStatusCode())
		.when()
		.post("/subareas");
	}

	@Test
	public void atualizaUm() throws SQLException {
		URI uri = URI.create(LOCALHOST + "/subareas/" + NOME_1);
		SubArea novaSubArea = new SubArea(NOME_1, NOVA_DESCRICAO);
		given()
		.contentType(ContentType.JSON)
		.body(novaSubArea)
		.expect().statusCode(Response.Status.OK.getStatusCode())
		.when()
		.put(uri);
	}

	@Test
	public void atualizaNaoExistente() throws SQLException {
		URI uri = URI.create(LOCALHOST + "/subareas/" + ID_QUE_NAO_EXISTE);
		SubArea novaSubArea = new SubArea(NOME_1, NOVA_DESCRICAO);
		given()
		.contentType(ContentType.JSON)
		.body(novaSubArea)
		.expect().statusCode(Response.Status.NOT_MODIFIED.getStatusCode())
		.when()
		.put(uri);
	}
	
	@Test
	public void removeUm() {
		URI uri = URI.create(LOCALHOST + "/subareas/" + NOME_1);
		given()
		.contentType(ContentType.JSON)
		.expect().statusCode(Response.Status.OK.getStatusCode())
		.when()
		.delete(uri);
	}
	
	@Test
	public void removeUmQueNaExiste() {
		URI uri = URI.create(LOCALHOST + "/subareas/" + ID_QUE_NAO_EXISTE);
		given()
		.contentType(ContentType.JSON)
		.expect().statusCode(Response.Status.NOT_FOUND.getStatusCode())
		.when()
		.delete(uri);
	}
	
}
