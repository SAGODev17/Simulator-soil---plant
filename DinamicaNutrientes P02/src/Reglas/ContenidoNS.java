package Reglas;

public class ContenidoNS {
	public Nutriente nutriente;
	public Suelo suelo;
	public float enSolucion;
	public float precipitado;
	
	public ContenidoNS(Nutriente pNutriente, Suelo pSuelo) {
		this.nutriente = pNutriente;
		this.suelo = pSuelo;
		this.enSolucion = 0;
		this.precipitado = 0;
	}
	
	public boolean enSolucion() {
		return (this.enSolucion > 0);
	}
	
}
