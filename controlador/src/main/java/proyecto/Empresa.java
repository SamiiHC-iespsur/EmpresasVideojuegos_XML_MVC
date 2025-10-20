package proyecto;

import jakarta.xml.bind.annotation.*;
import java.util.*;

@XmlRootElement(name = "empresa")
@XmlType(propOrder = { "nombre", "pais", "fundacion", "juegosDestacados" })
public class Empresa {
    private String nombre;
    private String pais;
    private int fundacion;
    private List <String> juegosDestacados = new ArrayList<>();

    public Empresa(String nombre, String pais, int fundacion, List<String> juegosDestacados) {
        this.nombre = nombre;
        this.pais = pais;
        this.fundacion = fundacion;
        this.juegosDestacados = juegosDestacados;
    }

    public Empresa() {
    }

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
}
