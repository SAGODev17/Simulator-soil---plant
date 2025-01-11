public class Paciente {
	public String identificacion;
	public String nombre;
	public float masa;
	public float estatura;
	
	public Paciente() {
		this.identificacion = "";
		this.nombre = "";
		this.masa = 0;
		this.estatura = 0;
	}
	
	public float calcularIndiceMasaCorporal() {
		float rIndiceMasaCorporal;
		rIndiceMasaCorporal = this.masa / (this.estatura * this.estatura);
		return rIndiceMasaCorporal;
	}
	
	public float calcularMasaMaximaNormal() {
		float rMasaMaximaNormal;
		rMasaMaximaNormal = 25 * this.estatura * this.estatura;
		return rMasaMaximaNormal;
	}

}