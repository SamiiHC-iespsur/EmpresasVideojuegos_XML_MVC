package proyecto;

import java.util.List;

public class Controlador {
    // Instanciación de Modelo y Vista como atributos del Controlador
    private Modelo modelo;
    private Vista vista;

    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    // Método para iniciar el flujo de la aplicación
    public void iniciar() throws Exception{
        while (true) { 
            // Lógica para iniciar la aplicación
            
            List <Empresa> empresas = modelo.obtenerEmpresas();
            vista.imprimirEmpresas(empresas);

            Empresa nuevaEmpresa = vista.nuevaEmpresa();
            modelo.guardarEmpresa(nuevaEmpresa);
            vista.mostrarMensaje("Empresa agregada exitosamente.");

            empresas =  modelo.obtenerEmpresas();
            vista.imprimirEmpresas(empresas);
        }
    }
}
