package Reglas;

public class Suelo {
	public String nombre;
	public ParametroNS[] parametros;
	public ContenidoNS[] contenido;
	
	public Suelo() {
		this.nombre = "";
		this.parametros = null;
		this.contenido = null;
	}
	
	public Suelo(int pCantidadNutrientes) {
		this.nombre = "";
		this.parametros = new ParametroNS[pCantidadNutrientes];
		this.contenido = new ContenidoNS[pCantidadNutrientes];
	}
	
	public boolean enSolucion() {
		boolean rEnSolucion;
		int i;
		rEnSolucion = false;
		for (i=0; i<contenido.length; i++) {
			rEnSolucion = rEnSolucion || contenido[i].enSolucion();
		}
		return rEnSolucion;
	}
	
}
