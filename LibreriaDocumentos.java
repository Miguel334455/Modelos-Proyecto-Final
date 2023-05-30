package crear_documentos;

import java.util.ArrayList;
import java.util.List;
import Historial.*;

public class LibreriaDocumentos {
    private List<Observador> observadores = new ArrayList<>();
    
    public void registrarObservador(Observador observador) {
        observadores.add(observador);
    }
    
    public void eliminarObservador(Observador observador) {
        observadores.remove(observador);
    }
    
    public void notificarObservadores(AccionUsuario accion) {
        for (Observador observador : observadores) {
            observador.actualizar(accion);
        }
    }
    
    public void realizarAccionUsuario(AccionUsuario accion) {
        // Realizar la acción del usuario sobre el documento
        
        // Notificar a los observadores de la acción realizada
        notificarObservadores(accion);
    }
}
