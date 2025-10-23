package proyecto;

// Importaciones de utilidades y JAXB
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

// Clase contenedora para la lista de empresas, necesaria para JAXB
@XmlRootElement(name = "empresas")
public class Empresas {
    
    @XmlTransient
    public List <Empresa> listaEmpresas = new ArrayList<>();

    // Constructor por defecto
    public Empresas() {
    }

    // Constructor con Lista de Empresas por parámetro (sobrecarga)
    public Empresas(List<Empresa> listaEmpresas) {
        this.listaEmpresas = listaEmpresas;
    }
    
    // Getters y Setters
    @XmlElement(name = "empresa")
    public List<Empresa> getListaEmpresas() {
        return listaEmpresas;
    }

    public void setListaEmpresas(List<Empresa> listaEmpresas) {
        this.listaEmpresas = listaEmpresas;
    }
}
