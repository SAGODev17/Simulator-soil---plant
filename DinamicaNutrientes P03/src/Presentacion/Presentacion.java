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
	
	public int capturarCantidadNutrientes() {
		int rCantidad;
		rCantidad = 0;
		this.seccionPrincipal = "Captura de datos de nutrientes";
		this.presentarEncabezado();
		rCantidad = this.capturarDatoEntero("Cantidad de nutrientes: ");
		this.presentarCierreSeccion();
		return rCantidad;
	}
	
	public Nutriente capturarNutriente() {
		Nutriente rNutriente;
		rNutriente = new Nutriente();
		this.seccionPrincipal = "Captura de datos de nutriente";
		this.presentarEncabezado();
		rNutriente.nombre = this.capturarDatoCadena("Nombre del nutriente: ");
		rNutriente.simbolo = this.capturarDatoCadena("Símbolo del nutriente: ");
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
	
	public Planta capturarPlanta(int pCantidadNutrientes) {
		Planta rPlanta;
		rPlanta = new Planta(pCantidadNutrientes);
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
	
	public Suelo capturarSuelo(int pCantidadNutrientes) {
		Suelo rSuelo;
		rSuelo = new Suelo(pCantidadNutrientes);
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
	
	public void presentarNutrientes(Sistema pSistema) {
		int i;
		this.seccionPrincipal = "Simulación";
		this.presentarEncabezado();
		for (i=0; i<pSistema.nutrientes.length; i++) {
			this.presentarLinea("NB - " + pSistema.planta.contenido[i].nutriente.nombre + " en biomasa [u]: " + pSistema.planta.contenido[i].enBiomasa);
			this.presentarLinea("NS - " + pSistema.planta.contenido[i].nutriente.nombre + " en solución [u]: " + pSistema.suelo.contenido[i].enSolucion);
			this.presentarLinea("NP - " + pSistema.planta.contenido[i].nutriente.nombre + " precipitado [u]: " + pSistema.suelo.contenido[i].precipitado);
			this.presentarLinea("VA - Velocidad de absorción [u/t]: " + pSistema.planta.parametros[i].velocidadAbsorcion);
			this.presentarLinea("VP - Velocidad de precipitación [u/t]: " + pSistema.suelo.parametros[i].velocidadPrecipitacion);
		}
		this.presentarLineaEnBlanco();
		this.presentarLineaDivisoria();
	}

	public void presentarPasoSimulacion(Sistema pSistema) {
		int i;
		for (i=0; i<pSistema.nutrientes.length; i++) {
			this.presentarLinea(
					pSistema.planta.contenido[i].nutriente.simbolo + "NB= " + pSistema.planta.contenido[i].enBiomasa + "  -  " +
					pSistema.suelo.contenido[i].nutriente.simbolo + "NS= " + pSistema.suelo.contenido[i].enSolucion + "  -  " +
					pSistema.suelo.contenido[i].nutriente.simbolo + "NP= " + pSistema.suelo.contenido[i].precipitado);
		}
	}

}
