package proyecto;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Vista vista = new Vista();
        Empresa empresa1 = vista.nuevaEmpresa();
        vista.mostrarMensaje("Empresa creada:\n" + empresa1.toString());

        Empresa empresa2 = vista.nuevaEmpresa();
        vista.mostrarMensaje("Empresa creada:\n" + empresa2.toString());

        Empresa empresa3 = vista.nuevaEmpresa();
        vista.mostrarMensaje("Empresa creada:\n" + empresa3.toString());

        List<Empresa> empresas = List.of(empresa1, empresa2, empresa3);
        vista.imprimirEmpresas(empresas);
    }
}
