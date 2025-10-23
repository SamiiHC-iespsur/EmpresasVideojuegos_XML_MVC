package proyecto;

// Importaciones de utilidades
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

// Anotaciones JAXB para definir el elemento raíz y el orden de los elementos hijos
@XmlRootElement(name = "empresa")
@XmlType(propOrder = { "nombre", "pais", "fundacion", "juegosDestacados" })
public class Empresa {
    // Atributos de la clase Empresa
    private String nombre;
    private String pais;
    private int fundacion;
    private List <String> juegosDestacados = new ArrayList<>();

    // Constructor con todos los atributos
    public Empresa(String nombre, String pais, int fundacion, List<String> juegosDestacados) {
        this.nombre = nombre;
        this.pais = pais;
        this.fundacion = fundacion;
        this.juegosDestacados = juegosDestacados;
    }

    // Constructor sin atributos (sobrecarga)
    public Empresa() {}

    // Getters y Setters con sus anotaciones JAXB correspondientes
    @XmlElement(name = "nombre")
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @XmlElement(name = "pais")
    public String getPais() {
        return pais;
    }
    
    public void setPais(String pais) {
        this.pais = pais;
    }
    
    @XmlElement(name = "fundacion")
    public int getFundacion() {
        return fundacion;
    }
    
    public void setFundacion(int fundacion) {
        this.fundacion = fundacion;
    }
    
    @XmlElementWrapper(name = "juegosDestacados")
    @XmlElement(name = "juego")
    public List<String> getJuegosDestacados() {
        return juegosDestacados;
    }
    
    public void setJuegosDestacados(List<String> juegosDestacados) {
        this.juegosDestacados = juegosDestacados;
    }

    // Método toString para mostrar la información de la empresa con formato legible
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(nombre).append("; ");
        sb.append("País: ").append(pais).append("; ");
        sb.append("Año de fundación: ").append(fundacion).append("; ");
        sb.append("Juegos destacados: ").append(String.join(", ", juegosDestacados)).append(".");
        return sb.toString();
    }
}
