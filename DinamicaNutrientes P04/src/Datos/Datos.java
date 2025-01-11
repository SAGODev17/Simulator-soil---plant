package Datos;
import Reglas.Sistema;

public class Datos extends ArchivoCsv {
	public String archivoSimulacion;
	
	public Datos() {
		this.archivoSimulacion = "simulacion";
	}
	
	public RegistroCsv construirRegistroEncabezadoSimulacion(Sistema pSistema) {
		RegistroCsv rRegistroEncabezado;
		int i;
		rRegistroEncabezado = new RegistroCsv();
		for (i=0; i<pSistema.nutrientes.length; i++) {
			rRegistroEncabezado.agregarValor(pSistema.nutrientes[i].simbolo + "Solucion");
			rRegistroEncabezado.agregarValor(pSistema.nutrientes[i].simbolo + "Absorcion");
			rRegistroEncabezado.agregarValor(pSistema.nutrientes[i].simbolo + "Biomasa");
			rRegistroEncabezado.agregarValor(pSistema.nutrientes[i].simbolo + "Precipitacion");
			rRegistroEncabezado.agregarValor(pSistema.nutrientes[i].simbolo + "Precipitado");
		}
		return rRegistroEncabezado;
	}
	
	public void grabarEncabezadoSimulacion(Sistema pSistema) {
		RegistroCsv tRegistroEncabezado;
		tRegistroEncabezado = this.construirRegistroEncabezadoSimulacion(pSistema);
		this.grabarRegistro(this.archivoSimulacion, tRegistroEncabezado);
	}

	public RegistroCsv construirRegistroPasoSimulacion(Sistema pSistema) {
		RegistroCsv rRegistroNutrientes;
		int i;
		rRegistroNutrientes = new RegistroCsv();
		for (i=0; i<pSistema.nutrientes.length; i++) {
			rRegistroNutrientes.agregarValor((float)pSistema.suelo.contenido[i].enSolucion);
			rRegistroNutrientes.agregarValor((float)pSistema.planta.contenido[i].absorcion);
			rRegistroNutrientes.agregarValor((float)pSistema.planta.contenido[i].enBiomasa);
			rRegistroNutrientes.agregarValor((float)pSistema.suelo.contenido[i].precipitacion);
			rRegistroNutrientes.agregarValor((float)pSistema.suelo.contenido[i].precipitado);
		}
		return rRegistroNutrientes;
	}
	
	public void grabarPasoSimulacion(Sistema pSistema) {
		RegistroCsv tRegistroNutrientes;
		tRegistroNutrientes = this.construirRegistroPasoSimulacion(pSistema);
		this.grabarRegistro(this.archivoSimulacion, tRegistroNutrientes);
	}
	
}
