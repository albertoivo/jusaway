package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Atividade;

public class AtividadeDao extends AbstractDao<Atividade> {

	public AtividadeDao(Connection con) {
		super.con = con;
	}

	@Override
	public boolean persist(Atividade atividade) throws SQLException {
		String sql = "insert into atividade values (?, ?)";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, atividade.getNome());
			stmt.setString(2, atividade.getDescricao());
			return stmt.execute();
		}
	}

	@Override
	public Atividade search(Serializable id) throws SQLException {
		String sql = "select * from atividade where nome like ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, "%" + id + "%");
			stmt.execute();
			List<Atividade> atividades = new ArrayList<>();
			atividades = transformaLista(stmt, this::transformaAtividade);
			if (atividades != null && atividades.size() == 1) {
				return atividades.get(0);
			}
			return null;
		}
	}

	@Override
	public int delete(Atividade atividade) throws SQLException {
		try (PreparedStatement stmt = con.prepareStatement("delete from atividade where nome = ?")) {
			stmt.setString(1, atividade.getNome());
			return stmt.executeUpdate();
		}
	}

	public int remove(String nome) throws SQLException {
		try (PreparedStatement stmt = con.prepareStatement("delete from atividade where nome = ?")) {
			stmt.setString(1, nome);
			return stmt.executeUpdate();
		}
	}

	@Override
	public int update(Serializable id, Atividade novaAtividade) throws SQLException {
		String sql = "update atividade set nome = ?, descricao = ? where nome = ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, novaAtividade.getNome());
			stmt.setString(2, novaAtividade.getDescricao());
			stmt.setString(3, (String) id);
			return stmt.executeUpdate();
		}
	}

	@Override
	public List<Atividade> listAll() throws SQLException {
		List<Atividade> atividades;
		String sql = "select * from atividade";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.execute();
			atividades = transformaLista(stmt, this::transformaAtividade);
		}
		return atividades;
	}

	private Atividade transformaAtividade(ResultSet rs) throws SQLException {
		String nome = rs.getString("nome");
		String descricao = rs.getString("descricao");
		return new Atividade(nome, descricao);
	}

	@Override
	boolean exists(Serializable id) throws SQLException {
		String sql = "select true from atividade where nome = ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, (String) id);
			try (ResultSet rs = stmt.executeQuery()) {
				return rs.next();
			}
		}
	}

}
