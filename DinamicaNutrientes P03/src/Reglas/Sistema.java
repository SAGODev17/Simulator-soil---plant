package Reglas;

public class Sistema {
	public Planta planta;
	public Suelo suelo;
	public Nutriente[] nutrientes;
	
	public Sistema(Planta pPlanta, Suelo pSuelo, Nutriente[] pNutrientes) {
		this.planta = pPlanta;
		this.suelo = pSuelo;
		this.nutrientes = pNutrientes;
	}
	
	public float cantidadAbsorcion(int pIndice) {
		float rCantidadAbsorcion;
		rCantidadAbsorcion = Math.min(this.suelo.contenido[pIndice].enSolucion, this.planta.parametros[pIndice].velocidadAbsorcion);
		return rCantidadAbsorcion;
	}

	public float cantidadPrecipitacion(int pIndice) {
		float rCantidadPrecipitacion;
		rCantidadPrecipitacion = Math.min(this.suelo.contenido[pIndice].enSolucion, this.suelo.parametros[pIndice].velocidadPrecipitacion);
		return rCantidadPrecipitacion;
	}
	
	public void absorcion(int pIndice) {
		float cantidadAbsorcion;
		cantidadAbsorcion = this.cantidadAbsorcion(pIndice);
		this.suelo.contenido[pIndice].enSolucion = this.suelo.contenido[pIndice].enSolucion - cantidadAbsorcion;
		this.planta.contenido[pIndice].enBiomasa = this.planta.contenido[pIndice].enBiomasa + cantidadAbsorcion;
	}
	
	public void precipitacion(int pIndice) {
		float cantidadPrecipitacion;
		cantidadPrecipitacion = this.cantidadPrecipitacion(pIndice);
		this.suelo.contenido[pIndice].enSolucion = this.suelo.contenido[pIndice].enSolucion - cantidadPrecipitacion;
		this.suelo.contenido[pIndice].precipitado = this.suelo.contenido[pIndice].precipitado + cantidadPrecipitacion;
	}
	
	public void paso() {
		int i;
		for (i=0; i<nutrientes.length; i++) {
			this.absorcion(i);
			this.precipitacion(i);
		}
	}
	
}


