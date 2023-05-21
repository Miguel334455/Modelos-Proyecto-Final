package consulta;

import java.util.List;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import crear_documentos.Articulo;
import crear_documentos.Libro;
import crear_documentos.Ponencias;

public class Consultor {
	
	String consultaString = "";
	
	// Method for searching books
	public Libro buscadorLibro(List<Libro> libreriaGuardada ,String titulo, int numPaginas) {
		
		Libro prLibro = new Libro("", "", null, "", "", 0);
		
		for(int i = 0; i < libreriaGuardada.size(); i++) {
			// Check if the title and number of pages match
			if(titulo == libreriaGuardada.get(i).getTitulo() && numPaginas == libreriaGuardada.get(i).getNumeroDePaginas()) {
				return libreriaGuardada.get(i); // Return the matched book
			}
		}
		
		return prLibro;	// Return a default book if no match is found
	}
		
	// Method for searching conferences
	public Ponencias buscadorPonencias(List<Ponencias> libreriaGuardada ,String titulo,String nombreCongreso) {
		
		Ponencias prPonencias = new Ponencias("", "", null, "", "", "");
		
		for(int i = 0; i <= libreriaGuardada.size(); i++) {
			// Check if the title and conference name match
			if(titulo == libreriaGuardada.get(i).getTitulo() && nombreCongreso == libreriaGuardada.get(i).getNombreCongreso()) {
				return libreriaGuardada.get(i);	// Return the matched conference
			}
			
		}
		return prPonencias;	// Return a default conference if no match is found
	}
	
	// Method for searching articles
	public Articulo buscadorArticulo(List<Articulo> libreriaGuardada, String titulo, String isbn) {
		
		Articulo prArticulo = new Articulo("", "", null, "", "");
		
		for(int i = 0; i <= libreriaGuardada.size(); i++) {
			// Check if the title and ISBN match
			if(titulo == libreriaGuardada.get(i).getTitulo() && isbn == libreriaGuardada.get(i).getIsbn()) {
				return libreriaGuardada.get(i);	// Return the matched article
			}
			
		}
		return prArticulo;	// Return a default article if no match is found
	}
	
}
	
	
	// 
	
	





