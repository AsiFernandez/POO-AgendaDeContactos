
public class Contacto {

	//ATRIBUTOS
	private int telefono;
	private String nombre;
	
	//GETTERS Y SETTERS
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	//CONSTRUCTOR
	public Contacto(){
		
	}
	
	
	//Metodo toString()
	
	public String toString() {
		return "Contacto: "+ this.getNombre() + " --> " +  this.getTelefono();
		
	}
	
	public String toStringTelefono() {
		return "Numero de telefono: " +  this.getTelefono();
		
	}
}
