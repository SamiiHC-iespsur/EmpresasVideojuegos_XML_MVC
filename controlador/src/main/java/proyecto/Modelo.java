package proyecto;

import java.io.File;
import java.util.List;

import jakarta.xml.bind.*;

public class Modelo {
    private static final String ruta = "./recursos/empresasvideojuegos.xml";

    public void guardarEmpresa(Empresa e) throws Exception{
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

    public List <Empresa> obtenerEmpresas() throws Exception {
        File f = new File(ruta);

        JAXBContext jc = JAXBContext.newInstance(Empresas.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Empresas empresas = (Empresas) unmarshaller.unmarshal(f);

        return empresas.getListaEmpresas();
    }
}
