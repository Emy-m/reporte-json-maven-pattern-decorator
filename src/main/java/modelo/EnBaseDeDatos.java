package modelo;

import java.util.Properties;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class EnBaseDeDatos implements Comunicacion {

	private Comunicacion comunicacion;
	private ISalidaEnBD reporteEnBD;

	public EnBaseDeDatos(Comunicacion comunicacion, ISalidaEnBD reporteEnBD) {
		this.comunicacion = comunicacion;
		this.reporteEnBD = reporteEnBD;
	}

	@Override
	public String run() {
		String jsonString = comunicacion.run();
		JsonArray jsonArray = (JsonArray) JsonParser.parseString(jsonString);

		for (JsonElement lineaDeReporte : jsonArray) {
			Properties propiedadesLineaReporte = new Gson().fromJson(lineaDeReporte.toString(), Properties.class);
			reporteEnBD.guardarLineaDeReporte(propiedadesLineaReporte.getProperty("id"),
					propiedadesLineaReporte.getProperty("userId"), propiedadesLineaReporte.getProperty("title"),
					propiedadesLineaReporte.getProperty("body"));
		}

		return jsonString;
	}

}
