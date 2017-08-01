package dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.AtividadeDao;
import dao.ConnectionPool;
import modelo.Atividade;

public class AtividadeDaoTest {

	private static final String NOME = "nome";
	private static final String DESCRICAO = "descricao";
	private static final String NOVO_NOME = "novo-nome";
	private static final String NOVA_DESCRICAO = "nova-descricao";

	private AtividadeDao dao;

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
			try (PreparedStatement stmt = con.prepareStatement("truncate table atividade")) {
				stmt.execute();
			}
		} catch (SQLException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void test() {
		try (Connection con = new ConnectionPool().getConnection()) {

			Atividade a1 = new Atividade(NOME, DESCRICAO);

			dao = new AtividadeDao(con);

			assertTrue(dao.listAll().size() == 0);

			// persist
			dao.persist(a1);

			assertTrue(dao.listAll().size() == 1);
			assertEquals(NOME, dao.listAll().get(0).getNome());

			// search
			Atividade a2 = dao.search(a1.getNome());
			assertEquals(DESCRICAO, a2.getDescricao());
			
			// search nao existente
			a2 = dao.search("id que nao existe");
			assertNull(a2);

			// update
			Atividade a3 = new Atividade(NOVO_NOME, NOVA_DESCRICAO);
			dao.update(a1.getNome(), a3);

			// search novo nome
			Atividade a4 = dao.search(NOVO_NOME);
			assertEquals(NOVO_NOME, a4.getNome());
			assertEquals(NOVA_DESCRICAO, a4.getDescricao());
			
			assertTrue(dao.listAll().size() == 1);
			
			// remove
			int remove = dao.delete(a4);
			assertTrue(remove > 0);
			assertTrue(dao.listAll().size() == 0);
			
			// vazio
			Atividade a5 = dao.search(a4.getNome());
			assertNull(a5);
			
		} catch (SQLException e) {
			fail(e.getMessage());
		}
	}

}
