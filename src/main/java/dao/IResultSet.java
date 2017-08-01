package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
interface IResultSet<T> {

	T iResultSet(ResultSet rs) throws SQLException;

}