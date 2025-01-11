import Presentacion.*;

public class Presentacion extends Consola {
	public Presentacion() {
		this.nombreAplicacion = "TAMIZAJE EN SALUD";
		this.seccionSecundaria = "";
	}
	
	public Paciente capturarPaciente() {
		Paciente rPaciente;
		rPaciente = new Paciente();
		this.seccionPrincipal = "Captura de datos";
		this.presentarEncabezado();
		rPaciente.identificacion = this.capturarDatoCadena("Identificación: ");
		rPaciente.nombre = this.capturarDatoCadena("Paciente: ");
		rPaciente.masa = this.capturarDatoFlotante("Masa [Kg]: ");
		rPaciente.estatura = this.capturarDatoFlotante("Estatura [m]: ");
		this.presentarCierreSeccion();
		return rPaciente;
	}
	
	public void presentarPaciente(Paciente pPaciente) {
		this.seccionPrincipal = "Presentación de datos";
		this.presentarEncabezado();
		this.presentarLinea("Identificación: " + pPaciente.identificacion);
		this.presentarLinea("Paciente: " + pPaciente.nombre);
		this.presentarLinea("Masa [Kg]: " + pPaciente.masa);
		this.presentarLinea("Estatura [m]: " + pPaciente.estatura);
		this.presentarLineaEnBlanco();
		this.presentarLinea("Indice de masa corporal: " + pPaciente.calcularIndiceMasaCorporal());
		this.presentarLinea("Masa máxima normal: " + pPaciente.calcularMasaMaximaNormal());
		this.presentarPausa();
		this.presentarCierreSeccion();
	}

}