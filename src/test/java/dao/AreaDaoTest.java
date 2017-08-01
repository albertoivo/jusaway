package dao;

import static org.junit.Assert.*;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.AreaDao;
import dao.ConnectionPool;
import modelo.Area;

public class AreaDaoTest {

	private static final String NOME = "nome";
	private static final String DESCRICAO = "descricao";
	private static final String NOVO_NOME = "novo-nome";
	private static final String NOVA_DESCRICAO = "nova-descricao";
	private static final Serializable ID_QUE_NAO_EXISTE = "id-que-n@o-existe.";

	private AreaDao dao;

	@Before
	public void init() {
		truncate();
	}

	@After
	public void finish() {
		truncate();
	}

	private void truncate() {
		try (Connection con = new ConnectionPool().getConnection()) {
			try (PreparedStatement stmt = con.prepareStatement("truncate table area")) {
				stmt.execute();
			}
		} catch (SQLException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void test() {
		try (Connection con = new ConnectionPool().getConnection()) {

			Area a1 = new Area(NOME, DESCRICAO);

			dao = new AreaDao(con);

			assertTrue(dao.listAll().size() == 0);

			// persist
			dao.persist(a1);

			assertTrue(dao.listAll().size() == 1);
			assertEquals(NOME, dao.listAll().get(0).getNome());

			// exist
			assertTrue(dao.exists(NOME));

			// non-exist
			assertTrue(!dao.exists(ID_QUE_NAO_EXISTE));

			// null-exist
			assertTrue(!dao.exists(null));

			// search
			Area a2 = dao.search(a1.getNome());
			assertEquals(DESCRICAO, a2.getDescricao());

			// non-search
			assertNull(dao.search(ID_QUE_NAO_EXISTE));

			// null-search
			assertNull(dao.search(null));

			// update
			Area a3 = new Area(NOVO_NOME, NOVA_DESCRICAO);
			int update = dao.update(a1.getNome(), a3);
			assertTrue(update == 1);

			// search novo nome
			Area a4 = dao.search(NOVO_NOME);
			assertEquals(NOVO_NOME, a4.getNome());
			assertEquals(NOVA_DESCRICAO, a4.getDescricao());
			assertTrue(dao.listAll().size() == 1);

			// remove
			int remove = dao.delete(a4);
			assertTrue(remove > 0);
			assertTrue(dao.listAll().size() == 0);

			// vazio
			Area a5 = dao.search(a4.getNome());
			assertNull(a5);

		} catch (SQLException e) {
			fail(e.getMessage());
		}
	}

}
