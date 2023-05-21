package crear_documentos;

import java.util.List;

public class Ponencias extends Documentos {
	
	private String nombreCongreso;
	
	public Ponencias(String titulo, String fechaDePublicacion, List<Autores> autoreslist, String isbn, String editorial, String nombreCongreso) {
		// Call the superclass constructor using the "super" keyword
		super(titulo, fechaDePublicacion, autoreslist, isbn, editorial);
		this.nombreCongreso = nombreCongreso; 
	}

	public String getNombreCongreso() {
		return nombreCongreso;  // Getter method to retrieve the nombreCongreso value
	}

	public void setNombreCongreso(String nombreCongreso) {
		this.nombreCongreso = nombreCongreso;  // Setter method to set the nombreCongreso value
	}
	
}
