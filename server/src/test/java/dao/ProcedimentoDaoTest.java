package dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.ProcedimentoDao;
import dao.ConnectionPool;
import modelo.Procedimento;

public class ProcedimentoDaoTest {

	private static final String NOME = "nome";
	private static final String DESCRICAO = "descricao";
	private static final String NOVO_NOME = "novo-nome";
	private static final String NOVA_DESCRICAO = "nova-descricao";

	private ProcedimentoDao dao;

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
			try (PreparedStatement stmt = con.prepareStatement("truncate table procedimento")) {
				stmt.execute();
			}
		} catch (SQLException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void test() {
		try (Connection con = new ConnectionPool().getConnection()) {

			Procedimento a1 = new Procedimento(NOME, DESCRICAO);

			dao = new ProcedimentoDao(con);

			assertTrue(dao.listAll().size() == 0);

			// persist
			dao.persist(a1);

			assertTrue(dao.listAll().size() == 1);
			assertEquals(NOME, dao.listAll().get(0).getNome());

			// search
			Procedimento a2 = dao.search(a1.getNome());
			assertEquals(DESCRICAO, a2.getDescricao());
			
			// search nao existente
			a2 = dao.search("id que nao existe");
			assertNull(a2);

			// update
			Procedimento a3 = new Procedimento(NOVO_NOME, NOVA_DESCRICAO);
			dao.update(a1.getNome(), a3);

			// search novo nome
			Procedimento a4 = dao.search(NOVO_NOME);
			assertEquals(NOVO_NOME, a4.getNome());
			assertEquals(NOVA_DESCRICAO, a4.getDescricao());
			
			assertTrue(dao.listAll().size() == 1);
			
			// remove
			int remove = dao.delete(a4);
			assertTrue(remove > 0);
			assertTrue(dao.listAll().size() == 0);
			
			// vazio
			Procedimento a5 = dao.search(a4.getNome());
			assertNull(a5);
			
		} catch (SQLException e) {
			fail(e.getMessage());
		}
	}

}
