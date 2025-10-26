package proyecto;

// Importaciones necesarias para lanzamiento de excepciones
import java.io.IOException;

import jakarta.xml.bind.JAXBException;

public class Main {
    public static void main(String[] args) throws IOException, JAXBException {
        Modelo mod = new Modelo();
        Vista vis = new Vista();
        Controlador ctrl = new Controlador(mod, vis);

        ctrl.iniciar();
    }
}
