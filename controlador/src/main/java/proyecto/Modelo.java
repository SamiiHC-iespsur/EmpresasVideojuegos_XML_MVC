package proyecto;

// Importaciones de utilidades y JAXB
import java.io.File;
import java.io.IOException;
import java.util.List;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class Modelo {
    // Ruta al archivo XML de empresas construida de forma independiente del sistema operativo
    private final String ruta = "controlador" + File.separator
                              + "src" + File.separator
                              + "main" + File.separator
                              + "java" + File.separator
                              + "proyecto" + File.separator
                              + "recursos" + File.separator
                              + "empresasvideojuegos.xml";

    // Método para guardar una nueva empresa en el archivo XML
    public void guardarEmpresa(Empresa e) throws IOException, JAXBException{
        File f = new File(ruta);

        JAXBContext jc = JAXBContext.newInstance(Empresas.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Empresas empresas = (Empresas) unmarshaller.unmarshal(f);

        List<Empresa> listaEmpresas = empresas.getListaEmpresas();

        listaEmpresas.add(new Empresa(e.getNombre(), e.getPais(), e.getFundacion(), e.getJuegosDestacados()));

        empresas.setListaEmpresas(listaEmpresas);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        marshaller.marshal(empresas, f);
    }

    // Método para obtener la lista de empresas desde el archivo XML
    public List <Empresa> obtenerEmpresas() throws IOException, JAXBException {
        File f = new File(ruta);

        JAXBContext jc = JAXBContext.newInstance(Empresas.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Empresas empresas = (Empresas) unmarshaller.unmarshal(f);

        return empresas.getListaEmpresas();
    }
}
