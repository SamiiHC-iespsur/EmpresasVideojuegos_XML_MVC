package proyecto;

// Importaciones de utilidades y JAXB
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import jakarta.xml.bind.JAXBException;

public class Controlador {
    // Instanciación de Modelo y Vista como atributos del Controlador
    private final Modelo modelo;
    private final Vista vista;
    private final Scanner sc;

    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.sc = new Scanner(System.in);
    }

    // Método para iniciar el flujo de la aplicación
    public void iniciar() throws IOException, JAXBException{
        System.out.println("\n=== Menú de Gestión de Empresas de Videojuegos ===");
        while (true) {
            System.out.println("\n1. Mostrar todas las empresas");
            System.out.println("2. Buscar empresas");
            System.out.println("3. Agregar una nueva empresa");
            System.out.println("4. Borrar una empresa");
            System.out.println("5. Modificar una empresa");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = sc.nextInt();
            System.out.println();
            sc.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1 -> {
                    List<Empresa> empresas = modelo.obtenerEmpresas();
                    vista.imprimirEmpresas(empresas);
                }
                case 2 -> {
                    System.out.println("A. Buscar por nombre");
                    System.out.println("B. Buscar por país");
                    System.out.println("C. Buscar por año de fundación");
                    System.out.println("D. Buscar por fundación anterior a un año");
                    System.out.println("E. Buscar por fundación posterior a un año");
                    System.out.println("F. Buscar por juego destacado");
                    System.out.print("Seleccione una opción de búsqueda: ");

                    String opcionBusqueda = sc.nextLine();
                    System.out.println();
                    
                    switch (opcionBusqueda) {
                        case "A" -> {
                            System.out.print("Ingrese el nombre a buscar: ");
                            vista.imprimirEmpresasPorNombre(modelo.obtenerEmpresas(), sc.nextLine());
                        }
                        case "B" -> {
                            System.out.print("Ingrese el país a buscar: ");
                            vista.imprimirEmpresasPorPais(modelo.obtenerEmpresas(), sc.nextLine());
                        }
                        case "C" -> {
                            System.out.print("Ingrese el año de fundación a buscar: ");
                            vista.imprimirEmpresasPorAnio(modelo.obtenerEmpresas(), sc.nextInt());
                        }
                        case "D" -> {
                            System.out.print("Ingrese el año límite: ");
                            vista.imprimirEmpresasFundacionAnterior(modelo.obtenerEmpresas(), sc.nextInt());
                        }
                        case "E" -> {
                            System.out.print("Ingrese el año límite: ");
                            vista.imprimirEmpresasFundacionPosterior(modelo.obtenerEmpresas(), sc.nextInt());
                        }
                        case "F" -> {
                            System.out.print("Ingrese el juego destacado a buscar: ");
                            vista.imprimirEmpresasPorJuegoDestacado(modelo.obtenerEmpresas(), sc.nextLine());
                        }
                        default -> System.out.println("Opción de búsqueda no válida. Por favor, intenténtalo de nuevo.");
                    }
                }
                case 3 -> {
                    Empresa nuevaEmpresa = vista.nuevaEmpresa();
                    modelo.guardarEmpresa(nuevaEmpresa);
                    vista.mostrarMensaje("Empresa agregada exitosamente.");
                }
                case 4 -> {
                    List<Empresa> empresasParaBorrar = modelo.obtenerEmpresas();
                    Empresa empresaABorrar = vista.borrarEmpresa(empresasParaBorrar);
                    if (empresaABorrar != null) {
                        boolean borrado = modelo.borrarEmpresa(empresaABorrar.getNombre());
                        if (borrado) {
                            vista.mostrarMensaje("Empresa borrada exitosamente.");
                        } else {
                            vista.mostrarMensaje("No se encontró la empresa para borrar.");
                        }
                    } else {
                        vista.mostrarMensaje("No se encontró la empresa para borrar.");
                    }
                }
                case 5 -> {
                    List<Empresa> empresasParaModificar = modelo.obtenerEmpresas();
                    Empresa empresaAModificar = vista.modificarEmpresa(empresasParaModificar);
                    if (empresaAModificar != null ) {
                        boolean modificado = modelo.editarEmpresa(empresaAModificar.getNombrePredecesor(), empresaAModificar);
                        if (modificado) {
                            vista.mostrarMensaje("Empresa modificada exitosamente.");
                        } else {
                            vista.mostrarMensaje("No se encontró la empresa para modificar.");
                        }
                    } else {
                        vista.mostrarMensaje("No se encontró la empresa para modificar.");
                    }
                }
                case 6 -> {
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    return;
                }
                default -> System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }
}
