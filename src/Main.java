import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

	static Scanner scan = new Scanner(System.in);
	static ArrayList<Contacto> contactos = new ArrayList<Contacto>();
	
	public static void main(String[] args) {
		
		
		int opcion;
		
		do{
            // Mostrar menú
			System.out.println("\n");
            System.out.println("Menú:");
            System.out.println(" 1. Añadir nuevo contacto");
            System.out.println(" 2. Buscar contacto");
            System.out.println(" 3. Eliminar contacto");
            System.out.println(" 4. Ver lista de contactos");
            System.out.println(" 5. Salir");
            System.out.println("Introduzca opción");
            // Leer opción
            opcion = scan.nextInt();
            scan.nextLine(); 
            switch (opcion){
                case 1:
                	aniadirContacto();
                    break;
                case 2:
                	System.out.println("Introduce un nombre");
                	String nombreBuscar = scan.nextLine();
                	buscarContacto(nombreBuscar);
            	
                    break;
                case 3:
                	System.out.println("Introduce un nombre");
                	String borrarContacto = scan.nextLine();
                    eliminarContacto(borrarContacto);
                    break;
                case 4:
                	
                	listarContactos();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opción incorrecta. Elija otra");
            } // Fin switch
        }while(opcion != 6);
		
		
	}
	
	//METO2
	
	/*
	 * 1ª Parte, metodo para añadir contactos a la agenda.
	 * pide los datos y llama a el metodo existeContacto para comprobar si esta duplicado o no.
	 */
	private static void aniadirContacto() {
		System.out.println("Introduce el nombre del contacto");
		String nombre = scan.nextLine();
		
		System.out.println("Introduce un numero de telefono");
		int numTel = scan.nextInt();
		
		if(existeContacto(nombre) == false) {
			Contacto contacto = new Contacto();
			contacto.setNombre(nombre);
			contacto.setTelefono(numTel);
			contactos.add(contacto);
		}else {
			System.out.println("Contacto duplicado imposible crear contacto");
		}
		
	}
	/*
	 * 2ª parte, metodo para comprobar si el contacto existe o no, le pasamos el parametro 
	 * del nombre que hemos pedido en la parte 1 y usando eso comprobamos 
	 * si el atributo nombre de los objetos contacto es igual al que hemos pedido en la primera parte 
	 */
	private static boolean existeContacto(String nombre) {
		
		for(int i = 0; i< contactos.size(); i++) {
			if(contactos.get(i).getNombre().equalsIgnoreCase(nombre)) { // equalsIgnoreCase: si pasamos Asier y asier funciona igual, sino no es el mismo nombre
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
	
	
	/*
	 * Metodo para listar todos los contactos que tenemos guardados en el ArrayList
	 * recorre el arraylist y por cada ojeto hace un toString de los objetos y los imprime
	 */
	public static void listarContactos() {
		
		Iterator it = contactos.iterator();
		while(it.hasNext()) {
			Contacto obj =  (Contacto) it.next();
			System.out.println(obj);
		}
		
	}

	/*
	 * Metodo para buscar un contacto pasandole un nombre
	 */
	public static void buscarContacto (String nombre) {
		
		for (Contacto mostrarContacto: contactos) //Recorre el arraylist y cada contacto por cada vuelta el que toque lo guarda en una variable mostrarContacto 
		{
		   if (mostrarContacto.getNombre().equalsIgnoreCase(nombre)) {	//Compara el nombre del objeto en la variable con el nombre que le pasamos y si son iguales los muestra en pantalla
		           System.out.println(mostrarContacto.toStringTelefono());
		   }	
		}
	}
	
	public static void eliminarContacto(String nombre) {
		
		for(int i= 0; i< contactos.size(); i++) {
			if( contactos.get(i).getNombre().equalsIgnoreCase(nombre)) {
				contactos.remove(i);
				System.out.println("Contacto con el nombre " + nombre + " ha sido eliminado");
			}else if(contactos.isEmpty()) {
				System.out.println("La agenda esta vacia");
			}else {
				System.out.println("El contacto no existe");
			}
		}
		
	}
	
	
	
}
