package main;

import com.google.gson.Gson;

import bd.ReporteEnBD;
import modelo.EnArchivoPlano;
import modelo.EnBaseDeDatos;
import modelo.EnConsola;
import modelo.ReporteJson;
import modelo.RestCall;

public class Main {

	public static void main(String[] args) {
		RestCall rest = new RestCall("https://jsonplaceholder.typicode.com/posts");
		ReporteEnBD reporteEnBD = new ReporteEnBD();

		new EnConsola(new EnArchivoPlano(new EnBaseDeDatos(rest, reporteEnBD), "C:\\Users\\Emy_m\\Desktop\\asd.txt"))
				.run();

		Gson gson = new Gson();
		RestCall restCallSimple = new RestCall("https://jsonplaceholder.typicode.com/posts/1");
		ReporteJson reporteJson = gson.fromJson(restCallSimple.run(), ReporteJson.class);
		System.out.println(reporteJson);
	}

}
