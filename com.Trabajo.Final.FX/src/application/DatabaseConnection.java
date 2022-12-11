package application;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

	Connection connection;

	public Connection getConnection() {
		String dbName = "trabajoaccesoAdatos";
		String userName = "root";
		String password = "Administrador_0";
		//Administrador_0

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName, userName, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;

	}
}
