package proyecto;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;

public class Vista {

	private final String ruta;

	public Vista() {
		this.ruta = "./empresasvideojuegos.xml";
	}

	public Vista(String rutaRuta) {
		this.ruta = rutaRuta;
	}

	public List<Empresa> cargarEmpresas() throws Exception {
		if (ruta.isEmpty() || !ruta.endsWith(".xml")) {
            throw new IllegalArgumentException("Ruta no válida.");
        } else {
            File f = new File(ruta);
			JAXBContext jc = JAXBContext.newInstance(Empresas.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			Empresas empresas = (Empresas) unmarshaller.unmarshal(f);
			return empresas.getListaEmpresas();
        }
	}

	public String generarListaNombres() throws Exception { 
		List<Empresa> lista = cargarEmpresas();
		return lista.stream()
				.map(Empresa::getNombre)
				.collect(Collectors.joining(System.lineSeparator()));
	}

	public Empresa encontrarEmpresaPorNombre(String nombre) throws Exception {
		return cargarEmpresas().stream()
				.filter(e -> e.getNombre() != null && e.getNombre().equals(nombre))
				.findFirst().orElse(null);
	}

	public String generarVistaEmpresa(Empresa e) {
		if (e == null) return "Empresa no encontrada";
		StringBuilder sb = new StringBuilder();
		sb.append("Nombre: ").append(e.getNombre()).append(System.lineSeparator());
		sb.append("País: ").append(e.getPais()).append(System.lineSeparator());
		sb.append("Fundación: ").append(e.getFundacion()).append(System.lineSeparator());
		sb.append("Juegos destacados: ");
		if (e.getJuegosDestacados() != null && !e.getJuegosDestacados().isEmpty()) {
			sb.append(String.join(", ", e.getJuegosDestacados()));
		} else {
			sb.append("(ninguno)");
		}
		return sb.toString();
	}

	public List<Empresa> filtrarPorPais(String pais) throws Exception {
		return cargarEmpresas().stream()
				.filter(e -> e.getPais() != null && e.getPais().equalsIgnoreCase(pais))
				.collect(Collectors.toList());
	}
}
