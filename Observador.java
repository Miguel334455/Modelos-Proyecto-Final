package Historial;

public interface Observador {
    void actualizar(AccionUsuario accion);
    void registrarAccion(AccionUsuario accion);
}
