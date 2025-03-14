package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
	private static Connection connection;

	public static Connection getConnection() {
		if (connection == null) {
			try {
				Properties props = new Properties();
				props.load(DatabaseConnection.class.getResourceAsStream("/config.properties"));

				String url = "jdbc:mysql://" + props.getProperty("DBADDRESS") + ":" + props.getProperty("DBPORT") + "/"
						+ props.getProperty("DBNAME");

				connection = DriverManager.getConnection(url, props.getProperty("DBUSER"),
						props.getProperty("DBPASSWORD"));
				System.out.println("Conexão com o banco de dados estabelecida!");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Erro ao conectar ao banco de dados.");
			}
		}
		return connection;
	}

	public static void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
				System.out.println("Conexão com o banco de dados fechada.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
