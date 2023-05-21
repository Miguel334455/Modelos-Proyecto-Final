package crear_documentos;

import java.util.List;

public class Libro extends Documentos {
	
	private int numeroDePaginas;
	
	public Libro(String titulo, String fechaDePublicacion, List<Autores> autoreslist, String isbn, String editorial, int numeroDePaginas) {
		// Call the superclass constructor using the "super" keyword
		super(titulo, fechaDePublicacion, autoreslist, isbn, editorial);
		this.numeroDePaginas = numeroDePaginas;
	}

	// Getter and Setter for the numeroDePaginas field
	public int getNumeroDePaginas() {
		return numeroDePaginas;
	}

	public void setNumeroDePaginas(int numeroDePaginas) {
		this.numeroDePaginas = numeroDePaginas;
	}
	
}
