package proyecto;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "empresas")
public class Empresas {
    
    @XmlTransient
    public List <Empresa> listaEmpresas = new ArrayList<>();

    public Empresas() {
    }

    public Empresas(List<Empresa> listaEmpresas) {
        this.listaEmpresas = listaEmpresas;
    }
    
    @XmlElement(name = "empresa")
    public List<Empresa> getListaEmpresas() {
        return listaEmpresas;
    }

    public void setListaEmpresas(List<Empresa> listaEmpresas) {
        this.listaEmpresas = listaEmpresas;
    }
}
