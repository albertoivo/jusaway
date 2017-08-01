package performance;

public class Postgres {
	

	/**
	 * Postgres
	 */
//	@Test
//	public void test() throws SQLException {
//		try (Connection con = new ConnectionPool("postgres").getConnection()) {
//			int size = 50;
//			AreaDao dao = new AreaDao(con);
//			for (int i = 0; i < size; i++) {
//				dao.persist(new Area("area" + i));
//			}
//			for (int i = 0; i < size; i++) {
//				assertTrue(dao.exists("area" + i));
//			}
//			for (int i = 0; i < size; i++) {
//				dao.update("area" + i, new Area("a" + i, "desc"));
//			}
//			for (int i = 0; i < size; i++) {
//				dao.remove("a" + i);
//			}
//		}
//	}
//	
//	@BeforeClass
//	public static void init() throws SQLException {
//		truncate();
//	}
//
//	@AfterClass
//	public static void finish() throws SQLException {
//		truncate();
//	}
//
//	private static void truncate() {
//		try (Connection con = new ConnectionPool("postgres").getConnection()) {
//			try (PreparedStatement stmt = con.prepareStatement("truncate table area")) {
//				stmt.execute();
//			}
//		} catch (SQLException e) {
//			fail(e.getMessage());
//		}
//	}
}
