package proyecto;

import java.util.*;

public class Empresa {
    private String nombre;
    private String pais;
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
    public List<Juego> getJuegosDestacados() {
        return juegosDestacados;
    }
}
