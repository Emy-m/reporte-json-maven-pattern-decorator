package modelo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ReporteJson {
	private int userId;
	private int id;
	private String title;
	private String body;

	public ReporteJson(int userId, int id, String title, String body) {
		this.userId = userId;
		this.id = id;
		this.title = title;
		this.body = body;
	}

	public int obtenerIdUsuario() {
		return this.userId;
	}

	public int obtenerIdReporte() {
		return this.id;
	}

	public String obtenerTitulo() {
		return this.title;
	}

	public String obtenerCuerpoReporte() {
		return this.body;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
