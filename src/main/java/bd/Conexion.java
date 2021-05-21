package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexion {
	private static final String CONTROLADOR = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/reportes_java_maven";
	private static final String USUARIO = "root";
	private static final String CLAVE = "";

	public static Connection conectar() {
		Connection conexion = null;
		try {
			Class.forName(CONTROLADOR);
			conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);

			return conexion;
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException("Hubo un error con la base de datos", e);
		}
	}

	public static Connection conectar(Boolean autoCommit) {
		Connection conexion = null;
		try {
			Class.forName(CONTROLADOR);
			conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
			conexion.setAutoCommit(autoCommit);

			return conexion;
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException("Hubo un error con la base de datos", e);
		}
	}

	public static PreparedStatement prepararTransaccion(Connection conexion, String transaccion) {
		try {
			return conexion.prepareStatement(transaccion);
		} catch (SQLException e) {
			throw new PersistenciaException("Error creando la transaccion", e);
		}
	}
}
