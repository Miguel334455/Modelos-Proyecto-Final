package Historial;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class RegistroAcciones implements Observador {
    private static RegistroAcciones instancia = new RegistroAcciones();
    private List<AccionUsuario> accionesRegistradas = new ArrayList<>();
    
    private RegistroAcciones() {
        // Constructor privado para garantizar que solo haya una instancia
    }
    
    public static RegistroAcciones obtenerInstancia() {
        return instancia;
    }
    
    public void actualizar(AccionUsuario accion) {
        // Registrar la acción realizada por el usuario en el registro de acciones
        registrarAccion(accion);
    }
    
    public void registrarAccion(AccionUsuario accion) {
        accion.setFechaHora(new Date()); // Establecer la fecha y hora actual en la acción
        accionesRegistradas.add(accion);
        // Otras operaciones de registro, como almacenar en una base de datos o archivo
    }
    
    // Otros métodos de la clase RegistroAcciones
}