package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

abstract class AbstractDao<T> {

	Connection con;

	abstract boolean exists(Serializable id) throws SQLException;

	abstract boolean persist(T entity) throws SQLException;

	abstract int delete(T entity) throws SQLException;

	abstract int update(Serializable id, T entity) throws SQLException;

	abstract T search(Serializable id) throws SQLException;

	abstract List<T> listAll() throws SQLException;

	static <T> List<T> transformaLista(PreparedStatement stmt, IResultSet<T> transformaResultSetT) throws SQLException {
		try (ResultSet rs = stmt.getResultSet()) {
			List<T> lista = new ArrayList<>();
			while (rs.next()) {
				T entity = transformaResultSetT.iResultSet(rs);
				lista.add(entity);
			}
			return lista;
		}
	}
}
