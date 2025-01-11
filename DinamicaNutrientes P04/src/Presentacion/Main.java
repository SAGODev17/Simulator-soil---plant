package Presentacion;
import Datos.Datos;
import Reglas.ContenidoNP;
import Reglas.ContenidoNS;
import Reglas.Nutriente;
import Reglas.Planta;
import Reglas.RelacionNNP;
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
		int cantidadNutrientes, i, j;
		
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
		for (i=0; i<(cantidadNutrientes-1); i++) {
			for (j=i+1; j<cantidadNutrientes; j++) {
				planta.relaciones[i][j] = presentacion.capturarRelacionNNP(nutrientes[i], nutrientes[j], planta);
				planta.relaciones[j][i] = new RelacionNNP(nutrientes[j], nutrientes[i], planta);
				planta.relaciones[j][i].numeradorOptimo = planta.relaciones[i][j].numeradorOptimo; 
				planta.relaciones[j][i].denominadorOptimo = planta.relaciones[i][j].denominadorOptimo; 
			}
		}
		for (i=0; i<cantidadNutrientes; i++) {
			presentacion.capturarNutrienteInicioSimulacion(suelo.contenido[i]);
		}
		sistema = new Sistema(planta,suelo,nutrientes);
		datos.grabarEncabezadoSimulacion(sistema);
		presentacion.presentarNutrientes(sistema);
		presentacion.presentarPasoSimulacion(sistema);
		datos.grabarPasoSimulacion(sistema);
		while (suelo.enSolucion()) {
			sistema.paso();
			presentacion.presentarPasoSimulacion(sistema);
			datos.grabarPasoSimulacion(sistema);
		}
	}

}
