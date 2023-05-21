package crear_documentos;

import java.io.ObjectInputStream.GetField;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import consulta.Consultor;

public class Probador {
	
	public static void main(String args[]) {
		
		Consultor consulta = new Consultor();


		Autores autor1 = new Autores("correoreal@ud.com", "caereal23", "1");
		Autores autor2 = new Autores("coreal@ud.com", "clereal23", "2");
		Autores autor3 = new Autores("eal@ud.com", "caler23", "3");
		Autores autor4 = new Autores("oreal@ud.com", "leeal23", "4");
		Autores autor5 = new Autores("xdddd@axdd.com", "lezx23", "5");
		
		List<Autores> autoresPrueba = new ArrayList<>();
		List<Libro> librosGuardados = new ArrayList<>();
		
		autoresPrueba.add(autor1);
		autoresPrueba.add(autor2);
		autoresPrueba.add(autor3);
		autoresPrueba.add(autor4);
		
		Libro libro1 = new Libro("tomsito", "21/9/2000", autoresPrueba, "545454", "San Pablito", 300);
		
		libro1.autoresList.add(autor5);
		
		librosGuardados.add(libro1);
		
		System.out.print(consulta.buscadorLibro(librosGuardados, "tomsito", 300).getEditorial());
		
		consulta.buscadorLibro(librosGuardados, "tomsito", 300).setNumeroDePaginas(250);
		
		System.out.print(consulta.buscadorLibro(librosGuardados, "tomsito", 250).getNumeroDePaginas());
		
		
		
	}

}
