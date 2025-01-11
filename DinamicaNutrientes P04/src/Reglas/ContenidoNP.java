package Reglas;
public class ContenidoNP {
	public Nutriente nutriente;
	public Planta planta;
	public float absorcion;
	public float enBiomasa;
	
	public ContenidoNP(Nutriente pNutriente, Planta pPlanta) {
		this.nutriente = pNutriente;
		this.planta = pPlanta;
		this.absorcion = 0;
		this.enBiomasa = 0;
	}
	
}
