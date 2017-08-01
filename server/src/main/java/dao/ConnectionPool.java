package dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

public class ConnectionPool {

	private DataSource dataSource;

	public ConnectionPool() {
		MysqlDataSource pool = new MysqlDataSource();
		pool.setUrl("jdbc:mysql://127.0.0.1:3306/inticdb");
		pool.setUser("intic");
		pool.setPassword("intic");
		this.dataSource = pool;
	}
	
//	public ConnectionPool(String url) {
//		PGPoolingDataSource pool = new PGPoolingDataSource();
//		
//		pool.setServerName("localhost");
//		pool.setPortNumber(5432);
//		pool.setDatabaseName("inticdb");
//		pool.setUser("postgres");
//		pool.setPassword("postgres");
//		
//		this.dataSource = pool;
//	}

	/**
	 * 
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

}
