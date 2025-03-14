package util;

import java.sql.Connection;

public class TesteConexao {
	public static void main(String[] args) {
		Connection connection = DatabaseConnection.getConnection();

		if (connection != null) {
			System.out.println("Conexão com o banco de dados foi bem-sucedida!");
		} else {
			System.out.println("Falha ao conectar ao banco de dados.");
		}

		DatabaseConnection.closeConnection();
	}
}
