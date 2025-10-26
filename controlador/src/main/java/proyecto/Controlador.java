package proyecto;

// Importaciones de utilidades y JAXB
import java.io.IOException;
import java.util.List;

import jakarta.xml.bind.JAXBException;

public class Controlador {
    // Instanciación de Modelo y Vista como atributos del Controlador
    private final Modelo modelo;
    private final Vista vista;

    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    // Método para iniciar el flujo de la aplicación
    public void iniciar() throws IOException, JAXBException{
        while (true) { 
            // Mostrar la lista de empresas actuales
            List <Empresa> empresas = modelo.obtenerEmpresas();
            vista.imprimirEmpresas(empresas);

            // Pedir al usuario que ingrese una nueva empresa
            Empresa nuevaEmpresa = vista.nuevaEmpresa();
            modelo.guardarEmpresa(nuevaEmpresa);
            vista.mostrarMensaje("Empresa agregada exitosamente.");
        }
    }
}
