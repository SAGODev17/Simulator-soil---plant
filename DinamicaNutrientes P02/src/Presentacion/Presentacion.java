package Presentacion;
import Reglas.ContenidoNS;
import Reglas.Nutriente;
import Reglas.ParametroNP;
import Reglas.ParametroNS;
import Reglas.Planta;
import Reglas.Sistema;
import Reglas.Suelo;

public class Presentacion extends Consola {
	public Presentacion() {
		this.nombreAplicacion = "SIMULADOR DE DINÁMICA DE NUTRIENTES";
	}
	
	public Nutriente capturarNutriente() {
		Nutriente rNutriente;
		rNutriente = new Nutriente();
		this.seccionPrincipal = "Captura de datos de nutriente";
		this.presentarEncabezado();
		rNutriente.nombre = this.capturarDatoCadena("Nombre del nutriente: ");
		this.presentarCierreSeccion();
		return rNutriente;
	}
	
	public Planta capturarPlanta() {
		Planta rPlanta;
		rPlanta = new Planta();
		this.seccionPrincipal = "Captura de datos de planta";
		this.presentarEncabezado();
		rPlanta.nombre = this.capturarDatoCadena("Nombre de la planta: ");
		this.presentarCierreSeccion();
		return rPlanta;
	}
	
	public Suelo capturarSuelo() {
		Suelo rSuelo;
		rSuelo = new Suelo();
		this.seccionPrincipal = "Captura de datos de suelo";
		this.presentarEncabezado();
		rSuelo.nombre = this.capturarDatoCadena("Nombre del suelo: ");
		this.presentarCierreSeccion();
		return rSuelo;
	}
	
	public ParametroNP capturarParametroNP(Nutriente pNutriente, Planta pPlanta) {
		ParametroNP rParametroNP;
		rParametroNP = new ParametroNP(pNutriente, pPlanta);
		rParametroNP.nutriente = pNutriente;
		rParametroNP.planta = pPlanta;
		this.seccionPrincipal = "Captura de parámetros Nutriente-Planta";
		this.presentarEncabezado();
		rParametroNP.velocidadAbsorcion = this.capturarDatoFlotante("Velocidad de absorción " + rParametroNP.nutriente.nombre + " - " + rParametroNP.planta.nombre + " [u/t]: ");
		this.presentarCierreSeccion();
		return rParametroNP;
	}
	
	public ParametroNS capturarParametroNS(Nutriente pNutriente, Suelo pSuelo) {
		ParametroNS rParametroNS;
		rParametroNS = new ParametroNS(pNutriente, pSuelo);
		rParametroNS.nutriente = pNutriente;
		rParametroNS.suelo = pSuelo;
		this.seccionPrincipal = "Captura de parámetros Nutriente-Suelo";
		this.presentarEncabezado();
		rParametroNS.velocidadPrecipitacion = this.capturarDatoFlotante("Velocidad de precipitación " + rParametroNS.nutriente.nombre + " - " + rParametroNS.suelo.nombre + " [u/t]: ");
		this.presentarCierreSeccion();
		return rParametroNS;
	}
	
	public void capturarNutrienteInicioSimulacion(ContenidoNS pContenidoNS) {
		this.seccionPrincipal = "Captura de datos de inicio de simulación";
		this.presentarEncabezado();
		pContenidoNS.enSolucion = this.capturarDatoFlotante("Cantidad de " + pContenidoNS.nutriente.nombre + " en solución [u]: ");
		this.presentarCierreSeccion();
	}
	
	public void presentarNutriente(Sistema pSistema) {
		this.seccionPrincipal = "Simulación";
		this.presentarEncabezado();
		this.presentarLinea("NB - " + pSistema.planta.contenido.nutriente.nombre + " en biomasa [u]: " + pSistema.planta.contenido.enBiomasa);
		this.presentarLinea("NS - " + pSistema.planta.contenido.nutriente.nombre + " en solución [u]: " + pSistema.suelo.contenido.enSolucion);
		this.presentarLinea("NP - " + pSistema.planta.contenido.nutriente.nombre + " precipitado [u]: " + pSistema.suelo.contenido.precipitado);
		this.presentarLinea("VA - Velocidad de absorción [u/t]: " + pSistema.planta.parametro.velocidadAbsorcion);
		this.presentarLinea("VP - Velocidad de precipitación [u/t]: " + pSistema.suelo.parametro.velocidadPrecipitacion);
		this.presentarLineaEnBlanco();
		this.presentarLineaDivisoria();
	}

	public void presentarPasoSimulacion(Sistema pSistema) {
		this.presentarLinea(
				"NB= " + pSistema.planta.contenido.enBiomasa + "  -  " +
				"NS= " + pSistema.suelo.contenido.enSolucion + "  -  " +
 				"NP= " + pSistema.suelo.contenido.precipitado);
	}

}



