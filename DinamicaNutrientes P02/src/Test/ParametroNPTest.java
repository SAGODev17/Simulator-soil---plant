package Test;

import Reglas.ParametroNP;
import Reglas.Nutriente;
import Reglas.Planta;
import org.junit.Test;
import static org.junit.Assert.*;

public class ParametroNPTest {

    @Test
    public void testConstructor() {
        Nutriente nutriente = new Nutriente();
        Planta planta = new Planta();
        ParametroNP parametro = new ParametroNP(nutriente, planta);
        assertEquals(nutriente, parametro.nutriente);
        assertEquals(planta, parametro.planta);
        assertEquals(0, parametro.velocidadAbsorcion, 0.01); // Usamos 0.01 de margen para valores flotantes
    }

    @Test
    public void testSetVelocidadAbsorcion() {
        Nutriente nutriente = new Nutriente();
        Planta planta = new Planta();
        ParametroNP parametro = new ParametroNP(nutriente, planta);
        parametro.velocidadAbsorcion = 2; // Asignamos un valor
        assertEquals(2, parametro.velocidadAbsorcion, 0.01);
    }
}