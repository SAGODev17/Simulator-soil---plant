import java.util.Scanner;

public class Presentacion {
	public Presentacion() {
		
	}
	
	public Paciente capturarPaciente() {
		Scanner scanner = new Scanner(System.in);
		Paciente rPaciente;
		rPaciente = new Paciente();
		System.out.println("*********** Captura de datos ***********");
		System.out.println("");
		System.out.print("Identificación: ");
		rPaciente.identificacion = scanner.nextLine();
		System.out.print("Nombre: ");
		rPaciente.nombre = scanner.nextLine();
		System.out.print("Masa [Kg]: ");
		rPaciente.masa = scanner.nextFloat();
		System.out.print("Estatura [m]: ");
		rPaciente.estatura = scanner.nextFloat();
		System.out.println("");
		System.out.println("****************************************");
		System.out.println("");
		scanner.close();
		return rPaciente;
	}
	
	public void presentarPaciente(Paciente pPaciente) {
		System.out.println("********* Presentación de datos ********");
		System.out.println("");
		System.out.println("Identificación: " + pPaciente.identificacion);
		System.out.println("Paciente: " + pPaciente.nombre);
		System.out.println("Masa [Kg]: " + pPaciente.masa);
		System.out.println("Estatura [m]: " + pPaciente.estatura);
		System.out.println("Indice de masa corporal: " + pPaciente.calcularIndiceMasaCorporal());
		System.out.println("Masa máxima normal: " + pPaciente.calcularMasaMaximaNormal());
		System.out.println("");
		System.out.println("****************************************");
		System.out.println("");
	}

}