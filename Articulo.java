package crear_documentos;

import java.util.List;

public class Articulo extends Documentos {
	
	// Constructor for the Articulo class
	public Articulo(String titulo, String fechaDePublicacion, List<Autores> autoreslist, String isbn, String editorial) {
		
		// Call the constructor of the superclass Documentos using the 'super' keyword
		super(titulo, fechaDePublicacion, autoreslist, isbn, editorial);
	}

}