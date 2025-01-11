public class Paciente {
	public float masa;
	public float estatura;
	
	public Paciente() {
		this.masa = 0;
		this.estatura = 0;

	}
	
	public float calcularIndiceMasaCorporal() {
		float rIndiceMasaCorporal;
		rIndiceMasaCorporal = this.masa / (this.estatura * this.estatura);
		return rIndiceMasaCorporal;
	}

}