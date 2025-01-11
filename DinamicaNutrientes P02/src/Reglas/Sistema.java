package Reglas;
public class Sistema {
	public Planta planta;
	public Suelo suelo;
	
	public Sistema(Planta pPlanta, Suelo pSuelo) {
		this.planta = pPlanta;
		this.suelo = pSuelo;
	}
	
	public float cantidadAbsorcion() {
		float rCantidadAbsorcion;
		rCantidadAbsorcion = Math.min(this.suelo.contenido.enSolucion, this.planta.parametro.velocidadAbsorcion);
		return rCantidadAbsorcion;
	}

	public float cantidadPrecipitacion() {
		float rCantidadPrecipitacion;
		rCantidadPrecipitacion = Math.min(this.suelo.contenido.enSolucion, this.suelo.parametro.velocidadPrecipitacion);
		return rCantidadPrecipitacion;
	}
	
	public void absorcion() {
		float cantidadAbsorcion;
		cantidadAbsorcion = this.cantidadAbsorcion();
		this.suelo.contenido.enSolucion = this.suelo.contenido.enSolucion - cantidadAbsorcion;
		this.planta.contenido.enBiomasa = this.planta.contenido.enBiomasa + cantidadAbsorcion;
	}
	
	public void precipitacion() {
		float cantidadPrecipitacion;
		cantidadPrecipitacion = this.cantidadPrecipitacion();
		this.suelo.contenido.enSolucion = this.suelo.contenido.enSolucion - cantidadPrecipitacion;
		this.suelo.contenido.precipitado = this.suelo.contenido.precipitado + cantidadPrecipitacion;
	}
	
	public void paso() {
		this.absorcion();
		this.precipitacion();
	}
	
}





