package Presentacion;
import Datos.Datos;
import Reglas.ContenidoNP;
import Reglas.ContenidoNS;
import Reglas.Nutriente;
import Reglas.Planta;
import Reglas.Sistema;
import Reglas.Suelo;

public class Main {

	public static void main(String[] args) {
		Presentacion presentacion;
		Datos datos;
		Nutriente[] nutrientes;
		Planta planta;
		Suelo suelo;
		Sistema sistema;
		int cantidadNutrientes, i;
		presentacion = new Presentacion();
		datos = new Datos();
		cantidadNutrientes = presentacion.capturarCantidadNutrientes();
		nutrientes = new Nutriente[cantidadNutrientes];
		for (i=0; i<cantidadNutrientes; i++) {
			nutrientes[i] = presentacion.capturarNutriente(); 
		}
		planta = presentacion.capturarPlanta(cantidadNutrientes);
		suelo = presentacion.capturarSuelo(cantidadNutrientes);
		for (i=0; i<cantidadNutrientes; i++) {
			planta.parametros[i] = presentacion.capturarParametroNP(nutrientes[i], planta);
			planta.contenido[i] = new ContenidoNP(nutrientes[i], planta);
			suelo.parametros[i] = presentacion.capturarParametroNS(nutrientes[i], suelo);
			suelo.contenido[i] = new ContenidoNS(nutrientes[i], suelo);
		}
		for (i=0; i<cantidadNutrientes; i++) {
			presentacion.capturarNutrienteInicioSimulacion(suelo.contenido[i]);
		}
		sistema = new Sistema(planta,suelo,nutrientes);
		datos.grabarEncabezadoSimulacion(sistema);
		presentacion.presentarNutrientes(sistema);
		presentacion.presentarPasoSimulacion(sistema);
		datos.grabarPasoSimulacion(sistema);
		while (suelo.contenido[0].enSolucion()) {
			sistema.paso();
			presentacion.presentarPasoSimulacion(sistema);
			datos.grabarPasoSimulacion(sistema);
		}
	}

}




