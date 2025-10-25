package proyecto;

public class Main {
    public static void main(String[] args) throws Exception{
        Modelo mod = new Modelo();
        Vista vis = new Vista();
        Controlador ctrl = new Controlador(mod, vis);

        ctrl.iniciar();
    }
}
