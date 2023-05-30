package crear_documentos;

public class Autores {
	
	private String correo;
	private String direccion;
	private String numtel;
	
	// Constructor for the Autores class
	public Autores(String correo, String direccion, String numtel){
		this.correo = correo;
		this.direccion = direccion;
		this.numtel = numtel;
	}
	
	// Getter for the correo field
	public String getCorreo() {
		return correo;
	}
	
	// Setter for the correo field
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	// Getter for the direccion field
	public String getDireccion() {
		return direccion;
	}
	
	// Setter for the direccion field
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	// Getter for the numtel field
	public String getNumtel() {
		return numtel;
	}
	
	// Setter for the numtel field
	public void setNumtel(String numtel) {
		this.numtel = numtel;
	}
	
}
