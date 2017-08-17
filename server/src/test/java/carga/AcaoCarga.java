package carga;

import java.sql.Connection;
import java.sql.SQLException;

import dao.AcaoDao;
import dao.ConnectionPool;
import modelo.Acao;

public class AcaoCarga {

	public static void main(String[] args) {
		
		System.out.println("Iniciando a carga de Ação.");

		try (Connection con = new ConnectionPool().getConnection()) {

			for (int i = 1; i < 30; i++) {
				new AcaoDao(con).persist(new Acao("acao " + i, "desc " + i));
			}
			
			for (int i = 1; i < 30; i++) {
				new AcaoDao(con).persist(new Acao("nome " + i, "text " + i));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
