package concurso.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import concurso.exceptions.GenericException;


public class AdministradorDeConexiones {

public static Connection obtenerConexion() throws GenericException {
		
		String url = "jdbc:mysql://localhost/concurso_db";
		String user = "root";
		String password = "";
		String driverName = "com.mysql.jdbc.Driver";
		
		try {
			Class.forName(driverName);
			Connection connection = DriverManager.getConnection(url, user, password);
			return connection;
		} catch (ClassNotFoundException | SQLException e) {
			throw new GenericException("Error obteniendo conexion: "+ e.getMessage(),e);
		}
		
	}
}
