package Datos;
import Reglas.Nutriente;

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

	public RegistroCsv construirRegistroPasoSimulacion(Nutriente pNutriente) {
		RegistroCsv rRegistroNutriente;
		rRegistroNutriente = new RegistroCsv();
		rRegistroNutriente.agregarValor((float)pNutriente.enBiomasa);
		rRegistroNutriente.agregarValor((float)pNutriente.enSolucion);
		rRegistroNutriente.agregarValor((float)pNutriente.precipitado);
		return rRegistroNutriente;
	}
	
	public void grabarPasoSimulacion(Nutriente pNutriente) {
		RegistroCsv tRegistroNutriente;
		tRegistroNutriente = this.construirRegistroPasoSimulacion(pNutriente);
		this.grabarRegistro(this.archivoSimulacion, tRegistroNutriente);
	}
	
}
