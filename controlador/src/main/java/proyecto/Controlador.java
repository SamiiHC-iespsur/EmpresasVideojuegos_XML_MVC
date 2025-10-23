package proyecto;

public class Controlador {
    // Instanciación de Modelo y Vista como atributos del Controlador
    private Modelo modelo;
    private Vista vista;

    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    // Método para iniciar el flujo de la aplicación
    public void iniciar() {
        while (true) { 
            // Lógica para iniciar la aplicación
        }
    }
}