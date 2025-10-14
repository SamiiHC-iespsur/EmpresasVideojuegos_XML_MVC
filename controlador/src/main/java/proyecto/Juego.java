package proyecto;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "juego")
public class Juego {
    @XmlElement
    private String nombre;

    public Juego(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
