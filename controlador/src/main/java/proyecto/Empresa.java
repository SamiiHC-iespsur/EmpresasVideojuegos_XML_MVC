package proyecto;

import jakarta.xml.bind.annotation.*;
import java.util.*;

@XmlRootElement(name = "empresa")
@XmlType(propOrder = { "nombre", "pais", "fundacion", "juegosDestacados" })
public class Empresa {
    @XmlElement
    private String nombre;
    @XmlElement
    private String pais;
    @XmlElement
    private int fundacion;
    private List <Juego> juegosDestacados;

    public Empresa(String nombre, String pais, int fundacion) {
        this.nombre = nombre;
        this.pais = pais;
        this.fundacion = fundacion;
        this.juegosDestacados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public int getFundacion() {
        return fundacion;
    }
    public void setFundacion(int fundacion) {
        this.fundacion = fundacion;
    }
    @XmlElementWrapper(name = "juegosDestacados")
    @XmlElement(name = "juego")
    public List<Juego> getJuegosDestacados() {
        return juegosDestacados;
    }
}
