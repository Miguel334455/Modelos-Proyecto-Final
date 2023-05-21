package crear_documentos;

import java.util.ArrayList;
import java.util.List;

abstract class Documentos {
	
	protected String titulo;
	protected String fechaDePublicacion;
	protected List<Autores> autoresList;
	protected String isbn;
	protected String editorial;
	protected boolean enLibreria = true;
	
	// Constructor for the Documentos class
	public Documentos(String titulo, String fechaDePublicacion, List<Autores> autoreslist, String isbn, String editorial) {
		this.titulo = titulo;
		this.fechaDePublicacion = fechaDePublicacion;
		this.autoresList = autoreslist;
		this.isbn = isbn;
		this.editorial = editorial;		
	}
	
	// Getter and Setter for the enLibreria field
	public boolean isEnLibreria() {
		return enLibreria;
	}
	
	public void setEnLibreria(boolean enLibreria) {
		this.enLibreria = enLibreria;
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
	
	// Getter and Setter for the autoresList field
	public List<Autores> getAutoresList() {
		return autoresList;
	}
	
	public void setAutoresList(List<Autores> autoresList) {
		this.autoresList = autoresList;
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
	
}