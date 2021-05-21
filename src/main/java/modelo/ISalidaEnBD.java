package modelo;

public interface ISalidaEnBD {
	void guardarLineaDeReporte(String idReporte, String idUsuario, String titulo, String cuerpo);
}
