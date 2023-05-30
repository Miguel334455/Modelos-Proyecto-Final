package crear_documentos;

import consulta.Consultor;
import Historial.*;
import java.util.ArrayList;
import java.util.List;

public class Probador {
    public static void main(String[] args) {
        // Crear documentos y autores
        Autores autor1 = new Autores("autor1@gmail.com", "Dirección 1", "123456789");
        Autores autor2 = new Autores("autor2@gmail.com", "Dirección 2", "987654321");

        Articulo documento1 = new Articulo("Título artículo", "2023-05-26", autor1, "ISBN-123456", "Editorial A");
        Libro documento2 = new Libro("Título libro", "2023-05-26", autor2, "ISBN-789456", "Editorial B", 200);
        Ponencias documento3 = new Ponencias("Título ponencia", "2023-05-26", autor1, "ISBN-654321", "Editorial C", "Congreso X");

        // Crear librería de documentos
        LibreriaDocumentos libreria = new LibreriaDocumentos();

        // Registrar observadores
        RegistroAcciones registroAcciones = RegistroAcciones.obtenerInstancia();
        libreria.registrarObservador(registroAcciones);
        Consultor consulta = new Consultor();

        // Realizar acciones de usuario
        Usuario usuario1 = new Usuario("Usuario1", "usuario1@gmail.com");

        AccionUsuario accion1 = new AccionUsuario(TipoAccion.CREACION, documento1, usuario1);
        libreria.realizarAccionUsuario(accion1);

        AccionUsuario accion2 = new AccionUsuario(TipoAccion.MODIFICACION, documento2, usuario1);
        libreria.realizarAccionUsuario(accion2);

        AccionUsuario accion3 = new AccionUsuario(TipoAccion.ELIMINACION, documento3, usuario1);
        libreria.realizarAccionUsuario(accion3);

        // Ejemplo de uso de la lista de libros guardados
        List<Libro> librosGuardados = new ArrayList<>();
        librosGuardados.add((Libro) documento2);  // Agregar el libro documento2 a la lista de libros guardados

        System.out.print(consulta.buscadorLibro(librosGuardados, "tomsito", 300).getEditorial());
		
		consulta.buscadorLibro(librosGuardados, "tomsito", 300).setNumeroDePaginas(250);
		
		System.out.print(consulta.buscadorLibro(librosGuardados, "tomsito", 250).getNumeroDePaginas());
		
    }
}
