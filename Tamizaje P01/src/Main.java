public class Main {

	public static void main(String[] args) {
		Paciente paciente;
		Presentacion presentacion;
		
		presentacion = new Presentacion();
		paciente = presentacion.capturarPaciente();
		presentacion.presentarPaciente(paciente);
	}
	
}