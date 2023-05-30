package crear_documentos;

public class Articulo extends Documentos {
	
	// Constructor for the Articulo class
	public Articulo(String titulo, String fechaDePublicacion, Autores autor, String isbn, String editorial) {
		
		// Call the constructor of the superclass Documentos using the 'super' keyword
		super(titulo, fechaDePublicacion, autor, isbn, editorial);
	}

}