package modelo;

public class EnConsola implements Comunicacion {

	private Comunicacion comunicacion;

	public EnConsola(Comunicacion comunicacion) {
		this.comunicacion = comunicacion;
	}

	@Override
	public String run() {
		String reporte = comunicacion.run();
		System.out.println(reporte);
		return reporte;
	}

}
