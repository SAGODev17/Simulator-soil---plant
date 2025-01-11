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
		Nutriente nutriente;
		Planta planta;
		Suelo suelo;
		Sistema sistema;
		presentacion = new Presentacion();
		datos = new Datos();
		nutriente = presentacion.capturarNutriente();
		planta = presentacion.capturarPlanta();
		suelo = presentacion.capturarSuelo();
		planta.parametro = presentacion.capturarParametroNP(nutriente, planta);
		planta.contenido = new ContenidoNP(nutriente, planta);
		suelo.parametro = presentacion.capturarParametroNS(nutriente, suelo);
		suelo.contenido = new ContenidoNS(nutriente, suelo);
		presentacion.capturarNutrienteInicioSimulacion(suelo.contenido);
		sistema = new Sistema(planta,suelo);
		datos.grabarEncabezadoSimulacion();
		presentacion.presentarNutriente(sistema);
		presentacion.presentarPasoSimulacion(sistema);
		datos.grabarPasoSimulacion(sistema);
		while (suelo.contenido.enSolucion()) {
			sistema.paso();
			presentacion.presentarPasoSimulacion(sistema);
			datos.grabarPasoSimulacion(sistema);
		}
	}

}
