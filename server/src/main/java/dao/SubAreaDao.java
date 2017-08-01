package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.SubArea;

public class SubAreaDao extends AbstractDao<SubArea> {

	public SubAreaDao(Connection con) {
		super.con = con;
	}

	@Override
	public boolean persist(SubArea area) throws SQLException {
		String sql = "insert into subarea values (?, ?)";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, area.getNome());
			stmt.setString(2, area.getDescricao());
			return stmt.execute();
		}
	}

	@Override
	public SubArea search(Serializable id) throws SQLException {
		String sql = "select * from subarea where nome like ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, "%" + id + "%");
			stmt.execute();
			List<SubArea> areas = new ArrayList<>();
			areas = transformaLista(stmt, this::transformaSubArea);
			if (areas != null && areas.size() == 1) {
				return areas.get(0);
			}
			return null;
		}
	}

	@Override
	public int delete(SubArea area) throws SQLException {
		try (PreparedStatement stmt = con.prepareStatement("delete from subarea where nome = ?")) {
			stmt.setString(1, area.getNome());
			return stmt.executeUpdate();
		}
	}

	public int remove(String nome) throws SQLException {
		try (PreparedStatement stmt = con.prepareStatement("delete from subarea where nome = ?")) {
			stmt.setString(1, nome);
			return stmt.executeUpdate();
		}
	}

	@Override
	public int update(Serializable id, SubArea novaSubArea) throws SQLException {
		String sql = "update subarea set nome = ?, descricao = ? where nome = ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, novaSubArea.getNome());
			stmt.setString(2, novaSubArea.getDescricao());
			stmt.setString(3, (String) id);
			return stmt.executeUpdate();
		}
	}

	@Override
	public List<SubArea> listAll() throws SQLException {
		List<SubArea> areas;
		String sql = "select * from subarea";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.execute();
			areas = transformaLista(stmt, this::transformaSubArea);
		}
		return areas;
	}

	private SubArea transformaSubArea(ResultSet rs) throws SQLException {
		String nome = rs.getString("nome");
		String descricao = rs.getString("descricao");
		return new SubArea(nome, descricao);
	}

	@Override
	boolean exists(Serializable id) throws SQLException {
		String sql = "select true from subarea where nome = ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, (String) id);
			try (ResultSet rs = stmt.executeQuery()) {
				return rs.next();
			}
		}
	}

}
