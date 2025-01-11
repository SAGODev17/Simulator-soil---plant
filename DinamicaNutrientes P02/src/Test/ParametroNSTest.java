package Test;
import Reglas.ParametroNS;
import Reglas.Nutriente;
import Reglas.Suelo;
import org.junit.Test;
import static org.junit.Assert.*;

public class ParametroNSTest {

    @Test
    public void testConstructor() {
        Nutriente nutriente = new Nutriente();
        Suelo suelo = new Suelo();
        ParametroNS parametro = new ParametroNS(nutriente, suelo);
        assertEquals(nutriente, parametro.nutriente);
        assertEquals(suelo, parametro.suelo);
        assertEquals(0, parametro.velocidadPrecipitacion, 0.01); // Usamos 0.01 de margen para valores flotantes
    }

    @Test
    public void testSetVelocidadPrecipitacion() {
        Nutriente nutriente = new Nutriente();
        Suelo suelo = new Suelo();
        ParametroNS parametro = new ParametroNS(nutriente, suelo);
        parametro.velocidadPrecipitacion = 2; // Asignamos un valor
        assertEquals(2, parametro.velocidadPrecipitacion, 0.01);
    }
}