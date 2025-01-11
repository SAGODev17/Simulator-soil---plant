package Reglas;
public class ParametroNP {
	public Nutriente nutriente;
	public Planta planta;
	public float velocidadAbsorcion;
	
	public ParametroNP(Nutriente pNutriente, Planta pPlanta) {
		this.nutriente = pNutriente;
		this.planta = pPlanta;
		this.velocidadAbsorcion = 0;
	}
	
}
