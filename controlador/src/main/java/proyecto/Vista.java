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
        System.out.println("Lista de empresas:");
        for (Empresa empresa : empresas) {
            System.out.println(empresa.toString());
        }
    }

    // Método para imprimir empresas por nombre
    public void imprimirEmpresasPorNombre(List<Empresa> empresas, String nombre) {
        System.out.println("Lista de empresas filtradas por nombre:");
        for (Empresa empresa : empresas) {
            if (empresa.getNombre().toLowerCase().contains(nombre.trim().toLowerCase())) {
                System.out.println(empresa.toString());
            }
        }
    }

    // Método para imprimir empresas por país
    public void imprimirEmpresasPorPais(List<Empresa> empresas, String pais) {
        System.out.println("Lista de empresas filtradas por país:");
        for (Empresa empresa : empresas) {
            if (empresa.getPais().equalsIgnoreCase(pais)) {
                System.out.println(empresa.toString());
            }
        }
    }

    // Método para imprimir empresas por año de fundación
    public void imprimirEmpresasPorAnio(List<Empresa> empresas, int anio) {
        System.out.println("Lista de empresas filtradas por año de fundación:");
        for (Empresa empresa : empresas) {
            if (empresa.getFundacion() == anio) {
                System.out.println(empresa.toString());
            }
        }
    }

    // Método para imprimir empresas de fundación anterior a un año dado
    public void imprimirEmpresasFundacionAnterior(List<Empresa> empresas, int anio) {
        System.out.println("Lista de empresas fundadas antes de " + anio + ":");
        for (Empresa empresa : empresas) {
            if (empresa.getFundacion() < anio) {
                System.out.println(empresa.toString());
            }
        }
    }

    // Método para imprimir empresas de fundación posterior a un año dado
    public void imprimirEmpresasFundacionPosterior(List<Empresa> empresas, int anio) {
        System.out.println("Lista de empresas fundadas después de " + anio + ":");
        for (Empresa empresa : empresas) {
            if (empresa.getFundacion() > anio) {
                System.out.println(empresa.toString());
            }
        }
    }

    // Método para imprimir empresas por juego destacado
    public void imprimirEmpresasPorJuegoDestacado(List<Empresa> empresas, String juego) {
        System.out.println("Lista de empresas que tienen el juego destacado '" + juego + "':");
        for (Empresa empresa : empresas) {
            for (String juegoDestacado : empresa.getJuegosDestacados()) {
                if (juegoDestacado.toLowerCase().contains(juego.toLowerCase())) {
                    System.out.println(empresa.toString());
                    break; // Evitar imprimir la misma empresa múltiples veces
                }
            }
        }
    }

    // Método para sacar mensajes por pantalla para el usuario
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    // Método de creación de una nueva empresa
    public Empresa nuevaEmpresa() {
        System.out.println("Agregar una nueva empresa:");
        
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
                if (juegosDestacados.isEmpty()) {
                    System.out.println("Debes ingresar al menos un juego destacado.");
                } else {
                    break;
                }
            } else {
                juegosDestacados.add(juegoDestacado);
            }
        }
        
        return new Empresa(nombre, pais, fundacion, juegosDestacados);
    }

    // Método para borrar una empresa (por nombre)
    public Empresa borrarEmpresa(List<Empresa> empresas) {
        System.out.print("Ingrese el nombre de la empresa a borrar: ");
        String nombre = sc.nextLine().trim();
        for (Empresa empresa : empresas) {
            if (empresa.getNombre().equalsIgnoreCase(nombre)) {
                return empresa;
            }
        }
        System.err.println("Empresa no encontrada.");
        return null;
    }

    // Método para modificar una empresa (por nombre)
    public Empresa modificarEmpresa(List<Empresa> empresas) {
        System.out.print("Ingrese el nombre de la empresa a modificar: ");
        String nombre = sc.nextLine().trim();
        for (Empresa empresa : empresas) {
            if (empresa.getNombre().equalsIgnoreCase(nombre)) {
                System.out.print("Nuevo nombre: ");
                String nuevoNombre = sc.nextLine().trim();
                
                System.out.print("Nuevo país: ");
                String nuevoPais = sc.nextLine().trim();

                System.out.print("Nuevo año de fundación: ");
                String nuevoAnioAux = sc.nextLine().trim();
                int nuevoAnio = 0;
                if (!nuevoAnioAux.isBlank() && !nuevoAnioAux.isEmpty()) {
                    nuevoAnio = Integer.parseInt(nuevoAnioAux);
                }
                // Al ser una lista, se usa un bucle para permitir múltiples entradas
                List<String> nuevosJuegosDestacados = new ArrayList<>();
                String nuevoJuegoDestacado;
                while (true) {
                    System.out.print("Nuevo juego destacado (dejar en blanco para terminar): ");
                    nuevoJuegoDestacado = sc.nextLine().trim();
                    if (nuevoJuegoDestacado.isBlank() || nuevoJuegoDestacado.isEmpty()) {
                        break;
                    } else {
                        nuevosJuegosDestacados.add(nuevoJuegoDestacado);
                    }
                }
                return new Empresa(nombre, nuevoNombre, nuevoPais, nuevoAnio, nuevosJuegosDestacados);
            }
        }
        System.err.println("Empresa no encontrada.");
        return null;
    }
}