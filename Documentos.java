package crear_documentos;

import java.time.LocalDate;

abstract class Documentos {
	
	protected String titulo;
	protected String fechaDePublicacion;
	protected Autores autor;
	protected String isbn;
	protected String editorial;
	private LocalDate fechaRetiro;
    private LocalDate fechaDevolucion;
	private boolean enReserva = true;
	private boolean dadoDeBaja;
	
	// Constructor for the Documentos class
	public Documentos(String titulo, String fechaDePublicacion, Autores autor, String isbn, String editorial) {
		this.titulo = titulo;
		this.fechaDePublicacion = fechaDePublicacion;
		this.autor = autor;
		this.isbn = isbn;
		this.editorial = editorial;
	}
	
	// Getter and Setter for the titulo field
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	// Getter and Setter for the fechaDePublicacion field
	public String getFechaDePublicacion() {
		return fechaDePublicacion;
	}
	
	public void setFechaDePublicacion(String fechaDePublicacion) {
		this.fechaDePublicacion = fechaDePublicacion;
	}
	
	// Getters and Setters for the Autor field
	
	public Autores getAutor() {
		return autor;
	}

	public void setAutor(Autores autor) {
		this.autor = autor;
	}

	// Getter and Setter for the isbn field
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	// Getter and Setter for the editorial field
	public String getEditorial() {
		return editorial;
	}
	
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	
	public void reservarDocumento(LocalDate fechaRetiro, LocalDate fechaDevolucion) {
        this.fechaRetiro = fechaRetiro;
        this.fechaDevolucion = fechaDevolucion;
        this.enReserva = true;
    }

	public void darDeBajaTemporalmente() {
        this.dadoDeBaja = true;
        this.enReserva = false;
    }

	public void darDeAlta() {
        this.dadoDeBaja = false;
    }
	
}