package Datos;
import Reglas.Sistema;

public class Datos extends ArchivoCsv {
	public String archivoSimulacion;
	
	public Datos() {
		this.archivoSimulacion = "simulacion";
	}
	
	public RegistroCsv construirRegistroEncabezadoSimulacion() {
		RegistroCsv rRegistroEncabezado;
		rRegistroEncabezado = new RegistroCsv();
		rRegistroEncabezado.agregarValor("Biomasa");
		rRegistroEncabezado.agregarValor("Solucion");
		rRegistroEncabezado.agregarValor("Precipitado");
		return rRegistroEncabezado;
	}
	
	public void grabarEncabezadoSimulacion() {
		RegistroCsv tRegistroEncabezado;
		tRegistroEncabezado = this.construirRegistroEncabezadoSimulacion();
		this.grabarRegistro(this.archivoSimulacion, tRegistroEncabezado);
	}

	public RegistroCsv construirRegistroPasoSimulacion(Sistema pSistema) {
		RegistroCsv rRegistroNutriente;
		rRegistroNutriente = new RegistroCsv();
		rRegistroNutriente.agregarValor((float)pSistema.planta.contenido.enBiomasa);
		rRegistroNutriente.agregarValor((float)pSistema.suelo.contenido.enSolucion);
		rRegistroNutriente.agregarValor((float)pSistema.suelo.contenido.precipitado);
		return rRegistroNutriente;
	}
	
	public void grabarPasoSimulacion(Sistema pSistema) {
		RegistroCsv tRegistroNutriente;
		tRegistroNutriente = this.construirRegistroPasoSimulacion(pSistema);
		this.grabarRegistro(this.archivoSimulacion, tRegistroNutriente);
	}
	
}




