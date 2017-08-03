package dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

public class ConnectionPool {

	private DataSource dataSource;

	public ConnectionPool() {
		MysqlDataSource pool = new MysqlDataSource();
		pool.setUrl("jdbc:mysql://127.0.0.1:3306/jusawaydb");
		pool.setUser("jusaway");
		pool.setPassword("jusaway");
		this.dataSource = pool;
	}
	
	/**
	 * 
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

}
