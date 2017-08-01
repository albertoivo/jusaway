package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Acao;

public class AcaoDao extends AbstractDao<Acao> {

	public AcaoDao(Connection con) {
		super.con = con;
	}

	@Override
	public boolean persist(Acao acao) throws SQLException {
		String sql = "insert into acao values (?, ?)";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, acao.getNome());
			stmt.setString(2, acao.getDescricao());
			return stmt.execute();
		}
	}

	@Override
	public Acao search(Serializable id) throws SQLException {
		String sql = "select * from acao where nome like ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, "%" + id + "%");
			stmt.execute();
			List<Acao> acaos = new ArrayList<>();
			acaos = transformaLista(stmt, this::transformaAcao);
			if (acaos != null && acaos.size() == 1) {
				return acaos.get(0);
			}
			return null;
		}
	}

	@Override
	public int delete(Acao acao) throws SQLException {
		try (PreparedStatement stmt = con.prepareStatement("delete from acao where nome = ?")) {
			stmt.setString(1, acao.getNome());
			return stmt.executeUpdate();
		}
	}

	public int remove(String nome) throws SQLException {
		try (PreparedStatement stmt = con.prepareStatement("delete from acao where nome = ?")) {
			stmt.setString(1, nome);
			return stmt.executeUpdate();
		}
	}

	@Override
	public int update(Serializable id, Acao novaAcao) throws SQLException {
		String sql = "update acao set nome = ?, descricao = ? where nome = ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, novaAcao.getNome());
			stmt.setString(2, novaAcao.getDescricao());
			stmt.setString(3, (String) id);
			return stmt.executeUpdate();
		}
	}

	@Override
	public List<Acao> listAll() throws SQLException {
		String sql = "select * from acao";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.execute();
			return transformaLista(stmt, this::transformaAcao);
		}
	}

	private Acao transformaAcao(ResultSet rs) throws SQLException {
		String nome = rs.getString("nome");
		String descricao = rs.getString("descricao");
		return new Acao(nome, descricao);
	}

	@Override
	boolean exists(Serializable id) throws SQLException {
		String sql = "select true from acao where nome = ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, (String) id);
			try (ResultSet rs = stmt.executeQuery()) {
				return rs.next();
			}
		}
	}

}
