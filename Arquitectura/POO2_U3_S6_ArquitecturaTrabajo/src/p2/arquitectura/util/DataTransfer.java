package p2.arquitectura.util;

public class DataTransfer {

	private String nombreCompleto;
	
	/*
	 * Inicio
	 * Bloque creación singleton
	 */
	private static DataTransfer instance;
	
	private DataTransfer() {		
	}
	
	public static DataTransfer getInstance() {
		if(instance==null) {
			instance = new DataTransfer();
		}
		
		return instance;
	}
	
	/*
	 * Fin
	 * Bloque creación singleton
	 */
	
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	
}
