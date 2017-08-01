package performance;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.AreaDao;
import dao.ConnectionPool;
import modelo.Area;

public class mysql {
	
	private int size = 100000;

	/**
	 * MySQL
	 */
	@Test
	public void test() throws SQLException {
		try (Connection con = new ConnectionPool().getConnection()) {
			AreaDao dao = new AreaDao(con);
			for (int i = 0; i < size; i++) {
				dao.persist(new Area("area" + i));
			}
			for (int i = 0; i < size; i++) {
				assertTrue(dao.exists("area" + i));
			}
			for (int i = 0; i < size; i++) {
				dao.update("area" + i, new Area("a" + i, "desc"));
			}
			for (int i = 0; i < size; i++) {
				dao.remove("a" + i);
			}
		}
	}
	
	@BeforeClass
	public static void init() throws SQLException {
		truncate();
	}

	@AfterClass
	public static void finish() throws SQLException {
		truncate();
	}

	private static void truncate() {
		try (Connection con = new ConnectionPool().getConnection()) {
			try (PreparedStatement stmt = con.prepareStatement("truncate table area")) {
				stmt.execute();
			}
		} catch (SQLException e) {
			fail(e.getMessage());
		}
	}
}
