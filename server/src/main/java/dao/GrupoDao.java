package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Grupo;

public class GrupoDao extends AbstractDao<Grupo> {

	public GrupoDao(Connection con) {
		super.con = con;
	}

	@Override
	public boolean persist(Grupo grupo) throws SQLException {
		String sql = "insert into grupo values (?, ?)";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, grupo.getNome());
			stmt.setString(2, grupo.getDescricao());
			return stmt.execute();
		}
	}

	@Override
	public Grupo search(Serializable id) throws SQLException {
		String sql = "select * from grupo where nome like ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, "%" + id + "%");
			stmt.execute();
			List<Grupo> grupos = new ArrayList<>();
			grupos = transformaLista(stmt, this::transformaGrupo);
			if (grupos != null && grupos.size() == 1) {
				return grupos.get(0);
			}
			return null;
		}
	}

	@Override
	public int delete(Grupo grupo) throws SQLException {
		try (PreparedStatement stmt = con.prepareStatement("delete from grupo where nome = ?")) {
			stmt.setString(1, grupo.getNome());
			return stmt.executeUpdate();
		}
	}

	public int remove(String nome) throws SQLException {
		try (PreparedStatement stmt = con.prepareStatement("delete from grupo where nome = ?")) {
			stmt.setString(1, nome);
			return stmt.executeUpdate();
		}
	}

	@Override
	public int update(Serializable id, Grupo novaGrupo) throws SQLException {
		String sql = "update grupo set nome = ?, descricao = ? where nome = ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, novaGrupo.getNome());
			stmt.setString(2, novaGrupo.getDescricao());
			stmt.setString(3, (String) id);
			return stmt.executeUpdate();
		}
	}

	@Override
	public List<Grupo> listAll() throws SQLException {
		List<Grupo> grupos;
		String sql = "select * from grupo";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.execute();
			grupos = transformaLista(stmt, this::transformaGrupo);
		}
		return grupos;
	}

	private Grupo transformaGrupo(ResultSet rs) throws SQLException {
		String nome = rs.getString("nome");
		String descricao = rs.getString("descricao");
		return new Grupo(nome, descricao);
	}

	@Override
	boolean exists(Serializable id) throws SQLException {
		String sql = "select true from grupo where nome = ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, (String) id);
			try (ResultSet rs = stmt.executeQuery()) {
				return rs.next();
			}
		}
	}

}
