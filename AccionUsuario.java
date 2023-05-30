package Historial;

import java.util.Date;

import crear_documentos.Articulo;
import crear_documentos.Libro;
import crear_documentos.Ponencias;

public class AccionUsuario {
    private TipoAccion tipo;
    private Articulo articulo;
    private Libro libro;
    private Ponencias ponencia;
    private Usuario usuario;
    private Date fechaHora;
    
    // Constructor, getters y setters
    
    public AccionUsuario(TipoAccion tipo, Articulo documento1, Usuario usuario) {
        this.tipo = tipo;
        this.articulo = documento1;
        this.usuario = usuario;
    }
    
    public AccionUsuario(TipoAccion tipo, Libro documento1, Usuario usuario) {
        this.tipo = tipo;
        this.libro = documento1;
        this.usuario = usuario;
    }

    public AccionUsuario(TipoAccion tipo, Ponencias documento1, Usuario usuario) {
        this.tipo = tipo;
        this.ponencia = documento1;
        this.usuario = usuario;
    }

    public TipoAccion getTipo() {
        return tipo;
    }
    
    public void setTipo(TipoAccion tipo) {
        this.tipo = tipo;
    }
    
    public Articulo getArticulo() {
        return articulo;
    }
    
    public void setArticulo(Articulo documento) {
        this.articulo = documento;
    }

    public Libro getLibro() {
        return libro;
    }
    
    public void setLibro(Libro documento) {
        this.libro = documento;
    }

    public Ponencias getPonencia() {
        return ponencia;
    }
    
    public void setPonencias(Ponencias documento) {
        this.ponencia = documento;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }
}