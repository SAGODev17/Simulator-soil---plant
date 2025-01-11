package Reglas;
public class ParametroNS {
	public Nutriente nutriente;
	public Suelo suelo;
	public float velocidadPrecipitacion;
	
	public ParametroNS(Nutriente pNutriente, Suelo pSuelo) {
		this.nutriente = pNutriente;
		this.suelo = pSuelo;
		this.velocidadPrecipitacion = 0;
	}

}


