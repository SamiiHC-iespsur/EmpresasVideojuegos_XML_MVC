package proyecto;

// Importaciones necesarias para lanzamiento de excepciones
import java.io.IOException;

import jakarta.xml.bind.JAXBException;

public class Main {
    public static void main(String[] args) throws IOException, JAXBException {
        // Instanciación de Modelo, Vista y Controlador
        Modelo mod = new Modelo();
        Vista vis = new Vista();
        Controlador ctrl = new Controlador(mod, vis);

        // Inicio del flujo de la aplicación
        ctrl.iniciar();
    }
}
