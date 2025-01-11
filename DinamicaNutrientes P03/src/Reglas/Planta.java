package Reglas;

public class Planta {
	public String nombre;
	public ParametroNP[] parametros;
	public ContenidoNP[] contenido;
	
	public Planta() {
		this.nombre = "";
		this.parametros = null;
		this.contenido = null;
	}
	
	public Planta(int pCantidadNutrientes) {
		this.nombre = "";
		this.parametros = new ParametroNP[pCantidadNutrientes];
		this.contenido = new ContenidoNP[pCantidadNutrientes];
	}
	
}


