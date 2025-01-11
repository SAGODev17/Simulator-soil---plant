package Reglas;

public class Nutriente {
	public float enBiomasa;
	public float enSolucion;
	public float precipitado;
	public float velocidadAbsorcion;
	public float velocidadPrecipitacion;
	
	public Nutriente() {
		this.enBiomasa = 0;
		this.enSolucion = 0;
		this.precipitado = 0;
		this.velocidadAbsorcion = 0;
		this.velocidadPrecipitacion = 0;
	}
	
	public float cantidadAbsorcion() {
		float rCantidadAbsorcion;
		rCantidadAbsorcion = Math.min(this.enSolucion, this.velocidadAbsorcion);
		return rCantidadAbsorcion;
	}
	
	public float cantidadPrecipitacion() {
		float rCantidadPrecipitacion;
		rCantidadPrecipitacion = Math.min(this.enSolucion, this.velocidadPrecipitacion);
		return rCantidadPrecipitacion;
	}
	
	public void absorcion() {
		float cantidadAbsorcion;
		cantidadAbsorcion = this.cantidadAbsorcion();
		this.enSolucion = this.enSolucion - cantidadAbsorcion;
		this.enBiomasa = this.enBiomasa + cantidadAbsorcion;
	}
	
	public void precipitacion() {
		float cantidadPrecipitacion;
		cantidadPrecipitacion = this.cantidadPrecipitacion();
		this.enSolucion = this.enSolucion - cantidadPrecipitacion;
		this.precipitado = this.precipitado + cantidadPrecipitacion;
			
	}
	
	public void paso() {
		this.absorcion();
		this.precipitacion();
	}
	
	public boolean enSolucion() {
		return (this.enSolucion > 0);
	}
	
}

