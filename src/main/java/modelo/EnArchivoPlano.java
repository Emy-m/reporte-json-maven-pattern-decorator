package modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EnArchivoPlano implements Comunicacion {

	private Comunicacion comunicacion;
	private String ubicacion;

	public EnArchivoPlano(Comunicacion comunicacion, String ubicacion) {
		this.comunicacion = comunicacion;
		this.ubicacion = ubicacion;
	}

	@Override
	public String run() {
		try {
			String reporte = comunicacion.run();
			File archivoPlano = new File(ubicacion);
			FileWriter escritura = new FileWriter(archivoPlano);
			escritura.write(reporte);
			escritura.close();
			return reporte;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
