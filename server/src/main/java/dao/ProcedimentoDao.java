package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Procedimento;

public class ProcedimentoDao extends AbstractDao<Procedimento> {

	public ProcedimentoDao(Connection con) {
		super.con = con;
	}

	@Override
	public boolean persist(Procedimento procedimento) throws SQLException {
		String sql = "insert into procedimento values (?, ?)";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, procedimento.getNome());
			stmt.setString(2, procedimento.getDescricao());
			return stmt.execute();
		}
	}

	@Override
	public Procedimento search(Serializable id) throws SQLException {
		String sql = "select * from procedimento where nome like ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, "%" + id + "%");
			stmt.execute();
			List<Procedimento> procedimentos = new ArrayList<>();
			procedimentos = transformaLista(stmt, this::transformaProcedimento);
			if (procedimentos != null && procedimentos.size() == 1) {
				return procedimentos.get(0);
			}
			return null;
		}
	}

	@Override
	public int delete(Procedimento procedimento) throws SQLException {
		try (PreparedStatement stmt = con.prepareStatement("delete from procedimento where nome = ?")) {
			stmt.setString(1, procedimento.getNome());
			return stmt.executeUpdate();
		}
	}

	public int remove(String nome) throws SQLException {
		try (PreparedStatement stmt = con.prepareStatement("delete from procedimento where nome = ?")) {
			stmt.setString(1, nome);
			return stmt.executeUpdate();
		}
	}

	@Override
	public int update(Serializable id, Procedimento novaProcedimento) throws SQLException {
		String sql = "update procedimento set nome = ?, descricao = ? where nome = ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, novaProcedimento.getNome());
			stmt.setString(2, novaProcedimento.getDescricao());
			stmt.setString(3, (String) id);
			return stmt.executeUpdate();
		}
	}

	@Override
	public List<Procedimento> listAll() throws SQLException {
		List<Procedimento> procedimentos;
		String sql = "select * from procedimento";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.execute();
			procedimentos = transformaLista(stmt, this::transformaProcedimento);
		}
		return procedimentos;
	}

	private Procedimento transformaProcedimento(ResultSet rs) throws SQLException {
		String nome = rs.getString("nome");
		String descricao = rs.getString("descricao");
		return new Procedimento(nome, descricao);
	}

	@Override
	boolean exists(Serializable id) throws SQLException {
		String sql = "select true from procedimento where nome = ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, (String) id);
			try (ResultSet rs = stmt.executeQuery()) {
				return rs.next();
			}
		}
	}

}
