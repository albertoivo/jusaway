package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Area;

public class AreaDao extends AbstractDao<Area> {

	public AreaDao(Connection con) {
		super.con = con;
	}

	public boolean exists(Serializable id) throws SQLException {
		String sql = "select true from area where nome = ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, (String) id);
			try (ResultSet rs = stmt.executeQuery()) {
				return rs.next();
			}
		}
	}

	@Override
	public boolean persist(Area area) throws SQLException {
		String sql = "insert into area values (?, ?)";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, area.getNome());
			stmt.setString(2, area.getDescricao());
			return stmt.execute();
		}
	}

	@Override
	public Area search(Serializable id) throws SQLException {
		String sql = "select * from area where nome like ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, "%" + id + "%");
			stmt.execute();
			List<Area> areas = new ArrayList<>();
			areas = transformaLista(stmt, this::transformaArea);
			if (areas != null && areas.size() == 1) {
				return areas.get(0);
			}
			return null;
		}
	}

	@Override
	public int delete(Area area) throws SQLException {
		try (PreparedStatement stmt = con.prepareStatement("delete from area where nome = ?")) {
			stmt.setString(1, area.getNome());
			return stmt.executeUpdate();
		}
	}

	public int remove(String nome) throws SQLException {
		try (PreparedStatement stmt = con.prepareStatement("delete from area where nome = ?")) {
			stmt.setString(1, nome);
			return stmt.executeUpdate();
		}
	}

	@Override
	public int update(Serializable id, Area novaArea) throws SQLException {
		String sql = "update area set nome = ?, descricao = ? where nome = ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, novaArea.getNome());
			stmt.setString(2, novaArea.getDescricao());
			stmt.setString(3, (String) id);
			return stmt.executeUpdate();
		}
	}

	@Override
	public List<Area> listAll() throws SQLException {
		List<Area> areas;
		String sql = "select * from area";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.execute();
			areas = transformaLista(stmt, this::transformaArea);
		}
		return areas;
	}

	private Area transformaArea(ResultSet rs) throws SQLException {
		String nome = rs.getString("nome");
		String descricao = rs.getString("descricao");
		return new Area(nome, descricao);
	}

}
