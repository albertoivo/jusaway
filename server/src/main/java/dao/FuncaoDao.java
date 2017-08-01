package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Funcao;

public class FuncaoDao extends AbstractDao<Funcao> {

	public FuncaoDao(Connection con) {
		super.con = con;
	}

	@Override
	public boolean persist(Funcao funcao) throws SQLException {
		String sql = "insert into funcao values (?, ?)";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, funcao.getNome());
			stmt.setString(2, funcao.getDescricao());
			return stmt.execute();
		}
	}

	@Override
	public Funcao search(Serializable id) throws SQLException {
		String sql = "select * from funcao where nome like ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, "%" + id + "%");
			stmt.execute();
			List<Funcao> funcaos = new ArrayList<>();
			funcaos = transformaLista(stmt, this::transformaFuncao);
			if (funcaos != null && funcaos.size() == 1) {
				return funcaos.get(0);
			}
			return null;
		}
	}

	@Override
	public int delete(Funcao funcao) throws SQLException {
		try (PreparedStatement stmt = con.prepareStatement("delete from funcao where nome = ?")) {
			stmt.setString(1, funcao.getNome());
			return stmt.executeUpdate();
		}
	}

	public int remove(String nome) throws SQLException {
		try (PreparedStatement stmt = con.prepareStatement("delete from funcao where nome = ?")) {
			stmt.setString(1, nome);
			return stmt.executeUpdate();
		}
	}

	@Override
	public int update(Serializable id, Funcao novaFuncao) throws SQLException {
		String sql = "update funcao set nome = ?, descricao = ? where nome = ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, novaFuncao.getNome());
			stmt.setString(2, novaFuncao.getDescricao());
			stmt.setString(3, (String) id);
			return stmt.executeUpdate();
		}
	}

	@Override
	public List<Funcao> listAll() throws SQLException {
		List<Funcao> funcaos;
		String sql = "select * from funcao";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.execute();
			funcaos = transformaLista(stmt, this::transformaFuncao);
		}
		return funcaos;
	}

	private Funcao transformaFuncao(ResultSet rs) throws SQLException {
		String nome = rs.getString("nome");
		String descricao = rs.getString("descricao");
		return new Funcao(nome, descricao);
	}

	@Override
	boolean exists(Serializable id) throws SQLException {
		String sql = "select true from funcao where nome = ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, (String) id);
			try (ResultSet rs = stmt.executeQuery()) {
				return rs.next();
			}
		}
	}

}
