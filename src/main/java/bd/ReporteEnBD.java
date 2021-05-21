package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import modelo.ISalidaEnBD;

public class ReporteEnBD implements ISalidaEnBD {

	private final String ESTRUCTURA_TABLA = "('id_reporte', 'id_usuario', 'titulo', 'cuerpo', 'fecha')";
	private final String SQL_INSERT = "insert into reportes values (?, ?, ?, ?, ?)";

	@Override
	public void guardarLineaDeReporte(String idReporte, String idUsuario, String titulo, String cuerpo) {
		Connection conexion = Conexion.conectar();
		PreparedStatement transaccion = Conexion.prepararTransaccion(conexion, SQL_INSERT);
		LocalDateTime fecha = LocalDateTime.now();

		try {
			transaccion.setString(1, idReporte);
			transaccion.setString(2, idUsuario);
			transaccion.setString(3, titulo);
			transaccion.setString(4, cuerpo);
			transaccion.setTimestamp(5, Timestamp.valueOf(fecha));

			transaccion.execute();
		} catch (SQLException e) {
			throw new PersistenciaException("Error preparando la transaccion", e);
		} finally {
			try {
				transaccion.close();
				conexion.close();
			} catch (SQLException e) {
				throw new PersistenciaException("Error preparando la transaccion", e);
			}
		}
	}

}
