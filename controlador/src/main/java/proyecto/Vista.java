package proyecto;

// Importaciones de utilidades
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Vista {
    // Declaración e inicialización de Scanner para entrada de datos
    private final Scanner sc;
    
    public Vista() {
        this.sc = new Scanner(System.in);
    }
    
    // Método para mostrar la lista de todas las empresas, con sus respectivos atributos
    public void imprimirEmpresas(List<Empresa> empresas) {
        System.out.println("\nLista de empresas:");
        for (Empresa empresa : empresas) {
            System.out.println(empresa.toString());
        }
        System.out.println();
    }
    
    // Método para sacar mensajes por pantalla para el usuario
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
    
    // Método de petición de entrada de datos de atributos para añadir una nueva Empresa
    public Empresa nuevaEmpresa() {
        System.out.println("\nAgregar una nueva empresa:");
        
        System.out.print("Nombre: ");
        String nombre = sc.nextLine().trim();
        
        System.out.print("País: ");
        String pais = sc.nextLine().trim();
        
        System.out.print("Año de fundación: ");
        int fundacion = Integer.parseInt(sc.nextLine().trim());
        
        // Al ser una lista, se usa un bucle para permitir múltiples entradas
        List<String> juegosDestacados = new ArrayList<>();
        String juegoDestacado;
        while (true) {
            System.out.print("Juego destacado (dejar en blanco para terminar): ");
            juegoDestacado = sc.nextLine().trim();
            if (juegoDestacado.isBlank() || juegoDestacado.isEmpty()) {
                break;
            } else {
                juegosDestacados.add(juegoDestacado);
            }
        }
        
        return new Empresa(nombre, pais, fundacion, juegosDestacados);
    }
}