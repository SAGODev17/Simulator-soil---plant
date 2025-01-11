package Presentacion;
import Reglas.Nutriente;

public class Presentacion extends Consola {
	public Presentacion() {
		this.nombreAplicacion = "SIMULADOR DE DINÁMICA DE NUTRIENTES";
	}
	
	public Nutriente capturarNutrienteInicioSimulacion() {
		Nutriente rNutriente;
		rNutriente = new Nutriente();
		this.seccionPrincipal = "Captura de datos de inicio de simulación";
		this.presentarEncabezado();
		rNutriente.enSolucion = this.capturarDatoFlotante("Cantidad de nutriente en solución [u]: ");
		rNutriente.velocidadAbsorcion = this.capturarDatoFlotante("Velocidad de absorción [u/t]: ");
		rNutriente.velocidadPrecipitacion = this.capturarDatoFlotante("Velocidad de precipitación [u/t]: ");
		this.presentarCierreSeccion();
		return rNutriente;
	}
	
	public void presentarNutriente(Nutriente pNutriente) {
		this.seccionPrincipal = "Simulación";
		this.presentarEncabezado();
		this.presentarLinea("NB - Nutriente en biomasa [u]: " + pNutriente.enBiomasa);
		this.presentarLinea("NS - Nutriente en solución [u]: " + pNutriente.enSolucion);
		this.presentarLinea("NP - Nutriente precipitado [u]: " + pNutriente.precipitado);
		this.presentarLinea("VA - Velocidad de absorción [u/t]: " + pNutriente.velocidadAbsorcion);
		this.presentarLinea("VP - Velocidad de precipitación [u/t]: " + pNutriente.velocidadPrecipitacion);
		this.presentarLineaEnBlanco();
		this.presentarLineaDivisoria();
	}

	public void presentarPasoSimulacion(Nutriente pNutriente) {
		this.presentarLinea(
				"NB= " + pNutriente.enBiomasa + "  -  " +
				"NS= " + pNutriente.enSolucion + "  -  " +
 				"NP= " + pNutriente.precipitado);
	}
}
