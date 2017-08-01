package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.LocalTramitacao;

public class LocalTramitacaoDao extends AbstractDao<LocalTramitacao> {

	public LocalTramitacaoDao(Connection con) {
		super.con = con;
	}

	@Override
	public boolean persist(LocalTramitacao localtramitacao) throws SQLException {
		String sql = "insert into localtramitacao values (?, ?)";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, localtramitacao.getNome());
			stmt.setString(2, localtramitacao.getDescricao());
			return stmt.execute();
		}
	}

	@Override
	public LocalTramitacao search(Serializable id) throws SQLException {
		String sql = "select * from localtramitacao where nome like ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, "%" + id + "%");
			stmt.execute();
			List<LocalTramitacao> localtramitacaos = new ArrayList<>();
			localtramitacaos = transformaLista(stmt, this::transformaLocalTramitacao);
			if (localtramitacaos != null && localtramitacaos.size() == 1) {
				return localtramitacaos.get(0);
			}
			return null;
		}
	}

	@Override
	public int delete(LocalTramitacao localtramitacao) throws SQLException {
		try (PreparedStatement stmt = con.prepareStatement("delete from localtramitacao where nome = ?")) {
			stmt.setString(1, localtramitacao.getNome());
			return stmt.executeUpdate();
		}
	}

	public int remove(String nome) throws SQLException {
		try (PreparedStatement stmt = con.prepareStatement("delete from localtramitacao where nome = ?")) {
			stmt.setString(1, nome);
			return stmt.executeUpdate();
		}
	}

	@Override
	public int update(Serializable id, LocalTramitacao novaLocalTramitacao) throws SQLException {
		String sql = "update localtramitacao set nome = ?, descricao = ? where nome = ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, novaLocalTramitacao.getNome());
			stmt.setString(2, novaLocalTramitacao.getDescricao());
			stmt.setString(3, (String) id);
			return stmt.executeUpdate();
		}
	}

	@Override
	public List<LocalTramitacao> listAll() throws SQLException {
		List<LocalTramitacao> localtramitacaos;
		String sql = "select * from localtramitacao";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.execute();
			localtramitacaos = transformaLista(stmt, this::transformaLocalTramitacao);
		}
		return localtramitacaos;
	}

	private LocalTramitacao transformaLocalTramitacao(ResultSet rs) throws SQLException {
		String nome = rs.getString("nome");
		String descricao = rs.getString("descricao");
		return new LocalTramitacao(nome, descricao);
	}

	@Override
	boolean exists(Serializable id) throws SQLException {
		String sql = "select true from localtramitacao where nome = ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, (String) id);
			try (ResultSet rs = stmt.executeQuery()) {
				return rs.next();
			}
		}
	}

}
