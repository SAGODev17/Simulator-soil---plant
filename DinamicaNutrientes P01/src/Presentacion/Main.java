package Presentacion;
import Datos.Datos;
import Reglas.Nutriente;

public class Main {

	public static void main(String[] args) {
		Presentacion presentacion;
		Datos datos;
		Nutriente nutriente = new Nutriente();
		presentacion = new Presentacion();
		datos = new Datos();
		nutriente = presentacion.capturarNutrienteInicioSimulacion();
		datos.grabarEncabezadoSimulacion();
		presentacion.presentarNutriente(nutriente);
		presentacion.presentarPasoSimulacion(nutriente);
		datos.grabarPasoSimulacion(nutriente);
		while (nutriente.enSolucion()) {
			nutriente.paso();
			presentacion.presentarPasoSimulacion(nutriente);
			datos.grabarPasoSimulacion(nutriente);
			
		}
	
	}

}
