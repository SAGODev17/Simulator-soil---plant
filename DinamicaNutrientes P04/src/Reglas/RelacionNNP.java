package Reglas;

public class RelacionNNP {
		public Nutriente nutriente1;
		public Nutriente nutriente2;
		public Planta planta;
		public float numeradorOptimo;
		public float denominadorOptimo;
		
		public RelacionNNP(Nutriente pNutriente1, Nutriente pNutriente2, Planta pPlanta) {
			this.nutriente1 = pNutriente1;
			this.nutriente2 = pNutriente2;
			this.planta = pPlanta;
			this.numeradorOptimo = 0;
			this.denominadorOptimo = 1;
		}
		
	}
