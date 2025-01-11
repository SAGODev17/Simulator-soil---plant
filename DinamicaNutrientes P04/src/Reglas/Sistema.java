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
		float tMultiplicador;
		float tRelacion;
		float tContenido1, tContenido2, tNumeradorOptimo, tDenominadorOptimo, tRelacionOptima, tDiferencia, tLimite;
		int i;
		tMultiplicador = 1;
		for (i=0; i<suelo.contenido.length; i++) {
			if (i != pIndice) {
				tContenido1 = this.suelo.contenido[i].enSolucion; 
				tContenido2 = this.suelo.contenido[pIndice].enSolucion; 
				if (i > pIndice) {
					tContenido1 = this.suelo.contenido[pIndice].enSolucion; 
					tContenido2 = this.suelo.contenido[i].enSolucion; 
				}
				tNumeradorOptimo = this.planta.relaciones[pIndice][i].numeradorOptimo;
				tDenominadorOptimo = this.planta.relaciones[pIndice][i].denominadorOptimo;
				tRelacionOptima = tNumeradorOptimo / tDenominadorOptimo;
				tRelacion = tContenido1 / tContenido2;
				tDiferencia = Math.abs(tRelacion - tRelacionOptima);
				tLimite = 1 - (tDiferencia / tRelacionOptima);
				tLimite = Math.max(tLimite, 0);
				tMultiplicador = Math.min(tMultiplicador, tLimite);
			}
		}
		rCantidadAbsorcion = Math.min(this.suelo.contenido[pIndice].enSolucion, this.planta.parametros[pIndice].velocidadAbsorcion * tMultiplicador);
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
		this.planta.contenido[pIndice].absorcion = cantidadAbsorcion;
		this.planta.contenido[pIndice].enBiomasa = this.planta.contenido[pIndice].enBiomasa + cantidadAbsorcion;
	}
	
	public void precipitacion(int pIndice) {
		float cantidadPrecipitacion;
		cantidadPrecipitacion = this.cantidadPrecipitacion(pIndice);
		this.suelo.contenido[pIndice].precipitacion = cantidadPrecipitacion;
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
